package PlayerPacket;

import PropPacket.Prop;
import TerritoryPacket.Land;

public class Player {

	private int ID;
	private String Name;
	public int Money;
	public int Point;
    public int BillikenAmount;
	private int AreaCount;
	private int CottageCount;
	private int HouseCount;
	private int SkyscraperCount;
	public int RoadBlockCount;
	public int BombCount;
	public int RoboticDollCount;

	
	public Player(int id, String name) {
		this.ID = id;
		this.Name = name;
		this.Money = 10000;
		this.Point = 0;
		this.AreaCount = 0;
		this.CottageCount = 0;
		this.HouseCount = 0;
		this.SkyscraperCount = 0;
		this.RoadBlockCount = 0;
		this.BombCount = 0;
		this.RoboticDollCount = 0;
	}

	public String GetName() {
		return this.Name;
	}

	public void SetName(String name) {
		this.Name = name;
	}

	public int GetMoney() {
		return Money;
	}

	public int GetPoint() {
		return this.Point;
	}

    public String GetFixedAssets() {
        return "地产：空地"+this.AreaCount+"处；"
                +"茅屋"+this.CottageCount+"处；"
                +"洋房"+this.HouseCount+"处；"
                +"摩天楼"+this.SkyscraperCount+"处。";
    }

    public String GetProp() {
        return "道具：路障"+this.RoadBlockCount+"个；"+
                "炸弹"+this.BombCount+"个；"+
                "机器娃娃"+this.RoboticDollCount+"个。";
    }



    public void AddPoint(int point) {
		this.Point += point;
	}

	public void BuyArea(Land land) {
		if(this.Money >= land.GetBasePrice()){
			this.Money -= land.GetBasePrice();
			this.AreaCount += 1;
			land.setOwnBy(this.ID);
		}
	}

	public void UpdateArea(Land land) {
		if(this.Money >= land.GetBasePrice() ){
			this.Money -= land.GetBasePrice();
			switch(land.GetType()){
			case 0:
				this.CottageCount += 1;
				break;
			case 1:
				this.HouseCount += 1;
				break;
			case 2:
				this.SkyscraperCount += 1;
				break;
			}
		}
	}

	private boolean CanSellHouse(int count){
		if(count >= 1 )
			return true;
		else
			return false;
	}
	
	public void SellArea(Land land) {
		
		switch(land.GetType()){
		case 1:
			if(CanSellHouse(this.CottageCount)){
				this.Money += land.GetSellPrice();
				this.CottageCount -= 1;
				land.setOwnBy(-1);
			}
			break;
		case 2:
			if(CanSellHouse(this.HouseCount)){
				this.HouseCount -= 1;
				this.Money += land.GetSellPrice();
				land.setOwnBy(-1);
			}
			break;
		case 3:
			if(CanSellHouse(this.SkyscraperCount)){
				this.SkyscraperCount -= 1;
				this.Money += land.GetSellPrice();
				land.setOwnBy(-1);
			}
			break;
		case 0:
			if(CanSellHouse(this.AreaCount)){
				this.AreaCount -= 1;
				this.Money += land.GetSellPrice();
				land.setOwnBy(-1);
			}
			break;
		}
	}

	private boolean checkPropCanBuy(){
		if(this.RoadBlockCount + this.RoboticDollCount + this.BombCount <= 9)
			return true;
		else
			return false;
	}
	
	public void BuyProp(Prop prop) {
		if(checkPropCanBuy() && this.Point >= prop.GetPoint()){
			this.Point -= prop.GetPoint();
			switch(prop.getID()){
			case 1:
				this.RoadBlockCount += 1;
				break;
			case 2:
				this.RoboticDollCount += 1;
				break;
			case 3:
				this.BombCount += 1;
				break;
			}
		}
	}

}
