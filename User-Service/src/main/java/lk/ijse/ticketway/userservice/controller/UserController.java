package lk.ijse.ticketway.userservice.controller;

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

    @RequestMapping("/login")
    public String login(){
        return "Login";
    }

    @RequestMapping("/register")
    public String register(){
        return "Register";
    }

    @RequestMapping("/update")
    public String update(){
        return "Update";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "Delete";
    }

    @RequestMapping("/get")
    public String get(){
        return "Get";
    }

    @RequestMapping("/getAll")
    public String getAll(){
        return "Get All";
    }

    @RequestMapping("/getByUserName")
    public String getByUserName(){
        return "Get By UserName";
    }

    @RequestMapping("/getByUserEmail")
    public String getByUserEmail(){
        return "Get By User Email";
    }

    @RequestMapping("/getByUserMobile")
    public String getByUserMobile(){
        return "Get By User Mobile";
    }

    @RequestMapping("/getByUserNic")
    public String getByUserNic(){
        return "Get By User Nic";
    }

    @RequestMapping("/getByUserType")
    public String getByUserType(){
        return "Get By User Type";
    }

    @RequestMapping("/getByUserStatus")
    public String getByUserStatus(){
        return "Get By User Status";
    }

    @RequestMapping("/getByUserCreatedDate")
    public String getByUserCreatedDate(){
        return "Get By User Created Date";
    }

    @RequestMapping("/getByUserUpdatedDate")
    public String getByUserUpdatedDate(){
        return "Get By User Updated Date";
    }

    @RequestMapping("/getByUserCreatedBy")
    public String getByUserCreatedBy(){
        return "Get By User Created By";
    }

    @RequestMapping("/getByUserUpdatedBy")
    public String getByUserUpdatedBy(){
        return "Get By User Updated By";
    }

    @RequestMapping("/getByUserDeletedBy")
    public String getByUserDeletedBy(){
        return "Get By User Deleted By";
    }

    @RequestMapping("/getByUserDeletedDate")
    public String getByUserDeletedDate(){
        return "Get By User Deleted Date";
    }

    @RequestMapping("/getByUserDeleted")
    public String getByUserDeleted(){
        return "Get By User Deleted";
    }

}
