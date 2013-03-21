package Test;

import main.java.Territory.MineralEstate;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestMineralEstate {
    @Test
    public void Test_minaeralestate_has_20_points(){
       MineralEstate minerlEstateObj=new MineralEstate(20);
       assertThat(20,is(minerlEstateObj.getTheGivenPoints()));
    }

}
