package Test;

import org.junit.Before;
import org.junit.Test;

import PlayerPacket.Player;
import PropPacket.Prop;
import TerritoryPacket.Land;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    Player player;
    @Before
    public void setUp(){
        player = new Player(1,"钱夫人");
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
        player.BuyArea(new Land(1,200,0));
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
        player.UpdateArea(new Land(1,200,1));
        int money = player.GetMoney();
        String fixedAssets = player.GetFixedAssets();
        //Then
        assertThat(money,is(equalTo(9800)));
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房1处；摩天楼0处。")));
    }
    @Test
    public void change_property_and_money_when_player_sell_house(){
        //Given
        //When
        player.SellArea(new Land(1,200,2));
        int money = player.GetMoney();
        String fixedAssets = player.GetFixedAssets();
        //Then
        assertThat(money,is(equalTo(10000)));
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。")));
    }
    @Test
    public void change_prop_and_money_when_player_buy_prop(){
        //Given
        //When
        player.BuyProp(new Prop(1,"路障",50,"#"));
        int point = player.GetPoint();
        String prop = player.GetProp();
        //Then
        assertThat(point,is(equalTo(0)));
        assertThat(prop,is(equalTo("道具：路障0个；"+
                "炸弹0个；"+
                "机器娃娃0个。")));
    }
}
