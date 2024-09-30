package Shift.ShiftBack.domain.testing.repository;

import Shift.ShiftBack.domain.testing.schema.EpaTest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<EpaTest,String> {
}
