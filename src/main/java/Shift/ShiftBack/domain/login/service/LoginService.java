package Shift.ShiftBack.domain.login.service;

import Shift.ShiftBack.domain.login.dto.SessionProperty;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    public Optional<SessionProperty> verifyLogin(String session_id) {
        // 세션에서 유저 정보를 가져오는 로직 호출
//        SessionProperty sessionProperty = getSessionProperty(session_id);
        //TEST case
        SessionProperty sessionProperty = SessionProperty.builder()
                .login_type("email")
                .id(123)
                .name("John Doe")
                .gender("male")
                .age_range("25-34")
                .phone_number("123-456-7890")
                .email("johndoe@example.com")
                .build();

        // 세션 정보가 존재하면 Optional에 담아 반환, 없으면 Optional.empty() 반환
        if (sessionProperty != null) {
            return Optional.of(sessionProperty);
        } else {
            return Optional.empty();
        }
    }

    // 세션 서버에서 세션 속성(유저 정보 등)을 가져오는 메서드 (구현 필요)
    public SessionProperty getSessionProperty(String session_id) {
        // TODO: 세션 서버와 연결하여 유저 정보를 가져오는 로직을 구현
        return null;  // 실제 구현에서 null이 아닌 세션 속성을 반환해야 함
    }
}