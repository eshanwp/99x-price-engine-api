package io.x99.priceengine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //To remove null from the response :D
@Slf4j
public class ResponseDto<T> {
    private String message;
    private String details;
    private Boolean status;
    private T data;

    /* Response Constance*/
    private final static String OPERATION_SUCCESSFULLY = "Operation Successfully.";
    private final static String OPERATION_FAILED = "Operation Failed.";

    /* For return is void*/
    private ResponseDto(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    /* For returning data*/
    private ResponseDto(T data, String message, Boolean status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    /* For return errors*/
    private ResponseDto(String details, String message, Boolean status) {
        this.message = message;
        this.details = details;
        this.status = status;
    }

    /*Response builders*/
    public ResponseDto<T> buildSuccessMsg() {
        return new ResponseDto<>(OPERATION_SUCCESSFULLY, Boolean.TRUE);
    }

    public ResponseDto<T> buildSuccessMsgWithData(T data) {
        return new ResponseDto<>(data, OPERATION_SUCCESSFULLY, Boolean.TRUE);
    }

    public ResponseDto<T> buildFailureMsg(Exception ex) {
        return buildFailureMsg(ex.getLocalizedMessage(), ex);
    }

    public ResponseDto<T> buildFailureMsg(String msg, Exception ex) {
        if (ex != null) {
            if (log.isDebugEnabled())
                log.debug("Oops, An error occurred while processing the request", ex);
            else
                log.error("Oops, An error occurred while processing the request cased by {}", ExceptionUtils.getRootCauseMessage(ex), ex);
        }

        return new ResponseDto<>(msg, OPERATION_FAILED, Boolean.FALSE);
    }
}
