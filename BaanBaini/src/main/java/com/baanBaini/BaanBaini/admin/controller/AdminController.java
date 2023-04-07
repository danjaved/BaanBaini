package com.baanBaini.BaanBaini.admin.controller;

import com.baanBaini.BaanBaini.admin.model.dto.AdminDTO;
import com.baanBaini.BaanBaini.admin.model.requestModel.AdminSignupRequestModel;
import com.baanBaini.BaanBaini.admin.model.responseModel.AdminSignupResponseModel;
import com.baanBaini.BaanBaini.admin.service.AdminLoginService;
import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import com.baanBaini.BaanBaini.shared.urls.actionPaths.AdminActionPaths;
import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerPaths.ADMIN_BASE_URL)
public class AdminController {

    @Autowired
    MapperUtility mapperUtility;

    @Autowired
    AdminLoginService adminLoginService;

    @PostMapping(AdminActionPaths.SIGNUP)
    public ResponseEntity<AdminSignupResponseModel> addUser (@RequestBody AdminSignupRequestModel admin){
        AdminDTO adminDTO= mapperUtility.mapModel(admin, AdminDTO.class);
        adminDTO=adminLoginService.addAdmin(adminDTO);
        return ResponseEntity.ok(mapperUtility.mapModel(adminDTO,AdminSignupResponseModel.class));
    }
    @GetMapping("testAccess")
    public String testAccess(){
        return "ADMIN Data Visible";
    }
}
