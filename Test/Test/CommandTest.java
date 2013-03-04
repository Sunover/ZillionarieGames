package Test;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;


import ControlPacket.Command;
import ControlPacket.CommandFactory;
import MapPacket.FirstMap;
import PlayerPacket.Player;
import PropPacket.Prop;
import TerritoryPacket.Land;
import TerritoryPacket.TerritoryBsc;



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
		Command RollCommand = CommandFactory.MakeCommand("roll", -100, Qianfuren,firstMap);
		RollCommand.ActCommand(Qianfuren,firstMap);
		boolean flag = Qianfuren.GetPosition() >= 0 && Qianfuren.GetPosition() <= 69;
		//Then
		assertTrue(flag);
	}
	@Test
	public void player_setup_block_and_effect_others(){
		//Given
		//When
		Qianfuren.AddPoint(50);
		Qianfuren.GetUserInput().SetInput("3");
		Qianfuren.BuyProp();
		
		Command BlockCommand = CommandFactory.MakeCommand("block", 3, Qianfuren,firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.GetMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.GetRoadBlock().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(1));
		
		Player Atubo = new Player(2);
		Atubo.SetPosition(3);
		BlockCommand.ActCommand(Atubo,firstMap);
		Prop RoadBlock = territory.GetRoadBlock();
		//Then
		assertNull(RoadBlock);
	} 
	@Test
	public void return_player_assets_when_query_comman_activate(){
		Command QueryCommand = CommandFactory.MakeCommand("query", null, Qianfuren, firstMap);
		QueryCommand.ActCommand(Qianfuren, firstMap);
	}

	@Test
	public void player_setup_bomb_and_effect_others(){
		//Given
		//When
		Qianfuren.AddPoint(50);
		Qianfuren.GetUserInput().SetInput("3");
		Qianfuren.BuyProp();
		
		Command BombCommand = CommandFactory.MakeCommand("bomb", 3, Qianfuren,firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.GetMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.GetBomb().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(1));
		
		Player Atubo = new Player(2);
		Atubo.SetPosition(3);
		BombCommand.ActCommand(Atubo,firstMap);
		Prop RoadBlock = territory.GetBomb();
		//Then
		assertNull(RoadBlock);
		assertThat(Atubo.GetPosition(),is(14));
	} 
	
	@Test
	public void player_setup_Robot_and_effect(){
		//Given
		//When
		Qianfuren.AddPoint(50);
		Qianfuren.GetUserInput().SetInput("3");
		Qianfuren.BuyProp();
		
		CommandFactory.MakeCommand("block", 3, Qianfuren,firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.GetMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.GetRoadBlock().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(1));
		
		Player Atubo = new Player(2);
		Command RobotCommand = CommandFactory.MakeCommand("robot", null, Atubo, firstMap);
		RobotCommand.ActCommand(Atubo, firstMap);
		Prop RoadBlock = territory.GetRoadBlock();
		//Then
		assertNull(RoadBlock);
	}
	@Test
	public void return_extra_money_when_sell_area(){
		//Given
		Land land = new Land(1,200,0);
		Qianfuren.GetUserInput().SetInput("Y");
		Qianfuren.SetMoney(200);
		Qianfuren.BuyArea(land, firstMap);
		
		//when
		Command SellCommand = CommandFactory.MakeCommand("sell", 1, Qianfuren, firstMap);
		
		SellCommand.ActCommand(Qianfuren, firstMap);
		String FixedAssets = Qianfuren.GetFixedAssets();
		int Money = Qianfuren.GetMoney();
		//Then
		assertThat(FixedAssets,is("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。"));
		assertThat(Money,is(400));
	}
	
	@Test
	public void return_extra_money_when_sell_prop(){
		//Given
		Qianfuren.SetPoint(50);
		Qianfuren.GetUserInput().SetInput("1");
		Qianfuren.BuyProp();
		//when
		Command SellPropCommand = CommandFactory.MakeCommand("selltool", 1, Qianfuren, firstMap);
		SellPropCommand.ActCommand(Qianfuren, firstMap);
		String FixedAssets = Qianfuren.GetProp();
		int Point = Qianfuren.GetPoint();
		//Then
		assertThat(FixedAssets,is("道具：路障0个；炸弹0个；机器娃娃0个。"));
		assertThat(Point,is(50));
	}
}
