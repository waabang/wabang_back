package gdg.backya.wabang.dtos;

import lombok.Builder;
import lombok.Getter;
import org.locationtech.jts.geom.Point;

@Getter
public class GetLocationsResponse {
  private final Integer id;
  private final String name;
  private final Double latitude;
  private final Double longitude;
  private final String streetAddress;

  @Builder
  public GetLocationsResponse(Integer id, String name, Double latitude, Double longitude, String streetAddress) {
    this.id = id;
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
    this.streetAddress = streetAddress;
  }

  public static GetLocationsResponse from(Integer id, String name, Point point, String streetAddress) {
    return GetLocationsResponse.builder()
      .name(name)
      .latitude(point.getCoordinate().y)
      .longitude(point.getCoordinate().x)
      .streetAddress(streetAddress)
      .build();
  }
}

