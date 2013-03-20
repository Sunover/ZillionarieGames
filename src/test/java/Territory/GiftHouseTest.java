package Territory;

import Player.Player;
import Territory.GiftHouse;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import sun.font.TrueTypeFont;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-18
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */

public class GiftHouseTest extends TestCase {

    Player player=new Player(1);
    GiftHouse giftHouse=new GiftHouse(1);
    @Before
    @Test
    public void test_the_choice_is_money(){
       //Given
       //When
        player.setMoney(0);
        giftHouse.excuteTheChoice(1,player);
       //Then
        assertThat(2000,is(player.getMoney())) ;
    }

    @Test
   public void test_the_choice_is_point(){
        //Given
        //When
         player.setPoint(0);
        giftHouse.excuteTheChoice(2, player);
        //Then
        assertThat(200,is(player.getPoint()));
    }

    @Test
    public void test_the_choice_is_billiken(){
        //Given
        player.setBilliken(false);
        //When
        giftHouse.excuteTheChoice(3,player);
        //Then
        assertTrue(player.getBilliken());
    }
}
