package fiis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Design {
	
	Connection con=null;
	private JTextField textField_Book;
	private JTextField textField_Client;
	private JTextField textField_Comic;
	private JTextField textField_Rental;
	
	static JTable table_Book;
	static JTable table_Comic;
	static JTable table_Client;
	static JTable table_Rental;
	
	public Design(){
		
		con=Main.dbConnector();
		JFrame frame = new JFrame();
		
		JPanel panelBook = new JPanel();
		panelBook.setBounds(212, 576, 821, 40);
		JPanel panelComic = new JPanel();
		panelComic.setBounds(212, 576, 821, 40);
		JPanel panelClient = new JPanel();
		panelClient.setBounds(212, 576, 821, 40);
		JPanel panelRental = new JPanel();
		panelRental.setBounds(212, 576, 821, 40);
		
		frame.setBounds(300,50,1061,676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Library");
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(253, 245, 230));
		panel.setBounds(0, 0, 1043, 629);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 11, 171, 605);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMakeupAcademy = new JLabel("Library");
		lblMakeupAcademy.setFont(new Font("Viner Hand ITC", Font.PLAIN, 19));
		lblMakeupAcademy.setBounds(55, 25, 180, 45);
		panel_1.add(lblMakeupAcademy);
		
		JScrollPane scrollPane_Book = new JScrollPane();
		scrollPane_Book.setBounds(212, 74, 819, 471);
		panel.add(scrollPane_Book);
		
		table_Book = new JTable();
		table_Book.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID BOOK", "TITLE BOOK", "AUTHOR BOOK"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2350224884436217853L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_Book.setViewportView(table_Book);
		
		JScrollPane scrollPane_Comic = new JScrollPane();
		scrollPane_Comic.setBounds(212, 74, 819, 471);
		panel.add(scrollPane_Comic);
		
		table_Comic = new JTable();
		table_Comic.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID COMIC BOOK", "SERIES COMIC ", "NUMBER COMIC"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_Comic.setViewportView(table_Comic);
		
		JScrollPane scrollPane_Client = new JScrollPane();
		scrollPane_Client.setBounds(212, 74, 819, 471);
		panel.add(scrollPane_Client);
		
		table_Client = new JTable();
		table_Client.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID CLIENT", "NAME CLIENT"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_Client.setViewportView(table_Client);
		
		JScrollPane scrollPane_Rental = new JScrollPane();
		scrollPane_Rental.setBounds(212, 74, 819, 471);
		panel.add(scrollPane_Rental);
		
		table_Rental = new JTable();
		table_Rental.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID RENTAL", "ITEM ID", "CLIENT ID", "RENTED DATE", "RETURNED DATE"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_Rental.setViewportView(table_Rental);
		
		textField_Book = new JTextField();
		textField_Book.setBounds(212, 11, 819, 34);
		textField_Book.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model= (DefaultTableModel) table_Book.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				table_Book.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter("(?i)"+textField_Book.getText().trim()));
				
			}
		});
		textField_Book.setColumns(10);
		panel.add(textField_Book);
		
		textField_Client = new JTextField();
		textField_Client.setBounds(212, 11, 819, 34);
		textField_Client.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model= (DefaultTableModel) table_Client.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				table_Client.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter("(?i)"+textField_Client.getText().trim()));
				
			}
		});
		textField_Client.setColumns(10);
		panel.add(textField_Client);
		
		textField_Comic = new JTextField();
		textField_Comic.setBounds(212, 11, 819, 34);
		textField_Comic.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model= (DefaultTableModel) table_Comic.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				table_Comic.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter("(?i)"+textField_Comic.getText().trim()));
				
			}
		});
		textField_Comic.setColumns(10);
		panel.add(textField_Comic);
		
		textField_Rental = new JTextField();
		textField_Rental.setBounds(212, 11, 819, 34);
		textField_Rental.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model= (DefaultTableModel) table_Rental.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				table_Rental.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter("(?i)"+textField_Rental.getText().trim()));
				
			}
		});
		textField_Rental.setColumns(10);
		panel.add(textField_Rental);
		
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelBook.setVisible(true);
				panelComic.setVisible(false);
				panelClient.setVisible(false);
				panelRental.setVisible(false);
				table_Book.setVisible(true);
				table_Comic.setVisible(false);
				table_Client.setVisible(false);
				table_Rental.setVisible(false);
				textField_Book.setVisible(true);
				textField_Comic.setVisible(false);
				textField_Client.setVisible(false);
				textField_Rental.setVisible(false);
				scrollPane_Book.setVisible(true);
				scrollPane_Comic.setVisible(false);
				scrollPane_Client.setVisible(false);
				scrollPane_Rental.setVisible(false);
				try {
					String sql= "SELECT * FROM BOOK order by author_book ASC, title_book ASC";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet res=pst.executeQuery();
					table_Book.setModel(DbUtils.resultSetToTableModel(res));
					
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnBook.setBounds(20, 104, 131, 45);
		panel_1.add(btnBook);
		
		JButton btnComic = new JButton("Comic Book");
		btnComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBook.setVisible(false);
				panelComic.setVisible(true);
				panelClient.setVisible(false);
				panelRental.setVisible(false);
				table_Book.setVisible(false);
				table_Comic.setVisible(true);
				table_Client.setVisible(false);
				table_Rental.setVisible(false);
				textField_Book.setVisible(false);
				textField_Comic.setVisible(true);
				textField_Client.setVisible(false);
				textField_Rental.setVisible(false);
				scrollPane_Book.setVisible(false);
				scrollPane_Comic.setVisible(true);
				scrollPane_Client.setVisible(false);
				scrollPane_Rental.setVisible(false);
				try {
					String sql= "SELECT * FROM COMICBOOK order by series_comic ASC,number_comic ASC";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet res=pst.executeQuery();
					table_Comic.setModel(DbUtils.resultSetToTableModel(res));
					
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			
		});
		btnComic.setBounds(20, 212, 131, 45);
		panel_1.add(btnComic);
		
		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBook.setVisible(false);
				panelComic.setVisible(false);
				panelClient.setVisible(true);
				panelRental.setVisible(false);
				table_Book.setVisible(false);
				table_Comic.setVisible(false);
				table_Client.setVisible(true);
				table_Rental.setVisible(false);
				textField_Book.setVisible(false);
				textField_Comic.setVisible(false);
				textField_Client.setVisible(true);
				textField_Rental.setVisible(false);
				scrollPane_Book.setVisible(false);
				scrollPane_Comic.setVisible(false);
				scrollPane_Client.setVisible(true);
				scrollPane_Rental.setVisible(false);
				try {
					String sql= "SELECT * FROM CLIENT order by name_client";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet res=pst.executeQuery();
					table_Client.setModel(DbUtils.resultSetToTableModel(res));
					
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnClient.setBounds(20, 323, 131, 45);
		panel_1.add(btnClient);
		
		JButton btnRental = new JButton("Rental");
		btnRental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBook.setVisible(false);
				panelComic.setVisible(false);
				panelClient.setVisible(false);
				panelRental.setVisible(true);
				table_Book.setVisible(false);
				table_Comic.setVisible(false);
				table_Client.setVisible(false);
				table_Rental.setVisible(true);
				textField_Book.setVisible(false);
				textField_Comic.setVisible(false);
				textField_Client.setVisible(false);
				textField_Rental.setVisible(true);
				scrollPane_Book.setVisible(false);
				scrollPane_Comic.setVisible(false);
				scrollPane_Client.setVisible(false);
				scrollPane_Rental.setVisible(true);
				try {
					String sql= "SELECT * FROM RENTAL order by id_rental";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet res=pst.executeQuery();
					table_Rental.setModel(DbUtils.resultSetToTableModel(res));
					
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnRental.setBounds(20, 436, 131, 45);
		panel_1.add(btnRental);
		
		
		panelBook.setBackground(Color.WHITE);
		panel.add(panelBook);
		panelBook.setVisible(false);
		panelBook.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBook();
			}
		});
		btnAdd.setBounds(30, 0, 114, 38);
		panelBook.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBook();
			}
		});
		btnUpdate.setBounds(362, 0, 114, 38);
		panelBook.add(btnUpdate);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveBook();
			}
		});
		btnRemove.setBounds(690, 0, 114, 38);
		panelBook.add(btnRemove);
		
		
		panelComic.setBackground(Color.WHITE);
		panel.add(panelComic);
		panelComic.setVisible(false);
		panelComic.setLayout(null);
		
		JButton btnAdd_4 = new JButton("Add");
		btnAdd_4.setBounds(30, 0, 114, 38);
		btnAdd_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddComic();
			}
		});
		panelComic.add(btnAdd_4);
		
		JButton btnUpdate_4 = new JButton("Update");
		btnUpdate_4.setBounds(362, 0, 114, 38);
		btnUpdate_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateComic();
			}
		});
		panelComic.add(btnUpdate_4);
		
		JButton btnRemove_4 = new JButton("Remove");
		btnRemove_4.setBounds(690, 0, 114, 38);
		btnRemove_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveComic();
			}
		});
		panelComic.add(btnRemove_4);
		
		
		panelClient.setBackground(Color.WHITE);
		panel.add(panelClient);
		panelClient.setVisible(false);
		panelClient.setLayout(null);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(30, 0, 114, 38);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddClient();
			}
		});
		panelClient.add(btnAdd_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBounds(362, 0, 114, 38);
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateClient();
			}
		});
		panelClient.add(btnUpdate_1);
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setBounds(690, 0, 114, 38);
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveClient();
			}
		});
		panelClient.add(btnRemove_1);
		
		panelRental.setBackground(Color.WHITE);
		panel.add(panelRental);
		panelRental.setVisible(false);
		panelRental.setLayout(null);
		
		JButton btnAdd_2 = new JButton("Add");
		btnAdd_2.setEnabled(false);
		btnAdd_2.setBounds(30, 0, 114, 38);
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddRental();
			}
		});
		panelRental.add(btnAdd_2);
		
		JButton btnUpdate_2 = new JButton("Update");
		btnUpdate_2.setEnabled(false);
		btnUpdate_2.setBounds(362, 0, 114, 38);
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateRental();
			}
		});
		panelRental.add(btnUpdate_2);
		
		JButton btnRemove_2 = new JButton("Remove");
		btnRemove_2.setEnabled(false);
		btnRemove_2.setBounds(690, 0, 114, 38);
		btnRemove_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveRental();
			}
		});
		panelRental.add(btnRemove_2);
	
				
        frame.setVisible(true);
	}
}

