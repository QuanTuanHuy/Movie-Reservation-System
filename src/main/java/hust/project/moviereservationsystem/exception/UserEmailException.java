package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UserEmailException extends ApplicationException {
    public UserEmailException() {
        super(ErrorCodes.EMAIL_IS_EXISTED.getMessage(), ErrorCodes.EMAIL_IS_EXISTED.getCode());
    }
}
