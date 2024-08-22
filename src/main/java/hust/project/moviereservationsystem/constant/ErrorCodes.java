package hust.project.moviereservationsystem.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    CREATE_USER_FAIL(400001L, "Create user fail"),
    CREATE_ROLE_FAIL(400002L, "Create role fail"),
    GET_ROLE_NOT_FOUND(400003L, "get role not found"),


    ;
    private final Long code;
    private final String message;
}
