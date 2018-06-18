package guiPackage;


import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * This Class provides an UI
 * to add new elements to the subjects 
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class AddWindow {

	private static JFrame addFrame;
	private static JLabel statusLabel;
	private static JTextField newNounTextField;
	public static JButton saveChangesbutton;
	public static JButton recordButton;
	public static JButton playRecordedVoiceButton;

	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	/**
	 * Static method that initializes and shows the AddWindow
	 * @param listener
	 */
	public static void show(GuiListener listener) {
		/*GUI Components*/
		addFrame = new JFrame();
		addFrame.setTitle("Add");
		addFrame.getContentPane().setBackground(Color.PINK);
		addFrame.getContentPane().setLayout(null);
		/////////////////////////
		JButton browseMP3Button = new JButton("Browse MP3");
		browseMP3Button.setForeground(new Color(0, 0, 128));
		browseMP3Button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		browseMP3Button.setBounds(183, 62, 125, 36);
		addFrame.getContentPane().add(browseMP3Button);
		browseMP3Button.setActionCommand("browseMP3Button");
		browseMP3Button.addActionListener(listener);
		
		
		JLabel AddMP3Label = new JLabel("From MP3 File:");
		AddMP3Label.setForeground(new Color(0, 0, 128));
		AddMP3Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		AddMP3Label.setHorizontalAlignment(SwingConstants.CENTER);
		AddMP3Label.setBounds(51, 56, 104, 48);
		addFrame.getContentPane().add(AddMP3Label);
		
		JLabel recordVoiceLabel = new JLabel("Record Voice:");
		recordVoiceLabel.setForeground(new Color(128, 0, 128));
		recordVoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		recordVoiceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		recordVoiceLabel.setBounds(51, 123, 104, 36);
		addFrame.getContentPane().add(recordVoiceLabel);
		
		JButton stopRecodringButton = new JButton("");
		stopRecodringButton.setBounds(165, 131, 42, 23);
		stopRecodringButton.setIcon(resizedImageIcon(AddWindow.class.getResource("/iconPackage/stopIcon.jpg"), stopRecodringButton));
		addFrame.getContentPane().add(stopRecodringButton);
		stopRecodringButton.setActionCommand("stopRecodringButton");
		stopRecodringButton.addActionListener(listener);
		doHovereffect(stopRecodringButton);
		
		recordButton = new JButton("");
		recordButton.setBounds(225, 131, 42, 23);
		recordButton.setIcon(resizedImageIcon(AddWindow.class.getResource("/iconPackage/recordIcon.jpg"), recordButton));
		addFrame.getContentPane().add(recordButton);
		recordButton.setActionCommand("recordButton");
		recordButton.addActionListener(listener);
		doHovereffect(recordButton);
		
		
		playRecordedVoiceButton = new JButton("");
		playRecordedVoiceButton.setBounds(283, 131, 42, 23);
		playRecordedVoiceButton.setIcon(resizedImageIcon(AddWindow.class.getResource("/iconPackage/playIcon.jpg"), playRecordedVoiceButton));
		addFrame.getContentPane().add(playRecordedVoiceButton);
		playRecordedVoiceButton.setActionCommand("playRecordedVoiceButton");
		playRecordedVoiceButton.addActionListener(listener);
		doHovereffect(playRecordedVoiceButton);
		
		// for recording status
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		statusLabel.setBounds(348, 124, 117, 35);
		addFrame.getContentPane().add(statusLabel);

		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 176, 487, 2);
		addFrame.getContentPane().add(separator_1);
		
		JLabel addNewNounlabel = new JLabel("Add Noun:");
		addNewNounlabel.setHorizontalAlignment(SwingConstants.CENTER);
		addNewNounlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		addNewNounlabel.setBounds(21, 195, 104, 48);
		addFrame.getContentPane().add(addNewNounlabel);
		
		newNounTextField = new JTextField();
		newNounTextField.setToolTipText("");
		newNounTextField.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		newNounTextField.setBounds(156, 200, 298, 36);
		addFrame.getContentPane().add(newNounTextField);
		newNounTextField.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(0, 254, 487, 2);
		addFrame.getContentPane().add(separator_2);
		
		JLabel newImageLabel = new JLabel("Add Image:");
		newImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newImageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		newImageLabel.setBounds(21, 272, 104, 48);
		addFrame.getContentPane().add(newImageLabel);
		
		JButton browseImagebutton = new JButton("Browse Image");
		browseImagebutton.setForeground(new Color(139, 69, 19));
		browseImagebutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		browseImagebutton.setBounds(178, 276, 133, 36);
		addFrame.getContentPane().add(browseImagebutton);
		browseImagebutton.setActionCommand("browseImagebutton");
		browseImagebutton.addActionListener(listener);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(0, 331, 487, 2);
		addFrame.getContentPane().add(separator_3);
		
		saveChangesbutton = new JButton("Save Changes");
		saveChangesbutton.setForeground(new Color(0, 128, 0));
		saveChangesbutton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveChangesbutton.setBounds(226, 344, 122, 36);
		addFrame.getContentPane().add(saveChangesbutton);
		saveChangesbutton.setActionCommand("saveChangesbutton");
		saveChangesbutton.addActionListener(listener);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(new Color(128, 0, 0));
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelButton.setBounds(358, 344, 119, 36);
		addFrame.getContentPane().add(cancelButton);
		cancelButton.setActionCommand("cancelButton");
		cancelButton.addActionListener(listener);
		
		
		JLabel lblAddPronounciation = new JLabel("Add Pronounciation:");
		lblAddPronounciation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPronounciation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddPronounciation.setBounds(21, 11, 148, 48);
		addFrame.getContentPane().add(lblAddPronounciation);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setForeground(new Color(178, 34, 34));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOr.setBounds(80, 97, 42, 28);
		addFrame.getContentPane().add(lblOr);
		addFrame.setResizable(false);
		addFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddWindow.class.getResource("/iconPackage/YM.png")));
		addFrame.setBounds(100, 100, 493, 416);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addFrame.setLocationRelativeTo(null);
		addFrame.setVisible(true);
		
		//it's invoked when the window is closed
		addFrame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
		    	GuiListener.subjectUI.getFrame().setEnabled(true);
		    	GuiListener.subjectUI.getFrame().setVisible(true);  
		    }
		});
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A getter method for the addFrame
	 * @return addFrame
	 */
	public static JFrame getFrame() {
		return addFrame;
	}
	
	
	
	/**
	 * This method resizes the Image to fit the button
	 * @param url
	 * @param button
	 * @return ImageIcon
	 */
	private static ImageIcon resizedImageIcon(URL url, JButton button){
		ImageIcon icon = new ImageIcon(url);
		java.awt.Image im = icon.getImage();
		java.awt.Image im2 = im.getScaledInstance(button.getWidth(), button.getHeight(),java.awt.Image.SCALE_SMOOTH );
		return new ImageIcon(im2);
	}
	

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This method do some effects on the button when the user hovers over it
	 * @param b
	 */
	private static void doHovereffect(final JButton b){
		b.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	b.setBorder(new LineBorder(Color.GREEN, 3));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	b.setBorder(new LineBorder(Color.magenta, 2));
		    }
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	b.setBorder(new LineBorder(Color.blue, 3));
		    }
		    
		});
		}
	

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * set the current status of the recording process
	 * @param status
	 */
	public static void setStatus(String status){
		statusLabel.setText(status);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A getter method to get the new noun in the Text Field
	 * @return newNounTextField
	 */
	public static String getNoun(){
		return newNounTextField.getText();
	}

	
	
	
}
