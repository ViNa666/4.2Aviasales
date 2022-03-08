package ru.netology.manager;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor

public class TicketManager {
    private TicketRepository repository;

    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repository.getAll()) {
            if (matches(item, from, to)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;


                result = tmp;
                Arrays.sort(tmp);

            }
        }
        return result;

    }


    public boolean matches(Ticket item, String searchFrom, String searchTo) {
        return item.getDepartureAirport().contains(searchFrom) & item.getArrivalAirport().contains(searchTo);

    }
}

