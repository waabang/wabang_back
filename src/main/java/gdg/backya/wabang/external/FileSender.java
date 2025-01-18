package gdg.backya.wabang.external;
import com.fasterxml.jackson.databind.ObjectMapper;
import gdg.backya.wabang.services.AnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.*;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FileSender {

  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  public AnswerResponse uploadFile(String url, MultipartFile file, String description, String userId) throws IOException {
    HttpEntity<MultiValueMap<String, Object>> requestEntity = parseToHttpEntity(url, file, description, userId);
    // 응답을 제네릭 타입 T로 변환
    try {
      ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
      return objectMapper.readValue(response.getBody(), AnswerResponse.class);
    } catch (RestClientException e) {
      throw new RuntimeException("Failed to send file", e);
    } catch (Exception e) {
      throw new RuntimeException("Failed to map response to DTO", e);
    }
  }

  private HttpEntity<MultiValueMap<String, Object>> parseToHttpEntity(String url, MultipartFile file, String description, String userId) throws IOException {
    MultiValueMap<String, Object> body = createBody(file, description, userId);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    return new HttpEntity<>(body, headers);
  }

  private MultiValueMap<String, Object> createBody(MultipartFile file, String description, String userId) throws IOException {
    // MultipartFile의 내용을 ByteArrayResource로 변환
    ByteArrayResource fileResource = new ByteArrayResource(file.getBytes()) {
      @Override
      public String getFilename() {
        return file.getOriginalFilename();  // 파일명 설정
      }
    };

    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    body.add("image", fileResource);
    body.add("mission", 2);
    body.add("description", description);
    body.add("userId", userId);
    return body;
  }
}
