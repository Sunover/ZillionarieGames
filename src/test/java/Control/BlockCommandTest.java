package Control;

import Map.FirstMap;
import Player.Player;
import Prop.Prop;
import Territory.TerritoryBsc;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-20
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
public class BlockCommandTest extends TestCase {

    Player player1=new Player(1);
    Player player2=new Player(2);
    FirstMap map=new FirstMap();
    BlockCommand blockcommand=new BlockCommand(9,player1,map);
    @Before
    @Test
    public void test_put_block_successful(){
       //Given
        BlockCommand blockcommand=new BlockCommand(10,player1,map);
        //When
        TerritoryBsc territory = map.getMapPointList().get(10);
        Prop roadBlock = territory.getRoadBlock();
        //Then
        assertNotNull(roadBlock);

    }
     @Test
    public void  test_display_when_block_on_terrtory(){
        //Given
        TerritoryBsc territory = map.getMapPointList().get(9);
        //When
        //Then
        assertThat('#',is(territory.getDisplayNow()));
    }
    @Test
    public void test_owner_of_block_is_player_himself_stop_day_is_0(){
        // Given
        player1.setPosition(9);
        //When
        blockcommand.actCommand(player1,map);
        //Then
        assertThat(0,is(player1.getStopTimes())) ;
    }

    @Test
    public void test_player_stop_1_day_after_actCommand(){
       // Given
       player2.setPosition(9);
      //When
       blockcommand.actCommand(player2,map);
       //Then
       assertThat(1,is(player2.getStopTimes())) ;
    }

    @Test
    public  void  test_terrory_has_block_0_after_actCommand(){
        // Given
        player2.setPosition(9);
        //When
        blockcommand.actCommand(player2,map);
        //Then
        assertNull(map.getMapPointList().get(9).getRoadBlock());
    }

    @Test
    public void test_terrory_get_display_is_0_after_actCommand(){
        // Given
        player2.setPosition(9);
        TerritoryBsc territory = map.getMapPointList().get(9);
        //When
        blockcommand.actCommand(player2,map);
        //Then
        assertThat('0', is(territory.getDisplayNow()));
    }
}
