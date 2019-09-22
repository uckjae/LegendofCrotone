/*
 Version : 2.4
 파일명 : Story.java
 작성일자 : 2019-09-21
 설명 : 게임스토리를 출력
 */
package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//정하
class Story {
	private FileReader fr; // 스토리 읽어오는 리더 0919 정하
	private BufferedReader br; // 스토리 읽어오는 버퍼 0919 정하
	private ArrayList<String> story;
	private int storyIndex; // 스토리인덱스 0919 정하
	private Scanner sc;

	Story() {
		this.sc = new Scanner(System.in);
	}
	
	void storyIndex(Hero hero) {
		this.storyIndex = hero.getStoryIndex();
	}

	// 불러오기 한 스토리 라인 저장 // 0920 정하
	void gameStory(Hero hero) {
		switch (hero.gethPos()) { // hero 현재 위치값 가져오기.
		case 2:
			this.readWeaponTutorialStory(); // 무기 튜토리얼 스토리 읽어오기
			break;
		case 3:
			this.readArmorTutorialStory(); // 방어구 튜토리얼 스토리 읽어오기
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


	// txt 스토리 파일을 읽어서 ArrayList 에 저장  완료
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
			System.out.println("스토리를 불러오지 못했습니다. 게임을 다시 실행해주세요.");
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				System.out.println("스토리를 불러오는 도중 에러가 발생했습니다. 게임을 다시 실행해주세요.");
				e.printStackTrace();
			}
		}
	}

	//오프닝 스토리 읽어오기  완료
	void readOpenStory() { 
		for ( this.storyIndex = 0; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("오프닝") ) { // 오프닝 까지만 출력
				System.out.println(this.story.get(this.storyIndex));

			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//무기 튜토리얼 스토리 읽어오기 완료
	void readWeaponTutorialStory() { 
		for ( this.storyIndex  = this.storyIndex ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("무기튜토리얼") ) { // 무기튜토리얼 까지만 출력
				System.out.println(this.story.get(this.storyIndex));

			} else {
				this.storyIndex++;
				return;
			}
		}

	}

	//방어구 튜토리얼 스토리 읽어오기 완료
	void readArmorTutorialStory() { 
		for ( this.storyIndex  = this.storyIndex ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("방어구튜토리얼") ) { // 방어구튜토리얼 까지만 출력
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}	
	}

	//삼각자 스토리 읽어오기
	void readTriangleStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("삼각자발견") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}	
	}
	
	//컴퍼스 스토리 읽어오기
	void readCompassStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("컴퍼스발견") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//공학용계산기 스토리 읽어오
	void readCalculatorStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("공학용계산기발견") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//1소형몬스터 스토리 읽어오기 완료 58
	void read1SmallMonsterStory() { 
		for ( this.storyIndex  = 58; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("1소형몬스터") ) { // 방어구튜토리얼 까지만 출력
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//1대형몬스터 스토리 읽어오기
	void read1BigMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("1대형몬스터") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//2소형몬스터 스토리 읽어오기 96
	void read2SmallMonsterStory() {
		for ( this.storyIndex  = 96 ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("2소형몬스터") ) { // 방어구튜토리얼 까지만 출력
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//2대형몬스터 스토리 읽어오기
	void read2BigMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("2대형몬스터") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//3소형몬스터 스토리 읽어오기 144
	void read3SmallMonsterStory() {
		for ( this.storyIndex  = 144 ; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("3소형몬스터") ) { // 방어구튜토리얼 까지만 출력
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}

	//3대형몬스터 스토리 읽어오기
	void read3BigMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("3대형몬스터") ) {
				System.out.println(this.story.get(this.storyIndex));
			} else {
				this.storyIndex++;
				return;
			}
		}
	}
	
	//보스몬스터 스토리 읽어오기
	void readBosMonsterStory() {
		for ( this.storyIndex  = this.storyIndex; this.storyIndex < this.story.size(); this.storyIndex++) {
			if ( this.story.get(this.storyIndex).equals("＃")) { // 특정 기호 만나면 출력 멈줬다가 아무키나 누르면 다시 출력
				this.sc.nextLine();
				this.storyIndex++; // ＃기호 출력 안하기 위해서
			}
			if ( !this.story.get(this.storyIndex).equals("보스") ) {
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