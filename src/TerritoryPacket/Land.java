package TerritoryPacket;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
public class Land extends TerritoryBsc{

    private int id;
    private int basePrice;//base Price
    private int ownBy;
    private int type;

    public Land(int id, int basePrice, int type) {
        this.id = id;
        this.basePrice = basePrice;
        this.type = type;
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

    public void setOwnBy(int ownBy) {
        ownBy = ownBy;
    }

}
