package com.satish.jmx;

/**
 * 
 * @author satishkamavaram
 *
 */
public interface OperationMetricsMBean {

	public int sum(int a ,int b);
	
	public int getLastOperationValue();
	
	public int getOperationsCount();
	
}
