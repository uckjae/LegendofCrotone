import java.util.ArrayList;

public class Character {
	private static Character character;
	private final String cName;//ĳ�����̸�
	private int cLv;//ĳ���� ����
	private int cMaxhp;//�ִ�Hp
	private int cMaxmp;//�ִ�Mp
	private int cHp;//���� Hp
	private int cMp;//����mp
	private int cAtt;//�ɸ��� ���ݷ�
	private int cDef;//ĳ���� ����
	private int cExp;//ĳ���� ����ġ
	private int[] cLexp = {10,20,30};//�������� �ʿ��� ����ġ�� ���� �Լ� //�ʱ�ȭ 0918 �̿��� 
	private int cPos;//ĳ���� ������ġ
	private int inventoryMax;//�κ��丮 �ִ�ġ -> �Ʒ��� ���� �Է��� ����
	private Item[] inventory = new Item[inventoryMax];//������ ��� �κ��丮
	private Item[] item;//�������� ������
	private int[][] cLStatus = {{20, 0, 2, 2},{25,25,4,4},{30,30,6,6},{40,40,10,10}};//������������ ĳ���� Status ���� �� 0918 �̿��� �߰�
	
	//������
	
	public int getcLv() {
		return cLv;
	}
	
	public Character getCharacter() {
		return character;
	}
	
	//������ ����

	//ĳ���� ���� �̱���
	private Character(String cName) {//������ 1����
		this.cName = cName;
		this.cLv = 1;
		this.cMaxhp = 20;
		this.cMaxmp = 0;
		this.cHp = this.cMaxhp;
		this.cMp = this.cMaxmp;
		this.cExp = 0;
		this.cAtt = 2;
		this.cDef = 2;
		this.item = new Item[2];
	}
	
	public static Character mkCharacter(String cName) {//ĳ���ʹ� �ϳ��� �־���� �̱���
		if( character == null) {
			character = new Character(cName);
		}
		return character;	
	}
	
	protected void cAttack(Monster monster) {//�����Լ�
		int gap = cLStatus[this.cLv][2]-cLStatus[this.cLv-1][2];
		int attPoint = (int)(Math.random()*gap) + cLStatus[this.cLv-1][2] + 1 - monster.getmDef(); //+ (Weapon)(item[0]).getwAtt;
		attPoint = item[0]==null? attPoint:attPoint+ ((Weapon)(item[0])).getwAtt();
		monster.mHp -= attPoint;
	}
	
	protected void cSkillOne(Monster monster) {//���ǰ��� ��ų
		int attPoint = (int)(Math.random()+cLStatus[this.cLv][2])+13 - monster.getmDef();
		this.cMp-=10;
		monster.setmHp(monster.getmHp()-attPoint);
	}
	
	protected void cSkillTwo(Monster monster) {//�̺����� ��ų
		int attPoint = (int)(Math.random()+cLStatus[this.cLv][2])+18 - monster.getmDef();
		this.cMp-=15;
		monster.setmHp(monster.getmHp()-attPoint);
	}
	
	protected void cUse(Item item) {//�����ۻ���Լ�
		
	}
	
	protected void cLvUp(int cLv) {//�������Լ�
		if(character.cExp>cLexp[cLv-1]) {
			this.cMaxhp = cLStatus[cLv-1][0];
			this.cHp = this.cMaxhp;
			this.cMaxmp = cLStatus[cLv-1][1];
			this.cMp = this.cMaxmp;
			this.cExp = 0;
			this.cAtt = cLStatus[cLv-1][2];
			this.cDef = cLStatus[cLv-1][3];
			this.cLv++;
		}
	}
	
	protected void cMove() {//ĳ���� �̵��Լ�
		cPos++;
	}
	
	protected void cGet(Item item) {//������ ȹ���Լ�
		
	}
}
