package Shift.ShiftBack.domain.testing.controller;

import Shift.ShiftBack.domain.testing.dto.request.PostTestRequest;
import Shift.ShiftBack.domain.testing.dto.response.TidResponse;
import Shift.ShiftBack.domain.testing.dto.response.TotalReplyCountResponse;
import Shift.ShiftBack.domain.testing.schema.EpaTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @PostMapping("/save_epa")
    public ResponseEntity<TidResponse> saveEpaTest(@RequestBody PostTestRequest dto) {
        //todo: 세션에 로그인 되어있는지 확인 절차
        //todo: 세션의 아이디로 유저정보 DB에 있는지 확인 있으면 User 객체 반환,없으면 새로운 User 객체 생성 후 DB에 저장
        EpaTest epaTest = EpaTest.builder()
                    .owner_platform("test")
                    .owner_id(1)
                    .age(dto.age())
                    .nickname(dto.nickname())
                    .gender(dto.gender())
                    .keyword_myself(dto.keyword_myself())
                    .keyword_want(dto.keyword_want())
                    .keyword_others(dto.keyword_others())
                    .notification_agree(dto.notification_agree())
                .build();

        //todo: DB에 epatest 저장 
        String tid = "test"; // 저장소 저장 후 tid 반환

        TidResponse tidResponse = TidResponse.builder()
                .tid(tid)
                .build();

        return ResponseEntity.ok(tidResponse);
    }

    @GetMapping("/total_num")
     public ResponseEntity<TotalReplyCountResponse> getTotalReplyCount() {

        Integer totalCount = 0; //todo: DB에서 총 댓글 수 가져오기
        TotalReplyCountResponse totalReplyCountResponse = TotalReplyCountResponse.builder()
                .totalNum(totalCount)
                .build();
        return ResponseEntity.ok(totalReplyCountResponse);
    }


}
