package Control;

import Map.MapBsc;
import Player.Player;
import Prop.Prop;
import Territory.TerritoryBsc;

public class RobotCommand extends Command {

	public RobotCommand(Player player){
		Prop RoboticDoll  = new Prop(2);
		RoboticDoll.setupBy(player.getId());
		player.useProp(RoboticDoll);
	}
	
	@Override
	public void actCommand(Player player, MapBsc map) {
		for(int i = 0; i <= 10; i++ ){
			int position = (player.getPosition() + i) % map.getMapPointList().size();
			//清除地图上10步内的路障、炸弹
			TerritoryBsc territory = map.getMapPointList().get(position);
			territory.setBomb(null);
			territory.setRoadBlock(null);
			territory.setDisplayNow(map.getMapPointDisplayList().get(territory.getId()));
		}
	}

}
