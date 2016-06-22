package Windows;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Testing extends JPanel {

	  JScrollPane scrollpane;
 
	/**
	 * Create the panel.
	 */
	public Testing() {
		
		//super("JScrollPane Demonstration");
	    //setSize(300, 200);
	    //setDefaultCloseOperation(EXIT_ON_CLOSE);

	    String categories[] = { "Household", "Office", "Extended Family",
	        "Company (US)", "Company (World)", "Team", "Will",
	        "Birthday Card List", "High School", "Country", "Continent",
	        "Planet" };
	    JList list = new JList(categories);
	    scrollpane = new JScrollPane(list);

	    add(scrollpane);
	    
	    JButton btnNewButton = new JButton("New button");
	    add(btnNewButton);

	}

}
