package main.java.Territory;

import main.java.Map.MapBsc;
import main.java.Player.Player;

public class Prison extends TerritoryBsc {

    private static final int INPRISION = 2;

	public Prison(int ID){
    	super(ID,'P');
    }

	@Override
	public void enterTerritory(Player player,MapBsc Map) {
		player.setStopTimes(INPRISION);
	}







}
