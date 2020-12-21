package service;

import java.util.List;

import dao.TicketDao;
import dao.TicketDaoImpl;
import entities.Ticket;

public class TicketServiceImpl implements TicketService {

	private final TicketDao dao;
	
	public TicketServiceImpl() {
		dao = new TicketDaoImpl();
	}
	
	@Override
	public List<Ticket> getAllTickets() {
		return dao.getAllTickets();
	}

	@Override
	public void addTicket(Ticket ticket) {
		dao.addTicket(ticket);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		dao.deleteTicket(ticket);
	}

}
