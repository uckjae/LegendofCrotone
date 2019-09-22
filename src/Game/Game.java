/*
 Version : 2.4
 ���ϸ� : Game.java
 �ۼ����� : 2019-09-21
 ���� : Game ������ ���� �͵�
 */
package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import Item.*;

public class Game {
	private static Game game; //�̱�������
	private Hero hero;//������ ĳ���͸� ������
	private Event event;//�̺�ƮŬ����
	private Menu menu;//�޴�Ŭ����
	private FileOutputStream fos;//���� �ҷ����⸦ ���� Ŭ����
	private FileInputStream fis;//���� �ҷ����⸦ ���� Ŭ����
	private ObjectOutputStream oos;//���� �ҷ����⸦ ���� Ŭ����
	private ObjectInputStream ois;//���� �ҷ����⸦ ���� Ŭ����
	
	private Story story; // ���丮 �ҷ��������ؼ�... 0919 2020 ����
	private Scanner sc; // ��ĳ�� 0919 ����
	
	private Game() { // ������ ��ĳ�� �ʱ�ȭ
		this.sc = new Scanner(System.in);
	}
	
	//�̱�������
	public static Game gameStart() {
		if( game == null) {
			game = new Game();
		}
		return game;	
	}

	//���ӽ��� �Ϸ� // 0919 1636 ���� 
	public void gStrart(){
		this.menu = new Menu();
		this.event = new Event();
		this.story = new Story();
		story.loadStory();

		String choice;
		boolean isProgress = false; //���࿩��

		do {
			menu.startMenu();
			System.out.println("���Ͻô� �׸��� �������ּ���.");
			
			choice = this.sc.nextLine().trim();
			
			switch (choice) {
			case "1":
				story.readOpenStory(); // ������ ���丮 �����ֱ�
				this.hero = this.event.newHero();//ĳ���ͻ���
				this.hero.hMove(); // ĳ���� �̵���Ű��
				gProgress();
				isProgress = true;
				break;

			case "2":
				System.out.println("�ҷ����⸦ �����ϼ̽��ϴ�.");
				this.hero = this.gLoad();
				this.story.storyIndex(hero);
				this.hero.hStatus();
				gProgress();
				isProgress = true;
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
		} while (!isProgress);
	}

	//��ġ���� ���� �������� �Լ�
	void gProgress() {
		String choice ="";
		do {
			switch (hero.gethPos()) { // hero ���� ��ġ�� ��������.
			case 2:
				story.gameStory(hero);
				Weapon pencil = new Weapon(2,"����");
				hero.hGet(pencil);
				hero.hMove();
				break;
			case 3:
				story.gameStory(hero); // �� Ʃ�丮�� 
				Armor note = new Armor(2, "������");
				hero.hGet(note);
				hero.hMove();
				break;
				
			case 4:	
			case 5:
				story.gameStory(hero);
				event.eBattle(hero); // �����Լ�ȣ�� ( ���ο��� ���� ��ġ üũ �� �´� ���� ����)
				choice = event.smallMonster(hero); // �������� ���� �� �޴�����
				if ( choice.equals("4")) this.gQuit();
				break;
				
			case 6:
				story.gameStory(hero);
				Weapon triangle = new Weapon(4,"�ﰢ��");
				event.igat(hero,triangle); //������ ���� ����
				hero.hMove();
				break;
				
			case 7:
				story.gameStory(hero);
				event.eBattle(hero); // �����Լ�ȣ�� ( ���ο��� ���� ��ġ üũ �� �´� ���� ����)
				
				do {
					choice = event.bigMonster(hero); // �������� ���� �� �޴�����
					if ( choice.equals("4")) this.gSave(hero);
				}while (choice.equals("4"));
				
				if ( choice.equals("5")) this.gQuit();
				break;
				
			case 8:
			case 9:
				story.gameStory(hero);
				event.eBattle(hero); // �����Լ�ȣ�� ( ���ο��� ���� ��ġ üũ �� �´� ���� ����)
				choice = event.smallMonster(hero); // �������� ���� �� �޴�����
				if ( choice.equals("4")) this.gQuit();
				break;
			
			case 10:
				story.gameStory(hero);
				Weapon compass = new Weapon(6,"���۽�");
				event.igat(hero,compass); //������ ���� ����
				hero.hMove();
				break;
				
			case 11:
				story.gameStory(hero);
				event.eBattle(hero); // �����Լ�ȣ�� ( ���ο��� ���� ��ġ üũ �� �´� ���� ����)
				
				do {
					choice = event.bigMonster(hero); // �������� ���� �� �޴�����
					if ( choice.equals("4")) this.gSave(hero);
				}while (choice.equals("4"));
				
				if ( choice.equals("5")) this.gQuit();
				break;
				
			case 12:
			case 13:
			case 14:
				story.gameStory(hero);
				event.eBattle(hero); // �����Լ�ȣ�� ( ���ο��� ���� ��ġ üũ �� �´� ���� ����)
				choice = event.smallMonster(hero); // �������� ���� �� �޴�����
				if ( choice.equals("4")) this.gQuit();
				break;
			
			case 15:
				story.gameStory(hero);
				Weapon calculator = new Weapon(10,"���п����");
				event.igat(hero,calculator); //������ ���� ����
				hero.hMove();
				break;
				
			case 16:
				story.gameStory(hero);
				event.eBattle(hero); // �����Լ�ȣ�� ( ���ο��� ���� ��ġ üũ �� �´� ���� ����)
				
				do {
					choice = event.bigMonster(hero); // �������� ���� �� �޴�����
					if ( choice.equals("4")) this.gSave(hero);
				}while (choice.equals("4"));
				
				if ( choice.equals("5")) this.gQuit();
				break;
				
			case 17:
				story.gameStory(hero);
				event.eBattle(hero); // �����Լ�ȣ�� ( ���ο��� ���� ��ġ üũ �� �´� ���� ����)
				System.out.println("[��]�� �ᱹ ������ ���� ��Ÿ��󽺸� ����ġ�� �θ���� ���� ��а����� ��� �Ǿ���...");
				this.sc.nextLine().trim();
				this.gQuit();
			}
		}while(true);
	}


	//���ӷε��Լ� �ϰ� �ϼ�
	Hero gLoad(){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File f = new File("C:\\LoC\\Save\\SaveFile.txt");
		long start = System.currentTimeMillis() ;

		try {
			if(f.exists()) {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				hero = (Hero)ois.readObject();
				Hero.mkHero(hero);
				this.hero.hMove();
				System.out.println("�ҷ����Ⱑ �Ϸ�Ǿ����ϴ�.");
			}else {
				System.out.println("���� ������ �����ϴ�.");
				System.out.println("ó������ ������ �����ϼ���.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000+"�� �ɸ�");
		return hero;
		
		
	}

	//���������Լ� �ϰ� �ϼ� 0919 1810 
	void gSave(Hero hero){
		long start = System.currentTimeMillis();
		this.hero.storyIndex(story);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		File f = new File("C:\\LoC\\Save\\SaveFile.txt");
		File fd = new File("C:\\LoC\\");
		File fd2 = new File("C:\\LoC\\Save\\");
		try {
			if(!fd.exists()) fd.mkdir();
			fd2.mkdir();
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(hero);

			System.out.println("������ �Ϸ�");

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000+"�� �ɸ�");
	}

	//���� �����Լ� ���� �Ϸ�
	void gQuit(){
		System.out.println("������ ����˴ϴ�.");
		System.exit(0);
	}

}
