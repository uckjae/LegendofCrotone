/*
 Version : 2.4
 파일명 : MpPotion.java
 작성일자 : 2019-09-21
 설명 : MP 포션
 */
package Item;

public class MpPotion extends Item {
	private final int mpRecover; // Mp 회복량
	
	public MpPotion(){ //포션 생성시 회복량과 이름을 받음
		super("레드불");
		this.mpRecover = 20;
	}

	public int getMpRecover() {
		return mpRecover;
	}
	
}
