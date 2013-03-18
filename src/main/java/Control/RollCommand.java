package main.java.Control;

import main.java.Map.MapBsc;
import main.java.Player.Player;
import main.java.Territory.TerritoryBsc;

public class RollCommand extends Command {
	public RollCommand(){}
	@Override
	public void actCommand(Player player,MapBsc map) {
		if(player.getStopTimes() == 0){
			int rollPoint = (int)(Math.random()*6 + 1);
			int position = (player.getPosition()+rollPoint) % map.getMapPointList().size();
			player.setPosition(position);
			TerritoryBsc territory = map.getMapPointList().get(position);
			
			territory.setDisplayNow(player.getDisplay());
			System.out.println();
			System.out.println(map.getMapPointList().get(position).getDisplayNow());
			System.out.println();
		}else{
			int stopTime = player.getStopTimes();
			player.setStopTimes(stopTime - 1);
		}
	}

}
