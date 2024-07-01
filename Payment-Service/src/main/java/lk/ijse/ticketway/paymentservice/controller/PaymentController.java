package lk.ijse.ticketway.paymentservice.controller;

import lk.ijse.ticketway.paymentservice.dto.PaymentDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : savindaJ
 * @date : 2024-06-24
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/actions")
public class PaymentController {

    @PostMapping("/validate")
    public String add(@RequestBody PaymentDTO paymentDTO) {
        return "Add";
    }

    @PostMapping("/process")
    public String update(@RequestBody PaymentDTO paymentDTO) {
        return "Update";
    }
}
