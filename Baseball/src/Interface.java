import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//this will be the class with the main user interface
public class Interface extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		new Interface();
	}//end main
	
	//add all components
	JPanel primary = new JPanel();
	JPanel west = new JPanel();
	JPanel edit = new JPanel();
	JPanel editSouth = new JPanel();
	JPanel selector = new JPanel();
	JPanel selectorSth = new JPanel();
	//dimension
	Dimension separator = new Dimension(0,10);//separator between buttons
	//west JPanel objects
	JButton newBttn = new JButton("New Player");
	JButton infoBttn = new JButton("Show Players");
	JButton editBttn = new JButton("Edit Player");
	JButton delBttn = new JButton("Delete Player");
	JButton saveBttn = new JButton("Save");
	JButton loadBttn = new JButton("Load");
	JButton exitBttn = new JButton("Exit");
	//edit JPanel object
	JTextField firstTxt = new JTextField("", 20);
	JTextField secondTxt = new JTextField("", 20);
	JTextField teamTxt = new JTextField("", 20);
	JComboBox<Player.Position> positionCmb = new JComboBox<>(Player.Position.values());
	JTextField avgTxt = new JTextField("", 20);
	//editSouth JPanel object
	JButton addBttn = new JButton("Add");
	//selector JPanel object
	JLabel selectLbl = new JLabel("Please Select a Player");
	DefaultListModel<String> nameList = new DefaultListModel<>();
	JList<String> playerLst = new JList<>(nameList);
	//selectorSth JPanel object
	JButton moreBttn = new JButton("More");
	JButton edit2Bttn = new JButton("Edit Player");
	JButton del2Bttn = new JButton("Delete Player");
	
	public Interface() {
		init();
	}//end constructor
	
	//initializing all components
	private void init() {
		
		//Interface JFrame
		this.setSize(500, 300);
		this.add(primary);
		//primary JPanel
		primary.setLayout(new BorderLayout());
		primary.add(west, BorderLayout.WEST);
		//primary.add(selectorSth, BorderLayout.SOUTH);
		//west JPanel
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.add(Box.createRigidArea(separator));
		west.add(newBttn);
		newBttn.addActionListener(this);
		west.add(Box.createRigidArea(separator));
		west.add(infoBttn);
		infoBttn.addActionListener(this);
		west.add(Box.createRigidArea(separator));
		west.add(editBttn);
		editBttn.addActionListener(this);
		west.add(Box.createRigidArea(separator));
		west.add(delBttn);
		delBttn.addActionListener(this);
		west.add(Box.createRigidArea(separator));
		west.add(saveBttn);
		west.add(Box.createRigidArea(separator));
		west.add(loadBttn);
		west.add(Box.createRigidArea(separator));
		west.add(exitBttn);
		west.add(Box.createRigidArea(separator));
		//edit JPanel
		edit.setVisible(false);
		GridLayout editLayout = new GridLayout(0, 1);
		editLayout.setVgap(10);
		edit.setLayout(editLayout);
		edit.add(firstTxt);
		edit.add(secondTxt);
		edit.add(teamTxt);
		edit.add(positionCmb);
		edit.add(avgTxt);
		//editSouth JPanel
		editSouth.setVisible(false);
		editSouth.setLayout(new FlowLayout());
		editSouth.add(addBttn);
		//selector JPanel
		selector.setVisible(false);
		selector.add(selectLbl);
		selector.add(playerLst);
		//selectorSth JPanel
		selectorSth.setVisible(false);
		selectorSth.add(moreBttn);
		moreBttn.setVisible(false);
		selectorSth.add(edit2Bttn);
		edit2Bttn.setVisible(false);
		selectorSth.add(del2Bttn);
		del2Bttn.setVisible(false);
		//firstTxt JTextField
		firstTxt.setMaximumSize(new Dimension(50,20));
		
		this.setVisible(true);
		
	}//end init
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if (source == newBttn) {
			hideAll();
			primary.add(edit, BorderLayout.CENTER);
			primary.add(editSouth, BorderLayout.SOUTH);
			edit.setVisible(true);
			editSouth.setVisible(true);
		}//end if
		else if (source == infoBttn) {
			hideAll();
			primary.add(selector, BorderLayout.CENTER);
			primary.add(selectorSth, BorderLayout.SOUTH);
			selector.setVisible(true);
			selectorSth.setVisible(true);
			moreBttn.setVisible(true);
			//loadList();
		}//end if
		else if (source == editBttn) {
			hideAll();
			primary.add(selector, BorderLayout.CENTER);
			primary.add(selectorSth, BorderLayout.SOUTH);
			selector.setVisible(true);
			selectorSth.setVisible(true);
			edit2Bttn.setVisible(true);
		}//end else if
		else if (source == delBttn) {
			hideAll();
			primary.add(selector, BorderLayout.CENTER);
			primary.add(selectorSth, BorderLayout.SOUTH);
			selector.setVisible(true);
			selectorSth.setVisible(true);
			del2Bttn.setVisible(true);
		}
	}//end actionPerformed
	
	//method to hide all JPanels before a new one is loaded
	public void hideAll() {
		edit.setVisible(false);
		editSouth.setVisible(false);
		selector.setVisible(false);
		selectorSth.setVisible(false);
		moreBttn.setVisible(false);
		edit2Bttn.setVisible(false);
		del2Bttn.setVisible(false);
		primary.remove(edit);
		primary.remove(editSouth);
		primary.remove(selector);
		primary.remove(selectorSth);
	}//end hide all
	
	//method to load JList with all players
	public void loadList(PlayerDB list) {
		Player current;
		String name;
		int i;
		//for every player
		for (i = 0; i < list.lenght(); i++) {
			//get player at current index
			current = list.findPlayer(i);
			//get that player's first and last name
			name = current.getFirstName() + "" + current.getSecondName();
			//add that player to the list
			nameList.addElement(name);
		}//end for
	}//end loadList

}//end class
