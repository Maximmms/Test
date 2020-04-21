import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfTries = 0;
		String playAgain = "";
		do {
			// Генерация случайного числа
			int theNumber = (int)(Math.random() * 200 - 100);
			//System.out.println(theNumber);
			int guess = 0;
			while (guess != theNumber) {
				System.out.println("Угадай число от -100 до 100:");
				guess = scan.nextInt();
				numberOfTries = numberOfTries + 1;
				//System.out.println("You entered " + guess + "."); 
				if (guess < theNumber)            
					System.out.println(guess + " слишком мало, попробуй еще разок.");
				else if (guess > theNumber)   
					System.out.println(guess + " слишком много, попробуй еще разок");
				else        
					System.out.println(guess + " Правильно. Ты победил!");
			}
			System.out.println("Количество попыток" + numberOfTries);
			System.out.println("");
			System.out.println("Нет желания сыграть еще разок (y/n)?");           
			playAgain = scan.next(); 
		}		while (playAgain.equalsIgnoreCase("y"));
		System.out.println("Спасибо за игру! Пока.");
		
		scan.close();

	}

}
