package gdg.backya.wabang.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetRewardsResponse {
    private final String name;
    private final Integer point;

    @Builder
    public GetRewardsResponse(String name, Integer point) {
        this.name = name;
        this.point = point;
    }

    public static GetRewardsResponse from(String name, Integer point) {
        return GetRewardsResponse.builder()
                .name(name)
                .point(point)
                .build();
    }
}
