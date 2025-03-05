package dev.Zerphyis.meeting.Repositorys;

import dev.Zerphyis.meeting.Entity.Room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByResourcesContainingIgnoreCase(String resource);
}
