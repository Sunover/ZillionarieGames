package Control;

import Map.FirstMap;
import Player.Player;
import Territory.Land;
import Territory.TerritoryBsc;
import junit.framework.TestCase;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-20
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
public class SellCommandTest extends TestCase {
    @Test
    public void  test_sell_the_land(){
        //Given
        Player player1=new Player(1);
        player1.setMoney(10000);
        FirstMap map=new FirstMap();
        Land land=(Land)map.getMapPointList().get(3);
        player1.getUserInput().setInput("Y");
        player1.buyArea(land,map);
        //Then
        assertEquals(player1.getId(),land.getOwnBy());
        SellCommand sellCommand=new SellCommand(3);
        //When
        sellCommand.actCommand(player1,map);
        //Then
        assertThat(-1, is(land.getOwnBy()));
    }

}
