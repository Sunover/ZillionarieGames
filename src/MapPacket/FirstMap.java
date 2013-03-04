package MapPacket;

import java.util.ArrayList;

import TerritoryPacket.GiftHouse;
import TerritoryPacket.Hospital;
import TerritoryPacket.Land;
import TerritoryPacket.MagicHouse;
import TerritoryPacket.MineralEstate;
import TerritoryPacket.Prison;
import TerritoryPacket.Start;
import TerritoryPacket.TerritoryBsc;
import TerritoryPacket.ToolsHouse;
import other.PrintInConsoleWithColor;

public class FirstMap extends MapBsc {

	private ArrayList<TerritoryBsc> MapPointList=new ArrayList<TerritoryBsc>();
	private ArrayList<Character> MapPointDisplayList = new ArrayList<Character>();
	//Record the original one
	private ArrayList<Character> MapPointDisplayListNow = new ArrayList<Character>();
	//根据玩家行走情况记录最新的地图显示状况
		   
	public ArrayList<Character> GetMapPointDisplayList(){
		return MapPointDisplayList;
	}

	public FirstMap(){
		Init();
	}
		    
	public ArrayList<TerritoryBsc> GetMapPointList(){
		return this.MapPointList;
	}
		    
	public void Init(){
		Start start = new Start();
		MapPointList.add(start); //空地
		
		MapPointDisplayList.add(start.GetDisplayNow());
	    
	    MapPointDisplayListNow.add(start.GetDisplayNow());
		
		for(int i=1;i<=13;i++)   {
		    MapPointList.add(new Land(i,200,0));
		    MapPointDisplayList.add(TerritoryBsc.AREA);
		    
		    MapPointDisplayListNow.add(TerritoryBsc.AREA);
		    
		}  //第一地段
		       //MapPointList.add(new Hospital(3,stopMemberMap)) ; //医院
		MapPointList.add(new Hospital(14)) ;
		MapPointDisplayList.add(TerritoryBsc.HOSPITAL);
		MapPointDisplayListNow.add(TerritoryBsc.HOSPITAL);
		       
		for(int i=15;i<=27;i++){
			MapPointList.add(new Land(i,200,0)); //第二地段
			MapPointDisplayList.add(TerritoryBsc.AREA);
			MapPointDisplayListNow.add(TerritoryBsc.AREA);
		}
		MapPointList.add(new ToolsHouse(28));   //道具屋
		MapPointDisplayList.add(TerritoryBsc.PROP);
		MapPointDisplayListNow.add(TerritoryBsc.PROP);
		        
		for(int i=29;i<=34;i++)  
		{
			MapPointList.add(new Land(i,500,0));
		    MapPointDisplayList.add(TerritoryBsc.AREA);
		    MapPointDisplayListNow.add(TerritoryBsc.AREA);
		}//第三地段
		MapPointList.add(new GiftHouse(35));   //礼品屋
		MapPointDisplayList.add(TerritoryBsc.GIFT);
		MapPointDisplayListNow.add(TerritoryBsc.GIFT);
		        
		for(int i=36;i<=48;i++){
		     MapPointList.add(new Land(i,300,0));//第四地段
		     MapPointDisplayList.add(TerritoryBsc.AREA);
		     MapPointDisplayListNow.add(TerritoryBsc.AREA);
		}
		        
		MapPointList.add(new Prison(49));    //监狱
		MapPointDisplayList.add(TerritoryBsc.PRITISION);
		MapPointDisplayListNow.add(TerritoryBsc.PRITISION);
		        
		for(int i=50;i<=62;i++) {
		     MapPointList.add(new Land(i,300,0));//第五地段
		     MapPointDisplayList.add(TerritoryBsc.AREA);
		     MapPointDisplayListNow.add(TerritoryBsc.AREA);
		}
		MapPointList.add(new MagicHouse(63));    //魔法屋
		MapPointDisplayList.add(TerritoryBsc.MAGGIC);
		MapPointDisplayListNow.add(TerritoryBsc.MAGGIC);

		//矿地
		MapPointList.add(new MineralEstate(69,60));    //矿地
		MapPointDisplayList.add(TerritoryBsc.MINE);
		MapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		MapPointList.add(new MineralEstate(68,80));    //矿地
		MapPointDisplayList.add(TerritoryBsc.MINE);
		MapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		MapPointList.add(new MineralEstate(67,40));    //矿地
		MapPointDisplayList.add(TerritoryBsc.MINE);
		MapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		MapPointList.add(new MineralEstate(66,100));    //矿地
		MapPointDisplayList.add(TerritoryBsc.MINE);
		MapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		MapPointList.add(new MineralEstate(65,80));    //矿地
		MapPointDisplayList.add(TerritoryBsc.MINE);
		MapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		MapPointList.add(new MineralEstate(64,20));    //矿地
		MapPointDisplayList.add(TerritoryBsc.MINE);
		MapPointDisplayListNow.add(TerritoryBsc.MINE);
		
	}
	private char[][] positions = new char[8][29];//存放每个位置的字符
	private char[] PrintPositions = new char[8 * 29];//将2维变成1维
	private int[][] positionsInt = new int[8][29];//存放每个位置的 土地编号

	public void SetPositions(){
		for(int i = 0; i < 29; i++){
		    positions[0][i] = MapPointDisplayListNow.get(i).charValue();
		    positionsInt[0][i] = i;
		}
		for(int i = 1; i <= 7; i++){
		    positions[i][0] = MapPointDisplayListNow.get(70-i).charValue();
		    positionsInt[i][0] = 70 - i;
		    positions[i][28] = MapPointDisplayListNow.get(28+i).charValue();
		    positionsInt[i][28] = 28 + i;
		}
		for(int i = 1; i <= 6; i++){
		    for(int j = 1; j <= 27; j++)
		    	{positions[i][j] = ' ';positionsInt[i][j] = -1;}
		}
		for(int j = 1; j <= 27; j++){
			positions[7][j] = MapPointDisplayListNow.get(63-j).charValue();
		}
		
	}
		    
	public void SetupPrintPositions(){
		int k = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 29; j++){
		    	if(j == 29)
		    		PrintPositions[k] = ' ';
		    	else
		    		PrintPositions[k] = positions[i][j];
		    	k++;
		    }
		}
	}
	
	private void SetMapPointDisplayListNow(){
		for(int i = 0; i < MapPointDisplayListNow.size(); i++){
			MapPointDisplayListNow.set(i, MapPointList.get(i).GetDisplayNow());
		}
	}
		    
	private void DoDraw() {
		for(int i = 0; i < 8 * 29; i++){
			if(i != 0 && i % 29 == 0)
				System.out.println();
          PrintInConsoleWithColor.CLibrary.Instance.printfc((MapPointList.get(i).GetOwnBy()+1),String.valueOf(PrintPositions[i]));

		}
		System.out.println();
	}
	public void DrawMap(){
		SetMapPointDisplayListNow();
		SetPositions();
		SetupPrintPositions();
		DoDraw();
	}
}
