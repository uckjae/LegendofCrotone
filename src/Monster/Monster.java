/*
 Version : 2.4
 파일명 : Monster.java
 작성일자 : 2019-09-21
 설명 : 몬스터
 */
package Monster;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Game.Hero;
import Item.Item;

public abstract class Monster {
	protected String mName; //몬스터이름
	private int MaxHp;//몬스터최대 경험치
	private int mHp;//몬스터 현재Hp
	private int mExp;//몬스터가 주는 경험치
	private int mAtt;//몬스터 최소 공격력
	private int mDef;//몬스터 방어력
	private int mAttGap;//
	protected HashMap<String, String> quizInfo;
	protected Scanner sc;
	protected boolean isOx;
	
	private Item item = null;//몬스터가 갖은 아이템
	
	//몬스터레벨 삭제 0919 오후 이욱재
		
	public Monster(String mName, int maxHp, int mExp, int mAtt, int mDef, int mAttGap) {//쓸모없는 파라미터 제거 0919 오후 이욱재
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

	//문제생성 추상함수 = 몬스터 별로 문제가 다름.
	public abstract void quizCreate();
	
	// 퀴즈풀기 함수
	public boolean quiz() {
		this.isOx = false;
		for( Map.Entry quiz : this.quizInfo.entrySet() ) { 
			String key = (String) quiz.getKey();
			String answer = (String) quiz.getValue();
			System.out.println("─────────────────────────────────────────────");
			System.out.println("문제 : "+key+" : ");
			String userAnswer = sc.nextLine();
			System.out.printf("정답 : %s=%s / 입력하신 답 : %s %n", key, answer,userAnswer);
			System.out.println("─────────────────────────────────────────────");
			this.isOx = this.isOx(answer, userAnswer); // 정답체크함수 호출
			break;
		} 	
		return this.isOx;
	}
	
	boolean isOx(String answer, String userAnswer) { 
		System.out.println("─────────────────────────────────────────────");
		if ( answer.equals(userAnswer) ) {
			System.out.println("맞췄다!! 공격성공!!");
			this.isOx = true;
		} else {
			System.out.println("틀렸다ㅠㅠ공격실패ㅠㅠ");
		}
		System.out.println("─────────────────────────────────────────────");
		return this.isOx;
	}
	
	public void mAttack(Hero hero) {
		System.out.println("─────────────────────────────────────────────");
		System.out.println("\t"+mName+"가/이 공격했다");
		int AttPoint  = (int)(Math.random()*mAttGap) + mAtt -hero.gethDef();
		if(AttPoint<0) AttPoint = 1;
		hero.sethHp(hero.gethHp()-AttPoint);
		System.out.println("\t"+AttPoint+"의 피해를 입었다");
		System.out.println("─────────────────────────────────────────────");
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
