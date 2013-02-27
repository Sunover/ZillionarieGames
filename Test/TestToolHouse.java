import PlayerPacket.Player;
import TerritoryPacket.ToolsHouse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 下午8:02
 * To change this template use File | Settings | File Templates.
 */
public class TestToolHouse {
    @Test
    public void Test_buy_one_roadblock(){
        ToolsHouse toolsHouse=new ToolsHouse();
        Player player=new Player(1,"XiaoLi");
        toolsHouse.EnterToolHouse(player);
        assertThat(1,is(player.RoadBlockCount));
    }

    public void Test_buy_one_RoboticDoll(){
        ToolsHouse toolsHouse=new ToolsHouse();
        Player player=new Player(1,"XiaoLi");
        toolsHouse.EnterToolHouse(player);
        assertThat(1,is(player.RoadBlockCount));
    }


}
