package Test;

import org.junit.Before;
import org.junit.Test;

import MapPacket.FirstMap;
import PlayerPacket.Player;
import TerritoryPacket.Land;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    Player player;
    FirstMap firstMap;
    @Before
    public void setUp(){
        player = new Player(1);
        firstMap = new FirstMap();
    }
    @Test
    public void return_Qian_When_id_is_1(){
        //Given
        //When
        String name = player.GetName();
        //Then
        assertThat(name,is(equalTo("钱夫人")));
    }
    @Test
    public void return_10000_when_player_initialize(){
        //Given
        //When
        int money = player.GetMoney();
        //Then
        assertThat(money,is(equalTo(10000)));
    }
    @Test
    public void return_0_point_when_player_initialize(){
        //Given
        //When
        int point = player.GetPoint();
        //Then
        assertThat(point,is(equalTo(0)));
    }
    @Test
    public void return_0_fixedAssets_when_player_initialize(){
        //Given
        //When
        String fixedAssets = player.GetFixedAssets();
        //Then
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void return_0_property_when_player_initialize(){
        //Given
        //When
        String property = player.GetProp();
        //Then
        assertThat(property,is(equalTo("道具：路障0个；炸弹0个；机器娃娃0个。")));
    }
    @Test
    public void add_point_when_player_come_across_mine(){
        //Given
        //When
        player.AddPoint(20);
        int point = player.GetPoint();
        //Then
        assertThat(point,is(equalTo(20)));
    }
    @Test
    public void change_property_and_money_when_player_buy_areaOne(){
        //Given
        //When
    	player.GetUserInput().SetInput("Y");
        player.BuyArea(new Land(1,200,0), firstMap);
        int money = player.GetMoney();
        String fixedAssets = player.GetFixedAssets();
        //Then
        assertThat(money,is(equalTo(9800)));
        assertThat(fixedAssets,is(equalTo("地产：空地1处；茅屋0处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void change_property_and_money_when_player_update_cottage(){
        //Given
        //When
    	player.GetUserInput().SetInput("Y");
    	player.SetMoney(1200);
    	Land land = new Land(1,200,0);
    	player.BuyArea(land, firstMap);
        player.UpdateArea(land, firstMap);
        int money = player.GetMoney();
        String fixedAssets = player.GetFixedAssets();
        //Then
        assertThat(money,is(equalTo(800)));
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋1处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void change_property_and_money_when_player_sell_house(){
        //Given
        //When
        player.SellArea(new Land(1,200,2), firstMap);
        int money = player.GetMoney();
        String fixedAssets = player.GetFixedAssets();
        //Then
        assertThat(money,is(equalTo(11200)));
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void change_prop_and_money_when_player_buy_prop(){
        //Given
        //When
    	player.GetUserInput().SetInput("1");
        player.BuyProp();
        int point = player.GetPoint();
        String prop = player.GetProp();
        //Then
        assertThat(point,is(equalTo(0)));
        assertThat(prop,is(equalTo("道具：路障0个；"+
                "炸弹0个；"+
                "机器娃娃0个。")));
    }
}
