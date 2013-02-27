package TerritoryPacket;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:34
 * To change this template use File | Settings | File Templates.
 */
public class Hospital extends TerritoryBsc {
    private  int intStayTotalDays;
    private HashMap<String ,Integer> map;

    public Hospital(int intStayDays,HashMap<String,Integer> stopmap){
            intStayTotalDays=intStayDays;
            map=stopmap;
    }

    public  void EnterHospital(String name){
        map.put(name,new Integer(intStayTotalDays));
    }
}
