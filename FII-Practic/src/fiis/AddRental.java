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

public class AddRental {

	static JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Connection con=null;
	
	public AddRental(){
		
		con=Main.dbConnector();
		
        JFrame frmInsert = new JFrame();
        frmInsert.setBounds(500,300,315,349);
		
		frmInsert.setTitle("Add Rental");
		frmInsert.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 299, 310);
		frmInsert.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(117, 24, 160, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNume = new JLabel("ITEMID");
		lblNume.setBounds(21, 78, 46, 14);
		panel.add(lblNume);
		
		JLabel lblDurata = new JLabel("CLIENTID");
		lblDurata.setBounds(21, 123, 46, 14);
		panel.add(lblDurata);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 75, 160, 20);
		panel.add(textField_1);
		
		JLabel lblData = new JLabel("RENTED DATE");
		lblData.setBounds(21, 173, 84, 14);
		panel.add(lblData);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 120, 160, 20);
		panel.add(textField_2);
		
		JLabel lblNrParticipanti = new JLabel("RETURNED DATE");
		lblNrParticipanti.setBounds(19, 222, 111, 14);
		panel.add(lblNrParticipanti);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(117, 170, 160, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(117, 219, 160, 20);
		panel.add(textField_4);
		
		JLabel lblIdAngajat = new JLabel("ID");
		lblIdAngajat.setBounds(21, 27, 58, 14);
		panel.add(lblIdAngajat);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql= "INSERT INTO RENTAL (id_rental,rented_date,returned_date,book_id_book,comicbook_id_comic,client_id_client ) VALUES (?,?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Date salvate!");
					
					pst.close();
					
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(106, 274, 89, 23);
		panel.add(btnNewButton);
		
		frmInsert.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddRental();
	}

}
