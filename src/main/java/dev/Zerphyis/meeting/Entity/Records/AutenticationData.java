package dev.Zerphyis.meeting.Entity.Records;

import dev.Zerphyis.meeting.Entity.Person.TypeRole;

public record AutenticationData(String name, String email, String password, TypeRole role) {
}

