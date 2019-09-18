
public class Monster {
	protected String mName; //몬스터이름
	protected int MaxHp;//몬스터최대 경험치
	protected int mHp;//몬스터 현재Hp
	protected int mExp;//몬스터가 주는 경험치
	protected int mAtt;//몬스터 공격력
	protected int mDef;//몬스터 방어력
	protected int mPos;//몬스터 위치
	protected Item item;//몬스터가 갖은 Item
	
	public void mAttack(Character character) {//캐릭터 공격함수
		
	}
	
	public void mDrop() {//아이템드랍함수
		
	}

	public int getmHp() {
		return mHp;
	}

	public void setmHp(int mHp) {
		this.mHp = mHp;
	}

	public String getmName() {
		return mName;
	}

	public int getMaxHp() {
		return MaxHp;
	}

	public int getmExp() {
		return mExp;
	}

	public int getmAtt() {
		return mAtt;
	}

	public int getmDef() {
		return mDef;
	}

	public int getmPos() {
		return mPos;
	}

	public Item getItem() {
		return item;
	}
	

}
