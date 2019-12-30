package interfac;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import list.Track;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FrameGeral extends JFrame {
	private JPanel contentPane;
	private JTextField txtSearchBar = new JTextField();
	private int setSearched=0;
	private JTextField textBar;
	private int search_mode;
	//private String filepath = "C://Users//smcgt//eclipse-workspace//v15//imagens";
	private JCheckBox BoxCaixa;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	//private ArrayList<Integer> buffer;
	private ArrayList<Track> tracklist;
	private AtomicInteger currentTrack;
	private JLabel lblNomeDaMusica;
	private JLabel lblNomeDoArtista;
	private JLabel lblNewLabel_1;
	private JLabel lblLenghtDaCancion;
	private String username;
	private boolean logout;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameGeral frame = new FrameGeral();
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
	public FrameGeral(ArrayList <Integer> buffer,ArrayList<Track> tracklist,AtomicInteger currentTrack,String username) {
		//Inicializações
		//this.buffer=buffer;
		this.tracklist=tracklist;
		this.currentTrack=currentTrack;
		this.username=username;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		System.out.println(UIManager.getLookAndFeel());
		JLabel lblCurrentlyPlaying = new JLabel("Currently playing");
		lblCurrentlyPlaying.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentlyPlaying.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblCurrentlyPlaying.setBounds(490, 248, 124, 16);
		contentPane.add(lblCurrentlyPlaying);
		
		
		JLabel lblGroovyPlayer = new JLabel("");
		lblGroovyPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		//lblGroovyPlayer.setIcon(new ImageIcon("C:\\Users\\smcgt\\eclipse-workspace\\v15\\imagens\\titulo2-5.png"));
		lblGroovyPlayer.setIcon(new ImageIcon(FrameGeral.class.getResource("/titulo2-5.png")));
		lblGroovyPlayer.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblGroovyPlayer.setBounds(36, 35, 285, 50);
		contentPane.add(lblGroovyPlayer);
		
		
		JLabel label_1 = new JLabel(this.username);
		label_1.setBounds(570, 11, 71, 16);
		contentPane.add(label_1);
		
		JButton button_6 = new JButton("x");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		button_6.setBounds(687, 6, 43, 29);
		contentPane.add(button_6);
		
//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setBounds(226, 514, 392, 20);
//		contentPane.add(progressBar);
//		progressBar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				//Play the music
//				buffer.add(5);
//			}
//		});
		
//		JLabel lblHome = new JLabel("Home");
//		lblHome.setBounds(272, 38, 61, 16);
//		contentPane.add(lblHome);
		this.lblLenghtDaCancion = new JLabel();
		
//		JScrollBar scrollBar = new JScrollBar();
//		scrollBar.setBounds(715, 109, 15, 390);
//		contentPane.add(scrollBar);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(FrameGeral.class.getResource("/anterior36-2.png")));
		btnNewButton_1.setBounds(16, 507, 38, 38);
		contentPane.add(btnNewButton_1);
		btnNewButton_1 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Play the music
				buffer.add(9);
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(FrameGeral.class.getResource("/pause36-2.png")));
		btnNewButton_2.setBounds(56, 507, 38, 38);
		contentPane.add(btnNewButton_2);
		btnNewButton_2 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Play the music
				buffer.add(1);
			}
		});
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(FrameGeral.class.getResource("/play36-2.png")));
		btnNewButton_3.setBounds(96, 507, 38, 38);
		contentPane.add(btnNewButton_3);
		btnNewButton_3 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Play the music
				buffer.add(2);
			}
		});
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(FrameGeral.class.getResource("/proximo36-2.png")));
		btnNewButton_4.setBounds(136, 507, 38, 38);
		contentPane.add(btnNewButton_4);
		btnNewButton_4 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Play the music
				buffer.add(8);
			}
		});
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(FrameGeral.class.getResource("/reset36-2.png")));
		btnNewButton_5.setBounds(176, 507, 38, 38);
		contentPane.add(btnNewButton_5);
		btnNewButton_5 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Play the music
				buffer.add(3);
			}
		});
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(FrameGeral.class.getResource("/voldown36-2.png")));
		btnNewButton_6.setBounds(640, 507, 38, 38);
		contentPane.add(btnNewButton_6);
		btnNewButton_6 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Play the music
				buffer.add(7);
			}
		});
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon(FrameGeral.class.getResource("/volup36-2.png")));
		btnNewButton_7.setBounds(680, 507, 38, 38);
		contentPane.add(btnNewButton_7);
		btnNewButton_7 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Play the music
				buffer.add(6);
			}
		});
		
		JTextField txtSearchBar1 = new JTextField();
		txtSearchBar1.setText("Search Bar");
		txtSearchBar1.setColumns(10);
		txtSearchBar1.setBounds(36, 109, 198, 33);
		contentPane.add(txtSearchBar1);
		
		JButton btnNewButton_8 = new JButton("Tracks");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(getCheckbox().isSelected()) {
					if(getRadioButton1().isSelected() ){
						setSearch_mode(4);
						}
					else if(getRadioButton2().isSelected() ){
						setSearch_mode(5);
						}
					
				}
				else {
					setSearch_mode(1);
				}

					txtSearchBar.setText(txtSearchBar1.getText());
					buffer.add(11);
			}
		});
		btnNewButton_8.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_8.setIcon(new ImageIcon(FrameGeral.class.getResource("/lupa24.png")));
		btnNewButton_8.setBounds(233, 109, 100, 33);
		contentPane.add(btnNewButton_8);
		contentPane.add(btnNewButton_8);
		
		
		JButton btnNewButton_9 = new JButton("Albuns");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSearch_mode(2);
				txtSearchBar.setText(txtSearchBar1.getText());
				buffer.add(11);
			}
		});
		btnNewButton_9.setIcon(new ImageIcon(FrameGeral.class.getResource("/lupa24.png")));
		btnNewButton_9.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_9.setBounds(331, 109, 100, 33);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Artists");
		btnNewButton_10.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_10.setBounds(431, 109, 100, 33);
		btnNewButton_10.setIcon(new ImageIcon(FrameGeral.class.getResource("/lupa24.png")));
		btnNewButton_10 .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSearch_mode(3);
				txtSearchBar.setText(txtSearchBar1.getText());
				buffer.add(11);
			}
		});
		contentPane.add(btnNewButton_10);
		
		this.setSetSearched(1);
		setTextBar(new JTextField());
		getTextBar().setBounds(321, 513, 65, 29);
		contentPane.add(getTextBar());
		getTextBar().setColumns(10);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buffer.add(5);
				int time = Integer.parseInt(getTextBar().getText());
				buffer.add(time);
			}
		});
		btnNewButton.setBounds(384, 512, 47, 33);
		contentPane.add(btnNewButton);
		
		this.logout=true;
		JButton btnTerminarSesso = new JButton("Logout");
		btnTerminarSesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			setLogout(true);	
			}
		});
		btnTerminarSesso.setBounds(580, 33, 150, 29);
		contentPane.add(btnTerminarSesso);
		

		JLabel lblNewLabel = new JLabel("tempo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(260, 519, 61, 16);
		contentPane.add(lblNewLabel);
		
		JButton buttonMinus = new JButton("-");
		buttonMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buffer.add(13);
			}
		});
		buttonMinus.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		buttonMinus.setBounds(513, 502, 33, 33);
		contentPane.add(buttonMinus);
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buffer.add(12);
			}
		});
		buttonPlus.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		buttonPlus.setBounds(558, 502, 33, 33);
		contentPane.add(buttonPlus);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(491, 273, 150, 150);
		contentPane.add(this.lblNewLabel_1);
		
		lblNomeDaMusica = new JLabel("Nome da música");
		lblNomeDaMusica.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDaMusica.setBounds(490, 429, 124, 16);
		contentPane.add(this.lblNomeDaMusica);
		
		lblNomeDoArtista = new JLabel("Nome do artista");
		lblNomeDoArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoArtista.setBounds(490, 447, 124, 16);
		contentPane.add(lblNomeDoArtista);

		this.rdbtnNewRadioButton_1 = new JRadioButton("without vocals");
		rdbtnNewRadioButton_1.setVisible(false);
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_9.setVisible(false);
				btnNewButton_10.setVisible(false);
			}
		});
		rdbtnNewRadioButton_1.setBounds(36, 180, 141, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		this.rdbtnNewRadioButton_2 = new JRadioButton("with vocals");
		rdbtnNewRadioButton_2.setVisible(false);
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				btnNewButton_9.setVisible(true);
//				btnNewButton_10.setVisible(true);
			}
		});
		rdbtnNewRadioButton_2.setBounds(183, 180, 141, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		this.BoxCaixa = new JCheckBox("Karaoke Mode");
		buttonMinus.setVisible(false);
		buttonPlus.setVisible(false);
		BoxCaixa.addMouseListener(new MouseAdapter() {
			
			//boolean checked = BoxCaixa.isSelected();
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(BoxCaixa.isSelected()) {
				btnNewButton_9.setVisible(false);
				btnNewButton_10.setVisible(false);
				rdbtnNewRadioButton_1.setVisible(true);
				rdbtnNewRadioButton_2.setVisible(true);
				rdbtnNewRadioButton_1.setSelected(true);
				buttonMinus.setVisible(true);
				buttonPlus.setVisible(true);
				}
				
			 else if (!BoxCaixa.isSelected())
			 {
			 	btnNewButton_9.setVisible(true);
				btnNewButton_10.setVisible(true);
				rdbtnNewRadioButton_1.setVisible(false);
				rdbtnNewRadioButton_2.setVisible(false);
				rdbtnNewRadioButton_1.setSelected(true);
				buttonMinus.setVisible(false);
				buttonPlus.setVisible(false);
			}
			}
		});
		BoxCaixa.setBounds(36, 149, 128, 23);
		contentPane.add(BoxCaixa);
		
//		if(tracklist.size() > 0) {
//  			if(tracklist.get(currentTrack.get()).getPlayable() == 1) {
//  				int length = tracklist.get(currentTrack.get()).getLength();
//				JLabel lblLenghtDaCancion = new JLabel();
//				lblLenghtDaCancion.setBounds(269, 495, 141, 16);
//				lblLenghtDaCancion.setText(Integer.toString(length));
//				contentPane.add(lblLenghtDaCancion);
//  			}
//  		}
		
		ButtonGroup g1 = new ButtonGroup();
		g1.add(rdbtnNewRadioButton_1);
		g1.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buffer.add(10);
			}
		});
		btnNewButton_11.setIcon(new ImageIcon(FrameGeral.class.getResource("/lixo1.png")));
		btnNewButton_11.setBounds(216, 507, 38, 38);
		contentPane.add(btnNewButton_11);
		
	}

	protected void setLogout(boolean b) {
		this.logout=b;
		
	}

	public JTextField getTextField() {
		return this.txtSearchBar;
	}

	public int getSetSearched() {
		return setSearched;
	}

	public void setSetSearched(int setSearched) {
		this.setSearched = setSearched;
	}

	public JTextField getTextBar() {
		return textBar;
	}
	
	public JCheckBox getCheckbox() {
		return BoxCaixa;
	}
	
	public JRadioButton getRadioButton1() {
		return rdbtnNewRadioButton_1;
	}
	public JRadioButton getRadioButton2() {
		return rdbtnNewRadioButton_2;
	}

	public void setTextBar(JTextField textBar) {
		this.textBar = textBar;
	}

	public int getSearch_mode() {
		return search_mode;
	}

	public void setSearch_mode(int search_mode) {
		this.search_mode = search_mode;
	}
	
	public void update() {
		  if(tracklist.size() > 0) {
	  			if(tracklist.get(currentTrack.get()).getPlayable() == 1) {
	  				//System.out.println("Eu vou atualizar");
	  				int length = tracklist.get(currentTrack.get()).getLength();
					lblLenghtDaCancion = new JLabel();
					this.lblLenghtDaCancion.setBounds(340, 495, 141, 16);
					this.lblLenghtDaCancion.setText(Integer.toString(length));
					contentPane.add(lblLenghtDaCancion);
	  				this.lblNomeDaMusica.setText(tracklist.get(currentTrack.get()).getName());
	  				this.lblNomeDoArtista.setText(tracklist.get(currentTrack.get()).getArtist_name());
	  				this.lblNewLabel_1.setIcon(new ImageIcon(tracklist.get(currentTrack.get()).getFilepath() + tracklist.get(currentTrack.get()).getImagename()));
	  				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	  				lblNewLabel_1.setBounds(490, 298, 124, 124);
	  				contentPane.add(this.lblNewLabel_1);
	  				contentPane.add(this.lblNomeDaMusica);
	  				contentPane.add(this.lblNomeDoArtista);
	  			}
	  		}
	}
}
