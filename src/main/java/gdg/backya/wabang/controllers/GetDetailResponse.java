package gdg.backya.wabang.controllers;

import lombok.Getter;

@Getter
public class GetDetailResponse {
  private String quiz;

  public GetDetailResponse(String quiz) {
    this.quiz = quiz;
  }
}
