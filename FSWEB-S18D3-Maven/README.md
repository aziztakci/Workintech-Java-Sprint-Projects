# SQL Sorgu Alıştırmaları

Bu hafta SQL sorguları üzerine çalışıyorsunuz. Bugünkü alıştırmada sizin için hazırladığımız veritabanında aşağıda istediğimiz sonuçları elde etmenize yarayan SQL sorgularını oluşturacaksınız.

# Proje Kurulumu
Projeyi forklayın ve clonlayın. Tamamladığınızda da pushlayın.

## Kütüphane Bilgi Sistemi

* Spring Data Jpa ve Postgresql driver dependencyleri sisteme ekleyiniz.
Veri tabanına bağlanabilmek için :
* `application.properties` dosyasında `spring.datasource.username` karşısına veritabanını bağlanmak için kullandığınız kullanıcı ismini MUTLAKA GİRİNİZ.
* `application.properties` dosyasında `spring.datasource.password` karşısına veritabanını bağlanmak için kullandığınız şifreyi MUTLAKA GİRİNİZ.

### Görevler

	1) Veri tabanınız içerisinde doctor adında bir tablo oluşturun. 
		Tabloda(id: bigint, name: character varying, surname: character varying, proficiency: character varying) kolonları olmalıdır.
        id kolonu PRİMARY KEY ve auto-increment olmalıdır.	

	2) Veri tabanınız içerisinde nurse adında bir tablo oluşturun. 
		Tabloda(id: bigint, name: character varying, surname: character varying, proficiency: character varying) kolonları olmalıdır.
        id kolonu PRİMARY KEY ve auto-increment olmalıdır.

	3) Veri tabanınız içerisinde patient adında bir tablo oluşturun.
		Tabloda(id: bigint, name: character varying, surname: character varying, email: character varying, complaint: text) kolonları olmalıdır.
        id kolonu PRİMARY KEY ve auto-increment olmalıdır.	

	4) Veri tabanınız içerisinde surgery adında bir tablo oluşturun.
	    Tabloda(id: bigint, nurse_id: bigint, patient_id: bigint, doctor_id: bigint) kolonları olmalıdır.
        id kolonu PRİMARY KEY ve auto-increment olmalıdır.
		Bu tabloda nurse_id, patient_id ve doctor_id foreign key olmalıdır.

	5) Veri tabanınız içerisinde operation adında bir tablo oluşturun.
         Tabloda(id: bigint, patient_id: bigint, doctor_id: bigint) kolonları olmalıdır.
         id kolonu PRİMARY KEY ve auto-increment olmalıdır.
         Bu tabloda patient_id ve doctor_id foreign key olmalıdır.



