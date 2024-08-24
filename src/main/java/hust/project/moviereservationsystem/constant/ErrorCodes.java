package hust.project.moviereservationsystem.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    CREATE_USER_FAIL(400001L, "Create user fail"),
    CREATE_ROLE_FAIL(400002L, "Create role fail"),
    GET_ROLE_NOT_FOUND(400003L, "Get role not found"),

    CREATE_MOVIE_FAIL(400004L, "Create movie fail"),
    GET_MOVIE_NOT_FOUND(400005L, "Get movie not found"),
    DELETE_MOVIE_FAIL(400006L, "Delete movie fail"),

    CREATE_GENRE_FAIL(400007L, "Create genre fail"),
    GET_GENRE_NOT_FOUND(400008L, "Get genre not found"),

    CREATE_MOVIE_GENRE_FAIL(400009L, "Create movie genre fail"),
    ;
    private final Long code;
    private final String message;
}
