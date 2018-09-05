/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName VehicleFactory.java
 * @author Eric
 * @date 2018年8月31日 下午5:26:11  
 */
package com.eric.comm.design.factory;

/** 
 * @Description: 交通工具工厂

 * @author Eric
 * @date 2018年8月31日 下午5:26:11  
 */
public class VehicleFactory {
	
	public static IVehicle getVehicle(String VName){
		
		switch (VName.trim().toLowerCase()) {
		case "bus":
			return new Bus();
		case "train":
			return new Train();
		case "plane":
			return new Plane();
		default:
			return null;
		}
		
	}

}
