/**
 * Copyright (c) 2006-2015 Fangcang Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Fangcang. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Fangcang,http://www.fangcang.com.
 *  
 */
package com.eric.common.util;

import java.util.ArrayList;
import java.util.List;

import com.eric.common.dto.ConsistentHash;

/**
 * <p>
 * 
 * 
 * 
 * </p>
 * 
 * @author wd
 * @date 2016年3月24日 下午3:14:21
 * @version
 */
public class ConsistentHashUtils {

    private static final String NODE1 = "NODE_1";

    private static final String NODE2 = "NODE_2";

    private static final String NODE3 = "NODE_3";

    private static final String NODE4 = "NODE_4";

    private static final String NODE5 = "NODE_5";

    private static ConsistentHash<String> consistentHash;

    private static final Integer numberOfReplicas = 10000;
    
    private static List<String> nodes;

    static {
	nodes = new ArrayList<String>();
	nodes.add(NODE1);
	nodes.add(NODE2);
	nodes.add(NODE3);
	nodes.add(NODE4);
	nodes.add(NODE5);
	
	consistentHash = new ConsistentHash<String>(numberOfReplicas, nodes);
    }
    
    public static ConsistentHash<String> getInstance(){
	return consistentHash;
    }
    
    public static void main(String[] args) {
	String node= ConsistentHashUtils.getInstance().get("10087");
	System.out.println(node);
    }
}
