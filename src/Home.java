import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frmPersonalDiary;
	private JTextField userName;
	private JPasswordField userPass;
	private JLabel lblPassword;
	private JLabel lblAPersonalDiary;
	DataReadWrite conn = new DataReadWrite();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					//window.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPersonalDiary = new JFrame();
		frmPersonalDiary.setTitle("Personal Diary");
		frmPersonalDiary.setType(Type.POPUP);
		frmPersonalDiary.setResizable(false);
		frmPersonalDiary.getContentPane().setBackground(SystemColor.activeCaption);
		frmPersonalDiary.setBounds(0, -26, 565, 380);
		frmPersonalDiary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPersonalDiary.getContentPane().setLayout(null);
		frmPersonalDiary.setLocationRelativeTo(null);
		
		userName = new JTextField();
		userName.setToolTipText("User Name");
		userName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setBounds(170, 111, 222, 29);
		frmPersonalDiary.getContentPane().add(userName);
		userName.setColumns(10);
		
		userPass = new JPasswordField();
		userPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userPass.setToolTipText("Password");
		userPass.setHorizontalAlignment(SwingConstants.CENTER);
		userPass.setBounds(170, 181, 222, 29);
		frmPersonalDiary.getContentPane().add(userPass);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(new Color(0, 0, 102));
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(141, 89, 124, 23);
		frmPersonalDiary.getContentPane().add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(0, 0, 102));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(141, 161, 114, 23);
		frmPersonalDiary.getContentPane().add(lblPassword);
		
		lblAPersonalDiary = new JLabel("A Personal Diary");
		lblAPersonalDiary.setHorizontalAlignment(SwingConstants.CENTER);
		lblAPersonalDiary.setFont(new Font("Castellar", Font.BOLD, 22));
		lblAPersonalDiary.setBounds(133, 21, 301, 41);
		frmPersonalDiary.getContentPane().add(lblAPersonalDiary);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userName.getText();
				String userpass = userPass.getText();
				if(conn.userExists(username, userpass)) {
					frmPersonalDiary.hide();
					new Diary();
				}else {
					JOptionPane.showMessageDialog(frmPersonalDiary, "Username or Password combination is wrong!!", "Wrong Username/Password", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setSelectedIcon(null);
		btnLogin.setIcon(null);
		btnLogin.setForeground(new Color(0, 128, 128));
		btnLogin.setBackground(new Color(72, 209, 204));
		btnLogin.setFont(new Font("Californian FB", Font.BOLD, 15));
		btnLogin.setBounds(170, 234, 222, 23);
		frmPersonalDiary.getContentPane().add(btnLogin);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(75, 0, 130));
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLogin.setBounds(28, 123, 86, 43);
		frmPersonalDiary.getContentPane().add(lblLogin);
		
		JLabel lblZone = new JLabel("Zone");
		lblZone.setHorizontalAlignment(SwingConstants.CENTER);
		lblZone.setForeground(new Color(75, 0, 130));
		lblZone.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblZone.setBounds(10, 148, 86, 43);
		frmPersonalDiary.getContentPane().add(lblZone);
		frmPersonalDiary.setVisible(true);
	}
}
