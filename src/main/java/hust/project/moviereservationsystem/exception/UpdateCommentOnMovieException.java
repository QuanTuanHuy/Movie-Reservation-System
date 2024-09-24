package hust.project.moviereservationsystem.exception;

import hust.project.moviereservationsystem.constant.ErrorCodes;

public class UpdateCommentOnMovieException extends ApplicationException {
    public UpdateCommentOnMovieException() {
        super(ErrorCodes.UPDATE_COMMENT_ON_MOVIE_FAIL.getMessage(), ErrorCodes.UPDATE_COMMENT_ON_MOVIE_FAIL.getCode());
    }
}
