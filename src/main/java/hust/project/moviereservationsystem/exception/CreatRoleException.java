package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreatRoleException extends ApplicationException {
    public CreatRoleException() {
        super(ErrorCodes.CREATE_ROLE_FAIL.getMessage(), ErrorCodes.CREATE_ROLE_FAIL.getCode());
    }
}
