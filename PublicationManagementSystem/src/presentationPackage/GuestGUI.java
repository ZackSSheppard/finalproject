package presentationPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class GuestGUI {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GuestGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(97, 38, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reg();
			}
		});
		btnRegister.setBounds(388, 38, 97, 25);
		frame.getContentPane().add(btnRegister);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setEnabled(false);
		btnAddToCart.setBounds(78, 395, 97, 25);
		frame.getContentPane().add(btnAddToCart);
		
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setEnabled(false);
		btnRemoveFromCart.setBounds(227, 395, 137, 25);
		frame.getContentPane().add(btnRemoveFromCart);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setEnabled(false);
		btnPlaceOrder.setBounds(426, 395, 106, 25);
		frame.getContentPane().add(btnPlaceOrder);
		
		JLabel lblCart = new JLabel("Shopping Cart");
		lblCart.setBounds(259, 259, 97, 16);
		frame.getContentPane().add(lblCart);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(38, 286, 517, 96);
		frame.getContentPane().add(textArea_1);
		
		JButton btnPromotions = new JButton("Promotions");
		btnPromotions.setEnabled(false);
		btnPromotions.setBounds(248, 38, 97, 25);
		frame.getContentPane().add(btnPromotions);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(38, 124, 517, 103);
		frame.getContentPane().add(textArea);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.setBounds(278, 98, 47, 16);
		frame.getContentPane().add(lblBooks);
	}
	
	public void reg() {
		RegisterGUI r = new RegisterGUI();
	}
}
