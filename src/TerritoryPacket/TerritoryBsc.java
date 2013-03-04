package  TerritoryPacket;

import MapPacket.MapBsc;
import PlayerPacket.Player;
import PropPacket.Prop;

public abstract class TerritoryBsc {
    protected int id;
    private char Display;

    private Prop RoadBlock;
    private Prop Bomb;
    public int OwnBy=-1;

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

    public TerritoryBsc(){}

    public char GetDisplayNow(){
    	return this.Display;
    }

    public void SetOwnBy(int ownBy) {
        this.OwnBy = ownBy;
    }

    public int GetOwnBy(){
        return this.OwnBy;
    }

    public void SetDisplayNow(char Display){
    	this.Display = Display;
    }

    public TerritoryBsc(int ID, char display){
    	this.id = ID;
    	this.Display = display;
    }

    public int GetID(){
    	return this.id;
    }

	public Prop GetRoadBlock() {
		return RoadBlock;
	}
	public void SetRoadBlock(Prop roadBlock) {
		RoadBlock = roadBlock;
	}
	public Prop GetBomb() {
		return Bomb;
	}
	public void SetBomb(Prop bomb) {
		Bomb = bomb;
	}
    public abstract void EnterTerritory(Player player,MapBsc Map);

   public TerritoryBsc WelComeMessage(Player player){
       int ID = player.GetPosition();
        switch(this.Display){
            case START:
            case HOSPITAL:
                return new Hospital(ID);
            case PROP:
                return new ToolsHouse(ID);
            case GIFT:
               return new GiftHouse(ID);
            case MAGGIC:
                return new MagicHouse(ID);
            case PRITISION:
                return new Prison(ID);
            case MINE:
                return new MineralEstate(ID);
            default:
                return new Land();
        }
    }

}
