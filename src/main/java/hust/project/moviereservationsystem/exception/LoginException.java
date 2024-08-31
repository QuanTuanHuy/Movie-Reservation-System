package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class LoginException extends ApplicationException {
    public LoginException() {
        super(ErrorCodes.INVALID_EMAIL_OR_PASSWORD.getMessage(), ErrorCodes.INVALID_EMAIL_OR_PASSWORD.getCode());
    }
}
