package guiPackage;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * Splash Screen Class
 * @author Yahya Almardeny
 * @version 03/12/2016
 */

public class SplashScreen {
	
		public  SplashScreen() {
			JFrame frame = new JFrame(); // create new frame
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SplashScreen.class.getResource("/iconPackage/YM.png"))); // set the frame icon
			frame.setResizable(false); // deactivate resizablity
			frame.setUndecorated(true); // disable the native decoration of the frame
			frame.add(new JLabel(new  ImageIcon(this.getClass().getResource("/iconPackage/SplashScreen.gif")))); // set the label image and add it
			frame.pack(); // resize the frame to fit the image
			frame.setLocationRelativeTo(null); // center the splash screen window
			frame.setVisible(true);
			try {
				Thread.sleep(5000); // thread sleep before moving to the main menu
			} catch (InterruptedException e) {/*Do Nothing*/}
			
			frame.dispose(); //then dispose the frame
		}

}
