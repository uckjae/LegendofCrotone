
public class Armor extends Item{
	public final int aDef;//무기 방어력 설정후 바뀌지 않음
	
	Armor(int aDef, String iName){// 방어구 생성시 방어력과 이름을 받음
		super(iName);
		this.aDef = aDef;
	}

}
