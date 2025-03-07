package dev.Zerphyis.meeting.Entity.Records.PersonDTO;

public class PersoNameResponse {

    private String name;

    // Construtor que recebe o nome do reservista
    public PersoNameResponse(String name) {
        this.name = name;
    }

    // Getter para o nome do reservista
    public String getName() {
        return name;
    }

    // Setter para o nome do reservista
    public void setName(String name) {
        this.name = name;
    }
}