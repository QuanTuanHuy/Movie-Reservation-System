package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetRefundException extends ApplicationException {
    public GetRefundException() {
        super(ErrorCodes.GET_REFUND_NOT_FOUND.getMessage(), ErrorCodes.GET_REFUND_NOT_FOUND.getCode());
    }
}
