package dev.Zerphyis.meeting.Controller;

import dev.Zerphyis.meeting.Entity.Records.ReservationsDTo.DataReservations;
import dev.Zerphyis.meeting.Entity.Records.ReservationsDTo.ReservationsResponse;
import dev.Zerphyis.meeting.Entity.Reservations.Reservations;
import dev.Zerphyis.meeting.Service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservationsController {
        @Autowired
        private ReservationsService reservationsService;

    @PostMapping()
    public ResponseEntity<ReservationsResponse> createReservation(@RequestBody DataReservations data) {
        Reservations reservation = reservationsService.createReservation(data);

        ReservationsResponse response = new ReservationsResponse(
                reservation.getRoom().getId(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getStatus(),
                reservation.getReservistName()
        );

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationsResponse> getReservation(@PathVariable String id) {
        Reservations reservation = reservationsService.getReservationById(id);

        ReservationsResponse response = new ReservationsResponse(
                reservation.getRoom().getId(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getStatus(),
                reservation.getReservistName()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<ReservationsResponse>> listAllReservations() {
        List<ReservationsResponse> response = reservationsService.listAll().stream()
                .map(reservation -> new ReservationsResponse(
                        reservation.getRoom().getId(),
                        reservation.getDate(),
                        reservation.getTime(),
                        reservation.getStatus(),
                        reservation.getReservistName()
                ))
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationsResponse> updateReservation(@PathVariable String id, @RequestBody DataReservations data) {
        Reservations reservation = reservationsService.updateReservation(id, data);

        ReservationsResponse response = new ReservationsResponse(
                reservation.getRoom().getId(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getStatus(),
                reservation.getReservistName()
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        reservationsService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
    }


