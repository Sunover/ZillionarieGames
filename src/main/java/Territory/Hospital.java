package main.java.Territory;

import main.java.Map.MapBsc;
import main.java.Player.Player;

public class Hospital extends TerritoryBsc {

    public Hospital(int id){
        super(id,'H');
    }

    @Override
    public void enterTerritory(Player player,MapBsc map) {
		player.setStopTimes(3);
	}
}
