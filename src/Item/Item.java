/*
 Version : 2.4
 ���ϸ� : Item.java
 �ۼ����� : 2019-09-21
 ���� : ������
 */
package Item;

import java.io.Serializable;

public class Item implements Serializable {
	protected final String iName; // �������� �̸�	
	
	public Item(String iName) { //������ ���� �� �������� �̸��� ����.
		this.iName = iName;
	}

	public String getiName() {
		return iName;
	}
	
}
