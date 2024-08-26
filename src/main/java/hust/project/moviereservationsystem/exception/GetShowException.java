package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetShowException extends ApplicationException {
    public GetShowException() {
        super(ErrorCodes.GET_SHOW_NOT_FOUND.getMessage(), ErrorCodes.GET_SHOW_NOT_FOUND.getCode());
    }
}
