package fydna2600.mancala;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Mancala {


	private static Board b;
	private JFrame display;
	private static JLabel textBoard;
	
	public void runGUI(){
		//create the display
		display = new JFrame("Text Mancala");
		display.setSize(300, 300);
		display.setLayout(new GridLayout(2, 1));
		
		//listener for close button
		display.addWindowListener(new WindowAdapter() {
			public void windowsClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//create display components
		textBoard = new JLabel(b.toString(), JLabel.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		display.add(textBoard);
		display.add(buttonPanel);
		
		//create buttons
		JButton zeroButton = new JButton("[0]");
		JButton oneButton = new JButton("[1]");
		JButton twoButton = new JButton("[2]");
		JButton threeButton = new JButton("[3]");
		JButton fourButton = new JButton("[4]");
		JButton fiveButton = new JButton("[5]");
		
		//add actions
		zeroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					b.move(0);
				} catch (InvalidMove e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textBoard.setText(b.toString());
			}
		});
		oneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					b.move(1);
				} catch (InvalidMove e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textBoard.setText(b.toString());
			}
		});
		twoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					b.move(2);
				} catch (InvalidMove e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textBoard.setText(b.toString());
			}
		});
		threeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					b.move(3);
				} catch (InvalidMove e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textBoard.setText(b.toString());
			}
		});
		fourButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					b.move(4);
				} catch (InvalidMove e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textBoard.setText(b.toString());
			}
		});
		fiveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					b.move(5);
				} catch (InvalidMove e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textBoard.setText(b.toString());
			}
		});
		
		//add the buttons to the display
		buttonPanel.add(zeroButton);
		buttonPanel.add(oneButton);
		buttonPanel.add(twoButton);
		buttonPanel.add(threeButton);
		buttonPanel.add(fourButton);
		buttonPanel.add(fiveButton);
		display.setVisible(true);
	}
	
	public Mancala(){
		b = new Board();
	}
	
}
