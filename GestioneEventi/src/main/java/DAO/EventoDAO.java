package DAO;

import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    // costruttore

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        // scrivo transazione
        EntityTransaction transaction = em.getTransaction();
        // faccio partire la transazione
        transaction.begin();
        //aggiungo evento al persistence context
        em.persist(evento);
        //evento viene salvato al concludersi della transazione
        transaction.commit();

        System.out.println("L'evento " + evento.getTitolo() + " e' stato salvato con successo!");
    }
}
