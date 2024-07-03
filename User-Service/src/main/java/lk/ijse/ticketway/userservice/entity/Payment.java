package lk.ijse.ticketway.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author : savindaJ
 * @date : 2024-06-24
 * @since : 0.1.0
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentId;
    private String paymentType;
    private String paymentAmount;
    private String paymentDate;
    private String paymentTime;
    private String paymentStatus;
    private String paymentLocation;
    private Date date;

    @OneToOne(mappedBy = "payment")
    private Ticket ticket;
}
