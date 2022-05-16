package com.project.neonaduri.dto.post;

import com.project.neonaduri.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ThemeAndSearchDto {

    private Long postId;
    private String postImgUrl;
    private String postTitle;
    private String location;
    private String startDate;
    private String endDate;
    private boolean islike;
    private int likeCnt;
    private int reviewCnt;
    private String theme;
    private User user;
}
