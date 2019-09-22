/*
 Version : 2.4
 파일명 : HpPotion.java
 작성일자 : 2019-09-21
 설명 : HP포션
 */
package Item;

public class HpPotion extends Item{
	private final int hpRecover; // Hp 회복량
	
	public HpPotion(){
		super("맥주");
		this.hpRecover = 20;
	}

	public int getHpRecover() {
		return hpRecover;
	}
	
}
