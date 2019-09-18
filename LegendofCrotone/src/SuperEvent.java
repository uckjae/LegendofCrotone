import java.util.ArrayList;

public abstract class SuperEvent {
	//옵저버 패턴
	private ArrayList<Observer> observers = new ArrayList();
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	public void removeObserver(Observer observer){
	    observers.remove(observer);
	}
	public void notifyObserver() {
		for(Observer o:observers) {
			o.update(this);
		}
	}
	
	public abstract void eBattle(Character character);
}
