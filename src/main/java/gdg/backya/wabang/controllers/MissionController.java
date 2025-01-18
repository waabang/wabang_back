package gdg.backya.wabang.controllers;

import gdg.backya.wabang.dtos.GetMissionResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.services.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping("{missionId}")
    public ResponseEntity<BaseResponse<GetMissionResponse>> getMission(@PathVariable Integer missionId) {
        BaseResponse<GetMissionResponse> res = missionService.getMission(missionId);

        return ResponseEntity.ok(res);
    }
}
