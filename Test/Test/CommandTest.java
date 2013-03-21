package Test;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;


import main.java.Control.Command;
import main.java.Control.CommandFactory;
import main.java.Map.FirstMap;
import main.java.Player.Player;
import main.java.Prop.Prop;
import main.java.Territory.Land;
import main.java.Territory.TerritoryBsc;



public class CommandTest extends TestCase {
	private Player Qianfuren;
	private FirstMap firstMap;
	@Before
	public void Setup(){
		Qianfuren = new Player(1);
		firstMap = new FirstMap();
	}
	@Test
	public void player_begin_roll(){
		//Given
		//When
		Command RollCommand = CommandFactory.makeCommand("roll", -100, Qianfuren, firstMap);
		RollCommand.ActCommand(Qianfuren,firstMap);
		boolean flag = Qianfuren.getPosition() >= 0 && Qianfuren.getPosition() <= 69;
		//Then
		assertTrue(flag);
	}
	@Test
	public void player_setup_block_and_effect_others(){
		//Given
		//When
		Qianfuren.addPoint(50);
		Qianfuren.getUserInput().setInput("3");
		Qianfuren.buyProp();
		
		Command BlockCommand = CommandFactory.makeCommand("block", 3, Qianfuren, firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.getMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.getRoadBlock().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(1));
		
		Player Atubo = new Player(2);
		Atubo.setPosition(3);
		BlockCommand.ActCommand(Atubo,firstMap);
		Prop RoadBlock = territory.getRoadBlock();
		//Then
		assertNull(RoadBlock);
	} 
	@Test
	public void return_player_assets_when_query_comman_activate(){
		Command QueryCommand = CommandFactory.makeCommand("query", null, Qianfuren, firstMap);
		QueryCommand.ActCommand(Qianfuren, firstMap);
	}

	@Test
	public void player_setup_bomb_and_effect_others(){
		//Given
		//When
		Qianfuren.addPoint(50);
		Qianfuren.getUserInput().setInput("3");
		Qianfuren.buyProp();
		
		Command BombCommand = CommandFactory.makeCommand("bomb", 3, Qianfuren, firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.getMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.getBomb().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(1));
		
		Player Atubo = new Player(2);
		Atubo.setPosition(3);
		BombCommand.ActCommand(Atubo,firstMap);
		Prop RoadBlock = territory.getBomb();
		//Then
		assertNull(RoadBlock);
		assertThat(Atubo.getPosition(),is(14));
	} 
	
	@Test
	public void player_setup_Robot_and_effect(){
		//Given
		//When
		Qianfuren.addPoint(50);
		Qianfuren.getUserInput().setInput("3");
		Qianfuren.buyProp();
		
		CommandFactory.makeCommand("block", 3, Qianfuren, firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.getMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.getRoadBlock().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(1));
		
		Player Atubo = new Player(2);
		Command RobotCommand = CommandFactory.makeCommand("robot", null, Atubo, firstMap);
		RobotCommand.ActCommand(Atubo, firstMap);
		Prop RoadBlock = territory.getRoadBlock();
		//Then
		assertNull(RoadBlock);
	}
	@Test
	public void return_extra_money_when_sell_area(){
		//Given
		Land land = new Land(1,200,0);
		Qianfuren.getUserInput().setInput("Y");
		Qianfuren.setMoney(200);
		Qianfuren.buyArea(land, firstMap);
		
		//when
		Command SellCommand = CommandFactory.makeCommand("sell", 1, Qianfuren, firstMap);
		
		SellCommand.ActCommand(Qianfuren, firstMap);
		String FixedAssets = Qianfuren.getFixedAssets();
		int Money = Qianfuren.getMoney();
		//Then
		assertThat(FixedAssets,is("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。"));
		assertThat(Money,is(400));
	}
	
	@Test
	public void return_extra_money_when_sell_prop(){
		//Given
		Qianfuren.setPoint(50);
		Qianfuren.getUserInput().setInput("1");
		Qianfuren.buyProp();
		//when
		Command SellPropCommand = CommandFactory.makeCommand("selltool", 1, Qianfuren, firstMap);
		SellPropCommand.ActCommand(Qianfuren, firstMap);
		String FixedAssets = Qianfuren.getProp();
		int Point = Qianfuren.getPoint();
		//Then
		assertThat(FixedAssets,is("道具：路障0个；炸弹0个；机器娃娃0个。"));
		assertThat(Point,is(50));
	}
}
