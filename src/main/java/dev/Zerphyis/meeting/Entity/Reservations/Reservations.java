package dev.Zerphyis.meeting.Entity.Reservations;

import dev.Zerphyis.meeting.Entity.Person.Person;
import dev.Zerphyis.meeting.Entity.Records.ReservationsDTo.DataReservations;
import dev.Zerphyis.meeting.Entity.Room.Room;
import dev.Zerphyis.meeting.Repositorys.PersonRepository;
import dev.Zerphyis.meeting.Repositorys.RoomRepository;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "tb_reservas")
@Entity
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime time;
    private TypeStatus status;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "reservist_id")
    private Person reservist;

    @Transient
    private String reservistName;

    @Transient
    private  RoomRepository roomRepository;

    @Transient
    private  PersonRepository personRepository;

    public String getReservistName() {
        if (this.reservist != null) {
            return this.reservist.getName();
        }
        return null;
    }
  public Reservations(){

  }
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReservistName(String reservistName) {
        this.reservistName = reservistName;
    }

    public TypeStatus getStatus() {
        return status;
    }

    public void setStatus(TypeStatus status) {
        this.status = status;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public void setReservist(Person reservist) {
        this.reservist = reservist;
    }
}
