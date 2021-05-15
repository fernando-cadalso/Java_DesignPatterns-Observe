package refactoring_guru.observer.example.listeners;

import java.io.File;

//Interface comum do observador
public interface EventListener {
	
	void update(String eventType, File file);

}
