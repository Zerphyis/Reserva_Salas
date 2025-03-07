package dev.Zerphyis.meeting.Entity.Records.ReservationsDTo;

import dev.Zerphyis.meeting.Entity.Reservations.TypeStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationsResponse {
        private Long roomId;
        private LocalDate date;
        private LocalTime time;
        private TypeStatus status;
        private String reservistName;

        public ReservationsResponse(Long roomId, LocalDate date, LocalTime time, TypeStatus status, String reservistName) {
            this.roomId = roomId;
            this.date = date;
            this.time = time;
            this.status = status;
            this.reservistName = reservistName;
        }

        public Long getRoomId() {
            return roomId;
        }

        public LocalDate getDate() {
            return date;
        }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public TypeStatus getStatus() {
        return status;
    }

    public void setStatus(TypeStatus status) {
        this.status = status;
    }

    public void setReservistName(String reservistName) {
        this.reservistName = reservistName;
    }

    public String getReservistName() {
            return reservistName;
        }
    }


