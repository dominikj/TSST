package atmNode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class Window extends JFrame{
	
	private DefaultTableModel modelTable = new DefaultTableModel();
	private JTable FIB = new JTable(modelTable);
	private JTextPane history;
	
	Window(){
		setTitle("Węzeł ATM");
		setResizable(false);
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scroll = new JScrollPane(FIB);
		scroll.setBounds(12, 43, 300, 200);
		scroll.setEnabled(false);
		panel.add(scroll);
		modelTable.addColumn("Port_s");
		modelTable.addColumn("VPI_s");
		modelTable.addColumn("VCI_s");
		modelTable.addColumn("Port_d");
		modelTable.addColumn("VPI_d");
		modelTable.addColumn("VCI_d");
		
		history = new JTextPane();
		history.setBounds(330, 43, 400, 200);
		panel.add(history);
	}
	
	public void setEntry(String port_s, String vpi_s, String vci_s,String port_d, String vpi_d, String vci_d){
		modelTable.addRow(new Object[] {port_s, vpi_s, vci_s, port_d, vpi_d, vci_d});
	}
	
	public void appendHistory(String hist){
	     StyledDocument document = (StyledDocument) history.getDocument();
	     try {
			document.insertString(document.getLength(),hist, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	                                                   
	 }
	
}
