package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetPaymentException extends ApplicationException {
    public GetPaymentException() {
        super(ErrorCodes.GET_PAYMENT_NOT_FOUND.getMessage(), ErrorCodes.GET_PAYMENT_NOT_FOUND.getCode());
    }
}
