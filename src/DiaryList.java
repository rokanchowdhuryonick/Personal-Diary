import java.awt.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.awt.Window.Type;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DiaryList {
	JFrame diaryList;
	private JPanel contentPane;
	private JTable table;
	private JButton btnCreateNew;
	DataReadWrite drw = new DataReadWrite();
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DiaryList frame = new DiaryList();
//					frame.diaryList.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DiaryList() {
		diaryList = new JFrame();
		diaryList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		diaryList.setResizable(false);
		diaryList.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				diaryList.hide();
				new Home();
				
			}
		});
		diaryList.setTitle("Diary List");
		diaryList.setType(Type.POPUP);
		//diaryList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		diaryList.setBounds(100, 100, 700, 621);
		diaryList.getContentPane().setLayout(new BorderLayout());
		diaryList.getContentPane().setBackground(SystemColor.activeCaption);
		diaryList.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		diaryList.setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
        
        Object[] columnsName = new Object[4];
        
        columnsName[0] = "Sl";
        columnsName[1] = "Title";
        columnsName[2] = "Details Text";
        columnsName[3] = "Date Time";
        
        model.setColumnIdentifiers(columnsName);
        
        Object[] rowData = new Object[4];
        
        for(int i = 0; i < drw.readFromFile().size(); i++){
        	rowData[0] = i+1;
            rowData[1] = drw.readFromFile().get(i).getTitle();
            rowData[2] =drw.readFromFile().get(i).getText();
            rowData[3] = drw.readFromFile().get(i).getNow();
               
               model.addRow(rowData);
        }
        
        table.setModel(model);
		
		
		table.setBounds(10, 90, 664, 460);
		JScrollPane sp = new JScrollPane(table);
		sp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String title = model.getValueAt(index, 1).toString();
				String text = model.getValueAt(index, 2).toString();
				String dateTime = model.getValueAt(index, 3).toString();
				System.out.println("hamma: "+title);
				JOptionPane.showMessageDialog(contentPane, "Title: "+title+"\nDate Time:"+dateTime+"/\n\t\t\tDetails\n\n"+text, title, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		sp.setBounds(10, 70, 664, 480);
		contentPane.add(sp);
		
		btnCreateNew = new JButton("Create New");
		btnCreateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				diaryList.hide();
				 new Diary();
			}
		});
		btnCreateNew.setBounds(258, 25, 122, 23);
		contentPane.add(btnCreateNew);
		
		JButton btnSeeDetails = new JButton("See Details");
		btnSeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String title = model.getValueAt(index, 1).toString();
				String text = model.getValueAt(index, 2).toString();
				String dateTime = model.getValueAt(index, 3).toString();
				System.out.println("hamma: "+title);
				JOptionPane.showMessageDialog(contentPane, "Title: "+title+"\nDate Time:"+dateTime+"/\n\t\t\tDetails\n\n"+text, title, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSeeDetails.setBounds(277, 548, 122, 23);
		contentPane.add(btnSeeDetails);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diaryList.hide();
				new Home();
			}
		});
		btnLogout.setBounds(585, 25, 89, 23);
		contentPane.add(btnLogout);
		diaryList.setVisible(true);

	}
}
