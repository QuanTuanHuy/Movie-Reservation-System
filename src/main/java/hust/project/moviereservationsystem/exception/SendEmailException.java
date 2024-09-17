package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class SendEmailException extends ApplicationException {
    public SendEmailException() {
        super(ErrorCodes.SEND_EMAIL_FAIL.getMessage(), ErrorCodes.SEND_EMAIL_FAIL.getCode());
    }
}
