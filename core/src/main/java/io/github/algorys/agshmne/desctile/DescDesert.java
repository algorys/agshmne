package io.github.algorys.agshmne.desctile;

public enum DescDesert {
	desert("Désert"),
	saltdesert("Désert de Sel"),
	steppe("Steppe"),
	tundra("Toundra")
	;
	
	private final String text;

    private DescDesert(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
}
