package com.thEkip.Hotel.api.dto.responses;

import com.thEkip.Hotel.entities.Customer;
import com.thEkip.Hotel.entities.Room;
import com.thEkip.Hotel.service.dto.reponses.ReservationServiceAddResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReservationAddResponse {

    private long reservationId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Room room;
    private Customer customer;

    public static ReservationAddResponse responseFromServiceToDto(ReservationServiceAddResponse response ) {
        ReservationAddResponse rsa =  new ReservationAddResponse( response.getReservationId(),response.getStartDate(),
                                            response.getEndDate(),response.getRoom(),response.getCustomer());
        return rsa;
    }


}
