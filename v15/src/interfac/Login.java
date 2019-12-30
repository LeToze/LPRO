package interfac;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	protected static final int DISPOSE_ON_CLOSE = 0;
	//private Jthis frame;
	private JTextField validate_username;
	private JPasswordField validate_password;
	private boolean auto = false;
	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login window = new Login();
//					window.this.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
		this.setBackground(new Color(95, 158, 160));
		this.getContentPane().setBackground(new Color(95, 158, 160));
		this.getContentPane().setLayout(null);
		//this.setVisible(false);
		
		
		//JTextField user1 = new JTextField();
		setValidate_username(new JTextField());
		this.validate_username.setBounds(246, 267, 234, 43);
		this.getContentPane().add(this.validate_username);
		this.validate_username.setColumns(10);
		//this.validate_username.setText(this.validate_username.getText());
		
		setValidate_password(new JPasswordField());
		getValidate_password().setBounds(246, 340, 234, 43);
		this.getContentPane().add(getValidate_password());
		
		
		JButton btnLogIn = new JButton("Login");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setauto();
			}
		});
//		btnLogIn.addActionListener(new ActionListener() {
//			
//
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				//if login sucessfull
//				//verificar dados com a base de dados 
//			
//		
//				
//		//		if(validate_password == us && validate_username == us)
//		//		{
//				dispose();
//				
//				//FrameGeral(null, null, null).setVisible(true);
//		//		}
//		//		else {
//		//			JOptionPane.showMessageDialog(null, "Invalid Username or password");
//		//		}
//			}
//		});
		btnLogIn.setBounds(299, 414, 117, 29);
		this.getContentPane().add(btnLogIn);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setBounds(127, 284, 84, 16);
		this.getContentPane().add(lblUtilizador);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(127, 357, 84, 16);
		this.getContentPane().add(lblPassword);
		
		JButton button_6 = new JButton("x");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		button_6.setBounds(687, 6, 43, 29);
	
		

		this.getContentPane().add(button_6);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/titulo2-5.png")));
		label.setBounds(45, 64, 285, 50);
		this.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("<html>Bem-vindo ao Groovy Player, um serviço de streaming de música. <br/> Podes ouvir as tuas músicas favoritas e existe Karaoke para os que gostam de cantar! <br/> Para continuares, faz login com os dados fornecidos.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(93, 155, 550, 75);
		this.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("/Users/luis/Downloads/coollogo_com-14986317-4.png"));
		label_1.setBounds(6, 459, 724, 105);
		this.getContentPane().add(label_1);
		
		
		this.setBounds(100, 100, 736, 573);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	protected void setauto() {
		// TODO Auto-generated method stub
		this.auto=true;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public JTextField getValidate_username() {
		return validate_username;
	}

	public void setValidate_username(JTextField validate_username) {
		this.validate_username = validate_username;
	}

	public JPasswordField getValidate_password() {
		return validate_password;
	}

	public void setValidate_password(JPasswordField validate_password) {
		this.validate_password = validate_password;
	}

	public boolean getAuto() {
		// TODO Auto-generated method stub
		return this.auto;
	}
}
