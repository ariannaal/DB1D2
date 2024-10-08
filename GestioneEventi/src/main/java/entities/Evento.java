package entities;

import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {

    @Id // chiave primaria
    @Column(name = "id")
    private int id;

    @Column(name = "titolo")
    private String title;

    @Column(name = "data_evento")
    private LocalDate eventDate;

    @Column(name = "descrizione")
    private String eventDescription;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipo_evento;

    @Column(name = "n_massimo_partecipanti")
    private int n_massimo_partecipanti;
    
    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

//    @Column(name = "data_evento")
//    private LocalDate dataEvento;
//
//    @Column(name = "descrizione")
//    private String descrizione;
//
//    @Column(name = "tipo_evento")
//    @Enumerated(EnumType.STRING)
//    private TipoEvento tipoEvento;
//
//    @Column(name = "n_massimo_partecipanti")
//    private int numeroMassimoPartecipanti;
//
//    @Column(name = "id_location")
//    private int id_location;

//    @OneToOne
//    @JoinColumn(name = "id_location")
//    private Location location;
//
//
//    @OneToMany(mappedBy = "evento")
//    private List<Partecipazione> partecipazioni;


    // costruttore vuoto obbligatorio per leggere la tabella

    public Evento() {
    }

    public Evento(String title, LocalDate eventDate, String eventDescription, TipoEvento tipo_evento, int n_massimo_partecipanti, Location location) {
        this.title = title;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.tipo_evento = tipo_evento;
        this.n_massimo_partecipanti = n_massimo_partecipanti;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }


    public int getMaxParticipants() {
        return n_massimo_partecipanti;
    }

    public void setMaxParticipants(int n_massimo_partecipanti) {
        this.n_massimo_partecipanti = n_massimo_partecipanti;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", eventDescription='" + eventDescription + '\'' +
                ", maxParticipants=" + n_massimo_partecipanti +
                '}';
    }
}
