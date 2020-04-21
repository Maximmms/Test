import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfTries = 0;
		String playAgain = "";
		do {
			// ��������� ���������� �����
			int theNumber = (int)(Math.random() * 200 - 100);
			//System.out.println(theNumber);
			int guess = 0;
			while (guess != theNumber) {
				System.out.println("������ ����� �� -100 �� 100:");
				guess = scan.nextInt();
				numberOfTries = numberOfTries + 1;
				//System.out.println("You entered " + guess + "."); 
				if (guess < theNumber)            
					System.out.println(guess + " ������� ����, �������� ��� �����.");
				else if (guess > theNumber)   
					System.out.println(guess + " ������� �����, �������� ��� �����");
				else        
					System.out.println(guess + " ���������. �� �������!");
			}
			System.out.println("���������� �������" + numberOfTries);
			System.out.println("");
			System.out.println("��� ������� ������� ��� ����� (y/n)?");           
			playAgain = scan.next(); 
		}		while (playAgain.equalsIgnoreCase("y"));
		System.out.println("������� �� ����! ����.");
		
		scan.close();

	}

}
