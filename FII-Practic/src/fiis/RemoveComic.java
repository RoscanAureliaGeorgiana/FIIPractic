package fiis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveComic {

	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	Connection con=null;
	
	public RemoveComic(){
		
		con=Main.dbConnector();
		JFrame frmInsert = new JFrame();
		frmInsert.setBounds(500,300,315,349);
			
		frmInsert.setTitle("Remove Comic");
		frmInsert.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 299, 310);
		frmInsert.getContentPane().add(panel);
		panel.setLayout(null);
			
		JLabel lblNume = new JLabel("ID");
		lblNume.setBounds(21, 58, 46, 14);
		panel.add(lblNume);
			
		JLabel lblData = new JLabel("SERIES");
		lblData.setBounds(21, 122, 46, 14);
		panel.add(lblData);
			
		JLabel lblNrParticipanti = new JLabel("NUMBER");
		lblNrParticipanti.setBounds(21, 188, 86, 14);
		panel.add(lblNrParticipanti);
			
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 55, 160, 20);
		panel.add(textField_1);
			
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(117, 119, 160, 20);
		panel.add(textField_3);
			
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(117, 185, 160, 20);
		panel.add(textField_4);
			
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql= "DELETE FROM COMICBOOK WHERE id_comic=?";
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, textField_1.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Date sterse!");
					
					pst.close();
					
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(106, 252, 89, 23);
		panel.add(btnNewButton);
			
		frmInsert.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveComic();
	}

}