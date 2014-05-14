package net.smktarunabhaktipenjualan.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import net.smktarunabhaktipenjualan.domain.barang;

public interface AppService {

	void saveBarang(barang b);
	
	void hapusBarang(barang b);
	

	Page<barang> cariSemuaBarang(Pageable p);
	
	barang cariBarangById(String id);
	
	Long countSemuaBarang();
	
}
