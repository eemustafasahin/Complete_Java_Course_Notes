```java
/*----------------------------------------------------------------------------------------------------------------------
    31.10.2020
    Dosya İşlemleri

    İkincil belleklerde organize edilmiş alanlara dosya (file) denir. Dosyaların isimleri ve özellikleri vardır. Dosya
    işlemleri aslında işletim sistemi tarafından yapılır. İşletim sistemin dosya işlemleri ilgili faaliyetlerinden oluşan
    bölümüne dosya sistemi denir. Java'nın bu konudaki sınıfları dolaylı olarak işletim sisteminin sistem fonksiyonları
    veya API (Application Programming Interface) fonksiyonlarını çağırmaktadır.

    Bir dosyanın yerini belirten yazısal ifadeye "yol ifadesi (path)" denilmektedir. Windows'ta dizin geçişleri
    '\' karakteri ile UNIX/Linux ve Mac OS X sistemlerinde '/' ile belirtilir. Windows sistemlerinde ayrıca bir de
    sürücü (drive) kavramı vardır. UNIX/Linux sistemlerinde ve Mac OS X sisemlerinde sürücü kavramı yoktur. Windows
    sistemlerinde her sürücünün ayrı bir kökü ve dizin ağacı vardır. Sürücünün kök dizini onun en dış dizinidir.

    Yol ifadeleri mutlak (absolute) ve göreli (relative) olmak üzere ikiye ayrılmaktadır. Eğer sürücü ifadesinden
    sonraki (yol ifadesinde sürücü de belirtilmeyebilir) ilk karakter '\' ise böyle yol ifadelerine mutlak, değilse
    göreli yol ifadeleri denilmektedir. Örneğin:

    "c:\a\b\c.dat"	---> mutlak yol ifadesi
    "\x\y\z.txt"	---> mutlak yol ifadesi
    "x\y\z.txt" 	---> göreli
    "x.txt"			---> göreli

    Benzer şekilde / karakteri ile de aynı durum düşünülebilir. Yani bir yol ifadesinin başınada / varsa mutlak yoksa
    göreli yol ifadesidir.

    Çalışmakta olan her programın (yani process'in) bir çalışma dizini (current working directory) vardır. Programın
    çalışma dizini göreli yol ifadelerinin çözülmesi için orijin belirtir. Örneğin, programımızın çalışma dizini
    "c:\temp" olsun. Biz bu programda "x\y\z.dat" biçiminde bir yol ifadesi kullanırsak toplamda "c:\temp\x\y\z.dat"
    dosyasını belirtmiş oluruz. Prosesin çalışma dizini istenildiği zaman değiştirilebilir. Ancak işin başında genel
    olarak programın çalıştırıldığı dizindir.

    Mutlak yol ifadeleri kök dizinden itibaren çözülür. Window sistemlerine özgü olarak eğer yol ifadesinde sürücü
    belirtilmemişse prosesin çalışma dizininin bulunduğu sürücü o mutlak yol ifadesindeki sürücü olarak alınır. Örneğin
    prosesin çalışma dizini "d:\temp" olsun. "\a\b\c.dat" yol ifadesi d'nin kök dizininden itibaren yol belirtir yani
    örnekteki yol ifadesi "d:\a\b\c.dat".
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java'da process'in çalışma dizini System sınıfının getProperty metoduna "user.dir" string sabiti argüman olarak
    geçilerek elde edilebilir. Bununla birlikte process'in çalışma dizinini değiştirmek için System sınıfının setProperty
    metodu yine "user.dir" string sabiti ile kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        if (args.length > 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        String currentWorkingDirectory = System.getProperty("user.dir");

        System.out.printf("Current Working Directory:%s%n", currentWorkingDirectory);

        if (args.length > 0)
            System.setProperty("user.dir", args[0]);

        currentWorkingDirectory = System.getProperty("user.dir");

        System.out.printf("Current Working Directory:%s%n", currentWorkingDirectory);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Windows’ta dosya ve dizin isimlerinin büyük harf küçük harf duyarlılığı yoktur. Windows dosyanın ismini bizim
	belirttiğimiz gibi saklar. Ancak işleme sokarken büyük harf küçük harf farkını dikkate almaz. Ancak UNIX/Linux
	sistemlerinde (Mac OS X dahil) dosya ve dizin isimlerinin büyük harf küçük harf duyarlılığı vardır. Yol ifadelerinde
	kullanabileceğimiz iki özel dizin ismi vardır. Bunlar “.” ve “..” isimleridir. “.” o anda belirtilen dizinin aynısı,
	“..” ise o anda belirtilen dizinin üst dizini anlamına gelir. Örneğin “a\b\..\c.txt” yol ifadesi aslında “a\x.txt”
	ile eşdeğerdir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anahtar Notlar: Dosya işlemleri sırasında bir çok durum oluşabilir. Örneğin, bir dosya verildiği dizinde
    bulunamayabilir, o anki processin o dosyaya yazma hakkı olmayabilir vs. Bu durumda genel olarak metotlar exception'lar
    fırlatabilmektedir. Programcı bu exceptionlara dikkat etmelidir. Bu exception sınıfları genel olarak IOException
    veya IOException sınıfından türetilmiş olan exception nesneleridir. IOException sınıfının checked bir exception
    sınıfı olduğuna dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Text ve Binary Dosyalar

    Bilgisayar dünyasında içeriklerine göre dosyalar kabaca “text” ve “binary” dosyalar biçiminde ikiye ayrılmaktadır.
    Aslında bu ayrım tamamen mantıksal düzeydedir. Dosyanın içerisinde ne olursa olsun dosyalar byte topluluklarından
    oluşurlar. Dosyaların uzantıları onların içerisinde ne olduğuna yönelik bir ipucu vermek için düşünülmüştür.
    İçerisinde yalnızca yazıların bulunduğu dosyalara “text” dosyalar, içerisinde yazıların dışında başka birtakım
    bilgilerin de bulunduğu dosyalara “binary” dosyalar denilmektedir. Örneğin notepad’te oluşturmuş olduğumuz dosyalar
    tipik text dosyalardır. Halbuki uzantısı “.exe” olan “.obj” olan dosyaların içerisinde yazı yoktur. Bunlar tipik
    binary dosyalardır. Uzantısı “.doc” olan veya “.docx” olan dosyalar da aslında “binary” dosyalardır. Her ne kadar bu
    dosyaların içerisinde yazılar varsa da yazıların dışında başka metadata bilgileri vardır.

    Text ve binary modda açılan dosyalar için Windows ve Unix/Linux (Mac OS X dahil) sistemlerinde farklılıklar
    bulunmaktadır. Bir dosya text modda açılmışsa ve çalışılan sistem windows ise yazma yapan herhangi bir fonksiyon
    Line feed (LF) ('\n') karakterini yazdığında aslında dosyaya Carriage Return (CR)('\r') ve LF karakterlerinin ikisi
    birden yazılır. Benzer şekilde dosyadan okuma yapan fonksiyonlar çalışılan sistem Windows ise ve dosya text modda
    açılmışsa CRLF karakterlerini yanyana gördüğünde yalnızca LF olarak okuma yaparlar. Bu konu ileride
    detaylandırılacaktır.

    Java'da dosyalar üzerinde işlem yapan pek çok sınıf vardır. Bu sınıfları iki gruba ayırabiliriz:
    - Dosyanın bütünü üzerinde işlem yapan türler. Örneğin, bir dosyayı silen, kopyalayan, yer değiştiren gibi
    - Dosyanın içerisindeki veriler üzerinde işlem yapan türler. Örneğin, dosyaya yazma yapan, dosyadan okuma yapan sınıflar.
    Java'da dosya işlemi yapan sınıflar genel olarak java.io ve java.nio paketlerinde bulunmaktadır.

    File Sınıfı
    Bu sınıf bir dosya ya da dizine (directory) ilişkin bütünsel işlemleri yapan sınıftır. File sınıfının kullanılması
    için önce programcı dosya yolunu vererek bir File nesnesi oluşturur. Sınıfın dosyanın bütünü üzerinde işlem yapan
    birçok yararlı metodu bulunmaktadır. File sınıfının ayrıca başka parametreli ctor'ları da bulunmaktadır
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    File sınıfı türünden nesne yaratıldığında yol ifadesinin geçerli olup olmadığı kontrol edilmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File file = new File(args[0]);

        //...
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    File sınıfının exists metodu verilen yol ifadesine ilişkin dosya ya da dizinin varlığını test etmek amaçlı
    kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File file = new File(args[0]);

        if (file.exists())
            System.out.println("Geçerli yol ifadesi");
        else
            System.out.println("Geçersiz yol ifadesi");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    File sınıfının isDirectory metodu belirtilen yol ifadesinin bir dizin belirtip belirtmediğini test eder
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File file = new File(args[0]);

        if (file.isDirectory())
            System.out.println("Dizin");
        else
            System.out.println("Dizin değil");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    File sınıfının isFile metodu belirtilen yol ifadesinin bir dosya olup olmadığını test eder.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File file = new File(args[0]);

        if (file.isFile())
            System.out.println("Dosya");
        else
            System.out.println("Dosya değil");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    isFile ve isDirectory metotları yol ifadesinin geçersiz olması ya da ne dosya ne de dizin belirten bir
    yol ifadesi olması durumunda false döndürür. Bu durumların ayrıca kontrol edilmesi gerekebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File file = new File(args[0]);

        if (file.exists())
            if (file.isFile())
                System.out.println("Dosya");
            else if (file.isDirectory())
                System.out.println("Dizin");
            else
                System.out.println("Ne dosya ne de dizin");
        else
            System.out.println("Geçersiz yol ifadesi");
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    File sınıfının getAbsolutePath isimli metodu ile File sınıfına verilen yol ifadesi mutlak olarak elde edilir.
    Zaten mutlak verilmişse aynı mutlak verilmemişse çalışma dizini ile birleştirilmiş hali elde edilir. File sınıfının
    getName isimli metodu ile yol ifadesine ilişkin dosyanın veya dizinin doğrudan ismi elde edilebilir. Benzer şekilde
    getParent isimli metodu ile de dosya ya da dizinin üst dizini (parent) elde edilebilir. geParentFile
    isimli metodu ile üst dizine ilişkin File referansı elde edilebilir. getParent ve getParenFile metotları göreli yol
    ifadesi ile yaratılmış olan bir File nesnesi için null döndürür. Bu durumda en iyi yöntem getAbsoluteFile metodu ile
    mutlak yol ifadesine ilişkin File referansı alınıp getParent veya getParentFile çağrılmadır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File file = new File(args[0]);

        System.out.printf("Absolute Path:%s%n", file.getAbsolutePath());
        System.out.printf("Name:%s%n", file.getName());
        System.out.printf("Parent:%s%n", file.getParent()); //Dikkat göreli tol ifadesi için null döndürür
        System.out.printf("Parent:%s%n", file.getAbsoluteFile().getParent());
        System.out.printf("Parent:%s%n", new File(file.getAbsolutePath()).getParent());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    File sınıfının delete metodu ilgili yol ifadesinde bulunan dosya ya da dizini silmektedir. Boş olmayan dizinler
    silinemez. Bunun için önce dizinin boşaltılması sonra silinmesi gerekir. File sınıfının delete metodunun geri dönüş
    değeri yol ifadesine ilişkin bilginin silinip silinmediğine ilişkin boolean türündendir. Bu geri dönüş değerinden
    dosyanın hangi sebepten silinemediği anlaşılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File file = new File(args[0]);

        System.out.println(file.delete() ? "Silindi" : "Silinemedi");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    File nesnesi bir dizin gösteriyorsa bu durumda o dizin içerisindeki dosyalar ve dizinler elde edilebilir. Bir dizin
    içerisindeki dosyaları ve dizinlerin isimleri list metoduyla elde edilebilir. List metodu eğer File nesnesine
    ilişkin yol ifadesi bir dizin değilse veya geçersizse bu durumda null döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        String [] files = path.list();

        if (files != null)
            for (String file : files)
                System.out.println(file);
        else
            System.out.println("Geçersiz yol ifadesi");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki program aşağıdaki gibi de yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        if (path.exists() && path.isDirectory())
            for (String file : path.list())
                System.out.println(file);
        else
            System.out.println("Geçersiz yol ifadesi");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki program daha detaylı biçimde yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        FileListApp.run(args);
    }
}

final class FileListApp {

    private static void listFiles(File path)
    {
        for (String file : path.list())
            System.out.println(file);
    }

    private FileListApp()
    {
    }

    public static void run(String [] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        if (path.exists())
            if (path.isDirectory())
                listFiles(path);
            else
                System.out.println("Belirtilen yol ifadesi dizin değil");
        else
            System.out.println("Belirtilen yol ifadesi bulunamadı");
    }
}

```
```java```
```java

/*----------------------------------------------------------------------------------------------------------------------
    File sınıfının listFiles metodu ile o dizin içerisindeki dosya ve dizinler File türünden elde edilebilir. File
    sınıfının getName isimli metodu yol ifadesi içerisindeki dosya ya da dizin ismi elde edilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.File;

class App {
    public static void main(String[] args)
    {
        FileListApp.run(args);
    }
}

final class FileListApp {
    private static void listFiles(File path)
    {
        for (File file : path.listFiles())
            System.out.println(file.getAbsolutePath());
    }

    private FileListApp()
    {
    }

    public static void run(String [] args)
    {
        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        if (path.exists())
            if (path.isDirectory())
                listFiles(path);
            else
                System.out.println("Belirtilen yol ifadesi dizin değil");
        else
            System.out.println("Belirtilen yol ifadesi bulunamadı");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.App <path>
    Program komut satırı argümanı verilmezse klavyeden yol ifadesini isteyecektir. Aldığı yol ifadesine ilişkin dizinin
    içerisindeki dosya ve dizinlerin isimlerini eğer directory ise yanına <DIR> yazarak ekrana basaktır. Eğer directory
    değilse ismini doğrudan ekrana basacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.File;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        DirectoryListContentsApp.run(args);
    }
}

final class DirectoryListContentsApp {
    private static void listFiles(File path)
    {
        for (File file : path.listFiles())
            System.out.printf("%s%s%n", file.getName(), file.isDirectory() ? " <DIR>" : "");
    }

    private DirectoryListContentsApp()
    {
    }

    public static void run(String [] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesiniz giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        if (path.exists())
            if (path.isDirectory())
                listFiles(path);
            else
                System.out.println("Belirtilen yol ifadesi dizin değil");
        else
            System.out.println("Belirtilen yol ifadesi bulunamadı");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Yukarıdaki uygulamayı dosyalar için byte cinsinden uzunlukları gösterecek şekilde yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.File;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        DirectoryListContentsApp.run(args);
    }
}

final class DirectoryListContentsApp {
    private static void listFiles(File path)
    {
        for (File file : path.listFiles()) {
            String postfix = "";

            if (file.isDirectory())
                postfix = " <DIR>";
            else if (file.isFile())
                postfix = String.format(" %s bytes", file.length());

            System.out.printf("%s%s%n", file.getName(), postfix);
        }
    }

    private DirectoryListContentsApp()
    {
    }

    public static void run(String [] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesiniz giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        if (path.exists())
            if (path.isDirectory())
                listFiles(path);
            else
                System.out.println("Belirtilen yol ifadesi dizin değil");
        else
            System.out.println("Belirtilen yol ifadesi bulunamadı");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    File sınıfının mkdir metodu eğer verilen yol ifadesi isimli bir dizin yaratır. Eğer yol ifadesine ilişkin dizin
    varsa bu durumda hiç birşey yapmaz. Metodun geri dönüş değeri dizinin yaratılıp yaratılmadığını gösteren boolean
    türden değerdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.File;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        System.out.println(path.mkdir() ? "Dizin yaratıldı" : "Dizin yaratılamadı");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    mkdir metodu yaratılmak istenen dizine ilişkin yol ifadesi geçersizse dizini yaratamaz ve false değerine döner.
    Verilen yol ifadesine ilişkin tüm dizinlerin yaratılabilmesi için mkdirs metodu kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.File;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        File path = new File(args[0]);

        System.out.println(path.mkdirs() ? "Dizin yaratıldı" : "Dizin yaratılamadı");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Path Arayüzü, Paths ve Files Sınıfları
    Path arayüzü Java 7 ile eklenmiş dosya ve dizinler üzerinde daha kolay işlem yapılmasını sağlayan bir arayüzdür.
    Kullanımı karışık gibi gözükse de birçok işlemi kolaylaştırmaktadır. Tipik olarak bir Path referansı elde etmek için
    Java 11 ile birlikte of metodu kullanılabilir. Java 11 öncesinde Path referansı elde etmek için genel olarak Paths
    isimli sınıfın get metotları kullanılıyordu. Ancak bu sınıfın dökümanlara göre get metotlarının ileride "deprecated"
    olabileceği söylendiğinden Java 11 sonrası için bu sınıfın kullanımı tavsiye edilmez. Path arayüzü, Paths sınıfı
    ve File sınıfı java.nio.file paketi içerisinde bildirilmiştir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Files sınıfı birçok yararlı static metot barındırır. Aslında File sınıfının da içerisinde bulunan birçok yararlı
    metodu barındırır. Ancak File sınıfında da Files'da olmayan bazı metotlar vardır. Yani programcı Files sınıfını
    File sınıfına yardımcı olarak düşünmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try {
            Path path = Paths.get(args[0]);

            if (Files.exists(path))
                System.out.println(Files.deleteIfExists(path) ? "Silindi" : "Silinemedi");
            else
                System.out.println("Belirtilen yol ifadesi geçersiz");

        }
        catch (DirectoryNotEmptyException ignored) {
            System.out.println("Dolu bir dizin silinemez");
        }
        catch (IOException ex) {
            System.out.println("Dosya işlemine ilişkin belirlenemeyen bir durum oluştu");
        }
        catch (Throwable ignored) {
            System.out.println("Belirlenemeyen durum oluştu");
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Java 11 ve sonrasında Paths referansı yerine Path sınıfının of isimli metotları kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try {
            Path path = Path.of(args[0]);

            if (Files.exists(path))
                System.out.println(Files.deleteIfExists(path) ? "Silindi" : "Silinemedi");
            else
                System.out.println("Belirtilen yol ifadesi geçersiz");

        }
        catch (DirectoryNotEmptyException ignored) {
            System.out.println("Dolu bir dizin silinemez");
        }
        catch (IOException ex) {
            System.out.println("Dosya işlemine ilişkin belirlenemeyen bir durum oluştu");
        }
        catch (Throwable ignored) {
            System.out.println("Belirlenemeyen durum oluştu");
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Files sınıfının copy metotları belirli bir kaynaktan başka bir yere kopyalama yapmak amaçlı kullanılmaktadır. Bu
    metodun bir çok overload'u bulunmaktadır. Path türünden iki argümanla çağrılabilen versiyonu birinci parametrede
    elde edilen path'e ikinci parametredeki path'e doğrudan kopyalanmasını sağlar. Bu metot kaynak (source) path  ile
    belirtilen dosyayı bulamazsa NoSuchFileException fırlatır. Ayrıca hedef (destination-target) path ifadesine ilişkin
    bir dosya mevcutsa bu durumda FileAlreadyExistsException nesnesini fırlatır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 2) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try {
            Files.copy(Path.of(args[0]), Path.of(args[1]));
            System.out.println("Kopyalama başarılı...");
        }
        catch (FileAlreadyExistsException ex) {
            System.out.println("Hedef dosya var. Bu durumda kopyalama yapılamaz!!!");
        }
        catch (IOException ex) {
            System.out.println("Dosya işlemine ilişkin belirlenemeyen bir durum oluştu");
        }
        catch (Throwable ignored) {
            System.out.println("Belirlenemeyen durum oluştu");
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Files sınıfının aşağıda kullanılan copy metodu CopyOption arayüzüğ türünden bir referans alır. Bu arayüzü destekleyen
    StandardCopyOption isimli bir enum ile bu argüman verilebilir. REPLACE_EXISTING isimli enum sabiti ile hedef dosya
    varsa bile yenisi ile değiştirilir. REPLACE_EXISTING değeri ile dizin kopyalaması yapıldığında hedef dizin varsa
    ve içi boş değilse DirectoryEmptyException nesnesi fırlatılır. StandardCopyOption enum'nun diğer sabitleri
    burada ele alınmayacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 2) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try {
            Files.copy(Path.of(args[0]), Path.of(args[1]), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Kopyalama başarılı...");
        }
        catch (DirectoryNotEmptyException ex) {
            System.out.println("Dizin boş değil");
        }
        catch (FileAlreadyExistsException ex) {
            System.out.println("Hedef dosya var. Bu durumda kopyalama yapılamaz!!!");
        }
        catch (IOException ex) {
            System.out.println("Dosya işlemine ilişkin belirlenemeyen bir durum oluştu");
        }
        catch (Throwable ignored) {
            System.out.println("Belirlenemeyen durum oluştu");
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Files sınıfının move metodu kaynak yol ifadesinden den hedef yol ifadesine taşıma işlemi yapar. copy metoduna
    benzer şekilde kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 2) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try {
            Files.move(Path.of(args[0]), Path.of(args[1]), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Taşıma başarılı...");
        }
        catch (DirectoryNotEmptyException ex) {
            System.out.println("Dizin boş değil");
        }
        catch (FileAlreadyExistsException ex) {
            System.out.println("Hedef dosya var. Bu durumda kopyalama yapılamaz!!!");
        }
        catch (IOException ex) {
            System.out.println("Dosya işlemine ilişkin belirlenemeyen bir durum oluştu");
        }
        catch (Throwable ignored) {
            System.out.println("Belirlenemeyen durum oluştu");
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    01.11.2020
    Sınıf Çalışması: Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.App <src> <dest>
    Program komut satırı argümanı verilmezse klavyeden yol ifadesini isteyecektir. src ile aldığı dosyayı dest ile
    aldığı dosya olarak kopyalayacaktır. Hedef dosya varsa hedef dosya ismi ve uzantısının sonuna "-bak" ekelenerek
    yedeklenecektir. Daha önce yedeklenmişse üzerine yazılacaktır. Bu işlemden sonra kopyalama yapılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.copyandbackup.CopyAndBackupApp;

class App {
    public static void main(String[] args)
    {
        CopyAndBackupApp.run(args);
    }
}

package org.csystem.app.samples.copyandbackup;

public final class CopyAndBackupApp {
    private CopyAndBackupApp()
    {
    }

    public static void run(String [] args)
    {
        CopyAndBackup copyAndBackup = new CopyAndBackup(args);

        copyAndBackup.run();
    }
}


package org.csystem.app.samples.copyandbackup;

import org.csystem.util.CommanLineUtil;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class CopyAndBackup {
    private Path m_sourcePath;
    private Path m_destinationPath;

    private void parseCommand(String [] args)
    {
        args = CommanLineUtil.getArguments(args, "Kaynak dosya ve hedef dosya yol ifadelerini giriniz:", new Scanner(System.in));

        if (args.length != 2) {
            System.out.println("Kullanım:: java CopyAndBackupApp <kaynak dosya> <hedef dosya>");
            System.exit(-1);
        }

        m_sourcePath = Path.of(args[0]);
        m_destinationPath = Path.of(args[1]);
    }

    private void backupAndCopy() throws IOException
    {
        Files.move(m_destinationPath, Path.of(m_destinationPath.toString() + "-bak"), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(m_sourcePath, m_destinationPath);
        System.out.println("Kopyalama tamamlandı eski dosya kaydedildi");
    }

    private void copy() throws IOException
    {
        try {
            Files.copy(m_sourcePath, m_destinationPath);
            System.out.println("Kopyalama tamamlandı");
        }
        catch (FileAlreadyExistsException ex) {
            this.backupAndCopy();
        }
    }

    public CopyAndBackup(String [] args)
    {
        this.parseCommand(args);
    }

    public void run()
    {
        try {
            this.copy();
        }
        catch (NoSuchFileException ex) {
            System.out.println("Kaynak dosya bulunamadı");
        }
        catch (Throwable ex) {
            System.out.println("Belirlenemeyen bir durum oluştu");
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Dosya Verileri Üzerinde İşlem Yapan Sınıflar
    Dosyanın verileri üzerinde işlem yapan sınıflar genel olarak iki kategoriye ayrılmıştır. Dosyaya yazma yapan ve
    okuma yapan sınıflar. Aslında Java'da genel olarak tüm giriş çıkış (input/ output) işlemleri iki parça halinde
    yapılmaktadır.

    InputStream ve OutputStream Sınıfları
    Temel giriş çıkış işlemleri için InputStream ve OutputStream isimli iki adet sınıf bulunmaktadır. Bu sınıflar
    sadece dosyalar için değil network gibi diğer kavramlar için de kullanılabilmektedir. Yani Java'da "okuma ve yazma"
    ya da daha genel ismiyle "giriş ve çıkış" işlemleri bu sınıflar ile soyutlanmıştır.

    FileInputStream ve FileOutputStream Sınıfları

    Dosya işlemleri için temel iki sınıf FileInputStream ve FileOutputStream sınıflarıdır. FileOutputStream sınıfı
    OutputStream sınıfından, FileInputStream sınıfı da InputStream sınıfından türetilmiştir. Bu sınıflar Closeable ve
    dolayısıyla AutoCloseable arayüzünü desteklediklerinden “try with resources” deyimi ile kullanılabilirler. Bir
    dosyanın verileri üzerinde işlem yapılmadan önce o dosyanın açılması gerekir. Dosyanın açılması işlemi bu sınıfların
    başlangıç metotları tarafından yapılmaktadır. Kapatılması için de close metodu kullanılmalıdır. Bilindiği gibi
    Java 7 ile eklenen “try with resources” deyimi close işlemini otomatik olarak yapmaktadır. Bu sınıflar java.io paketi
    içerisinde bildirilmişlerdir.

    Dosya Gösterici Kavramı

    Dosyaların uzantılarının işletim sistemi için bir önemi yoktur. Uzantı ne olursa olsun dosyaların içerisinde byte
    yığınları vardır. Biz de temelde dosyalardan byte okuyup onlara byte yazarız. Dosya içerisindeki her bir byte'ın
    ilk byte 0(sıfır) olmak üzere artan sırada bir pozisyon numarası vardır. Buna dosya terminolojisinde ilgili byte’ın
    offset’i denilmektedir. Dosya göstericisi bir imleç gibi (kalemin ucu gibi) düşünülebilir. Dosya göstericisi o anda
    dosyanın neresinden itibaren okuma ya da yazma yapılacağını anlatan bir offset belirtir.
        x x x x x x x x
        0 1 2 3 4 5 6 7
    Bu örnekte dosya göstericisinin 2 numaralı offset'i gösterdiğini düşünelim. Biz artık 2 byte'lık bir okuma yaparsak
    2 ve 3 numaralı offset'teki byte'ları okuruz. Okuma ve yazma metotları okunan ya da yazılan miktar kadar dosya
    göstericisini otomatik ilerletmektedir. Dosya açıldığında dosya göstericisi başlangıçta 0'ıncı offset'tedir.
    Yazma sırasında dosya göstericisinin gösterdiği yerden itibaren eski bilgiler ezilerek yeni bilgiler yazılır. Fakat
    özel bir durum olarak dosya göstericisi dosyanın sonundaysa dosyaya yazma yapıldığında dosya büyütülmektedir.
    Başka bir deyişle bu durumda dosyaya yazma işlemi ekleme anlamına gelir.

    Dosya Göstericisinin EOF Durumu

    Dosya göstericisinin dosyanın son byte'ından sonraki byte'ı göstermesi durumuna EOF (End Of File) durumu denir.
    EOF durumundan okuma yapılamaz. Fakat dosya göstericisi EOF durumundayken dosyaya yazma yapılabilir. Bu durum
    dosyaya ekleme anlamına gelir. Dosyaya ekleme yapmanın başka bir yolu yoktur. Dosya göstericisinin dosyanın son
    byte’ından sonraki byte’ı göstermesi söz konusu olabilir. Ancak daha ileride bir yeri göstermesi söz konusu değildir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    FileOutputStream sınıfının File türden ve String türden tek parametreli ctor'ları yeni bir dosya yaratıp dosyayı açar.
    Eğer dosya varsa dosyayı sıfırlayarak (yani bilgileri kaybederek) açar. Yazma işlemi için en temel metot bir byte'lık
    bilgiyi yazan write metodudur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileOutputStream;
import java.util.Scanner;

class WriterApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0])) {
            for (int i = 1; i <= 10; ++i)
                fileOutputStream.write((byte)i);
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    FileInputStreamn sınıfının File türden ve String türden ctor'ları varolan bir dosyayı dosya göstericisi başta olacak
    şekilde açar. Eğer dosya yoksa FileNotFoundException nesnesi fırlatılır. Okuma işlemi en temel olarak read isimli
    bir metot ile yapılabilir. read metodu dosya sonuna gelindiğinde -1 değerine geri döner
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReaderApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            int val;

            while ((val = fileInputStream.read()) != -1)
                System.out.printf("%d ", (byte)val);

            System.out.println();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı");
            System.out.printf("Message:%s%n", ex.getMessage());
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    FileOutputStream sınıfının boolean türden parametresi de olan ctor'ları ile bu parametre true ise dosyanın sonuna
    ekleme yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

class WriterApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        Random r = new Random();

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0], true)) {
            byte [] data = new byte[10];

            r.nextBytes(data);

            for (byte val : data)
                fileOutputStream.write(val);
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    FileOutputStream sınıfının byte türden dizi parametreli write metotları ile yazma işlemi yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

class WriterApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        Random r = new Random();

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0], true)) {
            byte [] data = new byte[10];

            r.nextBytes(data);
            fileOutputStream.write(data);
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    FileInputStream sınıfının byte dizi parametreli read metodu byte türden dizinin içerisine dosyadaki bilgileri
    okur. Ne kadar okuduğu miktarı ile de geri döner. Bu durumda programcının ne kadar okunduğu miktarına göre dizinin
    elemanlarını kullanması gerekir. Yani aslında dizinin uzunluğu en fazla ne kadar okunacağını belirtir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReaderApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            byte [] buffer = new byte[15];
            int read;

            while ((read = fileInputStream.read(buffer)) > 0) {
                System.out.printf("Number of bytes read:%d%n", read);
                for (int i = 0; i < read; ++i)
                    System.out.printf("%d%n", buffer[i]);
            }

            System.out.println();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı");
            System.out.printf("Message:%s%n", ex.getMessage());
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması:Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.App <src> <dest> <block size>
    - Programda Files sınıfı kullanılmayacaktır
    - Program src ile belirtilen dosyayı dest ile belirtilen dosyaya kopyalayacaktır
    - Dosya varsa üstüne yazılacaktır
    - Dosya bloklar halinde kopayalanack blok uzunluğu da komut satırı argümanından alınacaktır

    Anahtar Notlar: Files kullanılarak yapılanın daha iyi olduğu söylenebilir. Çünkü işletim sistemine özgü bazı özel
    fonksiyolar da Files sınıfının metotları içerisinde kullanılabilir. Tabii ki bu uygulamada da blok miktarı
    ayarlanarak çok büyük dosyalar için de hızlı olması sağlanabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.copyfilewithblock.CopyFileApp;

class App {
    public static void main(String[] args)
    {
        CopyFileApp.run(args);
    }
}

package org.csystem.app.samples.copyfilewithblock;

public final class CopyFileApp {
    private CopyFileApp()
    {
    }

    public static void run(String [] args)
    {
        CopyFile copyFile = new CopyFile(args);

        copyFile.run();
    }
}

package org.csystem.app.samples.copyfilewithblock;

import org.csystem.util.CommanLineUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class CopyFile {
    private String m_sourcePath;
    private String m_destinationPath;
    private int m_blockSize;

    private void parseCommand(String [] args)
    {
        args = CommanLineUtil.getArguments(args, "Kaynak dosya ve hedef dosya yol ifadeleri ve blok uzunluğunu giriniz:", new Scanner(System.in));

        if (args.length != 3) {
            System.out.println("Kullanım:: java CopyAndBackupApp <kaynak dosya> <hedef dosya> <blok uzunluğu>");
            System.exit(-1);
        }

        m_sourcePath = args[0];
        m_destinationPath = args[1];
        m_blockSize = Integer.parseInt(args[2]);
    }

    private void copy() throws IOException
    {
        byte [] buffer = new byte[m_blockSize];

        try (FileInputStream fileInputStream = new FileInputStream(m_sourcePath);
                FileOutputStream fileOutputStream = new FileOutputStream(m_destinationPath)) {
            int read;

            while ((read = fileInputStream.read(buffer)) > 0)
                fileOutputStream.write(buffer, 0, read);

            System.out.println("Kopyalama tamamlandı");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Kaynak dosya bulunamadı");
        }
    }

    public CopyFile(String [] args)
    {
        try {
            this.parseCommand(args);
        }
        catch (NumberFormatException ex) {
            System.out.println("Geçersiz blok uzunluğu bilgisi");
            System.exit(-1);
        }
    }

    public void run()
    {
        try {
            this.copy();
        }
        catch (Throwable ex) {
            System.out.println("Belirlenemeyen bir durum oluştu");
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek aşağıdaki gibi Files sınıfının copy metodu ile yapılabilir. Bu metot bir InputStream'den bir dosyaya
    kopyalama yapar. Benzer şekilde bir dosyadan da OutputStream'e kopyalama yapan bir copy metodu da vardır. Burada
    örnek olarak InputStream bir FileInputStream olarak alınmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.copyfile.CopyFileApp;

class App {
    public static void main(String[] args)
    {
        CopyFileApp.run(args);
    }
}


package org.csystem.app.samples.copyfile;

public final class CopyFileApp {
    private CopyFileApp()
    {
    }

    public static void run(String [] args)
    {
        CopyFile copyFile = new CopyFile(args);

        copyFile.run();
    }
}

package org.csystem.app.samples.copyfile;

import org.csystem.util.CommanLineUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyFile {
    private String m_sourcePath;
    private Path m_destinationPath;

    private void parseCommand(String [] args)
    {
        args = CommanLineUtil.getArguments(args, "Kaynak dosya ve hedef dosya yol ifadeleri ve blok uzunluğunu giriniz:", new Scanner(System.in));

        if (args.length != 2) {
            System.out.println("Kullanım:: java CopyAndBackupApp <kaynak dosya> <hedef dosya>");
            System.exit(-1);
        }

        m_sourcePath = args[0];
        m_destinationPath = Path.of(args[1]);
    }

    private void copy() throws IOException
    {
        try (FileInputStream fileInputStream = new FileInputStream(m_sourcePath)) {
            Files.copy(fileInputStream, m_destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Kopyalama tamamlandı");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Kaynak dosya bulunamadı");
        }
    }

    public CopyFile(String [] args)
    {
        try {
            this.parseCommand(args);
        }
        catch (NumberFormatException ex) {
            System.out.println("Geçersiz blok uzunluğu bilgisi");
            System.exit(-1);
        }
    }

    public void run()
    {
        try {
            this.copy();
        }
        catch (Throwable ex) {
            System.out.println("Belirlenemeyen bir durum oluştu");
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırından aşağıdaki gibi çalışan programı yazınız
        java org.csystem.app.App file1 file2 ... fileN dest

    - Program file1, file2, file3, ..., fileN ile belirtilen dosyaları birleştirerek dest ile belirtilen dosyaya
    ekleyecektir
    - Files sınıfı ve Path arayüzünü kullanabilirsiniz
    - Program kaynak dosyalardan bir bile yoksa mesaj vererek programı sonlandırmalı ve kopyaladığı bilgi varsa bile
    hedef dosyayı silmelidir
    - TODO: Bir önceki maddeyi öncden dosyaların var olup olmadığına bakarak uygulayınız
    - Hedef dosya varsa üzerine yazılacaktır

    Örnek özellikle ArrayList kullanımı için de aşağıdaki gibi yazılmıştır. Kullanılmadan da yazılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.concatfilesapp.ConcatFilesApp;

class App {
    public static void main(String[] args)
    {
        ConcatFilesApp.run(args);
    }
}

package org.csystem.app.samples.concatfilesapp;

public final class ConcatFilesApp {
    private ConcatFilesApp()
    {
    }

    public static void run(String [] args)
    {
        ConcatFiles concatFiles = new ConcatFiles(args);

        concatFiles.run();
    }
}

package org.csystem.app.samples.concatfilesapp;

import org.csystem.util.CommanLineUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ConcatFiles {
    private final ArrayList<Path> m_sourcePaths = new ArrayList<>();
    private File m_destinationFile;

    private void parseCommand(String [] args)
    {
        args = CommanLineUtil.getArguments(args, "Kaynak dosyalar ve hedef dosyaları giriniz:", new Scanner(System.in));

        if (args.length < 2) {
            System.out.println("Kullanım:: java CopyAndBackupApp <file1> <file2> ...<fileN> <destination file>");
            System.exit(-1);
        }

        for (int i = 0; i < args.length - 1; ++i)
            m_sourcePaths.add(Path.of(args[i]));

        m_destinationFile = new File(args[args.length - 1]);
        m_destinationFile.delete();
    }

    private void concat() throws IOException
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream(m_destinationFile, true)) {
            for (Path path : m_sourcePaths)
                Files.copy(path, fileOutputStream);
        }
        catch (NoSuchFileException ex) {
            System.out.println("Kaynak dosya bulunamadı");
            m_destinationFile.delete();
            System.exit(-1);
        }
    }

    public ConcatFiles(String [] args)
    {
        this.parseCommand(args);
    }

    public void run()
    {
        try {
            this.concat();
        }
        catch (Throwable ex) {
            System.out.println("Belirlenemeyen bir durum oluştu");
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Değerleri Byte Dizisine Dönüştürüp Geri Almak

    Mademki stream tabanlı dosya işlemlerinde bir dosyaya biz write metoduyla bir byte dizisi yazabiliyoruz o halde bir
    bilgiyi dosyaya yazmadan önce onu byte dizisine dönüştürmemiz gerekir. Benzer biçimde dosyadan okuduklarımız da
    aslında bir byte dizisinin içerisine yerleştiriliyor. O halde byte dizisinin içerisine okunan bilgileri de yeniden
    ilgili türe dönüştürmemiz gerekir. Java'da temel bir türü byte türden diziye dönüştürmek ve byte türden diziyi
    ilgili temel türe dönüştürmek için ByteBuffer isimli sınıf kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ByteBuffer sınıfı ile int türden bir bilginin byte dizisine çevrilmesi için bir yöntem
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;

class WriterApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0], true)) {
            for (int i = 1; i <= 10; ++i) {
                byte [] data = ByteBuffer.allocate(4).putInt(i).array();

                fileOutputStream.write(data);
            }
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ByteBuffer sınıfının wrap isimli metodu kullanılarak byte türden dizi sarmalanıp ilgili türe dönüştürülebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.Scanner;

class ReaderApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            byte [] buffer = new byte[4];
            int read;

            while ((read = fileInputStream.read(buffer)) > 0) {
                int val = ByteBuffer.wrap(buffer, 0, read).getInt(0);

                System.out.printf("%d ", val);
            }


            System.out.println();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı");
            System.out.printf("Message:%s%n", ex.getMessage());
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    String sınıfının getBytes isimli metodu ile bir yazı byte türden bir diziye çevrilebilir. Aşağıdaki örnekte
    yazılar dosyaya yazılırken yazılan başına kaç byte ile tutuldukları da dosyaya eklenmiştir. Bu tasarımda yazılar
    değişken uzunlukla (variable length) tutulmuştur. Örneğin:
    CSD ve oğuz yazılarının dosya içerisinde tutuluşları aşağıdaki gibidir:
    CSD 3 byte'lık bir yazı:
    oğuz 5 byte'lık bir yazı:
    3xxx5yyyyy
    x'ler CSD yazısının her bir byte'ına karşılık gelmektedir
    y'ler oğuz yazısının her bir byte'ına karşılık gelmektedir
    Dikkat edililirse aşağıdaki örnekte programcı tüm bu işlemleri ayarlamak zorundadır. Yani bu işlem biraz zahmetli
    olabilmektedir. Bu dosya işlemlerinin Java'da en aşağı seviyede yapılan biçimidir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;

class WriterApp {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", kb);

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0], true)) {
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if (text.equals("quit"))
                    break;

                byte [] data = text.getBytes();
                byte [] dataLen = ByteBuffer.allocate(2).putShort((short)data.length).array();

                fileOutputStream.write(dataLen);
                fileOutputStream.write(data);
            }
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    String sınıfının byte türden dizi parametreli ctor elemanı ile bir yazı elde edilebilir. Aşağıdaki işlemlerin
    de zahmetli ve aşağı seviyeli şekilde yapıldığına dikkat ediniz. WriterApp ve ReaderApp örnekleri özellikle
    sadece main içerisinde yazılmıştır. Detaylar gözardı edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Scanner;

class ReaderApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            for (;;) {
                byte [] dataLen = new byte[2];
                int read = fileInputStream.read(dataLen);

                if (read == -1)
                    break;

                if (read != 2)
                    throw new IOException("Dosya formatı bozuk");

                short len = ByteBuffer.wrap(dataLen).getShort(0);
                byte [] data = new byte[len];

                read = fileInputStream.read(data);

                if (read != len)
                    throw new IOException("Dosya formatı bozukx");

                String text = new String(data);

                System.out.println(text);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı");
            System.out.printf("Message:%s%n", ex.getMessage());
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Anahtar Notlar: UTF8 kodlaması UNICODE tablonun sıkıştırılmış biçimini oluşturmakta kullanılır. UTF8'de UNICODE
    bir yazıdaki İngilizce karakterler 1 byte ile, diğer karakterler birden çok byte ile kodlanırlar. Böylece UTF8
    kodlaması ekonomik bir kodlama halini alır. Bu nedenle UTF8 en çok kullanılan karakter kodlamalarından biridir.
    String sınıfının parametresiz getBytes metodu ve yalnızca byte [] parametreli ctor'u plotformun default tablolamasına
    göre çalışırlar. Bu kavrama "charset veya encoding" denilmektedir. Yukarıdaki yazan uygulama örneğin UTF8 ile
    yazmışsa okuyan uygulamanın default platformu UNICODE ise doğru bilgi edilemeyebilir. Bu durumlar için Java'da
    Charset isimli bir arayüz bulunmaktadır. getBytes metodunun ve String'in ctor'unun Charset alan versiyonları da
    bulunmaktadır. Charset en kolay StandardCharsets sınıfının public static ve final elemanları ile kullanılabilir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Yukardaki örneğin platform ne olursa olsun UTF-8 kullanan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class WriterApp {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", kb);

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0], true)) {
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if (text.equals("quit"))
                    break;

                byte [] data = text.getBytes(StandardCharsets.UTF_8);
                byte [] dataLen = ByteBuffer.allocate(2).putShort((short)data.length).array();

                fileOutputStream.write(dataLen);
                fileOutputStream.write(data);
            }
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukardaki örneğin platform ne olursa olsun UTF-8 kullanan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class ReaderApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            for (;;) {
                byte [] dataLen = new byte[2];
                int read = fileInputStream.read(dataLen);

                if (read == -1)
                    break;

                if (read != 2)
                    throw new IOException("Dosya formatı bozuk");

                short len = ByteBuffer.wrap(dataLen).getShort(0);
                byte [] data = new byte[len];

                read = fileInputStream.read(data);

                if (read != len)
                    throw new IOException("Dosya formatı bozukx");

                String text = new String(data, StandardCharsets.UTF_8);

                System.out.println(text);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı");
            System.out.printf("Message:%s%n", ex.getMessage());
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
