package Control;

import Map.MapBsc;
import Player.Player;

public class QuitCommand extends Command{

	public QuitCommand(){}
	
	@Override
	public void actCommand(Player player, MapBsc Map) {
		System.exit(-1);
	}
}
