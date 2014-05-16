package net.smktarunabhaktipenjualan.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.smktarunabhaktipenjualan.domain.barang;

public interface AppService {

	void saveBarang(barang b);
	
	void hapusBarang(barang b);
	

	Page<barang> cariSemuaBarang(Pageable p);
	
	barang cariBarangById(String id);
	
	Long countSemuaBarang();

	
}