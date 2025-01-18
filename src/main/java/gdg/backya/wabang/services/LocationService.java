package gdg.backya.wabang.services;

import gdg.backya.wabang.domain.Location;
import gdg.backya.wabang.dtos.GetLocationsResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

  private final LocationRepository locationRepository;

  public BaseResponse<List<GetLocationsResponse>> getLocationsNearby(Float latitude, Float longitude, Integer page, Integer size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    List<Location> list= locationRepository.findWhereNearby(latitude, longitude, 5000, pageRequest).getContent();

    return BaseResponse.success("success", list.stream().map(
      location -> GetLocationsResponse.from(location.getId(), location.getName(), location.getCoordinate(), location.getStreetAddress())
    ).toList(
    ));
  }
}
