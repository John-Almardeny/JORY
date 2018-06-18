package soundUtilities;

import javax.sound.sampled.*;
import javax.swing.JOptionPane;

import resourcesPackage.Resource;
import resourcesPackage.Subjects;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
 

/**
 * This class contains static methods to record 
 * the sounds coming from a microphone
 * also to manipulate the recorded sounds
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class VoiceRecorder {
	
    private static File wavFile;
    private static AudioInputStream ais;
    private static TargetDataLine line; //receives audio data from a mixer. Commonly, the mixer has captured audio data from a port such as a microphone
    private static AudioFormat format = new AudioFormat(32000, 16, 2, true, true); // defines audio format attributes
    									//corresponds to (sampleRate,sampleSizeInBits,channels,signed,bigEndian)
    
    
    /**
     * The constructor accepts parameter to
     * determine the subject file and directory
     * for the recorder sounds  
     * @param subject
     */
    public VoiceRecorder(Subjects subject){
    	wavFile = new File(generateRecordName(subject)); // Initialize the wave file	
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Captures the sound and record it into a WAV file
     * if it starts recording it returns true 
     * otherwise it returns false
     * @return boolean 
     */
    public static boolean start() { 
        try {
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format); // get the audio formats supported by the data line
            //AudioSystem is the entry point to the sampled-audio system resources
            if (!AudioSystem.isLineSupported(info)) {// checks if system supports the data line
                return false;
             }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing
            ais = new AudioInputStream(line);
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, wavFile);  // start recording to the file
        } 
        catch (LineUnavailableException | IOException ex) {
        	JOptionPane.showMessageDialog(null, "Error in Recording The Sound", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
		return true;
	}
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
    /**
     * A static method stop and closes 
     * the target data line to finish capturing and recording
     * if succeed returns true
     * @return true
     */
    public static boolean finish() {
       try {line.stop();line.close();ais.close();}
       catch (Exception e){/*Do Nothing*/}
       return true;
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
    /**
     * A static method to play the recorded sound
     */
    public static void play(){
    	try{SoundPlayer.playSound(wavFile.toString());}
    	catch(Exception e){/*Do Nothing*/}
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
    /**
     * Delete Current Record
     */
	public static void deleteCurrentRecord() {
		wavFile.delete();
	}
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
	/**
	 * A getter method of the wavFile
	 * @return wavFile
	 */
	public static File getWavFile(){
		return wavFile;
	}

    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
	/**
	 * Resets the wavFile to null 
	 */
	public static void resetWaveFile(){
		wavFile = null;
	}
	
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
	/**
	 * A private method that auto-incrementally generates
	 * names for the records files in specific directories
	 * according to the subject passed to it
	 * @param subject
	 * @return recordNameWithPath
	 */
	private String generateRecordName(Subjects subject){
    	// folders of the subjects
		final String recordsFolder = (subject.toString().equalsIgnoreCase("Alphabet"))? Resource.getAlphabetpronounciationfolder()+"Records":
	    							 (subject.toString().equalsIgnoreCase("Numbers"))? Resource.getNumberspronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Animals"))? Resource.getAnimalspronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Colors"))? Resource.getColorspronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Shapes"))? Resource.getShapespronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Vegetable"))? Resource.getVegetablepronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Fruit"))? Resource.getFruitpronounciationfolder()+"Records":null;
    	
    	File file = new File(recordsFolder, "generatedRecodName.txt");
    	PrintWriter pww = null;
    	Scanner scannerr = null;
    	int newNumberr = 0;
   
    	if (!file.exists()){ // if it is the first recorded audio
    		try {
    			// create a folder to contain all records from now then
    			new File(recordsFolder).mkdir();
				pww = new PrintWriter(file); // then create the text file that contains the last recorded audio name
				pww.print("0"); // start with name zero
			} 
    		catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
    		finally{
    			pww.close();
    		}
    	}
    	
    	
    	else { // if it's not the first time
    		 try {
				scannerr = new Scanner(file);
				String lastNumberr = scannerr.next(); // read the last String name from the text file
				newNumberr = Integer.parseInt(lastNumberr); // parse to a number
				newNumberr++; // increment it
				pww = new PrintWriter(file); 
				pww.print(newNumberr); // overwrite the old name
				pww.flush();	  
			} 
    		catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    		finally{
	    		scannerr.close();
	    		pww.close();
	    	}
    	}
    	
    	return recordsFolder+File.separator+newNumberr+".wav"; // return the record Name With full Path
    	
    }
	

	public static void decrementName(Subjects subject){
    	// folders of the subjects
		final String recordsFolder = (subject.toString().equalsIgnoreCase("Alphabet"))? Resource.getAlphabetpronounciationfolder()+"Records":
	    							 (subject.toString().equalsIgnoreCase("Numbers"))? Resource.getNumberspronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Animals"))? Resource.getAnimalspronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Colors"))? Resource.getColorspronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Shapes"))? Resource.getShapespronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Vegetable"))? Resource.getVegetablepronounciationfolder()+"Records":
	    		    				 (subject.toString().equalsIgnoreCase("Fruit"))? Resource.getFruitpronounciationfolder()+"Records":null;
    	
    	File file = new File(recordsFolder, "generatedRecodName.txt");
    	PrintWriter pw = null;
    	Scanner scanner = null;
    	int newNumber = 0;
   
    	if (!file.exists()){ // if it is the first recorded audio
    		//do nothing
    	}
    	
    	else { // if it's not the first time
    		 try {
				scanner = new Scanner(file);
				String lastNumber = scanner.next(); // read the last String name from the text file
				newNumber = Integer.parseInt(lastNumber); // parse to a number
				newNumber--; // decrement it
				pw = new PrintWriter(file); 
				pw.print(newNumber); // overwrite the old name
				pw.flush();	  
			} 
    		catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    		finally{
	    		scanner.close();
	    		pw.close();
	    	}
    	}
 	
    }
	
	

}