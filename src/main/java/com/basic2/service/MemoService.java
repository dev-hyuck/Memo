package com.basic2.service;

import com.basic2.dto.MemoCreateResponse;
import com.basic2.dto.MemoGetResponse;
import com.basic2.entity.Memo;
import com.basic2.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoCreateResponse save(MemoCreateResponse request) {
        Memo memo = new Memo(request.getText());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoCreateResponse(
               savedMemo.getId(),
               savedMemo.getText(),
               savedMemo.getCreatedAt(),
               savedMemo.getModifiedAt()

        );
    }

    @Transactional(readOnly = true)
    public List<MemoGetResponse> findAll() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoGetResponse> dtos = new ArrayList<>();
        for (Memo memo : memos) {
            MemoGetResponse dto = new MemoGetResponse(
                    memo.getId(),
                    memo.getText(),
                    memo.getCreatedAt(),
                    memo.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }




}
