package refactoring_guru.observer.example.publishers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import refactoring_guru.observer.example.listeners.EventListener;

//Publicador básico
public class EventManager {

	Map<String, List<EventListener>> listeners = new HashMap<>();
	
	public EventManager(String... operations) {
		for (String operation : operations) {
			this.listeners.put(operation, new ArrayList<EventListener>());
		}
	}
	/**
	 * Realiza o cadastro de um interessado na mudança de estado
	 * de um tipo de evento.
	 * @param listener é o interessado.
	 * @param eventType é o tipo do evento.
	 */
	public void subscriber(String eventType, EventListener listener) {
		List<EventListener> users = listeners.get(eventType);
		users.add(listener);
	}
	/**
	 * Realiza o cancelamento do cadastro de um interessado na mudança de estado
	 * de um tipo de evento.
	 * @param eventType é o tipo do evento.
	 * @param listener é o interessado.
	 */
	public void unsubscribe(String eventType, EventListener listener) {
		List<EventListener> users = listeners.get(eventType);
		users.remove(listener);
	}
	/**
	 * Atualiza os interessados registrando o tipo do evento no arquivo informado.
	 * @param eventType é o tipo do evento registrado.
	 * @param file é o arquivo de registro do evento.
	 */
	public void notify(String eventType, File file) {
		List<EventListener> users = listeners.get(eventType);
		for (EventListener listener : users) {
			listener.update(eventType, file);
		}
		
	}
	
	
}
