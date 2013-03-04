package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import PropPacket.Prop;

public class SellToolCommand extends Command {

	private Prop prop;
	
	public SellToolCommand(int ID){
		prop = new Prop(ID);
	}
	@Override
	public void ActCommand(Player player,MapBsc Map) {
		player.SellProp(prop);
	}

}
