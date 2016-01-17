package io.github.algorys.agshmne.desctile;

public enum DescSea {
	sea("Mer"),
	ocean("Océan")
	;
	
	private final String text;

    private DescSea(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
}
