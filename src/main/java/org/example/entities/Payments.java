package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "payments")
@Data
@ToString(callSuper = true)
public class Payments extends BaseEntities{
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
