package com.c77.almakmur.web;

import com.c77.almakmur.domain.PembayaranZakatHeader;
import com.c77.almakmur.service.PembayaranZakatHeaderRepository;
import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

@RestController
@RequestMapping("/api")
public class PembayaranZakatHeaderController {
    
    @Autowired private PembayaranZakatHeaderRepository pembayaranZakatHeaderRepository;
    
    @RequestMapping(value = "/pembayaranzakat", method = RequestMethod.GET)
    @ResponseBody
//    public Page<PembayaranZakatHeader> findAll(Pageable pageable) {
//        return pembayaranZakatHeaderRepository.findAll(pageable);
//    }
    public List<PembayaranZakatHeader> findAll(Pageable pageable, HttpServletResponse response) {
        List<PembayaranZakatHeader> hasil = pembayaranZakatHeaderRepository.findAll(pageable).getContent();
        for (PembayaranZakatHeader p : hasil) {
            p.setZakatDetailSet(null);
        }
        return hasil;
    }
    
    @RequestMapping(value = "/pembayaranzakat/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PembayaranZakatHeader findById(@PathVariable String id) {
        PembayaranZakatHeader x = pembayaranZakatHeaderRepository.findOne(id);
        if (x == null) {
            throw new IllegalStateException();
        }
        x.setZakatDetailSet(null);
        return x;
    }
    
    @RequestMapping(value = "/pembayaranzakat/nokwitansi/{nokwitansi}", method = RequestMethod.GET)
    @ResponseBody
    public PembayaranZakatHeader findByNoKwitansi(@PathVariable String nokwitansi) {
        PembayaranZakatHeader x = pembayaranZakatHeaderRepository.findByNoKwitansi(nokwitansi);
        if (x == null) {
            throw new IllegalStateException();
        }
        x.setZakatDetailSet(null);
        return x;
    }
    
    @RequestMapping(value="/pembayaranzakat", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PembayaranZakatHeader pembayaranZakatHeader, HttpServletRequest request, HttpServletResponse response) {
        pembayaranZakatHeaderRepository.save(pembayaranZakatHeader);
        String newId = pembayaranZakatHeader.getId();
        String requestUrl = request.getRequestURI().toString();
        URI uri = new UriTemplate("{request}/{id}").expand(requestUrl, newId);
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/pembayaranzakat/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody PembayaranZakatHeader pembayaranZakatHeader) {
        PembayaranZakatHeader x = pembayaranZakatHeaderRepository.findOne(id);
        if (x == null) {
            throw new IllegalStateException("Tidak ada Kwitansi dengan ID " + id);
        }
        pembayaranZakatHeader.setId(x.getId());
        pembayaranZakatHeaderRepository.save(pembayaranZakatHeader);
    }
    
    @RequestMapping(value="/pembayaranzakat/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        pembayaranZakatHeaderRepository.delete(id);
    }
}
