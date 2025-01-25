package com.doka.organizer.service;

import com.doka.organizer.entity.Ministry;
import com.doka.organizer.entity.Reservation;
import com.doka.organizer.entity.Room;
import com.doka.organizer.repository.MinistryRepository;
import com.doka.organizer.repository.ReservationRepository;
import com.doka.organizer.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MinistryRepository ministryRepository;

    // Criar ou salvar uma reserva
    public Reservation saveReservation(Reservation reservation) {
        // Buscar o Ministry pelo nome e associar à reserva
        Ministry ministry = ministryRepository.findByName(reservation.getMinistry().getName())
                .orElseThrow(() -> new RuntimeException("Ministry not found: " + reservation.getMinistry().getName()));
        reservation.setMinistry(ministry);

        // Buscar o Room pelo nome e associar à reserva
        Room room = roomRepository.findByName(reservation.getRoom().getName())
                .orElseThrow(() -> new RuntimeException("Room not found: " + reservation.getRoom().getName()));
        reservation.setRoom(room);

        // Salvar a reserva
        return reservationRepository.save(reservation);
    }

    // Buscar todas as reservas
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Buscar reservas por data
    public List<Reservation> getReservationsByDate(LocalDate date) {
        return reservationRepository.findByDate(date);
    }

    // Buscar uma reserva pelo ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Atualizar uma reserva
    public Optional<Reservation> updateReservation(Long id, Reservation updatedReservation) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setRoom(updatedReservation.getRoom());
            reservation.setMinistry(updatedReservation.getMinistry());
            reservation.setDate(updatedReservation.getDate());
            reservation.setStartTime(updatedReservation.getStartTime());
            reservation.setEndTime(updatedReservation.getEndTime());
            return reservationRepository.save(reservation);
        });
    }

    // Deletar uma reserva pelo ID
    public boolean deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
