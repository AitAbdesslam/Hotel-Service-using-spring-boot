//package com.aitabdesslam.hotelservice;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import com.aitabdesslam.hotelservice.dto.ClientDTO;
//import com.aitabdesslam.hotelservice.dto.ReservationDTO;
//import com.aitabdesslam.hotelservice.dto.RoomDTO;
//import com.aitabdesslam.hotelservice.entities.Client;
//import com.aitabdesslam.hotelservice.entities.Reservation;
//import com.aitabdesslam.hotelservice.entities.Room;
//import com.aitabdesslam.hotelservice.exceptions.ClientNotFoundException;
//import com.aitabdesslam.hotelservice.exceptions.ClientSaveException;
//import com.aitabdesslam.hotelservice.exceptions.ReservationNotFoundException;
//import com.aitabdesslam.hotelservice.exceptions.RoomNotAvailableException;
//import com.aitabdesslam.hotelservice.exceptions.RoomNotFoundException;
//import com.aitabdesslam.hotelservice.mappers.ClientMapper;
//import com.aitabdesslam.hotelservice.mappers.ReservationMapper;
//import com.aitabdesslam.hotelservice.mappers.RoomMapper;
//import com.aitabdesslam.hotelservice.repositories.ClientRepository;
//import com.aitabdesslam.hotelservice.repositories.ReservationRepository;
//import com.aitabdesslam.hotelservice.repositories.RoomRepository;
//import com.aitabdesslam.hotelservice.service.IReservationService;
//import com.aitabdesslam.hotelservice.service.ReservationServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class ReservationServiceImplTest {
//
//    @Mock
//    private RoomRepository roomRepository;
//
//    @Mock
//    private ReservationRepository reservationRepository;
//
//    @Mock
//    private RoomMapper roomMapper;
//
//    @Mock
//    private ReservationMapper reservationMapper;
//
//    @Mock
//    private ClientMapper clientMapper;
//
//    @Mock
//    private ClientRepository clientRepository;
//
//    @InjectMocks
//    private ReservationServiceImpl reservationService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testIsRoomAvailable_ReturnsTrue_WhenRoomIsAvailable() {
//        // Mocking the RoomDTO and Room entity
//        RoomDTO roomDTO = new RoomDTO();
//        roomDTO.setId(1L);
//
//        // Create a mock Room with a known ID for testing
//        Room room = new Room();
//        room.setId(1L);
//
//        when(roomMapper.fromRoomDTO(roomDTO)).thenReturn(room);
//        when(reservationRepository.findOverlappingReservations(eq(room.getId()), any(LocalDate.class), any(LocalDate.class)))
//                .thenReturn(new ArrayList<>());
//
//        // Test Data
//        LocalDate checkin = LocalDate.of(2023, 8, 1);
//        LocalDate checkout = LocalDate.of(2023, 8, 5);
//
//        // Perform the test
//        boolean isAvailable = reservationService.isRoomAvailable(roomDTO, checkin, checkout);
//
//        // Assertion
//        Assertions.assertTrue(isAvailable, "The room should be available.");
//    }
//
//    @Test
//    public void testIsRoomAvailable_ReturnsFalse_WhenRoomIsNotAvailable() {
//        // Arrange
//        RoomDTO roomDTO = new RoomDTO();
//        roomDTO.setId(1L);
//
//        LocalDate checkin = LocalDate.of(2023, 8, 1);
//        LocalDate checkout = LocalDate.of(2023, 8, 5);
//
//        Room room = new Room();
//        room.setId(1L);
//
//        List<Reservation> overlappingReservations = new ArrayList<>();
//        overlappingReservations.add(new Reservation());
//
//        when(roomMapper.fromRoomDTO(roomDTO)).thenReturn(room);
//        when(reservationRepository.findOverlappingReservations(1L, checkin, checkout)).thenReturn(overlappingReservations);
//
//        // Act
//        boolean isAvailable = reservationService.isRoomAvailable(roomDTO, checkin, checkout);
//
//        // Assert
//        assertFalse(isAvailable);
//    }
//
//    @Test
//    public void testMakeReservation_ThrowsRoomNotAvailableException_WhenRoomIsNotAvailable() {
//        // Create a RoomDTO for testing
//        RoomDTO roomDTO = new RoomDTO();
//        roomDTO.setId(1L);
//        roomDTO.setRoomNumber("101");
//
//        // Create an instance of the actual RoomMapper (not a mock)
//        RoomMapper roomMapper = new RoomMapper();
//
//        // Call the method to map RoomDTO to Room
//        Room room = roomMapper.fromRoomDTO(roomDTO);
//
//        // Set up the ReservationRepository mock
//        when(reservationRepository.findOverlappingReservations(any(Long.class), any(LocalDate.class), any(LocalDate.class)))
//                .thenReturn(new ArrayList<>()); // Assuming an empty list means no overlapping reservations
//
//        // Perform the test
//        LocalDate checkINDate = LocalDate.now().plusDays(1);
//        LocalDate checkOUTDate = LocalDate.now().plusDays(3);
//
//        assertThrows(RoomNotAvailableException.class, () -> {
//            reservationService.makeReservation(new ClientDTO(),roomDTO, checkINDate, checkOUTDate);
//        });
//    }
//
//        @Test
//    public void testMakeReservation_ThrowsRoomNotFoundException_WhenRoomNotFound() {
//        // Arrange
//        ClientDTO clientDTO = new ClientDTO();
//        clientDTO.setId(1L);
//
//        RoomDTO roomDTO = new RoomDTO();
//        roomDTO.setId(1L);
//
//        LocalDate checkin = LocalDate.of(2023, 8, 1);
//        LocalDate checkout = LocalDate.of(2023, 8, 5);
//
//        when(roomRepository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        assertThrows(RoomNotFoundException.class, () -> {
//            reservationService.makeReservation(clientDTO, roomDTO, checkin, checkout);
//        });
//    }
//
//    // Add more test cases for other methods in the ReservationServiceImpl class as needed.
//
//}
