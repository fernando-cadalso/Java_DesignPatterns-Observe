package refactoring_guru.observer.example.listeners;

import java.io.File;

//Envia email ao receber notificações
public class EmailNotificationListener implements EventListener{

	private String email;
	
	public EmailNotificationListener(String email) {
		this.email = email;
	}
	@Override
	public void update(String eventType, File file) {

		System.out.println("Mensagem para " + email + " : Alguém realizou a operação " + 
							eventType + " no arquivo: " + file.getName());
	}
}
