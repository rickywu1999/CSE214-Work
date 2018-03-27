
public class GPS extends Car{
	Location current;
	Location destination;
	double speed;
	
	public void setCurrentLocation(Location a) { current = a; }
	public void setDestination(Location a) { destination = a; }
	public double getCalculatedDistance() {
		return Math.sqrt( Math.pow(destination.x - current.x, 2) + Math.pow(destination.y - current.y, 2));
	}
	public double getArrivalTime() {
		return getCalculatedDistance() / speed;
	}
	public String printCurrent() {
		return current.x + " " + current.y;
	}
	
	public String printDestination() {
		return destination.x + " " + destination.y;
	}
}
