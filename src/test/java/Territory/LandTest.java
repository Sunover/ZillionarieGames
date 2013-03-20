package Territory;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-3-18
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
 */
public class LandTest extends TestCase {
   Land land=new Land(1,300,0);
   @Before
    @Test
    public void update_to_house_level(){
       //Given
       land.setType(0);
       //When
       land.upgradeType();
       land.upgradeType();
       //Then
       assertThat(2,is(land.getType()));
    }

    @Test
    public void  update_to_over_max_level(){
        //Given
        land.setType(0);
        //When
        land.upgradeType();
        land.upgradeType();
        land.upgradeType();
        land.upgradeType();
        //Then
        assertTrue(land.overMaxLevel());
    }

    @Test
    public void test_function_calculateFixedAssets(){
        //Given
        Hashtable <Integer,Land> landHashTable= new Hashtable<Integer, Land>();
        //When
        String fixedAssets =land.calculateFixedAssets(landHashTable);
        //Then
        assertThat(fixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。")));
    }

    @Test
    public  void test_returnAssets_ownby_is_none(){
        //Given
        Hashtable <Integer,Land> landHashTable= new Hashtable<Integer, Land>();
        land.setOwnBy(1);
        //When
        landHashTable.put(land.getId(),land);
        land.returnFixedAssets(landHashTable);
        //Then
        assertThat(-1,is(land.getOwnBy()));
    }

    @Test
    public  void test_returnAssets_and_type_is_0(){
        //Given
        Hashtable <Integer,Land> landHashTable= new Hashtable<Integer, Land>();
        land.setOwnBy(1);
        //When
        landHashTable.put(land.getId(),land);
        land.returnFixedAssets(landHashTable);
        //Then
        assertThat(0,is(land.getType()));
    }

    @Test
    public  void test_returnAssets_and_setBomb_is_null(){
        //Given
        Hashtable <Integer,Land> landHashTable= new Hashtable<Integer, Land>();
        land.setOwnBy(1);
        //When
        landHashTable.put(land.getId(),land);
        land.returnFixedAssets(landHashTable);
        //Then
        assertNull(is(land.getBomb()));
    }

    @Test
    public  void test_returnAssets_and_RoadBlock_is_null(){
        //Given
        Hashtable <Integer,Land> landHashTable= new Hashtable<Integer, Land>();
        land.setOwnBy(1);
        //When
        landHashTable.put(land.getId(),land);
        land.returnFixedAssets(landHashTable);
        //Then
        assertNull(is(land.getRoadBlock()));
    }

    @Test
    public void test_pass_free_of_area_is_150(){
         //Given
          land.setType(0);
        //When
         int passMoney=land.passByFee();
        //Then
        assertThat(150,is(passMoney));
    }

    @Test
    public void test_pass_free_of_cottage_is_300(){
        //Given
        land.setType(1);
        //When
        int passMoney=land.passByFee();
        //Then
        assertThat(300,is(passMoney));
    }

    @Test
    public void test_pass_free_of_house_is_450(){
        //Given
        land.setType(2);
        //When
        int passMoney=land.passByFee();
        //Then
        assertThat(450,is(passMoney));
    }

    @Test
    public void test_pass_free_of_skyscrapper_is_600(){
        //Given
        land.setType(3);
        //When
        int passMoney=land.passByFee();
        //Then
        assertThat(600,is(passMoney));
    }
}
