/*
 Version : 2.4
 파일명 : GumonMon.java
 작성일자 : 2019-09-21
 설명 : 1소형몬스터
 */
package Monster;
import java.util.Random;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.Map;
import Item.HpPotion;
import Item.MpPotion;

public class GumonMon extends Monster {
	HpPotion hp;
	MpPotion mp;
	Random rd;

	public GumonMon() {
		super("구몬학습지",20,3, 13, 7, 3 );
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
			String quiz = q1+"+"+q2;
			String answer = Integer.toString(q1+q2);
			this.quizInfo.put(quiz, answer);
		}
	}


}
