/*
 Version : 2.4
 ���ϸ� : Armor.java
 �ۼ����� : 2019-09-21
 ���� : ��
 */
package Item;

public class Armor extends Item{
	private final int aDef;//���� ���� ������ �ٲ��� ����
	
	public Armor(int aDef, String iName){// �� ������ ���°� �̸��� ����
		super(iName);
		this.aDef = aDef;
	}

	public int getaDef() {
		return aDef;
	}
	

}
