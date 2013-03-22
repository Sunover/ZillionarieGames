package Territory;

import Map.FirstMap;
import Player.Player;
import junit.framework.TestCase;
import org.junit.Test;
import other.PrintInConsoleWithColor;


import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-19
 * Time: 下午1:47
 * To change this template use File | Settings | File Templates.
 */
public class ToolsHouseTest  {
    @Test
    public void Test_buy_one_roadblock(){
        ToolsHouse toolsHouse=new ToolsHouse(28);
        Player player=new Player(1);
        player.setPoint(50);
        player.getUserInput().setInput("1");
       // toolsHouse.enterTerritory(player, Map);
        player.buyProp();
        String str = player.getProp();
        assertThat(str,is(equalTo("道具：路障1个；炸弹0个；机器娃娃0个。")));
    }

}


