package com.basic2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class MemoCreateResponse {

    private final long id;
    private final String text;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemoCreateResponse(long id, String text, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
