/*
 Version : 2.4
 ���ϸ� : Weapon.java
 �ۼ����� : 2019-09-21
 ���� : ����
 */
package Item;

public class Weapon extends Item {
	private final int wAtt;//���� ���ݷ�
	
	public Weapon(int wAtt, String iName){//��������� ���ݷ°� �̸��� ����
		super(iName);
		this.wAtt = wAtt;
	}
	
	public int getwAtt() {
		return wAtt;
	}
}
