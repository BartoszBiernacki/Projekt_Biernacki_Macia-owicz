package Keyboard_package;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Window extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	JTextField field;
	int fontSize;
	String written;
	
	KeysPanel keysPanel;
	
	public Window(String arg0, JTextField f) throws HeadlessException {
		super(arg0);
		setSize(600, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		written = "";
		field = new JTextField("Text");
		fontSize = 40;
		field.setFont(new Font(null, Font.PLAIN, fontSize));
		add(field, BorderLayout.PAGE_START);
		
		keysPanel = new KeysPanel(this, f);
		add(keysPanel, BorderLayout.CENTER);
		
		for(int i = 0; i < 10; i++)
		{
			keysPanel.digits[i].addActionListener(new KeysListener());
		}
		
		keysPanel.plus.addActionListener(new KeysListener());
		keysPanel.minus.addActionListener(new KeysListener());
		keysPanel.times.addActionListener(new KeysListener());
		keysPanel.divided.addActionListener(new KeysListener());
		keysPanel.coma.addActionListener(new KeysListener());
		keysPanel.backspace.addActionListener(new BackspaceListener());
		keysPanel.decimalPoint.addActionListener(new KeysListener());
		keysPanel.left.addActionListener(new CursorListener());
		keysPanel.right.addActionListener(new CursorListener());
		keysPanel.ok.addActionListener(new OkListener());
		keysPanel.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		keysPanel.leftBracket.addActionListener(new KeysListener());
		keysPanel.rightBracket.addActionListener(new KeysListener());
		keysPanel.piValueButton.addActionListener(new KeysListener());
		keysPanel.eValueButton.addActionListener(new KeysListener());
		keysPanel.power.addActionListener(new KeysListener());
		keysPanel.squareRoot.addActionListener(new KeysListener());
		keysPanel.absoluteValue.addActionListener(new KeysListener());
		keysPanel.sinus.addActionListener(new KeysListener());
		keysPanel.cosinus.addActionListener(new KeysListener());
		keysPanel.tangens.addActionListener(new KeysListener());
		keysPanel.arcusSinus.addActionListener(new KeysListener());
		keysPanel.arcusCosinus.addActionListener(new KeysListener());
		keysPanel.arcusTangens.addActionListener(new KeysListener());
		keysPanel.exp.addActionListener(new KeysListener());
		keysPanel.naturalLogarythm.addActionListener(new KeysListener());
		keysPanel.firtstVariableButoon.addActionListener(new KeysListener());
		keysPanel.secondVariableButton.addActionListener(new KeysListener());
	}
	
	
	class KeysListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			written += e.getActionCommand();
			field.setText(written);
			field.grabFocus();
		}
		
	}
	class OkListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	class BackspaceListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int x = field.getCaretPosition();
			String a = written.substring(0, x-1);
			a += written.substring(x, written.length());//trzeba dodaæ obs³ugê b³êdu, pluje siê, jak siê za du¿o razy wciœnie backspace
			written = a;
			field.setText(written);
			field.setCaretPosition(x-1);
			field.grabFocus();
		}
	}
	class CursorListener implements ActionListener {//tutaj to samo co wy¿ej
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(field.getCaretPosition());
			if(e.getActionCommand().equals("<"))
				field.setCaretPosition(field.getCaretPosition()-1);
			else
				field.setCaretPosition(field.getCaretPosition()+1);
			field.grabFocus();
			
		}
	}

}