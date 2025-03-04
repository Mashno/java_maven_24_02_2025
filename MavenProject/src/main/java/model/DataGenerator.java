/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author katar
 */


import com.github.javafaker.Faker;

public class DataGenerator {
    private Faker faker = new Faker();

    public Heretic generateHeretic() {
        return new Heretic(faker.name().fullName(), faker.lorem().sentence(), faker.address().fullAddress(), faker.idNumber().valid(), getRandomThreatLevel());
    }

    private String getRandomThreatLevel() {
        String[] levels = {"Низкий", "Средний", "Высокий", "Критический"};
        return levels[faker.number().numberBetween(0, levels.length)];
    }
}
     

