package week1;

import javax.swing.JOptionPane;

public class numsCalculation {
	
	static double sum(double a, double b) {
		return a+b;
	}
	
	static double difference(double a, double b) {
		return Math.abs(a-b);
	}
	
	static double product(double a, double b) {
		return a*b;
	}
	
	static double quotient(double a, double b) {
		return a/b;
	}

	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, "Please input the number: ", "Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		
		strNum2 = JOptionPane.showInputDialog(null, "Please input the number: ", "Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		
		double num1, num2;
		num1 = Double.parseDouble(strNum1);
		num2 = Double.parseDouble(strNum2);
		
		String[] options = {"sum", "difference", "product", "quotient"};
        String basic = (String) JOptionPane.showInputDialog(null, "Basic Calculator", "Which one", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (basic) {
        case "sum":
        	JOptionPane.showMessageDialog(null, sum(num1, num2),
    				"Show the sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
        case "difference":
        	JOptionPane.showMessageDialog(null, difference(num1, num2),
    				"Show the difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
            break;
        case "product":
        	JOptionPane.showMessageDialog(null, product(num1, num2),
    				"Show the product of two numbers", JOptionPane.INFORMATION_MESSAGE);
            break;
        case "quotient":
        	JOptionPane.showMessageDialog(null, quotient(num1, num2),
    				"Show the quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
        System.exit(0);
	}

}
