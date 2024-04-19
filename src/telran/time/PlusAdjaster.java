package telran.time;

public class PlusAdjaster implements TimePointAdjuster {
	TimePoint timePoint;
	
	public PlusAdjaster(TimePoint timePoint) {
		this.timePoint = timePoint;
	}

	@Override
	public TimePoint adjust(TimePoint point) {
		TimePoint pointSec = point.convert(TimeUnit.SECOND);
		TimePoint timePointSec = timePoint.convert(TimeUnit.SECOND);
		int sumSec = pointSec.getAmount() + timePointSec.getAmount();
		TimePoint resSec = new TimePoint(sumSec, TimeUnit.SECOND);
		return resSec.convert(point.getTimeUnit());
	}
}
