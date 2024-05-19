package hust.soict.ict.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.*;
import hust.soict.ict.aims.cart.Playable;

public class MediaStore extends JPanel {
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+ media.getCost()+ " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					playMedia((Playable) media);
				}
			});
			container.add(playButton);
		}
		
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	//Play media box
	private void playMedia(Playable media) {
		// Create a dialog to display the play message
		JDialog playDialog = new JDialog();
		playDialog.setTitle("Playing Media");
		playDialog.setSize(300, 200);
		playDialog.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());

		JLabel message = new JLabel("Now Playing: " + media.getTitle());
		message.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(message);

		panel.add(Box.createVerticalGlue());
		playDialog.add(panel);
		playDialog.setVisible(true);

		// Invoke the play method of the media
		media.play();
		JOptionPane.showMessageDialog(playDialog, "Playing " + this.media.getTitle());
	}
}
