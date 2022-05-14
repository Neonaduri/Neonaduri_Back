package com.project.neonaduri.controller;

/**
 * [controller] - userController
 *
 * @class   : userController
 * @author  : 오예령
 * @since   : 2022.04.30
 * @version : 1.0
 *
 *   수정일     수정자             수정내용
 *  --------   --------    ---------------------------
 *  2022.05.03 오예령       아이디 중복검사 및 로그인 정보 조회 기능 추가
 *  2022.05.07 오예령       아이디 중복검사 로직 변경
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.neonaduri.dto.user.DuplicateCheckDto;
import com.project.neonaduri.dto.user.IsLoginDto;
import com.project.neonaduri.dto.user.SignupRequestDto;
import com.project.neonaduri.dto.user.SocialLoginInfoDto;
import com.project.neonaduri.security.UserDetailsImpl;
import com.project.neonaduri.service.GoogleLoginService;
import com.project.neonaduri.service.KakaoUserService;
import com.project.neonaduri.service.UserService;
import com.project.neonaduri.utils.StatusEnum;
import com.project.neonaduri.utils.StatusMessage;
import com.project.neonaduri.validator.UserInfoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final KakaoUserService kakaoUserService;
    private final GoogleLoginService googleLoginService;
    private final UserService userService;
    private final UserInfoValidator userInfoValidator;

    // 회원가입
    @PostMapping("/user/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignupRequestDto signupRequestDto, Errors errors) {
        String message = userService.registerUser(signupRequestDto, errors);
        if (message.equals("회원가입 성공")) {
            return ResponseEntity.status(201)
                    .body(message);
        } else {
            return ResponseEntity.status(400)
                    .body(message);
        }
    }

    // 카카오 로그인
    @GetMapping("/user/kakao/callback")
    public SocialLoginInfoDto kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return kakaoUserService.kakaoLogin(code, response);
    }

    // 구글 로그인
    @GetMapping("/user/google/callback")
    public void googleLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        googleLoginService.googleLogin(code, response);
    }

     // 아이디 중복검사
    @PostMapping("/api/idcheck")
    public ResponseEntity<String> idcheck(@RequestBody DuplicateCheckDto duplicateCheckDto) {
        if (!userInfoValidator.idDuplichk(duplicateCheckDto.getUserName())) {
             return ResponseEntity.status(201)
                     .body("201");
        } else {
            return ResponseEntity.status(400)
                    .body("400");
        }
    }

    // 유저 정보 확인
    @GetMapping("/api/islogin")
    private ResponseEntity<IsLoginDto> isloginChk(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        userInfoValidator.isloginCheck(userDetails);
        return new ResponseEntity<>(userInfoValidator.isloginCheck(userDetails), HttpStatus.OK);
    }

    // 회원정보 수정
    @PutMapping("/api/user/mypage")
    public ResponseEntity<StatusMessage> updateUserInfo(@RequestParam("profileImgFile") MultipartFile multipartFile,
                                                        @RequestParam String profileImgUrl,
                                                        @RequestParam("nickName") String nickName,
                                                        @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {

        Long userId = userDetails.getUser().getId();
        //파일이 비었다는 것은 사용자가 이미지를 삭제했다거나 , 사진 수정하지 않았다는 것
        if (multipartFile.isEmpty()){
            userService.deleteProfileImg(profileImgUrl,nickName,userId);
        } else {
            //사용자가 이미지를 수정함
            userService.updateUserInfo(multipartFile, nickName, userId);
        }

        StatusMessage message= new StatusMessage();

        message.setStatus(StatusEnum.CREATED);
        return new ResponseEntity<StatusMessage>(message,HttpStatus.CREATED);
    }

}