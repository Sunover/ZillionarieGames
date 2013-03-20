package Territory;

import Map.FirstMap;
import Map.MapBsc;
import Player.Player;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-18
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public class HospitalTest extends TestCase {
    @Test
    public void get_stop_time(){
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
