package gdg.backya.wabang.global.exceptions;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException{
  private String message;
  private String code;

  protected ServiceException() {
  }

  protected ServiceException(String message, String code) {
    this.message = message;
    this.code = code;
  }



}
