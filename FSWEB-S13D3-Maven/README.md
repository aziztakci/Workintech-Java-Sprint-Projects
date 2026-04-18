# Introduction To Java OOP

### Proje Kurulumu

Projeyi öncelikle forklayın ve clone edin.
Daha sonra projeyi IntellijIDEA kullanarak açınız. README.md dosyasını dikkatli bir şekilde okuyarak istenenleri yapmaya çalışın.
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Person Sınıfı

* org.example paketi altında ```Person``` isimli bir sınıf tanımlayınız.
* Sınıf için 3 tane ```instance variable``` tanımlayınız. 
* ```firstname``` String olmalı, ```lastName``` String olmalı ```age``` int olmalı.
* Kendiniz Person isimli bir sınıfta olmasını isteyeceğiniz 3 adet daha ```instance variable``` ekleyiniz.
* Bu sınıf için firstname, lastname ve age değerlerini alabileceğiniz bir ```constructor``` tanımlayınız.
* Kendi eklediğiniz parametreleri de kullandığınız bir adet daha ```constructor``` ekleyerek ```overloading``` yapınız. Toplamda minimum 2 tane ```constructor``` olmalı.
* Eklediğiniz ```constructor``` metodlarından birinin içerisinden diğerini çağırarak ```constructor chaining``` yapınız.
* Person sınıfının içerisinde 4 adet method tanımlayınız.
* ```getFirstName``` => firstname değerini dönmeli
* ```getLastName``` => lastname değerini dönmeli.
* ```getAge``` => age değerini dönmeli.
* ```isTeen``` => age değeri 13-19 arasında ```true``` dönmeli. Diğer koşullarda ```false``` dönmeli.

* main metodu içerisinde aşağıdaki gibi çağırımlar yapabilmelisiniz.
* Person sınıfından birden fazla person ```instance``` oluşturarak. Bir sınıftan pek çok obje oluşturabilmeyi deneyimleyiniz.

Person person = new Person("John", "Doe", 20);

System.out.println("Firstname: " + person.getFirstName());

System.out.println("LastName: " + person.getLastName());

System.out.println("Age: " + person.getAge());

### Wall Sınıfı

* org.example paketi altında ```Wall``` isimli bir sınıf tanımlayınız.
* Sınıf için 2 tane ```instance variable``` tanımlayınız.
* Bu iki sınıf değişkeni; ```width``` double olmalı, ```height``` double olmalı.
* Wall sınıfı için bir adet ```constructor``` tanımlayınız. 2 parametreyi de set etmeli.
* Wall sınıfı içerisine 5 tane metod ekleyiniz.
* ```getWidth``` => width değerini dönmeli
* ```getHeight``` => height değerini dönmeli.
* ```setWidth``` => bir parametre almalı ve aldığı parametreyi width değerine eşitlemeli. Gelen parametre 0'dan küçükse, width değerini 0'a eşitlemeli.
* ```setHeight``` => bir parametre almalı ve aldığı parametreyi height değerine eşitlemeli. Gelen parametre 0'dan küçükse, height değerini 0'a eşitlemeli.
* ```getArea``` => hiçbir parametre almamalı ve ```width*height``` değerini dönmeli.

Aşağıdaki gibi test edebilirsiniz.

INPUT

Wall wall = new Wall(5,4);

System.out.println("area= " + wall.getArea());

wall.setHeight(-1.5);

System.out.println("width= " + wall.getWidth());

System.out.println("height= " + wall.getHeight());

System.out.println("area= " + wall.getArea());

OUTPUT

area= 20.0

width= 5.0

height= 0.0

area= 0.0
