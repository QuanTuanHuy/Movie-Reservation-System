package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateAddressException extends ApplicationException {
    public CreateAddressException() {
        super(ErrorCodes.CREATE_ADDRESS_FAIL.getMessage(), ErrorCodes.CREATE_ADDRESS_FAIL.getCode());
    }
}
