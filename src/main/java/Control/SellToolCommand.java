package main.java.Control;

import main.java.Map.MapBsc;
import main.java.Player.Player;
import main.java.Prop.Prop;

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
