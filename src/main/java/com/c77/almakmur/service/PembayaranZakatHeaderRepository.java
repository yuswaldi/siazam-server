package com.c77.almakmur.service;

import com.c77.almakmur.domain.PembayaranZakatHeader;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PembayaranZakatHeaderRepository extends PagingAndSortingRepository<PembayaranZakatHeader, String>{
    PembayaranZakatHeader findByNoKwitansi(String noKwitansi);
}
