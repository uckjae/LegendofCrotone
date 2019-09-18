import java.util.ArrayList;

public class Character {
	private static Character character;
	private final String cName;//캐릭터이름
	private int cLv;//캐릭터 레벨
	private int cMaxhp;//최대Hp
	private int cMaxmp;//최대Mp
	private int cHp;//현재 Hp
	private int cMp;//현재mp
	private int cAtt;//케릭터 공격력
	private int cDef;//캐릭터 방어력
	private int cExp;//캐릭터 경험치
	private int[] cLexp = {10,20,30};//레벨업에 필요한 경험치를 담을 함수 //초기화 0918 이욱재 
	private int cPos;//캐릭터 현재위치
	private int inventoryMax;//인벤토리 최대치 -> 아래에 정수 입력후 삭제
	private Item[] inventory = new Item[inventoryMax];//아이템 담는 인벤토리
	private Item[] item;//장착중인 아이템
	private int[][] cLStatus = {{20, 0, 2, 2},{25,25,4,4},{30,30,6,6},{40,40,10,10}};//레벨업에따른 캐릭서 Status 설정 값 0918 이욱재 추가
	
	//옵저버
	
	public int getcLv() {
		return cLv;
	}
	
	public Character getCharacter() {
		return character;
	}
	
	//옵저버 종료

	//캐릭터 생성 싱글톤
	private Character(String cName) {//생성시 1레벨
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
	
	public static Character mkCharacter(String cName) {//캐릭터는 하나만 있어야함 싱글톤
		if( character == null) {
			character = new Character(cName);
		}
		return character;	
	}
	
	protected void cAttack(Monster monster) {//공격함수
		int gap = cLStatus[this.cLv][2]-cLStatus[this.cLv-1][2];
		int attPoint = (int)(Math.random()*gap) + cLStatus[this.cLv-1][2] + 1 - monster.getmDef(); //+ (Weapon)(item[0]).getwAtt;
		attPoint = item[0]==null? attPoint:attPoint+ ((Weapon)(item[0])).getwAtt();
		monster.mHp -= attPoint;
	}
	
	protected void cSkillOne(Monster monster) {//근의공식 스킬
		int attPoint = (int)(Math.random()+cLStatus[this.cLv][2])+13 - monster.getmDef();
		this.cMp-=10;
		monster.setmHp(monster.getmHp()-attPoint);
	}
	
	protected void cSkillTwo(Monster monster) {//미분적분 스킬
		int attPoint = (int)(Math.random()+cLStatus[this.cLv][2])+18 - monster.getmDef();
		this.cMp-=15;
		monster.setmHp(monster.getmHp()-attPoint);
	}
	
	protected void cUse(Item item) {//아이템사용함수
		
	}
	
	protected void cLvUp(int cLv) {//레벨업함수
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
	
	protected void cMove() {//캐릭터 이동함수
		cPos++;
	}
	
	protected void cGet(Item item) {//아이템 획득함수
		
	}
}
