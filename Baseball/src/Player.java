
public class Player {

	//make enumeration so positions are fixed
	enum Position {Catcher, First, Second, Shortstop, Third,
		LeftField, CenterField, RightField, Designated
	}
	//player data
	private String firstName;
	private String secondName;
	private String team;
	private Position position;
	private double battAvg = 0.0;
	//private double slug= 0.0;
	//private double onBase= 0.0;
	//database data
	private Player prevPlay;
	private Player nextPlay;
	public static int lastId = 0;
	private int id = lastId;
	
	//constructor only sets player name and team
	//everything else will have to be edited in to avoid complication
	public Player (String first, String second, String team, Position pos, double avg) {
		this.firstName = first;
		this.secondName = second;
		this.team = team;
		this.position = pos;
		avg = round(avg, 3);
		this.battAvg = avg;
		//this.slug = 0.0;
		//this.onBase = 0.0;
		this.prevPlay = null;
		this.nextPlay = null;
		
		lastId++;
	}//end constructor
	
	
	//make getters and setters
	public void setFirstName(String value) {
		this.firstName = value;
	}//end set
	
	public String getFirstName() {
		return this.firstName;
	}//end get
	
	public void setSecondName(String value) {
		this.secondName = value;
	}//end set
	
	public String getSecondName() {
		return this.secondName;
	}//end get
	
	public void setTeam(String value) {
		this.team = value;
	}//end set
	
	public String getTeam() {
		return this.team;
	}//end get
	
	public void setPosition(Position value) {
		this.position = value;
	}//end set
	
	public Position getPosition() {
		return this.position;
	}//end get
	
	public void setBattAvg(double value) {
		value = round(value, 3);
		this.battAvg = value;
	}//end set
	
	public double getBattAvg() {
		return this.battAvg;
	}//end get
	/*
	public void setSlug(double value) {
		value = round(value,3);
		this.slug = value;
	}//end set
	
	public double getSlug() {
		return this.slug;
	}//end get
	
	public void setOnBase(double value) {
		value = round(value, 3);
		this.onBase = value;
	}//end set
	
	public double getOnBase() {
		return this.onBase;
	}//end get
	*/
	//id only has a get
	public int getId() {
		return id;
	}//end get
	
	public void setPrevPlay(Player value) {
		this.prevPlay = value;
	}//end set
	
	public Player getPrevPlay() {
		return this.prevPlay;
	}//end get
	
	public void setNextPlay(Player value) {
		this.nextPlay = value;
	}//end set
	
	public Player getNextPlay() {
		return this.nextPlay;
	}//end get
	
	//method to add to last id
	public static void addLastId() {
		++lastId;
	}//end addLastId
	
	//method to round doubles
	//using this to format all double properties
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}//end round
}//end class
