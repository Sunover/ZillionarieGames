package TerritoryPacket;

import PlayerPacket.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-25
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class GiftHouse extends TerritoryBsc {
    public Player Currentplayer;

    private void AddReward(){
        Currentplayer.Money+=2000;
    }

    private void AddPointCard(){
        Currentplayer.Point+=200;
    }

    private void AddBilliken(){
        Currentplayer.BillikenAmount+=1;
    }
    public void EnterGiftHouse(Player player){
        Currentplayer=player;
        String s1="\n";
        String openningString="欢迎来到礼品屋，请选择一件你喜欢的礼品。通过输入礼品的编号选择礼品："+s1+"      礼品        编号"
                +s1+"      奖金         1"+s1+"      点数卡       2"+s1+"      福神         3";
        System.out.print(openningString);
        int ChoiceGiftNum=0;
        try{
        BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
        ChoiceGiftNum=Integer.parseInt(is.readLine());
        }catch (IOException e) {
            e.printStackTrace();
        }
        switch (ChoiceGiftNum)
        {
            case 1:
                AddReward();
                break;
            case 2:
                AddPointCard();
                break;
            case 3:
                AddBilliken();
                break;
            default:
                break;
        }

    }



}
