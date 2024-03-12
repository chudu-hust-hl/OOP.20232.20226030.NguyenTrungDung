import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Enter the rows: ");
		int rows = scanner.nextInt();
		for(int i=0;i < rows; i++) {
			for( int j=0; j<2*rows-1;j++) {
				if(rows-1-i<=j && rows-1+i>=j) {
					System.out.print("*");
				}
				else System.out.print(" ");
			}
			System.out.println("");
		}
		scanner.close();
	}
}
