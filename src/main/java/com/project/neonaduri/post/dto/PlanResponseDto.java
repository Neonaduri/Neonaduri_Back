package com.project.neonaduri.post.dto;

import com.project.neonaduri.login.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlanResponseDto {

    private Long postId;
    private String postImgUrl;
    private String postTitle;
    private String startDate;
    private String endDate;
    private String location;
    private String theme;
    private boolean islike;
    private int likeCnt;
    private int reviewCnt;
    private User user;

}
