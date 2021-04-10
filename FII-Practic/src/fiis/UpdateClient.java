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

public class UpdateClient {

	private JTextField textField_1;
	private JTextField textField_3;
	Connection con=null;
	
	public UpdateClient(){
		
		con=Main.dbConnector();
		JFrame frmInsert = new JFrame();
		frmInsert.setBounds(500,300,315,349);
		
		frmInsert.setTitle("Update Client");
		frmInsert.getContentPane().setLayout(null);
			
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 299, 310);
		frmInsert.getContentPane().add(panel);
		panel.setLayout(null);
			
		JLabel lblNume = new JLabel("ID");
		lblNume.setBounds(21, 95, 46, 14);
		panel.add(lblNume);
			
		JLabel lblData = new JLabel("NAME");
		lblData.setBounds(21, 163, 46, 14);
		panel.add(lblData);
			
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 92, 160, 20);
		panel.add(textField_1);
			
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(117, 160, 160, 20);
		panel.add(textField_3);
			
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql= "UPDATE CLIENT SET name_client=? WHERE id_client=?";
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(2, textField_1.getText());
					pst.setString(1, textField_3.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Date modificate!");
					
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
		new UpdateClient();
	}

}
