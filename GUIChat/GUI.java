package jrJava.GUIChat;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class GUI implements ActionListener {

	public static final String NAME = "Me: ";
	
	private MessageSender sender;
	private JFrame frame;
	private JTextArea textArea1;
	private JTextArea textArea2;
	
	
	public GUI(){
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(30, 30, 300, 250);
		panel.add(scrollPane1);
		
		textArea1 = new JTextArea();
		scrollPane1.setViewportView(textArea1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(30, 300, 300, 150);
		panel.add(scrollPane2);
		
		textArea2 = new JTextArea();
		scrollPane2.setViewportView(textArea2);
		
		JButton send = new JButton("Send");
		send.setBounds(230, 480, 100, 30);
		panel.add(send);
		send.addActionListener(this);
		
		frame.setVisible(true);
	}
	
	
	public void setMessageSender(MessageSender _sender){ sender = _sender; }
	
	
	public void actionPerformed(ActionEvent e){
		String typed = textArea2.getText();
		addText(typed);
		sender.send(typed);
		textArea2.setText(""); 
	}
	
	public void addText(String msg){
		textArea1.setText(textArea1.getText() + "\n" + msg);
	}
	
}