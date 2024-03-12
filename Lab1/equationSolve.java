package week1;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Scanner;


public class equationSolve {

	static void firstDegEqn(double a, double b){
		if(a==0) {
			if(b==0) {
				JOptionPane.showMessageDialog(null,"Infinite solution","Solution", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"No solution","Solution", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null,-b/a,"Solution", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] options = {"first degree eqn", "first degree system", "second degree eqn"};
        String basic = (String) JOptionPane.showInputDialog(null, "Basic Calculator", "Which one", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (basic) {
        case "first degree eqn":
        	String strNum1, strNum2;
    		strNum1 = JOptionPane.showInputDialog(null, "Please input the number: ", "Input the first number", 
    				JOptionPane.INFORMATION_MESSAGE);
    		
    		strNum2 = JOptionPane.showInputDialog(null, "Please input the number: ", "Input the second number",
    				JOptionPane.INFORMATION_MESSAGE);
    		
    		double num1, num2;
    		num1 = Double.parseDouble(strNum1);
    		num2 = Double.parseDouble(strNum2);
    		
    		firstDegEqn(num1, num2);
    		break;
        
        case "first degree system":
        	double[][] coefficients= new double[2][2];
    		double[] constants = new double[2];
    		double[] solution = new double[2];
    		
    		
    		for(int i=0;i<2;i++) {
    			JTextField field1 = new JTextField();
                JTextField field2 = new JTextField();
                JTextField field3 = new JTextField();

                // Create a panel to hold the input fields
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                panel.add(new JLabel("A"+(i+1)));
                panel.add(field1);
                panel.add(new JLabel("B"+(i+1)));
                panel.add(field2);
                panel.add(new JLabel("C"+(i+1)));
                panel.add(field3);

                // Show input dialog with custom panel
                int result = JOptionPane.showConfirmDialog(null, panel, "Enter three numbers",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                // Handle user input
                if (result == JOptionPane.OK_OPTION) {
                    try {
                    	coefficients[i][0] = Double.parseDouble(field1.getText());
                        coefficients[i][1] = Double.parseDouble(field2.getText());
                        constants[i] = Double.parseDouble(field3.getText());

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
                    }
                }
    		}     
                //Caculatting
                double det = coefficients[0][0] * coefficients[1][1] - coefficients[0][1] * coefficients[1][0];
                solution[0] = (constants[0] * coefficients[1][1] - constants[1] * coefficients[0][1]) / det;
                solution[1] = (coefficients[0][0] * constants[1] - coefficients[1][0] * constants[0]) / det;
                
                if(det == 0) {
                	JOptionPane.showMessageDialog(null, "No unique solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                	JOptionPane.showMessageDialog(null, "x1= "+ solution[0]+ ", x2=" +solution[1], "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
                
            break;
        
        case "second degree eqn":
        	double[] coefficients2deg = new double[3];
        	double[] solution2deg = new double[2];
        	
        	JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();

            // Create a panel to hold the input fields
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            panel.add(new JLabel("A"));
            panel.add(field1);
            panel.add(new JLabel("B"));
            panel.add(field2);
            panel.add(new JLabel("C"));
            panel.add(field3);

            // Show input dialog with custom panel
            int result = JOptionPane.showConfirmDialog(null, panel, "Enter three numbers",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Handle user input
            if (result == JOptionPane.OK_OPTION) {
                try {
                	coefficients2deg[0] = Double.parseDouble(field1.getText());
                	coefficients2deg[1] = Double.parseDouble(field2.getText()); 
                	coefficients2deg[2] = Double.parseDouble(field3.getText());

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
                }
            }
        	
        	double delta= coefficients2deg[1]*coefficients2deg[1]-4*coefficients2deg[0]*coefficients2deg[2];
        	if(delta <0) {
        		JOptionPane.showMessageDialog(null, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else if(delta==0) {
        		solution2deg[0]= (-coefficients2deg[1])/(2*coefficients2deg[0]);
        		JOptionPane.showMessageDialog(null, "One solution: x= "+ solution2deg[0], "Solution", JOptionPane.INFORMATION_MESSAGE);
        	}
        	else {
        		solution2deg[0]= (-coefficients2deg[1] + Math.sqrt(delta))/(2*coefficients2deg[0]);
        		solution2deg[1]= (-coefficients2deg[1] - Math.sqrt(delta))/(2*coefficients2deg[0]);
        		JOptionPane.showMessageDialog(null, "Two solution: x1= "+ solution2deg[0]+ ", x2= "+solution2deg[1], "Solution", JOptionPane.INFORMATION_MESSAGE);
        	}
        }
        System.exit(0);
		scanner.close();
	}

}
