package com.thEkip.Hotel.api.controllers;

import com.thEkip.Hotel.api.dto.responses.ReservationAddResponse;
import com.thEkip.Hotel.api.dto.requests.ReservationAddRequest;
import com.thEkip.Hotel.entities.Reservation;
import com.thEkip.Hotel.service.abstracts.ReservationService;
import com.thEkip.Hotel.service.dto.reponses.ReservationServiceAddResponse;
import com.thEkip.Hotel.utilities.response.ErrorResponse;
import com.thEkip.Hotel.utilities.response.Response;
import com.thEkip.Hotel.utilities.response.SuccessDataResponse;
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
        return ResponseEntity.ok(new SuccessDataResponse("Successfully Reservations Listed", reservations));
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity getOneReservationById(@PathVariable long reservationId) {
        Reservation byReservationId = reservationService.getOneReservationByReservationId(reservationId);
        return ResponseEntity.ok(new SuccessDataResponse("Successfully Reservations Listed",byReservationId));
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
        return ResponseEntity.ok(new SuccessDataResponse("Successfully Reservations Listed",reservationAddResponse));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity addOneReservation(@PathVariable long reservationId) {
        reservationService.deleteById(reservationId);
        return ResponseEntity.ok(new Response("Successfully Reservation Deleted",true));
    }

}
