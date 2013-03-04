package ControlPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public class HelpCommand extends Command {

	public HelpCommand(){}
	@Override
	public void ActCommand(Player player ,MapBsc map) {
		System.out.println("roll 掷骰子命令，行走1~6步，步数由随机算法产生。");
		System.out.println("block n 玩家拥有路障后，可将路障放置到离当前位置前后10步的距离"+
		"任一玩家经过路障，都将会被拦截。该道具一次有效。n 前后的相对距离，负数表示后方。");
		System.out.println("bomb n 可将路障放置到离当前位置前后10步的距离，任一玩家j经过"+
		"在该位置，将被炸伤，送往医院，住院三天。n 前后的相对距离，负数表示后方。");
		System.out.println("robot 使用该道具，可清扫前方路面上10步以内的其他道具，如炸弹、路障。");
		System.out.println("sell x 出售自己的房产，x地图上的绝对位置，即地产的编号。");
		System.out.println("sellTool x 出售道具， x 道具编号");
		System.out.println("query 显示自家资产信息");
		System.out.println("help 查看命令帮助");
		System.out.println("quit 强制退出");
	}

}
