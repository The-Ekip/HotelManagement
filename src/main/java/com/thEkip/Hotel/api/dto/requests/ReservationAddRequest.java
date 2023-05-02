package com.thEkip.Hotel.api.dto.requests;

import com.thEkip.Hotel.api.dto.reponses.ReservationAddResponse;
import com.thEkip.Hotel.service.dto.reponses.ReservationServiceAddResponse;
import com.thEkip.Hotel.service.dto.requests.ReservationServiceAddRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public  class ReservationAddRequest {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private long roomId;

    private long customerId;

    public ReservationServiceAddRequest responseToReservationServiceAddRequest() {
        return  new ReservationServiceAddRequest(this.customerId,this.roomId,this.endDate,this.startDate);

    }

}