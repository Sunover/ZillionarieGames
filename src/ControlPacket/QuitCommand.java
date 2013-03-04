package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public class QuitCommand extends Command{

	public QuitCommand(){}
	
	@Override
	public void ActCommand(Player player, MapBsc Map) {
		System.exit(-1);
	}
}
