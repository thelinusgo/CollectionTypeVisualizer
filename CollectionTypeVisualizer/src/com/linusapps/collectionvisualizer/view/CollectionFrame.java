package com.linusapps.collectionvisualizer.view;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.linusapps.collectionvisualizer.controller.CollectionVisualizerController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JTextPane;
/**
 * The class that represents the main GUI of this program.
 * @author linus
 *
 */
public class CollectionFrame extends JFrame{
	
	private CollectionCanvas theCanvas;
	private CollectionVisualizerController<Integer> controller;
	private JTextField textField;
	private JPanel thePanel;
	private JButton btnArrayList;
	private JButton btnLinkedList;
	private JLabel lblModeSelect;
	private JToggleButton btnValueIndexToggle;
	private JMenuBar menuBar;
	private JMenu mnFileMenu;
	private JMenu mnHelpMenu;
	private JButton btnClear;
	private JButton btnAddButton;
	private JButton btnRemove;
	private JButton btnContains;
	
	/**
	 * Create a new instance of a CollectionFrame and initialize all of the components.
	 */
	public CollectionFrame(){
		super("Collection Visualizer");
		
		controller = new CollectionVisualizerController<Integer>();

		theCanvas = new CollectionCanvas(this);
		getContentPane().setLayout(new BorderLayout()); 
		getContentPane().add(theCanvas, BorderLayout.CENTER);
		theCanvas.setLayout(new BorderLayout(0, 0));
		
		thePanel = new JPanel();
		theCanvas.add(thePanel, BorderLayout.SOUTH);
		
		btnArrayList = new JButton("ArrayList Mode");
		btnArrayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnClear = new JButton("Clear");
		thePanel.add(btnClear);
		
		lblModeSelect = new JLabel("Mode Select:");
		thePanel.add(lblModeSelect);
		thePanel.add(btnArrayList);
		
		btnLinkedList = new JButton("LinkedList Mode");
		thePanel.add(btnLinkedList);
		
		JLabel lblValue = new JLabel("Value:");
		thePanel.add(lblValue);
		
		textField = new JTextField();
		thePanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddValueindex = new JLabel("Toggle Mode:");
		thePanel.add(lblAddValueindex);
		
		btnValueIndexToggle = new JToggleButton("Item Mode");
		thePanel.add(btnValueIndexToggle);
		
		btnAddButton = new JButton("Add");
		thePanel.add(btnAddButton);
		
		btnRemove = new JButton("Remove");
		thePanel.add(btnRemove);
		
		btnContains = new JButton("Contains");
		thePanel.add(btnContains);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); 
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFileMenu = new JMenu("File");
		mnFileMenu.setMnemonic('F');
		menuBar.add(mnFileMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFileMenu.add(mntmExit);
		
		mnHelpMenu = new JMenu("Help");
		mnHelpMenu.setMnemonic('H');
		menuBar.add(mnHelpMenu);
		
		JMenuItem mntmProgramInstructions = new JMenuItem("Program Instructions");
		mnHelpMenu.add(mntmProgramInstructions);
		
		JMenuItem mntmAboutCollectionvisualizer = new JMenuItem("About CollectionVisualizer");
		mnHelpMenu.add(mntmAboutCollectionvisualizer);
		this.setVisible(true);
		this.enableActionListeners();
	}
	


	@SuppressWarnings("unchecked")
	/**
	 * This enables the action listeners for all the interactive Swing components. This should be called in the constructor.
	 */
	private void enableActionListeners(){
		btnArrayList.addActionListener(e->{
			controller.setControllerState("arraylist");
			
		});
		
		btnLinkedList.addActionListener(e->{
			controller.setControllerState("linkedlist");
		
		});
		
		btnValueIndexToggle.addActionListener(e->{
		
		if(btnValueIndexToggle.isSelected()){
			btnValueIndexToggle.setText("Index Mode");
			controller.setisIndexMode(true);
		}else{
			btnValueIndexToggle.setText("Item Mode");
			controller.setisIndexMode(false);
		}
		
		
		
		});
		
		btnClear.addActionListener(e->{
			controller.clearLists();
			repaintAll();
		});
	
		btnAddButton.addActionListener(e->{
			String val = textField.getText();
			if(isValidInput(val)){
			textField.setText("");
			controller.getArrayList().drawAddingItem(Integer.parseInt(val), theCanvas.getGraphics());
			}else{
				JOptionPane.showMessageDialog(null, "value must be a number between 0 and 100");
			}
		});
		
		btnRemove.addActionListener(e->{
			String val = textField.getText();
			if(isValidInput(val)){
			textField.setText("");
			controller.getArrayList().drawRemovingItem(Integer.parseInt(val), theCanvas.getGraphics());
			}else{
				JOptionPane.showMessageDialog(null, "value must be a number between 0 and 100");
			}
		
		
		});
		
		btnContains.addActionListener(e->{
			String val = textField.getText();
			if(isValidInput(val)){
			textField.setText("");
			controller.getArrayList().drawContainingItem(Integer.parseInt(val), theCanvas.getGraphics());
			/*Add a slight delay for dramatic effect. */
			try {
				Thread.sleep(3000);
				controller.getArrayList().draw(theCanvas.getGraphics());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}else{
				JOptionPane.showMessageDialog(null, "value must be a number between 0 and 100");
			}
		});
		
		
	}

	/**
	 * Repaints the canvas and the panel.
	 */
	private void repaintAll(){
		theCanvas.repaint();
		thePanel.repaint();
	}
	
	/**
	 * Checks the input inside a textField is valid.
	 * @param val
	 * @return
	 */
	private boolean isValidInput(String val){
		int integer = Integer.parseInt(val);
		if(val.equals(null) || (integer > 100 || integer < 0)){
			return false;
		}
		return true;
	}
	
	
	/**
	 * Return the controller object encapsulated in this CollectionFrame.
	 * @return
	 */
	public CollectionVisualizerController controller(){
		return this.controller;
	}
	
	
	public static void main(String... args){
		new CollectionFrame();
	}
}
