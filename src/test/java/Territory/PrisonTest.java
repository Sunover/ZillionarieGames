package Territory;

import Map.FirstMap;
import Player.Player;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-19
 * Time: 下午1:38
 * To change this template use File | Settings | File Templates.
 */
public class PrisonTest extends TestCase {
    @Test
    public void test_enter_into_prison_to_stop_2_days() throws Exception {
        //Given
        Player player=new Player(1);
        FirstMap map=new FirstMap() ;
        Prison prison=new Prison(17);
        //When
        prison.enterTerritory(player,map);
        //Then
        assertThat(2,is(player.getStopTimes()));

    }
}
