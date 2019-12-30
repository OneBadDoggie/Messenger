package io.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.javabrains.messenger.database.MyDatabase;
import io.javabrains.messenger.models.Message;

public class MessageService {

	private Map<Long, Message> messages = MyDatabase.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Message 1", "obd"));
		messages.put(2L, new Message(2, "Message 2", "obd"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message msg : messages.values()) {
			cal.setTime(msg.getCreated());
			if (cal.get(Calendar.YEAR)== year) {
				messagesForYear.add(msg);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> messagesForPage = new ArrayList<Message>(messages.values());
		
		return messagesForPage.subList(start,  start + size);
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}
