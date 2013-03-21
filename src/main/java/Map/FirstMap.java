package Map;

import java.util.ArrayList;

import Territory.TerritoryBsc;
import Territory.GiftHouse;
import Territory.Hospital;
import Territory.Land;
import Territory.MagicHouse;
import Territory.MineralEstate;
import Territory.Prison;
import Territory.Start;
import Territory.ToolsHouse;
import other.PrintInConsoleWithColor;

public class FirstMap extends MapBsc {

	private ArrayList<TerritoryBsc> mapPointList=new ArrayList<TerritoryBsc>();
	private ArrayList<Character> mapPointDisplayList = new ArrayList<Character>();
	//Record the original one
	private ArrayList<Character> mapPointDisplayListNow = new ArrayList<Character>();

		   
	public ArrayList<Character> getMapPointDisplayList(){
		return mapPointDisplayList;
	}

	public FirstMap(){
		init();
	}
		    
	public ArrayList<TerritoryBsc> getMapPointList(){
		return this.mapPointList;
	}
		    
	public void init(){
		Start startObject = new Start();
		mapPointList.add(startObject); //
		
		mapPointDisplayList.add(startObject.getDisplayNow());
	    
	    mapPointDisplayListNow.add(startObject.getDisplayNow());
		
		for(int i=1;i<=13;i++)   {
		    mapPointList.add(new Land(i, 200, 0));
		    mapPointDisplayList.add(TerritoryBsc.AREA);
		    
		    mapPointDisplayListNow.add(TerritoryBsc.AREA);
		    
		}
		       //MapPointList.add(new Hospital(3,stopMemberMap)) ;
		mapPointList.add(new Hospital(14)) ;
		mapPointDisplayList.add(TerritoryBsc.HOSPITAL);
		mapPointDisplayListNow.add(TerritoryBsc.HOSPITAL);
		       
		for(int i=15;i<=27;i++){
			mapPointList.add(new Land(i, 200, 0));
			mapPointDisplayList.add(TerritoryBsc.AREA);
			mapPointDisplayListNow.add(TerritoryBsc.AREA);
		}
		mapPointList.add(new ToolsHouse(28));
		mapPointDisplayList.add(TerritoryBsc.PROP);
		mapPointDisplayListNow.add(TerritoryBsc.PROP);
		        
		for(int i=29;i<=34;i++)  
		{
			mapPointList.add(new Land(i, 500, 0));
		    mapPointDisplayList.add(TerritoryBsc.AREA);
		    mapPointDisplayListNow.add(TerritoryBsc.AREA);
		}//����ض�
		mapPointList.add(new GiftHouse(35));
		mapPointDisplayList.add(TerritoryBsc.GIFT);
		mapPointDisplayListNow.add(TerritoryBsc.GIFT);
		        
		for(int i=36;i<=48;i++){
		     mapPointList.add(new Land(i, 300, 0));
		     mapPointDisplayList.add(TerritoryBsc.AREA);
		     mapPointDisplayListNow.add(TerritoryBsc.AREA);
		}
		        
		mapPointList.add(new Prison(49));
		mapPointDisplayList.add(TerritoryBsc.PRITISION);
		mapPointDisplayListNow.add(TerritoryBsc.PRITISION);
		        
		for(int i=50;i<=62;i++) {
		    mapPointList.add(new Land(i, 300, 0));
		     mapPointDisplayList.add(TerritoryBsc.AREA);
		     mapPointDisplayListNow.add(TerritoryBsc.AREA);
		}
		mapPointList.add(new MagicHouse(63));
		mapPointDisplayList.add(TerritoryBsc.MAGGIC);
		mapPointDisplayListNow.add(TerritoryBsc.MAGGIC);


		mapPointList.add(new MineralEstate(69, 60));
		mapPointDisplayList.add(TerritoryBsc.MINE);
		mapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		mapPointList.add(new MineralEstate(68, 80));
		mapPointDisplayList.add(TerritoryBsc.MINE);
		mapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		mapPointList.add(new MineralEstate(67, 40));
		mapPointDisplayList.add(TerritoryBsc.MINE);
		mapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		mapPointList.add(new MineralEstate(66, 100));
		mapPointDisplayList.add(TerritoryBsc.MINE);
		mapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		mapPointList.add(new MineralEstate(65, 80));
		mapPointDisplayList.add(TerritoryBsc.MINE);
		mapPointDisplayListNow.add(TerritoryBsc.MINE);
		        
		mapPointList.add(new MineralEstate(64, 20));
		mapPointDisplayList.add(TerritoryBsc.MINE);
		mapPointDisplayListNow.add(TerritoryBsc.MINE);
		
	}
	private char[][] positions = new char[8][29];
	private char[] printPositions = new char[8 * 29];
	private int[][] positionsInt = new int[8][29];

	public void setPositions(){
		for(int i = 0; i < 29; i++){
		    positions[0][i] = mapPointDisplayListNow.get(i).charValue();
		    positionsInt[0][i] = i;
		}
		for(int i = 1; i <= 7; i++){
		    positions[i][0] = mapPointDisplayListNow.get(70-i).charValue();
		    positionsInt[i][0] = 70 - i;
		    positions[i][28] = mapPointDisplayListNow.get(28+i).charValue();
		    positionsInt[i][28] = 28 + i;
		}
		for(int i = 1; i <= 6; i++){
		    for(int j = 1; j <= 27; j++)
		    	{positions[i][j] = ' ';positionsInt[i][j] = -1;}
		}
		for(int j = 1; j <= 27; j++){
			positions[7][j] = mapPointDisplayListNow.get(63-j).charValue();
		}
		
	}
		    
	public void setupPrintPositions(){
		int k = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 29; j++){
		    	if(j == 29)
		    		printPositions[k] = ' ';
		    	else
		    		printPositions[k] = positions[i][j];
		    	k++;
		    }
		}
	}
	
	private void setMapPointDisplayListNow(){
		for(int i = 0; i < mapPointDisplayListNow.size(); i++){
			mapPointDisplayListNow.set(i, mapPointList.get(i).getDisplayNow());
		}
	}
		    
	private void doDraw() {
		for(int i = 0; i < 8 * 29; i++){
			if(i != 0 && i % 29 == 0)
				System.out.println();
            System.out.print(printPositions[i]);
        // PrintInConsoleWithColor.CLibrary.Instance.printfc((mapPointList.get(i).getOwnBy()+1),String.valueOf(printPositions[i]));
		}
		System.out.println();
	}
	public void drawMap(){
		setMapPointDisplayListNow();
		setPositions();
		setupPrintPositions();
		doDraw();
	}
}
