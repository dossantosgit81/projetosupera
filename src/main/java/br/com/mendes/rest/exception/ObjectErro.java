package br.com.mendes.rest.exception;

import java.util.Arrays;
import java.util.List;

public class ObjectErro {
	
	private List<String> messages;
	
	private String messageDeveloper;
	
	private String status;
	
	public ObjectErro() {
		
	}

	public ObjectErro(String message, String messageDeveloper, String status) {
		this.messages = Arrays.asList(message);
		this.messageDeveloper = messageDeveloper;
		this.status = status;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String getMessageDeveloper() {
		return messageDeveloper;
	}

	public void setMessageDeveloper(String messageDeveloper) {
		this.messageDeveloper = messageDeveloper;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
