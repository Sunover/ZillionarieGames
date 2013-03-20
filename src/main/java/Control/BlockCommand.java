package Control;

import Map.MapBsc;
import Player.Player;
import Prop.Prop;
import Territory.TerritoryBsc;

public class BlockCommand extends Command {

	public BlockCommand(int step,Player player, MapBsc map){//player set up the block
		Prop roadBlock = new Prop(1);
		roadBlock.setupBy(player.getId());
		player.useProp(roadBlock);
		TerritoryBsc territory = map.getMapPointList().get(
				(player.getPosition()+step)% map.getMapPointList().size());
		territory.setRoadBlock(roadBlock);
		territory.setDisplayNow(TerritoryBsc.ROADBLOCK);
	}//使用Block
	
	//block生效 对其他玩家
	@Override
	public void actCommand(Player player,MapBsc map) { // player stand on the block
		TerritoryBsc territory = map.getMapPointList().get(player.getPosition());
		Prop roadBlock = territory.getRoadBlock();
		if(roadBlock != null && player.getId() != roadBlock.getSetupBy()){
			player.setStopTimes(1);
			//还需要恢复地图上那个原来存放block的点
			territory.setRoadBlock(null);
			territory.setDisplayNow(map.getMapPointDisplayList().get(territory.getId()));
		}
	}

}
