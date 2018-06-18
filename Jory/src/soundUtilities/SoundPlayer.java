package soundUtilities;


import javax.sound.sampled.*;
import javax.swing.JOptionPane;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.IOException;


/**
 * This class contains static methods 
 * to manipulate mp3 or wave sounds depending 
 * on the sound file passed to the method
 * this class implements JACo API and Javax.sound API
 * @author Yaha Almardeny
 * @version 03/12/2016
 */
public class SoundPlayer {
	public static MP3Player mp3 = null; // mp3 object file
	public static Clip clip = null; // clip wave object file
	private static AudioInputStream stream = null;
	
	
	/**
	 * A static method to play an audio file
	 * of format mp3 or wave exclusively depending on the 
	 * file passed as a parameter to this method
	 * @param fileFullPath
	 */
	public static void playSound(String fileFullPath){
		if (fileFullPath.endsWith(".mp3")){ // if it's mp3 file
				
				File f = new File (fileFullPath); 
				if(f.exists()){ // if the file exists
					try {
						mp3 = new MP3Player(f); // create new mp3 object and add the mp3 file
						mp3.play(); // start playing
						while(!mp3.isStopped()){ // thread sleep as long as the mp3 is playing
						    Thread.sleep(1);
						  }
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, "Error in playing the sound", "Error", JOptionPane.ERROR_MESSAGE);	
					}
				}
				else {JOptionPane.showMessageDialog(null, "Audio File Not Found", "Error", JOptionPane.ERROR_MESSAGE);}
		}
		
		else if (fileFullPath.endsWith(".wav")){ // if it's wave file 
			    File f = new File (fileFullPath);
			    AudioFormat format;
			    DataLine.Info info;
			    if(f.exists()){
			    	try{
					    stream = AudioSystem.getAudioInputStream(f);
					    format = stream.getFormat();
					    info = new DataLine.Info(Clip.class, format);
					    clip = (Clip) AudioSystem.getLine(info);
					    clip.open(stream);
					    //estimate the duration of the wave file
					    long l = f.length(); // get the length of the file
	                    int fz = format.getFrameSize(); // get the frame size of the file
	                    float fr = format.getFrameRate(); // get the frame rate of the file
	                    final long durationInMiliSeconds =  // then apply this formula
	                            						(long)(((float)l / (fz * fr)) * 1000);
	                    
					    clip.start(); // start playing
					    Thread.sleep(durationInMiliSeconds); // thread sleep the duration 
		    		}
			    	catch (Exception e) {
			    		JOptionPane.showMessageDialog(null, "Error in playing the sound", "Error", JOptionPane.ERROR_MESSAGE);
			    	}
			    	
			    	finally{
					    try {
							stream.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					    clip.close(); 
					   
			    	}
			 }
			 else {JOptionPane.showMessageDialog(null, "Audio File Not Found", "Error", JOptionPane.ERROR_MESSAGE);}
		
		 }
		/*however this should not execute because there is filter in the FileDialog when the user choose the file unless
		  he/she manually changes the sound file with the another type but the same name*/
		else {JOptionPane.showMessageDialog(null, "Audio File Type is not Supported", "Error", JOptionPane.ERROR_MESSAGE);}
	}

	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * A static method to stop the current playing audio file
	 */
	public static void stopAudio(){
		if(mp3 != null){mp3.stop(); }
		if(clip != null){clip.stop(); clip.close();  try{stream.close();}catch (IOException e){/*Do Nothing*/}}
	}
	
	

}

