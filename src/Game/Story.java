/*
 Version : 2.4
 ���ϸ� : Story.java
 �ۼ����� : 2019-09-21
 ���� : ���ӽ��丮�� ���
 */
package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//����
class Story {
	private FileReader fr; // ���丮 �о���� ���� 0919 ����
	private BufferedReader br; // ���丮 �о���� ���� 0919 ����
	private ArrayList<String> story;
	private int storyIndex; // ���丮�ε��� 0919 ����
	private Scanner sc;

	Story() {
		this.sc = new Scanner(System.in);
	}
	
	void storyIndex(Hero hero) {
		this.storyIndex = hero.getStoryIndex();
	}

	// �ҷ����� �� ���丮 ���� ���� // 0920 ����
	void gameStory(Hero hero) {
		switch (hero.gethPos()) { // hero ���� ��ġ�� ��������.
		case 2:
			this.readWeaponTutorialStory(); // ���� Ʃ�丮�� ���丮 �о����
			break;
		case 3:
			this.readArmorTutorialStory(); // �� Ʃ�丮�� ���丮 �о����
			break;
		case 4:
		case 5:
			this.read1SmallMonsterStory();
			break;
		case 7:
			this.read1BigMonsterStory();
			break;
		case 8:
		case 9:
			this.read2SmallMonsterStory();
			break;
		case 11:
			this.read2BigMonsterStory();
			break;
		case 12:
		case 13:
		case 14:
			this.read3SmallMonsterStory();
			break;
		case 16:
			this.read3BigMonsterStory();
			break;
		case 17:
			this.readBosMonsterStory();
			break;
		case 6:
			this.readTriangleStory();
			break;
		case 10:
			this.readCompassStory();
			break;
		case 15:
			this.readCalculatorStory();
			break;
		}
	}


	// txt ���丮 ������ �о ArrayList �� ����  �Ϸ�
	void loadStory() { 
		this.story = new ArrayList<String>();

		try {
			fr = new FileReader("story.txt");
			br = new BufferedReader(fr);
			String line="";
			for (int i = 0; (line = br.readLine())!=null; i++) {
				//System.out.println(line);
				story.add(line);
			}
		} catch (Exception e) {
			System.out.println("���丮�� �ҷ����� ���߽��ϴ�. ������ �ٽ� �������ּ���.");
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				System.out.println("���丮�� �ҷ����� ���� ������ �߻��߽��ϴ�. ������ �ٽ� �������ּ���.");
				e.printStackTrace();
			}
		}
	}

	//������ ���丮 �о����  �Ϸ�
	void readOpenStory() { 
		for ( this.storyIndex = 0; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("������") ) { // ������ ������ ���
				System.out.println(this.story.get(this.storyIndex));

			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//���� Ʃ�丮�� ���丮 �о���� �Ϸ�
	void readWeaponTutorialStory() { 
		for ( this.storyIndex  = this.storyIndex ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("����Ʃ�丮��") ) { // ����Ʃ�丮�� ������ ���
				System.out.println(this.story.get(this.storyIndex));

			} else {
				this.storyIndex++;
				return;
			}
		}

	}

	//�� Ʃ�丮�� ���丮 �о���� �Ϸ�
	void readArmorTutorialStory() { 
		for ( this.storyIndex  = this.storyIndex ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("��Ʃ�丮��") ) { // ��Ʃ�丮�� ������ ���
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}	
	}

	//�ﰢ�� ���丮 �о����
	void readTriangleStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("�ﰢ�ڹ߰�") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}	
	}
	
	//���۽� ���丮 �о����
	void readCompassStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("���۽��߰�") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//���п���� ���丮 �о��
	void readCalculatorStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("���п����߰�") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//1�������� ���丮 �о���� �Ϸ� 58
	void read1SmallMonsterStory() { 
		for ( this.storyIndex  = 58; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("1��������") ) { // ��Ʃ�丮�� ������ ���
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//1�������� ���丮 �о����
	void read1BigMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("1��������") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//2�������� ���丮 �о���� 96
	void read2SmallMonsterStory() {
		for ( this.storyIndex  = 96 ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("2��������") ) { // ��Ʃ�丮�� ������ ���
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//2�������� ���丮 �о����
	void read2BigMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("2��������") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//3�������� ���丮 �о���� 144
	void read3SmallMonsterStory() {
		for ( this.storyIndex  = 144 ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("3��������") ) { // ��Ʃ�丮�� ������ ���
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//3�������� ���丮 �о����
	void read3BigMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("3��������") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//�������� ���丮 �о����
	void readBosMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("��")) { // Ư�� ��ȣ ������ ��� ����ٰ� �ƹ�Ű�� ������ �ٽ� ���
				this.sc.nextLine();
				this.storyIndex++; // ����ȣ ��� ���ϱ� ���ؼ�
			}
			if ( !this.story.get(this.storyIndex).equals("����") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	int getStoryIndex() {
		return storyIndex;
	}
	
}