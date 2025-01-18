package gdg.backya.wabang.controllers.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class AnswerRequest {
  private String answer;
  private MultipartFile image;

  public AnswerRequest(String answer, MultipartFile image) {
    this.answer = answer;
    this.image = image;
  }
}
