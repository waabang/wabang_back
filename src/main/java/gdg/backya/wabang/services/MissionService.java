package gdg.backya.wabang.services;

import gdg.backya.wabang.controllers.AnswerRequest;
import gdg.backya.wabang.controllers.MissionCreateRequest;
import gdg.backya.wabang.domain.Location;
import gdg.backya.wabang.domain.Mission;
import gdg.backya.wabang.domain.enums.MissionType;
import gdg.backya.wabang.dtos.GetMissionResponse;
import gdg.backya.wabang.external.FileSender;
import gdg.backya.wabang.external.OpenAPIClient;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.repositories.LocationRepository;
import gdg.backya.wabang.repositories.MissionRepository;
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

    public BaseResponse<GetMissionResponse> getMission(Integer missionId) {

        Mission mission = missionRepository.findById(missionId).orElseThrow(IllegalArgumentException::new);
        Location location = locationRepository.findById(mission.getLocationId()).orElseThrow(IllegalArgumentException::new);



        GetMissionResponse res = GetMissionResponse.from(missionId,mission.getType().toString(),mission.getHeadImageUrl() , mission.getTitle());

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
        System.out.println(ret.getSuccess());
        return BaseResponse.success("success", ret);
    }
}
