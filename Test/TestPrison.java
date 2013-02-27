import TerritoryPacket.Prison;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
public class TestPrison {
    @Test
    public void Test_XiaoLi_In_Hospital(){
        HashMap<String ,Integer> stopMemberMap=new HashMap<String, Integer>();
        Prison prison=new Prison(2,stopMemberMap);
        String name1="Xiaoli";
        prison.EnterPrison(name1);
        boolean is=stopMemberMap.containsKey(name1);
        assertThat(true,is(stopMemberMap.containsKey(name1)));
    }
}
