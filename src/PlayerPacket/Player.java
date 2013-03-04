package PlayerPacket;

import java.util.Hashtable;

import MapPacket.MapBsc;
import PropPacket.Prop;
import TerritoryPacket.Land;

public class Player {

	private static final int MAXAMOUNTBEFOREBUYPROP = 9;
	private static int MoneyOriginal = 10000;
	private int ID;
	private int Money;
	private int Point;
	private boolean Billiken;
	private int BillikenUseTime;
	private int StopTimes;
	private int Position;
	
	private char Display;
	
	private Hashtable<Integer,Land> LandHashTable;
	private Hashtable<Integer,Integer> PropHashTable;
	
	private static final int Q = 1;
	private static final int A = 2;
	private static final int S = 3;
	private static final int J = 4;
	
	private UserInput userInput;

	
	public Player(int id) {
		this.ID = id;
		GetName();
		this.Money = MoneyOriginal;
		this.Point = 0;
		this.SetStopTimes(0);
		this.PropHashTable = new Hashtable<Integer,Integer>();
		Prop.InitializePlayerProps(PropHashTable);
		this.LandHashTable = new Hashtable<Integer,Land>();
		this.userInput = new UserInput();
		SetDisplay();
	}
	
	public Hashtable<Integer,Land> GetLandList(){
		return this.LandHashTable;
	}

	public int GetID(){
		return this.ID;
	}
	
	public String GetName() {
		switch(this.ID){
		case Q:
			return "钱夫人";
		case A:
			return "阿土伯";
		case S:
			return "孙小美";
		case J:
			return "金贝贝";
		default:
				return "";
		}
	}

	public void SetName(String name) {
	}
	
	public void SetMoney(int Money){
		this.Money = Money;
	}

	public int GetMoney() {
		return Money;
	}

	public int GetPoint() {
		return this.Point;
	}
	public void SetPoint(int point){
		this.Point = point;
	}
	
    public String GetFixedAssets() {
        return Land.CalculateFixedAssets(this.LandHashTable);
    }

    public String GetProp() {
        return Prop.CalculateProps(PropHashTable);
    }



    public void AddPoint(int point) {
		this.Point += point;
	}

	public void BuyArea(Land land, MapBsc Map) {
		if(this.userInput.GetInput() == UserInput.YES ){
			if(this.Money >= land.GetBasePrice()){
				this.Money -= land.GetBasePrice();
				land.SetOwnBy(this.ID);
				LandHashTable.put(land.GetID(), land);
			}else{
				System.out.println("您的资金不足");
			}
		}
	}
	
	public void UpdateArea(Land land, MapBsc Map) {
		if(this.userInput.GetInput() == UserInput.YES){
			if(this.Money >= land.GetBasePrice() ){
				this.Money -= land.GetBasePrice();
				land.UpgradeType();
				Map.GetMapPointList().get(land.GetID()).SetDisplayNow(land.GetDisplay());
			}
			else{
				System.out.println("您的资金不足");
			}
		}
	}

	public void SellArea(Land land, MapBsc Map) {
		try{
			this.LandHashTable.remove(land.GetID());
		}
		catch(Exception e){
			System.out.println("不能卖该房产");
			return;
		}
		this.Money += land.GetSellPrice();
		land.SetOwnBy(-1);
		land.SetType(0);
		Map.GetMapPointList().get(land.GetID()).SetDisplayNow(land.GetDisplay());
	}

	public void SellProp(Prop prop){
		int count = PropHashTable.get(prop.getID());
		if(count >= 1){
			PropHashTable.remove(prop.getID());
			PropHashTable.put(prop.getID(), count-1);
			this.Point += prop.GetPoint();
		}
		else{
			System.out.println("不能卖该道具");
			return;
		}
	}

	private boolean CheckPropCanBuy() {
		return this.PropHashTable.size() <= MAXAMOUNTBEFOREBUYPROP;
	}
	
	public void BuyProp() {
		Prop prop = new Prop(Integer.parseInt(this.userInput.GetInput()));
		if(CheckPropCanBuy() && this.Point >= prop.GetPoint()){
			this.Point -= prop.GetPoint();
			int count = this.PropHashTable.get(prop.getID()) + 1;
			this.PropHashTable.remove(prop.getID());
			this.PropHashTable.put(prop.getID(), count);
			System.out.println("购买"+prop.GetName()+"成功");
		}
	}
	
	public void UseProp(Prop p){
		try{
			this.PropHashTable.remove(p);
		}catch(Exception e){
			System.out.println("没有该道具，无法使用");
			return;
		}
	}
	
	public static void setMoneyOriginal(int moneyOriginal) {
		MoneyOriginal = moneyOriginal;
	}

	public int GetStopTimes() {
		return StopTimes;
	}

	public void SetStopTimes(int stopTimes) {
		StopTimes = stopTimes;
	}

	public int GetPosition() {
		return Position;
	}

	public void SetPosition(int position) {
		Position = position;
	}

	public boolean GetBilliken() {
		return Billiken;
	}

	public void SetBilliken(boolean billiken) {
		Billiken = billiken;
		if(billiken){
			this.BillikenUseTime = 5;
		}else{
			this.BillikenUseTime = 0;
		}
	}

	public int GetBillikenUseTime() {
		return BillikenUseTime;
	}

	public void SetBillikenUseTime(int billikenUseTime) {
		BillikenUseTime = billikenUseTime;
	}
	
	public void StepIntoOtherTerritory(Land land){
		if(this.Billiken)
		{
			this.BillikenUseTime -= 1;
			if(this.BillikenUseTime == 0)
				this.Billiken = false;
		}
		else
			this.Money -= land.PassByFee();
	}

	public UserInput GetUserInput() {
		return userInput;
	}

	public void SetUserInput(UserInput userInput) {
		this.userInput = userInput;
	}

	public void GainMoney() {
		this.Money += 2000;
	}
	
	public void GainPoint(){
		this.Point += 200;
	}
	
	public void GainBilliken(){
		SetBilliken(true);
	}

	public char GetDisplay() {
		return Display;
	}

	public void SetDisplay() {
		switch(this.ID){
		case Q:
			this.Display = 'Q';
			break;
		case A:
			this.Display = 'A';
			break;
		case S:
			this.Display = 'S';
			break;
		case J:
			this.Display = 'J';
			break;
		default:
			this.Display = ' ';
			break;
		}
	}

}
