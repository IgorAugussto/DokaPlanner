package com.doka.organizer.controller;

import com.doka.organizer.entity.Reservation;
import com.doka.organizer.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Criar uma nova reserva
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    // Listar todas as reservas
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // Obter reservas por data
    @GetMapping("/by-date")
    public List<Reservation> getReservationsByDate(@RequestParam LocalDate date) {
        return reservationService.getReservationsByDate(date);
    }

    // Atualizar uma reserva
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(
            @PathVariable Long id, @RequestBody Reservation updatedReservation) {
        return reservationService.updateReservation(id, updatedReservation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        if (reservationService.deleteReservation(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
