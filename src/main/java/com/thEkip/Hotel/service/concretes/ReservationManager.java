package com.thEkip.Hotel.service.concretes;

import com.thEkip.Hotel.dao.ReservationRepository;
import com.thEkip.Hotel.entities.Reservation;
import com.thEkip.Hotel.exceptionHandler.hotelExceptions.EntityNotFoundException;
import com.thEkip.Hotel.service.abstracts.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationManager implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getOneReservationByReservationId(long reservationId) {

        return reservationRepository.findById(reservationId).orElseThrow(()-> new EntityNotFoundException());
    }



    @Override
    public List<Reservation> getAllReservationsByDate(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();
        return reservationRepository.findAllByStartDateBeforeAndEndDateAfter(now, now);
    }
}
