package PropPacket;

import java.util.ArrayList;
import java.util.Hashtable;

public class Prop {
	private int ID;
	private static String Name;
	private int Point;
	private String Display;
	private int SetupBy = -1;
	
	public final static int ROADBLOCK = 1;
	public final static int ROBOTICDOLL = 2;
	public final static int BOMB = 3;
	
	public Prop(int ID){
		this.ID = ID;
		SetName();
		SetPoint();
		SetDisplay();
	}
	
	public static void InitializePlayerProps(Hashtable<Integer,Integer> PropHashTable){
		PropHashTable.put(ROADBLOCK, 0);
		PropHashTable.put(ROBOTICDOLL, 0);
		PropHashTable.put(BOMB, 0);
	}

	public int GetPoint() {
		return Point;
	}

	public int getID() {
		return ID;
	}

	public int getSetupBy() {
		return SetupBy;
	}

	public void SetSetupBy(int setupBy) {
		SetupBy = setupBy;
	}

	public String GetName() {
		return Name;
	}

	public void SetName() {
		switch(ID){
		case ROADBLOCK:
			Name = "路障";
			break;
		case ROBOTICDOLL:
			Name = "机器娃娃";
			break;
		case BOMB:
			Name = "炸弹";
			break;
		}
	}

	public String GetDisplay() {
		return Display;
	}

	public void SetDisplay() {
		switch(ID){
		case ROADBLOCK:
			this.Display = "#";
			break;
		case ROBOTICDOLL:
			this.Display = "";
			break;
		case BOMB:
			this.Display = "@";
			break;
		}
	}
	
	public void SetPoint(){
		switch(ID){
		case ROADBLOCK:
			this.Point = 50;
			break;
		case ROBOTICDOLL:
			this.Point = 30;
			break;
		case BOMB:
			this.Point = 50;
			break;
		}
	}
	
	public static String CalculateProps(Hashtable<Integer,Integer> PropList){
		int RoadBlockCount = 0;
		int BombCount = 0;
		int RoboticDollCount = 0;
		
		try{
			RoadBlockCount = PropList.get(ROADBLOCK);
			BombCount = PropList.get(BOMB);
			RoboticDollCount = PropList.get(ROBOTICDOLL);
		}
		catch(Exception e){}
		
		return "道具：路障"+RoadBlockCount+"个；"+
        "炸弹"+BombCount+"个；"+
        "机器娃娃"+RoboticDollCount+"个。";
	}
	
	public static ArrayList<Prop> ReturnAllKindsProps(){
		ArrayList<Prop> result = new ArrayList<Prop>();
		result.add(new Prop(ROADBLOCK));
		result.add(new Prop(BOMB));
		result.add(new Prop(ROBOTICDOLL));
		return result;
	}

}
