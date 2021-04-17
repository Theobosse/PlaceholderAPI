package fr.theobosse.papi.utils;

public enum Level {

    HIGHER(1),
    HIGH(2),
    NORMAL(3),
    LOW(4),
    LOWER(5);

    private final int id;

    Level(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public static Level getByID(int id) {
        return Level.values()[id - 1];
    }
}
