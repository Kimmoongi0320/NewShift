package Shift.ShiftBack.domain.user.repository;

import Shift.ShiftBack.domain.user.schema.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
