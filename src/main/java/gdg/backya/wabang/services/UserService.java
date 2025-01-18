package gdg.backya.wabang.services;

import gdg.backya.wabang.domain.User;
import gdg.backya.wabang.dtos.GetTotalPointResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public BaseResponse<GetTotalPointResponse> getTotalPoint(){
        User user = userRepository.findAll().getFirst();

        GetTotalPointResponse res = GetTotalPointResponse.from(user.getPoint());

        return BaseResponse.success("success", res);
    }
}
