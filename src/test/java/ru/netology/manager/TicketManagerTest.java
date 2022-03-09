package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 50_000, "LED", "CCC", 720);
    Ticket ticket2 = new Ticket(2, 30_000, "SVO", "VRA", 600);
    Ticket ticket3 = new Ticket(3, 35_000, "SVO", "CCC", 660);
    Ticket ticket4 = new Ticket(4, 21_000, "LED", "CCC", 750);
    Ticket ticket5 = new Ticket(5, 75_000, "LED", "CCC", 800);
    Ticket ticket6 = new Ticket(6, 100_000, "SVO", "CCC", 611);



    @Test
    public void shouldSearchIfNoMatches() {

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        String from = "DME";
        String to = "HAV";

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(actual, expected);


    }

    @Test
    public void shouldSearchIfFromOnlyMatches() {

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        String from = "LED";
        String to = "HAV";

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(actual, expected);


    }
    @Test
    public void shouldSearchIfToOnlyMatches() {

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        String from = "DME";
        String to = "CCC";

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchIfIsOneMatch() {

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        String from = "SVO";
        String to = "VRA";

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll(from, to);

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchIfIsSeveralMatches() {

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        String from = "LED";
        String to = "CCC";

        Ticket[] expected = {ticket4, ticket1, ticket5};
        Ticket[] actual = manager.findAll(from, to);



        assertArrayEquals(actual, expected);
    }

}