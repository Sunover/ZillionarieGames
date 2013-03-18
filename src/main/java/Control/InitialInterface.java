package main.java.Control;

import main.java.Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created with IntelliJ IDEA.
 * User: nove
 * Date: 13-2-27
 * Time: 下午3:24
 * To change this template use File | Settings | File Templates.
 */
public class InitialInterface {
    String strReturn="\n";
    String strPrologue="欢迎来到大富翁游戏！下面让我们开始我们愉快之旅吧！"
            +strReturn+"请选择玩家："+strReturn+"1---钱夫人      2---阿土伯      3---孙小美    4---金贝贝"
            +strReturn+"(系统提示：“请选择2~4位不重复玩家，输入编号即可,输入s开始游戏！)"
            +strReturn+"玩家1：";
      String [] roleArray = new String[]{"钱夫人","阿土伯","孙小美","金贝贝"};
      private int roleAccount =4;
      private int currentChoicePlayerNum =1;
      private ArrayList<Integer> gamePlayerList =new ArrayList<Integer>();
      HashMap<Integer,Player> playMap =new HashMap<Integer, Player>();

    public InitialInterface(){
         System.out.print(strPrologue);
    }
    public void reciveTheInput(){
        int choiceToolNum=0;
        while (true) {
            try{
                BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
                choiceToolNum=Integer.parseInt(is.readLine());
            }catch (IOException e) {
                e.printStackTrace();
            }
           if(choiceTheRole(choiceToolNum)) break;;
        }
    }

    public boolean choiceTheRole(int roleNum){
        if(roleNum==115){
            startGame();
            return false;
        }
        if(isChoiceRight(roleNum)){
            gamePlayerList.add(roleNum);
            playMap.put(new Integer(currentChoicePlayerNum), new Player(roleNum));
            currentChoicePlayerNum++;
        }
        if(currentChoicePlayerNum >5)
        {
            startGame();
            return  false;
        }
        String strOut="请选择玩家"+Integer.toString(currentChoicePlayerNum)+"的角色:";
        System.out.print(strOut);
        return true;
    }

    public boolean isChoiceRight(int roleNum){
          if (roleNum> roleAccount ||roleNum<0){
              System.out.print("警告：没有此角色！请输入正确的角色编号!"+strReturn);
                 return false;
          }

          for(Integer  tmp: gamePlayerList){
              if(tmp.intValue()==roleNum)
               System.out.print("警告：不能重复选择角色！"+strReturn);
              return false;
        }
        return true;
    }

    public void startGame(){
        ///start Game
        System.out.print("游戏开始了！");

    }
}
