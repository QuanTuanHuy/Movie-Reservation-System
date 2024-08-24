package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetAddressException extends ApplicationException {
    public GetAddressException() {
        super(ErrorCodes.GET_ADDRESS_NOT_FOUND.getMessage(), ErrorCodes.GET_ADDRESS_NOT_FOUND.getCode());
    }
}
