/*
 Version : 2.4
 ���ϸ� : Monster.java
 �ۼ����� : 2019-09-21
 ���� : ����
 */
package Monster;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Game.Hero;
import Item.Item;

public abstract class Monster {
	protected String mName; //�����̸�
	private int MaxHp;//�����ִ� ����ġ
	private int mHp;//���� ����Hp
	private int mExp;//���Ͱ� �ִ� ����ġ
	private int mAtt;//���� �ּ� ���ݷ�
	private int mDef;//���� ����
	private int mAttGap;//
	protected HashMap<String, String> quizInfo;
	protected Scanner sc;
	protected boolean isOx;
	
	private Item item = null;//���Ͱ� ���� ������
	
	//���ͷ��� ���� 0919 ���� �̿���
		
	public Monster(String mName, int maxHp, int mExp, int mAtt, int mDef, int mAttGap) {//������� �Ķ���� ���� 0919 ���� �̿���
		this.mName = mName;
		MaxHp = maxHp;
		this.mHp = this.MaxHp;
		this.mExp = mExp;
		this.mAtt = mAtt;
		this.mDef = mDef;
		this.mAttGap = mAttGap;
		this.quizInfo = new HashMap<String, String>();
		sc = new Scanner(System.in);
	}

	//�������� �߻��Լ� = ���� ���� ������ �ٸ�.
	public abstract void quizCreate();
	
	// ����Ǯ�� �Լ�
	public boolean quiz() {
		this.isOx = false;
		for( Map.Entry quiz : this.quizInfo.entrySet() ) { 
			String key = (String) quiz.getKey();
			String answer = (String) quiz.getValue();
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("���� : "+key+" : ");
			String userAnswer = sc.nextLine();
			System.out.printf("���� : %s=%s / �Է��Ͻ� �� : %s %n", key, answer,userAnswer);
			System.out.println("������������������������������������������������������������������������������������������");
			this.isOx = this.isOx(answer, userAnswer); // ����üũ�Լ� ȣ��
			break;
		} 	
		return this.isOx;
	}
	
	boolean isOx(String answer, String userAnswer) { 
		System.out.println("������������������������������������������������������������������������������������������");
		if ( answer.equals(userAnswer) ) {
			System.out.println("�����!! ���ݼ���!!");
			this.isOx = true;
		} else {
			System.out.println("Ʋ�ȴ٤Фа��ݽ��ФФ�");
		}
		System.out.println("������������������������������������������������������������������������������������������");
		return this.isOx;
	}
	
	public void mAttack(Hero hero) {
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("\t"+mName+"��/�� �����ߴ�");
		int AttPoint  = (int)(Math.random()*mAttGap) + mAtt -hero.gethDef();
		if(AttPoint<0) AttPoint = 1;
		hero.sethHp(hero.gethHp()-AttPoint);
		System.out.println("\t"+AttPoint+"�� ���ظ� �Ծ���");
		System.out.println("������������������������������������������������������������������������������������������");
	}

	////////getter setter//////////////
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

	public int getmAttGap() {
		return mAttGap;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}	
	
}
