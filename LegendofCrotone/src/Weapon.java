
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
