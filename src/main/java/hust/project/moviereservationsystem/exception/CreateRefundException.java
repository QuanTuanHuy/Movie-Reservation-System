package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateRefundException extends ApplicationException {
    public CreateRefundException() {
        super(ErrorCodes.CREATE_REFUND_FAIL.getMessage(), ErrorCodes.CREATE_REFUND_FAIL.getCode());
    }
}
