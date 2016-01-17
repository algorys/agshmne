package io.github.algorys.agshmne.desctile;

public enum DescSwamp {
	swamp("Marécage"),
	marsh("Marais"),
	bog("Tourbière"),
	morass("Bourbier")
	;
	
	private final String text;

    private DescSwamp(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
}
