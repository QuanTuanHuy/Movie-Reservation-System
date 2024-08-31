package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UnExpectedException extends ApplicationException {
    public UnExpectedException() {
        super(ErrorCodes.UNEXPECTED_ERROR.getMessage(), ErrorCodes.UNEXPECTED_ERROR.getCode());
    }
}
