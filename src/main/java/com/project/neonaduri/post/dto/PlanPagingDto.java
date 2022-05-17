package com.project.neonaduri.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlanPagingDto {

    private List<PlanResponseDto> planList=new ArrayList<>();
    private int totalPage;
    private boolean islastPage;

    public PlanPagingDto(Page<PlanResponseDto> postDtoList, boolean islastPage) {

        this.planList= postDtoList.getContent();
        this.totalPage= postDtoList.getTotalPages();
        this.islastPage=islastPage;
    }
}
