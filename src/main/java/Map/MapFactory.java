package main.java.Map;

public class MapFactory {
	public static MapBsc MakeMap(int typeId){
		switch(typeId){
		case 1:
			return new FirstMap();
			default:
				break;
		}
		return null;
	}
}
