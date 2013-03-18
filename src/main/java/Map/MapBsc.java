package main.java.Map;

import java.util.ArrayList;

import main.java.Territory.TerritoryBsc;

public abstract class MapBsc {
	private ArrayList<TerritoryBsc> mapPointList =new ArrayList<TerritoryBsc>();

	public ArrayList<TerritoryBsc> getMapPointList() {
		return mapPointList;
	}

	public void setMapPointList(ArrayList<TerritoryBsc> mapPointList) {
		this.mapPointList = mapPointList;
	}
	
	public abstract ArrayList<Character> getMapPointDisplayList();
}
