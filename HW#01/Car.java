
public class Car {
	GPS myGPS;
	
	public void setGPS(GPS a) { myGPS = a; }
	public GPS getGPS() { return myGPS; }
	public void setCurrentSpeed(double a) { 
		myGPS.speed = a; 
	}
}
