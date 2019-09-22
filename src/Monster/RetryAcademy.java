/*
 Version : 2.4
 파일명 : RetryAcademy.java
 작성일자 : 2019-09-21
 설명 : 3대형몬스터
 */
package Monster;

//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
import Item.*;

public class RetryAcademy extends Monster {
	public RetryAcademy() {
		super("재수학원", 51, 14, 31, 20, 10);
		super.setItem(new Armor(10,"공업수학"));
	}
	@Override
	public void quizCreate() { 
		for (int count = 1; count <= 50; count++) {
			int q1 =((int)( Math.random()*89)+10);
			int q2 = ((int)( Math.random()*89)+10);
			int q3 = ((int)( Math.random()*9)+1);
			String quiz = q1+"+"+q2+"x"+q3;
			String answer = Integer.toString(q1+q2*q3);
			this.quizInfo.put(quiz, answer);
		}
	}


}
