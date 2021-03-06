package com.epam.java8.driver;

public enum Tasks {
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9);

    int value;
    Tasks(int value) {
        this.value = value;
    }

    public static Tasks getTask(int option) {
        for (Tasks task : Tasks.values()) {
            if(task.ordinal() == option) {
                return task;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
