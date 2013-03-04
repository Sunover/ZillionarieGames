package MapPacket;

public class MapFactory {
	public static MapBsc MakeMap(int TypeId){
		switch(TypeId){
		case 1:
			return new FirstMap();
			default:
				break;
		}
		return null;
	}
}
