package telran.time;

import java.util.Comparator;

import telran.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster{
	TimePoint[] timePoints;
	
	public FutureProximityAdjuster(TimePoint[] points) {
		this.timePoints = points;
}
	
	@Override
	public TimePoint adjust(TimePoint point) {
		TimePoint nextTimePointInTheFuture = null;
		TimePoint[] pointsInFuture = Arrays.search(timePoints, p -> p.convert(point.timeUnit).amount > point.amount);
		if(pointsInFuture.length>0) nextTimePointInTheFuture = Arrays.min(pointsInFuture, Comparator.naturalOrder());
		return nextTimePointInTheFuture;
	}
}