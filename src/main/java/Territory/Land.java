package Territory;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import Map.MapBsc;
import Player.Player;

public class Land extends TerritoryBsc{

    private int basePrice;
    private int type;
    private static int id;
    
    private final static int AREA = 0;
    private final static int COTTAGE = 1;
	private final static int HOUSE = 2;
	private final static int SKYSCRAPPER = 3;
    private final static int MAXLEVEL=3;
	
	private final static int ownBySystem = -1;

	public Land(){
		super(id,'0');
	}

    public Land(int id,int basePrice, int type) {
    	super(id,'0');
        this.basePrice = basePrice;
        this.type = type;
        this.setID(id);
    }
    
    public char getDisplay(){
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

    public int getBasePrice() {
        return basePrice;
    }
    public int getType(){
        return type;
    }

    public int getSellPrice(){
        return basePrice * (type + 1) * 2;
    }

	public static String calculateFixedAssets(Hashtable<Integer, Land> landList) {
		int areaCount = 0;
		int cottageCount = 0;
		int houseCount = 0;
		int skyScrapperCount = 0;
		for(Iterator<Integer> it = landList.keySet().iterator(); it.hasNext();){
			int id = it.next();
			switch(landList.get(id).getType()){
			case AREA:
				areaCount++;
				break;
			case COTTAGE:
				cottageCount++;
				break;
			case HOUSE:
				houseCount++;
				break;
			case SKYSCRAPPER:
				skyScrapperCount++;
				break;
			}
		}
		
		return "地产：空地"+areaCount+"处；茅屋"+cottageCount+"处；洋房"+houseCount+"处；摩天楼"+skyScrapperCount+"处。";
	}

    public boolean overMaxLevel(){
        if(this.type==MAXLEVEL)
            return true;
        return false;
    }
	public void upgradeType() {
        if(overMaxLevel())
            System.out.println("此地已是最高等级，不能在升级了！");
		this.type++;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static void returnFixedAssets(Hashtable<Integer, Land> landHashTable) {
		Set<Integer> LandIDCollection = (Set<Integer>) landHashTable.keySet();
		for(int i : LandIDCollection){
			Land land = landHashTable.get(i);
			land.setOwnBy(-1);
			land.setType(0);
			land.setRoadBlock(null);
			land.setBomb(null);
		}
	}

	public int getId() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}

	public int passByFee(){
		return this.basePrice / 2 * (this.type + 1);
	}
	
	@Override
	public void enterTerritory(Player player,MapBsc Map) {
		if(ownBy == ownBySystem)
		{
			while(!player.getUserInput().getValidatedInput()){
				System.out.println("是否购买该处空地，"+this.basePrice+"元（Y/N）？");
				player.getUserInput().ynValidated();
			}
			player.buyArea(this, Map);
		}
		else if(ownBy == player.getId()){
			while(!player.getUserInput().getValidatedInput()){
				System.out.println("是否升级该处地产，"+this.basePrice+"元（Y/N）？");
				player.getUserInput().ynValidated();
			}
			player.updateArea(this, Map);
		}
		else
			player.stepIntoOtherTerritory(this);
	}

}
