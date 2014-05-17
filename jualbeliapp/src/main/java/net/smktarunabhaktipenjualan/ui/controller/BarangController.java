
package net.smktarunabhaktipenjualan.ui.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import net.smktarunabhaktipenjualan.service.AppService;
import net.smktarunabhaktipenjualan.domain.barang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.net.URI;
import org.springframework.web.util.UriTemplate;


@Controller
public class BarangController {
    @Autowired
    private AppService appService;
    
    @RequestMapping(value = "/barang",method = RequestMethod.GET)
    @ResponseBody
    public List<barang> findAll(Pageable pageable,HttpServletResponse response){
        List<barang> hasil = appService.cariSemuaBarang(pageable).getContent();
        return hasil;
    }
    
    @RequestMapping("/barang/{id}")
    @ResponseBody
    public barang findbyId(@PathVariable String id){
        barang barang = appService.cariBarangById(id);
        if (barang==null){
            throw new IllegalStateException();
        }
        return barang;
    }
    
    @RequestMapping(value="/barang",method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid barang x,HttpServletRequest request,HttpServletResponse response){
        appService.saveBarang(x);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl,x.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
}