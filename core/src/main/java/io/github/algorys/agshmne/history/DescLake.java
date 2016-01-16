package io.github.algorys.agshmne.history;

public enum DescLake {
    lake("Lacs de "),
    pond("Etangs de "),
    fountain("Fontaines de "),
    waterfall("Chutes de ")
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
