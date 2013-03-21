package Player;

import Control.SellCommand;
import Control.SellToolCommand;
import Map.FirstMap;
import Prop.Prop;
import Territory.Land;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Hashtable;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-20
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTest extends TestCase {
    @Test
    public void test_buy_land_succssful(){
       //Given
        FirstMap map=new FirstMap();
        Land land=(Land)map.getMapPointList().get(3);
        Player player1=new Player(1);
        player1.setMoney(1000);
        player1.getUserInput().setInput("Y");
        //When
        player1.buyArea(land,map);
        //Then
       assertThat(player1.getId(),is(land.getOwnBy()));
    }
    @Test
    public void test_function_calculateFixedAssets(){
        //Given
        FirstMap map=new FirstMap();
        Land land=(Land)map.getMapPointList().get(3);
        Player player1=new Player(1);
         player1.setMoney(1000);
        //When
        player1.getUserInput().setInput("Y");
        player1.buyArea(land,map);
        String strFixAssert= player1.getFixedAssets();
        //Then
        assertThat("地产：空地1处；茅屋0处；洋房0处；摩天楼0处。",is(strFixAssert));
    }

    @Test
    public void test_update_Area_when_money_is_sufficient(){
       //Given
        FirstMap map=new FirstMap();
        Land land=(Land)map.getMapPointList().get(3);
        Player player1=new Player(1);
        player1.setMoney(1000);
        player1.getUserInput().setInput("Y");
        player1.buyArea(land,map);
        //When
        player1.updateArea(land,map);
        //Then
        assertThat(1,is(land.getType()));
    }

    @Test
    public void test_update_Area_when_money_is_not_sufficient(){
        //Given
        FirstMap map=new FirstMap();
        Land land=(Land)map.getMapPointList().get(3);
        Player player1=new Player(1);
        player1.setMoney(200);
        player1.getUserInput().setInput("Y");
        player1.buyArea(land,map);

        int a=player1.getMoney();
        //When
        player1.updateArea(land,map);
        //Then
        assertThat(0,is(land.getType()));
    }

    @Test
    public void test_sell_area(){
            //Given
            Player player1=new Player(1);
            player1.setMoney(10000);
            FirstMap map=new FirstMap();
            Land land=(Land)map.getMapPointList().get(3);
            player1.getUserInput().setInput("Y");
            player1.buyArea(land,map);
            //When
            assertEquals(1,land.getOwnBy());
            player1.sellArea(land,map);
            //Then
            assertThat(-1,is(land.getOwnBy()));
    }

    @Test
    public void test_buy_prop(){
        //Given
        FirstMap map=new FirstMap();
        Player player1=new Player(1);
        player1.setPoint(1000);
        //When
        player1.choiceToBuy(1);
        String FixedAssets=player1.getProp();
        //Then
        assertThat(FixedAssets,is("道具：路障1个；炸弹0个；机器娃娃0个。"));
    }

    @Test
    public void test_sell_prop(){
        //Given
        FirstMap map=new FirstMap();
        Player player1=new Player(1);
        player1.setPoint(1000);
        player1.choiceToBuy(1);
        Prop roadBlock = new Prop(1);
         String FixedAssets=player1.getProp();
        assertThat(FixedAssets,is("道具：路障1个；炸弹0个；机器娃娃0个。"));
        //When
        player1.sellProp(roadBlock);
        FixedAssets=player1.getProp();
        //Then
        assertThat(FixedAssets,is("道具：路障0个；炸弹0个；机器娃娃0个。"));
    }


    @Test
    public void test_use_prop(){
        //Given
        FirstMap map=new FirstMap();
        Player player1=new Player(1);
        player1.setPoint(1000);
        //When
        player1.choiceToBuy(1);
        player1.useProp(new Prop(1));
        String FixedAssets=player1.getProp();
        //Then
        assertThat(FixedAssets,is("道具：路障0个；炸弹0个；机器娃娃0个。"));

    }

}
