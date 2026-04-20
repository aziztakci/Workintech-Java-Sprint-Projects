#  Java Encapsulation

### Proje Kurulumu

Projeyi öncelikle forklayın ve clone edin.
Daha sonra projeyi IntellijIDEA kullanarak açınız. README.md dosyasını dikkatli bir şekilde okuyarak istenenleri yapmaya çalışın.
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Point Sınıfı

* org.example paketi altında ```Point``` isimli bir sınıf tanımlayınız.
* Sınıfın 2 tane değişkeni olmalı x ve y ikisinin de değeri ```int``` olmalı.
* Bu iki değişkene sadece bu sınıf içerisinden erişilebilinmeli.
* Point sınıfı için bir adet ```constructor``` tanımlayınız. İki değeri de set edebilmeli.
* İlgili iki değişken için getter ve setter metodlarını tanımlayınız.
* Point sınıfı içerisinde bir tane ```distance``` isminde metod tanımlayınız.
* distance metodu iki nokta arasındaki uzaklığı bulmaya yarar.
* Bu işlemin matematiksel olarak yapımı: √ (xB − xA) * (xB - xA) + (yB − yA) * (yB - yA) şeklindedir.
*  √ işlemi karekök işlemini tanımlar. ```Math.sqrt``` bu işlem için kullanılmalıdır.
* distance metodu için 3 farklı ```overloading``` istenmektedir
* ```distance()``` hiçbir değer almazsa (0,0) noktasına göre uzaklık hesaplanmalı.
*  ```distance(Point p)``` şeklinde başka bir Point objesi alırsa verilen noktaya göre uzaklık hesaplanmalı.
* ```distance(int a, int b)``` şeklinde 2 farklı int parametresi alınırsa (a,b) ye göre uzaklık bulunmalı.

Aşağıdaki gibi bir test yapılabilir.

INPUT
Point first = new Point(6, 5);

Point second = new Point(3, 1);

System.out.println("distance(0,0)= " + first.distance());

System.out.println("distance(second)= " + first.distance(second));

System.out.println("distance(2,2)= " + first.distance(2, 2));

Point point = new Point(0,0);

System.out.println("distance()= " + point.distance());

OUTPUT
distance(0,0)= 7.810249675906654

distance(second)= 5.0

distance(2,2)= 5.0

distance()= 0.0

### Player Sınıfı
 
*  org.example paketi ```Player``` isimli bir sınıf oluşturunuz.
* Sınıfın 3 tane değişkeni olmalı ```String name``` ```int healthPercentage``` ```Weapon weapon```
* Weapon org.example paketi altında bir enum olmalı.
* Weapon enumının değerlerinden bir tanesi ```SWORD``` olmalı. İsteğinize göre başka değerlerde ekleyebilirsiniz.
* Her weapon için bir adet ```int damage``` ve ```double attackSpeed``` değeri tanımlanmalı. Aynı zamana bu değişkenler için getter metodları da yazılmalı.
* Tüm değişkenlere sadece bu sınıf içerisinden ulaşılabilinmeli.
* Değişkenler için getter ve setter metodları kesinlikle TANIMLANMAMALI.
* Sınıfın tek bir ```constructor``` metodu olmalı ve bu 3 değeri set edebilmeli.
* player objesi oluşturulduğu anda eğer healthPercentage 100'den büyük verildiyse, 100 değerine set edilmeli. Eğer healthPercentage 0'dan küçük verildiyse 0'a set edilmeli.
* Player sınıfı için 3 adet metod tanımlamalıyız.
* ```healthRemaining``` metodu healthPercentage değerini dönmeli.
* ```loseHealth(int damage)``` metodu damage değeri kadar healthPercentage değerinden düşmeli. Oyuncunun canı bir şekilde 0'değerinin altına düşerse, ```System.out.println(name + " player has been knocked out of game");``` değerini ekrana basmalı. 
*  ```restoreHealth(int healthPotion)``` metodu healthPotion miktarı kadar healthPercentage değerine ekleme yapmalı. Oyunucunun canı 100 değerinden yüksek bir değere çıkarsa tekrar geri 100 değerine eşitlenmeli.
