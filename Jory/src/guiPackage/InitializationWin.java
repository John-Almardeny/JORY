package guiPackage;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import java.awt.Color;

/**
 * This class creates an initialization frame with a progress bar
 * only in the very first run of the program when it initializes the database
 * for the first time
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class InitializationWin {
	 public static boolean end = false;
	 public static  JProgressBar progressBar;
	 public static JFrame frame;
	 public static JLabel updateLabel;
	/**
	 * constructor creates the frame and its components
	 */
	public InitializationWin() {
		
		frame  = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(InitializationWin.class.getResource("/iconPackage/YM.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 381, 188);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Initializing JORY Program for First Time");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel.setBounds(57, 40, 265, 25);
		frame.getContentPane().add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(31, 131, 321, 18);
		frame.getContentPane().add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(200);
		
		JLabel lblThisMayTake = new JLabel("This May Take A Few Minutes");
		lblThisMayTake.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisMayTake.setForeground(Color.WHITE);
		lblThisMayTake.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblThisMayTake.setBounds(57, 64, 265, 25);
		frame.getContentPane().add(lblThisMayTake);
		
		updateLabel = new JLabel("New label");
		updateLabel.setForeground(Color.LIGHT_GRAY);
		updateLabel.setHorizontalAlignment(SwingConstants.LEADING);
		updateLabel.setBounds(30, 115, 200, 14);
		frame.getContentPane().add(updateLabel);
		
		frame.setVisible(true);
		
	}
	
	/**
	 * This method updates the progress bar
	 * to a value of integer from extractDatabase() method
	 * @param i
	 * @param currentFile
	 */
	public static void update(int i, final String currentFile){
		final int percent = i;
		try {
			if (percent>0 && progressBar!=null){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					progressBar.setValue(percent);
					updateLabel.setText("Extracting " + currentFile);
				}});
			}
			}
			catch (Exception e) {/*Do Nothing*/}
		}
}
