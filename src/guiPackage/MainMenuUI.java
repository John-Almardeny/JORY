package guiPackage;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.URL;
import java.awt.Toolkit;

/**
 * Main Menu UI Class
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class MainMenuUI{

	private static JFrame frmMainMenu;

	
	/**
	 * This method minimizes the main menu
	 */
	public static void minimizeMainMEnuUI(){
		MainMenuUI.frmMainMenu.setState(Frame.ICONIFIED);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This method restores the main menu
	 */
	public static void restoreMainMEnuUI(){
		MainMenuUI.frmMainMenu.setState(Frame.NORMAL);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * A getter method for the frmMainMenu
	 * @return frmMainMenu
	 */
	public static JFrame getFrmMainMenu() {
		return frmMainMenu;
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * Create the Frame and its components.
	 * @param listener
	 */
	public MainMenuUI(GuiListener listener) {
		frmMainMenu = new JFrame();
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenuUI.class.getResource("/iconPackage/YM.png")));
		frmMainMenu.setResizable(false);
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setBackground(Color.BLACK);
		frmMainMenu.getContentPane().setLayout(new BorderLayout());
		
		JLabel backgroundImage = new JLabel(new ImageIcon(MainMenuUI.class.getResource("/iconPackage/bg.jpg")));
		backgroundImage.setLayout(new BorderLayout());
	
		JButton alphabetButton = new JButton();
		alphabetButton.setPreferredSize(new Dimension(160, 130));
		alphabetButton.setIcon(resizedImageIcon(MainMenuUI.class.getResource("/iconPackage/alphabetIcon.jpg")));
		alphabetButton.setBorder(new LineBorder(Color.magenta, 2));
		alphabetButton.setActionCommand("alphabetButton");
		alphabetButton.addActionListener(listener);
		
		JButton numbersButton = new JButton();
		numbersButton.setPreferredSize(new Dimension(160, 130));
		numbersButton.setIcon(resizedImageIcon(MainMenuUI.class.getResource("/iconPackage/numbersIcon.jpg")));
		numbersButton.setBorder(new LineBorder(Color.magenta, 2));
		numbersButton.setActionCommand("numbersButton");
		numbersButton.addActionListener(listener);
		
		JButton animalsButton = new JButton();
		animalsButton.setPreferredSize(new Dimension(160, 130));
		animalsButton.setIcon(resizedImageIcon(MainMenuUI.class.getResource("/iconPackage/animalsIcon.jpg")));
		animalsButton.setBorder(new LineBorder(Color.magenta, 2));
		animalsButton.setActionCommand("animalsButton");
		animalsButton.addActionListener(listener);
		
		JButton colorsButton = new JButton();
		colorsButton.setPreferredSize(new Dimension(160, 130));
		colorsButton.setIcon(resizedImageIcon(MainMenuUI.class.getResource("/iconPackage/colorsIcon.jpg")));
		colorsButton.setBorder(new LineBorder(Color.magenta, 2));
		colorsButton.setActionCommand("colorsButton");
		colorsButton.addActionListener(listener);
		
		JButton shapesButton = new JButton();
		shapesButton.setPreferredSize(new Dimension(160, 130));
		shapesButton.setIcon(resizedImageIcon(MainMenuUI.class.getResource("/iconPackage/shapesIcon.jpg")));
		shapesButton.setBorder(new LineBorder(Color.magenta, 2));
		shapesButton.setActionCommand("shapesButton");
		shapesButton.addActionListener(listener);
		
		JButton vegetButton = new JButton();
		vegetButton.setPreferredSize(new Dimension(160, 130));
		vegetButton.setIcon(resizedImageIcon(MainMenuUI.class.getResource("/iconPackage/vegetIcon.jpg")));
		vegetButton.setBorder(new LineBorder(Color.magenta, 2));
		vegetButton.setActionCommand("vegetButton");
		vegetButton.addActionListener(listener);
		
		JButton fruitButton = new JButton();
		fruitButton.setPreferredSize(new Dimension(160, 130));
		fruitButton.setIcon(resizedImageIcon(MainMenuUI.class.getResource("/iconPackage/fruitIcon.jpg")));
		fruitButton.setBorder(new LineBorder(Color.magenta, 2));
		fruitButton.setActionCommand("fruitButton");
		fruitButton.addActionListener(listener);
		
		JLabel verticalLeadingSpace = new JLabel();
		verticalLeadingSpace.setOpaque(false);
		verticalLeadingSpace.setLayout(new BorderLayout());
		verticalLeadingSpace.setPreferredSize(new Dimension(0,20));
		
		JPanel p = new JPanel();
        p.setOpaque(false);
        p.setLayout(new FlowLayout());
        p.add(alphabetButton);
        p.add(numbersButton);
        p.add(animalsButton);
        p.add(colorsButton);
        p.add(shapesButton);
        p.add(vegetButton);
        p.add(fruitButton);
        backgroundImage.add(verticalLeadingSpace,BorderLayout.PAGE_START);
        backgroundImage.add(p);
        frmMainMenu.getContentPane().add(backgroundImage);
        frmMainMenu.pack();
        frmMainMenu.setLocationRelativeTo(null);
        
        doHovereffect(alphabetButton);
        doHovereffect(numbersButton);
        doHovereffect(animalsButton);
        doHovereffect(colorsButton);
        doHovereffect(shapesButton);
        doHovereffect(vegetButton);
        doHovereffect(fruitButton);
        frmMainMenu.setVisible(true);

	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This methods resizes the Image passed as URL parameter
	 * to specific dimensions
	 * @param url
	 * @return ImageIcon
	 */
	private ImageIcon resizedImageIcon(URL url){
		ImageIcon icon = new ImageIcon(url);
		java.awt.Image im = icon.getImage();
		java.awt.Image im2 = im.getScaledInstance(170, 145,java.awt.Image.SCALE_SMOOTH );
		return new ImageIcon(im2);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This method does some effects on the button when the 
	 * user hovers over it
	 * @param b
	 */
	private void doHovereffect(final JButton b){
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
	
	
}
