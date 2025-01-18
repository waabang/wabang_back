package gdg.backya.wabang.controllers;

import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.services.MyService;
import gdg.backya.wabang.services.dtos.JoinedInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my")
public class MyController {

  private final MyService myService;

  @GetMapping("/joined-missions")
  public ResponseEntity<BaseResponse<List<JoinedInfo>>> getJoinedMissionsInfo(
      @RequestParam(value = "page", defaultValue =  "0") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    return ResponseEntity.ok(myService.getJoinedMissionsInfo(page, size));
  }

}
