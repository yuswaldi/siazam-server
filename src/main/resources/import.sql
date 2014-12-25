insert into m_jenis_zakat (kode, nama, keterangan) values ('Z001', 'Zakat Fitrah', 'Zakat di Bulan Ramadhan');
insert into m_jenis_zakat (kode, nama, keterangan) values ('Z002', 'Zakat Maal', 'Zakat atas harta');
insert into m_jenis_zakat (kode, nama, keterangan) values ('Z003', 'Zakat Profesi', 'Zakat atas pendapatan');

insert into t_pembayaran_zakat_header (no_kwitansi, tanggal_kwitansi, nama_penyetor, alamat_penyetor) values ('0001', '2014/12/03', 'ALI', 'VMC');

insert into t_pembayaran_zakat_detail (id, id_pembayaran_zakat_header, id_jenis_zakat, id_satuan_zakat, keterangan) values ('123', '12345', 1, 1, 'Coba2');