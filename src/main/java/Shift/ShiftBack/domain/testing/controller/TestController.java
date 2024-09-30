package Shift.ShiftBack.domain.testing.controller;

import Shift.ShiftBack.domain.login.dto.SessionProperty;
import Shift.ShiftBack.domain.login.service.LoginService;
import Shift.ShiftBack.domain.testing.dto.request.PostTestRequest;
import Shift.ShiftBack.domain.testing.dto.response.TidResponse;
import Shift.ShiftBack.domain.testing.dto.response.TotalReplyCountResponse;
import Shift.ShiftBack.domain.testing.repository.TestRepository;
import Shift.ShiftBack.domain.testing.schema.EpaTest;
import Shift.ShiftBack.domain.testing.service.TestService;
import Shift.ShiftBack.domain.user.repository.UserRepository;
import Shift.ShiftBack.domain.user.schema.User;
import Shift.ShiftBack.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserRepository userRepository;
    private final LoginService loginService;
    private final UserService userService;
    private final TestRepository testRepository;
    private final TestService testService;

    @PostMapping("/save_epa")
    public ResponseEntity<?> saveEpaTest(@RequestBody PostTestRequest dto) {
        String sessionId = dto.session_id();

        Optional<SessionProperty> sessionProperty = loginService.verifyLogin(sessionId);
        if (sessionProperty.isEmpty()) {
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("description", "not_logged_in");
            // 401 상태 코드와 함께 JSON 응답 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }

        //
        SessionProperty property = sessionProperty.get();

        User user = userService.createUser(property);

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

        String tid = testService.saveEpaTest(epaTest,user); // 저장소 저장 후 tid 반환

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
