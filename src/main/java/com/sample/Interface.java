package com.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface implements ActionListener {
	private JFrame frame;
	private JLabel questionLabel;
	private JButton yesButton;
	private JButton noButton;
	private String answer;
	private JLabel[] resultLabels;
	private JLabel resultLabel;
	
	public Interface() {
		this.frame = new JFrame("What should I drink - beer edition");
		this.yesButton = new JButton("YES");
		this.noButton = new JButton("NO");
		this.questionLabel = new JLabel(" ");
		this.resultLabels = new JLabel[9];
		
		this.frame.setSize(400,300);
		this.frame.setResizable(false);	
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.yesButton.addActionListener(this);
		this.noButton.addActionListener(this);

		this.frame.getContentPane().add(BorderLayout.WEST, yesButton);
		this.frame.getContentPane().add(BorderLayout.EAST, noButton);
		this.frame.getContentPane().add(BorderLayout.CENTER, questionLabel);
		
		this.frame.setVisible(true);
	}
	
	public String showQuestion(String question) {
		this.questionLabel.setText(question);
		System.out.println("Asking question: " + question);
		this.answer = " ";
		
		while(this.answer !="YES" && this.answer !="NO") {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return this.answer;
	}
	
	public void showResult(String[] results) {
		this.frame.getContentPane().removeAll();
		
		this.resultLabel= new JLabel("Results: ");
		this.frame.getContentPane().add(BorderLayout.NORTH, resultLabel);
		
		for(int i = 0; i<results.length; i++) {
			System.out.println(results[i]);
			resultLabels[i] = new JLabel(results[i]);
			this.frame.getContentPane().add(resultLabels[i]);
		}
		
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.yesButton) {
			this.answer = "YES";
			
		} else if (e.getSource() == this.noButton) {
			this.answer = "NO";
		}
	}
	
}	