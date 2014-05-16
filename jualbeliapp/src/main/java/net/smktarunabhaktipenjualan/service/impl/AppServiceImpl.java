package net.smktarunabhaktipenjualan.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import net.smktarunabhaktipenjualan.dao.barangDao;
import net.smktarunabhaktipenjualan.domain.barang;
import net.smktarunabhaktipenjualan.service.AppService;


@SuppressWarnings("unchecked")
@Service("AppService")
@Transactional
public class AppServiceImpl implements AppService {

	
	
	@Autowired
	public barangDao barangdao;
	
	
	@Override
	public void saveBarang(barang b) {
		barangdao.save(b);
		
	}

	@Override
	public void hapusBarang(barang b) {
		if (b == null || b.getId() == null) {
			return;
		}
		barangdao.delete(b);
	}

	@Override
	public Page<barang> cariSemuaBarang(Pageable p) {
		if (p == null) {
			p = new PageRequest(0, 20);
		}
		return barangdao.findAll(p);
	}

	@Override
	public barang cariBarangById(String id) {
		if (!StringUtils.hasText(id)) {
				return null;
		}
		return barangdao.findOne(id);
	}

	@Override
	public Long countSemuaBarang() {
		return barangdao.count();
	}
	
}
