package joryPackage;

import coursePackage.Course;
import guiPackage.GuiListener;
import guiPackage.InitializationWin;
import guiPackage.MainMenuUI;
import guiPackage.SplashScreen;

/**
 * The main entry point to the Program
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class JORY {

	public static void main(String[] args) {
		new Course(); // create a new Course object that contains all subjects
		if (InitializationWin.end){ // if finished extracting the database for first time
		new SplashScreen(); // then shows the splash screen
		new MainMenuUI(new GuiListener()); // create a new MainMenu 
		Course.updateDatabase(); // At the End of the lesson update the database	
		
		}
	}

}
