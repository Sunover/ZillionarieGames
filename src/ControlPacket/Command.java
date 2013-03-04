package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public abstract class Command {
	public abstract void ActCommand(Player player ,MapBsc map);
}
