/*
 Version : 2.4
 파일명 : SolutionMath.java
 작성일자 : 2019-09-21
 설명 : 2소형몬스터
 */
package Monster;

import java.util.Random;

//import java.util.Iterator;
//import java.util.Set;

import Item.HpPotion;
import Item.MpPotion;

public class SolutionMath extends Monster {
	HpPotion hp;
	MpPotion mp;
	Random rd;
	public SolutionMath() {
		super("해법수학", 34, 5, 20, 11, 5);
		rd = new Random();
		int r = rd.nextInt(2000000000)%2;
		switch(r) {
		case 0: super.setItem(hp = new HpPotion()); break;
		case 1: super.setItem(mp = new MpPotion()); break;
		}
	}
	
	@Override
	public void quizCreate() { 
		for (int count = 1; count <= 50; count++) {
			int q1 =((int)( Math.random()*9)+1);
			int q2 = ((int)( Math.random()*9)+1);
			String quiz = q1+"x"+q2;
			String answer = Integer.toString(q1*q2);
			this.quizInfo.put(quiz, answer);
		}
	}
	
//	@Override
//	public boolean quiz() { 	
//		this.isOx = false;
//		Set<String> keyset = this.quizInfo.keySet();
//		Iterator<String> it = keyset.iterator();
//		while (it.hasNext()){
//			String key = (String) it.next();
//			String answer = quizInfo.get(key);
//			System.out.println("─────────────────────────────────────────────");
//			System.out.println("문제: " +key+" : ");
//			String userAnswer = sc.nextLine();
//			System.out.printf("정답 : %s=%s / 입력하신 답 : %s %n", key, answer,userAnswer);
//			System.out.println("─────────────────────────────────────────────");
//
//			this.isOx = this.isOx(answer, userAnswer); // 정답체크함수 호출
//			break;
//		}		
//		return this.isOx;
//	}
	
}
