package gdg.backya.wabang.controllers;

import gdg.backya.wabang.dtos.GetTotalPointResponse;
import gdg.backya.wabang.global.dto.BaseResponse;
import gdg.backya.wabang.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/points")
    public ResponseEntity<BaseResponse<GetTotalPointResponse>> getTotalPoint(){
        BaseResponse<GetTotalPointResponse> res = userService.getTotalPoint();

        return ResponseEntity.ok(res);
    }
}
