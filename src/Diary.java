import javax.swing.*;
import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Diary{
	/**
	 * 
	 */
	private JFrame frame;
	private JTextField title;
	DataReadWrite frw = new DataReadWrite();
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Diary frame = new Diary();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Diary() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				//frame.hide();
				Home home = new Home();
			}
		});
		frame.setResizable(false);
		frame.setTitle("Diary");
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 700, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setLocationRelativeTo(null);
		
		title = new JTextField();
		title.setFont(new Font("Tahoma", Font.PLAIN, 14));
		title.setBounds(79, 62, 559, 24);
		frame.getContentPane().add(title);
		title.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(34, 59, 51, 27);
		frame.getContentPane().add(lblTitle);
		
		
		
		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblText.setBounds(34, 128, 51, 27);
		frame.getContentPane().add(lblText);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(34, 156, 604, 294);
		frame.getContentPane().add(textArea);
		
		JButton btnSave = new JButton("Save");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(title.getText().isEmpty() || textArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Title & Text Area can't be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					
					if(frw.writeToFile(new DiaryClass(title.getText(), textArea.getText()))) {
						JOptionPane.showMessageDialog(frame, "New Diary Successfully Stored!", "Success", JOptionPane.INFORMATION_MESSAGE);
						title.setText("");
						textArea.setText("");
					}else {
						JOptionPane.showMessageDialog(frame, "Error happend with database!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		
		btnSave.setBackground(new Color(85, 107, 47));
		btnSave.setForeground(new Color(0, 0, 205));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(261, 492, 91, 27);
		frame.getContentPane().add(btnSave);
		
		JButton btnSeeStoredDiary = new JButton("See Stored Diary");
		btnSeeStoredDiary.setBackground(Color.ORANGE);
		btnSeeStoredDiary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.hide();
				new DiaryList();
			}
		});
		btnSeeStoredDiary.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSeeStoredDiary.setBounds(264, 11, 203, 27);
		frame.getContentPane().add(btnSeeStoredDiary);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				frame.hide();
				new Home();
			}
		});
		btnLogout.setBounds(577, 15, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PasswordChange();
			}
		});
		btnChangePassword.setBounds(34, 15, 144, 23);
		frame.getContentPane().add(btnChangePassword);
		//setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
