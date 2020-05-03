
public class PlayerDB {

	private Player head;
	private Player tail;
	private Player current;
	
	PlayerDB() {
		
	}//end constructor
	
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
		//works under the assumption that the IDs are in order inside the list
		//if list is empty (head is null) there is nothing to remove. Inform user
		if (head == null) {
			System.out.println("Nothing to remove");
		}//end if
		else {
			boolean keepGoing = true;
			//otherwise start at head
			this.current = this.head;
			//go through list until the object's id matches the index provided
			while (keepGoing) {
				//check current object's id to see if it matches
				
				if(this.current.getId()== index) {
					//this happens if object is found
					
					Player temp;
					//take current's previous player, assign it current's next
					temp = this.current.getPrevPlay();
					temp.setNextPlay(this.current.getNextPlay());
					
					//check to see if current object is last object on the list
					if(current.getNextPlay() == null) {
						//if it's the last item, it's previous becomes new tail
						this.tail = current.getPrevPlay();
					}//end if
					else {
						//take current's next player, assign it current's previous player
						temp = this.current.getNextPlay();
						temp.setPrevPlay(this.current.getPrevPlay());
					}//end else
					
					//reduce id count by 1
					Player.lastId -= 1;
					//end loop once object is found
					keepGoing = false;
					
				}//end if
				else if(this.current.getNextPlay() == null) {
					//this happens if object is found and we reach the end of the list
					
					System.out.println("Player not found");
					keepGoing = false;
				}//end if
				else {
					//this happens if object is found but there are still objects left
					
					//if it doesn't match move on to next object
					this.current = this.current.getNextPlay();
				}//end else
				
			}//end while loop
			
		}//end else
	}//end remove
	
	//method to count how many players exist/have been created
	public void setLarget(int maxId) {
		Player.lastId = maxId;
	}//end setLargest
}//end class
