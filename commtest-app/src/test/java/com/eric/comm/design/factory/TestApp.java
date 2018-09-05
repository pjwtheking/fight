/**
 * CopyRright ©2018-2019 Eric All Right Reserved.
 * 
 * @fileName TestApp.java
 * @author Eric
 * @date 2018年8月31日 下午5:31:08  
 */
package com.eric.comm.design.factory;

import org.junit.Test;

/** 
 * @Description: 工厂模式测试

 * @author Eric
 * @date 2018年8月31日 下午5:31:08  
 */
public class TestApp {
	
	@Test
	public void testMain(){
		
		String vehicleName = "bus";
		IVehicle vehicle = VehicleFactory.getVehicle(vehicleName);
		if(vehicle == null){
			System.out.println("你选择的交通工具不存在");
			return;
		}
		vehicle.use();
		
	}

}
