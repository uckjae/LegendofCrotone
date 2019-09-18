import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.tools.FileObject;

public class Game {
	private Character character;//������ ĳ���͸� ������
	private int[] pos;//�̺�Ʈ�� �߻��ϴ� ��ġ���� �迭
	private Event event;//�̺�ƮŬ����
	private Menu menu;//�޴�Ŭ����
	FileOutputStream fos= null;//���� �ҷ����⸦ ���� Ŭ����
	FileInputStream fis = null;//���� �ҷ����⸦ ���� Ŭ����
	ObjectOutputStream oos = null;//���� �ҷ����⸦ ���� Ŭ����
	ObjectInputStream ois = null;//���� �ҷ����⸦ ���� Ŭ����
	
	//������ ����
	private ArrayList<Observer> observers = new ArrayList();
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	public void removeObserver(Observer observer){
	    observers.remove(observer);
	}
	public void notifyObserver() {
		for(Observer o:observers) {
			o.update(this);
		}
	}
		
	public Character getCharacter() {
		return character;
	}
	
	
	
	
	
	
	
	
	
	void gStrart(){//���ӽ����Լ�
		
	}
	
	void gLoad(){//���ӷε��Լ�
		
	}
	
	void gSave(String filename){//���������Լ� String�� ���ϸ�
		
	}
	
	void gStatus(Character character){//ĳ����������ȸ �Լ�
		
	}
	
	void gInventory(Character character){//ĳ���� �κ��丮 ��ȸ�Լ�
		
	}
	
	void gQuit(){//���� �����Լ�
		
	}
	
}
