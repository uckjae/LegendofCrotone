/*
 Version : 2.4
 파일명 : Weapon.java
 작성일자 : 2019-09-21
 설명 : 무기
 */
package Item;

public class Weapon extends Item {
	private final int wAtt;//무기 공격력
	
	public Weapon(int wAtt, String iName){//무기생성시 공격력과 이름을 받음
		super(iName);
		this.wAtt = wAtt;
	}
	
	public int getwAtt() {
		return wAtt;
	}
}
