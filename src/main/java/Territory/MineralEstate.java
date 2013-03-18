package main.java.Territory;

import main.java.Map.MapBsc;
import main.java.Player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class MineralEstate extends TerritoryBsc {
    private  int pointsValue=0;
    public MineralEstate(int ID){
    	super(ID,'$');
    }
    public MineralEstate(int ID, int Point){
    	super(ID,'$');
    	this.pointsValue = Point;
    }
    public int getTheGivenPoints(){
        return pointsValue;
    }
	@Override
	public void enterTerritory(Player player,MapBsc map) {
		MineralEstate Mineral = (MineralEstate) map.getMapPointList().get(super.id);
		int point = Mineral.getTheGivenPoints() + player.getPoint();
		player.setPoint(point);
	}
}
