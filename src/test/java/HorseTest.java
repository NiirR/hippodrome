import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class HorseTest {



    @org.junit.jupiter.api.Test
    void testNameNull(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse1 = new Horse(null , 1);
                }
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"     " , " ", ""})
    void testNameBlank(String name) throws IllegalArgumentException{

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse1 = new Horse(name , 1);
                }
        );
        assertEquals("Name cannot be blank.", exception.getMessage());
    }


    @org.junit.jupiter.api.Test
    void testSpeedNegative(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse1 = new Horse("Horse" ,  - 1);
                }
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testDistanceNegative(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse1 = new Horse("Horse" ,  5 ,-500);
                }
        );
        assertEquals( "Distance cannot be negative.", exception.getMessage());
    }


    @org.junit.jupiter.api.Test
    void getName() {
        Horse horse = new Horse("Hors" , 5 , 500);
        String result = horse.getName();
        assertEquals("Hors" , result);
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        Horse horse = new Horse("Hors" , 5 , 500);
        double result = horse.getSpeed();
        assertEquals(5 , result);
    }

    @org.junit.jupiter.api.Test
    void getDistance() {
        Horse horse = new Horse("Hors" , 5 , 500);
        double result = horse.getDistance();
        assertEquals(500 , result);
    }

    @org.junit.jupiter.api.Test
    void getDistanceZero() {
        Horse horse1 = new Horse("Hors" , 5);
        double result = horse1.getDistance();
        assertEquals(0 , result);
    }

    @org.junit.jupiter.api.Test
    void move() {
    try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
        new Horse("Horse" ,10 , 235).move();


        mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
    }
    }
}