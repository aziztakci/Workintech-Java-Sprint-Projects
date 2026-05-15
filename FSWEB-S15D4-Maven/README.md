#  Java Veri Yapıları Challenge

### Proje Kurulumu

Projeyi öncelikle forklayın ve clone edin.
Daha sonra projeyi IntellijIDEA kullanarak açınız. README.md dosyasını dikkatli bir şekilde okuyarak istenenleri yapmaya çalışın.
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Veri Yapıları Challenge I
 * Amacımız uygun veri yapısını kullanarak bir string değerinin palindrom olup olmadığına karar vermek.
 * org.example Main sınıfı altında static ```checkForPalindrome``` adında bir method tanımlayınız. Method input olarak bir ```String``` almalı ve ```boolean``` bir değer dönmeli.
 * İstediğiniz veri yapısını kullanabilirsiniz.
 * String değer .,?!_- gibi değerler içerebilir.Boşluk karakterini içerebilir. String değerleri büyük harfle ya da küçük harfle yazılabilir.
 * Yazacağınız kod bütün bu karakterlere ve küçük harf büyük harfe uygun çalışmalı.
 * Examples:
 * ```I did, did I?``` => palindrom 
 * ```Racecar``` => palindrom 
 * ```hello``` => palindrom değil
 * ```Was it a car or a cat I saw ?``` => palindrom

### Veri Yapıları Challenge II
 * org.example paketi altında ```WorkintechList``` adında bir sınıf yazmanız istenmektedir.
 * Sınıf ArrayList sınıfının tüm özelliklerine sahip olmalı ve bir ArrayList gibi davranmalı.
 * Ancak WorkintechList'ten oluşturulmuş instance değerleri içerilerinde bir ArrayList'ten farklı olarak tekrar eden data tutamazlar.
 * WorkintechList sınıfınde ```sort``` isminde bir metot tanımlamalısınız ve WorkintechList'e eklenmiş tüm değerleri sıralamalı(String ise A'dan Z'ye)(numeric ise 0'dan sonsuza doğru)
 * WorkintechList sınıfında bir ```remove``` metodu olmalı. Parametre olarak Object tipinde bir parametre almalı.
 * ```remove``` metodu aldığı parametreyi WorkintechList'ten silmeli ve WorkintechList'te bulunan tüm elemanları sıralamalı.

### Convert Decimal Numbers To Binary

 * Günlük hayatımız da hep 10'luk(Decimal) sistemde çalışırız bu yüzden kullanabildiğimiz rakamlar 0,1,2,3,4,5,6,7,8,9 dur.
 * Ancak bilgisayarlar 2'lik(binary) sistemde çalışırlar. O yüzden sadece 0 ve 1 rakamlarını bilirler.
 * Decimal bir sayıyı ikilik tabanda yazabiliriz.
 * Örnek olarak:
      * 5 sayısı 2'lik tabanda şu şekilde yazılır 101 => 2^2 + 0 + 2^0
      * 6 sayısı 2'lik tabanda şu şekilde yazılır 110 => 2^2 + 2^1 + 0
      * 13 sayısı 2'lik tabanda şu şekilde yazılır => 1101 => 2^3 + 2^2 + 0 + 2^0
   
 * Matematiksel olarak ilgili cevirme işlemininin nasıl yapıldığıyla ilgili detayı buradan okuyabilirsiniz: https://www.cuemath.com/numbers/decimal-to-binary/
 * Görevimiz Decimal number alıp günün sonunda bu değeri binary formata ceviren bir kod yazmak.
 * Bu işlemi gerçekleştirmek adına org.example Main sınıfı altında static ```convertDecimalToBinary``` adında bir method tanımlayınız. Method input olarak bir ```int``` almalı ve ```String``` bir değer dönmeli.
 * Bunun için kullanılabilecek en uygun Veri Yapısı hangisi olurdu ? Çözümünüz bu veri yapısını içermeli.
