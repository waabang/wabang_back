package gdg.backya.wabang.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetLocationsResponse {
  private final String name;
  private final Float latitude;
  private final Float longitude;
  private final String streetAddress;

  @Builder
  public GetLocationsResponse(String name, Float latitude, Float longitude, String streetAddress) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
    this.streetAddress = streetAddress;
  }

  public static GetLocationsResponse from(String name, Float latitude, Float longitude, String streetAddress) {
    return GetLocationsResponse.builder()
      .name(name)
      .latitude(latitude)
      .longitude(longitude)
      .streetAddress(streetAddress)
      .build();
  }
}

