package Control;

import Map.MapBsc;
import Player.Player;

public abstract class Command {
	public abstract void actCommand(Player player ,MapBsc map);
}
