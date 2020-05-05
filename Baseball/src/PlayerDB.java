
public class PlayerDB {

	private Player head;
	private Player tail;
	private Player current;
	
	public static void main(String[] args) {
		new PlayerDB();
	}//end main
	
	PlayerDB() {
		Player a = new Player("a", "a", "a");
		Player b = new Player("b", "b", "b");
		Player c = new Player("c", "c", "c");
		
		append(a);
		append(b);
		append(c);
		
		showAll();
		System.out.println(this.lenght());
		System.out.println("");
		
		remove(1);
		
		showAll();
		System.out.println(this.lenght());
		System.out.println("");
		
		Player n = new Player("n", "n", "n");
		append(n);
		
		showAll();
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
			
			//take rmv's previous player, assign it rmv's next
			temp = rmv.getPrevPlay();
			temp.setNextPlay(rmv.getNextPlay());
			
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
		//works under the assumption that the IDs are in order inside the list
		Player finder = this.head;
		Player result = null;
		
		//first parameter initializes finder to start of list(head)
		//second parameter states that loop will keep going until last item is reached(next is null)
		//third parameter moves the finder to its next object
		while (finder.getNextPlay() != null) {
			//check each objects id to see if its id we're looking for
			if(finder.getId() == index) {
				result = finder;
			}//end if
			finder = finder.getNextPlay();
		}//end for
		
		//if we went through entire list without finding anything method should return null
		return result;
	}//end findPlayer
	
	//method to reset Id counter to the amount of players on the list
	public int lenght() {
		Player finder = this.head;
		int amount= 0;
		
		//first parameter initializes finder to start of list(head)
		//second parameter states that loop will keep going until last item is reached(next is null)
		//third parameter moves the finder to its next object
		while (finder != null) {
			//check each objects id to see if its id we're looking for
			amount++;
			finder = finder.getNextPlay();
		}//end for
		
		return amount;
	}//end setLargest
	
}//end class
