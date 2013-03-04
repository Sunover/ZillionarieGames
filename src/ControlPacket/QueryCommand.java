package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public class QueryCommand extends Command {
	
	public QueryCommand(){
	}
	
	@Override
	public void ActCommand(Player player ,MapBsc map) {
		System.out.println("显示自家资产信息：");
		System.out.println("资 金："+player.GetMoney()+"元 ");
		System.out.println("点 数："+player.GetPoint()+"点");
		System.out.println(player.GetFixedAssets());
		System.out.println(player.GetProp());
	}

}
