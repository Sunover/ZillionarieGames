package Test;

import org.junit.Before;
import org.junit.Test;

import main.java.Map.FirstMap;
import main.java.Player.Player;
import main.java.Territory.Land;
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
        String name = player.getName();
        //Then
        assertThat(name,is(equalTo("钱夫人")));
    }
    @Test
    public void return_10000_when_player_initialize(){
        //Given
        //When
        int money = player.getMoney();
        //Then
        assertThat(money,is(equalTo(10000)));
    }
    @Test
    public void return_0_point_when_player_initialize(){
        //Given
        //When
        int point = player.getPoint();
        //Then
        assertThat(point,is(equalTo(0)));
    }
    @Test
    public void return_0_fixedAssets_when_player_initialize(){
        //Given
        //When
        String fixedAssets = player.getFixedAssets();
        //Then
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void return_0_property_when_player_initialize(){
        //Given
        //When
        String property = player.getProp();
        //Then
        assertThat(property,is(equalTo("道具：路障0个；炸弹0个；机器娃娃0个。")));
    }
    @Test
    public void add_point_when_player_come_across_mine(){
        //Given
        //When
        player.addPoint(20);
        int point = player.getPoint();
        //Then
        assertThat(point,is(equalTo(20)));
    }
    @Test
    public void change_property_and_money_when_player_buy_areaOne(){
        //Given
        //When
    	player.getUserInput().setInput("Y");
        player.buyArea(new Land(1, 200, 0), firstMap);
        int money = player.getMoney();
        String fixedAssets = player.getFixedAssets();
        //Then
        assertThat(money,is(equalTo(9800)));
        assertThat(fixedAssets,is(equalTo("地产：空地1处；茅屋0处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void change_property_and_money_when_player_update_cottage(){
        //Given
        //When
    	player.getUserInput().setInput("Y");
    	player.setMoney(1200);
    	Land land = new Land(1,200,0);
    	player.buyArea(land, firstMap);
        player.updateArea(land, firstMap);
        int money = player.getMoney();
        String fixedAssets = player.getFixedAssets();
        //Then
        assertThat(money,is(equalTo(800)));
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋1处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void change_property_and_money_when_player_sell_house(){
        //Given
        //When
        player.sellArea(new Land(1, 200, 2), firstMap);
        int money = player.getMoney();
        String fixedAssets = player.getFixedAssets();
        //Then
        assertThat(money,is(equalTo(11200)));
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void change_prop_and_money_when_player_buy_prop(){
        //Given
        //When
    	player.getUserInput().setInput("1");
        player.buyProp();
        int point = player.getPoint();
        String prop = player.getProp();
        //Then
        assertThat(point,is(equalTo(0)));
        assertThat(prop,is(equalTo("道具：路障0个；"+
                "炸弹0个；"+
                "机器娃娃0个。")));
    }
}
