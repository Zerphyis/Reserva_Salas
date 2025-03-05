package dev.Zerphyis.meeting.Service;

import dev.Zerphyis.meeting.Entity.Records.DataRoom;
import dev.Zerphyis.meeting.Entity.Room.Room;
import dev.Zerphyis.meeting.Repositorys.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository repository;


    public Room registerRoom(DataRoom data) {
        var newRoom = new Room(data);
        return repository.save(newRoom);
    }

    public Room atualizationRoom(Long id, DataRoom data) {
        Optional<Room> optinalRoom = repository.findById(id);
        if (optinalRoom.isPresent()) {
            Room attRoom = optinalRoom.get();
            attRoom.setName(data.name());
            attRoom.setCapacity(data.capacity());
            attRoom.setResources(data.resources());
            return repository.save(attRoom);
        } else {
            throw new RuntimeException("Sala não encontrado com o ID: " + id);
        }
    }

    public void deleteRoom(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Sala não encontrado com o ID: " + id);
        }
    }

    public List<Room> ListAll(){
        return repository.findAll();
    }
    public List<Room> findRoomsByResource(String resource) {
        return repository.findByResourcesContainingIgnoreCase(resource);
    }
}
