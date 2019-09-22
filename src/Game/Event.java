/*
 Version : 2.4
 ���ϸ� : Event.java
 �ۼ����� : 2019-09-21
 ���� : Eventó���� ���� �͵�
 */
package Game;

import java.util.Scanner;
import Item.Item;
import Monster.*;

class Event {
	private Monster monster;
	private Menu menu ;
	private Scanner sc;

	Event(){
		this.menu = new Menu();
		this.sc = new Scanner(System.in);
	}

	// ĳ���� ���� �Լ� //0919 1626 ����
	Hero  newHero() {
		String hName=null;
		
		do {
			System.out.println("\nĳ������ �̸��� �Է����ּ���. ");
			System.out.printf("�̸� : ");
			hName = this.sc.nextLine().trim();
			
		}while( hName.equals("") );
		
			Hero hero = Hero.mkHero(hName);
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.printf("\t�� %s �� ĳ���Ͱ� �����Ǿ����ϴ�.\n",hero.gethName());
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.printf("��� �����Ϸ��� Enter �� ��������.\n");

		
			return hero;
	}

	//������ �߰� ��  �Ϸ�//0920 1018 ����
	void igat(Hero hero, Item item) {
		this.menu.igetMenu(item);
		String choice = this.sc.nextLine().trim();
		switch (choice) {
		case "1":
			hero.hGet(item);
			this.sc.nextLine().trim();
			break;

		case "2":
			System.out.println("�������� �������� �ʰ� �������ϴ�.");
			break;
		default : 
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("\t�׳�  �������ϴ�");
			System.out.println("\t������ ������ �ٽ� ���ƿ��� �ʽ��ϴ�.�������ʹ� ���� �ܵ� ��������.");
			System.out.println("������������������������������������������������������������������������������������������");
			break;
		}
	}

	//�κ��丮���� ���� ������ ���ø޴� 0920 1443 ����
	void hinvenchoice(Hero hero) {
	//	int choiceInt = 0;
		boolean ischoice = false;
		do {
			System.out.println("������ ����� ������ ��ȣ�� �Է��ϼ���. (0 �޴��� ���ư���)");
			String choice = this.sc.nextLine().trim();
			//choiceInt = Integer.parseInt(choice);
			
			switch (choice) {
			case "0":
				ischoice = true;
				break;

			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "10":
				ischoice = hero.hUse(choice);
				//ischoice = choice.equals("0")||choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")||choice.equals("6")||choice.equals("7")||choice.equals("8")||choice.equals("9")||choice.equals("10");
				//this.sc.nextLine().trim();
				break;

			default:
				System.out.println("�ڡ١ڡ���������!!!�ڡ١ڡ�");
				break;
			}
			
		}while(!ischoice);
	}

	//�������� óġ �� ����
	String smallMonster(Hero hero) {
		String choice = "";

		do {
			menu.skMenu();
			choice = this.sc.nextLine().trim();

			switch (choice) {
			case "1":
				System.out.println("----------------------------------�̵����Դϴ�....��");
				hero.hMove();
				break;

			case "2":
				hero.hStatus();
				break;

			case "3":
				hero.hInventory();
				this.hinvenchoice(hero);
				break;

			case "4": 
				System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�.");
				break;

			default:
				System.out.println("�ڡ١ڡ���������!!!�ڡ١ڡ�");
				break;
			}
		}while( (!choice.equals("1") && !choice.equals("4")) );
		return choice;
	} 

	//�������� óġ �� ����
	String bigMonster(Hero hero) {
		String choice = "";

		do {
			menu.bkMenu();
			choice = this.sc.nextLine().trim();

			switch (choice) {
			case "1":
				System.out.println("----------------------------------�̵����Դϴ�....��");
				hero.hMove();
				System.out.println(hero.gethPos());
				break;

			case "2":
				hero.hStatus();
				break;

			case "3":
				hero.hInventory();
				this.hinvenchoice(hero);
				break;

			case "4":
				System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�.");
				System.out.println("������ �ϳ��� �����ϰ�, ���������� ���� �� ����� ó�� �˴ϴ�.");
				System.out.println("1. ���� 2 ���ư���");
				choice = this.sc.nextLine().trim();
				switch(choice) {
					case "1" :
						choice = "4";
						break;
					case "2":
						choice = "";
						System.out.println("�޴��� ���ư��ϴ�.");
						break;
				}
				break;

			case "5": 
				System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�.");
				break;

			default:
				System.out.println("�ڡ١ڡ���������!!!�ڡ١ڡ�");
				break;
			}
		}while( (!choice.equals("1") && !choice.equals("4") && !choice.equals("5") ) );
		return choice;
	} 

	void eBattle(Hero hero) {//�������� �Լ� 
		Monster monster = null; 
		switch(hero.gethPos()){//������� �����ǿ� ���� �����Ǵ� ������ ������ �ٸ�
			case 4:
			case 5: monster = new GumonMon();	break;
		
			case 7: monster = new AfterSchool(); break;

			case 8:
			case 9: monster = new SolutionMath(); break;

			case 11:monster = new NightSchool(); break;

			case 12:
			case 13:
			case 14:monster = new MokTest();break;

			case 16:monster = new RetryAcademy(); break;
			case 17:monster = new Boss();break;
		}
		
		while((hero.gethHp()>0) && (0 < monster.getmHp())) {// hero�� monster�� hp�� 0�� �ɶ� ���� �ݺ�
			
			//�����޴� �Լ�
			eHpInfo(hero,monster);//����ο� ������ ü�� �������� ����ϴ� �Լ�
			menu.bMenu();//�������ø޴�
			String choice = this.sc.nextLine().trim();
			
			
			switch (choice) {//���ݰ� ������ ����
				case "1"://���ݼ���
					menu.aMenu();
					String choice2 = this.sc.nextLine().trim();

					boolean isRight = false;
				
					switch (choice2) {
						case "1"://�⺻���ݼ���
							monster.quizCreate();
							isRight = monster.quiz();
							if (isRight) {
								hero.hAttack(monster);
							}
							break;
						
						case "2":// �ﰢ�Լ� ��ų ����

							if (hero.gethMp() >= 13) {//������ üũ
								monster.quizCreate();
								isRight = monster.quiz();
								if (isRight) hero.cSkillOne(monster);
								break;
							} else {
								System.out.println("Mp�� ���߶�!!");
								continue;//���� ������ ���ݹ����ʰ� �ٽ� ����ȭ������
							}
				
						case "3":// �̺����� ��ų����
							if (hero.gethMp() >= 18) {//������ üũ
								monster.quizCreate();
								isRight = monster.quiz();
								if (isRight) {
									hero.cSkillTwo(monster);
								}
								break;
							} else {
								System.out.println("Mp�� ���߶�!!");
								continue;
							}
						default://�߸��� ���ý�
							System.out.println("�ڡ١ڡ���������!!!�ڡ١ڡ�");
							continue;
					}
					break;
				case "2"://���� ���ý�
					boolean hasSomething = hero.hInventory();//���濡 ����� �ֳ� üũ
					if(hasSomething){
						this.hinvenchoice(hero);
						break;
					}else {
						
						continue;//���濡 ����� ������ �ٽ� ��������
					}

				default:
					System.out.println("�ڡ١ڡ���������!!!�ڡ١ڡ�");
					continue;
				}
				monster.mAttack(hero);
			}//���� loop ��
		if (hero.gethHp()<=0) {//hero�� hp�� 0���ϸ� ���
			eDeath();
		} else {
			System.out.println("������������������������������������������������������������������������������������������");
			System.out.println("���͸� óġ�Ͽ����ϴ�");
			System.out.println("������������������������������������������������������������������������������������������");
			hero.sethExp(hero.gethExp()+monster.getmExp());
			if(monster.getItem()!=null)this.igat(hero,monster.getItem());
		}
		hero.hLvUp();//��������� �������Լ� ȣ��
	}

	private void eDeath() {//ĳ���ͻ���Լ�
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("\t����Ͽ����ϴ�");
		System.out.println("\t�������������ᢸ����");
		System.out.println("������������������������������������������������������������������������������������������");
		System.exit(0);
	}

	//���� �� Hp ����Լ� ����
	private void eHpInfo(Hero hero,Monster monster) {
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("***"+hero.gethName()+"���� HP : " + hero.gethHp() +"/"+hero.gethMaxhp()+ " MP : "+hero.gethMp()+"/"+ hero.gethMaxmp() + " ����ġ : "+hero.gethExp()+ "***" +
				"\n"+"***"+ monster.getmName()+"�� HP : "+ monster.getmHp()+ "/"+ monster.getMaxHp() + " ����ġ : "+monster.getmExp()+"***");
		System.out.println("������������������������������������������������������������������������������������������");
	}

//	private Monster mkMonster(Hero hero) {
//	Monster result = null; 
//	switch(hero.gethPos()){
//	case 4:
//	case 5: result = new GumonMon(); 
//	System.out.println(result.getmName());
//	break;
//	case 7: result = new AfterSchool(); break;
//
//	case 8:
//	case 9: result = new SolutionMath(); break;
//
//	case 11:result = new NightSchool(); break;
//
//	case 12:
//	case 13:
//	case 14:result = new MokTest();break;
//
//	case 16:result = new RetryAcademy(); break;
//	case 17:result = new Boss();break;
//	}
//	return result;
//}

//public void eBattle(Hero hero) {//�����̺�Ʈ �Լ�
//	monster = mkMonster(hero);
//	battle(hero, monster);
//
//}
}

