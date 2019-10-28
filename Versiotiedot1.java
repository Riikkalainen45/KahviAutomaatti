

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

	public class Versiotiedot1 extends JFrame{

	
	    JPanel contentPane;
	    JLabel imageLabel = new JLabel();
	    JLabel headerLabel = new JLabel();
	    ImageIcon icon;
	    
// uusi frame ja siihen teksti ja gif ... jos onnistuu
	    
	    public Versiotiedot1() {
	    	
	        try {
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	            contentPane = (JPanel) getContentPane();
	            contentPane.setLayout(new BorderLayout());
	            setSize(new Dimension(400, 300));
	            setTitle("JuomaAutomaatin versio 30.10.2019");
	            icon = new ImageIcon("src/img/starbucks.png");
	            setIconImage(icon.getImage());
	            
	            
	            // Otsikko
	            headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
	            headerLabel.setText("Versiosta vastuussa: Riikka Niemi 1751510");
	            contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
	            

	           
	            ImageIcon ulalla = new ImageIcon(this.getClass().getResource("img/starbucks.png"));
	            imageLabel.setIcon(ulalla);
	            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
	            
	            
            this.setLocationRelativeTo(null);
	            this.setVisible(true);
	        }
	         catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }
	          

	    public static void main(String[] args) {
	    	EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    			try {
	    				Versiotiedot1 frame = new Versiotiedot1();
	    				frame.setVisible(true);
	    			}
	    			catch  (Exception ex) {
	    				System.out.println("Ulalla joo ollaan!");	
	    				}
	    			}
	    		
	    	});
	        
	    }

	}




