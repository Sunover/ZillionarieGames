package main.java.Control;

import main.java.Map.MapBsc;
import main.java.Player.Player;

public abstract class Command {
	public abstract void actCommand(Player player ,MapBsc map);
}
