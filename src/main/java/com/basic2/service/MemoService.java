package com.basic2.service;

import com.basic2.dto.MemoCreateResponse;
import com.basic2.dto.MemoGetResponse;
import com.basic2.dto.MemoUpdateRequest;
import com.basic2.entity.Memo;
import com.basic2.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
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

    @Transactional(readOnly = true)
    public MemoGetResponse findOne(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 메모입니다.")
        );
        return new MemoGetResponse(
                memo.getId(),
                memo.getText(),
                memo.getCreatedAt(),
                memo.getModifiedAt()
        );
    }

    @Transactional
    public MemoGetResponse update(Long memoId, MemoUpdateRequest request) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 메모입니다.")
        );
        memo.update(request.getText());
        return new MemoGetResponse(
                memo.getId(),
                memo.getText(),
                memo.getCreatedAt(),
                memo.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long memoId) {
        boolean existence = memoRepository.existsById(memoId);
        // 존재하지 않으면
        if (!existence) {
            throw new IllegalStateException("없는 건데 왜 삭제하려고 하세요!!!");
        }
        // 존재하면
        memoRepository.deleteById(memoId);
    }
}
