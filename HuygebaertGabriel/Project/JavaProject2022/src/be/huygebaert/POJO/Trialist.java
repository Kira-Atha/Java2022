package be.huygebaert.POJO;

import java.util.ArrayList;

public class Trialist extends VTT{
	private static final long serialVersionUID = -7351725857088101181L;
	static Trialist singleInstanceOfTrialist;
	
	private Trialist() {
		Category.numCount++;
		this.num=Category.numCount;
		this.singleCalendar = new Calendar(this.num,this);
	}
	
	public static Trialist getInstance() {
		if(singleInstanceOfTrialist == null) {
			singleInstanceOfTrialist= new Trialist();
		}
		return singleInstanceOfTrialist;
	}
}
