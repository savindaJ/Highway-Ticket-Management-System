package lk.ijse.ticketway.userservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : savindaJ
 * @date : 2024-06-24
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/actions")
public class UserController {

    @PostMapping("/login")
    public String login(){
        return "Login";
    }

    @PostMapping("/register")
    public String register(){
        return "Register";
    }

    @PutMapping("/update")
    public String update(){
        return "Update";
    }

}
