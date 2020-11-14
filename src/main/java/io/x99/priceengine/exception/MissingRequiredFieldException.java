package io.x99.priceengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MissingRequiredFieldException extends RuntimeException {
    private static final long serialVersionUID = -8586652822366230375L;

    public MissingRequiredFieldException(String message) {
        super(message);
    }
}
