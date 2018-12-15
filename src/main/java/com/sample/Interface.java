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
	private JButton yes;
	private JButton no;
	private String answer;
	
	public Interface() {
		this.frame = new JFrame("What should I drink - beer edition");
		this.yes = new JButton("YES");
		this.no = new JButton("NO");
		this.questionLabel = new JLabel(" ");
		
		this.frame.setSize(400,300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.yes.addActionListener(this);
		this.no.addActionListener(this);
		
		this.frame.getContentPane().add(BorderLayout.WEST, yes);
		this.frame.getContentPane().add(BorderLayout.EAST, no);
		
		this.frame.getContentPane().add(BorderLayout.CENTER, questionLabel);
		
		this.frame.setVisible(true);
	}
	
	public String showQuestion(String question) {
		this.questionLabel.setText(question);
		System.out.println("Asking question: " + question);
		this.answer = "";
		while(this.answer != "YES" || this.answer != "NO") {}
		System.out.println("Answer: " + this.answer);
		return this.answer;	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.yes) {
			this.answer="YES";
		}
		else if(e.getSource() == this.no) {
			this.answer="NO";	
		}
		
	}
	
}	