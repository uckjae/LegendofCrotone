
public class Weapon extends Item {
	private final int wAtt;//���� ���ݷ�
	
	public Weapon(int wAtt, String iName){//��������� ���ݷ°� �̸��� ����
		super(iName);
		this.wAtt = wAtt;
	}
	
	public int getwAtt() {
		return wAtt;
	}
}
