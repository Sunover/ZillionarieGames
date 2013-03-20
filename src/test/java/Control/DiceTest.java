package Control;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;








/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-20
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
public class DiceTest extends TestCase {

    public boolean isBetween(int value){
        if(value<1||value>6)
            return false;
        return true;
    }
    @Before
    @Test
    public void test_the_return_of_function_Run_is_from_1_to_6() throws Exception {
       //Given
        Dice dice=new Dice();
        //When
        for (int i=0;i<1000;i++)
        //Then
       assertTrue(isBetween(dice.Run()));


    }
}
