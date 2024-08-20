package org.example;

import DAO.EventoDAO;
import entities.Evento;
import enums.TipoEvento;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D2");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        // save
        try {
            Evento evento = new Evento(7, "Cena", LocalDate.of(2024, 4, 1), "degustazione", TipoEvento.PRIVATO, 10);
            ed.save(evento);
            Evento evento1 = new Evento(8, "Proiezione film", LocalDate.of(2023, 1, 1), "film sci-fi", TipoEvento.PUBBLICO, 60);
            ed.save(evento1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //find by
        try {
            Evento aldoFromDb = ed.findById(7);
            System.out.println(aldoFromDb);
        } catch (NotFoundEx ex) {
            System.out.println(ex.getMessage());
        }

        //delete
        try {
            ed.findByIdAndDelete(8);
        } catch (NotFoundEx ex) {
            System.out.println(ex.getMessage());
        }

    }
}
