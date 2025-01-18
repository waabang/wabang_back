package gdg.backya.wabang.controllers;

import gdg.backya.wabang.dtos.GetLocationsResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps/locations")
@RequiredArgsConstructor
public class MapController {

  private final LocationService locationService;

  @GetMapping
  public ResponseEntity<BaseResponse<List<GetLocationsResponse>>> getLocations(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "size", defaultValue = "10") Integer size,
      @RequestParam(value = "latitude") Float latitude,
      @RequestParam(value = "longitude") Float longitude
  ) {
    BaseResponse<List<GetLocationsResponse>> res = locationService.getLocationsNearby(latitude, longitude, page, size);
    return ResponseEntity.ok(BaseResponse.success("success", res));
  }




}
