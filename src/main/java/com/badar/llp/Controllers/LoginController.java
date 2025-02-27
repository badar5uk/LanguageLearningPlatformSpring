package com.badar.llp.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String home(HttpServletRequest request){
        return ("<h1>Welcome<h1>" + request.getSession().getId());
    }
}
