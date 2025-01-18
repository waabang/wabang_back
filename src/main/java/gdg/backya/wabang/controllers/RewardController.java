package gdg.backya.wabang.controllers;

import gdg.backya.wabang.dtos.GetRewardsResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.services.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rewards")
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<GetRewardsResponse>>> getRewards(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size){
        BaseResponse<List<GetRewardsResponse>> res = rewardService.getRewards(page, size);

        return ResponseEntity.ok(res);
    }
}
