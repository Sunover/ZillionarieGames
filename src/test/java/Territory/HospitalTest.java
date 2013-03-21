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
public class HospitalTest extends TestCase {
    @Test
    public void test_enter_into_hospital_to_stop_3_days() throws Exception {
        //Given
        Player player=new Player(1);
        FirstMap map=new FirstMap() ;
        Hospital hospital=new Hospital(17);
        //When
        hospital.enterTerritory(player,map);
        //Then
        assertThat(3,is(player.getStopTimes()));

    }
}