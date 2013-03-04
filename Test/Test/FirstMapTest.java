package Test;

import MapPacket.FirstMap;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-28
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public class FirstMapTest  {
     @Test
    public void test() throws Exception {
      //Given
       //When
        FirstMap mapfirst=new FirstMap();
        mapfirst.DrawMap();

       //Then
         //assertThat(70,is(mapfirst.intMapPointCount));
    }
}
