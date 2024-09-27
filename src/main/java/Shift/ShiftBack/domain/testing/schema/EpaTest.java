package Shift.ShiftBack.domain.testing.schema;

import Shift.ShiftBack.domain.reply.schema.EpaReply;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Data
@Document(collection = "epa_tests")
public class EpaTest {
    @Id
    private String id;
    private String owner_platform;
    private Integer owner_id;
    private String nickname;
    private String gender;
    private Integer age;
    private Boolean notification_agree;
    private List<String> keyword_want;
    private List<String> keyword_others;
    private List<String> keyword_myself;
    private List<EpaReply> replies;
}
