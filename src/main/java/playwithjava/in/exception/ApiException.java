package playwithjava.in.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException{
    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.setCode(code);
    }
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
