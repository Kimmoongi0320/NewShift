package Shift.ShiftBack.domain.reply.schema;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EpaReply {
    private Boolean anonymous = false;
    private String nickname = "unknown";
    private String gender = "unknown";
    private String relationship = "unknown";
    private String age_range = "unknown";
    private List<detail> keyword_detail;
    private String one_line_intro = "unknown";
    private String reply_time = "unknown";

}
