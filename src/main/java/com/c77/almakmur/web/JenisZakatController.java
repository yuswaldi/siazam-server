package com.c77.almakmur.web;

import com.c77.almakmur.domain.JenisZakat;
import com.c77.almakmur.service.JenisZakatRepository;
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
public class JenisZakatController {
    
    @Autowired private JenisZakatRepository jenisZakatRepository;
    
    @RequestMapping(value="/jeniszakat", method = RequestMethod.GET)
    public Iterable<JenisZakat> allJenisZakat() {
        return jenisZakatRepository.findAll();
    }
    
    @RequestMapping(value="/jeniszakat/{id}", method = RequestMethod.GET)
    public JenisZakat findById(@PathVariable Long id) {
        return jenisZakatRepository.findOne(id);
    }
    
    @RequestMapping(value="/jeniszakat", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody JenisZakat jenisZakat, HttpServletRequest request, HttpServletResponse response) {
        jenisZakatRepository.save(jenisZakat);
        Long newId = jenisZakat.getId();
        String requestUrl = request.getRequestURI().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, newId);
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/jeniszakat/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody JenisZakat jenisZakat) {
        JenisZakat jz = jenisZakatRepository.findOne(id);
        if (jz == null) {
            throw new IllegalStateException("Tidak ada Jenis Zakat dengan ID " + id);
        }
        jenisZakat.setId(jz.getId());
        jenisZakatRepository.save(jenisZakat);
    }
    
    @RequestMapping(value="/jeniszakat/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        jenisZakatRepository.delete(id);
    }
}
