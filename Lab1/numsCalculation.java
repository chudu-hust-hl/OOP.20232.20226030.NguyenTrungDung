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
		
		
		JOptionPane.showMessageDialog(null, sum(num1, num2),
				"Show the sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, difference(num1, num2),
				"Show the difference of two numbers", JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, product(num1, num2),
				"Show the product of two numbers", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, quotient(num1, num2),
				"Show the quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
	}

}
