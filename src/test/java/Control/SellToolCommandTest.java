package Control;

import Map.FirstMap;
import Player.Player;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-20
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class SellToolCommandTest extends TestCase {
    @Test
    public void test_sell_tool_prop(){
        //Given
        FirstMap map=new FirstMap();
        SellToolCommand sellToolCommand=new SellToolCommand(1);
        Player player1=new Player(1);
        player1.setPoint(1000);
        player1.choiceToBuy(1);
        //When
         sellToolCommand.actCommand(player1,map);
        //Then
        assertThat(1000,is(player1.getPoint()));
    }
}
