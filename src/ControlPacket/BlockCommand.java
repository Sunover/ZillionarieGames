package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import PropPacket.Prop;
import TerritoryPacket.TerritoryBsc;

public class BlockCommand extends Command {

	public BlockCommand(int Step,Player player, MapBsc map){//player set up the block
		Prop RoadBlock = new Prop(1);
		RoadBlock.SetSetupBy(player.GetID());
		player.UseProp(RoadBlock);
		TerritoryBsc territory = map.GetMapPointList().get(
				(player.GetPosition()+Step)% map.GetMapPointList().size());
		territory.SetRoadBlock(RoadBlock);
		territory.SetDisplayNow(TerritoryBsc.ROADBLOCK);
	}//使用Block
	
	//block生效 对其他玩家
	@Override
	public void ActCommand(Player player,MapBsc Map) { // player stand on the block
		TerritoryBsc territory = Map.GetMapPointList().get(player.GetPosition());
		Prop RoadBlock = territory.GetRoadBlock();
		if(RoadBlock != null && player.GetID() != RoadBlock.getSetupBy()){
			player.SetStopTimes(1);
			//还需要恢复地图上那个原来存放block的点
			territory.SetRoadBlock(null);
			territory.SetDisplayNow(Map.GetMapPointDisplayList().get(territory.GetID()));
		}
	}

}
