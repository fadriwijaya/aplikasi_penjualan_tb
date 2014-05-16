package net.smktarunabhakti.penjualan;

import net.smktarunabhaktipenjualan.domain.barang;
import net.smktarunabhaktipenjualan.service.AppService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
		private static ApplicationContext appCtx;
		private static AppService appService;
	
		public static void main(String[] args)
	{

		 appCtx = new ClassPathXmlApplicationContext("classpath:net/smktarunabhakti/penjualan/ApplicationContext.xml");
		 appService = (AppService) appCtx.getBean("AppService");
		 saveBarang();
	
	}
		private static void saveBarang()
		{
			barang b = new barang();
			b.setKodeBarang("12332");
			b.setNamaBarang("test");
			
			appService.saveBarang(b);
			
			
		}
}
