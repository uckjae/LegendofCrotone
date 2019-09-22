/*
 Version : 2.4
 ���ϸ� : Boss.java
 �ۼ����� : 2019-09-21
 ���� : ��������
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
		super("��Ÿ���", 80, 0, 45, 25, 5);
		this.quiz = new ArrayList<String>();
	}

	@Override
	public void quizCreate() { 
		quiz.add("1+1"); //0
		quiz.add("â��"); //1
		
		quiz.add("4--0"); //2
		quiz.add("��"); //3
		
		quiz.add("3+3"); //4
		quiz.add("8"); //5
		
		quiz.add("2+2"); //6
		quiz.add("����"); //7
		
		quiz.add("��+2"); //8
		quiz.add("ī��"); //9
		
		quiz.add("4+4"); //10
		quiz.add("�����"); //11
		
		

	}

	@Override
	public boolean quiz() {
		this.isOx = false;
		if ( this.quizindex == this.quiz.size() ) this.quizindex = 0;
		
		for ( this.quizindex = this.quizindex ; this.quizindex < this.quiz.size(); this.quizindex+=2) { 
			String key = this.quiz.get(this.quizindex);
			String answer = this.quiz.get(this.quizindex+1);
			
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("���� : "+key+" : ");
			String userAnswer = sc.nextLine();
			System.out.printf("���� : %s=%s / �Է��Ͻ� �� : %s %n", key, answer,userAnswer);
			System.out.println("������������������������������������������������������������������������������������������");
			this.isOx = this.isOx(answer, userAnswer); // ����üũ�Լ� ȣ��
			this.quizindex+=2;
			break;
		} 
		

		return this.isOx;
	}
}
