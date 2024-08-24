package hust.project.moviereservationsystem.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

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

    CREATE_CINEMA_FAIL(4000010L, "Create cinema fail"),
    GET_CINEMA_NOT_FOUND(4000011L, "Get cinema not found"),
    DELETE_CINEMA_FAIL(4000012L, "Delete cinema fail"),

    CREATE_ADDRESS_FAIL(4000013L, "Create address fail"),
    GET_ADDRESS_NOT_FOUND(4000014L, "Get address not found"),

    CREATE_CITY_FAIL(4000015L, "Create city fail"),
    GET_CITY_NOT_FOUND(4000016L, "Get city not found"),

    CREATE_DISTRICT_FAIL(4000017L, "Create district fail"),
    GET_DISTRICT_NOT_FOUND(4000018L, "Get district not found"),

    CREATE_WARD_FAIL(4000019L, "Create ward fail"),
    GET_WARD_NOT_FOUND(4000020L, "Get ward not found"),

    CREATE_CINEMA_HALL_FAIL(4000021L, "Create cinema hall fail"),
    GET_CINEMA_HALL_NOT_FOUND(4000022L, "Get cinema hall not found"),
    DELETE_CINEMA_HALL_FAIL(4000023L, "Delete cinema hall fail"),
    ;
    private final Long code;
    private final String message;
}
