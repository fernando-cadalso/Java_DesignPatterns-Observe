package refactoring_guru.observer.example.editor;

import java.io.File;

import refactoring_guru.observer.example.publishers.EventManager;

//Publicador concreto rastreado por outros objetos.
public class Editor {
	
	public EventManager events;
	private File file;
	
	public Editor() {
		this.events = new EventManager("open","save");
	}
	
	public void openFile(String filePath) {
		this.file = new File(filePath);
		events.notify("open", file);
	}
	
	public void saveFile() throws Exception{
		if (this.file == null) {
			throw new Exception("Abra um arquivo antes de salvar.");
		}
		events.notify("save", file);
	}

}
