package io.github.algorys.agshmne.desctile;

public enum DescRiver {
	river("Rivière"),
	stream("Fleuve"),
	coast("Côte"),
	shore("Rivages")
	;
	
	private final String text;

    private DescRiver(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
}
