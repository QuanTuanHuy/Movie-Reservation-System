package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateWardException extends ApplicationException {
    public CreateWardException() {
        super(ErrorCodes.CREATE_WARD_FAIL.getMessage(), ErrorCodes.CREATE_WARD_FAIL.getCode());
    }
}
