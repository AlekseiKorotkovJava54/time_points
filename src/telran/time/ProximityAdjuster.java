package telran.time;

public class ProximityAdjuster implements TimePointAdjuster{
	TimePoint [] timePoints;
	
	public ProximityAdjuster(TimePoint[] timePoints) {
		this.timePoints = timePoints;
		// sorted
	}

	@Override
	public TimePoint adjust(TimePoint point) {
		// TODO Auto-generated method stub
		return null;
	}

}
