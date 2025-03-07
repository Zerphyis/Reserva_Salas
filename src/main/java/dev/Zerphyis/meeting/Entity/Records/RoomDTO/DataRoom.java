package dev.Zerphyis.meeting.Entity.Records.RoomDTO;



import java.util.List;

public record DataRoom(String name,
                       Integer capacity,
                       List<String> resources) {
}
