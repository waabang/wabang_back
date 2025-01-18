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

  public BaseResponse<GetLocationsResponse> getLocationsNearby(Float latitude, Float longitude, Integer page, Integer size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    //locationRepository.findWhereNearby(latitude, longitude, pageRequest);
    return BaseResponse.success("success", null);
  }
}
