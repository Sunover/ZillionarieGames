package main.java.Territory;

import main.java.Map.MapBsc;
import main.java.Player.Player;
import main.java.Player.UserInput;
import main.java.Prop.Prop;

import java.util.ArrayList;
import java.util.List;

public class ToolsHouse extends TerritoryBsc  {

    private List<Prop> propList = new ArrayList<Prop>();

    public ToolsHouse(int id){
        super(id,'T');
        this.propList = Prop.returnAllKindsProps();
    }
    private int minPoint(){
        int Min = propList.get(0).getPoint();
        for(int i = 0; i < propList.size(); i++){
        	if(Min > propList.get(i).getPoint())
        		Min = propList.get(i).getPoint();
        }
        return Min;
    }

	@Override
	public void enterTerritory(Player player,MapBsc map) {
		if(player.getPoint() < minPoint()){
			Prop p = new Prop(Integer.parseInt(player.getUserInput().getInput()));
			System.out.println("您当前剩余的点数为"+player.getPoint()+"， 不足以购买"+
							p.getName()+"道具。");
		}
		while(!player.getUserInput().getValidatedInput()
				&& player.getUserInput().getInput() != UserInput.EXIT
				&& player.getPoint() >= minPoint()){
			System.out.println("欢迎光临道具屋， 请选择您所需要的道具：");
			System.out.println("1 路障");
			System.out.println("2 机器娃娃");
			System.out.println("3 炸弹");
			player.getUserInput().toolsHouseInputValidated();
			player.buyProp();
		}
		
		
	}
}
