/*
 Version : 2.4
 ���ϸ� : AfterSchool.java
 �ۼ����� : 2019-09-21
 ���� : 1��������
 */
package Monster;

//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
import Item.Armor;
import Item.HpPotion;
import Item.MpPotion;

public class AfterSchool extends Monster {
	public AfterSchool(){
		super("����ı���", 30, 5, 17, 10, 4);
		super.setItem(new Armor(4,"��������å"));
	}
	@Override
	public void quizCreate() { 
		for (int count = 1; count <= 50; count++) {
			int q1 =((int)( Math.random()*89)+10);
			int q2 = ((int)( Math.random()*89)+10);
			String quiz = q1+"+"+q2;
			String answer = Integer.toString(q1+q2);
			this.quizInfo.put(quiz, answer);
		}
	}


	
}
