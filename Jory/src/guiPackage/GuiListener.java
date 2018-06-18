package guiPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import coursePackage.Course;
import fileIOPackage.ImagesIO;
import fileIOPackage.MP3IO;
import resourcesPackage.Subjects;
import soundUtilities.SoundPlayer;
import soundUtilities.VoiceRecorder;


/**
 * This Class has most of the hard work and deals with the user.
 * It listens to the UIs and performs tasks accordingly.
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class GuiListener implements ActionListener{

	public static SubjectUITemplate subjectUI; // UI Template for the subjects, it will be customized slightly at run time.
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		GuiListener listener = new GuiListener(); // create a global-shared GuiListener object for all GUIs that will be used later
		 
		switch (e.getActionCommand()){ // the Action Command will specify which button was pressed
		
		    /*Listen To Main Menu UI*/
		 	case "alphabetButton":
		 		new Thread(new Runnable(){public void run(){
		 			SoundPlayer.playSound(Course.programFolder+File.separator+"Database"+File.separator+"Audio"+File.separator+"SubjectsAudio"+File.separator+"Alphabet.mp3");
		 		}}).start();
		 		subjectUI = new SubjectUITemplate(listener); // create the Subject GUI.
		 		subjectUI.populateList(Course.getAlphabet().getNoun()); // fill out the JList with the nouns of the current Lesson
		 		subjectUI.addImage(SubjectUITemplate.class.getResource("/iconPackage/alphabetImage.jpg"));//set the default image for the Lesson
		 		subjectUI.show(); // show the JFrame
		 		MainMenuUI.getFrmMainMenu().setVisible(false); // hide the Main Menu to be retrieved later on user's demand
		 		GuiActivitiesWatcher.reset(Subjects.Alphabet); // reset the activities references for the current lesson
		 		break;
		 		
		 	case "numbersButton":
		 		new Thread(new Runnable(){public void run(){
		 			SoundPlayer.playSound(Course.programFolder+File.separator+"Database"+File.separator+"Audio"+File.separator+"SubjectsAudio"+File.separator+"Numbers.mp3");
		 		}}).start();
		 		subjectUI = new SubjectUITemplate(listener);
		 		subjectUI.populateList(Course.getNumbers().getNoun());
		 		subjectUI.addImage(SubjectUITemplate.class.getResource("/iconPackage/numbersImage.jpg"));
		 		subjectUI.show();
		 		MainMenuUI.getFrmMainMenu().setVisible(false);
		 		GuiActivitiesWatcher.reset(Subjects.Numbers);
		 		break;
		 		
		 	case "animalsButton":
		 		new Thread(new Runnable(){public void run(){
		 			SoundPlayer.playSound(Course.programFolder+File.separator+"Database"+File.separator+"Audio"+File.separator+"SubjectsAudio"+File.separator+"Animals.mp3");
		 		}}).start();
		 		subjectUI = new SubjectUITemplate(listener);
		 		subjectUI.populateList(Course.getAnimals().getNoun());
		 		subjectUI.addImage(SubjectUITemplate.class.getResource("/iconPackage/animalsImage.jpg"));
		 		subjectUI.show();
		 		MainMenuUI.getFrmMainMenu().setVisible(false);
		 		GuiActivitiesWatcher.reset(Subjects.Animals);
		 		break;
		 		
		 	case "colorsButton":
		 		new Thread(new Runnable(){public void run(){
		 			SoundPlayer.playSound(Course.programFolder+File.separator+"Database"+File.separator+"Audio"+File.separator+"SubjectsAudio"+File.separator+"Colors.mp3");
		 		}}).start();
		 		subjectUI = new SubjectUITemplate(listener);
		 		subjectUI.populateList(Course.getColors().getNoun());
		 		subjectUI.addImage(SubjectUITemplate.class.getResource("/iconPackage/colorsImage.jpg"));
		 		subjectUI.show();
		 		MainMenuUI.getFrmMainMenu().setVisible(false);
		 		GuiActivitiesWatcher.reset(Subjects.Colors);
		 		break;
		 		
		 	case "shapesButton":
		 		new Thread(new Runnable(){public void run(){
		 			SoundPlayer.playSound(Course.programFolder+File.separator+"Database"+File.separator+"Audio"+File.separator+"SubjectsAudio"+File.separator+"Shapes.mp3");
		 		}}).start();
		 		subjectUI = new SubjectUITemplate(listener);
		 		subjectUI.populateList(Course.getShapes().getNoun());
		 		subjectUI.addImage(SubjectUITemplate.class.getResource("/iconPackage/shapesImage.jpg"));
		 		subjectUI.show();
		 		MainMenuUI.getFrmMainMenu().setVisible(false);
		 		GuiActivitiesWatcher.reset(Subjects.Shapes);
		 		break;
		 		
		 	case "vegetButton":
		 		new Thread(new Runnable(){public void run(){
		 			SoundPlayer.playSound(Course.programFolder+File.separator+"Database"+File.separator+"Audio"+File.separator+"SubjectsAudio"+File.separator+"Vegetable.mp3");
		 		}}).start();
		 			subjectUI = new SubjectUITemplate(listener);
		 		subjectUI.populateList(Course.getVegetable().getNoun());
		 		subjectUI.addImage(SubjectUITemplate.class.getResource("/iconPackage/vegetableImage.jpg"));
		 		subjectUI.show();
		 		MainMenuUI.getFrmMainMenu().setVisible(false);
		 		GuiActivitiesWatcher.reset(Subjects.Vegetable);
		 		break;
		 		
		 		
		 	case "fruitButton":
		 		new Thread(new Runnable(){public void run(){
		 			SoundPlayer.playSound(Course.programFolder+File.separator+"Database"+File.separator+"Audio"+File.separator+"SubjectsAudio"+File.separator+"Fruits.mp3");
		 		}}).start();
		 		subjectUI = new SubjectUITemplate(listener);
		 		subjectUI.populateList(Course.getFruit().getNoun());
		 		subjectUI.addImage(SubjectUITemplate.class.getResource("/iconPackage/fruitImage.jpg"));
		 		subjectUI.show();
		 		MainMenuUI.getFrmMainMenu().setVisible(false);
		 		GuiActivitiesWatcher.reset(Subjects.Fruit);
		 		break;
		 		
		 		
		 	/*Listen To Subject UI*/
		 		
		 	case "addButton":
		 		subjectUI.playButton.setEnabled(true);
		 		subjectUI.playAllButton.setEnabled(true);
		 		GuiActivitiesWatcher.mp3 = GuiActivitiesWatcher.voice = false;
		 		GuiActivitiesWatcher.stop = true; // stop the sound if it's running
		 		AddWindow.show(listener); // simply show the AddWindow without touching the current Subject Window
		 		subjectUI.getFrame().setEnabled(false);
		 		break;
		 		
		 	case "editButton":
		 		subjectUI.playButton.setEnabled(true);
		 		subjectUI.playAllButton.setEnabled(true);
		 		GuiActivitiesWatcher.mp3 = false;
		 		GuiActivitiesWatcher.voice = false;
		 		GuiActivitiesWatcher.stop = true;
		 		EditWindow.show(listener); // simply show the EditWindow without touching the current Subject Window
		 		subjectUI.getFrame().setEnabled(false);
		 		break;
		 		
		 	case "deleteButton":
		 		subjectUI.playButton.setEnabled(true);
		 		subjectUI.playAllButton.setEnabled(true);
		 		GuiActivitiesWatcher.mp3 = false;
		 		GuiActivitiesWatcher.voice = false;
		 		GuiActivitiesWatcher.stop = true;
		 		GuiActivitiesWatcher.delete = true;
		 		int dialogResult;
		 		if (subjectUI.getList().getSelectedValue()!=null){ // user has selected something from the list
			 		switch(GuiActivitiesWatcher.flag){ // this flag to indicate which subject we are currently in
				 		case "Alphabet":
				 			dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure That You Want To Delete " + subjectUI.getList().getSelectedValue(),"Warning",JOptionPane.YES_NO_OPTION);
				 			if(dialogResult == JOptionPane.YES_OPTION){
				 				GuiActivitiesWatcher.indexToDelete = subjectUI.getList().getSelectedValue();
				 				new Thread(new Runnable(){ // to run this method asynchronously immediately in the GUI.
				 					public void run(){
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				subjectUI.getList().setSelectedIndex(0);
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				Course.getAlphabet().delete(GuiActivitiesWatcher.indexToDelete );
					 				subjectUI.populateList(Course.getAlphabet().getNoun());
				 					}}).start();
				 				
				 			}
				 		break;
				 		case "Numbers":
				 			dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure That You Want To Delete " + subjectUI.getList().getSelectedValue(),"Warning",JOptionPane.YES_NO_OPTION);
				 			if(dialogResult == JOptionPane.YES_OPTION){
				 				GuiActivitiesWatcher.indexToDelete = subjectUI.getList().getSelectedValue();
				 				new Thread(new Runnable(){ // to run this method asynchronously immediately in the GUI.
				 					public void run(){
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				subjectUI.getList().setSelectedIndex(0);
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				Course.getNumbers().delete(GuiActivitiesWatcher.indexToDelete );
						 			subjectUI.populateList(Course.getNumbers().getNoun());
				 					}}).start();
				 					
				 				
				 			}
				 		break;
				 		case "Animals":
				 			dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure That You Want To Delete " + subjectUI.getList().getSelectedValue(),"Warning",JOptionPane.YES_NO_OPTION);
				 			if(dialogResult == JOptionPane.YES_OPTION){
				 				GuiActivitiesWatcher.indexToDelete = subjectUI.getList().getSelectedValue();
				 				new Thread(new Runnable(){ // to run this method asynchronously immediately in the GUI.
				 					public void run(){
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				subjectUI.getList().setSelectedIndex(0);
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				Course.getAnimals().delete(GuiActivitiesWatcher.indexToDelete );
					 				subjectUI.populateList(Course.getAnimals().getNoun());
				 					}}).start();
				 				
				 			}
				 		break;
				 		case "Colors":
				 			dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure That You Want To Delete " + subjectUI.getList().getSelectedValue(),"Warning",JOptionPane.YES_NO_OPTION);
				 			if(dialogResult == JOptionPane.YES_OPTION){
				 				GuiActivitiesWatcher.indexToDelete = subjectUI.getList().getSelectedValue();
				 				new Thread(new Runnable(){ // to run this method asynchronously immediately in the GUI.
				 					public void run(){
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				subjectUI.getList().setSelectedIndex(0);
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				Course.getColors().delete(GuiActivitiesWatcher.indexToDelete );
					 				subjectUI.populateList(Course.getColors().getNoun());
				 					}}).start();
				 				
				 			}
				 		break;
				 		case "Shapes":
				 			dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure That You Want To Delete " + subjectUI.getList().getSelectedValue(),"Warning",JOptionPane.YES_NO_OPTION);
				 			if(dialogResult == JOptionPane.YES_OPTION){
				 				GuiActivitiesWatcher.indexToDelete = subjectUI.getList().getSelectedValue();
				 				new Thread(new Runnable(){ // to run this method asynchronously immediately in the GUI.
				 					public void run(){
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				subjectUI.getList().setSelectedIndex(0);
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				Course.getShapes().delete(GuiActivitiesWatcher.indexToDelete );
					 				subjectUI.populateList(Course.getShapes().getNoun());
				 					}}).start();
				 				
				 			}
				 			
				 		break;
				 		case "Vegetable":
				 			dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure That You Want To Delete " + subjectUI.getList().getSelectedValue(),"Warning",JOptionPane.YES_NO_OPTION);
				 			if(dialogResult == JOptionPane.YES_OPTION){
				 				GuiActivitiesWatcher.indexToDelete = subjectUI.getList().getSelectedValue();
				 				new Thread(new Runnable(){ // to run this method asynchronously immediately in the GUI.
				 					public void run(){
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				subjectUI.getList().setSelectedIndex(0);
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				Course.getVegetable().delete(GuiActivitiesWatcher.indexToDelete );
					 				subjectUI.populateList(Course.getVegetable().getNoun());
				 					}}).start();
				 				
				 			}
				 			
				 		break;
				 		
				 		case "Fruit":
				 			dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure That You Want To Delete " + subjectUI.getList().getSelectedValue(),"Warning",JOptionPane.YES_NO_OPTION);
				 			if(dialogResult == JOptionPane.YES_OPTION){
				 				GuiActivitiesWatcher.indexToDelete = subjectUI.getList().getSelectedValue();
				 				new Thread(new Runnable(){ // to run this method asynchronously immediately in the GUI.
				 					public void run(){
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				subjectUI.getList().setSelectedIndex(0);
					 				GuiActivitiesWatcher.stop = true;
					 				SoundPlayer.stopAudio();
					 				Course.getFruit().delete(GuiActivitiesWatcher.indexToDelete );
					 				subjectUI.populateList(Course.getFruit().getNoun());
				 					}}).start();
				 				
				 			}
				 			
				 		break;
			 		}
		 		}
		 		else{JOptionPane.showMessageDialog(null, "First You Need To Select An Item From The List","Information",JOptionPane.INFORMATION_MESSAGE);}
		 		GuiActivitiesWatcher.stop = false;
		 		break;
		 		
		    case "playButton":
		    	GuiActivitiesWatcher.stop = true;
		 		GuiActivitiesWatcher.stop = false;
		 		if(subjectUI.getList().getSelectedIndex()!=-1){subjectUI.playAllButton.setEnabled(false);}
		 		switch(GuiActivitiesWatcher.flag){
			 		case "Alphabet":
			 			if(GuiActivitiesWatcher.loop && subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
			 			     public void run(){
			 			    	while(!GuiActivitiesWatcher.stop){SoundPlayer.playSound(Course.getSound(Subjects.Alphabet, subjectUI.getList().getSelectedValue()));}
			 			    	subjectUI.playAllButton.setEnabled(true);}}).start();
			 				}
			 			
			 			else if (subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
				 			    public void run(){
				 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Alphabet, subjectUI.getList().getSelectedValue()));
				 			    	subjectUI.playAllButton.setEnabled(true);
				 			    }}).start();
			 			}
			 				
			 			break;
			 			
			 		case "Numbers":
			 			if(GuiActivitiesWatcher.loop && subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
			 					public void run(){
			 						while(!GuiActivitiesWatcher.stop){SoundPlayer.playSound(Course.getSound(Subjects.Numbers, subjectUI.getList().getSelectedValue()));}
			 						subjectUI.playAllButton.setEnabled(true);}}).start();
			 					}
			 			else if (subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
				 			     public void run(){
				 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Numbers, subjectUI.getList().getSelectedValue()));
				 			    	subjectUI.playAllButton.setEnabled(true);
				 			     }}).start();
			 				}
			 			break;
			 			
			 		case "Animals":
			 			if(GuiActivitiesWatcher.loop && subjectUI.getList().getSelectedValue()!=null){new Thread(new Runnable() {
			 			    public void run(){while(!GuiActivitiesWatcher.stop){SoundPlayer.playSound(Course.getSound(Subjects.Animals, subjectUI.getList().getSelectedValue()));}
			 			   subjectUI.playAllButton.setEnabled(true);}}).start();
			 			}
			 			
			 			else if (subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
				 			     public void run(){
				 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Animals, subjectUI.getList().getSelectedValue()));
				 			    	subjectUI.playAllButton.setEnabled(true);
				 			     }}).start();
			 				}
			 			break;
			 			
			 		case "Colors":
			 			if(GuiActivitiesWatcher.loop && subjectUI.getList().getSelectedValue()!=null){new Thread(new Runnable() {
			 			    public void run(){while(!GuiActivitiesWatcher.stop){SoundPlayer.playSound(Course.getSound(Subjects.Colors, subjectUI.getList().getSelectedValue()));}
			 			   subjectUI.playAllButton.setEnabled(true);}}).start();
			 			}
			 			else if (subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
				 			     public void run(){
				 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Colors, subjectUI.getList().getSelectedValue()));
				 			    	subjectUI.playAllButton.setEnabled(true);
				 			     }}).start();
			 				}
			 			break;
			 			
			 		case "Shapes":
			 			if(GuiActivitiesWatcher.loop && subjectUI.getList().getSelectedValue()!=null){new Thread(new Runnable() {
			 			    public void run(){while(!GuiActivitiesWatcher.stop){SoundPlayer.playSound(Course.getSound(Subjects.Shapes, subjectUI.getList().getSelectedValue()));}
			 			   subjectUI.playAllButton.setEnabled(true);}}).start();
			 			}
			 			else if (subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
				 			     public void run(){
				 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Shapes, subjectUI.getList().getSelectedValue()));
				 			    	subjectUI.playAllButton.setEnabled(true);
				 			     }}).start();
			 				}
			 			break;
			 			
			 		case "Vegetable":
			 			if(GuiActivitiesWatcher.loop && subjectUI.getList().getSelectedValue()!=null){new Thread(new Runnable() {
			 			    public void run(){while(!GuiActivitiesWatcher.stop){SoundPlayer.playSound(Course.getSound(Subjects.Vegetable, subjectUI.getList().getSelectedValue()));}
			 			   subjectUI.playAllButton.setEnabled(true);}}).start();
			 			}
			 			else if (subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
				 			     public void run(){
				 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Vegetable, subjectUI.getList().getSelectedValue()));
				 			    	subjectUI.playAllButton.setEnabled(true);
				 			     }}).start();
			 				}
			 			break;
			 			
			 		case "Fruit":
			 			if(GuiActivitiesWatcher.loop && subjectUI.getList().getSelectedValue()!=null){new Thread(new Runnable() {
			 			    public void run(){while(!GuiActivitiesWatcher.stop){SoundPlayer.playSound(Course.getSound(Subjects.Fruit, subjectUI.getList().getSelectedValue()));}
			 			   subjectUI.playAllButton.setEnabled(true);}}).start();
			 			}
			 			else if (subjectUI.getList().getSelectedValue()!=null){
			 				new Thread(new Runnable() {
				 			     public void run(){
				 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Fruit, subjectUI.getList().getSelectedValue()));
				 			    	subjectUI.playAllButton.setEnabled(true);
				 			     }}).start();
			 				}
			 			break;
		 		}
		 		break;
		 		
		 	case "playAllButton":
		 		subjectUI.playAllButton.setEnabled(false);
		 		subjectUI.playButton.setEnabled(false);
		 		GuiActivitiesWatcher.stop = false;
		 		GuiActivitiesWatcher.counter = 0;
		 		switch(GuiActivitiesWatcher.flag){
			 		case "Alphabet":
			 			new Thread(new Runnable(){
			 				public void run(){		
			 			if(GuiActivitiesWatcher.loop){
			 				while(!GuiActivitiesWatcher.stop){
				 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
				 				 showImage(Subjects.Alphabet);
				 				SoundPlayer.playSound(Course.getSound(Subjects.Alphabet, Course.getAlphabet().getNoun().get(GuiActivitiesWatcher.counter)));
								 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
						         GuiActivitiesWatcher.incrementCounter();
						         if (GuiActivitiesWatcher.counter==Course.getAlphabet().getNoun().size()){GuiActivitiesWatcher.counter = 0;} //reset the loop
			 			  }
			 			}
			 			else{while(!GuiActivitiesWatcher.stop && GuiActivitiesWatcher.counter<Course.getAlphabet().getNoun().size()){
			 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Alphabet);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Alphabet, Course.getAlphabet().getNoun().get(GuiActivitiesWatcher.counter)));
			 				 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							 GuiActivitiesWatcher.incrementCounter();
							 if ( GuiActivitiesWatcher.counter==Course.getAlphabet().getNoun().size()){subjectUI.playAllButton.setEnabled(true);
							 subjectUI.playButton.setEnabled(true);}
			 				}
			 			}
			 				}}).start();
			 			
			 		break;
			 		case "Numbers":
			 			new Thread(new Runnable(){
			 				public void run(){
			 			
			 			if(GuiActivitiesWatcher.loop){while(!GuiActivitiesWatcher.stop){
			 				subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				showImage(Subjects.Numbers);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Numbers, Course.getNumbers().getNoun().get(GuiActivitiesWatcher.counter)));
							     try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							     GuiActivitiesWatcher.incrementCounter();
							     if (GuiActivitiesWatcher.counter==Course.getNumbers().getNoun().size()){GuiActivitiesWatcher.counter = 0;} //reset the loop
			 					}
			 			}
			 			else{while(!GuiActivitiesWatcher.stop && GuiActivitiesWatcher.counter<Course.getNumbers().getNoun().size()){
			 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Numbers);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Numbers, Course.getNumbers().getNoun().get(GuiActivitiesWatcher.counter)));
							 GuiActivitiesWatcher.incrementCounter();
							 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							 if ( GuiActivitiesWatcher.counter==Course.getNumbers().getNoun().size()){subjectUI.playAllButton.setEnabled(true);subjectUI.playButton.setEnabled(true);}
			 				}
			 			}
			 			 }}).start();
			 			
			 			
			 		break;

			 		case "Animals":
			 			new Thread(new Runnable(){
			 				public void run(){
			 			
			 			if(GuiActivitiesWatcher.loop){while(!GuiActivitiesWatcher.stop){
			 				subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Animals);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Animals, Course.getAnimals().getNoun().get(GuiActivitiesWatcher.counter)));
							     GuiActivitiesWatcher.incrementCounter();
							     try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							     if (GuiActivitiesWatcher.counter==Course.getAnimals().getNoun().size()){GuiActivitiesWatcher.counter = 0;} //reset the loop
			 					}
			 			}
			 			else{while(!GuiActivitiesWatcher.stop && GuiActivitiesWatcher.counter<Course.getAnimals().getNoun().size()){
			 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Animals);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Animals, Course.getAnimals().getNoun().get(GuiActivitiesWatcher.counter)));
							 GuiActivitiesWatcher.incrementCounter();
							 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							 if ( GuiActivitiesWatcher.counter==Course.getAnimals().getNoun().size()){subjectUI.playAllButton.setEnabled(true);subjectUI.playButton.setEnabled(true);}
			 				}
			 			}
			 				}}).start();
			 		break;
			 		
			 		case "Colors":
			 			new Thread(new Runnable(){
			 				public void run(){
			 			
			 			if(GuiActivitiesWatcher.loop){while(!GuiActivitiesWatcher.stop){
			 				subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Colors);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Colors, Course.getColors().getNoun().get(GuiActivitiesWatcher.counter)));
							     GuiActivitiesWatcher.incrementCounter();
							     try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							     if (GuiActivitiesWatcher.counter==Course.getColors().getNoun().size()){GuiActivitiesWatcher.counter = 0;} //reset the loop
			 					}
			 			}
			 			else{while(!GuiActivitiesWatcher.stop && GuiActivitiesWatcher.counter<Course.getColors().getNoun().size()){
			 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Colors);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Colors, Course.getColors().getNoun().get(GuiActivitiesWatcher.counter)));
							 GuiActivitiesWatcher.incrementCounter();
							 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							 if ( GuiActivitiesWatcher.counter==Course.getColors().getNoun().size()){subjectUI.playAllButton.setEnabled(true);subjectUI.playButton.setEnabled(true);}
			 				}
			 			}
			 				}}).start();
			 		break;
			 		
			 		case "Shapes":
			 			new Thread(new Runnable(){
			 				public void run(){
			 			
			 			if(GuiActivitiesWatcher.loop){while(!GuiActivitiesWatcher.stop){
			 				subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Shapes);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Shapes, Course.getShapes().getNoun().get(GuiActivitiesWatcher.counter)));
							     GuiActivitiesWatcher.incrementCounter();
							     try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							     if (GuiActivitiesWatcher.counter==Course.getShapes().getNoun().size()){GuiActivitiesWatcher.counter = 0;} //reset the loop
			 					}
			 			}
			 			else{while(!GuiActivitiesWatcher.stop && GuiActivitiesWatcher.counter<Course.getShapes().getNoun().size()){
			 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Shapes);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Shapes, Course.getShapes().getNoun().get(GuiActivitiesWatcher.counter)));
							 GuiActivitiesWatcher.incrementCounter();
							 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							 if ( GuiActivitiesWatcher.counter==Course.getShapes().getNoun().size()){subjectUI.playAllButton.setEnabled(true);subjectUI.playButton.setEnabled(true);}
			 				}
			 			}
			 				}}).start();
			 		break;
			 		
			 		case "Vegetable":
			 			new Thread(new Runnable(){
			 				public void run(){
			 			
			 			if(GuiActivitiesWatcher.loop){while(!GuiActivitiesWatcher.stop){
			 				subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				showImage(Subjects.Vegetable);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Vegetable, Course.getVegetable().getNoun().get(GuiActivitiesWatcher.counter)));
							     GuiActivitiesWatcher.incrementCounter();
							     try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							     if (GuiActivitiesWatcher.counter==Course.getVegetable().getNoun().size()){GuiActivitiesWatcher.counter = 0;} //reset the loop
			 					}
			 			}
			 			else{while(!GuiActivitiesWatcher.stop && GuiActivitiesWatcher.counter<Course.getVegetable().getNoun().size()){
			 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Vegetable);
			 				 SoundPlayer.playSound(Course.getSound(Subjects.Vegetable, Course.getVegetable().getNoun().get(GuiActivitiesWatcher.counter)));
							 GuiActivitiesWatcher.incrementCounter();
							 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							 if ( GuiActivitiesWatcher.counter==Course.getVegetable().getNoun().size()){subjectUI.playAllButton.setEnabled(true);subjectUI.playButton.setEnabled(true);}
			 				}
			 			}
			 				}}).start();
			 		break;
			 		
			 		case "Fruit":
			 			new Thread(new Runnable(){
			 				public void run(){
			 			
			 			if(GuiActivitiesWatcher.loop){while(!GuiActivitiesWatcher.stop){
			 				subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				showImage(Subjects.Fruit);
			 				SoundPlayer.playSound(Course.getSound(Subjects.Fruit, Course.getFruit().getNoun().get(GuiActivitiesWatcher.counter)));
							     GuiActivitiesWatcher.incrementCounter();
							     try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							     if (GuiActivitiesWatcher.counter==Course.getFruit().getNoun().size()){GuiActivitiesWatcher.counter = 0;} //reset the loop
			 					}
			 			}
			 			else{while(!GuiActivitiesWatcher.stop && GuiActivitiesWatcher.counter<Course.getFruit().getNoun().size()){
			 				 subjectUI.getList().setSelectedIndex(GuiActivitiesWatcher.counter);
			 				 showImage(Subjects.Fruit);
			 				 SoundPlayer.playSound(Course.getSound(Subjects.Fruit, Course.getFruit().getNoun().get(GuiActivitiesWatcher.counter)));
							 GuiActivitiesWatcher.incrementCounter();
							 try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
							 if ( GuiActivitiesWatcher.counter==Course.getShapes().getNoun().size()){subjectUI.playAllButton.setEnabled(true);subjectUI.playButton.setEnabled(true);}
			 				}
			 			}
			 				}}).start();
			 		break;
		 		}
		 		
		 		break;
		 	
		 	    
		 		
		 	case "stopButton":
		 		GuiActivitiesWatcher.stop = true;
		 		subjectUI.playButton.setEnabled(true);
		 		subjectUI.playAllButton.setEnabled(true);
		 		SoundPlayer.stopAudio();
		 		break;
		 		
		 	case "nextButton":
		 			switch(GuiActivitiesWatcher.flag){
				 		case "Alphabet":
				 			if (subjectUI.getList().getSelectedIndex() < Course.getAlphabet().getNoun().size()){
				 				SoundPlayer.stopAudio();
				 				subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()+1);				
				 			}
				 			break;
				 		case "Numbers":
				 			if (subjectUI.getList().getSelectedIndex() < Course.getNumbers().getNoun().size()){
				 				SoundPlayer.stopAudio();
				 				subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()+1);				 				
				 			}
				 			break;
				 		case "Animals":
				 			if (subjectUI.getList().getSelectedIndex() < Course.getAnimals().getNoun().size()){
				 				SoundPlayer.stopAudio();
				 				subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()+1);			 				
				 			}
				 			break;
				 		case "Colors":
				 			if (subjectUI.getList().getSelectedIndex() < Course.getColors().getNoun().size()){
				 				SoundPlayer.stopAudio();
				 				subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()+1);			
				 			}
				 			break;
				 		case "Shapes":
				 			if (subjectUI.getList().getSelectedIndex() < Course.getShapes().getNoun().size()){
				 				SoundPlayer.stopAudio();
				 				subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()+1);	
				 			}
				 			break;
				 		case "Vegetable":
				 			if (subjectUI.getList().getSelectedIndex() < Course.getVegetable().getNoun().size()){
				 				SoundPlayer.stopAudio();
				 				subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()+1);
				 			}
				 			break;
				 			
				 		case "Fruit":
				 			if (subjectUI.getList().getSelectedIndex() < Course.getFruit().getNoun().size()){
				 				SoundPlayer.stopAudio();
				 				subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()+1);	
				 			}
				 			break;
		 			}
		 		break;
		 		
		 	case "previousButton":
		 		if(subjectUI.getList().getSelectedIndex()>0){
		 			SoundPlayer.stopAudio();
		 			subjectUI.getList().setSelectedIndex(subjectUI.getList().getSelectedIndex()-1);
		 		}
		 		break;
		 	
		 		
		 	case "loopCheckBox":
		 		GuiActivitiesWatcher.loop = subjectUI.getLoopCheckBox().isSelected();
		 		try{SoundPlayer.stopAudio(); GuiActivitiesWatcher.stop = true;}catch(Exception ex){}
		 		subjectUI.playButton.setEnabled(true);
		 		subjectUI.playAllButton.setEnabled(true);
		 		break;
		 		
		 		

		 		
		 	/*Listen To AddWindow*/
		 	case "browseMP3Button":
		 		if(GuiActivitiesWatcher.firstMP3Browse){MP3IO.setMp3Dir(null);}
			 	  else{try{new File(MP3IO.getMp3Dir()).delete(); }catch(Exception ex){ex.printStackTrace();}}
			 		switch (GuiActivitiesWatcher.flag){
				 		case "Alphabet":
				 			
				 			if(MP3IO.addMP3(Subjects.Alphabet)){
				 				GuiActivitiesWatcher.voice = false;
						 		GuiActivitiesWatcher.mp3 = true;
						 		GuiActivitiesWatcher.firstMP3Browse = false;
				 			}
				 			break;
				 		case "Numbers":
				 			
				 			if(MP3IO.addMP3(Subjects.Numbers)){
				 				GuiActivitiesWatcher.voice = false;
						 		GuiActivitiesWatcher.mp3 = true;
						 		GuiActivitiesWatcher.firstMP3Browse = false;
				 			}
				 			break;
				 		case "Animals":
				 			
				 			if(MP3IO.addMP3(Subjects.Animals)){
				 				GuiActivitiesWatcher.voice = false;
						 		GuiActivitiesWatcher.mp3 = true;
						 		GuiActivitiesWatcher.firstMP3Browse = false;
				 			}
				 			break;
				 		case "Colors":
				 			
				 			if(MP3IO.addMP3(Subjects.Colors)){
				 				GuiActivitiesWatcher.voice = false;
						 		GuiActivitiesWatcher.mp3 = true;
						 		GuiActivitiesWatcher.firstMP3Browse = false;
				 			}
				 			break;
				 		case "Shapes":
				 			
				 			if(MP3IO.addMP3(Subjects.Shapes)){
				 				GuiActivitiesWatcher.voice = false;
						 		GuiActivitiesWatcher.mp3 = true;
						 		GuiActivitiesWatcher.firstMP3Browse = false;
				 			}
				 			break;
				 		case "Vegetable":
				 			
				 			if(MP3IO.addMP3(Subjects.Vegetable)){
				 				GuiActivitiesWatcher.voice = false;
						 		GuiActivitiesWatcher.mp3 = true;
						 		GuiActivitiesWatcher.firstMP3Browse = false;
				 			}
				 			break;
				 		case "Fruit":
				 		
				 			if(MP3IO.addMP3(Subjects.Fruit)){
				 				GuiActivitiesWatcher.voice = false;
						 		GuiActivitiesWatcher.mp3 = true;
						 		GuiActivitiesWatcher.firstMP3Browse = false;
				 			}
				 			break;
			 		}
		 		
		 		break;
		 			
		 		
		 		
		 
		 		
		 	case "recordButton":
		 	  AddWindow.recordButton.setEnabled(false);
		 	  AddWindow.saveChangesbutton.setEnabled(false);
		 	 AddWindow.playRecordedVoiceButton.setEnabled(false);
		 	  setRecordingStatus("Recording...");
		 	  if(GuiActivitiesWatcher.firstRecording){VoiceRecorder.resetWaveFile();}
		 	  else{try{VoiceRecorder.deleteCurrentRecord(); }catch(Exception ex){ex.printStackTrace();}}
		 	  switch (GuiActivitiesWatcher.flag){
			 		case "Alphabet":
			 			new Thread(new Runnable(){
			 				public void run(){
			 					new VoiceRecorder(Subjects.Alphabet);
					 			VoiceRecorder.start();
			 				}
			 			}).start();
			 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Alphabet);}
			 			
			 			break;
			 		case "Numbers":
			 			new Thread(new Runnable(){
			 				public void run(){
			 					
					 			new VoiceRecorder(Subjects.Numbers);
					 			VoiceRecorder.start();
			 				}
			 			}).start();
			 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Numbers);}
			 			break;
			 		case "Animals":
			 			new Thread(new Runnable(){
			 				public void run(){
					 			new VoiceRecorder(Subjects.Animals);
					 			VoiceRecorder.start();
			 				}
			 			}).start();
			 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Animals);}
			 			break;
			 		case "Colors":
			 			new Thread(new Runnable(){
			 				public void run(){
					 			new VoiceRecorder(Subjects.Colors);
					 			VoiceRecorder.start();
			 				}
			 			}).start();
			 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Colors);}
			 			break;
			 		case "Shapes":
			 			new Thread(new Runnable(){
			 				public void run(){
					 			new VoiceRecorder(Subjects.Shapes);
					 			VoiceRecorder.start();
			 				}
			 			}).start();
			 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Shapes);}
			 			break;
			 		case "Vegetable":
			 			new Thread(new Runnable(){
			 				public void run(){
					 			new VoiceRecorder(Subjects.Vegetable);
					 			VoiceRecorder.start();
			 				}
			 			}).start();
			 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Vegetable);}
			 			break;
			 			
			 		case "Fruit":
			 			new Thread(new Runnable(){
			 				public void run(){
					 			new VoiceRecorder(Subjects.Fruit);
					 			VoiceRecorder.start();
			 				}
			 			}).start();
			 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Fruit);}
			 			break;
		 	  }
		 	 GuiActivitiesWatcher.firstRecording=false;
		 	 GuiActivitiesWatcher.voice = true;
	 		 GuiActivitiesWatcher.mp3 = false;
		 		break;
		 		
		 	case "stopRecodringButton":
		 		 AddWindow.recordButton.setEnabled(true);
			 	 AddWindow.saveChangesbutton.setEnabled(true);
			 	 AddWindow.playRecordedVoiceButton.setEnabled(true);
		 		setRecordingStatus("Stopped!");
		 		SoundPlayer.stopAudio();
		 		new Thread(new Runnable(){public void run(){VoiceRecorder.finish();}}).start();
		 		break;
		 		
		 	case "playRecordedVoiceButton":
		 		 
		 		if (!GuiActivitiesWatcher.firstRecording){setRecordingStatus("Playing...");}
		 		new Thread(new Runnable(){
		 			public void run(){
		 				if(VoiceRecorder.getWavFile()!=null && AddWindow.recordButton.isEnabled()){
			 				AddWindow.recordButton.setEnabled(false);
			 				SoundPlayer.playSound(VoiceRecorder.getWavFile().toString());
			 				setRecordingStatus("");
			 				AddWindow.recordButton.setEnabled(true);
		 			}
		 			}
		 		}).start();
		 		
		 		break;

		 		
		 	case "browseImagebutton":
		 		if(GuiActivitiesWatcher.firstImageBrowse){ImagesIO.setImageDir(null);}
			 	  else{try{new File(ImagesIO.getImageDir()).delete(); }catch(Exception ex){ex.printStackTrace();}}
		 		switch (GuiActivitiesWatcher.flag){
			 		case "Alphabet":
			 		
			 			if(ImagesIO.addImage(Subjects.Alphabet)){GuiActivitiesWatcher.firstImageBrowse = false;}
			 			break;
			 		case "Numbers":
			 			
			 			if(ImagesIO.addImage(Subjects.Numbers)){GuiActivitiesWatcher.firstImageBrowse = false;}
			 			break;
			 		case "Animals":
			 			
			 			if(ImagesIO.addImage(Subjects.Animals)){GuiActivitiesWatcher.firstImageBrowse = false;}
			 			break;
			 		case "Colors":
			 			
			 			if(ImagesIO.addImage(Subjects.Colors)){GuiActivitiesWatcher.firstImageBrowse = false;}
			 			break;
			 		case "Shapes":
			 			
			 			if(ImagesIO.addImage(Subjects.Shapes)){GuiActivitiesWatcher.firstImageBrowse = false;}
			 			break;
			 		case "Vegetable":
			 			
			 			if(ImagesIO.addImage(Subjects.Vegetable)){GuiActivitiesWatcher.firstImageBrowse = false;}
			 			break;
			 			
			 		case "Fruit":
			 			
			 			if(ImagesIO.addImage(Subjects.Fruit)){GuiActivitiesWatcher.firstImageBrowse = false;}
			 			break;
		 		}
		 		GuiActivitiesWatcher.firstImageBrowse = false;
		 		break;
		 		
		 	case "saveChangesbutton":
		 		String noun="", sound = null, image = null;
		 		switch (GuiActivitiesWatcher.flag){
			 		case "Alphabet":
			 			try{
			 				noun = AddWindow.getNoun();
			 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} 
			 				else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
					 		image = ImagesIO.getImageDir();
			 			}
			 			catch(Exception ex){
			 				JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);
			 			}
			 			if (!noun.replaceAll(" ", "").isEmpty() && sound!=null && image!=null){
			 				Course.getAlphabet().addNew(noun,sound,image);
			 				subjectUI.populateList(Course.getAlphabet().getNoun());
					 		JOptionPane.showMessageDialog(null, "The New Item has been Added Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
					 		GuiActivitiesWatcher.firstRecording=true;
					 		GuiActivitiesWatcher.firstMP3Browse = true;
					 		GuiActivitiesWatcher.firstImageBrowse = true;
					 		AddWindow.getFrame().dispose();
					 		subjectUI.getFrame().setEnabled(true);
			 			}
			 			else{JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);}
			 			break;
			 			
			 		case "Numbers":
			 			try{
			 				noun = AddWindow.getNoun();
			 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} 
			 				else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
					 		image = ImagesIO.getImageDir();
			 			}
			 			catch(Exception ex){
			 				JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);
			 			}
			 			if (!noun.replaceAll(" ", "").isEmpty() && sound!=null && image!=null){
			 				Course.getNumbers().addNew(noun,sound,image);
			 				subjectUI.populateList(Course.getNumbers().getNoun());
					 		JOptionPane.showMessageDialog(null, "The New Item has been Added Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
					 		GuiActivitiesWatcher.firstRecording=true;
					 		GuiActivitiesWatcher.firstMP3Browse = true;
					 		GuiActivitiesWatcher.firstImageBrowse = true;
					 		AddWindow.getFrame().dispose();
					 		subjectUI.getFrame().setEnabled(true);
			 			}
			 			else{JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);}
			 			break;
			 		case "Animals":
			 			try{
			 				noun = AddWindow.getNoun();
			 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} 
			 				else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
					 		image = ImagesIO.getImageDir();
			 			}
			 			catch(Exception ex){
			 				JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);
			 			}
			 			if (!noun.replaceAll(" ", "").isEmpty() && sound!=null && image!=null){
			 				Course.getAnimals().addNew(noun,sound,image);
			 				subjectUI.populateList(Course.getAnimals().getNoun());
					 		JOptionPane.showMessageDialog(null, "The New Item has been Added Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
					 		GuiActivitiesWatcher.firstRecording=true;
					 		GuiActivitiesWatcher.firstMP3Browse = true;
					 		GuiActivitiesWatcher.firstImageBrowse = true;
					 		AddWindow.getFrame().dispose();
					 		subjectUI.getFrame().setEnabled(true);
			 			}
			 			else{JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);}
			 			break;
			 		case "Colors":
			 			try{
			 				noun = AddWindow.getNoun();
			 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} 
			 				else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
					 		image = ImagesIO.getImageDir();
			 			}
			 			catch(Exception ex){
			 				JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);
			 			}
			 			if (!noun.replaceAll(" ", "").isEmpty() && sound!=null && image!=null){
			 				Course.getColors().addNew(noun,sound,image);
			 				subjectUI.populateList(Course.getColors().getNoun());
					 		JOptionPane.showMessageDialog(null, "The New Item has been Added Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
					 		GuiActivitiesWatcher.firstRecording=true;
					 		GuiActivitiesWatcher.firstMP3Browse = true;
					 		GuiActivitiesWatcher.firstImageBrowse = true;
					 		AddWindow.getFrame().dispose();
					 		subjectUI.getFrame().setEnabled(true);
			 			}
			 			else{JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);}
			 			break;
			 		case "Shapes":
			 			try{
			 				noun = AddWindow.getNoun();
			 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} 
			 				else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
					 		image = ImagesIO.getImageDir();
			 			}
			 			catch(Exception ex){
			 				JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);
			 			}
			 			if (!noun.replaceAll(" ", "").isEmpty() && sound!=null && image!=null){
			 				Course.getShapes().addNew(noun,sound,image);
			 				subjectUI.populateList(Course.getShapes().getNoun());
					 		JOptionPane.showMessageDialog(null, "The New Item has been Added Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
					 		GuiActivitiesWatcher.firstRecording=true;
					 		GuiActivitiesWatcher.firstMP3Browse = true;
					 		GuiActivitiesWatcher.firstImageBrowse = true;
					 		AddWindow.getFrame().dispose();
					 		subjectUI.getFrame().setEnabled(true);
			 			}
			 			else{JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);}
			 			break;
			 			
			 		case "Vegetable":
			 			try{
			 				noun = AddWindow.getNoun();
			 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} 
			 				else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
					 		image = ImagesIO.getImageDir();
			 			}
			 			catch(Exception ex){
			 				JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);
			 			}
			 			if (!noun.replaceAll(" ", "").isEmpty() && sound!=null && image!=null){
			 				Course.getVegetable().addNew(noun,sound,image);
			 				subjectUI.populateList(Course.getVegetable().getNoun());
					 		JOptionPane.showMessageDialog(null, "The New Item has been Added Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
					 		GuiActivitiesWatcher.firstRecording=true;
					 		GuiActivitiesWatcher.firstMP3Browse = true;
					 		GuiActivitiesWatcher.firstImageBrowse = true;
					 		AddWindow.getFrame().dispose();
					 		subjectUI.getFrame().setEnabled(true);
			 			}
			 			else{JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);}
			 			break;
			 			
			 		case "Fruit":
			 			try{
			 				noun = AddWindow.getNoun();
			 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} 
			 				else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
					 		image = ImagesIO.getImageDir();
			 			}
			 			catch(Exception ex){
			 				JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);
			 			}
			 			if (!noun.replaceAll(" ", "").isEmpty() && sound!=null && image!=null){
			 				Course.getFruit().addNew(noun,sound,image);
			 				subjectUI.populateList(Course.getFruit().getNoun());
					 		JOptionPane.showMessageDialog(null, "The New Item has been Added Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
					 		GuiActivitiesWatcher.firstRecording=true;
					 		GuiActivitiesWatcher.firstMP3Browse = true;
					 		GuiActivitiesWatcher.firstImageBrowse = true;
					 		AddWindow.getFrame().dispose();
					 		subjectUI.getFrame().setEnabled(true);
			 			}
			 			else{JOptionPane.showMessageDialog(null, "Please Add Sound, Noun and Image","Error",JOptionPane.ERROR_MESSAGE);}
			 			break;
			 			
	 		}
		 		
		 		break;
		 		
		 	case "cancelButton":
		 		try{if(GuiActivitiesWatcher.mp3){SoundPlayer.stopAudio(); MP3IO.deleteMP3();}}catch(Exception ex){}
		 		try{if (GuiActivitiesWatcher.voice){VoiceRecorder.finish(); VoiceRecorder.deleteCurrentRecord();}}catch(Exception ex){}
		 		try{ImagesIO.deleteImage();}catch(Exception ex){}
		 		GuiActivitiesWatcher.firstMP3Browse = true;
		 		GuiActivitiesWatcher.firstRecording = true;
		 		GuiActivitiesWatcher.firstImageBrowse = true;
		 		AddWindow.getFrame().dispose();
		 		subjectUI.getFrame().setEnabled(true);
		 		break;
		 	
		 		
		 		
		 		
		 	/*Listen To EditWindow*/
			case "browseMP3ButtonE":
				if(GuiActivitiesWatcher.firstMP3Browse){MP3IO.setMp3Dir(null);}
			 	  else{try{new File(MP3IO.getMp3Dir()).delete(); }catch(Exception ex){ex.printStackTrace();}}
				switch (GuiActivitiesWatcher.flag){
			 		case "Alphabet":
			 			if(MP3IO.addMP3(Subjects.Alphabet)){
			 				GuiActivitiesWatcher.voice = false;
					 		GuiActivitiesWatcher.mp3 = true;
					 		GuiActivitiesWatcher.firstMP3Browse = false;
			 			}
			 			break;
			 		case "Numbers":
			 			if(MP3IO.addMP3(Subjects.Numbers)){
			 				GuiActivitiesWatcher.voice = false;
					 		GuiActivitiesWatcher.mp3 = true;
					 		GuiActivitiesWatcher.firstMP3Browse = false;
			 			}
			 			break;
			 		case "Animals":
			 			if(MP3IO.addMP3(Subjects.Animals)){
			 				GuiActivitiesWatcher.voice = false;
					 		GuiActivitiesWatcher.mp3 = true;
					 		GuiActivitiesWatcher.firstMP3Browse = false;
			 			}
			 			break;
			 		case "Colors":
			 			if(MP3IO.addMP3(Subjects.Colors)){
			 				GuiActivitiesWatcher.voice = false;
					 		GuiActivitiesWatcher.mp3 = true;
					 		GuiActivitiesWatcher.firstMP3Browse = false;
			 			}
			 			break;
			 		case "Shapes":
			 			
			 			if(MP3IO.addMP3(Subjects.Shapes)){
			 				GuiActivitiesWatcher.voice = false;
					 		GuiActivitiesWatcher.mp3 = true;
					 		GuiActivitiesWatcher.firstMP3Browse = false;
			 			}
			 			break;
			 		case "Vegetable":
			 		
			 			if(MP3IO.addMP3(Subjects.Vegetable)){
			 				GuiActivitiesWatcher.voice = false;
					 		GuiActivitiesWatcher.mp3 = true;
					 		GuiActivitiesWatcher.firstMP3Browse = false;
			 			}
			 			break;
			 			
			 		case "Fruit":
			 		
			 			if(MP3IO.addMP3(Subjects.Fruit)){
			 				GuiActivitiesWatcher.voice = false;
					 		GuiActivitiesWatcher.mp3 = true;
					 		GuiActivitiesWatcher.firstMP3Browse = false;
			 			}
			 			break;
				}

		 		break;
		 		
			case "recordButtonE":
				 EditWindow.recordButtonE.setEnabled(false);
			 	  EditWindow.saveChangesbuttonE.setEnabled(false);
			 	EditWindow.playRecordedVoiceButtonE.setEnabled(false);
				setRecordingStatusE("Recording...");
			 	  if(GuiActivitiesWatcher.firstRecording){VoiceRecorder.resetWaveFile();}
			 	  else{try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){ex.printStackTrace();}}
			 	  switch (GuiActivitiesWatcher.flag){
				 		case "Alphabet":
				 			new Thread(new Runnable(){
				 				public void run(){
				 					new VoiceRecorder(Subjects.Alphabet);
						 			VoiceRecorder.start();
				 				}
				 			}).start();
				 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Alphabet);}
				 			
				 			break;
				 		case "Numbers":
				 			new Thread(new Runnable(){
				 				public void run(){
						 			new VoiceRecorder(Subjects.Numbers);
						 			VoiceRecorder.start();
				 				}
				 			}).start();
				 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Numbers);}
				 			break;
				 		case "Animals":
				 			new Thread(new Runnable(){
				 				public void run(){
						 			new VoiceRecorder(Subjects.Animals);
						 			VoiceRecorder.start();
				 				}
				 			}).start();
				 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Animals);}
				 			break;
				 		case "Colors":
				 			new Thread(new Runnable(){
				 				public void run(){
						 			new VoiceRecorder(Subjects.Colors);
						 			VoiceRecorder.start();
				 				}
				 			}).start();
				 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Colors);}
				 			break;
				 		case "Shapes":
				 			new Thread(new Runnable(){
				 				public void run(){
						 			new VoiceRecorder(Subjects.Shapes);
						 			VoiceRecorder.start();
				 				}
				 			}).start();
				 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Shapes);}
				 			break;
				 		case "Vegetable":
				 			new Thread(new Runnable(){
				 				public void run(){
						 			new VoiceRecorder(Subjects.Vegetable);
						 			VoiceRecorder.start();
				 				}
				 			}).start();
				 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Vegetable);}
				 			break;
				 			
				 		case "Fruit":
				 			new Thread(new Runnable(){
				 				public void run(){
						 			new VoiceRecorder(Subjects.Fruit);
						 			VoiceRecorder.start();
				 				}
				 			}).start();
				 			if (!GuiActivitiesWatcher.firstRecording){VoiceRecorder.decrementName(Subjects.Fruit);}
				 			break;
			 	  }
			 	 GuiActivitiesWatcher.firstRecording=false;
			 	GuiActivitiesWatcher.voice = true;
		 		GuiActivitiesWatcher.mp3 = false;
			 		break;
			 		
			 	case "stopRecodringButtonE":
			 		EditWindow.recordButtonE.setEnabled(true);
				 	EditWindow.saveChangesbuttonE.setEnabled(true);
				 	EditWindow.playRecordedVoiceButtonE.setEnabled(true);
			 		setRecordingStatusE("Stopped!");
			 		SoundPlayer.stopAudio();
			 		new Thread(new Runnable(){public void run(){VoiceRecorder.finish();}}).start();
			 		break;
			 		
			 	case "playRecordedVoiceButtonE":
			 		if (!GuiActivitiesWatcher.firstRecording){setRecordingStatusE("Playing...");}
			 		new Thread(new Runnable(){
			 			public void run(){
			 				if(VoiceRecorder.getWavFile()!=null && EditWindow.recordButtonE.isEnabled()){
				 				EditWindow.recordButtonE.setEnabled(false);
				 				SoundPlayer.playSound(VoiceRecorder.getWavFile().toString());
				 				setRecordingStatusE("");
				 				EditWindow.recordButtonE.setEnabled(true);
			 			}
			 			}
			 		}).start();
			 		
			 		break;

		 		
			 	case "browseImagebuttonE":
			 		if(GuiActivitiesWatcher.firstImageBrowse){ImagesIO.setImageDir(null);}
				 	  else{try{new File(ImagesIO.getImageDir()).delete(); }catch(Exception ex){ex.printStackTrace();}}
			 		switch (GuiActivitiesWatcher.flag){
				 		case "Alphabet":
				 			if(ImagesIO.addImage(Subjects.Alphabet)){GuiActivitiesWatcher.firstImageBrowse = false;}
				 			break;
				 		case "Numbers":
				 			if(ImagesIO.addImage(Subjects.Numbers)){GuiActivitiesWatcher.firstImageBrowse = false;}
				 			break;
				 		case "Animals":
				 			if(ImagesIO.addImage(Subjects.Animals)){GuiActivitiesWatcher.firstImageBrowse = false;}
				 			break;
				 		case "Colors":
				 			if(ImagesIO.addImage(Subjects.Colors)){GuiActivitiesWatcher.firstImageBrowse = false;}
				 			break;
				 		case "Shapes":
				 			if(ImagesIO.addImage(Subjects.Shapes)){GuiActivitiesWatcher.firstImageBrowse = false;}
				 			break;
				 		case "Vegetable":
				 			if(ImagesIO.addImage(Subjects.Vegetable)){GuiActivitiesWatcher.firstImageBrowse = false;}
				 			break;
				 			
				 		case "Fruit":
				 			if(ImagesIO.addImage(Subjects.Fruit)){GuiActivitiesWatcher.firstImageBrowse = false;}
				 			break;
			 		}
			 		
			 		break;
			 		
		 		
			 	case "saveChangesbuttonE":
				 	noun=""; sound=""; image="";
					switch (GuiActivitiesWatcher.flag){
						 case "Alphabet":
						 	try{
						 		noun = EditWindow.getNoun();
						 		if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
								image = ImagesIO.getImageDir();
						 		}catch(Exception ex){}
						 		Course.getAlphabet().edit(subjectUI.getList().getSelectedValue(), noun, sound,  image);
								JOptionPane.showMessageDialog(null, "Letter "+subjectUI.getList().getSelectedValue()+ " has been Edited Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
								subjectUI.populateList(Course.getAlphabet().getNoun());
								GuiActivitiesWatcher.firstRecording=true;
						 		GuiActivitiesWatcher.firstMP3Browse = true;
						 		GuiActivitiesWatcher.firstImageBrowse = true;
						 		EditWindow.getFrame().dispose();
						 		subjectUI.getFrame().setEnabled(true);
					 			break;
						 			
						 			
				 		case "Numbers":
				 			try{
				 				noun = EditWindow.getNoun();
				 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
						 		image = ImagesIO.getImageDir();
				 			}
				 			catch(Exception ex){}
				 				Course.getNumbers().edit(subjectUI.getList().getSelectedValue(), noun, sound,  image);
						 		JOptionPane.showMessageDialog(null, "Number "+subjectUI.getList().getSelectedValue()+ " has been Edited Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
						 		subjectUI.populateList(Course.getNumbers().getNoun());
						 		GuiActivitiesWatcher.firstRecording=true;
						 		GuiActivitiesWatcher.firstMP3Browse = true;
						 		GuiActivitiesWatcher.firstImageBrowse = true;
						 		EditWindow.getFrame().dispose();
						 		subjectUI.getFrame().setEnabled(true);
				 			break;
				 			
				 		case "Animals":
				 			try{
				 				noun = EditWindow.getNoun();
				 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
						 		image = ImagesIO.getImageDir();
				 			}
				 			catch(Exception ex){}
				 				Course.getAnimals().edit(subjectUI.getList().getSelectedValue(), noun, sound,  image);
						 		JOptionPane.showMessageDialog(null, "Animal "+subjectUI.getList().getSelectedValue()+ " has been Edited Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
						 		subjectUI.populateList(Course.getAnimals().getNoun());
						 		GuiActivitiesWatcher.firstRecording=true;
						 		GuiActivitiesWatcher.firstMP3Browse = true;
						 		GuiActivitiesWatcher.firstImageBrowse = true;
						 		EditWindow.getFrame().dispose();
						 		subjectUI.getFrame().setEnabled(true);
				 			break;
				 		
				 		case "Colors":
				 			try{
				 				noun = EditWindow.getNoun();
				 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
						 		image = ImagesIO.getImageDir();
				 			}
				 			catch(Exception ex){}
				 				Course.getColors().edit(subjectUI.getList().getSelectedValue(), noun, sound,  image);
						 		JOptionPane.showMessageDialog(null, "Color "+subjectUI.getList().getSelectedValue()+ " has been Edited Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
						 		subjectUI.populateList(Course.getColors().getNoun());
						 		GuiActivitiesWatcher.firstRecording=true;
						 		GuiActivitiesWatcher.firstMP3Browse = true;
						 		GuiActivitiesWatcher.firstImageBrowse = true;
						 		EditWindow.getFrame().dispose();
						 		subjectUI.getFrame().setEnabled(true);
				 			break;
				 			
				 		case "Shapes":
				 			try{
				 				noun = EditWindow.getNoun();
				 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
						 		image = ImagesIO.getImageDir();
				 			}
				 			catch(Exception ex){}
				 				Course.getShapes().edit(subjectUI.getList().getSelectedValue(), noun, sound,  image);
						 		JOptionPane.showMessageDialog(null, "Shape "+subjectUI.getList().getSelectedValue()+ " has been Edited Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
						 		subjectUI.populateList(Course.getShapes().getNoun());
						 		GuiActivitiesWatcher.firstRecording=true;
						 		GuiActivitiesWatcher.firstMP3Browse = true;
						 		GuiActivitiesWatcher.firstImageBrowse = true;
						 		EditWindow.getFrame().dispose();
						 		subjectUI.getFrame().setEnabled(true);
				 			break;
				 			
				 		case "Vegetable":
				 			try{
				 				noun = EditWindow.getNoun();
				 				if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
						 		image = ImagesIO.getImageDir();
				 			}
				 			catch(Exception ex){}
				 				Course.getVegetable().edit(subjectUI.getList().getSelectedValue(), noun, sound,  image);
						 		JOptionPane.showMessageDialog(null, "Vegetable "+subjectUI.getList().getSelectedValue()+ " has been Edited Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
				 				subjectUI.populateList(Course.getVegetable().getNoun());
						 		GuiActivitiesWatcher.firstRecording=true;
						 		GuiActivitiesWatcher.firstMP3Browse = true;
						 		GuiActivitiesWatcher.firstImageBrowse = true;
						 		EditWindow.getFrame().dispose();
						 		subjectUI.getFrame().setEnabled(true);
				 			break;
				 			
				 		case "Fruit":
				 			try{
				 				noun = EditWindow.getNoun();
						 		if(GuiActivitiesWatcher.mp3){sound = MP3IO.getMp3Dir(); try{VoiceRecorder.deleteCurrentRecord();}catch(Exception ex){}} else if (GuiActivitiesWatcher.voice){sound = VoiceRecorder.getWavFile().toString(); try{MP3IO.deleteMP3();}catch(Exception ex){}}
				 				image = ImagesIO.getImageDir();
				 			}
				 			catch(Exception ex){}
				 				Course.getFruit().edit(subjectUI.getList().getSelectedValue(), noun, sound,  image);
						 		JOptionPane.showMessageDialog(null, "Fruit "+subjectUI.getList().getSelectedValue()+ " has been Edited Successfully","Information",JOptionPane.INFORMATION_MESSAGE);
				 				subjectUI.populateList(Course.getFruit().getNoun());
						 		GuiActivitiesWatcher.firstRecording=true;
						 		GuiActivitiesWatcher.firstMP3Browse = true;
						 		GuiActivitiesWatcher.firstImageBrowse = true;
						 		EditWindow.getFrame().dispose();
						 		subjectUI.getFrame().setEnabled(true);
				 			break;
				 			
		 		}
			 		
			 		break;
			 		
			 		
		 		
		 	case "cancelButtonE":
		 		try{if(GuiActivitiesWatcher.mp3){SoundPlayer.stopAudio(); MP3IO.deleteMP3();}}catch(Exception ex){}
		 		try{if (GuiActivitiesWatcher.voice){VoiceRecorder.finish(); VoiceRecorder.deleteCurrentRecord();}}catch(Exception ex){}
		 		try{ImagesIO.deleteImage();}catch(Exception ex){}
		 		GuiActivitiesWatcher.firstMP3Browse = true;
		 		GuiActivitiesWatcher.firstRecording = true;
		 		GuiActivitiesWatcher.firstImageBrowse = true;
		 		EditWindow.getFrame().dispose();
		 		subjectUI.getFrame().setEnabled(true);
		 		break;
		 		
		 }
		 
		 
	}
	
	
	/**
	 * Changes the image of each element in the list when user presses PlayAall button
	 * @param subject
	 */
	private void showImage(final Subjects subject){
		SwingUtilities.invokeLater(new Runnable(){ // to run this method asynchronously immediately in the GUI.
			public void run(){
				switch (subject.toString()){
					case "Alphabet":
						subjectUI.addImage((Course.getImage(Subjects.Alphabet, subjectUI.getList().getSelectedValue().toString())));
						break;
					
					case "Numbers":
						subjectUI.addImage((Course.getImage(Subjects.Numbers, subjectUI.getList().getSelectedValue().toString())));
						break;
					
					case "Animals":
						subjectUI.addImage((Course.getImage(Subjects.Animals, subjectUI.getList().getSelectedValue().toString())));
						break;
					
					case "Colors":
						subjectUI.addImage((Course.getImage(Subjects.Colors, subjectUI.getList().getSelectedValue().toString())));
						break;
					
					case "Shapes":
						subjectUI.addImage((Course.getImage(Subjects.Shapes, subjectUI.getList().getSelectedValue().toString())));
						break;
					
					case "Vegetable":
						subjectUI.addImage((Course.getImage(Subjects.Vegetable, subjectUI.getList().getSelectedValue().toString())));
						break;
						
					case "Fruit":
						subjectUI.addImage((Course.getImage(Subjects.Fruit, subjectUI.getList().getSelectedValue().toString())));
						break;
				}
			}});
		}

	/**
	 * Set the recording status for the AddWindow
	 * @param status
	 */
	private void setRecordingStatus(final String status){
		SwingUtilities.invokeLater(new Runnable(){ // to run this method asynchronously immediately in the GUI.
			public void run(){
				AddWindow.setStatus(status);
			}
			});
		}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * Set the recording status for the EditWindow
	 * @param status
	 */
	private void setRecordingStatusE(final String status){
		SwingUtilities.invokeLater(new Runnable(){ // to run this method asynchronously immediately in the GUI.
			public void run(){
				EditWindow.setStatus(status);
			}
			});
		}
	
		



	

	}

