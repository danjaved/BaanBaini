package com.baanBaini.BaanBaini.user.controller;

import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import com.baanBaini.BaanBaini.shared.urls.actionPaths.userActionPaths.UserLoginActionPaths;
import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import com.baanBaini.BaanBaini.user.model.dto.UserDto;
import com.baanBaini.BaanBaini.user.model.requestModel.UserLogInRequestModel;
import com.baanBaini.BaanBaini.user.model.requestModel.UserSignUpRequestModel;
import com.baanBaini.BaanBaini.user.model.responseModel.UserSignUpResponseModel;
import com.baanBaini.BaanBaini.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerPaths.USER_BASE_URL)
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @Autowired
    MapperUtility mapperUtility;

//    @PostMapping(UserLoginActionPaths.USER_LOGIN_URL)
//    public ResponseEntity userLogin(@RequestBody UserLogInRequestModel user){
//
//        return ResponseEntity.ok("Login Successful");
//    }

    @PostMapping(UserLoginActionPaths.USER_SIGNUP_URL)
    public ResponseEntity<UserSignUpResponseModel> addUser(@RequestBody UserSignUpRequestModel user){
        UserDto userDto=mapperUtility.mapModel(user, UserDto.class);
        userDto=this.userLoginService.addUser(userDto);
        UserSignUpResponseModel userSignUpResponseModel=mapperUtility.mapModel(userDto,UserSignUpResponseModel.class);
        return ResponseEntity.ok(userSignUpResponseModel);
    }
    @GetMapping("testAccess")
    public String testAccess(){
        return "USER Data Visible";
    }
}
