import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @org.junit.jupiter.api.Test
    void testHippodromeNull(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Hippodrome hippodrome = new Hippodrome(null);
                }
        );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testHippodromeListNull(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    List<Horse> horses = new ArrayList<>();
                    Hippodrome hippodrome = new Hippodrome(horses);
                }
        );
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            horses.add(new Horse("Hors" , 5 , i) );
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses , hippodrome.getHorses());
    }

    @Test
    void move() {

       List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse horse : horses){
            verify(horse).move();
        }
    }

    @Test
    void getWinner() {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("1" ,5 , 100));
        horses.add(new Horse("2" ,5 , 300));
        horses.add(new Horse("3" ,5 , 1000));
        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(horses.get(2) , hippodrome.getWinner());
    }
}