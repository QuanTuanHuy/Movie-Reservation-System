package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class GetMovieElasticException extends ApplicationException {
    public GetMovieElasticException() {
        super(ErrorCodes.GET_MOVIE_ELASTICSEARCH_FAIL.getMessage(), ErrorCodes.GET_MOVIE_ELASTICSEARCH_FAIL.getCode());
    }
}
