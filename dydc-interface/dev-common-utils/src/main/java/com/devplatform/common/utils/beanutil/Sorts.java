package com.devplatform.common.utils.beanutil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorts {

	public static void sortByQuery(List<FieldBean> list) {
		Collections.sort(list, new Comparator<FieldBean>() {
			public int compare(FieldBean arg0, FieldBean arg1) {
				return arg1.getIsQuery().compareTo(arg0.getIsQuery());
			}
		});
	}

}
