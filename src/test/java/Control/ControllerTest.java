package Control;

import Player.Player;
import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-20
 * Time: 下午7:58
 * To change this template use File | Settings | File Templates.
 */
public class ControllerTest extends TestCase {
 //   @Test
 /*   public void test_add_player_to_list() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        //Given
        Player player1=new Player(1);
        Controller controller=new Controller();
       // controller.choosePlayer("ddd");
        //When
        Class c=controller.getClass();
        Class[] cargs = new Class[1];
        String strParam1="12";
        Integer intParam1=new Integer(1);
        cargs[0]=strParam1.getClass();
       // cargs[1]=intParam2.getClass();
        Method m=controller.getClass().getMethod("choosePlayer",cargs);
        Object[] inArgs = new Object[1];
        inArgs[0] = strParam1; //变量参数一
        //inArgs[1] = intParam2; //变量参数二
        m.invoke(controller,inArgs);
        //Then

        Field fa=c.getDeclaredField("playerList");
        Player player=(Player)fa.get(intParam1);
        assertThat("钱夫人", is(player.getName()));
    } */



}
