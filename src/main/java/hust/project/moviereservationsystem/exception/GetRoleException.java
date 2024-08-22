package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetRoleException extends ApplicationException {
    public GetRoleException() {
        super(ErrorCodes.GET_ROLE_NOT_FOUND.getMessage(), ErrorCodes.GET_ROLE_NOT_FOUND.getCode());
    }
}
