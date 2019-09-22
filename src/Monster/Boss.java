/*
 Version : 2.4
 파일명 : Boss.java
 작성일자 : 2019-09-21
 설명 : 보스몬스터
 */
package Monster;

import java.util.ArrayList;

/*import java.util.Iterator;
import java.util.Map;
import java.util.Set;*/
import Item.HpPotion;
import Item.MpPotion;

public class Boss extends Monster{
	private ArrayList<String> quiz;
	private int quizindex;
	
	public Boss() {
		super("피타고라스", 80, 0, 45, 25, 5);
		this.quiz = new ArrayList<String>();
	}

	@Override
	public void quizCreate() { 
		quiz.add("1+1"); //0
		quiz.add("창문"); //1
		
		quiz.add("4--0"); //2
		quiz.add("똥"); //3
		
		quiz.add("3+3"); //4
		quiz.add("8"); //5
		
		quiz.add("2+2"); //6
		quiz.add("덧니"); //7
		
		quiz.add("차+2"); //8
		quiz.add("카이"); //9
		
		quiz.add("4+4"); //10
		quiz.add("눈사람"); //11
		
		

	}

	@Override
	public boolean quiz() {
		this.isOx = false;
		if ( this.quizindex == this.quiz.size() ) this.quizindex = 0;
		
		for ( this.quizindex = this.quizindex ; this.quizindex < this.quiz.size(); this.quizindex+=2) { 
			String key = this.quiz.get(this.quizindex);
			String answer = this.quiz.get(this.quizindex+1);
			
			System.out.println("─────────────────────────────────────────────");
			System.out.println("문제 : "+key+" : ");
			String userAnswer = sc.nextLine();
			System.out.printf("정답 : %s=%s / 입력하신 답 : %s %n", key, answer,userAnswer);
			System.out.println("─────────────────────────────────────────────");
			this.isOx = this.isOx(answer, userAnswer); // 정답체크함수 호출
			this.quizindex+=2;
			break;
		} 
		

		return this.isOx;
	}
}
