package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreatePaymentException extends ApplicationException {
    public CreatePaymentException() {
        super(ErrorCodes.CREATE_PAYMENT_FAIL.getMessage(), ErrorCodes.CREATE_PAYMENT_FAIL.getCode());
    }
}
