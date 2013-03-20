package Territory;

import Map.FirstMap;
import Player.Player;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-18
 * Time: 下午9:27
 * To change this template use File | Settings | File Templates.
 */
public class MineralEstateTest extends TestCase {
    FirstMap map=new FirstMap();
    Player player=new Player(1);
    @Before
    @Test
    public void test_function_Enter_Mineral_get_point() throws Exception {
        //Given
         map.init();
        //When
        int intPoint=player.getPoint();
        player.setPosition(69);
        //Then
        MineralEstate mineralEstate=(MineralEstate)map.getMapPointList().get(player.getPosition());
        mineralEstate.enterTerritory(player,map);
        assertThat(intPoint+60,is(player.getPoint()));
    }
}
