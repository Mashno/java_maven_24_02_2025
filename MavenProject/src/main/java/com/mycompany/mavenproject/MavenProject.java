/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject;
import Controller.Controller;
import View.View;
import com.github.javafaker.Faker;



/**
 *
 * @author Владислав
 */
public class MavenProject {

    public static void main(String[] args) {
        Controller contr = new Controller();
        new View(contr);
    }
}
