/*
 Version : 2.4
 파일명 : Event.java
 작성일자 : 2019-09-21
 설명 : Event처리를 위한 것들
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

	// 캐릭터 생성 함수 //0919 1626 정하
	Hero  newHero() {
		String hName=null;
		
		do {
			System.out.println("\n캐릭터의 이름을 입력해주세요. ");
			System.out.printf("이름 : ");
			hName = this.sc.nextLine().trim();
			
		}while( hName.equals("") );
		
			Hero hero = Hero.mkHero(hName);
			System.out.println("─────────────────────────────────────────────");
			System.out.printf("\t「 %s 」 캐릭터가 생성되었습니다.\n",hero.gethName());
			System.out.println("─────────────────────────────────────────────");
			System.out.printf("계속 진행하려면 Enter 를 누르세요.\n");

		
			return hero;
	}

	//아이템 발견 시  완료//0920 1018 정하
	void igat(Hero hero, Item item) {
		this.menu.igetMenu(item);
		String choice = this.sc.nextLine().trim();
		switch (choice) {
		case "1":
			hero.hGet(item);
			this.sc.nextLine().trim();
			break;

		case "2":
			System.out.println("아이템을 습득하지 않고 지나갑니다.");
			break;
		default : 
			System.out.println("─────────────────────────────────────────────");
			System.out.println("\t그냥  지나갑니다");
			System.out.println("\t지나간 버스는 다시 돌아오지 않습니다.다음부터는 정신 단디 차리세요.");
			System.out.println("─────────────────────────────────────────────");
			break;
		}
	}

	//인벤토리보기 이후 아이템 선택메뉴 0920 1443 정하
	void hinvenchoice(Hero hero) {
	//	int choiceInt = 0;
		boolean ischoice = false;
		do {
			System.out.println("아이템 사용할 아이템 번호를 입력하세요. (0 메뉴로 돌아가기)");
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
				System.out.println("★☆★☆정신차려!!!★☆★☆");
				break;
			}
			
		}while(!ischoice);
	}

	//소형몬스터 처치 후 선택
	String smallMonster(Hero hero) {
		String choice = "";

		do {
			menu.skMenu();
			choice = this.sc.nextLine().trim();

			switch (choice) {
			case "1":
				System.out.println("----------------------------------이동중입니다....★");
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
				System.out.println("종료하기를 선택하셨습니다.");
				break;

			default:
				System.out.println("★☆★☆정신차려!!!★☆★☆");
				break;
			}
		}while( (!choice.equals("1") && !choice.equals("4")) );
		return choice;
	} 

	//대형몬스터 처치 후 선택
	String bigMonster(Hero hero) {
		String choice = "";

		do {
			menu.bkMenu();
			choice = this.sc.nextLine().trim();

			switch (choice) {
			case "1":
				System.out.println("----------------------------------이동중입니다....★");
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
				System.out.println("저장하기를 선택하셨습니다.");
				System.out.println("저장은 하나만 가능하고, 기존파일이 있을 시 덮어쓰기 처리 됩니다.");
				System.out.println("1. 저장 2 돌아가기");
				choice = this.sc.nextLine().trim();
				switch(choice) {
					case "1" :
						choice = "4";
						break;
					case "2":
						choice = "";
						System.out.println("메뉴로 돌아갑니다.");
						break;
				}
				break;

			case "5": 
				System.out.println("종료하기를 선택하셨습니다.");
				break;

			default:
				System.out.println("★☆★☆정신차려!!!★☆★☆");
				break;
			}
		}while( (!choice.equals("1") && !choice.equals("4") && !choice.equals("5") ) );
		return choice;
	} 

	void eBattle(Hero hero) {//전투로직 함수 
		Monster monster = null; 
		switch(hero.gethPos()){//히어로의 포지션에 따라 생성되는 몬스터의 종류가 다름
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
		
		while((hero.gethHp()>0) && (0 < monster.getmHp())) {// hero나 monster의 hp가 0이 될때 까지 반복
			
			//전투메뉴 함수
			eHpInfo(hero,monster);//히어로와 몬스터의 체력 정보등을 출력하는 함수
			menu.bMenu();//전투선택메뉴
			String choice = this.sc.nextLine().trim();
			
			
			switch (choice) {//공격과 가방중 선택
				case "1"://공격선택
					menu.aMenu();
					String choice2 = this.sc.nextLine().trim();

					boolean isRight = false;
				
					switch (choice2) {
						case "1"://기본공격선택
							monster.quizCreate();
							isRight = monster.quiz();
							if (isRight) {
								hero.hAttack(monster);
							}
							break;
						
						case "2":// 삼각함수 스킬 선택

							if (hero.gethMp() >= 13) {//마나량 체크
								monster.quizCreate();
								isRight = monster.quiz();
								if (isRight) hero.cSkillOne(monster);
								break;
							} else {
								System.out.println("Mp가 모잘라!!");
								continue;//마나 부족시 공격받지않고 다시 선택화면으로
							}
				
						case "3":// 미분적분 스킬선택
							if (hero.gethMp() >= 18) {//마나량 체크
								monster.quizCreate();
								isRight = monster.quiz();
								if (isRight) {
									hero.cSkillTwo(monster);
								}
								break;
							} else {
								System.out.println("Mp가 모잘라!!");
								continue;
							}
						default://잘못된 선택시
							System.out.println("★☆★☆정신차려!!!★☆★☆");
							continue;
					}
					break;
				case "2"://가방 선택시
					boolean hasSomething = hero.hInventory();//가방에 든것이 있나 체크
					if(hasSomething){
						this.hinvenchoice(hero);
						break;
					}else {
						
						continue;//가방에 든것이 없으면 다시 선택으로
					}

				default:
					System.out.println("★☆★☆정신차려!!!★☆★☆");
					continue;
				}
				monster.mAttack(hero);
			}//전투 loop 끝
		if (hero.gethHp()<=0) {//hero의 hp가 0이하면 사망
			eDeath();
		} else {
			System.out.println("─────────────────────────────────────────────");
			System.out.println("몬스터를 처치하였습니다");
			System.out.println("─────────────────────────────────────────────");
			hero.sethExp(hero.gethExp()+monster.getmExp());
			if(monster.getItem()!=null)this.igat(hero,monster.getItem());
		}
		hero.hLvUp();//전투종료시 레벨업함수 호출
	}

	private void eDeath() {//캐릭터사망함수
		System.out.println("─────────────────────────────────────────────");
		System.out.println("\t사망하였습니다");
		System.out.println("\t▶▶▶게임종료◀◀◀");
		System.out.println("─────────────────────────────────────────────");
		System.exit(0);
	}

	//전투 중 Hp 출력함수 정은
	private void eHpInfo(Hero hero,Monster monster) {
		System.out.println("─────────────────────────────────────────────");
		System.out.println("***"+hero.gethName()+"님의 HP : " + hero.gethHp() +"/"+hero.gethMaxhp()+ " MP : "+hero.gethMp()+"/"+ hero.gethMaxmp() + " 경험치 : "+hero.gethExp()+ "***" +
				"\n"+"***"+ monster.getmName()+"의 HP : "+ monster.getmHp()+ "/"+ monster.getMaxHp() + " 경험치 : "+monster.getmExp()+"***");
		System.out.println("─────────────────────────────────────────────");
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

//public void eBattle(Hero hero) {//전투이벤트 함수
//	monster = mkMonster(hero);
//	battle(hero, monster);
//
//}
}

