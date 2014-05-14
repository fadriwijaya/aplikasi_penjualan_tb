package net.smktarunabhaktipenjualan.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="jualbeli")
public class penjualan implements Serializable{
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String id;
	
	@Column(name="waktu_transaksi")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date tgl;
	
	@Column(nullable= false)
	private String kasir;
	
	@Column(name = "no_struk", nullable = false)
	private String noStruk;

	
	@OneToMany(mappedBy="jual")
	@Cascade(value =CascadeType.ALL)
	private List<penjualanDetail> listpenjualanDetail;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public String getKasir() {
		return kasir;
	}

	public void setKasir(String kasir) {
		this.kasir = kasir;
	}

	public String getNoStruk() {
		return noStruk;
	}

	public void setNoStruk(String noStruk) {
		this.noStruk = noStruk;
	}
	
	
	
}
