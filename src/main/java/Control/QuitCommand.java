package main.java.Control;

import main.java.Map.MapBsc;
import main.java.Player.Player;

public class QuitCommand extends Command{

	public QuitCommand(){}
	
	@Override
	public void actCommand(Player player, MapBsc Map) {
		System.exit(-1);
	}
}
