package Test;

import MapPacket.FirstMap;
import PlayerPacket.Player;
import TerritoryPacket.ToolsHouse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestToolHouse {
	private FirstMap Map = new FirstMap();
    @Test
    public void Test_buy_one_roadblock(){
        ToolsHouse toolsHouse=new ToolsHouse(28);
        Player player=new Player(1);
        player.SetPoint(50);
        player.GetUserInput().SetInput("1");
        toolsHouse.EnterTerritory(player, Map);
        String str = player.GetProp();
        assertThat(str,is(equalTo("道具：路障1个；炸弹0个；机器娃娃0个。")));
    }

   
}
