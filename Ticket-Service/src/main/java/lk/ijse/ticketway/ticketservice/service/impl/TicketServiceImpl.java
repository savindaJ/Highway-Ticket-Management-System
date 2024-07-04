package lk.ijse.ticketway.ticketservice.service.impl;

import lk.ijse.ticketway.ticketservice.dto.TicketDTO;
import lk.ijse.ticketway.ticketservice.entity.Ticket;
import lk.ijse.ticketway.ticketservice.entity.User;
import lk.ijse.ticketway.ticketservice.entity.Vehicle;
import lk.ijse.ticketway.ticketservice.repository.TicketRepository;
import lk.ijse.ticketway.ticketservice.service.TicketService;
import lk.ijse.ticketway.ticketservice.util.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-06-28
 * @since : 0.1.0
 **/
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    private final RestTemplate restTemplate;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper mapper, RestTemplate restTemplate) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public ResponseDTO save(TicketDTO ticketDTO) {
        Ticket map = mapper.map(ticketDTO, Ticket.class);
        ResponseDTO forObject = restTemplate.getForObject("http://ticketway-user-service:8080/api/v1/users/actions/get-user/"+ticketDTO.getUserName(), ResponseDTO.class);
        assert forObject != null;
        forObject.getData().forEach((k, v) -> {
            if (k.equals("user")) {
                User user = mapper.map(v, User.class);
                map.setUser(user);
            }
        });

        ResponseDTO vehicle = restTemplate.getForObject("http://ticketway-vehicle-service:8080/api/v1/vehicle/actions/get-vehicle/"+ticketDTO.getVehicleNumber() , ResponseDTO.class);
        System.out.println(vehicle);
        assert vehicle != null;
        vehicle.getData().forEach((k, v) -> {
            if (k.equals("vehicle")) {
                System.out.println(v);
                map.setVehicle(mapper.map(v, Vehicle.class));
            }
        });

        ticketRepository.save(map);
        return new ResponseDTO("Ticket saved successfully", 200);
    }

    @Override
    public ResponseDTO update(TicketDTO ticketDTO) {
        ticketRepository.save(mapper.map(ticketDTO, Ticket.class));
        return new ResponseDTO("Ticket updated successfully", 200);
    }

    @Override
    public ResponseDTO getAll() {
        List<TicketDTO> all = ticketRepository.findAll().stream().map(ticket -> mapper.map(ticket, TicketDTO.class)).toList();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("tickets", all);
        return new ResponseDTO(200, "Ticket fetched successfully", objectObjectHashMap);
    }

    @Override
    public ResponseDTO getTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        TicketDTO map = mapper.map(ticket, TicketDTO.class);
        objectObjectHashMap.put("ticket", map);
        return new ResponseDTO(200, "Ticket fetched successfully", objectObjectHashMap);
    }
}
