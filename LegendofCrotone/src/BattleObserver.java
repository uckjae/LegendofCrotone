
public class BattleObserver implements Observer{

	@Override
	public void update(SuperEvent superEvent) {
		Character.mkCharacter("").cLvUp(Character.mkCharacter("").getcLv());
		
	}

}
