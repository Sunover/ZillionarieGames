package Control;

import Map.MapBsc;
import Player.Player;
import Territory.Land;

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
