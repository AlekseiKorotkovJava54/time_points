package telran.time;

public class TimePoint implements Comparable<TimePoint>{
	int amount;
	TimeUnit timeUnit;
	
	public TimePoint(int amount, TimeUnit timeUnit) {
		this.amount = amount;
		this.timeUnit = timeUnit;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	
//	public TimePoint convert(TimeUnit unit) {
//		TimePoint convertTimePoint = new TimePoint(this.amount, unit);
//		if(this.timeUnit != unit) {
//			convertTimePoint= switch(this.timeUnit) {
//			case HOUR -> unit == TimeUnit.MINUTE ? 
//					new TimePoint(this.amount*unit.value, unit): new TimePoint(this.amount*this.timeUnit.value, unit);
//			case MINUTE -> unit == TimeUnit.HOUR ? 
//					new TimePoint(this.amount/this.timeUnit.value, unit): new TimePoint(this.amount*this.timeUnit.value, unit);
//			case SECOND -> new TimePoint(this.amount/unit.value, unit);
//			default  -> this;
//			};
//		}
//		return convertTimePoint;
//	}
	public TimePoint convert(TimeUnit unit) {
		TimePoint convertTimePoint = new TimePoint(amount, timeUnit);
		if(timeUnit != unit) {
			convertTimePoint= switch(timeUnit) {
			case HOUR -> unit == TimeUnit.MINUTE ? 
					new TimePoint(amount*unit.value, unit): new TimePoint(amount*timeUnit.value, unit);
			case MINUTE -> unit == TimeUnit.HOUR ? 
					new TimePoint(amount/timeUnit.value, unit): new TimePoint(amount*timeUnit.value, unit);
			case SECOND -> new TimePoint(amount/unit.value, unit);
			default  -> this;
			};
		}
		return convertTimePoint;
	}
	
	public TimePoint with(TimePointAdjuster adjuster) {
		return adjuster.adjust(this);
	}
	
	@Override
	public int compareTo(TimePoint o) {
		return Integer.compare(this.convert(TimeUnit.SECOND).amount, o.convert(TimeUnit.SECOND).amount);
	}
	
	@Override
	public boolean equals(Object obj) {
		return amount == ((TimePoint)obj).convert(timeUnit).amount;
	}

}