package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UpdatePaymentException extends ApplicationException {
    public UpdatePaymentException() {
        super(ErrorCodes.UPDATE_PAYMENT_FAIL.getMessage(), ErrorCodes.UPDATE_PAYMENT_FAIL.getCode());
    }
}
