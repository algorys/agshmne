package io.github.algorys.agshmne.desctile;

public enum DescLake {
    lake("Lacs"),
    pond("Etangs"),
    fountain("Fontaines"),
    waterfall("Cascades"),
    fall("Chutes")
    ;

    private final String text;

    private DescLake(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
