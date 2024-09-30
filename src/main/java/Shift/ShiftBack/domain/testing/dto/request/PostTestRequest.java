package Shift.ShiftBack.domain.testing.dto.request;

import java.util.List;

public record PostTestRequest(
        String session_id,
        String owner_platform,
        Integer owner_id,
        String nickname,
        String gender,
        Integer age,
        Boolean notification_agree,
        List<String>keyword_want,
        List<String> keyword_others,
        List<String> keyword_myself
) {
}
