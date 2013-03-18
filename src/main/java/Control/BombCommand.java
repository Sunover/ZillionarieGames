package main.java.Control;

import main.java.Map.MapBsc;
import main.java.Player.Player;
import main.java.Prop.Prop;
import main.java.Territory.TerritoryBsc;

public class BombCommand extends Command {

	public BombCommand(int step, Player player, MapBsc map){
		Prop bomb = new Prop(3);
		bomb.setupBy(player.getId());
		player.useProp(bomb);
		TerritoryBsc territory = map.getMapPointList().get(
				(player.getPosition()+ step) % map.getMapPointList().size());
		territory.setBomb(bomb);
		territory.setDisplayNow(TerritoryBsc.BOMB);
		//设置地图上的点显示bomb
	}
	
	@Override
	public void actCommand(Player player,MapBsc map) {
		TerritoryBsc territory = map.getMapPointList().get(player.getPosition());
		Prop bomb = territory.getBomb();
		if(bomb != null && player.getId() != bomb.getSetupBy()){
			player.setStopTimes(3);//设置用户停留次数  可以在用户送去医院后设置
			player.setPosition(14);//用户被放到医院这个点上
			territory.setBomb(null);
			territory.setDisplayNow(map.getMapPointDisplayList().get(territory.getId()));
		}
	}

}
