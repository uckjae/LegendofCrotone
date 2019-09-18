
public class MpPotion extends Item{
	private int mpRecover; // Mp 회복량
	
	public MpPotion(int mpRecover, String iName){ //포션 생성시 회복량과 이름을 받음
		super(iName);
		this.mpRecover = mpRecover;
	}

	public int getMpRecover() {
		return mpRecover;
	}
	
}
