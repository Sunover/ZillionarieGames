package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import PropPacket.Prop;
import TerritoryPacket.TerritoryBsc;

public class RobotCommand extends Command {

	public RobotCommand(Player player){
		Prop RoboticDoll  = new Prop(2);
		RoboticDoll.SetSetupBy(player.GetID());
		player.UseProp(RoboticDoll);
	}
	
	@Override
	public void ActCommand(Player player, MapBsc Map) {
		for(int i = 0; i <= 10; i++ ){
			int position = (player.GetPosition() + i) % Map.GetMapPointList().size();
			//清除地图上10步内的路障、炸弹
			TerritoryBsc Territory = Map.GetMapPointList().get(position);
			Territory.SetBomb(null);
			Territory.SetRoadBlock(null);
			Territory.SetDisplayNow(Map.GetMapPointDisplayList().get(Territory.GetID()));
		}
	}

}
