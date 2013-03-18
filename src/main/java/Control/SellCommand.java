package main.java.Control;

import main.java.Map.MapBsc;
import main.java.Player.Player;
import main.java.Territory.Land;

public class SellCommand extends Command{

	private int houseID;
	
	public SellCommand(int HouseID){
		this.houseID = HouseID;
	}
	
	@Override
	public void actCommand(Player player, MapBsc map) {
		Land territory = (Land) map.getMapPointList().get(houseID);
		player.sellArea(territory, map);
	}

}
