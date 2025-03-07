package dev.Zerphyis.meeting.Entity.Records.ReservationsDTo;

import dev.Zerphyis.meeting.Entity.Reservations.TypeStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record DataReservations(String roomId,
                               String reservistId,
                               LocalDate date,
                               LocalTime time,
                               TypeStatus status) {
}
