public enum Symbols {
    X('X'),
    O('O'),
    Empty(' ');

    public char label;

    private Symbols(char label) {
        this.label = label;
    }
}

