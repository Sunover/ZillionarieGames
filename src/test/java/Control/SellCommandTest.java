package Control;

import Map.FirstMap;
import Player.Player;
import Territory.Land;
import Territory.TerritoryBsc;
import junit.framework.TestCase;
import org.junit.Test;

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
        Land land=new Land(3,1000,1);
        FirstMap map=new FirstMap();
        player1.buyArea(land,map);
        SellCommand sellCommand=new SellCommand(3);
        //When
        sellCommand.actCommand(player1,map);
        //Then
        assertEquals(player1,land.getOwnBy());
    }
}
