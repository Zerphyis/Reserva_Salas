package dev.Zerphyis.meeting.Entity.Records;



import java.util.List;

public record DataRoom(String name,
                       Integer capacity,
                       List<String> resources) {
}
