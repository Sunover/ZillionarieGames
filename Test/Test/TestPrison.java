package Test;

import main.java.Map.FirstMap;
import main.java.Player.Player;
import main.java.Territory.Prison;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestPrison {
    @Test
    public void Test_XiaoLi_In_Hospital(){
        Prison prison=new Prison(49);
        Player Q = new Player(1);
        prison.EnterTerritory(Q, new FirstMap());
        int flag = Q.getStopTimes();
        assertThat(flag,is(2));
    }
}
