package ControlPacket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import MapPacket.FirstMap;
import PlayerPacket.Player;
import TerritoryPacket.Land;
import TerritoryPacket.TerritoryBsc;

public class Controller {

	private static List<Player> PlayerList = new ArrayList<Player>();
	private static BufferedReader ReadInput;
	private static boolean InputFlag = false;
	private final static int MoneyOriginalMin = 1000;
	private final static int MoneyOriginalMax = 50000;
	private static boolean IsGameEnd = false;
	
	public static void SetupGame(String moneyOriginalStr){
		try{
			int MoneyOriginal = Integer.parseInt(moneyOriginalStr);
			if(MoneyOriginal >= MoneyOriginalMin && MoneyOriginal <= MoneyOriginalMax)
				Player.setMoneyOriginal(MoneyOriginal);
			InputFlag = true;
		}
		catch(Exception e){
			System.out.println("输入错误格式");
			InputFlag = false;
		}
	}
	public static void WhetherEndGame(){
		if(PlayerList.size() == 1){
			System.out.println(PlayerList.get(0).GetName()+"获胜");
			IsGameEnd = true;
			System.exit(-1);
		}else{
			for(int i = 0; i < PlayerList.size(); i++){
				Player temp = PlayerList.get(i);
				if(temp.GetMoney() < 0){
					Land.ReturnFixedAssets(temp.GetLandList());
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("欢迎来到大富翁游戏");
		ReadInput = new BufferedReader(new InputStreamReader(System.in));
		while(!InputFlag){
			System.out.println("设置玩家初始资金，范围1000～50000（默认10000）");
			SetupGame(ReadInput.readLine().trim());
		}
		InputFlag = false;
		while(!InputFlag){
			System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
			ChoosePlayer(ReadInput.readLine().trim());
		}
		InputFlag = false;
		
		while(!IsGameEnd){
			FirstMap Map = new FirstMap();
			Map.DrawMap();
			for(int i = 0; i < PlayerList.size(); i++){
				Player player = PlayerList.get(i);
				PlayerPositionCheck(player,Map);
				PlayerGo(player,Map);
				Map.DrawMap();
			}
			WhetherEndGame();
		}
		
	}
	private static void PlayerGo(Player player, FirstMap map) throws IOException {
		System.out.print(player.GetName()+">");
		String[] input = ReadInput.readLine().trim().split(" ");
		InputFlag = false;
		Command command;
		while(!InputFlag){
			if(input.length == 2)
				command = CommandFactory.MakeCommand(input[0], Integer.parseInt(input[1]), player, map);
			else
				command = CommandFactory.MakeCommand(input[0], null, player, map);
			
			command.ActCommand(player, map);
			map.DrawMap();
			
			if(input[0].toLowerCase().equals("roll"))
				InputFlag = true;
		}
		
	}
	private static void PlayerPositionCheck(Player player, FirstMap Map) {
		TerritoryBsc Territory = Map.GetMapPointList().get(player.GetPosition());
		Territory.EnterTerritory(player,Map);
	}
	private static void ChoosePlayer(String Players) {
		char[] PlayerCharList = Players.toCharArray();
		List<Integer> PlayerID = new ArrayList<Integer>();
		for(char p : PlayerCharList){
			try{
				PlayerID.add(Integer.parseInt(String.valueOf(p)));
			}
			catch(Exception e){
				InputFlag = false;
				return;
			}
		}
		InputFlag = true;
		for(int i = 0; i < PlayerID.size(); i++){
			PlayerList.add(new Player(PlayerID.get(i)));
		}
	}

}
