package playwithjava.in.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class ErrorBean {
    int code;
    String errorMessage;
    String recommendedAction;
}
