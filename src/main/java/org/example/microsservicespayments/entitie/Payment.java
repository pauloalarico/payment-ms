package org.example.microsservicespayments.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.microsservicespayments.dto.request.NewPaymentDTO;
import org.example.microsservicespayments.enums.Status;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Table(name = "ms_payments")
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cd_idnt_payment", unique = true)
    private UUID paymentId;
    @Column(name = "cd_idnt_order", unique = true)
    private UUID orderId;
    @Column(name = "vl_payment")
    private BigDecimal amount;
    @Column(name = "cd_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Payment(NewPaymentDTO dto) {
        this.orderId = dto.orderId();
        this.amount = dto.amount();
        this.status = Status.APPROVED;
    }

    public void declineTransaction() {
        this.status = Status.REJECTED;
    }
}
