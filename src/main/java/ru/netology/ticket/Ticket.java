package ru.netology.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int flightDuration;


    @Override
    public int compareTo(Ticket ticket) {
        return this.price - ticket.price;
    }
}
