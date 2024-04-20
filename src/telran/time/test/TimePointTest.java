package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import telran.time.*;

class TimePointTest {

	@Test
	void testBetween() {
		TimePoint point1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point2 = new TimePoint(3600 * 20, TimeUnit.SECOND);
		TimePoint point3 = TimeUnit.MINUTE.between(point1, point2);
		assertEquals(600, point3.getAmount());
		TimePoint point4 = TimeUnit.SECOND.between(point1, point2);
		assertEquals(36000, point4.getAmount());
		TimePoint point5 = TimeUnit.HOUR.between(point1, point2);
		assertEquals(10, point5.getAmount());
	}
	@Test
	void convertTest() {
		TimePoint timePoint = new TimePoint(10, TimeUnit.HOUR);
		TimePoint point1Actual = timePoint.convert(TimeUnit.SECOND);
		assertEquals(36000, point1Actual.getAmount());
		TimePoint point1Actual1 = timePoint.convert(TimeUnit.MINUTE);
		assertEquals(600, point1Actual1.getAmount());
		
		timePoint = new TimePoint(600, TimeUnit.MINUTE);
		point1Actual= timePoint.convert(TimeUnit.HOUR);
		assertEquals(10, point1Actual.getAmount());
		point1Actual1= timePoint.convert(TimeUnit.SECOND);
		assertEquals(36000, point1Actual1.getAmount());
		
		timePoint = new TimePoint(36000, TimeUnit.SECOND);
		point1Actual= timePoint.convert(TimeUnit.HOUR);
		assertEquals(10, point1Actual.getAmount());
		point1Actual1= timePoint.convert(TimeUnit.MINUTE);
		assertEquals(600, point1Actual1.getAmount());
		
		point1Actual= timePoint.convert(TimeUnit.SECOND);
		assertEquals(36000, point1Actual.getAmount());
	}
	@Test
	void plusAdjusterTest() {
		TimePoint timePoint1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
		TimePoint actual = timePoint2.with(new PlusAdjuster(timePoint1));
		assertEquals(660, actual.getAmount());
		assertEquals(TimeUnit.MINUTE, actual.getTimeUnit());
	}
	@Test
	void timePointEqualsTest() {
		//TODO
	}
	@Test
	void timePointCompareToTest() {
		TimePoint timePoint1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
		TimePoint timePoint3 = new TimePoint(3600, TimeUnit.SECOND);
		assertTrue(timePoint1.compareTo(timePoint2)>0);
		assertTrue(timePoint2.compareTo(timePoint1)<0);
		assertFalse (timePoint2.compareTo(timePoint1)>0);
		assertEquals (timePoint2.compareTo(timePoint3),0);
	}
	@Test
	void futureProximityAdjusterTest() {
		//TODO
	}

}