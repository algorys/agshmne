package io.github.algorys.agshmne.output;

import javax.swing.AbstractListModel;

@SuppressWarnings("serial")
public class OutputListModel extends AbstractListModel<String> {
	private OutputGame output;

	public OutputListModel(OutputGame output) {
		this.output = output;
	}

	@Override
	public int getSize() {
		return output.getOutput().size();
	}

	@Override
	public String getElementAt(int index) {
		return output.getOutput().get(index);
	}

}
