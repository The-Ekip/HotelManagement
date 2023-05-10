package com.thEkip.Hotel.service.concretes;

import com.thEkip.Hotel.dao.ReservationRepository;
import com.thEkip.Hotel.entities.Customer;
import com.thEkip.Hotel.entities.Reservation;
import com.thEkip.Hotel.entities.Room;
import com.thEkip.Hotel.exceptionHandler.hotelExceptions.BusinessRuleException;
import com.thEkip.Hotel.exceptionHandler.hotelExceptions.EntityNotFoundException;
import com.thEkip.Hotel.service.abstracts.CustomerService;
import com.thEkip.Hotel.service.abstracts.ReservationService;
import com.thEkip.Hotel.service.abstracts.RoomService;
import com.thEkip.Hotel.service.dto.reponses.ReservationServiceAddResponse;
import com.thEkip.Hotel.service.dto.requests.ReservationServiceAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationManager implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerService customerService;
    private final RoomService roomService;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getOneReservationByReservationId(long reservationId) {

        return reservationRepository.findById(reservationId).orElseThrow(()-> new EntityNotFoundException("reservation"));
    }

    @Override
    public List<Reservation> getAllReservationsByDate(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();
        return reservationRepository.findAllByStartDateBeforeAndEndDateAfter(now, now);
    }

    // TODO TEKRAR BAK
    @Override
    public ReservationServiceAddResponse createNewReservation(ReservationServiceAddRequest request) {
        Customer newCustomer = customerService.getOneCustomer(request.getCustomerId());
        Room newRoom = roomService.getOneRoomById(request.getRoomId());

        boolean isRoomAvailable= IsRoomAvailable(request.getRoomId(),request.getStartDate(),request.getEndDate());

        if(!isRoomAvailable){
            String format = request.getStartDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
            throw new BusinessRuleException(String.format("Room is not available between %s", format));
        }
        Reservation newReservation = new Reservation();
        newReservation.setCustomer(newCustomer);
        newReservation.setRoom(newRoom);
        newReservation.setStartDate(request.getStartDate());
        newReservation.setEndDate(request.getEndDate());
        Reservation save = reservationRepository.save(newReservation);
        ReservationServiceAddResponse reservationServiceAddResponse = ReservationServiceAddResponse.
                responseFromEntityToServiceDto(save);

        return reservationServiceAddResponse ;
    }



    @Override
    public void deleteById(long reservationId) {
        Reservation byReservationId = this.getOneReservationByReservationId(reservationId);
        reservationRepository.deleteById(reservationId);
    }
    private boolean IsRoomAvailable(long roomId, LocalDateTime startDate, LocalDateTime endDate) {
        Room newRoom = roomService.getOneRoomById(roomId);
        List<Reservation> reservations = reservationRepository.findAllByStartDateBeforeAndEndDateAfter(startDate, endDate);

        boolean isReservationExist=reservations.stream().anyMatch(x->x.getRoom().getRoomId()==newRoom.getRoomId());

        return  !isReservationExist;
    }


}
