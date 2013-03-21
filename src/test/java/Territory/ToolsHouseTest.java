package Territory;

import Map.FirstMap;
import Player.Player;
import junit.framework.TestCase;
import org.junit.Test;
import other.PrintInConsoleWithColor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
 /* @Test
  public void test_when_the_point_of_player_less_than_the_min_point_of_tool() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Player player=new Player(1);
        player.setPoint(10);
        FirstMap map=new FirstMap();
        map.init();
        ToolsHouse toolHouse=new ToolsHouse(10);
   //     toolHouse.enterTerritory(player,map);
       Class c=toolHouse.getClass();
       Class[] cargs = new Class[2];
        Integer intParam1=new Integer(1);
        Integer intParam2=new Integer(10);
        cargs[0]=intParam1.getClass();
        cargs[1]=intParam2.getClass();
        Method m=toolHouse.getClass().getDeclaredMethod("isAffordtheprice", cargs);
        Object[] inArgs = new Object[2];
        inArgs[0] = intParam1; //变量参数一
        inArgs[1] = intParam2; //变量参数二
        System.out.println("():"+m.invoke(toolHouse,inArgs));
        assertFalse(false);
    }    */

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


