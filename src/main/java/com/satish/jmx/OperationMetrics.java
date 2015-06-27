package com.satish.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * 
 * @author satishkamavaram
 *
 */
public class OperationMetrics extends NotificationBroadcasterSupport implements OperationMetricsMBean {

	private int sum;
	private int operationCount;
	private int sequenceNumber;
	
	public int sum(int a, int b) {
		System.out.println("Performing sum of : "+a+" "+b);
		int oldOpCount = this.operationCount;
		operationCount++;
		this.sum = a+b;
		
		Notification notification = new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(), 
				"operationCount changed", "operationCount", "int", oldOpCount, this.operationCount) ;
		
		sendNotification(notification);
		return this.sum;
	}

	public int getLastOperationValue() {
		System.out.println("Getting last operation value");
		return this.sum;

	}

	public int getOperationsCount() {
		System.out.println("Getting total operation count");
		return this.operationCount;
	}

}
