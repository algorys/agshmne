package io.github.algorys.agshmne.desctile;

public enum DescWood {
	wood("Bois"),
	forest("Forêt"),
	gardens("Jardins"),
	jungle("Jungle"),
	sylfe("Sylve")
	;
	
	private final String text;

    private DescWood(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
	
}
