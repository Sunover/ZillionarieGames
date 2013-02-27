import TerritoryPacket.GiftHouse;
import PlayerPacket.Player;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
public class TestGiftHouse {
   @Test
    public void Test_enter_gifthouse_and_buy_reward(){
        GiftHouse gitHouse=new GiftHouse();
        Player player=new Player(1,"XiaoLi");
        gitHouse.EnterGiftHouse(player);
        assertThat(4000,is(player.Money));
    }

    @Test
    public void Test_enter_gifthouse_and_get_PointCard(){
        GiftHouse gitHouse=new GiftHouse();
        Player player=new Player(1,"XiaoLi");
        gitHouse.EnterGiftHouse(player);
        assertThat(200,is(player.Money));
    }


    @Test
    public void Test_enter_gifthouse_and_get_Billiken(){
        GiftHouse gitHouse=new GiftHouse();
        Player player=new Player(1,"XiaoLi");
        gitHouse.EnterGiftHouse(player);
        assertThat(1,is(player.Money));
    }


}
