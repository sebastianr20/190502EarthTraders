package com.example.spacetraders190502.Model;

import java.util.Random;

public enum RandomEvent {
    PIRATE_ATTACK(0,new Random(), "Pirates attacking! Buckle up"),
    POLICE_CHECK(1, new Random(), "Police arrives to check cargo! Sit tight!"),
    DROUGHT(2, new Random(), "City drought! Everyone is thirsty"),
    RIOTS(3, new Random(), "Riots against government!"),
    BONUS(4, new Random(), "You hit the tailwind and got there faster than expected"),
    CARGO_LOST(5, new Random(), "Rough weather couldn't damage your cargo."),
    WARPED(6, new Random(), "You hit rough air but the ship survived the journey."),
    NOTHING(7, new Random(), "Good going! Keep it up!");

    private int id;
    private Random rand;
    private String eventName;

    RandomEvent(int id, Random rand, String event) {
        this.id = id;
        this.rand = rand;
        this.eventName = event;

    }

    @Override
    public String toString() {
        return getEventName();
    }

    public int getId() {
        return id;
    }

    public Random getRand() {
        return rand;
    }

    public String getEventName() {
        return eventName;
    }

    public static RandomEvent eventGen() {
        Random rand = new Random();
        int ordinal = rand.nextInt(8);
        RandomEvent re;
        switch(ordinal) {
            case 0: re = RandomEvent.PIRATE_ATTACK;
                break;
            case 1: re = RandomEvent.POLICE_CHECK;
                 break;
            case 2: re = RandomEvent.DROUGHT;
                break;
           case 3: re = RandomEvent.RIOTS;
               break;
            case 4: re = RandomEvent.BONUS;
                break;
            case 5: re = RandomEvent.CARGO_LOST;
                break;
            case 6: re = RandomEvent.WARPED;
                break;
            default: re = RandomEvent.NOTHING;
                break;
        }
        return re;
    }

}
