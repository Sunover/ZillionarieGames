package TerritoryPacket;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import MapPacket.MapBsc;
import PlayerPacket.Player;

public class Land extends TerritoryBsc{

    private int basePrice;
    private int type;
    private static int ID;
    
    private final static int AREA = 0;
    private final static int COTTAGE = 1;
	private final static int HOUSE = 2;
	private final static int SKYSCRAPPER = 3;
	
	private final static int OwnBySystem = -1;

	public Land(){
		super(ID,'0');
	}
	
    public Land(int id,int basePrice, int type) {
    	super(id,'0');
        this.basePrice = basePrice;
        this.type = type;
        this.SetID(id);
    }
    
    public char GetDisplay(){
    	switch (this.type){
    	case AREA:
    		return '0';
    	case COTTAGE:
    		return '1';
    	case HOUSE:
    		return '2';
    	case SKYSCRAPPER:
    		return '3';
    	default:
    		return ' ';
    	}
    }

    public int GetBasePrice() {
        return basePrice;
    }
    public int GetType(){
        return type;
    }

    public int GetSellPrice(){
        return basePrice * (type + 1) * 2;
    }

	public static String CalculateFixedAssets(Hashtable<Integer,Land> landList) {
		int AreaCount = 0;
		int CottageCount = 0;
		int HouseCount = 0;
		int SkyScrapperCount = 0;
		for(Iterator<Integer> it = landList.keySet().iterator(); it.hasNext();){
			int id = it.next();
			switch(landList.get(id).GetType()){
			case AREA:
				AreaCount++;
				break;
			case COTTAGE:
				CottageCount++;
				break;
			case HOUSE:
				HouseCount++;
				break;
			case SKYSCRAPPER:
				SkyScrapperCount++;
				break;
			}
		}
		
		return "地产：空地"+AreaCount+"处；茅屋"+CottageCount+"处；洋房"+HouseCount+"处；摩天楼"+SkyScrapperCount+"处。";
	}

	public void UpgradeType() {
		this.type++;
	}

	public void SetType(int type) {
		this.type = type;
	}

	public static void ReturnFixedAssets(Hashtable<Integer,Land> LandHashTable) {
		Set<Integer> LandIDCollection = (Set<Integer>) LandHashTable.keySet();
		for(int i : LandIDCollection){
			Land land = LandHashTable.get(i);
			land.SetOwnBy(-1);
			land.SetType(0);
			land.SetRoadBlock(null);
			land.SetBomb(null);
		}
	}

	public int GetID() {
		return ID;
	}

	public void SetID(int iD) {
		ID = iD;
	}

	public int PassByFee(){
		return this.basePrice / 2 * (this.type + 1);
	}
	
	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		if(OwnBy == OwnBySystem)
		{
			while(!player.GetUserInput().GetValidatedInput()){
				System.out.println("是否购买该处空地，"+this.basePrice+"元（Y/N）？");
				player.GetUserInput().YNValidated();
			}
			player.BuyArea(this,Map);
		}
		else if(OwnBy == player.GetID()){
			while(!player.GetUserInput().GetValidatedInput()){
				System.out.println("是否升级该处地产，"+this.basePrice+"元（Y/N）？");
				player.GetUserInput().YNValidated();
			}
			player.UpdateArea(this,Map);
		}
		else
			player.StepIntoOtherTerritory(this);
	}

}
