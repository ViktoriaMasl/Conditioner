package netology.ru;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ConditionerTest {

    @Test
    public void shouldGetAndSet() {
        Conditioner conditioner = new Conditioner();
        String expected = "Кондишн";

        assertNull(conditioner.getName());
        conditioner.setName(expected);
        assertEquals(expected, conditioner.getName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataForIncrease.csv")
    void shouldIncreaseCurrentTemperature(boolean on, int currentTemperature, int minTemperature, int maxTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setOn(on);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.increaseCurrentTemperature();

        assertEquals(expected, conditioner.getCurrentTemperature());
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/dataForDecrease.csv")
    void shouldDecreaseCurrentTemperature(boolean on, int currentTemperature, int minTemperature, int maxTemperature, int expected) {

        Conditioner conditioner = new Conditioner();
        conditioner.setOn(on);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.decreaseCurrentTemperature();

        assertEquals(expected, conditioner.getCurrentTemperature());
    }

}