package com.sirusservice.sirus.contoller;

import com.sirusservice.sirus.service.SirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/sirus")
public class SirusController {
    @Autowired
    SirusService sirusService;

    @PostMapping("/update")
    public void update() throws IOException {
        sirusService.update();
    }


}
