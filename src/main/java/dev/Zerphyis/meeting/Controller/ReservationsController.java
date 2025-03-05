package dev.Zerphyis.meeting.Controller;

import dev.Zerphyis.meeting.Entity.Records.DataReservations;
import dev.Zerphyis.meeting.Entity.Records.PersoNameResponse;
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
        public ResponseEntity<PersoNameResponse> createReservation(@RequestBody DataReservations data) {
            Reservations reservation = reservationsService.createReservation(data);
            PersoNameResponse response = reservation.getReservistName();
            return ResponseEntity.status(201).body(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Reservations> getReservation(@PathVariable String id) {
            Reservations reservation = reservationsService.getReservationById(id);
            return ResponseEntity.ok(reservation);
        }

        @GetMapping()
        public ResponseEntity<List<Reservations>> listAllRooms() {
            return ResponseEntity.ok(reservationsService.listAll());
        }

    @PutMapping("/{id}")
    public ResponseEntity<PersoNameResponse> updateReservation(@PathVariable String id, @RequestBody DataReservations data) {
        Reservations reservation = reservationsService.updateReservation(id, data);
        PersoNameResponse response = reservation.getReservistName(); // Pega o nome do reservista
        return ResponseEntity.ok(response); // Retorna apenas o nome
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
            reservationsService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        }
    }

