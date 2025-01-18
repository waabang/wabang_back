package gdg.backya.wabang.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMissionResponse {
    private final Integer missionId;
    private final String type;
    private final String url;
    private final String description;

    @Builder
    public GetMissionResponse(Integer missionId, String type, String url, String description) {
        this.missionId = missionId;
        this.type = type;
        this.url = url;
        this.description = description;
    }

    public static GetMissionResponse from(Integer missionId, String type, String url, String description) {
        return GetMissionResponse.builder()
                .missionId(missionId)
                .type(type)
                .url(url)
                .description(description)
                .build();
    }

}
