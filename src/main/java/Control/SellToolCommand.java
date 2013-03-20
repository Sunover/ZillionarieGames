package Control;

import Map.MapBsc;
import Player.Player;
import Prop.Prop;

public class SellToolCommand extends Command {

	private Prop prop;
	
	public SellToolCommand(int id){
		prop = new Prop(id);
	}
	@Override
	public void actCommand(Player player,MapBsc map) {
		player.sellProp(prop);
	}

}
