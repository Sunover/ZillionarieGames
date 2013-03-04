package TerritoryPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public class GiftHouse extends TerritoryBsc {
    public Player CurrentPlayer;
    private static final int MONEYAWARD = 1;
    private static final int POINTAWARD = 2;
    private static final int BILLIKENAWARD = 3;

    public GiftHouse(int ID){
        super(ID,'G');
    }
    
	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		System.out.println("欢迎光临礼品屋，请选择一件您 喜欢的礼品：");
		System.out.println("1 奖金");
		System.out.println("2 点数卡");
		System.out.println("3 福神");
		player.GetUserInput().ToolsHouseInputValidated();
		if(player.GetUserInput().GetValidatedInput())
		{
			switch(Integer.parseInt(player.GetUserInput().GetInput())){
			case MONEYAWARD:
				player.GainMoney();
				break;
			case POINTAWARD:
				player.GainPoint();
				break;
			case BILLIKENAWARD:
				player.GetBilliken();
				break;
			}
		}
	}



}
