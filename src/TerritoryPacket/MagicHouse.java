package TerritoryPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class MagicHouse extends TerritoryBsc {
    public MagicHouse(int ID){
    	super(ID,'M');
    }

	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		
	}
}
