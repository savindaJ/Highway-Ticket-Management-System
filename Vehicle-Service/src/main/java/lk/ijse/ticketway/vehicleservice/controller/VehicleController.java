package lk.ijse.ticketway.vehicleservice.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author : savindaJ
 * @date : 2024-06-24
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/actions")
public class VehicleController {

    @PostMapping("/register")
    public String add() {
        return "Add";
    }

    @PutMapping("/update")
    public String update() {
        return "Update";
    }

    @GetMapping
    public String get() {
        return "Get";
    }
}
