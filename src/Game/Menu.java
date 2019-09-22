/*
 Version : 2.4
 파일명 : Menu.java
 작성일자 : 2019-09-21
 설명 : 각종 메뉴들
 */
package Game;

import Item.Armor;
import Item.HpPotion;
import Item.Item;
import Item.MpPotion;
import Item.Weapon;

class Menu {
	void startMenu(){//시작메뉴
		System.out.println("─────────────────────────────────────────────");
		System.out.println("\tLegends of Crotone");
		System.out.println("─────────────────────────────────────────────");
		System.out.println("─────────────────────────────────────────────");
		System.out.println("\t▶ 1. 게임 새로 시작하기");
		System.out.println("\t▶ 2. 게임 불러오기");
		System.out.println("─────────────────────────────────────────────");
	}

	void skMenu() {//소형처치후 메뉴
		System.out.println("─────────────────────────────────────────────");
		System.out.println("1.이동하기 2.상태확인 3.가방보기 4.종료하기");
		System.out.println("─────────────────────────────────────────────");
	}

	void bkMenu() {//대형처치후메뉴
		System.out.println("─────────────────────────────────────────────");
		System.out.println("1.이동하기 2.상태확인 3.가방보기 4.저장하기 5.종료하기");
		System.out.println("─────────────────────────────────────────────");
	}

	void igetMenu(Item item) {//아이템획득시메뉴
		System.out.println("─────────────────────────────────────────────");
		System.out.printf("「%s」 아이템을 발견했습니다.\n", item.getiName());
		System.out.println("─────────────────────────────────────────────");
		//아이템 타입 다운캐스팅...
		if ( item instanceof Weapon) { 
			Weapon weapon = (Weapon)item;
			System.out.printf("\t종류 : 무기 / 공격력 : %d\n" ,weapon.getwAtt());
		} else if (item instanceof Armor) { 
			Armor armor = (Armor)item;
			System.out.printf("\t종류 : 방패 / 방어력 : %d\n",armor.getaDef());
		}else if ( item instanceof HpPotion) { 
			HpPotion hpPotion = (HpPotion)item;
			System.out.println("\t종류 : Hp포션 / 회복력 : " + hpPotion.getHpRecover());
		}else { 
			MpPotion mpPotion = (MpPotion)item;
			System.out.println("\t종류 : Mp포션 / 회복력 : " + mpPotion.getMpRecover());
		}
		System.out.println("─────────────────────────────────────────────");
		System.out.println("1. 줍기 \t 2. 지나가기");
	}

	void bMenu() {//전투시메뉴
		System.out.println("─────────────────────────────────────────────");
		System.out.println("1. 공격\t2.가방");
		System.out.println("─────────────────────────────────────────────");
	}

	void aMenu() {
		System.out.println("─────────────────────────────────────────────");
		System.out.println("1. 공격\t2.삼각함수\t3.미분적분");
		System.out.println("─────────────────────────────────────────────");
	}
}
