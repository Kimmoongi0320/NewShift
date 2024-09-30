package Shift.ShiftBack.domain.login.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionProperty {
    private String login_type;
    private Integer id;
    private String name;
    private String gender;
    private String age_range;
    private String phone_number;
    private String email;
}
