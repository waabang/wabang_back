package gdg.backya.wabang.services;

import gdg.backya.wabang.domain.Location;
import gdg.backya.wabang.domain.Reward;
import gdg.backya.wabang.dtos.GetLocationsResponse;
import gdg.backya.wabang.dtos.GetRewardsResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.repositories.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardService {
    private final RewardRepository rewardRepository;

    public BaseResponse<List<GetRewardsResponse>> getRewards(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<Reward> list= rewardRepository.findAll(pageRequest).getContent();

        return BaseResponse.success("success", list.stream().map(
                reward -> GetRewardsResponse.from(reward.getName(), reward.getPoint())).toList());
    }
}
