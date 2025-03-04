/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author katar
 */




import Controller.Controller;
import model.Heretic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View {
    private JFrame frame; 
    private JButton addButton;
    private JButton viewButton; 
    private JButton infoHeretic;
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
        frame.setSize(500,300);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        hereticList = new JList<>(listModel); 

        addButton = new JButton("Добавить еретика"); 
        viewButton = new JButton("Посмотреть список");
        infoHeretic = new JButton("Просмотреть информацию");
     
        JPanel panel = new JPanel(new GridLayout(3,1)); 
        panel.add(addButton); 
        panel.add(viewButton);
        panel.add(infoHeretic);
        frame.add(panel, BorderLayout.CENTER); 

        frame.setVisible(true);
        
        
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
                frame.setVisible(false);
                
                JFrame hereticsList = new JFrame();
                hereticsList.setSize(500,300);
                hereticsList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JPanel hereticsPanel = new JPanel(new BorderLayout());
                JList<String> heretics = new JList<>(listModel);
                
                JButton exit = new JButton("Выход");
                
                hereticsPanel.add(new JScrollPane(heretics), BorderLayout.CENTER);
                hereticsPanel.add(exit, BorderLayout.EAST);
                hereticsList.add(hereticsPanel);
                hereticsList.setVisible(true);
                
                exit.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hereticsList.dispose();
                        frame.setVisible(true);
                    }
                    
                });
            }
        });
  
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
  

      

