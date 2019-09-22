/*
 Version : 2.4
 ���ϸ� : Hero.java
 �ۼ����� : 2019-09-21
 ���� : ĳ������ �ʿ��� ��� �͵�
 */
package Game;

import java.io.Serializable;
import Item.Armor;
import Item.HpPotion;
import Item.Item;
import Item.MpPotion;
import Item.Weapon;
import Monster.Monster;

public class Hero implements Serializable{  //��ü������ ���� ����ȭó�� �� �� �ְ�
	private static Hero hero; //�̱�������
	private int storyIndex; // ����� ���� ���丮������ġ
	private final String hName;//ĳ�����̸�
	private int hLv;//ĳ���� ����
	private int hMaxhp;//�ִ�Hp
	private int hMaxmp;//�ִ�Mp
	private int hHp;//���� Hp
	private int hMp;//����mp
	private int hAtt;//�ɸ��� ���ݷ�
	private int hDef;//ĳ���� ����
	private int hExp;//ĳ���� ����ġ
	private int[] hLexp;//�������� �ʿ��� ����ġ�� ���� �Լ� //�ʱ�ȭ 0918 �̿��� 
	private int hPos;//ĳ���� ������ġ
	private Item[] inventory;//������ ��� �κ��丮
	private Item[] item;//�������� ������
	private int[][] hLStatus;//������������ ĳ���� Status ���� �� 0918 �̿��� �߰�

	//ĳ���� ���� �̱���
	private Hero(String hName) {//������ 1����
		this.hLStatus = new int[][] {{0,0,0,0},{50, 0, 15, 15},{60,50,20,20},{70,60,25,25},{80,70,30,30},{100,100,100,100}};
		this.hName = hName;
		this.hLv = 1;
		this.hMaxhp = hLStatus[1][0];
		this.hMaxmp = hLStatus[1][1]  ;
		this.hHp = this.hMaxhp;
		this.hMp = this.hMaxmp;
		this.hExp = 0;
		this.hAtt = hLStatus [1][2];
		this.hDef = hLStatus [1][3];
		this.hPos = 1;
		this.inventory = new Item[10];
		this.item = new Item[2];
		this.hLexp = new int[] {0,10,20,30,40};
	}

	//ĳ���ʹ� �ϳ��� �־���� �̱��� //�Լ��̸� ����0919
	static Hero mkHero(String hName) {
		if( hero == null) {
			hero = new Hero(hName);
		}
		return hero;	
	}
	//�ҷ����� �� ����ϴ� �̱��� ���� �Լ� (�����ε�)
	static Hero mkHero(Hero hero1) {
		hero = hero1;
		return hero;
	}

	//���� ���丮 ���� ���� �Լ� //0920 ����
	void storyIndex(Story story) {
		this.storyIndex = story.getStoryIndex();
	}

	//�����Լ� ����
	void hAttack(Monster monster) {
		int gap;
		int attPoint;
		if(hLv!=1){
			gap = hLStatus[this.hLv][2]-hLStatus[this.hLv-1][2];
			attPoint = (int)(Math.random()*gap) + hLStatus[this.hLv-1][2] + 1 - monster.getmDef(); //+ (Weapon)(item[0]).getwAtt;
			attPoint = item[0]==null? attPoint:attPoint+ ((Weapon)(item[0])).getwAtt();
			if(attPoint<0){
				attPoint =1;
			}


		}else{
			attPoint = (int)(Math.random()*2)+ hAtt;
		}
		System.out.println(attPoint+"�� ���ظ� ������");
		monster.setmHp(monster.getmHp()-attPoint);// -= attPoint;
	}

	//���ǰ��� ��ų ����
	void cSkillOne(Monster monster) {
		int attPoint = (int)(Math.random()*hLStatus[this.hLv][2])+13;
		this.hMp-=10;
		System.out.println("     *      _______________");
		System.out.println("   *   *   {  sin��+cos��=1!!! )");
		System.out.println("     *      \\_______________/ ");
		System.out.println("  *  *  *     ��������!!");
		System.out.println(" *   *    *");
		System.out.println("     *     ");
		System.out.println("  *  *  *  ");
		System.out.println(" *       * ");
		System.out.println(" *       * ");
		System.out.println("*********************");
		System.out.println("**"+attPoint+"�� ���ظ� ������**");
		System.out.println("*********************");
		monster.setmHp(monster.getmHp()-attPoint);
		//sin��+cos��=1
	}

	//�̺����� ��ų ����
	void cSkillTwo(Monster monster) {
		int attPoint = (int)(Math.random()*hLStatus[this.hLv][2])+18;
		this.hMp-=15;
		System.out.println("     *      _______________");
		System.out.println("   *   *   {  ��f(x)dx!!!!!!! )");
		System.out.println("     *      \\_______________/ ");
		System.out.println("  *  *  *     ������!!");
		System.out.println(" *   *    *");
		System.out.println("     *     ");
		System.out.println("  *  *  *  ");
		System.out.println(" *       * ");
		System.out.println(" *       * ");
		System.out.println(attPoint+"�� ���ظ� ������");
		System.out.println("***************");
		System.out.println("**"+attPoint+"�� ���ظ� ������**");
		System.out.println("***************");
		monster.setmHp(monster.getmHp()-attPoint);
	}

	// ������̴� ������ â�� �־��ֱ� //0919 ������ �߰�
	void hUseInventory(Item item) { 
		//int count = 0; // â�� �������� ���� ���� ����üũ
		for ( int index = 0; index < this.inventory.length ; index++) { // â������ŭ for �� ����
			if(this.inventory[index] == null) { // â�� ���������
				this.inventory[index] = item;
				System.out.printf("%s ���濡 �־����ϴ�.\n",this.inventory[index].getiName());
				return;
			}
		}
	}

	//�����ۻ���Լ� ���� 0919 1523 ����
	boolean hUse(String choice) { 
		boolean ischoice = false;
		Item item = hItemDelete(choice); // ������ �������� â���� ����

		if( item != null ) {
			ischoice = true;
			System.out.println("������������������������������������������������������������������������������������������\n");
			if ( item instanceof Weapon) { //����� �������� ����� item �迭 0���濡 �ְ� �ٿ�ĳ���� �� ���ݷ� �����ͼ� �����ֱ�
				Weapon newWeapon = (Weapon)item;
				if ( this.item[0] != null) {
					hUseInventory(this.item[0]); // ������ ������ �κ��丮��
					Weapon oldWeapon = (Weapon)this.item[0];
					this.hAtt -= oldWeapon.getwAtt();
					System.out.printf("%s ��������!!\n (���ݷ��� ��%d�� ���ҵǾ����ϴ�.)\n\n",oldWeapon.getiName(),oldWeapon.getwAtt());
				}			
				this.item[0] = item;
				this.hAtt += newWeapon.getwAtt();
				System.out.printf("%s �����Ϸ�!!\n (���ݷ��� ��%d�� �����Ǿ����ϴ�.)\n\n",newWeapon.getiName(),newWeapon.getwAtt());
			} else if (item instanceof Armor) { // ���� item �迭 1���濡 �ְ� �ٿ�ĳ���� �� ���� �����ͼ� �����ֱ�
				Armor newArmor = (Armor)item;
				if ( this.item[1] != null) {
					hUseInventory(this.item[1]); // ������ ������ �κ��丮��
					Armor oldArmor = (Armor)this.item[1];
					this.hDef -= oldArmor.getaDef();
					System.out.printf("%s �����Ϸ�!!\n (������ ��%d�� ���ҵǾ����ϴ�.)\n\n",oldArmor.getiName(),oldArmor.getaDef());
				}
				this.item[1] = item;
				this.hDef += newArmor.getaDef();
				System.out.printf("%s �����Ϸ�!!\n (������ ��%d�� �����Ǿ����ϴ�.)\n\n",newArmor.getiName(),newArmor.getaDef());
			}else if ( item instanceof HpPotion) { //HP�����̸� ȸ���� �����ͼ� �����ֱ�
				HpPotion hpPotion = (HpPotion)item;

				if ( (this.hHp+hpPotion.getHpRecover()) > this.hMaxhp ) { // ������ �Ծ ������ HP�� �ִ�HP ���� ũ�� �ִ� HP������ ǥ�����ֱ�
					this.hHp = this.hMaxhp;
				} else {
					this.hHp += hpPotion.getHpRecover();
				}
				System.out.printf("%s ���Ϸ�!!\n(HP�� ��%d�� ȸ���Ǿ����ϴ�.)\n",hpPotion.getiName(),hpPotion.getHpRecover());
			}else { // Mp �����̸� ȸ���� �����ͼ� �����ֱ�
				MpPotion mpPotion = (MpPotion)item;

				if ( (this.hMp+mpPotion.getMpRecover()) > this.hMaxmp ) { // ������ �Ծ ������ MP�� �ִ�MP ���� ũ�� �ִ� MP������ ǥ�����ֱ�
					this.hMp = this.hMaxmp;
				} else {
					this.hMp += mpPotion.getMpRecover();
				}
				System.out.printf("%s ���Ϸ�!!\n(MP�� ��%d�� ȸ���Ǿ����ϴ�.)\n",mpPotion.getiName(), mpPotion.getMpRecover());
			}
			System.out.println("������������������������������������������������������������������������������������������");
		}
		return ischoice;
		
	}

	//�������Լ� ����
	void hLvUp() {
		if(hero.hExp>hLexp[hLv]) {
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("������ �Ͽ����ϴ�");
			System.out.println("������������������������������������������������������������������������������������������");
			this.hLv++;
			this.hMaxhp = hLStatus[hLv][0];
			this.hHp = this.hMaxhp;
			this.hMaxmp = hLStatus[hLv][1];
			this.hMp = this.hMaxmp;
			this.hExp = 0;
			this.hAtt = hLStatus[hLv][2];
			this.hDef = hLStatus[hLv][3];

		}
	}

	//ĳ���� �̵��Լ� ����
	void hMove() {
		hPos++;
	}

	//������ ȹ���Լ� ���� // ��⸦ ������ �� ���� // 0920 0937
	void hGet(Item item) { 
		int i;
		for (i = 0; i < inventory.length; i++) {// �κ��丮�� ����ִٸ�
			if (inventory[i] == null) {
				inventory[i] =item; // �������� �־� ��
				System.out.println("������������������������������������������������������������������������������������������");
				System.out.println("�� "+hero.hName + " �� ���� " + item.getiName() + "�� ȹ���߽��ϴ�.");
				System.out.println("������������������������������������������������������������������������������������������");
				System.out.println("�� ���濡 [" + item.getiName() + "] �߰�");
				break;
			}
		}

		if (i >= inventory.length) { //�κ��丮�� ���� á�ٸ�
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("\t������ ���� �� �־� ���̻� ���� �� �����ϴ�.");
			System.out.println("\t������ ������ �ٽ� ���ƿ��� �ʽ��ϴ�.�������ʹ� ���� �ܵ� ��������.");
			System.out.println("������������������������������������������������������������������������������������������");
		}
	}

	//ĳ���� �κ��丮 ��ȸ�Լ� ���� �ϼ�
	boolean hInventory(){
		int count = 0;
		boolean hasSomething = true;
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("\t\t��  ��  ��  ��");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < this.inventory.length; i++) {
			if (this.inventory[i] != null) {
				System.out.printf("\t��(%d)�� %s\n",(i+1),this.inventory[i].getiName());
				System.out.println("-------------------------------------------");
				count++;
			}
		}
		if ( count == 0 ) {
			hasSomething = false;
			System.out.println("����ִ� �������� �����ϴ�.");
		}
		System.out.println("������������������������������������������������������������������������������������������");
		return hasSomething;
	}

	//ĳ����������ȸ �Լ� ���� �ϼ�
	void hStatus(){
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("\t����Lv : " + this.hLv);
		System.out.println("\t����HP : " + this.hHp +" / " + this.hMaxhp);
		System.out.println("\t����MP : " + this.hMp +" / " + this.hMaxmp);
		System.out.println("\t�������ġ : " + this.hExp);
		System.out.println("\t������ݷ� : " + this.hAtt);
		System.out.println("\t������� : " + this.hDef);
				
		if ( this.item[0] != null ) System.out.println("\t���� �������� ���� : " + this.item[0].getiName());
		if( this.item[1] != null) System.out.println("\t���� �������� �� : " + this.item[1].getiName());
		System.out.println("������������������������������������������������������������������������������������������");
	}

	// ������ �������� â���� ���� item return //0919 ������ �߰�
	Item hItemDelete(String choice) { 
		Item item = null;
		int choiceInt = (Integer.parseInt(choice))-1;

		if ( this.inventory[choiceInt] != null ) {
			item = this.inventory[choiceInt];
			this.inventory[choiceInt] = null;
			System.out.println("���濡�� ���´�");
		} else {
			System.out.println("�ڡ١ڡ���������!!�ڡ١ڡ�");
		}
		//System.out.printf("%s �������� ���濡�� ���½��ϴ�.\n",item.getiName());
		return item;
	}

	//----------------------------------------------getter setter----------------------------------

	// mAttack() ���� ��� //0919 �̿���
	public int gethHp() {
		return hHp;
	}

	// mAttack() ���� ��� //0919 �̿���
	public void sethHp(int hHp) {
		this.hHp = hHp;
	}

	// mAttack() ���� ��� //0919 �̿���
	public int gethDef() {
		return hDef;
	}

	// eHpInfo(Hero hero) ���� ��� //0919 ����
	public String gethName() {
		return hName;
	}

	public int gethMp() {
		return hMp;
	}

	public int gethExp() {
		return hExp;
	}

	public int gethPos() {
		return hPos;
	}

	//������
	public void sethExp(int hExp) {
		this.hExp = hExp;
	}

	// ���ϻ��
	public int getStoryIndex() {
		return storyIndex;
	}
	
	//������ hpInfo�Լ��� ��� 0921 �̿���
	public int gethMaxhp() {
		return hMaxhp;
	}
	
	//������ hpInfo�Լ��� ��� 0921 �̿���
	public int gethMaxmp() {
		return hMaxmp;
	}
	

}
