import TerritoryPacket.MineralEstate;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class TestMineralEstate {
    @Test
    public void Test_minaeralestate_has_20_points(){
       MineralEstate minerlEstateObj=new MineralEstate(20);
       assertThat(20,is(minerlEstateObj.GetTheGivenPoints()));
    }

}
