package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadiofanTest {
    Radiofan radio = new Radiofan();

    @Test
    void shouldSetRadioStation() {
        radio.setCurrentRadioStation(0);
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    void shouldSetOverMaxStation() {
        radio.setCurrentRadioStation(10);
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    void shouldSetUnderMinStation() {
        radio.setCurrentRadioStation(-1);
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    void shouldSetNextStation() {
        radio.setCurrentRadioStation(4);
        radio.shouldNextRadioStation();
        Assertions.assertEquals(5, radio.getCurrentRadioStation());
    }
    @Test
    void shouldSetNextStation2() {
        radio.setCurrentRadioStation(9);
        radio.shouldNextRadioStation();
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    void shouldSetPrevRadioStation() {
        radio.setCurrentRadioStation(4);
        radio.shouldPrevRadioStation();
        Assertions.assertEquals(3, radio.getCurrentRadioStation());
    }
    @Test
    void shouldSetPrevRadioStation2() {
        radio.setCurrentRadioStation(0);
        radio.shouldPrevRadioStation();
        Assertions.assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    void shouldIncreaseVolume() {
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }
    @Test
    void shouldIncreaseVolume2() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }
    @Test
    void shouldIncreaseVolume3() {
        radio.setCurrentVolume(101);
        radio.increaseVolume();
        Assertions.assertEquals(1, radio.getCurrentVolume());
    }
        @Test
        void shouldReduceVolume () {
            radio.setCurrentVolume(11);
            radio.reduceVolume();
            Assertions.assertEquals(10, radio.getCurrentVolume());
        }
    @Test
    void shouldReduceVolume2 () {
        radio.setCurrentVolume(-1);
        radio.reduceVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
        @Test
        void shouldSetOverMaxVolume() {
            radio.setCurrentVolume(101);
            Assertions.assertEquals(0, radio.getCurrentRadioStation());
        }

    @Test
    void shouldSetUnderMinVolume() {
        radio.setCurrentVolume(-1);
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }
    }

