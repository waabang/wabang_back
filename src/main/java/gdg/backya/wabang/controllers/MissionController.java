package gdg.backya.wabang.controllers;

import gdg.backya.wabang.controllers.dtos.AnswerRequest;
import gdg.backya.wabang.controllers.dtos.MissionCreateRequest;
import gdg.backya.wabang.dtos.GetMissionResponse;
import gdg.backya.wabang.external.OpenAPIClient;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.services.dtos.AnswerResponse;
import gdg.backya.wabang.services.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;
    private final OpenAPIClient openAPIClient;

    @GetMapping("/{missionId}")
    public ResponseEntity<BaseResponse<GetMissionResponse>> getMission(@PathVariable Integer missionId) {
        BaseResponse<GetMissionResponse> res = missionService.getMission(missionId);

        return ResponseEntity.ok(res);
    }

    @GetMapping("{missionId}/details")
    public ResponseEntity<BaseResponse<GetDetailResponse>> getMissionDetails(@PathVariable Integer missionId) {
        BaseResponse<GetDetailResponse> res = missionService.getMissionDetails(missionId);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public void createMission(@RequestBody MissionCreateRequest request) {
        missionService.save(request);
    }

    @PostMapping("/{missionId}/answer")
    public ResponseEntity<BaseResponse<AnswerResponse>> answerMission(
        @PathVariable Integer missionId,
        @RequestParam("answer") String answer,
        @RequestParam("image") MultipartFile image
    ) throws IOException {
        AnswerRequest answerRequest = new AnswerRequest(answer, image);
        BaseResponse<AnswerResponse> res = missionService.answerMission(missionId, answerRequest);
        return ResponseEntity.ok(res);
    }
}
