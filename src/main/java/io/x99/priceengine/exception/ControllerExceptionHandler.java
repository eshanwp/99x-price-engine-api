package io.x99.priceengine.exception;

import io.x99.priceengine.dto.ResponseDto;
import org.hibernate.exception.ConstraintViolationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public ControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected @NotNull ResponseEntity<Object> handleHttpMessageNotReadable(@NotNull HttpMessageNotReadableException ex, @NotNull HttpHeaders headers, @NotNull HttpStatus status, @NotNull WebRequest request) {
        ResponseDto<?> responseDto = new ResponseDto<>().buildFailureMsg(messageSource.getMessage("malformed.request", new Object[0], Locale.ENGLISH), ex);
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<?>> globalExceptionHandler(Exception ex) {
        ResponseDto<?> responseDto = new ResponseDto<>().buildFailureMsg(ex);
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseDto<?>> globalNullPointerExceptionHandler(Exception ex) {
        ResponseDto<?> responseDto = new ResponseDto<>().buildFailureMsg(
                messageSource.getMessage("null.pointer.exception", new Object[0], Locale.ENGLISH),
                ex);
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseDto<?>> dataIntegrityViolationExceptionHandler(Exception ex) {
        final String msg;

        if (ex.getCause().getClass().isAssignableFrom(ConstraintViolationException.class))
            msg = messageSource.getMessage("constraint.violation.exception", new Object[0], Locale.ENGLISH);
        else
            msg = messageSource.getMessage("data.integrity.violation.exception", new Object[0], Locale.ENGLISH);

        return new ResponseEntity<>(
                new ResponseDto<>().buildFailureMsg(msg, ex),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
