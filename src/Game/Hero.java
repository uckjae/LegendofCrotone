/*
 Version : 2.4
 ÆÄÀÏ¸í : Hero.java
 ÀÛ¼ºÀÏÀÚ : 2019-09-21
 ¼³¸í : Ä³¸¯ÅÍÀÇ ÇÊ¿äÇÑ ¸ðµç °Íµé
 */
package Game;

import java.io.Serializable;
import Item.Armor;
import Item.HpPotion;
import Item.Item;
import Item.MpPotion;
import Item.Weapon;
import Monster.Monster;

public class Hero implements Serializable{  //°´Ã¼ÀúÀåÀ» À§ÇØ Á÷·ÄÈ­Ã³¸® ÇÒ ¼ö ÀÖ°Ô
	private static Hero hero; //½Ì±ÛÅæÀû¿ë
	private int storyIndex; // ÀúÀå½Ã ÇöÀç ½ºÅä¸®ÁøÇàÀ§Ä¡
	private final String hName;//Ä³¸¯ÅÍÀÌ¸§
	private int hLv;//Ä³¸¯ÅÍ ·¹º§
	private int hMaxhp;//ÃÖ´ëHp
	private int hMaxmp;//ÃÖ´ëMp
	private int hHp;//ÇöÀç Hp
	private int hMp;//ÇöÀçmp
	private int hAtt;//ÄÉ¸¯ÅÍ °ø°Ý·Â
	private int hDef;//Ä³¸¯ÅÍ ¹æ¾î·Â
	private int hExp;//Ä³¸¯ÅÍ °æÇèÄ¡
	private int[] hLexp;//·¹º§¾÷¿¡ ÇÊ¿äÇÑ °æÇèÄ¡¸¦ ´ãÀ» ÇÔ¼ö //ÃÊ±âÈ­ 0918 ÀÌ¿íÀç 
	private int hPos;//Ä³¸¯ÅÍ ÇöÀçÀ§Ä¡
	private Item[] inventory;//¾ÆÀÌÅÛ ´ã´Â ÀÎº¥Åä¸®
	private Item[] item;//ÀåÂøÁßÀÎ ¾ÆÀÌÅÛ
	private int[][] hLStatus;//·¹º§¾÷¿¡µû¸¥ Ä³¸¯¼­ Status ¼³Á¤ °ª 0918 ÀÌ¿íÀç Ãß°¡

	//Ä³¸¯ÅÍ »ý¼º ½Ì±ÛÅæ
	private Hero(String hName) {//»ý¼º½Ã 1·¹º§
		this.hLStatus = new int[][] {{0,0,0,0},{50, 0, 15, 15},{60,50,20,20},{70,60,25,25},{80,70,30,30},{100,100,100,100}};
		this.hName = hName;
		this.hLv = 1;
		this.hMaxhp = hLStatus[1][0];
		this.hMaxmp = hLStatus[1][1]  ;
		this.hHp = this.hMaxhp;
		this.hMp = this.hMaxmp;
		this.hExp = 0;
		this.hAtt = hLStatus [1][2];
		this.hDef = hLStatus [1][3];
		this.hPos = 1;
		this.inventory = new Item[10];
		this.item = new Item[2];
		this.hLexp = new int[] {0,10,20,30,40};
	}

	//Ä³¸¯ÅÍ´Â ÇÏ³ª¸¸ ÀÖ¾î¾ßÇÔ ½Ì±ÛÅæ //ÇÔ¼öÀÌ¸§ º¯°æ0919
	static Hero mkHero(String hName) {
		if( hero == null) {
			hero = new Hero(hName);
		}
		return hero;	
	}
	//ºÒ·¯¿À±â ½Ã »ç¿ëÇÏ´Â ½Ì±ÛÅæ »ý¼º ÇÔ¼ö (¿À¹ö·Îµù)
	static Hero mkHero(Hero hero1) {
		hero = hero1;
		return hero;
	}

	//ÇöÀç ½ºÅä¸® ¶óÀÎ ÀúÀå ÇÔ¼ö //0920 Á¤ÇÏ
	void storyIndex(Story story) {
		this.storyIndex = story.getStoryIndex();
	}

	//°ø°ÝÇÔ¼ö ¿íÀç
	void hAttack(Monster monster) {
		int gap;
		int attPoint;
		if(hLv!=1){
			gap = hLStatus[this.hLv][2]-hLStatus[this.hLv-1][2];
			attPoint = (int)(Math.random()*gap) + hLStatus[this.hLv-1][2] + 1 - monster.getmDef(); //+ (Weapon)(item[0]).getwAtt;
			attPoint = item[0]==null? attPoint:attPoint+ ((Weapon)(item[0])).getwAtt();
			if(attPoint<0){
				attPoint =1;
			}


		}else{
			attPoint = (int)(Math.random()*2)+ hAtt;
		}
		System.out.println(attPoint+"ÀÇ ÇÇÇØ¸¦ ÀÔÇû´Ù");
		monster.setmHp(monster.getmHp()-attPoint);// -= attPoint;
	}

	//±ÙÀÇ°ø½Ä ½ºÅ³ ¿íÀç
	void cSkillOne(Monster monster) {
		int attPoint = (int)(Math.random()*hLStatus[this.hLv][2])+13;
		this.hMp-=10;
		System.out.println("     *      _______________");
		System.out.println("   *   *   {  sin©÷+cos©÷=1!!! )");
		System.out.println("     *      \\_______________/ ");
		System.out.println("  *  *  *     ½´½´½´½µ!!");
		System.out.println(" *   *    *");
		System.out.println("     *     ");
		System.out.println("  *  *  *  ");
		System.out.println(" *       * ");
		System.out.println(" *       * ");
		System.out.println("*********************");
		System.out.println("**"+attPoint+"ÀÇ ÇÇÇØ¸¦ ÀÔÇû´Ù**");
		System.out.println("*********************");
		monster.setmHp(monster.getmHp()-attPoint);
		//sin©÷+cos©÷=1
	}

	//¹ÌºÐÀûºÐ ½ºÅ³ ¿íÀç
	void cSkillTwo(Monster monster) {
		int attPoint = (int)(Math.random()*hLStatus[this.hLv][2])+18;
		this.hMp-=15;
		System.out.println("     *      _______________");
		System.out.println("   *   *   {  ¡òf(x)dx!!!!!!! )");
		System.out.println("     *      \\_______________/ ");
		System.out.println("  *  *  *     ÄâÄâÄç!!");
		System.out.println(" *   *    *");
		System.out.println("     *     ");
		System.out.println("  *  *  *  ");
		System.out.println(" *       * ");
		System.out.println(" *       * ");
		System.out.println(attPoint+"ÀÇ ÇÇÇØ¸¦ ÀÔÇû´Ù");
		System.out.println("***************");
		System.out.println("**"+attPoint+"ÀÇ ÇÇÇØ¸¦ ÀÔÇû´Ù**");
		System.out.println("***************");
		monster.setmHp(monster.getmHp()-attPoint);
	}

	// »ç¿ëÁßÀÌ´ø ¾ÆÀÌÅÛ Ã¢°í¿¡ ³Ö¾îÁÖ±â //0919 ±èÁ¤ÇÏ Ãß°¡
	void hUseInventory(Item item) { 
		//int count = 0; // Ã¢°í¿¡ ¾ÆÀÌÅÛÀÌ µéÀº ¹æÀÇ °¹¼öÃ¼Å©
		for ( int index = 0; index < this.inventory.length ; index++) { // Ã¢°í°¹¼ö¸¸Å­ for ¹® ½ÇÇà
			if(this.inventory[index] == null) { // Ã¢°í°¡ ºñ¾îÀÖÀ¸¸é
				this.inventory[index] = item;
				System.out.printf("%s °¡¹æ¿¡ ³Ö¾ú½À´Ï´Ù.\n",this.inventory[index].getiName());
				return;
			}
		}
	}

	//¾ÆÀÌÅÛ»ç¿ëÇÔ¼ö Á¤ÇÏ 0919 1523 ¼öÁ¤
	boolean hUse(String choice) { 
		boolean ischoice = false;
		Item item = hItemDelete(choice); // ¼±ÅÃÇÑ ¾ÆÀÌÅÛÀ» Ã¢°í¿¡¼­ Á¦°Å

		if( item != null ) {
			ischoice = true;
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡\n");
			if ( item instanceof Weapon) { //»ç¿ëÇÑ ¾ÆÀÌÅÛÀÌ ¹«±â¸é item ¹è¿­ 0¹ø¹æ¿¡ ³Ö°í ´Ù¿îÄ³½ºÆÃ ÈÄ °ø°Ý·Â °¡Á®¿Í¼­ ´õÇØÁÖ±â
				Weapon newWeapon = (Weapon)item;
				if ( this.item[0] != null) {
					hUseInventory(this.item[0]); // Âø¿ëÁß ¾ÆÀÌÅÛ ÀÎº¥Åä¸®·Î
					Weapon oldWeapon = (Weapon)this.item[0];
					this.hAtt -= oldWeapon.getwAtt();
					System.out.printf("%s ÀåÂøÇØÁ¦!!\n (°ø°Ý·ÂÀÌ ¡¼%d¡½ °¨¼ÒµÇ¾ú½À´Ï´Ù.)\n\n",oldWeapon.getiName(),oldWeapon.getwAtt());
				}			
				this.item[0] = item;
				this.hAtt += newWeapon.getwAtt();
				System.out.printf("%s ÀåÂø¿Ï·á!!\n (°ø°Ý·ÂÀÌ ¡¼%d¡½ Áõ°¡µÇ¾ú½À´Ï´Ù.)\n\n",newWeapon.getiName(),newWeapon.getwAtt());
			} else if (item instanceof Armor) { // ¹æ¾î±¸¸é item ¹è¿­ 1¹ø¹æ¿¡ ³Ö°í ´Ù¿îÄ³½ºÆÃ ÈÄ ¹æ¾î·Â °¡Á®¿Í¼­ ´õÇØÁÖ±â
				Armor newArmor = (Armor)item;
				if ( this.item[1] != null) {
					hUseInventory(this.item[1]); // Âø¿ëÁß ¾ÆÀÌÅÛ ÀÎº¥Åä¸®·Î
					Armor oldArmor = (Armor)this.item[1];
					this.hDef -= oldArmor.getaDef();
					System.out.printf("%s ÀåÂø¿Ï·á!!\n (¹æ¾î·ÂÀÌ ¡¼%d¡½ °¨¼ÒµÇ¾ú½À´Ï´Ù.)\n\n",oldArmor.getiName(),oldArmor.getaDef());
				}
				this.item[1] = item;
				this.hDef += newArmor.getaDef();
				System.out.printf("%s ÀåÂø¿Ï·á!!\n (¹æ¾î·ÂÀÌ ¡¼%d¡½ Áõ°¡µÇ¾ú½À´Ï´Ù.)\n\n",newArmor.getiName(),newArmor.getaDef());
			}else if ( item instanceof HpPotion) { //HPÆ÷¼ÇÀÌ¸é È¸º¹·® °¡Á®¿Í¼­ ´õÇØÁÖ±â
				HpPotion hpPotion = (HpPotion)item;

				if ( (this.hHp+hpPotion.getHpRecover()) > this.hMaxhp ) { // Æ÷¼ÇÀ» ¸Ô¾î¼­ Áõ°¡ÇÑ HP°¡ ÃÖ´ëHP º¸´Ù Å©¸é ÃÖ´ë HP±îÁö¸¸ Ç¥½ÃÇØÁÖ±â
					this.hHp = this.hMaxhp;
				} else {
					this.hHp += hpPotion.getHpRecover();
				}
				System.out.printf("%s »ç¿ë¿Ï·á!!\n(HP°¡ ¡¼%d¡½ È¸º¹µÇ¾ú½À´Ï´Ù.)\n",hpPotion.getiName(),hpPotion.getHpRecover());
			}else { // Mp Æ÷¼ÇÀÌ¸é È¸º¹·® °¡Á®¿Í¼­ ´õÇØÁÖ±â
				MpPotion mpPotion = (MpPotion)item;

				if ( (this.hMp+mpPotion.getMpRecover()) > this.hMaxmp ) { // Æ÷¼ÇÀ» ¸Ô¾î¼­ Áõ°¡ÇÑ MP°¡ ÃÖ´ëMP º¸´Ù Å©¸é ÃÖ´ë MP±îÁö¸¸ Ç¥½ÃÇØÁÖ±â
					this.hMp = this.hMaxmp;
				} else {
					this.hMp += mpPotion.getMpRecover();
				}
				System.out.printf("%s »ç¿ë¿Ï·á!!\n(MP°¡ ¡¼%d¡½ È¸º¹µÇ¾ú½À´Ï´Ù.)\n",mpPotion.getiName(), mpPotion.getMpRecover());
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		}
		return ischoice;
		
	}

	//·¹º§¾÷ÇÔ¼ö ¿íÀç
	void hLvUp() {
		if(hero.hExp>hLexp[hLv]) {
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("·¹º§¾÷ ÇÏ¿´½À´Ï´Ù");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			this.hLv++;
			this.hMaxhp = hLStatus[hLv][0];
			this.hHp = this.hMaxhp;
			this.hMaxmp = hLStatus[hLv][1];
			this.hMp = this.hMaxmp;
			this.hExp = 0;
			this.hAtt = hLStatus[hLv][2];
			this.hDef = hLStatus[hLv][3];

		}
	}

	//Ä³¸¯ÅÍ ÀÌµ¿ÇÔ¼ö Á¤ÇÏ
	void hMove() {
		hPos++;
	}

	//¾ÆÀÌÅÛ È¹µæÇÔ¼ö Á¤Àº // ´ã±â¸¦ ¼±ÅÃÇÒ ½Ã Á¤Àº // 0920 0937
	void hGet(Item item) { 
		int i;
		for (i = 0; i < inventory.length; i++) {// ÀÎº¥Åä¸®°¡ ºñ¾îÀÖ´Ù¸é
			if (inventory[i] == null) {
				inventory[i] =item; // ¾ÆÀÌÅÛÀ» ³Ö¾î ÁÜ
				System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
				System.out.println("¡¸ "+hero.hName + " ¡¹ ´ÔÀº " + item.getiName() + "À» È¹µæÇß½À´Ï´Ù.");
				System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
				System.out.println("¢¹ °¡¹æ¿¡ [" + item.getiName() + "] Ãß°¡");
				break;
			}
		}

		if (i >= inventory.length) { //ÀÎº¥Åä¸®°¡ °¡µæ Ã¡´Ù¸é
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("\t°¡¹æÀÌ °¡µæ Â÷ ÀÖ¾î ´õÀÌ»ó ´ãÀ» ¼ö ¾ø½À´Ï´Ù.");
			System.out.println("\tÁö³ª°£ ¹ö½º´Â ´Ù½Ã µ¹¾Æ¿ÀÁö ¾Ê½À´Ï´Ù.´ÙÀ½ºÎÅÍ´Â Á¤½Å ´Üµð Â÷¸®¼¼¿ä.");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		}
	}

	//Ä³¸¯ÅÍ ÀÎº¥Åä¸® Á¶È¸ÇÔ¼ö ±¤¹Î ¿Ï¼º
	boolean hInventory(){
		int count = 0;
		boolean hasSomething = true;
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("\t\t¡º  °¡  ¹æ  ¡»");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < this.inventory.length; i++) {
			if (this.inventory[i] != null) {
				System.out.printf("\t¡¶(%d)¡· %s\n",(i+1),this.inventory[i].getiName());
				System.out.println("-------------------------------------------");
				count++;
			}
		}
		if ( count == 0 ) {
			hasSomething = false;
			System.out.println("µé¾îÀÖ´Â ¾ÆÀÌÅÛÀÌ ¾ø½À´Ï´Ù.");
		}
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		return hasSomething;
	}

	//Ä³¸¯ÅÍÁ¤º¸Á¶È¸ ÇÔ¼ö ±¤¹Î ¿Ï¼º
	void hStatus(){
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("\tÇöÀçLv : " + this.hLv);
		System.out.println("\tÇöÀçHP : " + this.hHp +" / " + this.hMaxhp);
		System.out.println("\tÇöÀçMP : " + this.hMp +" / " + this.hMaxmp);
		System.out.println("\tÇöÀç°æÇèÄ¡ : " + this.hExp);
		System.out.println("\tÇöÀç°ø°Ý·Â : " + this.hAtt);
		System.out.println("\tÇöÀç¹æ¾î·Â : " + this.hDef);
				
		if ( this.item[0] != null ) System.out.println("\tÇöÀç Âø¿ëÁßÀÎ ¹«±â : " + this.item[0].getiName());
		if( this.item[1] != null) System.out.println("\tÇöÀç Âø¿ëÁßÀÎ ¹æ¾î±¸ : " + this.item[1].getiName());
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}

	// ¼±ÅÃÇÑ ¾ÆÀÌÅÛÀ» Ã¢°í¿¡¼­ »èÁ¦ item return //0919 ±èÁ¤ÇÏ Ãß°¡
	Item hItemDelete(String choice) { 
		Item item = null;
		int choiceInt = (Integer.parseInt(choice))-1;

		if ( this.inventory[choiceInt] != null ) {
			item = this.inventory[choiceInt];
			this.inventory[choiceInt] = null;
			System.out.println("°¡¹æ¿¡¼­ ²¨³Â´Ù");
		} else {
			System.out.println("¡Ú¡Ù¡Ú¡ÙÁ¤½ÅÂ÷·Á!!¡Ú¡Ù¡Ú¡Ù");
		}
		//System.out.printf("%s ¾ÆÀÌÅÛÀ» °¡¹æ¿¡¼­ ²¨³Â½À´Ï´Ù.\n",item.getiName());
		return item;
	}

	//----------------------------------------------getter setter----------------------------------

	// mAttack() ¿¡¼­ »ç¿ë //0919 ÀÌ¿íÀç
	public int gethHp() {
		return hHp;
	}

	// mAttack() ¿¡¼­ »ç¿ë //0919 ÀÌ¿íÀç
	public void sethHp(int hHp) {
		this.hHp = hHp;
	}

	// mAttack() ¿¡¼­ »ç¿ë //0919 ÀÌ¿íÀç
	public int gethDef() {
		return hDef;
	}

	// eHpInfo(Hero hero) ¿¡¼­ »ç¿ë //0919 Á¤Àº
	public String gethName() {
		return hName;
	}

	public int gethMp() {
		return hMp;
	}

	public int gethExp() {
		return hExp;
	}

	public int gethPos() {
		return hPos;
	}

	//¿íÀç»ç¿ë
	public void sethExp(int hExp) {
		this.hExp = hExp;
	}

	// Á¤ÇÏ»ç¿ë
	public int getStoryIndex() {
		return storyIndex;
	}
	
	//ÀüÅõ½Ã hpInfoÇÔ¼ö¿¡ »ç¿ë 0921 ÀÌ¿íÀç
	public int gethMaxhp() {
		return hMaxhp;
	}
	
	//ÀüÅõ½Ã hpInfoÇÔ¼ö¿¡ »ç¿ë 0921 ÀÌ¿íÀç
	public int gethMaxmp() {
		return hMaxmp;
	}
	

}
