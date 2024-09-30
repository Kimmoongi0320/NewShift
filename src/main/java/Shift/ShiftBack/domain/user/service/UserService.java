package Shift.ShiftBack.domain.user.service;

import Shift.ShiftBack.domain.login.dto.SessionProperty;
import Shift.ShiftBack.domain.testing.schema.EpaTest;
import Shift.ShiftBack.domain.user.repository.UserRepository;
import Shift.ShiftBack.domain.user.schema.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(SessionProperty property) {
        Optional<User> user = userRepository.findById(property.getId());
        if (user.isEmpty()) {
            User newUser = User.builder()
                    .ownerId(property.getId())
                    .name(property.getName())
                    .login_type(property.getLogin_type())
                    .email(property.getEmail())
                    .age_range(property.getAge_range())
                    .gender(property.getGender())
                    .phone_number(property.getPhone_number())
                    .tests(new ArrayList<String>())
                    .build();
            userRepository.save(newUser);
            return newUser;

        } else {
            return user.get();
        }
    }
}


