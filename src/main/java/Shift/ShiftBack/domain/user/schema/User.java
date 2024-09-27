package Shift.ShiftBack.domain.user.schema;

import Shift.ShiftBack.domain.testing.schema.EpaTest;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Data
@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String age_range;
    private String gender;
    private String phone_number;
    private List<EpaTest> tests;
}
