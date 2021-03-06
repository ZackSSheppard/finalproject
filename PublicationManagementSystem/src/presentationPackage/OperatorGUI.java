package presentationPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import domainPackage.Document;

public class OperatorGUI {

	private JFrame frame;
	private Operator op;

	/**
	 * Create the application.
	 */
	public OperatorGUI(Operator operator) {
		op = operator;
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
		frame.setBounds(100, 100, 329, 208);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddDocuments = new JButton("Add Document");
		btnAddDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDoc();
			}
		});
		btnAddDocuments.setBounds(76, 29, 152, 25);
		frame.getContentPane().add(btnAddDocuments);
		
		JButton btnRemoveDocument = new JButton("Remove Document");
		btnRemoveDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeDoc();
			}
		});
		btnRemoveDocument.setBounds(76, 67, 152, 25);
		frame.getContentPane().add(btnRemoveDocument);
		
		JButton btnEditDocument = new JButton("Edit Document");
		btnEditDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editDoc();
			}
		});
		btnEditDocument.setBounds(76, 105, 152, 25);
		frame.getContentPane().add(btnEditDocument);
	}
	
	public void addDoc() {
		// Option pane with all document attributes:
		Document d = new Document("", false, 0.0, "", "", "", "");
		DocumentGUI dg = new DocumentGUI(op, d, -1);
	}
	
	public void removeDoc() {
		// Enter Doc ID
		String s = JOptionPane.showInputDialog("Enter Document ID");
        int a = Integer.parseInt(s);
	    if(a >= 0) {
	    	op.removeDoc(a);
	    }
	}
	
	public void editDoc() {
		// Search first
		String s = JOptionPane.showInputDialog("Enter Document ID");
        int a = Integer.parseInt(s);
	    if(a >= 0) {
	    	// Pull up similar pane to addDoc
	    	Document d = op.selectDoc(a);
	    	DocumentGUI dg = new DocumentGUI(op, d, a);
	    }
	}
}
