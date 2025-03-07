package dev.Zerphyis.meeting.Controller;

import dev.Zerphyis.meeting.Entity.Records.RoomDTO.DataRoom;
import dev.Zerphyis.meeting.Entity.Room.Room;
import dev.Zerphyis.meeting.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class RoomController {
    @Autowired
    private RoomService service;

    @PostMapping()
    public ResponseEntity<Room> registerRoom(@RequestBody DataRoom data) {
        return ResponseEntity.ok(service.registerRoom(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody DataRoom data) {
        return ResponseEntity.ok(service.atualizationRoom(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        service.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Room>> listAllRooms() {
        return ResponseEntity.ok(service.ListAll());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Room>> listRoomsByResource(@RequestParam String recurso) {
        return ResponseEntity.ok(service.findRoomsByResource(recurso));
    }
}
