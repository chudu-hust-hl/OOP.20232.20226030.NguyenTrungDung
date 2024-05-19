package hust.soict.ict.aims.screen.manager;

import javax.swing.*;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookInputDialog extends JDialog {
    private JTextField titleField, categoryField, costField;
    private JList<String> authorList;
    private DefaultListModel<String> authorListModel;
    private Store store;

    public BookInputDialog(Frame owner, Store store) {
        super(owner, "Add New Book", true);
        this.store = store;

        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        authorListModel = new DefaultListModel<>();
        authorList = new JList<>(authorListModel);

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costField);
        inputPanel.add(new JLabel("Authors:"));
        inputPanel.add(new JScrollPane(authorList));

        JButton addAuthorButton = new JButton("Add Author");
        addAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String author = JOptionPane.showInputDialog(BookInputDialog.this, "Enter Author:");
                if (author != null && !author.trim().isEmpty()) {
                    authorListModel.addElement(author);
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewBook();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addAuthorButton);
        buttonPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    private void addNewBook() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        ArrayList<String> authors = new ArrayList<>();
        for (int i = 0; i < authorListModel.size(); i++) {
            authors.add(authorListModel.get(i));
        }

        Book newBook = new Book(title, category, authors, cost);
        store.addMedia(newBook);
        JOptionPane.showMessageDialog(this, "Book added successfully!");
        dispose();
    }
}
