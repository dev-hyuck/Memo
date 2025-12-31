package com.basic2.controller;

import com.basic2.dto.MemoCreateResponse;
import com.basic2.dto.MemoGetResponse;
import com.basic2.dto.MemoUpdateRequest;
import com.basic2.entity.Memo;
import com.basic2.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class MemoCotroller {

    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<MemoCreateResponse> create (
            @RequestBody MemoCreateResponse request

    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memoService.save(request));
    }

    @GetMapping ("/memos")
    public ResponseEntity<List<MemoGetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findAll());

    }

    @GetMapping("/memos/{memoId}")
    public ResponseEntity<MemoGetResponse> getOne(
            @PathVariable Long memoId,
            @RequestBody MemoUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memoService.update(memoId, request));
    }

    @GetMapping("/memos/{memoId}")
    public ResponseEntity<MemoGetResponse> getOne(
            @PathVariable Long memoId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findOne(memoId));
    }




}
