/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject;

/**
 *
 * @author katar
 */




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame; 
    private JButton addButton;
    private JButton viewButton; 
    private JList<String> hereticList; 
    private DefaultListModel<String> listModel; 
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller; 
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Heretic Tracker"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(400, 300); 

        listModel = new DefaultListModel<>();
        hereticList = new JList<>(listModel); 

        addButton = new JButton("Добавить еретика"); 
        viewButton = new JButton("Просмотреть информацию"); 

     
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addHeretic();
                updateList(); 
            }
        });

   
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = hereticList.getSelectedIndex(); 
                if (selectedIndex != -1) { 
                    Heretic selectedHeretic = controller.allHeretics().get(selectedIndex);
                    showHereticDetails(selectedHeretic); 
                } else {
                    JOptionPane.showMessageDialog(frame, "Пожалуйста, выберите еретика для просмотра информации.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(hereticList), BorderLayout.CENTER); 

        JPanel panel = new JPanel(); 
        panel.add(addButton); 
        panel.add(viewButton);
        frame.add(panel, BorderLayout.SOUTH); 

        frame.setVisible(true); 
    }

    private void updateList() {
        listModel.clear();
        for (Heretic heretic : controller.allHeretics()) { 
            listModel.addElement(heretic.getName());
        }
    }

    private void showHereticDetails(Heretic heretic) {
        String details = "Имя: " + heretic.getName() +
                         "\nПреступления: " + heretic.getCrimes() +
                         "\nПоследнее известное местоположение: " + heretic.getLast_appear() + "\nИдентификационный номер: " + heretic.getId() +
                         "\nУровень угрозы: " + heretic.getLevel_threat();
        
        JOptionPane.showMessageDialog(frame, details, "Информация о еретике", JOptionPane.INFORMATION_MESSAGE);
    }
}
  

      

