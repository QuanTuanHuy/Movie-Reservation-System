package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateUserException extends ApplicationException {
    public CreateUserException() {
        super(ErrorCodes.CREATE_USER_FAIL.getMessage(), ErrorCodes.CREATE_USER_FAIL.getCode());
    }
}
