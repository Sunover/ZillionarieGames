package Test;

import main.java.Control.InitialInterface;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-27
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class InitialInterfaceTest extends TestCase {
   public void Choice_one_player_to_start_and_return_false(){
       InitialInterface IniteObj=new InitialInterface();
       IniteObj.reciveTheInput();
   }
}
