package main.java.Territory;

import main.java.Map.MapBsc;
import main.java.Player.Player;
import main.java.Prop.Prop;

public abstract class TerritoryBsc {
    protected int id;
    private char display;

    private Prop roadBlock;
    private Prop bomb;
    public int ownBy =-1;

    public static final char START = 'S';
    public static final char HOSPITAL = 'H';
    public static final char PROP = 'T';//道具屋
    public static final char GIFT = 'G';
    public static final char MAGGIC = 'M';
    public static final char PRITISION = 'P';
    public static final char MINE = '$';
    public static final char ROADBLOCK = '#';
    public static final char ROBORITICDOLL = ' ';
    public static final char BOMB = '@';
    public static final char AREA = '0';
    public static final char COTTAGE = '1';
    public static final char HOUSE = '2';
    public static final char SKYSCRAPER = '3';

    public TerritoryBsc(){

    }

    public TerritoryBsc(int ID, char display){
        this.id = ID;
        this.display = display;
    }
    public char getDisplayNow(){
    	return this.display;
    }

    public void setOwnBy(int ownBy) {
        this.ownBy = ownBy;
    }

    public int getOwnBy(){
        return this.ownBy;
    }

    public void setDisplayNow(char display){
    	this.display = display;
    }



    public int getId(){
    	return this.id;
    }

	public Prop getRoadBlock() {
		return roadBlock;
	}
	public void setRoadBlock(Prop roadBlock) {
		this.roadBlock = roadBlock;
	}
	public Prop getBomb() {
		return bomb;
	}
	public void setBomb(Prop bomb) {
		this.bomb = bomb;
	}
    public abstract void enterTerritory(Player player,MapBsc Map);

   public TerritoryBsc welComeMessage(Player player){
       int id = player.getPosition();
        switch(this.display){
        case START:
            case HOSPITAL:
                return new Hospital(id);
            case PROP:
                return new ToolsHouse(id);
            case GIFT:
               return new GiftHouse(id);
            case MAGGIC:
                return new MagicHouse(id);
            case PRITISION:
                return new Prison(id);
            case MINE:
                return new MineralEstate(id);
            default:
                return new Land();
        }
    }

}
