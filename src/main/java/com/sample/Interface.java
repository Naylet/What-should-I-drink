package com.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface implements ActionListener {
	private JFrame frame;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    private JPanel resultPanel;
	private JLabel questionLabel;
	private JButton yesButton;
	private JButton noButton;
	private String answer;
	private JLabel[] resultLabels;
	private JLabel resultLabel;
	
	public Interface() {
		this.frame = new JFrame("What should I drink - beer edition");
	    this.buttonPanel = new JPanel();
	    this.labelPanel = new JPanel();
	    
		this.yesButton = new JButton("YES");
		this.noButton = new JButton("NO");
		
		this.questionLabel = new JLabel(" Question will be shown here ");
		this.questionLabel.setFont (questionLabel.getFont ().deriveFont (20.0f));

		this.frame.setLayout(new BorderLayout());
		this.frame.setSize(500,300);
		this.frame.setResizable(false);	
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.yesButton.addActionListener(this);
		this.yesButton.setPreferredSize(new Dimension(150, 50));
		this.noButton.addActionListener(this);
		this.noButton.setPreferredSize(new Dimension(150, 50));

		
		this.labelPanel.add(questionLabel);
		this.buttonPanel.add(yesButton, BorderLayout.WEST);
		this.buttonPanel.add(noButton, BorderLayout.EAST);

		
		this.frame.add(labelPanel, BorderLayout.CENTER);
		this.frame.add(buttonPanel, BorderLayout.SOUTH);
		this.frame.setVisible(true);
	}
	
	public String showQuestion(String question) {
		this.questionLabel.setText("<HTML>"+question+"</HTML>");
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
		this.buttonPanel.removeAll();
		this.labelPanel.removeAll();
		
		this.resultPanel = new JPanel();
		this.resultPanel.setLayout(new GridLayout(0, 1));
		
		this.resultLabel= new JLabel("Results: ");
		this.resultLabel.setFont (resultLabel.getFont ().deriveFont (20.0f));
		this.resultPanel.add(resultLabel);
		
		this.resultLabels = new JLabel[results.length];		
		
		for(int i = 0; i<results.length; i++) {
			resultLabels[i] = new JLabel(results[i]);
			this.resultLabels[i].setFont (resultLabels[i].getFont ().deriveFont (16.0f));
			this.resultPanel.add(resultLabels[i]);
		}
		
		this.frame.add(resultPanel, BorderLayout.NORTH);
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