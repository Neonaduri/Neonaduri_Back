package com.project.neonaduri.like.controller;


import com.project.neonaduri.like.dto.LikeResponseDto;
import com.project.neonaduri.like.service.LikeService;
import com.project.neonaduri.login.model.User;
import com.project.neonaduri.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;

    //찜 여부 확인 (찜 상태 - true, 찜 안 한 상태 - false)
    @PostMapping("/plans/like/{postId}")
    public ResponseEntity<LikeResponseDto> isLike(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user=userDetails.getUser();
        return ResponseEntity.status(201).body(likeService.toggle(postId, user));
    }
}
