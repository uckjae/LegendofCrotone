/*
 Version : 2.4
 ���ϸ� : HpPotion.java
 �ۼ����� : 2019-09-21
 ���� : HP����
 */
package Item;

public class HpPotion extends Item{
	private final int hpRecover; // Hp ȸ����
	
	public HpPotion(){
		super("����");
		this.hpRecover = 20;
	}

	public int getHpRecover() {
		return hpRecover;
	}
	
}
