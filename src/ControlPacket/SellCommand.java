package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import TerritoryPacket.Land;

public class SellCommand extends Command{

	private int HouseID;
	
	public SellCommand(int HouseID){
		this.HouseID = HouseID;
	}
	
	@Override
	public void ActCommand(Player player, MapBsc Map) {
		Land Territory = (Land) Map.GetMapPointList().get(HouseID);
		player.SellArea(Territory,Map);
	}

}
