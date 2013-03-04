package TerritoryPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public class Start extends TerritoryBsc{

	public Start(){
		super(0,'S');
	}

	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		
	}

}
