package hust.soict.ict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.*;

public class StoreManagerScreen extends JFrame {
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store =store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
				
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	

	JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store"));
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BookInputDialog(StoreManagerScreen.this, store).setVisible(true);
                refreshCenterPanel();
            }
        });

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CDInputDialog(StoreManagerScreen.this, store).setVisible(true);
                refreshCenterPanel();
            }
        });

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DVDInputDialog(StoreManagerScreen.this, store).setVisible(true);
                refreshCenterPanel();
            }
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
	

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout (new BoxLayout (header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 50)); 
		title.setForeground (Color.CYAN);
		header.add(Box.createRigidArea (new Dimension (10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue()); 
		header.add(Box.createRigidArea (new Dimension (10, 10)));
		return header;
	}
	
	//Create center component

	JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 2, 2)); // Dynamically set rows, fixed 3 columns

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        JScrollPane scrollPane = new JScrollPane(center);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        return centerPanel;
    }
	
	// Methods to add new media
	private void addNewBook() {
		String title = JOptionPane.showInputDialog(this, "Enter Book Title:");
		String category = JOptionPane.showInputDialog(this, "Enter Book Category:");
		String costStr = JOptionPane.showInputDialog(this, "Enter Book Cost:");
		float cost = Float.parseFloat(costStr);

		int numAuthors = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Number of Authors:"));
		ArrayList<String> authors = new ArrayList<>();
		for (int i = 0; i < numAuthors; i++) {
			String author = JOptionPane.showInputDialog(this, "Enter Author " + (i + 1) + ":");
			authors.add(author);
		}

		Book newBook = new Book(title, category, authors, cost);
		store.addMedia(newBook);
		JOptionPane.showMessageDialog(this, "Book added successfully!");
		refreshCenterPanel();
	}

	private void addNewCD() {
		String title = JOptionPane.showInputDialog(this, "Enter CD Title:");
		String category = JOptionPane.showInputDialog(this, "Enter CD Category:");
		String costStr = JOptionPane.showInputDialog(this, "Enter CD Cost:");
		String lengthStr = JOptionPane.showInputDialog(this, "Enter CD Length:");
		String director = JOptionPane.showInputDialog(this, "Enter CD Director:");
		ArrayList<Track> tracks = new ArrayList<>();
		float cost = Float.parseFloat(costStr);
		int length=Integer.parseInt(lengthStr);

		String artist = JOptionPane.showInputDialog(this, "Enter CD Artist:");
		CompactDisc newCD = new CompactDisc(title, category, director, tracks, length, cost, artist);
		store.addMedia(newCD);
		JOptionPane.showMessageDialog(this, "CD added successfully!");
		refreshCenterPanel();
	}

	private void addNewDVD() {
		String title = JOptionPane.showInputDialog(this, "Enter DVD Title:");
		String category = JOptionPane.showInputDialog(this, "Enter DVD Category:");
		String costStr = JOptionPane.showInputDialog(this, "Enter DVD Cost:");
		float cost = Float.parseFloat(costStr);

		String director = JOptionPane.showInputDialog(this, "Enter DVD Director:");
		String lengthStr = JOptionPane.showInputDialog(this, "Enter DVD Length:");
		int length = Integer.parseInt(lengthStr);

		DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
		store.addMedia(newDVD);
		JOptionPane.showMessageDialog(this, "DVD added successfully!");
		refreshCenterPanel();
	}

	private void refreshCenterPanel() {
		Container cp = getContentPane();
		cp.remove(1);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.revalidate();
		cp.repaint();
	}
}


