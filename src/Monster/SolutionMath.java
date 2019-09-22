/*
 Version : 2.4
 ���ϸ� : SolutionMath.java
 �ۼ����� : 2019-09-21
 ���� : 2��������
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
		super("�ع�����", 34, 5, 20, 11, 5);
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
//			System.out.println("������������������������������������������������������������������������������������������");
//			System.out.println("����: " +key+" : ");
//			String userAnswer = sc.nextLine();
//			System.out.printf("���� : %s=%s / �Է��Ͻ� �� : %s %n", key, answer,userAnswer);
//			System.out.println("������������������������������������������������������������������������������������������");
//
//			this.isOx = this.isOx(answer, userAnswer); // ����üũ�Լ� ȣ��
//			break;
//		}		
//		return this.isOx;
//	}
	
}
