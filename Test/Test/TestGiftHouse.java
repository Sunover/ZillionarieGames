package Test;

import TerritoryPacket.GiftHouse;
import MapPacket.FirstMap;
import PlayerPacket.Player;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestGiftHouse {
	private FirstMap Map;
	@Before
	public void SetUp(){
		Map = new FirstMap();
	}
   @Test
    public void Test_enter_gifthouse_and_buy_reward(){
        GiftHouse gitHouse=new GiftHouse(35);
        Player player=new Player(1);
        gitHouse.EnterTerritory(player, Map);
        assertThat(player.GetMoney(),is(4000));
    }

    @Test
    public void Test_enter_gifthouse_and_get_PointCard(){
        GiftHouse gitHouse=new GiftHouse(35);
        Player player=new Player(1);
        gitHouse.EnterTerritory(player,Map);
        assertThat(player.GetMoney(),is(200));
    }


    @Test
    public void Test_enter_gifthouse_and_get_Billiken(){
        GiftHouse gitHouse=new GiftHouse(35);
        Player player=new Player(1);
        gitHouse.EnterTerritory(player,Map);
        assertThat(player.GetMoney(),is(1));
    }


}
