package com.aitabdesslam.hotelservice.dto;

import com.aitabdesslam.hotelservice.entities.Client;
import com.aitabdesslam.hotelservice.entities.Room;
import com.aitabdesslam.hotelservice.enums.ReservationStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class ReservationDTO {
    private Long id;
    private LocalDate checkIN;
    private LocalDate checkOUT;
    //    private double totalCost;
    private ReservationStatus status;
    private ClientDTO clientDTO;
    private RoomDTO roomDTO;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationDTO)) return false;
        ReservationDTO that = (ReservationDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
