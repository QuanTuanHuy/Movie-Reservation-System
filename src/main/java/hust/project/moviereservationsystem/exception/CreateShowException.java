package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateShowException extends ApplicationException {
    public CreateShowException() {
        super(ErrorCodes.CREATE_SHOW_FAIL.getMessage(), ErrorCodes.CREATE_SHOW_FAIL.getCode());
    }
}
