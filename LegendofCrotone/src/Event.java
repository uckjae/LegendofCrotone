import java.util.ArrayList;

public class Event extends SuperEvent{
	private Monster monster;
	private Question question;
	private Item[] item;//�ȴٰ� �����ϴ� �����
	

		
	
	
	@Override
	public void eBattle(Character character) {//�����̺�Ʈ �Լ�
		notifyObserver();
	}
	
	public void eItem(Character character) {//������ ���� �̺�Ʈ �Լ�
		
	}
	
	public void eDeath(Character character) {//ĳ���ͻ���Լ�
		
	}
	
	public void eHpInfo(Character character) {//���� �� Hp ����Լ�
		
	}
}
