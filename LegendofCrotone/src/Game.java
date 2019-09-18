import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.tools.FileObject;

public class Game {
	private Character character;//게임은 캐릭터를 가진다
	private int[] pos;//이벤트가 발생하는 위치들의 배열
	private Event event;//이벤트클래스
	private Menu menu;//메뉴클래스
	FileOutputStream fos= null;//저장 불러오기를 위한 클래스
	FileInputStream fis = null;//저장 불러오기를 위한 클래스
	ObjectOutputStream oos = null;//저장 불러오기를 위한 클래스
	ObjectInputStream ois = null;//저장 불러오기를 위한 클래스
	
	void gStrart(){//게임실행함수
		
	}
	
	void gLoad(){//게임로드함수
		
	}
	
	void gSave(String filename){//게임저장함수 String은 파일명
		
	}
	
	void gStatus(Character character){//캐릭터정보조회 함수
		
	}
	
	void gInventory(Character character){//캐릭터 인벤토리 조회함수
		
	}
	
	void gQuit(){//게임 종료함수
		
	}
	
}
