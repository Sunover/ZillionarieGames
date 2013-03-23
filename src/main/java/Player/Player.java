package Player;

import java.util.Hashtable;

import Map.MapBsc;
import Prop.Prop;
import Territory.Land;

public class Player {

	private static final int MAXAMOUNTBEFOREBUYPROP = 9;
	private static int moneyOriginal = 10000;
	private int id;
	private int money;
	private int point;
	private boolean billiken;
	private int billikenUseTime;
	private int stopTimes;
	private int position;
	
	private char display;
	
	private Hashtable<Integer,Land> landHashTable;
	private Hashtable<Integer,Integer> propHashTable;
	
	private static final int Q = 1;
	private static final int A = 2;
	private static final int S = 3;
	private static final int J = 4;
	
	private UserInput userInput;

	
	public Player(int id) {
		this.id = id;
		getName();
		this.money = moneyOriginal;
		this.point = 0;
		this.setStopTimes(0);
		this.propHashTable = new Hashtable<Integer,Integer>();
		Prop.initializePlayerProps(propHashTable);
		this.landHashTable = new Hashtable<Integer,Land>();
		this.userInput = new UserInput();
		setDisplay();
	}
	
	public Hashtable<Integer,Land> getLandList(){
		return this.landHashTable;
	}

	public int getId(){
		return this.id;
	}
	
	public String getName() {
		switch(this.id){
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

	public void setName(String name) {
	}
	
	public void setMoney(int money){
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public int getPoint() {
		return this.point;
	}
	public void setPoint(int point){
		this.point = point;
	}
	
    public String getFixedAssets() {
        return Land.calculateFixedAssets(this.landHashTable);
    }

    public String getProp() {
        return Prop.calculateProps(propHashTable);
    }



    public void addPoint(int point) {
		this.point += point;
	}

	public void buyArea(Land land, MapBsc map) {
		if(this.userInput.getInput().equals(UserInput.YES) ){
			if(this.money >= land.getBasePrice()){
				this.money -= land.getBasePrice();
				land.setOwnBy(this.id);
				landHashTable.put(land.getId(), land);
			}else{
				System.out.println("您的资金不足");
			}
		}
	}
	
	public void updateArea(Land land, MapBsc map) {
		if(this.userInput.getInput().equals(UserInput.YES)){
			if(this.money >= land.getBasePrice() ){
				this.money -= land.getBasePrice();
				land.upgradeType();
				map.getMapPointList().get(land.getId()).setDisplayNow(land.getDisplay());
			}
			else{
				System.out.println("您的资金不足");
			}
		}
	}

	public void sellArea(Land land, MapBsc map) {
		try{
			this.landHashTable.remove(land.getId());
		}
		catch(Exception e){
			System.out.println("不能卖该房产");
			return;
		}
		this.money += land.getSellPrice();
		land.setOwnBy(-1);
		land.setType(0);
		map.getMapPointList().get(land.getId()).setDisplayNow(land.getDisplay());
	}

	public void sellProp(Prop prop){
		int count = propHashTable.get(prop.getId());
		if(count >= 1){
			propHashTable.remove(prop.getId());
			propHashTable.put(prop.getId(), count - 1);
			this.point += prop.getPoint();
		}
		else{
			System.out.println("不能卖该道具");
			return;
		}
	}

	private boolean checkPropCanBuy() {
		return this.propHashTable.size() <= MAXAMOUNTBEFOREBUYPROP;
	}
	
	public void buyProp() {
        choiceToBuy(Integer.parseInt(this.userInput.getInput()));
	}

    public void choiceToBuy(int index){
        Prop prop = new Prop(index);
        if(checkPropCanBuy() && this.point >= prop.getPoint()){
            this.point -= prop.getPoint();
            int count = this.propHashTable.get(prop.getId()) + 1;
            this.propHashTable.remove(prop.getId());
            this.propHashTable.put(prop.getId(), count);
            System.out.println("购买"+prop.getName()+"成功");
        }
    }
	public void useProp(Prop p){
		try{
            int count = this.propHashTable.get(p.getId()) - 1;
            this.propHashTable.remove(p.getId());
            this.propHashTable.put(p.getId(), count);
			//this.propHashTable.remove(p);
		}catch(Exception e){
			System.out.println("没有该道具，无法使用");
			return;
		}
	}
	
	public static void setMoneyOriginal(int moneyOriginal) {
		Player.moneyOriginal = moneyOriginal;
	}

	public int getStopTimes() {
		return stopTimes;
	}

	public void setStopTimes(int stopTimes) {
		this.stopTimes = stopTimes;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean getBilliken() {
		return billiken;
	}

	public void setBilliken(boolean billiken) {
		this.billiken = billiken;
		if(billiken){
			this.billikenUseTime = 5;
		}else{
			this.billikenUseTime = 0;
		}
	}

	public int getBillikenUseTime() {
		return billikenUseTime;
	}

	public void setBillikenUseTime(int billikenUseTime) {
		this.billikenUseTime = billikenUseTime;
	}
	
	public void stepIntoOtherTerritory(Land land){
		if(this.billiken)
		{
			this.billikenUseTime -= 1;
			if(this.billikenUseTime == 0)
				this.billiken = false;
		}
		else
			this.money -= land.passByFee();
	}

	public UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(UserInput userInput) {
		this.userInput = userInput;
	}

	public void gainMoney() {
		this.money += 2000;
	}
	
	public void gainPoint(){
		this.point += 200;
	}
	
	public void gainBilliken(){
		setBilliken(true);
	}

	public char getDisplay() {
		return display;
	}

	public void setDisplay() {
		switch(this.id){
		case Q:
			this.display = 'Q';
			break;
		case A:
			this.display = 'A';
			break;
		case S:
			this.display = 'S';
			break;
		case J:
			this.display = 'J';
			break;
		default:
			this.display = ' ';
			break;
		}
	}

}
