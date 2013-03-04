package TerritoryPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class MineralEstate extends TerritoryBsc {
    private  int PointsValue=0;
    /*public  MineralEstate(int  points){
             id=7;
             Display="$";
             PointsValue=points;
    }*/
    public MineralEstate(int ID){
    	super(ID,'$');
    }
    public MineralEstate(int ID, int Point){
    	super(ID,'$');
    	this.PointsValue = Point;
    }
    public int GetTheGivenPoints (){
        return PointsValue;
    }
	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		MineralEstate Mineral = (MineralEstate) Map.GetMapPointList().get(super.id);
		int Point = Mineral.GetTheGivenPoints() + player.GetPoint();
		player.SetPoint(Point);
	}
}
