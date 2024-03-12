package week1;

import javax.swing.JOptionPane;

public class ChoosingOption {

    public static void main(String[] args) {
        // Define custom option labels
        Object[] options = {"Yes", "No", "I don't"};

        // Show the confirmation dialog with custom options
        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?",
                "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Determine user's choice and display a message accordingly
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You've chosen: Yes");
        } else if (option == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "You've chosen: No");
        } else if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "You've chosen: I don't");
        }

        System.exit(0);
    }
}
