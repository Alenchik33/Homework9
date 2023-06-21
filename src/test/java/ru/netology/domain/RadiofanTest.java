package ru.netology.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value; 4; 4",
            "Invalid value; -4; 0",
            "Invalid value check; 15; 0",
            "Boundary value check 1; -1; 0",
            "Boundary value check 2; 0; 0",
            "Boundary value check 3; 1; 1",
            "Boundary value check 4; 8; 8",
            "Boundary value check 5; 9; 9",
            "Boundary value check 6; 10; 0",
    }, delimiter = ';')
    void setCurrentStationDefaultSetting(String nameTest, int inputSelectStation, int expectedStation) {
        Radiofan radio = new Radiofan();
        radio.setCurrentStation(inputSelectStation);
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value; 4; 5",
            "Boundary value check 1; 0; 1",
            "Boundary value check 2; 1; 2",
            "Boundary value check 3; 8; 9",
            "Boundary value check 4; 9; 0",
    }, delimiter = ';')
    void nextStationDefaultSetting(String nameTest, int oldCurrentStation, int expectedStation) {
        Radiofan radio = new Radiofan();
        radio.setCurrentStation(oldCurrentStation);
        radio.nextStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value; 4; 3",
            "Boundary value check 1; 0; 9",
            "Boundary value check 2; 1; 0",
            "Boundary value check 3; 8; 7",
            "Boundary value check 4; 9; 8",
    }, delimiter = ';')
    void prevStationDefaultSetting(String nameTest, int oldCurrentStation, int expectedStation) {
        Radiofan radio = new Radiofan();
        radio.setCurrentStation(oldCurrentStation);
        radio.prevStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value; 1; 0; 0",
            "Invalid value1; 1; -4; 0",
            "Invalid value2; 1; 4; 0",
            "Boundary value1; 1; -2; 0",
            "Boundary value2; 1; 1; 0",
            "Critical value; 20; 10; 10",
            "Invalid value1; 20; -1; 0",
            "Invalid value2; 20; 22; 0",
            "Boundary value1; 20; -1; 0",
            "Boundary value2; 20; 0; 0",
            "Boundary value3; 20; 1; 1",
            "Boundary value4; 20; 18; 18",
            "Boundary value5; 20; 19; 19",
            "Boundary value6; 20; 20; 0",
    }, delimiter = ';')
    void setCurrentStationCustomSetting(String nameTest, int counterStation, int inputSelectStation, int expectedStation) {
        Radiofan radio = new Radiofan(counterStation);
        radio.setCurrentStation(inputSelectStation);
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value; 1; 0; 0",
            "Critical value2; 20; 9; 10",
            "Boundary value1; 20; 0; 1",
            "Boundary value2; 20; 1; 2",
            "Boundary value3; 20; 18; 19",
            "Boundary value4; 20; 19; 0",
    }, delimiter = ';')
    void nextStationCustomSetting(String nameTest, int counterStation, int oldCurrentStation, int expectedStation) {
        Radiofan radio = new Radiofan(counterStation);
        radio.setCurrentStation(oldCurrentStation);
        radio.nextStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value1; 1; 0; 0",
            "Critical value2; 20; 10; 9",
            "Boundary value1; 20; 0; 19",
            "Boundary value2; 20; 1; 0",
            "Boundary value3; 20; 18; 17",
            "Boundary value4; 20; 19; 18",
    }, delimiter = ';')
    void prevStationCustomSetting(String nameTest, int counterStation, int oldCurrentStation, int expectedStation) {
        Radiofan radio = new Radiofan(counterStation);
        radio.setCurrentStation(oldCurrentStation);
        radio.prevStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical; 40; 40",
            "Invalid value1; -1; 30",
            "Invalid value2; 105; 30",
            "Boundary value1; -1; 30",
            "Boundary value2; 0; 0",
            "Boundary value3; 1; 1",
            "Boundary value4; 99; 99",
            "Boundary value5; 100; 100",
            "Boundary value6; 101; 30",
    }, delimiter = ';')
    void setCurrentVolume(String nameTest, int currentVolume, int expectedVolume) {
        Radiofan radio = new Radiofan();
        radio.setCurrentVolume(currentVolume);
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value; 10; 11",
            "Boundary value1; 0; 1",
            "Boundary value2; 1; 2",
            "Boundary value3; 99; 100",
            "Boundary value4; 100; 100",
    }, delimiter = ';')
    void volumeUp(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radiofan radio = new Radiofan();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.volumeUp();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical value; 10; 9",
            "Boundary value1; 0; 0",
            "Boundary value2; 1; 0",
            "Boundary value3; 99; 98",
            "Boundary value4; 100; 99",
    }, delimiter = ';')
    void volumeDown(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radiofan radio = new Radiofan();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.volumeDown();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }
}
