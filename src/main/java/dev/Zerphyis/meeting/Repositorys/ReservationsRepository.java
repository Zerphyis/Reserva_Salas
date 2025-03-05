package dev.Zerphyis.meeting.Repositorys;

import dev.Zerphyis.meeting.Entity.Reservations.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository  extends JpaRepository<Reservations, String> {
}
