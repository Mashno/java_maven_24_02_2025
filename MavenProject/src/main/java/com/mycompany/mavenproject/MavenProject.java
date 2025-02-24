/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject;
import com.github.javafaker.Faker;



/**
 *
 * @author Владислав
 */
public class MavenProject {

    public static void main(String[] args) {
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String address = faker.address().fullAddress();
        String email = faker.internet().emailAddress();

        System.out.println("Фейковое имя: " + name);
        System.out.println("Фейковый адрес: " + address);
        System.out.println("Фейковый email: " + email);
    }
}
