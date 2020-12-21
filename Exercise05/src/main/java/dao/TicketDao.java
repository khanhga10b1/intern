package dao;

import java.util.List;

import entities.Ticket;

public interface TicketDao {
	List<Ticket> getAllTickets();
	void addTicket(Ticket ticket);
	void deleteTicket(Ticket ticket);
}
