package Territory;

import Map.MapBsc;
import Player.Player;

public class Hospital extends TerritoryBsc {

    public Hospital(int id){
        super(id,'H');
    }

    @Override
    public void enterTerritory(Player player,MapBsc map) {
		player.setStopTimes(3);
	}
}
