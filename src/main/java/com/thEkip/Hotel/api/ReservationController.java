package com.thEkip.Hotel.api;

import com.thEkip.Hotel.entities.Reservation;
import com.thEkip.Hotel.service.abstracts.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations () {
       return  reservationService.getAllReservations();
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

}
