package main.java.Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import main.java.Map.FirstMap;
import main.java.Player.Player;
import main.java.Territory.Land;
import main.java.Territory.TerritoryBsc;

public class Controller {

	private static List<Player> playerList = new ArrayList<Player>();
	private static BufferedReader readInput;
	private static boolean inputFlag = false;
	private final static int moneyOriginalMin = 1000;
	private final static int moneyOriginalMax = 50000;
	private static boolean isGameEnd = false;
	
	public static void setupGame(String moneyOriginalStr){
		try{
			int moneyOriginal = Integer.parseInt(moneyOriginalStr);
			if(moneyOriginal >= moneyOriginalMin && moneyOriginal <= moneyOriginalMax)
				Player.setMoneyOriginal(moneyOriginal);
			inputFlag = true;
		}
		catch(Exception e){
			System.out.println("输入错误格式");
			inputFlag = false;
		}
	}
	public static void whetherEndGame(){
		if(playerList.size() == 1){
			System.out.println(playerList.get(0).getName()+"获胜");
			isGameEnd = true;
			System.exit(-1);
		}else{
			for(int i = 0; i < playerList.size(); i++){
				Player temp = playerList.get(i);
				if(temp.getMoney() < 0){
					Land.returnFixedAssets(temp.getLandList());
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("欢迎来到大富翁游戏");
		readInput = new BufferedReader(new InputStreamReader(System.in));
		while(!inputFlag){
			System.out.println("设置玩家初始资金，范围1000～50000（默认10000）");
			setupGame(readInput.readLine().trim());
		}
		inputFlag = false;
		while(!inputFlag){
			System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
			choosePlayer(readInput.readLine().trim());
		}
		inputFlag = false;
		
		while(!isGameEnd){
			FirstMap map = new FirstMap();
			map.drawMap();
			for(int i = 0; i < playerList.size(); i++){
				Player player = playerList.get(i);
				playerPositionCheck(player, map);
				playerGo(player, map);
				map.drawMap();
			}
			whetherEndGame();
		}
		
	}
	private static void playerGo(Player player, FirstMap map) throws IOException {
		System.out.print(player.getName()+">");
		String[] input = readInput.readLine().trim().split(" ");
		inputFlag = false;
		Command command;
		while(!inputFlag){
			if(input.length == 2)
				command = CommandFactory.makeCommand(input[0], Integer.parseInt(input[1]), player, map);
			else
				command = CommandFactory.makeCommand(input[0], null, player, map);
			
			command.actCommand(player, map);
			map.drawMap();
			
			if(input[0].toLowerCase().equals("roll"))
				inputFlag = true;
		}
		
	}
	private static void playerPositionCheck(Player player, FirstMap map) {
		TerritoryBsc territory = map.getMapPointList().get(player.getPosition());
		territory.enterTerritory(player, map);
	}
	private static void choosePlayer(String players) {
		char[] playerCharList = players.toCharArray();
		List<Integer> playerID = new ArrayList<Integer>();
		for(char p : playerCharList){
			try{
				playerID.add(Integer.parseInt(String.valueOf(p)));
			}
			catch(Exception e){
				inputFlag = false;
				return;
			}
		}
		inputFlag = true;
		for(int i = 0; i < playerID.size(); i++){
			playerList.add(new Player(playerID.get(i)));
		}
	}

}
