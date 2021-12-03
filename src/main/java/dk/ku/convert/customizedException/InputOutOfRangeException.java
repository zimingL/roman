package dk.ku.convert.customizedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InputOutOfRangeException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public InputOutOfRangeException(String message) {
        super(message);
    }
}