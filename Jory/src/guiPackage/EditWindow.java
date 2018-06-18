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
 * to edit an existing elements of the subjects 
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class EditWindow {

	private static JFrame editFrame;
	private static JTextField newNountextField;
	private static JLabel statusLabel;
	public static JButton recordButtonE;
	public static JButton playRecordedVoiceButtonE;
	public static JButton saveChangesbuttonE;
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * Static method that initializes and shows the window
	 * @param listener
	 */
	public static void show(GuiListener listener) {
		editFrame = new JFrame();
		editFrame.setTitle("Edit");
		editFrame.getContentPane().setBackground(Color.PINK);
		editFrame.getContentPane().setLayout(null);
		
		JButton browseMP3ButtonE = new JButton("Browse MP3");
		browseMP3ButtonE.setForeground(new Color(0, 0, 128));
		browseMP3ButtonE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		browseMP3ButtonE.setBounds(183, 62, 125, 36);
		editFrame.getContentPane().add(browseMP3ButtonE);
		browseMP3ButtonE.setActionCommand("browseMP3ButtonE");
		browseMP3ButtonE.addActionListener(listener);
		
		JLabel AddMP3Label = new JLabel("From MP3 File:");
		AddMP3Label.setForeground(new Color(0, 0, 128));
		AddMP3Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		AddMP3Label.setHorizontalAlignment(SwingConstants.CENTER);
		AddMP3Label.setBounds(51, 56, 104, 48);
		editFrame.getContentPane().add(AddMP3Label);
		
		JLabel recordVoiceLabel = new JLabel("Record Voice:");
		recordVoiceLabel.setForeground(new Color(128, 0, 128));
		recordVoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		recordVoiceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		recordVoiceLabel.setBounds(51, 123, 104, 36);
		editFrame.getContentPane().add(recordVoiceLabel);
		
		JButton stopRecodringButtonE = new JButton("");
		stopRecodringButtonE.setBounds(165, 131, 42, 23);
		stopRecodringButtonE.setIcon(resizedImageIcon(AddWindow.class.getResource("/iconPackage/stopIcon.jpg"), stopRecodringButtonE));
		editFrame.getContentPane().add(stopRecodringButtonE);
		stopRecodringButtonE.setActionCommand("stopRecodringButtonE");
		stopRecodringButtonE.addActionListener(listener);
		doHovereffect(stopRecodringButtonE);
		
		
		recordButtonE = new JButton("");
		recordButtonE.setBounds(225, 131, 42, 23);
		recordButtonE.setIcon(resizedImageIcon(AddWindow.class.getResource("/iconPackage/recordIcon.jpg"), recordButtonE));
		editFrame.getContentPane().add(recordButtonE);
		recordButtonE.setActionCommand("recordButtonE");
		recordButtonE.addActionListener(listener);
		doHovereffect(recordButtonE);
		
		playRecordedVoiceButtonE = new JButton("");
		playRecordedVoiceButtonE.setBounds(283, 131, 42, 23);
		playRecordedVoiceButtonE.setIcon(resizedImageIcon(AddWindow.class.getResource("/iconPackage/playIcon.jpg"), playRecordedVoiceButtonE));
		editFrame.getContentPane().add(playRecordedVoiceButtonE);
		playRecordedVoiceButtonE.setActionCommand("playRecordedVoiceButtonE");
		playRecordedVoiceButtonE.addActionListener(listener);
		doHovereffect(playRecordedVoiceButtonE);
		
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		statusLabel.setBounds(348, 124, 117, 35);
		editFrame.getContentPane().add(statusLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 176, 487, 2);
		editFrame.getContentPane().add(separator_1);
		
		JLabel addNewNounlabel = new JLabel("Edit Noun:");
		addNewNounlabel.setHorizontalAlignment(SwingConstants.CENTER);
		addNewNounlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		addNewNounlabel.setBounds(21, 195, 104, 48);
		editFrame.getContentPane().add(addNewNounlabel);
		
		newNountextField = new JTextField();
		newNountextField.setToolTipText("Leave Empty If You Do Not Want To Change");
		newNountextField.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		newNountextField.setBounds(156, 200, 298, 36);
		editFrame.getContentPane().add(newNountextField);
		newNountextField.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(0, 254, 487, 2);
		editFrame.getContentPane().add(separator_2);
		
		JLabel newImageLabel = new JLabel("Edit Image:");
		newImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newImageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		newImageLabel.setBounds(21, 272, 104, 48);
		editFrame.getContentPane().add(newImageLabel);
		
		JButton browseImagebuttonE = new JButton("Browse Image");
		browseImagebuttonE.setForeground(new Color(139, 69, 19));
		browseImagebuttonE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		browseImagebuttonE.setBounds(178, 276, 133, 36);
		editFrame.getContentPane().add(browseImagebuttonE);
		browseImagebuttonE.setActionCommand("browseImagebuttonE");
		browseImagebuttonE.addActionListener(listener);
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(0, 331, 487, 2);
		editFrame.getContentPane().add(separator_3);
		
		saveChangesbuttonE = new JButton("Save Changes");
		saveChangesbuttonE.setForeground(new Color(0, 128, 0));
		saveChangesbuttonE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveChangesbuttonE.setBounds(226, 344, 122, 36);
		editFrame.getContentPane().add(saveChangesbuttonE);
		saveChangesbuttonE.setActionCommand("saveChangesbuttonE");
		saveChangesbuttonE.addActionListener(listener);
		
		JButton cancelButtonE = new JButton("Cancel");
		cancelButtonE.setForeground(new Color(128, 0, 0));
		cancelButtonE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelButtonE.setBounds(358, 344, 119, 36);
		editFrame.getContentPane().add(cancelButtonE);
		cancelButtonE.setActionCommand("cancelButtonE");
		cancelButtonE.addActionListener(listener);
		
		JLabel editPronounciationLabel = new JLabel("Edit Pronounciation:");
		editPronounciationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editPronounciationLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		editPronounciationLabel.setBounds(21, 11, 148, 48);
		editFrame.getContentPane().add(editPronounciationLabel);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setForeground(new Color(178, 34, 34));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOr.setBounds(80, 97, 42, 28);
		editFrame.getContentPane().add(lblOr);
		editFrame.setResizable(false);
		editFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddWindow.class.getResource("/iconPackage/YM.png")));
		editFrame.setBounds(100, 100, 493, 416);
		editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		editFrame.setLocationRelativeTo(null);
		editFrame.setVisible(true);
		
		//it's invoked when the window is closed
		editFrame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
		    	GuiListener.subjectUI.getFrame().setEnabled(true);
		    	GuiListener.subjectUI.getFrame().setVisible(true);   
		    }
		});
		
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
	 * A getter method for the editFrame
	 * @return editFrame
	 */
	public static JFrame getFrame() {
		return editFrame;
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A getter method to get the new noun in the Text Field
	 * @return newNounTextField
	 */
	public static String getNoun(){
		return newNountextField.getText();
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
	
	
}
