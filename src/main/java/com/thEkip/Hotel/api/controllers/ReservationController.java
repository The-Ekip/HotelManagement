package com.thEkip.Hotel.api.controllers;

import com.thEkip.Hotel.api.dto.reponses.ReservationAddResponse;
import com.thEkip.Hotel.api.dto.requests.ReservationAddRequest;
import com.thEkip.Hotel.entities.Reservation;
import com.thEkip.Hotel.service.abstracts.ReservationService;
import com.thEkip.Hotel.service.dto.reponses.ReservationServiceAddResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity getAllReservations () {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
    @GetMapping("/{reservationId}")
    public Reservation getOneReservationById(@PathVariable long reservationId) {
        return reservationService.getOneReservationByReservationId(reservationId);
    }

    //TODO sonra tekrar bakılacak
    @GetMapping("/date")
    public List<Reservation> getAllReservationsByDate(){
        LocalDateTime date= LocalDateTime.now();
        return reservationService.getAllReservationsByDate(date);
    }

    @PostMapping
    public ResponseEntity addOneReservation(@RequestBody ReservationAddRequest request) {
        ReservationServiceAddResponse newReservation = reservationService.createNewReservation(request.responseToReservationServiceAddRequest());
        ReservationAddResponse reservationAddResponse = ReservationAddResponse.responseFromServiceToDto(newReservation);
        return ResponseEntity.ok(reservationAddResponse);
    }
}
