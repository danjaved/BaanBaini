package com.baanBaini.BaanBaini.kurtis.controllers;

import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerPaths.HOME_BASE_PATH)
public class HomeController {
    @GetMapping
    public String test(){
        return "I am accessible";
    }
}
