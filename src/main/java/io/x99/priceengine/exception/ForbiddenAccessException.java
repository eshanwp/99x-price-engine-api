package io.x99.priceengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenAccessException extends RuntimeException {

    private static final long serialVersionUID = 6525225690162870161L;

    public ForbiddenAccessException(String message) {
        super(message);
    }
}
