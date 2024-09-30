package Shift.ShiftBack.domain.testing.controller;

import Shift.ShiftBack.domain.login.service.LoginService;
import Shift.ShiftBack.domain.testing.dto.request.PostTestRequest;
import Shift.ShiftBack.domain.testing.dto.response.TidResponse;
import Shift.ShiftBack.domain.testing.dto.response.TotalReplyCountResponse;
import Shift.ShiftBack.domain.testing.schema.EpaTest;
import Shift.ShiftBack.domain.user.repository.UserRepository;
import Shift.ShiftBack.domain.user.schema.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserRepository userRepository;
    private final LoginService loginService;

    @PostMapping("/save_epa")
    public ResponseEntity<?> saveEpaTest(@RequestBody PostTestRequest dto) {
        //todo: 세션에 로그인 되어있는지 확인 절차
        String sessionId = dto.session_id();
        if (!loginService.verifyLogin(sessionId)) {
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("description", "not_logged_in");
            // 401 상태 코드와 함께 JSON 응답 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }

        //todo: 세션의 아이디로 유저정보 DB에 있는지 확인 있으면 User 객체 반환,없으면 새로운 User 객체 생성 후 DB에 저장
        User user = userRepository.findById(dto.owner_id()).orElse(null);
        EpaTest epaTest = EpaTest.builder()
                    .owner_platform(dto.owner_platform())
                    .owner_id(dto.owner_id())
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
