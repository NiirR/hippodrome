import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    Horse horse = new Horse("Hors" , 5 , 500);

    @org.junit.jupiter.api.Test
    void getName() {
        String result = horse.getName();
        assertEquals("Hors" , result);
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        double result = horse.getSpeed();
        assertEquals(5 , result);
    }

    @org.junit.jupiter.api.Test
    void getDistance() {
        double result = horse.getDistance();
        assertEquals(500 , result);
    }

    @org.junit.jupiter.api.Test
    void move() {
        double result = horse.getDistance() + horse.getSpeed();
        assertEquals(505 , result);
    }
}