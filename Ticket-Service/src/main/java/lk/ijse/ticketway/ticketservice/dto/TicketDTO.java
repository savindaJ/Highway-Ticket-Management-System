package lk.ijse.ticketway.ticketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : savindaJ
 * @date : 2024-06-28
 * @since : 0.1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private Long id;
    private String ticketId;
    private String ticketType;
    private String ticketPrice;
    private String ticketQty;
    private String ticketDate;
    private String ticketTime;
    private String ticketStatus;
    private String ticketLocation;
}
