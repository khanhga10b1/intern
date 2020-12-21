package service;

import java.util.List;

import entities.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();
	void addTicket(Ticket ticket);
	void deleteTicket(Ticket ticket);
}
