
public class Monster {
	protected String mName; //�����̸�
	protected int MaxHp;//�����ִ� ����ġ
	protected int mHp;//���� ����Hp
	protected int mExp;//���Ͱ� �ִ� ����ġ
	protected int mAtt;//���� ���ݷ�
	protected int mDef;//���� ����
	protected int mPos;//���� ��ġ
	protected Item item;//���Ͱ� ���� Item
	
	public void mAttack(Character character) {//ĳ���� �����Լ�
		
	}
	
	public void mDrop() {//�����۵���Լ�
		
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
