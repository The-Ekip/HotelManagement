package com.thEkip.Hotel.service.dto.reponses;

import com.thEkip.Hotel.entities.Customer;
import com.thEkip.Hotel.entities.Reservation;
import com.thEkip.Hotel.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReservationServiceAddResponse {
    private long reservationId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Room room;
    private Customer customer;

    public static ReservationServiceAddResponse responseFromEntityToServiceDto( Reservation reservation ) {
        return  new ReservationServiceAddResponse( reservation.getReservationId(),reservation.getStartDate(),
                reservation.getEndDate(),reservation.getRoom(),reservation.getCustomer());
    }
}
