# Java Çalışanlar Uygulaması

## Giriş

Bu proje aşağıdaki kavramların anlaşılması için oluşturulmuştur.

* Java ve JDK'nın birlikte çalışması
* Java'nın Temelleri
* Nesne Tabanlı Java Uygulamalarının temelleri

Bununla birlikte bir java uygulamasında sınıfların ve nesnelerin nasıl kullanıldığını ve Java'daki veri türlerinin nasıl uygulandığına odaklanır.

## Talimatlar

### Görev 1: Proje Kurulumu
Bu projeyi forkladıktan sonra bilgisayarınıza klonlayın.

### Görev 2: 
 * org.example paketi altında 3 tane sınıf oluşturmalısınız. ```Company```, ```Healthplan```, ```Employee```
 * Yazılacak tüm sınıflardaki sınıf değişkenleri  ```private``` olarak tanımlanmalı. Hepsi için getter & setter metodları yazılmalı. Her sınıfın toString() metodu ezilmeli. Her sınıf için en az bir tane ```constructor``` tanımlanmalı.
 * ```Healthplan``` sınıfı  ```id```, ```name``` ve ```plan``` isminde 3 adet sınıf değişkeninden oluşmalı. Bu 3 instance variable değerlerinin set edilebileceği bir constructor mutlaka eklenmeli.
 *  ```plan``` enum tipinde olmalı. ```name``` ve ```price``` değerlerini almalı. 
 * Bir tane ```BASIC``` isminde bir plan mutlaka eklemelisiniz. Kendinize göre başka planlarda ekleyebilirsiniz.
 * org.example paketi altında enums adında bir paket oluşturun. ```plan``` enumını bu paketin altında tanımlayın.
 * Employee sınıfı içerisinde ```id, fullName, email, password``` ve ```String[] healthplans``` isminde toplamda 5 sınıf değişkeni olmalı.
 * Bu 5 sınıf değişkeninin de atamasını yapabilecek bir constructor ekleyiniz.
 * Employee sınıfı içerisinde ```addHealthplan(int index, String name)``` isimli bir metod tanımlayınız. Amacımız healthplans dizisine parametre olarak gelen name değerini atamak. İlgili index değeri dizi içerisinde boşsa parametre olarak gelen ```name``` değişkeni ilgili indexe yazılmalı. İlgili index doluysa dolu olduğuna dair bir mesaj verilmeli. İlgili index değerinin dizi içerisinde hiç var olmadığı durumda kontrol edilmeli.
 * Company sınıfı içerisinde ```id, name, double giro, String[] developerNames``` isminde 4 adet sınıf değişkeni olmalı.
 * Bu 4 sınıf değişkeninin de atamasını yapabilecek bir constructor ekleyiniz.
 * giro değeri hiçbir şekilde 0 altında değer alamamalı.
 * Company sınıfı içerisinde ```addEmployee(int index, String name)``` isimli bir metod tanımlayınız. Amacımız developerNames dizisine parametre olarak gelen name değerini atamak. İlgili index değeri dizi içerisinde boşsa parametre olarak gelen ```name``` değişkeni ilgili indexe yazılmalı. İlgili index doluysa dolu olduğuna dair bir mesaj verilmeli. İlgili index değerinin dizi içerisinde hiç var olmadığı durumda kontrol edilmeli.


### Görev 3: Main metodun içinden başka bir metod çağırımı yapın. Tüm işlemler bu yeni çağırım yaptığınız metod içinde yapılmalı

### Sonuçlar
 * Her sınıf için en az bir tane obje oluşturmalısınız
 * Her obje için toString() metodunu mutlaka çağırmalı ve ekran görüntüsünü görmelisiniz
 * Encapsulation kurallarını doğru bir şekilde uygulamalısnız. Örneğin Company için giro değeri hiçbir zaman negatif bir değer almamalı.
   
 
