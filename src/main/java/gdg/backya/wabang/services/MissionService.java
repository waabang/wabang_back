package gdg.backya.wabang.services;

import gdg.backya.wabang.controllers.GetDetailResponse;
import gdg.backya.wabang.controllers.dtos.AnswerRequest;
import gdg.backya.wabang.controllers.dtos.MissionCreateRequest;
import gdg.backya.wabang.domain.*;
import gdg.backya.wabang.domain.Record;
import gdg.backya.wabang.domain.enums.MissionType;
import gdg.backya.wabang.dtos.GetMissionResponse;
import gdg.backya.wabang.external.FileSender;
import gdg.backya.wabang.external.OpenAPIClient;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.repositories.LocationRepository;
import gdg.backya.wabang.repositories.MissionRepository;
import gdg.backya.wabang.repositories.UserRepository;
import gdg.backya.wabang.services.dtos.AnswerResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;
    private final OpenAPIClient openAPIClient;
    private final LocationRepository locationRepository;
    private final FileSender fileSender;
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public BaseResponse<GetMissionResponse> getMission(Integer missionId) {

        Mission mission = missionRepository.findByLocationId(missionId).orElseThrow(IllegalArgumentException::new);
        Location location = locationRepository.findById(mission.getLocationId()).orElseThrow(IllegalArgumentException::new);
        GetMissionResponse res = GetMissionResponse.from(missionId,mission.getType().toString(),mission.getHeadImageUrl() , location.getName());
        return BaseResponse.success("success",res);
    }

    @Transactional
    public void save(MissionCreateRequest request) {

        Location location = locationRepository.findById(request.getLocationId()).orElseThrow(IllegalArgumentException::new);
        String imgUrl = openAPIClient.fetchOpenAPI(location.getCoordinate().getY(), location.getCoordinate().getX());
        Mission mission = Mission.builder()
            .locationId(location.getId())
            .title(request.getTitle())
            .headImageUrl(imgUrl)
            .type(MissionType.valueOf(request.getType()))
            .rewardPoint(100)
            .quiz(request.getQuiz())
            .build();
        missionRepository.save(mission);
    }


    @Transactional
    public BaseResponse<AnswerResponse> answerMission(Integer missionId, AnswerRequest answer) throws IOException {
        Mission mission = missionRepository.findById(missionId).orElseThrow(IllegalArgumentException::new);
        if(mission.getType() == MissionType.QUIZ) {
            System.out.println("정답은 " + mission.getQuiz());
            return BaseResponse.success("d", "d");
        }
        AnswerResponse ret = fileSender.uploadFile(
            "http://localhost:5000/api/upload",
            answer.getImage(),
            "answer",
            "1");
        User user = userRepository.findById(1).orElseThrow(IllegalArgumentException::new);
        user.setPoint(user.getPoint() + mission.getRewardPoint());
        Record record = recordRepository.findByUserIdAndRecordId(1, missionId)
            .orElse(new Record(1, missionId, false));
        record.setSuccess(ret.getSuccess());
        recordRepository.save(record);
        return BaseResponse.success("success", ret);
    }

    public BaseResponse<GetDetailResponse> getMissionDetails(Integer missionId) {
        Mission mission = missionRepository.findById(missionId).
            orElseThrow(IllegalArgumentException::new);
        return BaseResponse.success("success", new GetDetailResponse(mission.getTitle()));
    }
}
