/*
 Version : 2.4
 파일명 : Armor.java
 작성일자 : 2019-09-21
 설명 : 방어구
 */
package Item;

public class Armor extends Item{
	private final int aDef;//무기 방어력 설정후 바뀌지 않음
	
	public Armor(int aDef, String iName){// 방어구 생성시 방어력과 이름을 받음
		super(iName);
		this.aDef = aDef;
	}

	public int getaDef() {
		return aDef;
	}
	

}
