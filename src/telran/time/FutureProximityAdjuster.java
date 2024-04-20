package telran.time;

public class FutureProximityAdjuster implements TimePointAdjuster{
	TimePoint[] timePoints;
	
	public FutureProximityAdjuster(TimePoint[] points) {
		this.timePoints = points;
}
	
	@Override
	public TimePoint adjust(TimePoint point) {
		// TODO Auto-generated method stub
		return null;
	}

}