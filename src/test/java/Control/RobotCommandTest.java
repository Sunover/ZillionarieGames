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
 * Time: 上午11:56
 * To change this template use File | Settings | File Templates.
 */
public class RobotCommandTest extends TestCase {

    Player player1=new Player(1);
    Player player2=new Player(2);
    FirstMap map=new FirstMap();
    BlockCommand roadblock=new BlockCommand(10,player1,map);
    BombCommand bomb=new BombCommand(12,player1,map);
    RobotCommand robotcommand=new RobotCommand(player1);
    @Before
    @Test
    public void test_put_block_successful_to_clear_roadblock_in_10(){
        //Given
        player2.setPosition(7);
        //When
         robotcommand.actCommand(player2,map);
        for(int i = 0; i <= 10; i++ ){
            int position = (player2.getPosition() + i) % map.getMapPointList().size();
            //清除地图上10步内的路障、炸弹
            TerritoryBsc territory = map.getMapPointList().get(position);
        //Then
            assertNull(territory.getRoadBlock());
        }
    }

    @Test
    public void  test_put_block_successful_to_clear_bomb_in_10(){
        //Given
        player2.setPosition(7);
        //When
        robotcommand.actCommand(player2,map);
        for(int i = 0; i <= 10; i++ ){
            int position = (player2.getPosition() + i) % map.getMapPointList().size();
            //清除地图上10步内的路障、炸弹
            TerritoryBsc territory = map.getMapPointList().get(position);
            //Then
            assertNull(territory.getBomb());
        }
    }

    @Test
    public void test_terrory_get_display_is_0_after_actCommand_at_position_10(){
        // Given
        player2.setPosition(9);
        TerritoryBsc territory = map.getMapPointList().get(10);
        //When
        robotcommand.actCommand(player2,map);
        //Then
        assertThat('0', is(territory.getDisplayNow()));
    }
}
