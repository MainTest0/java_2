package com.tenco.myblog2.service;

import com.tenco.myblog2.dao.ADAO;

public class AService {

	ADAO ad;

	public AService() {
		ad = new ADAO();
	}

	// ADAO 이동
	// AS에서 접근하려면 AD가 필요하다
	public String select(String msg) {
		// AS(null) --> AC(null)
		
		String result2 = ad.select(msg);
		return result2;
	}

}
