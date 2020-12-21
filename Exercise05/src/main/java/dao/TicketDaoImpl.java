package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import entities.Ticket;

public class TicketDaoImpl implements TicketDao {
	
	private static final Map<String,Ticket> ticketMap = new HashMap<>();
	

	@Override
	public List<Ticket> getAllTickets() {	
		return new ArrayList<>(ticketMap.values());
	}


	@Override
	public void addTicket(Ticket ticket) {
		ticketMap.put(ticket.getId(),ticket);
	}


	@Override
	public void deleteTicket(Ticket ticket) {
		ticketMap.remove(ticket.getId());
		
	}
	
	

}
