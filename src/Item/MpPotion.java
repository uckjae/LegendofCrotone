/*
 Version : 2.4
 ���ϸ� : MpPotion.java
 �ۼ����� : 2019-09-21
 ���� : MP ����
 */
package Item;

public class MpPotion extends Item {
	private final int mpRecover; // Mp ȸ����
	
	public MpPotion(){ //���� ������ ȸ������ �̸��� ����
		super("�����");
		this.mpRecover = 20;
	}

	public int getMpRecover() {
		return mpRecover;
	}
	
}
