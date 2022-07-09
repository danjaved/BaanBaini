package com.baanBaini.BaanBaini.user.controller;

import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import com.baanBaini.BaanBaini.shared.urls.actionPaths.userActionPaths.UserOrdersActionPaths;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerPaths.USER_ORDERS_PATH)
public class UserOrderController {
    @GetMapping(UserOrdersActionPaths.ALL_ORDERS_PATH)
    public String getUserOrders(){
        return "User Orders";
    }
}
