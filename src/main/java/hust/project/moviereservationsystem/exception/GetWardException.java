package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetWardException extends ApplicationException {
    public GetWardException() {
        super(ErrorCodes.GET_WARD_NOT_FOUND.getMessage(), ErrorCodes.GET_WARD_NOT_FOUND.getCode());
    }
}
