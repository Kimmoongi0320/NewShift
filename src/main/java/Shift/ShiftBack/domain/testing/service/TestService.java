package Shift.ShiftBack.domain.testing.service;

import Shift.ShiftBack.domain.testing.repository.TestRepository;
import Shift.ShiftBack.domain.testing.schema.EpaTest;
import Shift.ShiftBack.domain.user.repository.UserRepository;
import Shift.ShiftBack.domain.user.schema.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final UserRepository userRepository;
    private final TestRepository testRepository;

    public String saveEpaTest(EpaTest epaTest, User user) {
        EpaTest savedTest = testRepository.save(epaTest);
        user.getTests().add(savedTest.getId());
        userRepository.save(user);

        return savedTest.getId();
    }
}
