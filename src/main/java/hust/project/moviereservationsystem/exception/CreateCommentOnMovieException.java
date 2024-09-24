package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class CreateCommentOnMovieException extends ApplicationException {
    public CreateCommentOnMovieException() {
        super(ErrorCodes.CREATE_COMMENT_ON_MOVIE_FAIL.getMessage(), ErrorCodes.CREATE_COMMENT_ON_MOVIE_FAIL.getCode());
    }
}
