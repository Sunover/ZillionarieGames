package PropPacket;

public class Prop {
	private int ID;
	private String Name;
	private int Point;
	private String Display;
	
	public Prop(int ID, String Name, int Point, String Display){
		this.ID = ID;
		this.Name = Name;
		this.Point = Point;
		this.Display = Display;
	}

	public int GetPoint() {
		return Point;
	}

	public int getID() {
		return ID;
	}


	
	
}
