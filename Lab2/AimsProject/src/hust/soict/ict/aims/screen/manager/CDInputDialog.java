package hust.soict.ict.aims.screen.manager;

import javax.swing.*;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CDInputDialog extends JDialog {
    private JTextField titleField, categoryField, costField, lengthField, directorField, artistField;
    private Store store;

    public CDInputDialog(Frame owner, Store store) {
        super(owner, "Add New CD", true);
        this.store = store;

        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        lengthField = new JTextField();
        directorField = new JTextField();
        artistField = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costField);
        inputPanel.add(new JLabel("Length:"));
        inputPanel.add(lengthField);
        inputPanel.add(new JLabel("Director:"));
        inputPanel.add(directorField);
        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(artistField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewCD();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    private void addNewCD() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());
        String director = directorField.getText();
        String artist = artistField.getText();

        CompactDisc newCD = new CompactDisc(title, category, director, new ArrayList<>(), length, cost, artist);
        store.addMedia(newCD);
        JOptionPane.showMessageDialog(this, "CD added successfully!");
        dispose();
    }
}
