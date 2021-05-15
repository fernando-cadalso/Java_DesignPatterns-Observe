package refactoring_guru.observer.example;

import refactoring_guru.observer.example.editor.Editor;
import refactoring_guru.observer.example.listeners.EmailNotificationListener;
import refactoring_guru.observer.example.listeners.LogOpenListener;

//Código da aplicação
public class Teste {

	public static void main(String[] args) {

		Editor editor = new Editor();
		editor.events.subscriber("open", new LogOpenListener("logFile.txt"));
		editor.events.subscriber("save", new EmailNotificationListener("fernando.cadalso@gmail.com"));
		
		try {
			editor.openFile("testFile.txt");
			editor.saveFile();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
