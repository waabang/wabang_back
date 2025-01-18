package gdg.backya.wabang.external;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OpenAPIClient {

  @Value("${open-api.base-url}")
  private String BASE_URL;
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  public String fetchOpenAPI(Double latitude, Double longitude) {
    return extractImages(getOpenAPIUrlWithCoordinate(latitude, longitude));
  }

  public String extractImages(String url) {
    URI uri = URI.create(url);
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      Map<String, Object> responseMap = objectMapper.readValue(responseEntity.getBody(), Map.class);
      Map<String, Object> body = (Map<String, Object>) responseMap.get("response");
      Map<String, Object> items = (Map<String, Object>) body.get("body");
      Map<String, Object> item =  ((Map<String, Object>) items.get("items"));
      List<Map<String,Object>> k = (List<Map<String, Object>>) item.get("item");
      String firstImage = (String)k.get(0).get("firstimage");

      return firstImage;
    } catch (Exception e) {
      throw new RuntimeException("Error parsing response", e);
    }
  }

  private String getOpenAPIUrlWithCoordinate(Double latitude, Double longitude) {
    return BASE_URL + "&mapY=" + latitude + "&mapX=" + longitude;
  }

}
