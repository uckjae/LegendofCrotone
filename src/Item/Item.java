/*
 Version : 2.4
 파일명 : Item.java
 작성일자 : 2019-09-21
 설명 : 아이템
 */
package Item;

import java.io.Serializable;

public class Item implements Serializable {
	protected final String iName; // 아이템의 이름	
	
	public Item(String iName) { //아이템 생성 시 아이템의 이름을 받음.
		this.iName = iName;
	}

	public String getiName() {
		return iName;
	}
	
}
