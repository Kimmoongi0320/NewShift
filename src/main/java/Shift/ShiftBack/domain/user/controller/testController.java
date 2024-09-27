package Shift.ShiftBack.domain.user.controller;

import Shift.ShiftBack.domain.user.repository.UserRepository;
import Shift.ShiftBack.domain.user.schema.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userTestController")
@RequiredArgsConstructor
public class testController {

    private final UserRepository userRepository;
    @GetMapping("/test")
    public void test() {
        User user = User.builder()
                .name("test")
                .build();
        userRepository.save(user);
        System.out.println("test complete");
    }
}
