package Control;

import Map.FirstMap;
import Player.Player;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-20
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class CommandFactoryTest extends TestCase {
    @Test
    public static void test_input_Roll_command_return_RollCommand_Object(){
        //Given
        CommandFactory commandFactory=new CommandFactory();
        Player player1=new Player(1);
        FirstMap map=new FirstMap();
        //When
        //Then
        assertTrue(commandFactory.makeCommand("ROLL",null,player1,map) instanceof RollCommand );
        assertTrue(commandFactory.makeCommand("BLOCK",2,player1,map) instanceof BlockCommand );
        assertTrue(commandFactory.makeCommand("BOMB",1,player1,map) instanceof BombCommand );
        assertTrue(commandFactory.makeCommand("ROBOT",1,player1,map) instanceof RobotCommand );
        assertTrue(commandFactory.makeCommand("SELL",1,player1,map) instanceof SellCommand );
        assertTrue(commandFactory.makeCommand("SELLTOOL",1,player1,map) instanceof SellToolCommand );
        assertTrue(commandFactory.makeCommand("QUERY",1,player1,map) instanceof QueryCommand );
        assertTrue(commandFactory.makeCommand("HELP",1,player1,map) instanceof HelpCommand );
        assertTrue(commandFactory.makeCommand("QUIT",1,player1,map) instanceof QuitCommand );

    }

}
