import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
//this will be the class with the main user interface
public class Interface extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		new Interface();
	}//end main
	
	PlayerDB players = new PlayerDB();
	Player tempPlayer;
	
	//add all components
	JPanel primary = new JPanel();
	JPanel west = new JPanel();
	JPanel edit = new JPanel();
	JPanel editSouth = new JPanel();
	JPanel selector = new JPanel();
	JPanel selectorSth = new JPanel();
	JPanel display = new JPanel();
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
	JButton modifyBttn = new JButton("Modify");
	//selector JPanel object
	DefaultListModel<String> nameList = new DefaultListModel<>();
	JList<String> playerLst = new JList<>(nameList);
	//selectorSth JPanel object
	JButton moreBttn = new JButton("More");
	JButton edit2Bttn = new JButton("Edit Player");
	JButton del2Bttn = new JButton("Delete Player");
	//display JPanel object
	JLabel firstLbl = new JLabel("First Name: ");
	JLabel secondLbl = new JLabel("Second Name: ");
	JLabel teamLbl = new JLabel("Team: ");
	JLabel positionLbl = new JLabel("Position: ");
	JLabel avgLbl = new JLabel("Batting Average:");
	JButton cancelBttn = new JButton("Cancel");
	
	public Interface() {
		init();
	}//end constructor
	
	//initializing all components
	private void init() {
		
		//Interface JFrame
		this.setSize(500, 300);
		this.add(primary);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		saveBttn.addActionListener(this);
		west.add(Box.createRigidArea(separator));
		west.add(loadBttn);
		loadBttn.addActionListener(this);
		west.add(Box.createRigidArea(separator));
		west.add(exitBttn);
		exitBttn.addActionListener(this);
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
		addBttn.addActionListener(this);
		addBttn.setVisible(false);
		editSouth.add(modifyBttn);
		modifyBttn.addActionListener(this);
		modifyBttn.setVisible(false);
		//selector JPanel
		selector.setVisible(false);
		selector.setLayout(new GridLayout(0,1));
		selector.add(playerLst);
		//selectorSth JPanel
		selectorSth.setVisible(false);
		selectorSth.add(moreBttn);
		moreBttn.addActionListener(this);
		moreBttn.setVisible(false);
		selectorSth.add(edit2Bttn);
		edit2Bttn.addActionListener(this);
		edit2Bttn.setVisible(false);
		selectorSth.add(del2Bttn);
		del2Bttn.addActionListener(this);
		del2Bttn.setVisible(false);
		//display JPanel
		display.setVisible(false);
		display.setLayout(new GridLayout(0, 1));
		display.add(firstLbl);
		display.add(secondLbl);
		display.add(teamLbl);
		display.add(positionLbl);
		display.add(avgLbl);
		display.add(cancelBttn);
		cancelBttn.addActionListener(this);
		
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
			addBttn.setVisible(true);
			//reset text boxes
			firstTxt.setText("");
			secondTxt.setText("");
			teamTxt.setText("");
			positionCmb.setSelectedIndex(0);
			avgTxt.setText("");
		}//end if
		else if (source == infoBttn) {
			hideAll();
			primary.add(selector, BorderLayout.CENTER);
			primary.add(selectorSth, BorderLayout.SOUTH);
			selector.setVisible(true);
			selectorSth.setVisible(true);
			moreBttn.setVisible(true);
			loadList(players);
			playerLst.setSelectedIndex(0);
		}//end if
		else if (source == editBttn) {
			hideAll();
			primary.add(selector, BorderLayout.CENTER);
			primary.add(selectorSth, BorderLayout.SOUTH);
			selector.setVisible(true);
			selectorSth.setVisible(true);
			edit2Bttn.setVisible(true);
			loadList(players);
			playerLst.setSelectedIndex(0);
		}//end else if
		else if (source == delBttn) {
			hideAll();
			primary.add(selector, BorderLayout.CENTER);
			primary.add(selectorSth, BorderLayout.SOUTH);
			selector.setVisible(true);
			selectorSth.setVisible(true);
			del2Bttn.setVisible(true);
			
			loadList(players);
			playerLst.setSelectedIndex(0);
		}//end else if
		else if (source == saveBttn) {
			JFileChooser chooser = new JFileChooser();
			File workingDir = new File(System.getProperty("user.dir"));
			chooser.setCurrentDirectory(workingDir);
			int returnVal = chooser.showOpenDialog(this);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					File theFile = chooser.getSelectedFile();
					FileOutputStream fo = new FileOutputStream(theFile);
					ObjectOutputStream obOut = new ObjectOutputStream(fo);
					obOut.writeObject(players);
					obOut.close();
				}//end try
				catch (IOException x) {
					JOptionPane.showMessageDialog(null, 
							  					  "Something went wrong",
							  					  "Error",
							  					  JOptionPane.ERROR_MESSAGE);
				}//end catch
			}//end if
			
		}//end else if
		else if (source == loadBttn) {
			JFileChooser chooser = new JFileChooser();
			File workingDir = new File(System.getProperty("user.dir"));
			chooser.setCurrentDirectory(workingDir);
			
			int returnVal = chooser.showOpenDialog(this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					File theFile = chooser.getSelectedFile();
					FileInputStream fi = new FileInputStream(theFile);
					ObjectInputStream obIn = new ObjectInputStream(fi);
					players = (PlayerDB)obIn.readObject();
					obIn.close();
				}//end try
				catch (IOException x) {
					JOptionPane.showMessageDialog(null, 
		  					  					  "Something went wrong",
		  					  					  "Error",
		  					  					  JOptionPane.ERROR_MESSAGE);
				}//end catch
				catch (ClassNotFoundException x) {
					JOptionPane.showMessageDialog(null, 
		  					  					  "Something went wrong",
		  					  					  "Error",
		  					  					  JOptionPane.ERROR_MESSAGE);
				}//end catch
			}//end if
			
		}//end else if
		else if (source == exitBttn) {
			this.dispose();
		}//end else if
		else if (source == addBttn) {
			//get info player put in
			String nFirstName = firstTxt.getText();
			String nSecondName = secondTxt.getText();
			String nTeam = teamTxt.getText();
			Player.Position position = (Player.Position)positionCmb.getSelectedItem();
			String avgString = avgTxt.getText();
			double avg;
			try {
				avg = Double.parseDouble(avgString);
			}//end try
			catch(NumberFormatException f) {
				avg = 0.0;
			}//end catch
			
			//create a player with said info parameters
			Player add = new Player(nFirstName,
									nSecondName,
									nTeam,
									position,
									avg);
			//add player to DB
			players.append(add);
			//reset text boxes
			firstTxt.setText("");
			secondTxt.setText("");
			teamTxt.setText("");
			positionCmb.setSelectedIndex(0);
			avgTxt.setText("");
			
		}//end else if
		else if (source == moreBttn) {
			//get selected player
			int selection = playerLst.getSelectedIndex();
			tempPlayer = players.findPlayer(selection);
			
			//load displayer
			hideAll();
			primary.add(display);
			display.setVisible(true);
			firstLbl.setText("First Name: " + tempPlayer.getFirstName());
			secondLbl.setText("Second Name: " + tempPlayer.getSecondName());
			teamLbl.setText("Team: " + tempPlayer.getTeam());
			Player.Position tempPosition = tempPlayer.getPosition();
			positionLbl.setText("Team: " + tempPosition.toString());
			avgLbl.setText("Batting Average: " + Double.toString(tempPlayer.getBattAvg()));
			
		}//end else if
		else if (source == cancelBttn) {
			hideAll();
		}//else if
		else if (source == edit2Bttn) {
			//get selected player
			int selection = playerLst.getSelectedIndex();
			tempPlayer = players.findPlayer(selection);
			
			//load editor with selected player's info
			hideAll();
			primary.add(edit, BorderLayout.CENTER);
			primary.add(editSouth, BorderLayout.SOUTH);
			edit.setVisible(true);
			editSouth.setVisible(true);
			modifyBttn.setVisible(true);
			
			firstTxt.setText(tempPlayer.getFirstName());
			secondTxt.setText(tempPlayer.getSecondName());
			teamTxt.setText(tempPlayer.getTeam());
			Player.Position tempPosition = tempPlayer.getPosition();
			positionCmb.setSelectedIndex(tempPosition.ordinal());
			avgTxt.setText(Double.toString(tempPlayer.getBattAvg()));
			
		}//end else if
		else if (source == modifyBttn) {
			//get info player put in
			String nFirstName = firstTxt.getText();
			String nSecondName = secondTxt.getText();
			String nTeam = teamTxt.getText();
			Player.Position position = (Player.Position)positionCmb.getSelectedItem();
			String avgString = avgTxt.getText();
			double avg;
			try {
				avg = Double.parseDouble(avgString);
			}//end try
			catch(NumberFormatException f) {
				avg = 0.0;
			}//end catch
			
			tempPlayer.setFirstName(nFirstName);
			tempPlayer.setSecondName(nSecondName);
			tempPlayer.setTeam(nTeam);
			tempPlayer.setPosition(position);
			tempPlayer.setBattAvg(avg);
			
			JOptionPane.showMessageDialog(this, 
										  "Player modified successfuly!", 
										  "Success", 
										  JOptionPane.INFORMATION_MESSAGE);
		}//end else if
		else if (source == del2Bttn) {
			int selection = playerLst.getSelectedIndex();
			players.remove(selection);
			loadList(players);
			playerLst.setSelectedIndex(0);	
		}//end else if
	}//end actionPerformed
	
	//method to hide all JPanels before a new one is loaded
	public void hideAll() {
		edit.setVisible(false);
		editSouth.setVisible(false);
		selector.setVisible(false);
		selectorSth.setVisible(false);
		moreBttn.setVisible(false);
		addBttn.setVisible(false);
		modifyBttn.setVisible(false);
		edit2Bttn.setVisible(false);
		del2Bttn.setVisible(false);
		edit.setVisible(false);
		display.setVisible(false);
		primary.remove(edit);
		primary.remove(editSouth);
		primary.remove(selector);
		primary.remove(selectorSth);
		primary.remove(display);
	}//end hide all
	
	//method to load JList with all players
	public void loadList(PlayerDB list) {
		Player current;
		String name;
		int i;
		
		nameList.removeAllElements();
		//for every player
		for (i = 0; i < list.lenght(); i++) {
			
			//get player at current index
			current = list.findPlayer(i);
			//get that player's first and last name
			name = current.getFirstName() + " " + current.getSecondName();
			//add that player to the list
			nameList.addElement(name);
		}//end for
	}//end loadList

}//end class
