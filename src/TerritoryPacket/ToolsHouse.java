package TerritoryPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import PlayerPacket.UserInput;
import PropPacket.Prop;

import java.util.ArrayList;
import java.util.List;

public class ToolsHouse extends TerritoryBsc  {

    private List<Prop> PropList = new ArrayList<Prop>();

    public ToolsHouse(int ID){
        super(ID,'T');
        this.PropList = Prop.ReturnAllKindsProps();
    }
    private int MinPoint(){
        int Min = PropList.get(0).GetPoint();
        for(int i = 0; i < PropList.size(); i++){
        	if(Min > PropList.get(i).GetPoint())
        		Min = PropList.get(i).GetPoint();
        }
        return Min;
    }

	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		if(player.GetPoint() < MinPoint()){
			Prop p = new Prop(Integer.parseInt(player.GetUserInput().GetInput()));
			System.out.println("您当前剩余的点数为"+player.GetPoint()+"， 不足以购买"+
							p.GetName()+"道具。");
		}
		while(!player.GetUserInput().GetValidatedInput()
				&& player.GetUserInput().GetInput() != UserInput.EXIT
				&& player.GetPoint() >= MinPoint()){
			System.out.println("欢迎光临道具屋， 请选择您所需要的道具：");
			System.out.println("1 路障");
			System.out.println("2 机器娃娃");
			System.out.println("3 炸弹");
			player.GetUserInput().ToolsHouseInputValidated();
			player.BuyProp();
		}
		
		
	}
}
