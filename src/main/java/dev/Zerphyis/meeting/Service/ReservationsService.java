package dev.Zerphyis.meeting.Service;

import dev.Zerphyis.meeting.Entity.Records.DataReservations;
import dev.Zerphyis.meeting.Entity.Reservations.Reservations;
import dev.Zerphyis.meeting.Repositorys.PersonRepository;
import dev.Zerphyis.meeting.Repositorys.ReservationsRepository;
import dev.Zerphyis.meeting.Repositorys.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PersonRepository personRepository;

    public Reservations createReservation(DataReservations data) {
        return reservationsRepository.save(new Reservations(data, roomRepository, personRepository));
    }

    public Reservations getReservationById(String id) {
        return reservationsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
    }

    public Reservations updateReservation(String id, DataReservations data) {
        Reservations reservation = getReservationById(id);
        reservation.setRoom(roomRepository.findById(Long.valueOf(data.roomId())).orElseThrow(() -> new IllegalArgumentException("Room not found")));
        reservation.setReservist(personRepository.findById(Long.valueOf(data.reservistId())).orElseThrow(() -> new IllegalArgumentException("Person not found")));
        reservation.setDate(data.date());
        reservation.setTime(data.time());
        reservation.setStatus(data.status());
        return reservationsRepository.save(reservation);
    }

    public List<Reservations>listAll(){
        return reservationsRepository.findAll();
    }

    public void deleteReservation(String id) {
        Reservations reservation = getReservationById(id);
        reservationsRepository.delete(reservation);
    }
}
