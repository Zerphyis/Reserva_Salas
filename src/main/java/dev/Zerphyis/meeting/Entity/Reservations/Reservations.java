package dev.Zerphyis.meeting.Entity.Reservations;

import dev.Zerphyis.meeting.Entity.Person.Person;
import dev.Zerphyis.meeting.Entity.Records.DataReservations;
import dev.Zerphyis.meeting.Entity.Records.PersoNameResponse;
import dev.Zerphyis.meeting.Entity.Room.Room;
import dev.Zerphyis.meeting.Repositorys.PersonRepository;
import dev.Zerphyis.meeting.Repositorys.RoomRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "tb_reservas")
@Entity
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Person reservist;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    private TypeStatus status;

    @Transient
    private final RoomRepository roomRepository;

    @Transient
    private final PersonRepository personRepository;

    public Reservations(RoomRepository roomRepository, PersonRepository personRepository) {
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
    }

    public Reservations(DataReservations data, RoomRepository roomRepository, PersonRepository personRepository) {
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;

        this.room = roomRepository.findById(Long.valueOf(data.roomId())).orElseThrow(() -> new IllegalArgumentException("Room not found"));

        this.reservist = personRepository.findById(Long.valueOf(data.reservistId())).orElseThrow(() -> new IllegalArgumentException("Person not found"));

        this.date = data.date();
        this.time = data.time();
        this.status = data.status();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Person getReservist() {
        return reservist;
    }
    public PersoNameResponse getReservistName() {
        return new PersoNameResponse(this.reservist.getName());
    }

    public void setReservist(Person reservist) {
        this.reservist = reservist;
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
}
