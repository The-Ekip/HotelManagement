package com.thEkip.Hotel.service.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReservationServiceAddRequest {

    private long customerId;
    private long roomId;
    private LocalDateTime endDate;
    private LocalDateTime startDate;



}
