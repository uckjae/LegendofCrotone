/*
 Version : 2.4
 파일명 : NightSchool.java
 작성일자 : 2019-09-21
 설명 : 2대형몬스터
 */
package Monster;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;



import Item.Armor;
import Item.HpPotion;
import Item.MpPotion;

public class NightSchool extends Monster{

	public NightSchool() {
		super("야간자율학습", 39, 11, 22, 14, 5);
		super.setItem(new Armor(6,"수학의정석"));
	}
	@Override
	public void quizCreate() { 
		for (int count = 1; count <= 50; count++) {
			int q1 =((int)( Math.random()*89)+10);
			int q2 = ((int)( Math.random()*89)+10);
			String quiz = q1+"x"+q2;
			String answer = Integer.toString(q1*q2);
			this.quizInfo.put(quiz, answer);
		}
	}

}
