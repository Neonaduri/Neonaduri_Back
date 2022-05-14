package com.project.neonaduri.dto.audio;

import lombok.Data;

@Data
public class AudioChatEntryDto {
    private Long postId;
    private String nickName;
    private AudioChatRole role;
    private Long participantCount;
}
