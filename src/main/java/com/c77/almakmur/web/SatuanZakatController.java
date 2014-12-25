package com.c77.almakmur.web;

import com.c77.almakmur.domain.SatuanZakat;
import com.c77.almakmur.service.SatuanZakatRepository;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

@RestController
@RequestMapping("/api")
public class SatuanZakatController {
    
    @Autowired private SatuanZakatRepository satuanZakatRepository;
    
    @RequestMapping(value = "/satuanzakat", method = RequestMethod.GET)
    public Iterable<SatuanZakat> allSatuanZakat() {
        return satuanZakatRepository.findAll();
    }
    
    @RequestMapping(value = "/satuanzakat/{id}", method = RequestMethod.GET)
    public SatuanZakat findById(@PathVariable Long id) {
        return satuanZakatRepository.findOne(id);
    }
    
    @RequestMapping(value = "/satuanzakat", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SatuanZakat satuanZakat, HttpServletRequest request, HttpServletResponse response) {
        satuanZakatRepository.save(satuanZakat);
        Long newId = satuanZakat.getId();
        String requestUrl = request.getRequestURI().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, newId);
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value = "/satuanzakat/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody SatuanZakat satuanZakat) {
        SatuanZakat sz = satuanZakatRepository.findOne(id);
        if (sz == null) {
            throw new IllegalStateException("Tidak ada Satuan Zakat dengan ID " + id);
        }
        satuanZakat.setId(sz.getId());
        satuanZakatRepository.save(satuanZakat);
    }
    
    @RequestMapping(value = "/satuanzakat/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        satuanZakatRepository.delete(id);
    }
}
