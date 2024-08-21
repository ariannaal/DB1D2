package entities;

import enums.Stato;
import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    private int id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "persona_id")
    private Persona persona;


    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Column(name = "stato_partecipazione")
    private Stato stato_partecipazione;

    public Partecipazione() {
    }

    public Partecipazione(int id, Persona persona, Evento evento, Stato stato_partecipazione) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.stato_partecipazione = stato_partecipazione;
    }

    public int getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato_partecipazione() {
        return stato_partecipazione;
    }

    public void setStato_partecipazione(Stato stato_partecipazione) {
        this.stato_partecipazione = stato_partecipazione;
    }
}
