package com.thEkip.Hotel.service.abstracts;

import com.thEkip.Hotel.api.dto.reponses.ReservationAddResponse;
import com.thEkip.Hotel.entities.Reservation;
import com.thEkip.Hotel.service.dto.reponses.ReservationServiceAddResponse;
import com.thEkip.Hotel.service.dto.requests.ReservationServiceAddRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ReservationService  {
    List<Reservation> getAllReservations();

    Reservation getOneReservationByReservationId(long reservationId);

    List<Reservation> getAllReservationsByDate(LocalDateTime date);

    ReservationServiceAddResponse createNewReservation(ReservationServiceAddRequest request);
}
