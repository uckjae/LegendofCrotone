
public class MpPotion extends Item{
	private int mpRecover; // Mp ȸ����
	
	public MpPotion(int mpRecover, String iName){ //���� ������ ȸ������ �̸��� ����
		super(iName);
		this.mpRecover = mpRecover;
	}

	public int getMpRecover() {
		return mpRecover;
	}
	
}
