package TerritoryPacket;

import PlayerPacket.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */
public class ToolsHouse extends TerritoryBsc  {

    public Player CurrentPlayer;
    public int intRoadBlockPrice=50;
    public int intRoboticDollPrice=30;
    public int intBombPrice=50;
    public int intLowPriceofGoods=0;

    public ToolsHouse(){
        FindTheMinPriceofGoods();
    }

    private void FindTheMinPriceofGoods(){
        int Min=0;
        if(intRoadBlockPrice>intRoboticDollPrice)
            Min=intRoboticDollPrice;
        else Min=intRoadBlockPrice;
        if(Min>intBombPrice)
            intLowPriceofGoods=intBombPrice;
        else intLowPriceofGoods=Min;
    }

    public void EnterToolHouse(Player player){
        CurrentPlayer=player;
        String s1="\n";
        String openningString="欢迎来到道具屋，请选择你所需要的道具。通过输入道具的编号选择道具，每位玩家最多可以拥有10个道具"+s1+"      道具        编号      价值（点数）      显示方式"
                +s1+"      路障          1        50                 #    "+s1+"     机器娃娃       2        30       "+s1+"      炸弹          3        50                 @";
        System.out.print(openningString);
        while(CheckThePointofPlayerIsEnough())
           if(! InputWhatToBuy())break;
     }

    private boolean CheckThePointofPlayerIsEnough(){
        if(CurrentPlayer.Point>  intLowPriceofGoods)
            return false;
        else return true;
    }

    public boolean InputWhatToBuy(){
        int ChoiceToolNum=0;
        try{
            BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
            ChoiceToolNum=Integer.parseInt(is.readLine());
        }catch (IOException e) {
            e.printStackTrace();
            return  false;
        }
        switch (ChoiceToolNum)
        {
            case 1:
                Getroadblock();
                break;
            case 2:
                GetRoboticDoll();
                break;
            case 3:
                GetBomb();
                break;
            case 46:
                return  false;
            case 66:
                return false;
            default:
                break;
        }
        return  true;
    }

    private void Getroadblock(){
        if(CurrentPlayer.Point<50)
            System.out.print("您当前剩余的点数为"+Integer.toString(CurrentPlayer.Point)+" 不足以购买路障道具");
        CurrentPlayer.Point-=intRoadBlockPrice;
        CurrentPlayer.RoadBlockCount-=1;
    }

    private void GetRoboticDoll(){
        if(CurrentPlayer.Point<30)
            System.out.print("您当前剩余的点数为"+Integer.toString(CurrentPlayer.Point)+" 不足以购买机器娃娃道具");
        CurrentPlayer.Point-=intRoboticDollPrice;
        CurrentPlayer.RoboticDollCount-=1;
    }

    private void GetBomb(){
        if(CurrentPlayer.Point<50)
            System.out.print("您当前剩余的点数为"+Integer.toString(CurrentPlayer.Point)+" 不足以购买炸弹道具");
        CurrentPlayer.Point-=intBombPrice;
        CurrentPlayer.BombCount-=1;
    }


}
