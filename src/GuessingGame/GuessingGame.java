import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private JButton btnStart = new JButton("\u041D\u043E\u0432\u0430\u044F \u0438\u0433\u0440\u0430");
	private int theNumberTries = 0;
	public void checkGuess() {    
		String guessText = txtGuess.getText(); 
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			theNumberTries = theNumberTries + 1;
			if (guess < theNumber)       
				message = guess + " маловато, попробуйте еще разок!";  
			else if (guess > theNumber) 
				message = guess + " многовато, попробуйте еще разок!"; 
			else {      
				message = guess + " верно. Вы выиграли!" + " Вы использовали " + theNumberTries + " ходов!";
				newGame();
				btnStart.setVisible(true);
			}
		} catch (Exception e)
		{
			message = "Введите числовое значение между 1 и 100";
		} finally {
			lblOutput.setText(message); 
			txtGuess.requestFocus();          
			txtGuess.selectAll();
		} 
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}


	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u0418\u0433\u0440\u0430 \u0411\u043E\u043B\u044C\u0448\u0435-\u041C\u0435\u043D\u044C\u0448\u0435");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u041C\u0430\u043A\u0441\u0438\u043C \u0438\u0433\u0440\u0430");
		lblNewLabel.setBounds(160, 29, 84, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435 \u043E\u0442 1 \u0434\u043E 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(29, 72, 183, 35);
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(222, 79, 86, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("\u0413\u043E\u0442\u043E\u0432\u043E");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess(); 
			}
		});
		btnGuess.setBounds(222, 136, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043F\u043E\u043F\u044B\u0442\u043E\u043A:");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(29, 188, 380, 44);
		getContentPane().add(lblOutput);
		btnStart.setVisible(false);


		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame ();
				lblOutput.setText("Новая игра");
				theNumberTries = 0;
				btnStart.setVisible(false);
			}
		});
		btnStart.setBounds(68, 136, 117, 23);
		getContentPane().add(btnStart);
	}

	public static void main(String[] args) {
		// TODO Автоматически созданная заглушка метода
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension (450,300));
		theGame.setVisible(true);
	}
}
