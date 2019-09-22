/*
 Version : 2.4
 ���ϸ� : NightSchool.java
 �ۼ����� : 2019-09-21
 ���� : 2��������
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
		super("�߰������н�", 39, 11, 22, 14, 5);
		super.setItem(new Armor(6,"����������"));
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
