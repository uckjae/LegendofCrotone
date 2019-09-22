/*
 Version : 2.4
 ���ϸ� : Menu.java
 �ۼ����� : 2019-09-21
 ���� : ���� �޴���
 */
package Game;

import Item.Armor;
import Item.HpPotion;
import Item.Item;
import Item.MpPotion;
import Item.Weapon;

class Menu {
	void startMenu(){//���۸޴�
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("\tLegends of Crotone");
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("\t�� 1. ���� ���� �����ϱ�");
		System.out.println("\t�� 2. ���� �ҷ�����");
		System.out.println("������������������������������������������������������������������������������������������");
	}

	void skMenu() {//����óġ�� �޴�
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("1.�̵��ϱ� 2.����Ȯ�� 3.���溸�� 4.�����ϱ�");
		System.out.println("������������������������������������������������������������������������������������������");
	}

	void bkMenu() {//����óġ�ĸ޴�
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("1.�̵��ϱ� 2.����Ȯ�� 3.���溸�� 4.�����ϱ� 5.�����ϱ�");
		System.out.println("������������������������������������������������������������������������������������������");
	}

	void igetMenu(Item item) {//������ȹ��ø޴�
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.printf("��%s�� �������� �߰��߽��ϴ�.\n", item.getiName());
		System.out.println("������������������������������������������������������������������������������������������");
		//������ Ÿ�� �ٿ�ĳ����...
		if ( item instanceof Weapon) { 
			Weapon weapon = (Weapon)item;
			System.out.printf("\t���� : ���� / ���ݷ� : %d\n" ,weapon.getwAtt());
		} else if (item instanceof Armor) { 
			Armor armor = (Armor)item;
			System.out.printf("\t���� : ���� / ���� : %d\n",armor.getaDef());
		}else if ( item instanceof HpPotion) { 
			HpPotion hpPotion = (HpPotion)item;
			System.out.println("\t���� : Hp���� / ȸ���� : " + hpPotion.getHpRecover());
		}else { 
			MpPotion mpPotion = (MpPotion)item;
			System.out.println("\t���� : Mp���� / ȸ���� : " + mpPotion.getMpRecover());
		}
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("1. �ݱ� \t 2. ��������");
	}

	void bMenu() {//�����ø޴�
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("1. ����\t2.����");
		System.out.println("������������������������������������������������������������������������������������������");
	}

	void aMenu() {
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("1. ����\t2.�ﰢ�Լ�\t3.�̺�����");
		System.out.println("������������������������������������������������������������������������������������������");
	}
}
