package MapPacket;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 下午5:15
 * To change this template use File | Settings | File Templates.
 */
public class FirstMap extends MapBsc {

    private HashMap<String ,Integer> stopMemberMap=new HashMap<String, Integer>();

    public  boolean   IsInstopMemberMap(String name){
        if(stopMemberMap.containsKey(name))
            return true;
        return false;
    }

    private void PutTheNewValueInstopMemberMap(String name,Integer days){
        stopMemberMap.put(name,days);
    }

    private void RemoveNameINMap(String name){
        stopMemberMap.remove(name);
    }

    private void DealWithStopMember(String name){
        Integer days= stopMemberMap.get(name);
        days=days-1;
        if(days.equals(new Integer(0))) RemoveNameINMap(name);
        else PutTheNewValueInstopMemberMap(name,days);
    }
    public boolean IsRun(String name) {
        if(!IsInstopMemberMap(name)) return true;
        DealWithStopMember(name);
        return  false;
    }
}
