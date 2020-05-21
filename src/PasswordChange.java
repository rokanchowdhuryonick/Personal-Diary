import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class PasswordChange {

	private JFrame passFrame;
	private JTextField pass;
	private JTextField againPass;
	DataReadWrite frw = new DataReadWrite();
	private JTextField username;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PasswordChange window = new PasswordChange();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PasswordChange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		passFrame = new JFrame();
		passFrame.setTitle("Change Your Password");
		passFrame.setResizable(false);
		passFrame.setBounds(100, 100, 450, 300);
		passFrame.setLocationRelativeTo(null);
		passFrame.getContentPane().setLayout(null);
		//passFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		passFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				passFrame.hide();
			}
		});
		
		pass = new JTextField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pass.setBounds(158, 59, 188, 27);
		passFrame.getContentPane().add(pass);
		pass.setColumns(10);
		
		againPass = new JTextField();
		againPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		againPass.setBounds(158, 103, 188, 27);
		passFrame.getContentPane().add(againPass);
		againPass.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPassword.setBounds(10, 59, 138, 27);
		passFrame.getContentPane().add(lblNewPassword);
		
		JLabel lblAgai = new JLabel("Again New Password");
		lblAgai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgai.setBounds(10, 103, 142, 27);
		passFrame.getContentPane().add(lblAgai);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = pass.getText();
				String againPassword = againPass.getText();
				String userName = username.getText();
				if(password.isEmpty() || againPassword.isEmpty() || userName.isEmpty()) {
					JOptionPane.showMessageDialog(passFrame, "Username, New Password and Again New Password field can't be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					if(!password.equals(againPassword)) {
						JOptionPane.showMessageDialog(passFrame, "New Password and Again New Password not matched!", "Warning", JOptionPane.WARNING_MESSAGE);
					}else {
						if(frw.changePassword(userName, againPassword)) {
							JOptionPane.showMessageDialog(passFrame, "Password Changed Successfully!", "Password Changed", JOptionPane.INFORMATION_MESSAGE);
							username.setText("");
							pass.setText("");
							againPass.setText("");
						}else {
							JOptionPane.showMessageDialog(passFrame, "User not found/Error from database", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
			}
		});
		btnChangePassword.setForeground(new Color(0, 0, 0));
		btnChangePassword.setBackground(SystemColor.textInactiveText);
		btnChangePassword.setFont(new Font("Dialog", Font.BOLD, 14));
		btnChangePassword.setBounds(138, 171, 174, 33);
		passFrame.getContentPane().add(btnChangePassword);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(158, 11, 188, 27);
		passFrame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(10, 11, 88, 27);
		passFrame.getContentPane().add(lblUserName);

		passFrame.setVisible(true);
	}
}
