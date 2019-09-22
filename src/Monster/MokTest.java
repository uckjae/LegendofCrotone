/*
 Version : 2.4
 ���ϸ� : MokTest.java
 �ۼ����� : 2019-09-21
 ���� : 3��������
 */
package Monster;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

import Item.HpPotion;
import Item.MpPotion;

public class MokTest extends Monster{
	HpPotion hp;
	MpPotion mp;
	Random rd;
	public MokTest() {
		super("���ǰ��", 44, 7, 28, 17, 5);
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
			int q3 = ((int)( Math.random()*9)+1);
			String quiz = q1+"+"+q2+"x"+q3;
			String answer = Integer.toString(q1+q2*q3);
			this.quizInfo.put(quiz, answer);
		}
	}
//	@Override
//	public boolean quiz() {
//		this.isOx = false;
//		for( Map.Entry quiz : this.quizInfo.entrySet() ) { 
//			String key = (String) quiz.getKey();
//			String answer = (String) quiz.getValue();
//			System.out.println("������������������������������������������������������������������������������������������");
//			System.out.println("���� : "+key+" : ");
//			String userAnswer = sc.nextLine();
//			System.out.printf("���� : %s=%s / �Է��Ͻ� �� : %s %n", key, answer,userAnswer);
//			System.out.println("������������������������������������������������������������������������������������������");
//			this.isOx = this.isOx(answer, userAnswer); // ����üũ�Լ� ȣ��
//			break;
//		} 
//		Set<String> keyset = this.quizInfo.keySet();
//		Iterator<String> it = keyset.iterator();
//		while (it.hasNext()){
//			String key = (String) it.next();
//			String answer = quizInfo.get(key);
//			System.out.println("������������������������������������������������������������������������������������������");
//			System.out.println("���� : "+key+" : ");
//			String userAnswer = sc.nextLine();
//			//String userAnswer = JOptionPane.showInputDialog(key).trim();
//			System.out.printf("���� : %s=%s / �Է��Ͻ� �� : %s %n", key, answer,userAnswer);
//			System.out.println("������������������������������������������������������������������������������������������");
//
//			this.isOx = this.isOx(answer, userAnswer); // ����üũ�Լ� ȣ��
//			break;
//		}		
//		return this.isOx;
//	}
}
