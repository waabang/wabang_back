package gdg.backya.wabang.services;

import gdg.backya.wabang.services.dtos.JoinedInfo;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.repositories.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyService {

  private final MyRepository myRepository;

  public BaseResponse<List<JoinedInfo>> getJoinedMissionsInfo(int page, int size) {
    int userId = 1;
    PageRequest pageRequest = PageRequest.of(page, size);
    List<JoinedInfo> infos = myRepository.findAllJoinedMissionsInfo(pageRequest).getContent();
    return BaseResponse.success("suceess", infos);
  }
}
