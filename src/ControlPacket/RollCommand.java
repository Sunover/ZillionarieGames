package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import TerritoryPacket.TerritoryBsc;

public class RollCommand extends Command {
	public RollCommand(){}
	@Override
	public void ActCommand(Player player,MapBsc map) {
		if(player.GetStopTimes() == 0){
			int RollPoint = (int)(Math.random()*6 + 1);
			int position = (player.GetPosition()+RollPoint) % map.GetMapPointList().size();
			player.SetPosition(position);
			TerritoryBsc Territory = map.GetMapPointList().get(position);
			
			Territory.SetDisplayNow(player.GetDisplay());
			System.out.println();
			System.out.println(map.GetMapPointList().get(position).GetDisplayNow());
			System.out.println();
		}else{
			int StopTime = player.GetStopTimes();
			player.SetStopTimes(StopTime - 1);
		}
	}

}
