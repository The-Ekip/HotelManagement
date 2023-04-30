package com.thEkip.Hotel.service.abstracts;

import com.thEkip.Hotel.entities.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ReservationService  {
    List<Reservation> getAllReservations();

    Reservation getOneReservationByReservationId(long reservationId);

    List<Reservation> getAllReservationsByDate(LocalDateTime date);
}
