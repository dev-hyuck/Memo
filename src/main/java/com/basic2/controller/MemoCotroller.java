package com.basic2.controller;

import com.basic2.dto.MemoCreateResponse;
import com.basic2.dto.MemoGetResponse;
import com.basic2.entity.Memo;
import com.basic2.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
