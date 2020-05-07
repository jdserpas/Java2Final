import java.io.*;

public class PlayerDB implements Serializable{

	private Player head;
	private Player tail;
	private Player current;
		
	PlayerDB() {
		Player a = new Player("Default", "Player", "Default Team", Player.Position.Catcher, 0);
		
		append(a);
		
	}//end constructor
	
	//a method to show all objects in the list
	public void showAll() {
		Player finder = this.head;
		
		while (finder != null) {
			//print each player
			System.out.println(finder.getFirstName() + "" + finder.getId());
			System.out.println("");
			
			finder = finder.getNextPlay();
		}//end for
		
	}//end show All
	
	public void append(Player value) {
		//first check to see if list is empty
		//if the list is empty then head will be null
		if (head == null) {
			//so if head is null then the new value will go to beginning of line (a.k.a. the head)
			this.head = value;
			//make it the new tail since it is alone on list
			this.tail = value;
		}//end if
		else {
			//if head does not equal null check last object in the line (tail)
			//store tail in temporary variable
			this.current = this.tail;
			//make the new value the tail
			this.tail = value;
			//set previous tail as new value's previous
			this.tail.setPrevPlay(this.current);
			//set new value as previous tail's next
			this.current.setNextPlay(this.tail);
		}//end else
		
	}//end append
	
	public void remove(int index) {
		Player rmv = findPlayer(index);
		
		if (this.head == null) {
			//if list is empty (head is null) there is nothing to remove. Inform user
			System.out.println("List is empty");
		}//end if
		else if(rmv == null) {
			//if object to be removed is not found, inform user.
			System.out.println("Player not found");
		}//end if
		else {
			//in all other cases, object can be removed
			Player temp;
			
			//check to see if rmv is first object on the list
			if (rmv.getPrevPlay() == null) {
				//it it's the first object, it's next object becomes the new first
				this.head =rmv.getNextPlay();
			}//end if 
			else {
				//take rmv's previous player, assign it rmv's next
				temp = rmv.getPrevPlay();
				temp.setNextPlay(rmv.getNextPlay());
			}
			//end if
			//check to see if rmv is last object on the list
			if(rmv.getNextPlay() == null) {
				//if it's the last item, it's previous becomes new tail
				this.tail = rmv.getPrevPlay();
			}//end if
			else {
				//take rmv's next player, assign it rmv's previous player
				temp = rmv.getNextPlay();
				temp.setPrevPlay(rmv.getPrevPlay());
			}//end else
			
		}//end else
		
	}//end remove
	
	//method to go through list and find desired object
	public Player findPlayer(int index) {
		//works under the assumption that the IDs are unique
		Player finder = this.head;
		Player result = null;
		int counter = 0;
		
		while (finder != null) {
			//check each objects id to see if its id we're looking for
			if(counter == index) {
				result = finder;
			}//end if
			
			counter++;
			finder = finder.getNextPlay();
			
		}//end for
		
		//if we went through entire list without finding anything, method should return null
		return result;
	}//end findPlayer
	
	//method to return amount of players on the list
	public int lenght() {
		Player finder = this.head;
		int amount= 0;
		
		while (finder != null) {
			//count how many times we loop
			amount++;
			finder = finder.getNextPlay();
		}//end for
		
		return amount;
	}//end setLargest
	
}//end class
