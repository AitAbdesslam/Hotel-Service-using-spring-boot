package com.aitabdesslam.hotelservice.service;

import com.aitabdesslam.hotelservice.dto.RoomDTO;
import com.aitabdesslam.hotelservice.exceptions.DuplicateRoomException;
import com.aitabdesslam.hotelservice.exceptions.RoomNotFoundException;

import java.util.List;

public interface IRoomService {
    RoomDTO addRoom(RoomDTO room) throws DuplicateRoomException;
    RoomDTO updateRoom(RoomDTO room) throws RoomNotFoundException;
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomByNumber(String roomNumber) throws RoomNotFoundException;
    void deleteRoomById(Long id) throws RoomNotFoundException;

    RoomDTO findById(Long id) throws RoomNotFoundException;
}
