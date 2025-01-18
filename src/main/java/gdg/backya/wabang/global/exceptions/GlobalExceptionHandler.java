package gdg.backya.wabang.global.exceptions;

import gdg.backya.wabang.global.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<BaseResponse> handleServiceException(ServiceException e) {
    BaseResponse res = BaseResponse.fail(e.getMessage(), e);
    return ResponseEntity.badRequest().body(res);
  }
}
