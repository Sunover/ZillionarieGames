package Territory;


import Map.MapBsc;
import Player.Player;

public class GiftHouse extends TerritoryBsc {
    public Player currentPlayer;
    private static final int MONEYAWARD = 1;
    private static final int POINTAWARD = 2;
    private static final int BILLIKENAWARD = 3;

    public GiftHouse(int id){
        super(id,'G');
    }
    
	@Override
	public void enterTerritory(Player player,MapBsc map) {
		System.out.println("欢迎光临礼品屋，请选择一件您 喜欢的礼品：");
		System.out.println("1 奖金");
		System.out.println("2 点数卡");
		System.out.println("3 福神");
		player.getUserInput().toolsHouseInputValidated();
		if(player.getUserInput().getValidatedInput())
		{
			  excuteTheChoice(Integer.parseInt(player.getUserInput().getInput()),player);
		}
    }
        public void excuteTheChoice(Integer inChoiceIndex,Player player){

            switch(inChoiceIndex){
            case MONEYAWARD:
                player.gainMoney();
                break;
            case POINTAWARD:
                player.gainPoint();
                break;
            case BILLIKENAWARD:
                player.gainBilliken();
                break;
        }
    }




}
