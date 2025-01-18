package gdg.backya.wabang.controllers;

import gdg.backya.wabang.domain.enums.MissionType;
import lombok.Getter;

@Getter
public class MissionCreateRequest {

    private String title;
    private String quiz;
    private Integer locationId;
    private String type;

  public MissionCreateRequest(String title, String quiz, Integer locationId, String type) {
    this.title = title;
    this.quiz = quiz;
    this.locationId = locationId;
    this.type = type;
  }
}
