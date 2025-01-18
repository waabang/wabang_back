package gdg.backya.wabang.services.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinedInfo {
  private String name;
  private String imageUrl;
  private String streetAddress;
  private Boolean success;

  public JoinedInfo(String name, String imageUrl, String streetAddress, Boolean success) {
    this.name = name;
    this.imageUrl = imageUrl;
    this.streetAddress = streetAddress;
    this.success = success;
  }
}
