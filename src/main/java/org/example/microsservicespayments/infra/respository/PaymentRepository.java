package org.example.microsservicespayments.infra.respository;

import org.example.microsservicespayments.model.entitie.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    @Query("""
            SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END
            FROM Payment p
            WHERE p.paymentId = :id
            """)
    boolean hasPaymentForId(@Param("id") UUID id);

    @Query("SELECT p from Payment p WHERE p.paymentId = :id")
    Optional<Payment> findPaymentById (@Param("id") UUID id);
}
