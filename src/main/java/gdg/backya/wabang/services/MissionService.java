package gdg.backya.wabang.services;

import gdg.backya.wabang.domain.Mission;
import gdg.backya.wabang.dtos.GetMissionResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.repositories.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;


    public BaseResponse<GetMissionResponse> getMission(Integer missionId) {

        Mission mission = missionRepository.findById(missionId).orElseThrow(IllegalArgumentException::new);
        GetMissionResponse res = GetMissionResponse.from(missionId,mission.getType().toString(), mission.getHeadImageUrl(), mission.getTitle());

        return BaseResponse.success("success",res);
    }

}
