package ControlPacket;

import PlayerPacket.Player;

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
      String [] RoleArray= new String[]{"钱夫人","阿土伯","孙小美","金贝贝"};
      private int RoleAccount=4;
      private int CurrentChoicePlayerNum=1;
      private ArrayList<Integer> GamePlayerList=new ArrayList<Integer>();
      HashMap<Integer,Player> PlayMap=new HashMap<Integer, Player>();

    public InitialInterface(){
         System.out.print(strPrologue);
    }
    public void ReciveTheInput(){
        int ChoiceToolNum=0;
        while (true) {
            try{
                BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
                ChoiceToolNum=Integer.parseInt(is.readLine());
            }catch (IOException e) {
                e.printStackTrace();
            }
           if(ChoiceTheRole(ChoiceToolNum)) break;;
        }
    }

    public boolean ChoiceTheRole(int RoleNum){
        if(RoleNum==115){
            StartGame();
            return false;
        }
        if(IsChoiceRight(RoleNum)){
            GamePlayerList.add(RoleNum);
            PlayMap.put(new Integer(CurrentChoicePlayerNum),new Player( RoleNum));
            CurrentChoicePlayerNum++;
        }
        if(CurrentChoicePlayerNum>5)
        {
            StartGame();
            return  false;
        }
        String strOut="请选择玩家"+Integer.toString(CurrentChoicePlayerNum)+"的角色:";
        System.out.print(strOut);
        return true;
    }

    public boolean IsChoiceRight(int RoleNum){
          if (RoleNum>RoleAccount||RoleNum<0){
              System.out.print("警告：没有此角色！请输入正确的角色编号!"+strReturn);
                 return false;
          }

          for(Integer  tmp:GamePlayerList){
              if(tmp.intValue()==RoleNum)
               System.out.print("警告：不能重复选择角色！"+strReturn);
              return false;
        }
        return true;
    }

    public void StartGame(){
        ///start Game
        System.out.print("游戏开始了！");

    }
}
