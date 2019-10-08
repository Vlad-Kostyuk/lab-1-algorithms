package com.milk;

public class Milk {

    String maker;
    float fat;
    int volume;
    int calories;

    public Milk(String maker, float fat, int volume, int calories) {
        this.maker = maker;
        this.fat = fat;
        this.volume = volume;
        this.calories = calories;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return String.format("Maker %s, fat %1.1f%%; volume %d ml; calories %d ",this.maker, this.fat, this.volume, this.calories);
    }
}
