# Java Inheritance

### Proje Kurulumu

Projeyi önce forklayın daha sonra klonlayın ve Intellij kullanarak projeyi açın. 
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Silindir
* com.workintech.cylinder paketi altında Circle isimli bir sınıf yazınız. ```radius``` isimli bir tane sınıf değişkenine sahip olmalı. radius değişkeninin tipi ne olmalı ?
* Sınıfın bir tane ```constructor``` metodu olmalı ve içerisinde radius değişkeninin değerini değiştirebilmeli. Radius bir şekilde 0'dan küçük belirtilirse radius 0'a eşitlenmeli. 
* Circle sınıfının ```getRadius``` isimli bir metodu olmalı ve radius değerinin dönmeli.
* Circle sınıfının ```getArea``` isimli bir metodu olmalı ve radius * radius * Math.PI değerini dönmeli.

* com.workintech.cylinder paketi altında Cylinder isminde bir sınıf yazınız. Circle sınıfı ile arasında kalıtım ilişkisi kurmalısınız.
* Cylinder sınıfının bir tane sınıf değişkeni olmalı ve adı ```height``` olmalı. height değişkeninin tipi ne olmalı ?
* Cylinder sınıfının bir tane constructor methodu olmalı ve 2 parametre almalı. height parametresi 0'dan küçükse, height 0'a eşitlenmeli.
* Cylinder sınıfının ```getHeight``` isimli bir metodu olmalı ve height değerini return etmeli.
* Cylinder sınıfının ```getVolume``` isimli bir metodu olmalı hacmi hesaplamalı. Hacmi hesaplamak için ```getArea``` ile height değişkenini çarpmalı.

### Havuzun Alanını Hesaplama

  Workintech yüzme ekibinin sana ihtiyacı var.  

* com.workintech.pool paketi altında Rectangle isimli bir sınıf yazınız. Sınıf'ın iki tane sınıf değişkeni olmalı. ```width``` ve ```length``` İki değişkeninde tipini ne seçmeliyiz?
* width değişkeni de height değişkenide 0 dan küçük set edilirse direkt olarak 0'a set edilmeliler.
* Rectangle sınıfının 3 methodu olmalı ```getWidth``` width alanını dönmeli.
* ```getLength``` methodu length fieldini dönmeli
* ```getArea``` methodu (width*length) i dönmeli.

* com.workintech.pool paketi altında Cuboid isimli bir sınıf daha yazmalısınız. Cuboid sınıfı ile Rectangle sınıfı arasında bir ilişki olmalı.
* Cuboid sınıfının tek bir sınıf değişkeni var ve adı height. Tipini belirlemek senin görevin. height 0'dan küçükse direkt 0 atanmalı.
* Cuboid sınıfının tek bir constructor methodu olmalı ve 3 parametre almalı. width, length ve height.
* Cuboid sınıfının iki tane methodu olmalı. ```getHeight``` height değerini dönmeli. ```getVolume``` volume değerinin hesaplamalı ve dönmeli. Volume alan ile yükseklik değerinin çarpımıdır.

### Developer Company
* com.workintech.developers paketi altında Employee isimli bir sınıf oluşturunuz. İçerisinde ```id, name, salary``` sınıf değişkenleri olmalı.
* Employee sınıfının bir adet ```constructor``` ve her değişkeni için ```getter & setter``` metodları olmalı. Constructor içerisinde 3 değişkende set edilebilmeli.
* Employee sınıfının içerisinde bir adet ```work``` isimli bir metod olmalı ve ```Employee starts to working``` şeklinde bir mesaj basmalı.
* Employee sınıfı ile parent child ilişkisi olan 4 sınıf daha yazmalısınız. ```HRManager, JuniorDeveloper, MidDeveloper, SeniorDeveloper```
* Her child sınıf parent sınıfında var olan 3 parametreyi set edebildiği bir ```constructor``` metoduna sahip olmalı.(Gerekirse başka constructorlarda eklenebilir.)  
* Tüm sınıflarda ```work``` metodu ```Override``` edilmeli. Her bir sınıf için o sınıfa özgü bir mesaj basılmalı ve çalışanın maaşı güncellenmeli.
* HRManager sınıfında 3 adet ```instance variable``` tanımlanmalı. JuniorDeveloper, MidDeveloper, SeniorDeveloper lar için birer array.
* HRManager ```addEmployee``` isimli bir metoda sahip olmalı. Bu metod için gerekli  ```Overload``` edilmiş hallerini tanımlamalısınız.
* Bu metodun amacı JuniorDeveloper gelirse ilgili developeri juniorDevelopers dizisine eklemeli.
* MidDeveloper gelirse ilgili developeri midDevelopers dizisine eklemeli.
* SeniorDeveloper gelirse ilgili developeri seniorDevelopers dizisine eklemeli.
* Bu eklemeler yapılırken ilgili dizide index alanı dolu mu diye bakılmalı. Doluysa içerdeki veri ezilmemeli. Bir uyarı verilmeli. Aynı zamanda indexin hiç var olmadığı durum da göz önünde bulundurulmalı.


### Uygulamayı Test Etmek

Uygulamada ```main``` metodu içerisinde INPUT kısmındaki kod blokları çağırıldığında, OUTPUT kısmındaki gibi bir çıktı alınmalı. 

### Silindir için
INPUT

Circle circle = new Circle(3.75);

System.out.println("circle.radius= " + circle.getRadius());

System.out.println("circle.area= " + circle.getArea());

Cylinder cylinder = new Cylinder(5.55, 7.25);

System.out.println("cylinder.radius= " + cylinder.getRadius());

System.out.println("cylinder.height= " + cylinder.getHeight());

System.out.println("cylinder.area= " + cylinder.getArea());

System.out.println("cylinder.volume= " + cylinder.getVolume());


OUTPUT

circle.radius= 3.75

circle.area= 44.178646691106465

cylinder.radius= 5.55

cylinder.height= 7.25

cylinder.area= 96.76890771219959

cylinder.volume= 701.574580913447

### Havuzun Alanı için
INPUT

Rectangle rectangle = new Rectangle(5, 10);

System.out.println("rectangle.width= " + rectangle.getWidth());

System.out.println("rectangle.length= " + rectangle.getLength());

System.out.println("rectangle.area= " + rectangle.getArea());

Cuboid cuboid = new Cuboid(5,10,5);

System.out.println("cuboid.width= " + cuboid.getWidth());

System.out.println("cuboid.length= " + cuboid.getLength());

System.out.println("cuboid.area= " + cuboid.getArea());

System.out.println("cuboid.height= " + cuboid.getHeight());

System.out.println("cuboid.volume= " + cuboid.getVolume());

OUTPUT

rectangle.width= 5.0

rectangle.length= 10.0

rectangle.area= 50.0

cuboid.width= 5.0

cuboid.length= 10.0

cuboid.area= 50.0

cuboid.height= 5.0

cuboid.volume= 250.0



