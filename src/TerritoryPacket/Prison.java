package TerritoryPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public class Prison extends TerritoryBsc {

    private static final int INPRISION = 2;

	public Prison(int ID){
    	super(ID,'P');
    }

	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		player.SetStopTimes(INPRISION);
	}







}
