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

    CREATE_CINEMA_HALL_SEAT_FAIL(4000024L, "Create cinema hall seat fail"),
    GET_CINEMA_HALL_SEAT_NOT_FOUND(4000025L, "Get cinema hall seat not found"),

    CREATE_SHOW_FAIL(4000026L, "Create show fail"),
    GET_SHOW_NOT_FOUND(4000027L, "Get show not found"),
    DELETE_SHOW_FAIL(4000028L, "Delete show fail"),

    CREATE_SEAT_TYPE_FAIL(4000029L, "Create seat type fail"),
    GET_SEAT_TYPE_NOT_FOUND(4000030L, "Get seat type not found"),
    DELETE_SEAT_TYPE_FAIL(4000031L, "Delete seat type fail"),

    CREATE_SHOW_SEAT_FAIL(4000032L, "Create show seat fail"),
    GET_SHOW_SEAT_NOT_FOUND(4000033L, "Get show seat not found"),
    UPDATE_SHOW_SEAT_FAIL(4000034L, "Update show seat fail"),

    UNEXPECTED_ERROR(4000035L, "Unexpected error"),

    EMAIL_IS_EXISTED(4000036L, "Email is existed"),
    INVALID_EMAIL_OR_PASSWORD(4000037L, "Invalid email or password"),
    ;
    private final Long code;
    private final String message;
}
