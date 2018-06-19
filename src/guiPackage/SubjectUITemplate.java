package guiPackage;

import javax.swing.JFrame;

import java.awt.Toolkit;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import coursePackage.Course;


import resourcesPackage.Subjects;
import soundUtilities.SoundPlayer;


/**
 * UI Template for the Subjects
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class SubjectUITemplate {
	
	public JFrame frame;
	public JLabel image;
	public JList<String> list;
	public JButton editButton;
	public JButton addButton;
	public JButton deleteButton;
	public JSeparator separator;
	public JButton playButton;
	public JButton nextButton;
	public JButton playAllButton;
	public JButton previousButton;
	public JButton stopButton;
	public JCheckBox loopCheckBox;
	public JLabel mainMenuArrowButton;
	public DefaultListModel<String> listModel;

	


	/**
	 * The constructor initializes and the frame
	 * @param listener
	 */
	public SubjectUITemplate(GuiListener listener) {
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(139, 0, 0));
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SubjectUITemplate.class.getResource("/iconPackage/YM.png")));
			frame.setResizable(false);
			frame.setBounds(100, 100, 895, 692);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
		
			list = new JList<String>();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			list.setBackground(new Color(240, 230, 140));
			list.setBounds(0, 0, 145, 321);
			DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
			renderer.setHorizontalAlignment(JLabel.CENTER);
			JScrollPane scrollPane = new JScrollPane(list);
			scrollPane.setBounds(0, 0, 145, 535);
			frame.getContentPane().add(scrollPane);
		
			addButton = new JButton("Add");
			addButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			addButton.setBounds(21, 549, 105, 28);
			frame.getContentPane().add(addButton);
			addButton.setActionCommand("addButton");
			addButton.addActionListener(listener);
			
			deleteButton = new JButton("Delete");
			deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			deleteButton.setBounds(21, 627, 105, 28);
			frame.getContentPane().add(deleteButton);
			deleteButton.setActionCommand("deleteButton");
			deleteButton.addActionListener(listener);
			
			editButton = new JButton("Edit");
			editButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			editButton.setBounds(21, 588, 105, 28);
			frame.getContentPane().add(editButton);
			editButton.setActionCommand("editButton");
			editButton.addActionListener(listener);
			
			image = new JLabel();
			image.setBounds(146, 0, 743, 535);
			frame.getContentPane().add(image);
			
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setForeground(Color.BLACK);
			separator.setBounds(143, 492, 9, 180);
			frame.getContentPane().add(separator);
			
			playButton = new JButton("");
			playButton.setBounds(380, 568, 60, 30);
			playButton.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/playIcon.jpg"),playButton));
			frame.getContentPane().add(playButton);
			playButton.setActionCommand("playButton");
			playButton.addActionListener(listener);
			
			nextButton = new JButton("");
			nextButton.setBounds(529, 568, 60, 30);
			nextButton.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/nextIcon.jpg"),nextButton));
			frame.getContentPane().add(nextButton);
			nextButton.setActionCommand("nextButton");
			nextButton.addActionListener(listener);
			
			
			previousButton = new JButton("");
			previousButton.setBounds(230, 568, 60, 30);
			previousButton.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/previousIcon.jpg"),previousButton));
			frame.getContentPane().add(previousButton);
			previousButton.setActionCommand("previousButton");
			previousButton.addActionListener(listener);
			
			stopButton = new JButton("");
			stopButton.setBounds(305, 568, 60, 30);
			stopButton.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/stopIcon.jpg"),stopButton));
			frame.getContentPane().add(stopButton);
			stopButton.setActionCommand("stopButton");
			stopButton.addActionListener(listener);
			
			loopCheckBox = new JCheckBox("Loop");
			loopCheckBox.setBackground(new Color(0, 0, 51));
			loopCheckBox.setForeground(new Color(255, 255, 255));
			loopCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
			loopCheckBox.setBounds(381, 615, 60, 23);
			frame.getContentPane().add(loopCheckBox);
			loopCheckBox.setActionCommand("loopCheckBox");
			loopCheckBox.addActionListener(listener);
			
			mainMenuArrowButton = new JLabel("");
			mainMenuArrowButton.setBounds(734, 568, 145, 77);
			mainMenuArrowButton.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/MainMenuArrow.jpg"), mainMenuArrowButton));
			frame.getContentPane().add(mainMenuArrowButton);
			doHovereffect(mainMenuArrowButton);
			
			playAllButton = new JButton("");
			playAllButton.setBounds(454, 568, 60, 30);
			playAllButton.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/playAllIcon.jpg"),playAllButton));
			frame.getContentPane().add(playAllButton);
			playAllButton.setActionCommand("playAllButton");
			playAllButton.addActionListener(listener);
			
		
		    frame.setLocationRelativeTo(null);
		    
		    
	
	 // listen to the changes of the JList value
	 list.addListSelectionListener(new ListSelectionListener() {
		
	    @Override
	    public void valueChanged(ListSelectionEvent evt) {
	    	if (!evt.getValueIsAdjusting() && playAllButton.isEnabled()){ // to prevent double events
	         try{
		        switch(GuiActivitiesWatcher.flag){
		            case "Alphabet":
		                addImage((Course.getImage(Subjects.Alphabet, list.getSelectedValue().toString())));
		                new Thread(new Runnable() {
			 			    public void run(){
			 			    	if (!GuiActivitiesWatcher.delete){
			 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Alphabet, list.getSelectedValue()));
			 			    	}
			 			    }}).start();
		                break;
		                
		            case "Numbers":
		              addImage((Course.getImage(Subjects.Numbers, list.getSelectedValue().toString())));
		              new Thread(new Runnable() {
			 			    public void run(){
			 			    	if (!GuiActivitiesWatcher.delete){
			 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Numbers, list.getSelectedValue()));
			 			    	}
			 			    }}).start();
		                break;
		            case "Animals":
		                addImage((Course.getImage(Subjects.Animals, list.getSelectedValue().toString())));
		                new Thread(new Runnable() {
			 			    public void run(){
			 			    	if (!GuiActivitiesWatcher.delete){
			 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Animals, list.getSelectedValue()));
			 			    	}
			 			    }}).start();
		                break;
		            case "Colors":
		                addImage((Course.getImage(Subjects.Colors, list.getSelectedValue().toString())));
		                new Thread(new Runnable() {
			 			    public void run(){
			 			    	if (!GuiActivitiesWatcher.delete){
			 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Colors, list.getSelectedValue()));
			 			    	}
			 			    }}).start();
		                break;
		            case "Shapes":
		                addImage((Course.getImage(Subjects.Shapes, list.getSelectedValue().toString())));
		                new Thread(new Runnable() {
			 			    public void run(){
			 			    	if (!GuiActivitiesWatcher.delete){
			 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Shapes, list.getSelectedValue()));
			 			    	}
			 			    }}).start();
		                break;
		            case "Vegetable":
		                addImage((Course.getImage(Subjects.Vegetable, list.getSelectedValue().toString())));
		                new Thread(new Runnable() {
			 			    public void run(){
			 			    	if (!GuiActivitiesWatcher.delete){
			 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Vegetable, list.getSelectedValue()));
			 			    	}
			 			    }}).start();
		                break;
		                
		            case "Fruit":
		                addImage((Course.getImage(Subjects.Fruit, list.getSelectedValue().toString())));
		                new Thread(new Runnable() {
			 			    public void run(){
			 			    	if (!GuiActivitiesWatcher.delete){
			 			    	 SoundPlayer.playSound(Course.getSound(Subjects.Fruit, list.getSelectedValue()));
			 			    	}
			 			    }}).start();
		                break;
		    }
	        }catch(Exception ex){}
			
	    	}
	    }
	});
	
	}
 
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * add new image to the frame 
	 * receives URL as parameter
	 * @param image
	 */
	public void addImage(URL image){
		this.image.setIcon(resizedImageIcon(image, this.image));
		frame.getContentPane().add(this.image);
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * add new image to the frame 
	 * receives String as parameter
	 * @param image
	 */
	public void addImage(String image){
		this.image.setIcon(resizedImageIcon(image, this.image));
		frame.getContentPane().add(this.image);
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method fills the list wit nouns
	 * @param linkedList
	 */
	public void populateList(LinkedList<String> linkedList){
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(String noun : linkedList) {
		    model.addElement(noun);
		}
		list.setModel(model);
		GuiActivitiesWatcher.delete = false;
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This method makes the frame visible
	 */
	public void show(){
		this.frame.setVisible(true);
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This methods resized the Image passed as URL parameter to fit
	 * the button passed also as parameter
	 * @param url
	 * @param button
	 * @return ImageIcon
	 */
	private ImageIcon resizedImageIcon(URL url, JButton button){
		ImageIcon icon = new ImageIcon(url);
		java.awt.Image im = icon.getImage();
		java.awt.Image im2 = im.getScaledInstance(button.getWidth(), button.getHeight(),java.awt.Image.SCALE_SMOOTH );
		return new ImageIcon(im2);
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
	/**
	 * This methods resized the Image passed as String parameter to fit
	 * the button passed also as parameter
	 * @param dir
	 * @param button
	 * @return ImageIcon
	 */
	private ImageIcon resizedImageIcon(String dir, JLabel label){
		ImageIcon icon = new ImageIcon(dir);
		java.awt.Image im = icon.getImage();
		java.awt.Image im2 = im.getScaledInstance(label.getWidth(), label.getHeight(),java.awt.Image.SCALE_SMOOTH );
		return new ImageIcon(im2);
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This methods resized the Image passed as parameter to fit
	 * the label passed also as parameter
	 * @param url
	 * @param label
	 * @return ImageIcon
	 */
	private ImageIcon resizedImageIcon(URL url, JLabel label){
		ImageIcon icon = new ImageIcon(url);
		java.awt.Image im = icon.getImage();
		java.awt.Image im2 = im.getScaledInstance(label.getWidth(), label.getHeight(),java.awt.Image.SCALE_SMOOTH );
		return new ImageIcon(im2);
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method does some effects on the label when
	 * the user hovers over it
	 * @param label
	 */
	private void doHovereffect(final JLabel label){
		label.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	Rectangle d = label.getBounds();
		    	d.setBounds(d.x-15, d.y-15,d.width+15, d.height+15);
		    	label.setBounds(d);
		    	label.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/MainMenuArrow.jpg"), label));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	Rectangle d = label.getBounds();
		    	d.setBounds(d.x+15, d.y+15,d.width-15, d.height-15);
		    	label.setBounds(d);
		    	label.setIcon(resizedImageIcon(SubjectUITemplate.class.getResource("/iconPackage/MainMenuArrow.jpg"), label));
		    	
		    }
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    			GuiActivitiesWatcher.stop = true;
		    			frame.dispose();
		    			MainMenuUI.getFrmMainMenu().setVisible(true);
		    }
		    
		});
	}
	

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/*Getters and Setters For The Frame Components*/
	
	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JList<String> getList() {
		return list;
	}


	public void setList(JList<String> list) {
		this.list = list;
	}


	public JButton getEditButton() {
		return editButton;
	}


	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}


	public JButton getAddButton() {
		return addButton;
	}


	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}


	public JButton getDeleteButton() {
		return deleteButton;
	}


	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}



	public JSeparator getSeparator() {
		return separator;
	}


	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}


	public JButton getPlayButton() {
		return playButton;
	}


	public void setPlayButton(JButton playButton) {
		this.playButton = playButton;
	}


	public JButton getNextButton() {
		return nextButton;
	}


	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}


	public JButton getPreviousButton() {
		return previousButton;
	}


	public void setPreviousButton(JButton previousButton) {
		this.previousButton = previousButton;
	}


	public JButton getStopButton() {
		return stopButton;
	}


	public void setStopButton(JButton stopButton) {
		this.stopButton = stopButton;
	}


	public JCheckBox getLoopCheckBox() {
		return loopCheckBox;
	}


	public void setLoopCheckBox(JCheckBox loopCheckBox) {
		this.loopCheckBox = loopCheckBox;
	}


	
	public JLabel getImage() {
		return image;
	}


	public void setImage(JLabel image) {
		this.image = image;
	}




	public DefaultListModel<String> getListModel() {
		return listModel;
	}



	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}
}
