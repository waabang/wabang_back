package gdg.backya.wabang.global.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseResponse implements Serializable {

  private String status;
  private String message;
  private Object payload;

  public BaseResponse(String status, String message, Object payload) {
    this.status = status;
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
      "status='" + status + '\'' +
      ", message='" + message + '\'' +
      '}';
  }
}
