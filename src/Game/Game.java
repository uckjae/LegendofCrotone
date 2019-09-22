/*
 Version : 2.4
 파일명 : Game.java
 작성일자 : 2019-09-21
 설명 : Game 실행을 위한 것들
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
	private static Game game; //싱글톤적용
	private Hero hero;//게임은 캐릭터를 가진다
	private Event event;//이벤트클래스
	private Menu menu;//메뉴클래스
	private FileOutputStream fos;//저장 불러오기를 위한 클래스
	private FileInputStream fis;//저장 불러오기를 위한 클래스
	private ObjectOutputStream oos;//저장 불러오기를 위한 클래스
	private ObjectInputStream ois;//저장 불러오기를 위한 클래스
	
	private Story story; // 스토리 불러오기위해서... 0919 2020 정하
	private Scanner sc; // 스캐너 0919 정하
	
	private Game() { // 생성자 스캐너 초기화
		this.sc = new Scanner(System.in);
	}
	
	//싱글톤적용
	public static Game gameStart() {
		if( game == null) {
			game = new Game();
		}
		return game;	
	}

	//게임실행 완료 // 0919 1636 정하 
	public void gStrart(){
		this.menu = new Menu();
		this.event = new Event();
		this.story = new Story();
		story.loadStory();

		String choice;
		boolean isProgress = false; //진행여부

		do {
			menu.startMenu();
			System.out.println("원하시는 항목을 선택해주세요.");
			
			choice = this.sc.nextLine().trim();
			
			switch (choice) {
			case "1":
				story.readOpenStory(); // 오프닝 스토리 보여주기
				this.hero = this.event.newHero();//캐릭터생성
				this.hero.hMove(); // 캐릭터 이동시키기
				gProgress();
				isProgress = true;
				break;

			case "2":
				System.out.println("불러오기를 선택하셨습니다.");
				this.hero = this.gLoad();
				this.story.storyIndex(hero);
				this.hero.hStatus();
				gProgress();
				isProgress = true;
				break;

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		} while (!isProgress);
	}

	//위치값에 따른 게임진행 함수
	void gProgress() {
		String choice ="";
		do {
			switch (hero.gethPos()) { // hero 현재 위치값 가져오기.
			case 2:
				story.gameStory(hero);
				Weapon pencil = new Weapon(2,"연필");
				hero.hGet(pencil);
				hero.hMove();
				break;
			case 3:
				story.gameStory(hero); // 방어구 튜토리얼 
				Armor note = new Armor(2, "연습장");
				hero.hGet(note);
				hero.hMove();
				break;
				
			case 4:	
			case 5:
				story.gameStory(hero);
				event.eBattle(hero); // 전투함수호출 ( 내부에서 별도 위치 체크 후 맞는 몬스터 출현)
				choice = event.smallMonster(hero); // 소형몬스터 종료 후 메뉴선택
				if ( choice.equals("4")) this.gQuit();
				break;
				
			case 6:
				story.gameStory(hero);
				Weapon triangle = new Weapon(4,"삼각자");
				event.igat(hero,triangle); //아이템 습득 선택
				hero.hMove();
				break;
				
			case 7:
				story.gameStory(hero);
				event.eBattle(hero); // 전투함수호출 ( 내부에서 별도 위치 체크 후 맞는 몬스터 출현)
				
				do {
					choice = event.bigMonster(hero); // 대형몬스터 종료 후 메뉴선택
					if ( choice.equals("4")) this.gSave(hero);
				}while (choice.equals("4"));
				
				if ( choice.equals("5")) this.gQuit();
				break;
				
			case 8:
			case 9:
				story.gameStory(hero);
				event.eBattle(hero); // 전투함수호출 ( 내부에서 별도 위치 체크 후 맞는 몬스터 출현)
				choice = event.smallMonster(hero); // 소형몬스터 종료 후 메뉴선택
				if ( choice.equals("4")) this.gQuit();
				break;
			
			case 10:
				story.gameStory(hero);
				Weapon compass = new Weapon(6,"컴퍼스");
				event.igat(hero,compass); //아이템 습득 선택
				hero.hMove();
				break;
				
			case 11:
				story.gameStory(hero);
				event.eBattle(hero); // 전투함수호출 ( 내부에서 별도 위치 체크 후 맞는 몬스터 출현)
				
				do {
					choice = event.bigMonster(hero); // 대형몬스터 종료 후 메뉴선택
					if ( choice.equals("4")) this.gSave(hero);
				}while (choice.equals("4"));
				
				if ( choice.equals("5")) this.gQuit();
				break;
				
			case 12:
			case 13:
			case 14:
				story.gameStory(hero);
				event.eBattle(hero); // 전투함수호출 ( 내부에서 별도 위치 체크 후 맞는 몬스터 출현)
				choice = event.smallMonster(hero); // 소형몬스터 종료 후 메뉴선택
				if ( choice.equals("4")) this.gQuit();
				break;
			
			case 15:
				story.gameStory(hero);
				Weapon calculator = new Weapon(10,"공학용계산기");
				event.igat(hero,calculator); //아이템 습득 선택
				hero.hMove();
				break;
				
			case 16:
				story.gameStory(hero);
				event.eBattle(hero); // 전투함수호출 ( 내부에서 별도 위치 체크 후 맞는 몬스터 출현)
				
				do {
					choice = event.bigMonster(hero); // 대형몬스터 종료 후 메뉴선택
					if ( choice.equals("4")) this.gSave(hero);
				}while (choice.equals("4"));
				
				if ( choice.equals("5")) this.gQuit();
				break;
				
			case 17:
				story.gameStory(hero);
				event.eBattle(hero); // 전투함수호출 ( 내부에서 별도 위치 체크 후 맞는 몬스터 출현)
				System.out.println("[그]는 결국 본인을 속인 피타고라스를 물리치고 부모님을 만나 비밀공식을 얻게 되었다...");
				this.sc.nextLine().trim();
				this.gQuit();
			}
		}while(true);
	}


	//게임로드함수 일겸 완성
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
				System.out.println("불러오기가 완료되었습니다.");
			}else {
				System.out.println("저장 파일이 없습니다.");
				System.out.println("처음부터 게임을 시작하세요.");
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
		System.out.println((end-start)/1000+"초 걸림");
		return hero;
		
		
	}

	//게임저장함수 일겸 완성 0919 1810 
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

			System.out.println("☆저장 완료");

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
		System.out.println((end-start)/1000+"초 걸림");
	}

	//게임 종료함수 정하 완료
	void gQuit(){
		System.out.println("게임이 종료됩니다.");
		System.exit(0);
	}

}
