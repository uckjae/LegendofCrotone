
public class HpPotion extends Item{
	private int mpRecover; // Mp È¸º¹·®
	
	public HpPotion(int mpRecover, String iName){
		super(iName);
		this.mpRecover = mpRecover;
	}

	public int getMpRecover() {
		return mpRecover;
	}
	
}
