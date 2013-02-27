package TerritoryPacket;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class MineralEstate extends TerritoryBsc {
    private  int PointsValue=0;
    public  MineralEstate(int  points){
             PointsValue=points;
    }
    public int GetTheGivenPoints (){
        return PointsValue;
    }
}
