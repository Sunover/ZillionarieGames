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
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
public class BombCommandTest extends TestCase {
    Player player1=new Player(1);

    Player player2=new Player(2);
    FirstMap map=new FirstMap();
    @Before
    @Test
    public void  test_display_when_bomb_on_terrtory(){
        //Given
        TerritoryBsc territory = map.getMapPointList().get(9);
        //When
        BombCommand bombCommand=new BombCommand(9,player1,map);
        //Then
        assertThat('@',is(territory.getDisplayNow()));
    }
    @Test
    public void test_put_bomb_successful(){
        //Given
        TerritoryBsc territory = map.getMapPointList().get(9);
        //When
        BombCommand bombCommand=new BombCommand(9,player1,map);
        Prop bomb = territory.getBomb();
        //Then
        assertThat(3,is(bomb.getId()));
    }

    @Test
    public void test_owner_of_bomb_is_player_himself_stop_day_is_0(){
        // Given
        player1.setPosition(9);
        //When
        BombCommand bombCommand=new BombCommand(9,player1,map);
        bombCommand.actCommand(player1,map);
        //Then
        assertThat(0,is(player1.getStopTimes())) ;
    }

    @Test
    public void test_player_stop_3_day_after_actCommand(){
        // Given
        player2.setPosition(9);
        //When
        BombCommand bombCommand=new BombCommand(9,player1,map);
        bombCommand.actCommand(player2,map);
        //Then
        assertThat(3,is(player2.getStopTimes())) ;
    }

    @Test
    public void test_player_put_into_hospital_after_actmand(){
        // Given
        player2.setPosition(9);
        //When
        BombCommand bombCommand=new BombCommand(9,player1,map);
        bombCommand.actCommand(player2,map);
        //Then
        assertThat(14,is(player2.getPosition()));
    }

    @Test
    public  void  test_terrory_has_bomb_0_after_actCommand(){
        // Given
        player2.setPosition(9);
        //When
        BombCommand bombCommand=new BombCommand(9,player1,map);
        bombCommand.actCommand(player2,map);
        //Then
        assertNull(map.getMapPointList().get(9).getBomb());
    }

    @Test
    public void test_terrory_get_display_is_0_after_actCommand(){
        // Given
        player2.setPosition(9);
        TerritoryBsc territory = map.getMapPointList().get(9);
        //When
        BombCommand bombCommand=new BombCommand(9,player1,map);
        bombCommand.actCommand(player2,map);
        //Then
        assertThat('0', is(territory.getDisplayNow()));
    }
}
