package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import PropPacket.Prop;
import TerritoryPacket.TerritoryBsc;

public class BombCommand extends Command {

	public BombCommand(int Step, Player player, MapBsc Map){
		Prop Bomb = new Prop(3);
		Bomb.SetSetupBy(player.GetID());
		player.UseProp(Bomb);
		TerritoryBsc Territory = Map.GetMapPointList().get(
				(player.GetPosition()+ Step) % Map.GetMapPointList().size());
		Territory.SetBomb(Bomb);
		Territory.SetDisplayNow(TerritoryBsc.BOMB);
		//设置地图上的点显示bomb
	}
	
	@Override
	public void ActCommand(Player player,MapBsc Map) {
		TerritoryBsc Territory = Map.GetMapPointList().get(player.GetPosition());
		Prop Bomb = Territory.GetBomb();
		if(Bomb != null && player.GetID() != Bomb.getSetupBy()){
			player.SetStopTimes(3);//设置用户停留次数  可以在用户送去医院后设置
			player.SetPosition(14);//用户被放到医院这个点上
			Territory.SetBomb(null);
			Territory.SetDisplayNow(Map.GetMapPointDisplayList().get(Territory.GetID()));
		}
	}

}
