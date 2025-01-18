package gdg.backya.wabang.global.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseResponse<T> implements Serializable {

  private String message;
  private String code;
  private T payload;

  public BaseResponse(String code, String message, T payload) {
    this.code = code;
    this.message = message;
    this.payload = payload;
  }

  public static BaseResponse success(String message, Object payload) {
    return new BaseResponse("success", message, payload);
  }

  public static BaseResponse fail(String message, Exception e) {
    return new BaseResponse("fail", e.getMessage(), null);
  }

  @Override
  public String toString() {
    return "BaseResponse{" +
      "status='" + code + '\'' +
      ", message='" + message + '\'' +
      '}';
  }
}
