package io.github.algorys.agshmne.output;

import java.util.ArrayList;
import java.util.List;

public class OutputGame {
	List<String> output = new ArrayList<>();
	
	public OutputGame() {
	}

	public List<String> getOutput() {
		return output;
	}
	
	public void addMessage(String message) {
		output.add(message);
	}
	
}
