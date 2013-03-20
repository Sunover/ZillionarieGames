package Control;

import Map.MapBsc;
import Player.Player;

public class QueryCommand extends Command {
	
	public QueryCommand(){
	}
	
	@Override
	public void actCommand(Player player, MapBsc map) {
		System.out.println("显示自家资产信息：");
		System.out.println("资 金："+player.getMoney()+"元 ");
		System.out.println("点 数："+player.getPoint()+"点");
		System.out.println(player.getFixedAssets());
		System.out.println(player.getProp());
	}

}
