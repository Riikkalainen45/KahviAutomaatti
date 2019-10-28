import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class kahvimaatti1 extends JFrame {
	
	Scanner lukija = new Scanner(System.in);
	
	JuomaAutomaatti omaKone = new JuomaAutomaatti();


	private JPanel contentPane;

	private int uusiKahvi;
	private int uusiTee;
	private int uusiKaakao;
	private JTextField txtKahvi;
	private JTextField txtTee;
	private JTextField txtKaakao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kahvimaatti1 frame = new kahvimaatti1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public kahvimaatti1() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(kahvimaatti1.class.getResource("/img/tea.jpg")));
		setTitle("KahviAutomaatti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Yll\u00E4pito");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNewKahviAnnos();
				omaKone.setKahvi(uusiKahvi);
			}
		});
		mnNewMenu.add(mntmAsetaKahvinMr);
		
		
		JMenuItem mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNewTeeAnnos();
				omaKone.setTee(uusiTee);
				
			}
		});
		mnNewMenu.add(mntmAsetaTeenMr);
		
		JMenuItem mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNewKaakaoAnnos();
				omaKone.setKaakao(uusiKaakao);
			}
		});
		mnNewMenu.add(mntmAsetaKaakaonMr);
		
		JMenuItem mntmTallennaAutomaatinTila = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Sarjallistamista.kirjoitaTiedostoon(omaKone);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}	
			
			}
		});
		mnNewMenu.add(mntmTallennaAutomaatinTila);
		
		JMenuItem mntmLataaAutomaatti = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					JuomaAutomaatti omaKone = Sarjallistamista.lueTiedostosta();
					omaKone.setKahvi(uusiKahvi);
				
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmLataaAutomaatti);
		
		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmLopeta);
		
		JMenu mnNewMenu_1 = new JMenu("Ohjelmatietoja");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmOhjelmaversio = new JMenuItem("OhjelmaVersio");
		mntmOhjelmaversio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Versiotiedot1 frame = new Versiotiedot1();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(mntmOhjelmaversio);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 omaKone.valmistaKahvi();
				 btnNewButton.setText(Integer.toString(omaKone.getKahvi()));
				 
		    	if(omaKone.getKahvi()<25) {
		    		btnNewButton.setForeground(Color.RED);
		    	}
			}
		});
		btnNewButton.setIcon(new ImageIcon(kahvimaatti1.class.getResource("/img/coffee.jpg")));
		btnNewButton.setBounds(10, 24, 424, 134);
		contentPane.add(btnNewButton);
		
		txtKahvi = new JTextField();
		txtKahvi.setText("KAHVI");
		txtKahvi.setBounds(193, 169, 66, 20);
		contentPane.add(txtKahvi);
		txtKahvi.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent et) {
				omaKone.valmistaTee();
				 btnNewButton_1.setText(Integer.toString(omaKone.getTee()));
				 
		    	if(omaKone.getTee()<25) {
		    		btnNewButton_1.setForeground(Color.RED);
		    	}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(kahvimaatti1.class.getResource("/img/tea.jpg")));
		btnNewButton_1.setBounds(10, 223, 424, 134);
		contentPane.add(btnNewButton_1);
		
		txtTee = new JTextField();
		txtTee.setText("TEE");
		txtTee.setBounds(184, 381, 86, 20);
		contentPane.add(txtTee);
		txtTee.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ek) {
				omaKone.valmistaKaakao();
				 btnNewButton_2.setText(Integer.toString(omaKone.getKaakao()));
				 
		    	if(omaKone.getKaakao()<25) {
		    		btnNewButton_2.setForeground(Color.RED);
		    	}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(kahvimaatti1.class.getResource("/img/cocoa.jpg")));
		btnNewButton_2.setBounds(10, 440, 424, 127);
		contentPane.add(btnNewButton_2);
		
		txtKaakao = new JTextField();
		txtKaakao.setText("KAAKAO");
		txtKaakao.setBounds(184, 586, 86, 20);
		contentPane.add(txtKaakao);
		txtKaakao.setColumns(10);
	}
		private void getNewKahviAnnos() {
			JTextField kahviField = new JTextField(6);
			 JPanel kahPanel = new JPanel();
			 kahPanel.add(new JLabel("Kahvin määrä"));
			 kahPanel.add(kahviField);
			 
			 int result = JOptionPane.showConfirmDialog(null, kahPanel, "Kahvin määrä",
						JOptionPane.OK_CANCEL_OPTION);
			 
			 String uusiArvo = JOptionPane.showInputDialog(null, "Varmista kahvin määrä");
			 if (result == JOptionPane.OK_OPTION) {
				uusiKahvi = Integer.parseInt(uusiArvo);
				return ;
			 }
			 System.exit(0);
		}	
		
		private void getNewTeeAnnos() {
			JTextField teeField = new JTextField(6);
			 JPanel teePanel = new JPanel();
			 teePanel.add(new JLabel("Teen määrä"));
			 teePanel.add(teeField);
			 
			 int result = JOptionPane.showConfirmDialog(null, teePanel, "Teen määrä",
						JOptionPane.OK_CANCEL_OPTION);
			 
			 String uusiArvo1 = JOptionPane.showInputDialog(null, "Varmista teen määrä");
			 if (result == JOptionPane.OK_OPTION) {
				uusiTee = Integer.parseInt(uusiArvo1);
				return;
			 }
			System.exit(0);
			
		}
	

			private void getNewKaakaoAnnos() {
					JTextField kaaField = new JTextField(6);
					JPanel kaaPanel = new JPanel();
					kaaPanel.add(new JLabel("Kaakaon määrä"));
					kaaPanel.add(kaaField);
	 
					int result = JOptionPane.showConfirmDialog(null, kaaPanel, "Kaakaon määrä",
							JOptionPane.OK_CANCEL_OPTION);
	 
					String uusiArvo2 = JOptionPane.showInputDialog(null, "Varmista kaakaon määrä");
					if (result == JOptionPane.OK_OPTION) {
						uusiKaakao = Integer.parseInt(uusiArvo2);
						return;
					}
					System.exit(0);
	
			}
}
