package io.github.algorys.agshmne.desctile;

public enum DescPlain {
	plain("Plaines"),
	savanna("Savane"),
	earth("Terres"),
	countries("Contrées"),
	county("Comté")
	;
	
	private final String text;

    private DescPlain(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
	
}
