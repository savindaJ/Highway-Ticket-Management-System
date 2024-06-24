package lk.ijse.ticketway.ticketservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : savindaJ
 * @date : 2024-06-24
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/actions")
public class TicketController {

    @RequestMapping("/add")
    public String add() {
        return "Add";
    }

    @RequestMapping("/update")
    public String update() {
        return "Update";
    }

}
