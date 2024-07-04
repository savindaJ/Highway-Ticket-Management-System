package lk.ijse.ticketway.paymentservice.service.impl;

import lk.ijse.ticketway.paymentservice.dto.PaymentDTO;
import lk.ijse.ticketway.paymentservice.entity.Payment;
import lk.ijse.ticketway.paymentservice.entity.Ticket;
import lk.ijse.ticketway.paymentservice.repository.PaymentRepository;
import lk.ijse.ticketway.paymentservice.service.PaymentService;
import lk.ijse.ticketway.paymentservice.util.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : savindaJ
 * @date : 2024-07-01
 * @since : 0.1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    public PaymentServiceImpl(PaymentRepository paymentRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseDTO add(PaymentDTO paymentDTO) {
        Payment map = modelMapper.map(paymentDTO, Payment.class);
        ResponseDTO forObject = restTemplate.getForObject("http://ticketway-ticket-service:8080/api/v1/ticket/actions/get-ticket/" + paymentDTO.getTicketId(), ResponseDTO.class);
        assert forObject != null;
        forObject.getData().forEach((k, v) -> {
            if (k.equals("ticket")) {
                map.setTicket(modelMapper.map(v, Ticket.class));
            }
        });
        Payment save = paymentRepository.save(map);
        return save != null ? new ResponseDTO("Success", 200) : new ResponseDTO("Error", 500);
    }

    @Override
    public ResponseDTO update(PaymentDTO paymentDTO) {
        Payment map = modelMapper.map(paymentDTO, Payment.class);
        ResponseDTO forObject = restTemplate.getForObject("http://ticketway-ticket-service:8080/api/v1/ticket/actions/get-ticket/" + paymentDTO.getTicketId(), ResponseDTO.class);
        assert forObject != null;
        forObject.getData().forEach((k, v) -> {
            if (k.equals("ticket")) {
                map.setTicket(modelMapper.map(v, Ticket.class));
            }
        });
        Payment save = paymentRepository.save(map);
        return save != null ? new ResponseDTO("Success", 200) : new ResponseDTO("Error", 500);
    }
}
