import MapPacket.FirstMap;
import TerritoryPacket.Hospital;
import org.junit.Test;
import sun.font.TrueTypeFont;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */
public class TestHosptal {
    @Test
    public void Test_XiaoLi_In_Hospital(){
        HashMap<String ,Integer> stopMemberMap=new HashMap<String, Integer>();
        Hospital hospital=new Hospital(3,stopMemberMap);
        String name1="Xiaoli";
        hospital.EnterHospital(name1);
        boolean is=stopMemberMap.containsKey(name1);
        assertThat(true,is(stopMemberMap.containsKey(name1)));
    }


}
