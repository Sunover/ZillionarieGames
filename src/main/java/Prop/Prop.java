package Prop;

import java.util.ArrayList;
import java.util.Hashtable;

public class Prop {
	private int id;
	private static String name;
	private int point;
	private String display;
	private int setupBy = -1;
	
	public final static int ROADBLOCK = 1;
	public final static int ROBOTICDOLL = 2;
	public final static int BOMB = 3;
	
	public Prop(int Id){
		this.id = Id;
		setName();
		setPoint();
		setDisplay();
	}
	
	public static void initializePlayerProps(Hashtable<Integer, Integer> propHashTable){
		propHashTable.put(ROADBLOCK, 0);
		propHashTable.put(ROBOTICDOLL, 0);
		propHashTable.put(BOMB, 0);
	}

	public int getPoint() {
		return point;
	}

	public int getId() {
		return id;
	}

	public int getSetupBy() {
		return setupBy;
	}

	public void setupBy(int setupBy) {
		this.setupBy = setupBy;
	}

	public String getName() {
		return name;
	}

	public void setName() {
		switch(id){
		case ROADBLOCK:
			name = "路障";
			break;
		case ROBOTICDOLL:
			name = "机器娃娃";
			break;
		case BOMB:
			name = "炸弹";
			break;
		}
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay() {
		switch(id){
		case ROADBLOCK:
			this.display = "#";
			break;
		case ROBOTICDOLL:
			this.display = "";
			break;
		case BOMB:
			this.display = "@";
			break;
		}
	}
	
	public void setPoint(){
		switch(id){
		case ROADBLOCK:
			this.point = 50;
			break;
		case ROBOTICDOLL:
			this.point = 30;
			break;
		case BOMB:
			this.point = 50;
			break;
		}
	}
	
	public static String calculateProps(Hashtable<Integer, Integer> propList){
		int roadBlockCount = 0;
		int bombCount = 0;
		int roboticDollCount = 0;
		
		try{
			roadBlockCount = propList.get(ROADBLOCK);
			bombCount = propList.get(BOMB);
			roboticDollCount = propList.get(ROBOTICDOLL);
		}
		catch(Exception e){}
		
		return "道具：路障"+roadBlockCount+"个；"+
        "炸弹"+bombCount+"个；"+
        "机器娃娃"+roboticDollCount+"个。";
	}
	
	public static ArrayList<Prop> returnAllKindsProps(){
		ArrayList<Prop> result = new ArrayList<Prop>();
		result.add(new Prop(ROADBLOCK));
		result.add(new Prop(BOMB));
		result.add(new Prop(ROBOTICDOLL));
		return result;
	}

}
