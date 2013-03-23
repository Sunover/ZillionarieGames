package Control;

import Map.MapBsc;
import Player.Player;
import Territory.TerritoryBsc;

public class RollCommand extends Command {
	public RollCommand(){}
	@Override
	public void actCommand(Player player,MapBsc map) {
		if(player.getStopTimes() == 0){
			int rollPoint = (int)(Math.random()*6 + 1);
            System.out.print(rollPoint);
            TerritoryBsc beforeTerritory = map.getMapPointList().get((player.getPosition()) % map.getMapPointList().size());
            beforeTerritory.resetDisplayNow();
            int position = (player.getPosition()+rollPoint) % map.getMapPointList().size();
			player.setPosition(position);
			TerritoryBsc territory = map.getMapPointList().get(position);

            //territory.setOwnBy(player.getId());
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
