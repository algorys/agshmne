package io.github.algorys.agshmne.desctile;

public enum DescMountain {
	mount("Monts"),
	mountain("Montagnes"),
    cliff("Falaises"),
    rifts("Crevasses"),
    canyon("Canyons")
    ;

    private final String text;

    private DescMountain(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
    	  return text;
    }
}
