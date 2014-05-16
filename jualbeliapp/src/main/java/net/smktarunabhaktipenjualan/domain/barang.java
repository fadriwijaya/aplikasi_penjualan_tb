package net.smktarunabhaktipenjualan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/*
 * @pemilik : Fadri
 * @java class barang
*/

@Entity
@Table(name="tbl_barang")
public class barang implements Serializable{
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid2")
	private String Id;
	
	@NotNull
	@Column(name="kode_barang", nullable = false, length = 5)
	private String kodeBarang;
	
	@NotNull
	@Column(name="nama_barang", nullable = false)
	private String namaBarang;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	
	
}
