package gdg.backya.wabang.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetTotalPointResponse {
    private final int totalPoint;

    @Builder
    public GetTotalPointResponse(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public static GetTotalPointResponse from(int totalPoint) {
        return builder().totalPoint(totalPoint).build();
    }
}
