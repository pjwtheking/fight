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

/**
 * <p>
 * 
 * 集合Util扩展类
 *
 * </p>
 * @author	jiangzuku 
 * @date	2016年7月19日 下午3:14:01
 * @version      
 */
public class CollectionUtilExtend {

    /**
     * 
     * <p>
     * 
     *
     *
     * </p>
     * @param source 被分割的list
     * @param max 每个list最多包含的元素
     * @return
     *  
     * @author	fangcang 
     * @date	2016年4月1日 下午3:32:59
     * @version
     */
    public static List<List<String>> subList(List<String> source, int max) {
	if(source==null || source.isEmpty()){
	    return null;
	}
	List<List<String>> result = new ArrayList<List<String>>();
	int totalCount = source.size();
	int fromIndex = 0;
	while (totalCount > max) {
	    result.add(source.subList(fromIndex, fromIndex + max));
	    totalCount = totalCount - max;
	    fromIndex = fromIndex + max;
	}
	result.add(source.subList(fromIndex, source.size()));
	return result;
    }
}
 