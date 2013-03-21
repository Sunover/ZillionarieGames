package Test;

import main.java.Player.Player;
import main.java.Territory.ToolsHouse;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-28
 * Time: 下午1:59
 * To change this template use File | Settings | File Templates.
 */
public class ToolsHouseTest extends TestCase {

    ToolsHouse toolHouse=new ToolsHouse(2);
    Player player1=new Player(1);
    @Before
    @Test
    public void enter_toolhouse_and_the_point_less(){
        //Given
        //When
      //  toolHouse.EnterTerritory(player1,toolHouse.MapPointList);
        //Then
      //  assertFalse(toolHouse.CheckThePointofPlayerIsEnough());
    }


}
