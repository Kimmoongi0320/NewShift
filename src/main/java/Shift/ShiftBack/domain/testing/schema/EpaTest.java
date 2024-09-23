package Shift.ShiftBack.domain.testing.schema;

import Shift.ShiftBack.domain.reply.schema.EpaReply;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EpaTest {
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
