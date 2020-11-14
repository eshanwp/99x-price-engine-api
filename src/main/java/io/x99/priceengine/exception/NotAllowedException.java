package io.x99.priceengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class NotAllowedException extends RuntimeException {
    private static final long serialVersionUID = 6525225690162870161L;

    public NotAllowedException(String message) {
        super(message);
    }
}
