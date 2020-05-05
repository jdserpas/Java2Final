import java.awt.*;
import javax.swing.*;

//this will be the class with the main user interface
public class Interface extends JFrame {
	
	public static void main(String[] args) {
		new Interface();
	}//end main
	
	//add all components
	JPanel primary = new JPanel();
	JPanel west = new JPanel();
	Dimension separator = new Dimension(0,10);//separator between buttons
	Button newBttn = new Button("New Player");
	Button infoBttn = new Button("Show Players");
	Button editBttn = new Button("Edit Player");
	Button delBttn = new Button("Delete Player");
	Button saveBttn = new Button("Save");
	Button loadBttn = new Button("Load");
	Button exitBttn = new Button("Exit");
	
	public Interface() {
		init();
	}//end constructor
	
	//initializing all components
	private void init() {
		
		//Interface JFrame
		this.setSize(500, 500);
		this.add(primary);
		//primary JPanel
		primary.setLayout(new BorderLayout());
		primary.add(west, BorderLayout.WEST);
		//west panel
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.add(Box.createRigidArea(separator));
		west.add(newBttn);
		west.add(Box.createRigidArea(separator));
		west.add(infoBttn);
		west.add(Box.createRigidArea(separator));
		west.add(editBttn);
		west.add(Box.createRigidArea(separator));
		west.add(delBttn);
		west.add(Box.createRigidArea(separator));
		west.add(saveBttn);
		west.add(Box.createRigidArea(separator));
		west.add(loadBttn);
		west.add(Box.createRigidArea(separator));
		west.add(exitBttn);
		west.add(Box.createRigidArea(separator));
		
	}//end init

}//end class
