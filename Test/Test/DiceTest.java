package Test;

import main.java.Control.Dice;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-27
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class DiceTest extends TestCase {
    @Test
    public void Test_100_times_return_valu_of_the_function_Run_less_than_6(){
        //Given
        Dice diceObj=new Dice();
        int i=0;
        //When
        for (;i<100;i++){
            int ReturnValue=diceObj.Run();
            if(ReturnValue>6||ReturnValue<0)
                break;
        }
        //Then
        assertThat(100,is(i));
    }
}
