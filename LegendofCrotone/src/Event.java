import java.util.ArrayList;

public class Event extends SuperEvent{
	private Monster monster;
	private Question question;
	private Item[] item;//걷다가 습득하는 무기들
	

		
	
	
	@Override
	public void eBattle(Character character) {//전투이벤트 함수
		notifyObserver();
	}
	
	public void eItem(Character character) {//아이템 습득 이벤트 함수
		
	}
	
	public void eDeath(Character character) {//캐릭터사망함수
		
	}
	
	public void eHpInfo(Character character) {//전투 중 Hp 출력함수
		
	}
}
