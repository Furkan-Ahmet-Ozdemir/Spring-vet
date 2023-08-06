# Veteriner Spring Web Uygulaması
* Bu uygulamanın amacı Kullanıcılar eklemek ve onlara ait hayvan veya hayvanlar eklemek.

### Uygulamınn Bazı Özellikleri 
* Kullanıcı Eklemek,Güncellemek ve Listelemek.
* Hayvan Eklemek,Güncellemek,Silmek ve Listelemek.
* Hayvan adı ya da sahibinin adı ile arama yapmak.
* Unit Test içeriyor.

## Kullandığım Teknolojiler
* Spring
* H2 Database
* Thymeleaf
* Bootstrap 
* JPA
* JDK 17
* Maven
* IntelliJ IDE 

## Projeye Nasıl Çalıştırılır ?
* Projeyi bu adresten indirmeniz gerekiyor :[proje linki](https://github.com/Furkan-Ahmet-Ozdemir/Spring-vet)
* Projeyi zipten çıkarın.

### IDE Gerekmeden Çalıştırmak İçin:
* Bilgisayarınızda maven kurulu olmalı. Kurulu değil ise buradan kurabilirsiniz: [https://maven.apache.org/download.cgi]
* Pathe tanımlı olmalı. Tanımlı değil ise buradan bakabilirsiniz: [https://mkyong.com/maven/how-to-install-maven-in-windows/]
* Cmd ye ```mvn --version``` yazdığınzda ``` Apache Maven 3.8.4 ``` benzeri bir cevap almalısınız.
* Projeyi zip te ise ziptan çıkartın.
* Daha sonra CMD yi açıp **pom.xml**  in olduğu dizine gelin.
* ```mvn spring-boot:run``` komutunu çalıştırın.
* Aşağıdaki yazıya benzer yazılar geliyorsa proje çalışmıştır :
```
Tomcat started on port(s): 8090 (http) with context path ''  
Started VetApplication in 3.574 seconds (JVM running for 3.991)
```

* Tarayıcınız açıp http://localhost:8090/ adresine gidin.

### IntelliJ IDE İle Çalıştırmak İçin:
* Projeyi IntelliJ IDE ile açın.
* ```Run VetApplication``` 
* Run kısmında aşağıdaki yazıya benzer yazılar geliyorsa proje çalışmıştır :
```
Tomcat started on port(s): 8090 (http) with context path ''  
Started VetApplication in 3.574 seconds (JVM running for 3.991)
```

* Tarayıcınız açıp http://localhost:8090/ adresine gidin.


## Teknik Seçimler / Kabuller Ve Nedenleri
* Uygulama ilke açıldığında Create Animal butonuna basıldığında bir mesaj ile Create User sayfasına yönlendiriyorum. 
Nedeni hiç User olmadan Animal oluşturulamaması için. 
* Arama kelimesini alıyorum ve boş mu dolu mu kontrolü yapıyorum. Boş ise bütün Animal ları getiriyorum. Dolu ise alaklı verileri. 
Boş iken hepsini getirme nedenim hiçbir şart belirtmemiş olması .
