package io.github.algorys.agshmne.desctile;

public enum DescHill {
	hill("Collines"),
	plateau("Plateau"),
	mound("Grand Tertre"),
	hillock("Buttes"),
	;
	
	private final String text;

    private DescHill(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
}
