package ru.netology.domain;

public class Radiofan {
    private int currentRadioStation;
    private int minStation = 0;
    private int maxStation = 9;
    private int currentVolume;
    private int minVolume = 0;
    private int maxVolume = 100;


    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation < minStation) {

            return;
        }
        if (currentRadioStation > maxStation) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    public void shouldNextRadioStation() {
        if (currentRadioStation >= maxStation) {
            setCurrentRadioStation(minStation);
        } else {
            setCurrentRadioStation(currentRadioStation + 1);
        }
    }

    public void shouldPrevRadioStation() {
        if (currentRadioStation <= minStation) {
            setCurrentRadioStation(maxStation);
        } else {
            setCurrentRadioStation(currentRadioStation - 1);
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minVolume) {

            return;
        }
        if (currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void reduceVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
        }
    }