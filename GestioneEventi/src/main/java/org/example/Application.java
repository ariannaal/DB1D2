package org.example;

import DAO.EventoDAO;
import entities.Evento;
import enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D2");

    public static void main(String[] args) {

        try {
            EntityManager em = emf.createEntityManager();
            Evento evento = new Evento(5, "Cena", LocalDate.of(2024, 4, 1), "degustazione", TipoEvento.PRIVATO, 10);
            EventoDAO ed = new EventoDAO(em);
            ed.save(evento);
            Evento evento1 = new Evento(6, "Proiezione film", LocalDate.of(2023, 1, 1), "film sci-fi", TipoEvento.PUBBLICO, 60);
            ed.save(evento1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
