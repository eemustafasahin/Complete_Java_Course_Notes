```java
/*----------------------------------------------------------------------------------------------------------------------
    07.11.2020
    BitConverter gibi bir sınıf yazılarak byte dizisi ve temel türler (+ string sınıfı) arasındaki dönüşümler
    daha basitleştirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;
import org.csystem.util.converter.BitConverter;

import java.io.FileOutputStream;
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

                byte [] data = BitConverter.getBytes(text);
                byte [] dataLen = BitConverter.getBytes((short)data.length);

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
    BitConverter gibi bir sınıf yazılarak byte dizisi ve temel türler (+ string sınıfı) arasındaki dönüşümler
    daha basitleştirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;
import org.csystem.util.converter.BitConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

                short len = BitConverter.toShort(dataLen);
                byte [] data = new byte[len];

                read = fileInputStream.read(data);

                if (read != len)
                    throw new IOException("Dosya formatı bozukx");

                String text = BitConverter.toString(data);

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
    Yazma ve Okuma İşlemini Kolaylaştıran Adaptör Sınıflar

    Önceki konularda da gördüğümüz gibi bizim bir blgiyi dosyaya yazabilmemiz için önce onu byte dizisine dönüştürmemiz
    sonra da write metoduyla bu işi yapmamız gerekir. Benzer biçimde bir dosyadan okuma yaparken de biz read metoduyla
    önce istediğimiz bilgiyi byte dizisi olarak okuyup sonra da ilgili türe dönüştürmemiz gerekir. İşte bu işlem biraz
    yorucudur. Üstelik String türü de işin içine girdiğinda yazı değişken uzunlukta tutulacaksa uzunluk bilgisinin
    eklenmesi gibi durumlar da programcının sorumluluğunda olacaktır. Bu işlemleri kendi içerisinde yapan adaptör
    sınıflar vardır. Bu adaptör sınıflar aslında sadece dosya işlemlerinde kullanılmaz. Genel okuma ve yazma sınıflarıdır.
    Yani örneğin bir ağ üzerinde uzak bir makinaya veri gönderme ve alma durumlarında da kullanılabilir.

    Genel olarak yani normal olarak yazma işlemi adaptör sınıfla yapılmışsa okuma işlemi de ilgili adaptör sınıfla ve
    yazmaya karşılık gelen metotla yapılmalıdır. Aksi durumda verinin istenilen kısmı elde edilemeyebilir.

    Anahtar Notlar: Dosyaya yazma yapan ve dosyadan okuma yapan uygulamaların her ikisi de okuma ve yazma işlemini
    adaptör sınıflar yaparsa özellikle String yazma ve okuma için sorun oluşmaz. Ancak yazma işlemi farklı bir
    formatta yapılmışsa bu durumda okuma işleminin de yukarıdaki örneklerde olduğu gibi byte dizisi kullanılması
    gerekebilir. Bu durum genel olarak ikili (binary) dosyalar için geçerlidir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    DataOutputStream sınıfı:
    Bu durumda, DataOutputStream sınıfının writeXXX metotları temel türleri dosyaya yazılabilir. DataOutputStream
    sınıfının bir başlangıç metodu vardır. Bu metot OutputStream referansı alır. Bu sınıfın writeXXX metotları yazdığı
    türü byte dizisine çevirerek OutputStream referansının gösterdiği nesne için write metodunu çağırır. Böylelike
    programcı herhangi bir işlem yapmadan doğrudan istediği temel türü yazabilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    DataOutputStream sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

class WriterApp {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", kb);

        if (args.length != 2) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0], true)) {
            Random r = new Random();
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            int count = Integer.parseInt(args[1]);

            for (int i = 0; i < count; ++i) {
                int val = r.nextInt(100);

                System.out.printf("%d ", val);
                dataOutputStream.writeInt(val);
            }

            System.out.println();
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    DataInputStream sınıfı:
    DataInputStream sınıfı da DataOutputStream sınıfıyla çok benzer biçimde kullanılmaktadır. Bu sınıf da bizden bir
    InputStream parametresi alır. Sınıfın readXXX isminde metotları vardır. Bu metotlar önce bizim verdiğimiz stream’den
    okumayı yaparlar. Sonra da byte dizisini ilgili türe çevirerek geri döndürürler. readXXX metotları dosya (stream)
    sonuna gelindiğinde EOFException nesnesi fırlatırlar
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    DataInputStream sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.DataInputStream;
import java.io.EOFException;
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
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            for (;;) {
                int val = dataInputStream.readInt();

                System.out.printf("%d ", val);
            }
        }
        catch (EOFException ex) {
            System.out.println("\nOkuma tamamlandı");
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
    DataOutputStream sınıfının writeUTF metodu UTF-8 formatında yazıyı dosyaya (stream'e) yazar. Şüphesiz yazının
    uzunluğu gibi bilgileri kendi içerisinde ayarlar. Yani formatı ona göre oluşturur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if (text.equals("quit"))
                    break;

                dataOutputStream.writeUTF(text);
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
    DataInputStream sınıfının readUTF metodu UTF-8 formatında bilgiyi dosyadan (stream'den) okur. Bu metot da dosya
    sonuna gelindiğinde EOFException fırlatır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.DataInputStream;
import java.io.EOFException;
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
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            for (;;) {
                String text = dataInputStream.readUTF();

                System.out.println(text);
            }
        }
        catch (EOFException ex) {
            System.out.println("\nOkuma tamamlandı");
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
    DataOutputStream sınıfında bir yazıyı dosyaya (stream'e yazan) writeBytes ve writeChar metotları da bulunmaktadır.
    writeBytes metodu her bir karakteri writeByte metoduyla yazar yani 1(bir) byte olarak yazar. Bu durumda birden fazla
    byte ile tutulan karakterler için okumada exception oluşabilir. Çünkü readByte metoduyla 1 byte okunur ve exception
    oluşabilir. Aşağıdaki WriterApp örneğinde dosyaya Türkçe karakterlerden oluşan yazılar ekleyiniz ve ReaderApp ile
    okuma sonucu gözlemleyiniz
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    WriterApp
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if (text.equals("quit"))
                    break;

                dataOutputStream.writeBytes(text +  '\n');
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
    ReaderApp
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.DataInputStream;
import java.io.EOFException;
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
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            for (;;) {
                byte ch = dataInputStream.readByte();

                System.out.printf("%c", (byte)ch);
            }
        }
        catch (EOFException ex) {
            System.out.println("\nOkuma tamamlandı");
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
    BufferedReader ve BufferedWriter Sınıfları

    BufferedReader ve BufferedWriter sınıfları yazıyla işlem yapan adaptör sınıflardır. Bu sınıfları DataOutputStream
    ve DataInputStream sınıflarının yazı ile işlem yapan biçimlerine benzetebiliriz. BufferedReader ve BufferedWriter
    sınıfları sırasıyla Reader ve Writer türden referansını parametre olarak bizden alırlar. BufferedWriter sınıfının
    write metotları yazdırma işlemini yapmaktadır. Bu durumda dosyayı bir editörle açtığımızda anlamlı şeyler görürürüz.
    Pekiyi DataOutputStream sınıfı ile BufferedWriter sınıfı arasındaki temel fark nedir? DataOutputStream sınıfı
    bilgiyi byte dizisine dönüştürüp dosyaya yazar. Halbuki BufferedWriter sınıfı bilgiyi bir yazı olarak dosyaya yaza.
    BufferedWriter ve BufferedReader sınıfları da yine sadece dosya için değil genel olarak kullanılabilen sınıflardır.

    Anahtar Notlar: Bu sınıflar "tamponlu (buffered)" olarak çalışırlar. Bilginin yazılması hemnen gerçekleşmeyebilir.
    Bu sebeple programcının yazmanın yapılması durumuna göre kod yazması veya basit olarak yazma işleminin tampondan
    dosyaya (stream'e) hemen yazılması için de flush isimli metodu çağırması gerekir. DataOutputStream sınıfının da
    flush isimli bir metodu vardır. Dosya işlemlerinde kullanılması gerekmez. Ancak BufferedWriter için dosya
    işlemlerinde de gerekir. Tamponlu çalışma konusu ayrıntılı bir konudur. Burada detaylar ele alınmayacaktır.

    Daha önce anlatıldığı gibi satır kavramı özellike Windows sistemleri için farklıdır. Yani bir sonraki satırın başına
    geçmek için windows'da "CRLF" karakter çiftinin kullanıldığını hatırlayınız. Bu sebeple işletim sistemine göre uygun
    satır sonu karakter veya karakterlerinin yazılması için BufferedWriter sınıfının newLine isimli metodu kullanılır.
    BufferedReader ve BufferedWriter sınıfları Closable arayüzünü destekler
----------------------------------------------------------------------------------------------------------------------*/
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    BufferedWriter sınıfının dosya işlemlerinde  kullanımında nesne yaratmak için FileWriter isimli yine
    adaptör bir sınıf Write parametreli ctor'u için kullanılabilir. Dosyalar için genel kalıp aşağıdaki
    gibidir. FileWriter'a charset verilmezse default charset kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.*;
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

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[0], true))) {
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if (text.equals("quit"))
                    break;

                bufferedWriter.write(text);
                bufferedWriter.newLine();
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
    BufferedReader sınıfının dosya işlemlerinde kullanımında nesne yaratmak için FileReader isimli yine
    adaptör bir sınıf Reader parametreli ctor'u için kullanılabilir. Dosyalar için genel kalıp aşağıdaki
    gibidir. FileReader'a charset verilmezse default charset kullanılır. Satır satır okuma yapmak için readLine metodu
    kullanılır. readLine metodu dosya sonuna gelindiğinde null döndürür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.*;
import java.util.Scanner;

class ReaderApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            String line;

            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
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
    Yukarıdaki örneğin kesin UTF-8 ile çalışan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.*;
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

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[0], StandardCharsets.UTF_8, true))) {
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if (text.equals("quit"))
                    break;

                bufferedWriter.write(text);
                bufferedWriter.newLine();
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
    Yukarıdaki örneğin kesin UTF-8 ile çalışan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.*;
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

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8))) {
            String line;

            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
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
    Klavye işlemleri için BufferedReader aşağıdaki gibi kullanılabilir. Sınıfın metotlarının IOException fırlattığına
    dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class App {
    public static void main(String[] args) throws IOException
    {
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String str = kb.readLine();
            byte[] data = str.getBytes(StandardCharsets.UTF_8);

            System.out.printf("Byte length of %s:%d%n", str, data.length);

            if (str.equals("quit"))
                break;
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek Files sınıfının newBufferedWriter metodu ile de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(args[0]), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            for (;;) {
                System.out.print("Bir yazı giriniz:");
                String text = kb.nextLine();

                if (text.equals("quit"))
                    break;

                bufferedWriter.write(text);
                bufferedWriter.newLine();
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
    Yukarıdaki örnek Files sınıfının newBufferedReader metodu ile de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class ReaderApp {
    public static void main(String[] args)
    {
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", new Scanner(System.in));

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8)) {
            String line;

            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
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
    RandomAccessFile Sınıfı
    RandomAccessFile sınıfı ile dosya üzerinde istenilen offset’e konumlanma yapılarak yazma ya da okuma yapılabilir.
    RandomAccessFile sınıfı ile dosyanın açılış moduna göre okuma veya hem okuma hem yazma yapılabilir. RandomAccessFile
    Object sınıfından türetilmiştir. Closeable arayüzünü ve diğer bazı okuma ve yazmaya ilişkin arayüzleri
    desteklemektedir. Sınfın write ve writeXXX metotları ile yazma işlemi yapılabilir. read ve readXXX metotları ile de
    okuma yapılabilir. Sınıfın iki adet başlangıç metodu bulunmaktadır. Başlangıç metotlarının birinci parametreleri
    dosyaya ilişkin isim ya da File referansıdır. Başlangıç metotlarının ikinci parametreleri ortaktır. Bu parametreler
    dosyanın açılış modunu belirlemek için kullanılır. Açılış modları “r”, “rw”, “rws”, “rwd” biçiminde olabilir.
    Bunlar dışındaki değerler exception oluşmasına yol açar:
    “r”     → Yalnızca okuma amaçlı açmak için kullanılır. Dosya yoksa exception oluşur.
    “rw”    → Hem okuma hem de yazma amaçlı kullanılan moddur. Dosya yoksa yaratılır.
    “rws” ve “rwd” açılış modları “New IO” mekanizmasına ilişkindir. Burada ele alınmayacaktır

    RandomAccessFile sınıfı dosyayı her zaman korur. RandomAccessFile sınıfı ile dosya açıldığında dosya göstericisi
    sıfır numaralı offet'i gösterir.

    Dosya Göstericisinin Konumlandırılması
    Sınfın seek metodu ile istenilen bir offsete konumlanılabilir. Sınıfın getFilePointer metodu ile o anki dosya
    göstericisinin nerede olduğu bilgisi alınabilir.
----------------------------------------------------------------------------------------------------------------------*/
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    RandomAccessFile sınıfı ile basit bir örnek. Örnekte hem dosyaya yazma hem de dosyadan okuma yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws IOException
    {
        Scanner kb = new Scanner(System.in);
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", kb);

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        try (RandomAccessFileStandartInputApp randomAccessFileStandartInputApp = new RandomAccessFileStandartInputApp(args[0], kb)) {
            randomAccessFileStandartInputApp.run();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class RandomAccessFileStandartInputApp implements Closeable {
    private final RandomAccessFile m_randomAccessFile;
    private final Scanner m_kb;

    private void runForWrite() throws IOException
    {
        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String text = m_kb.nextLine();

            if (text.equals("quit"))
                break;

            m_randomAccessFile.writeUTF(text);
        }

        System.out.printf("Offset of File Pointer:%d%n", m_randomAccessFile.getFilePointer());
    }

    private void runForRead() throws IOException
    {
        m_randomAccessFile.seek(0); //Dosya göstericisini dosyanın başına konumlandırdık

        try {
            for (;;) {
                String text = m_randomAccessFile.readUTF();

                System.out.printf("%s ", text);
            }
        }
        catch (EOFException ex) {
            System.out.println();
        }
    }

    public RandomAccessFileStandartInputApp(String path) throws IOException
    {
        this(path, new Scanner(System.in));
    }

    public RandomAccessFileStandartInputApp(String path, Scanner kb) throws IOException
    {
        m_randomAccessFile = new RandomAccessFile(path, "rw");
        m_randomAccessFile.seek(m_randomAccessFile.length()); //Dosya göstericisini dosyanın sonuna konumlandırdık
        m_kb = kb;
    }

    public void run() throws IOException
    {
        this.runForWrite();
        this.runForRead();
    }

    public void close() throws IOException
    {
        m_randomAccessFile.close();
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Endian kavramı: Birden fazla byte'dan oluşan değerlerin bellekte tutuluşları sistemden sisteme değişebilmektedir.
    Pratikte iki yerleşim biçimi kullanılmaktadır:
    1. Düşük anlamlı byte değerlerinin ona ayrılan belleğin düşük sayısal adresinde bulunacak biçimde yerleştirilmesine
    "little endian" denir.

    2. Düşük anlamlı byte değerlerinin ona ayrılan belleğin yüksek sayısal adresinde bulunacak biçimde yerleştirilmesine
    "big endian" denir.

    Endian kavramı tamsayılar için kullanılır. Gerçek sayı türleri için IEEE 754 standartlarında endian kavramı
    belirtilmemiştir. Teorik olarak gerçek sayılar için endian değişebilse de pratikte bu durum bir sorun oluşturmaz.

    Java'da tamsayı türleri sistemden bağımsız olarak "big endian" kullanılır
----------------------------------------------------------------------------------------------------------------------*/
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Çalışılan sistemin endian'ının anlaşılması
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;
import package org.csystem.util;

import java.io.IOException;
import java.nio.ByteOrder;

class App {
    public static void main(String[] args) throws IOException
    {
        System.out.printf("Your system is %s%n", SystemUtil.getEndianText());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    ByteBuffer nesnesinin endian çalışma bilgisinin değiştirilmesi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.SystemUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws IOException
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Bir sayı giriniz:");
        short val = Short.parseShort(kb.nextLine());

        ByteBuffer byteBuffer = ByteBuffer.allocate(4).putShort(val);

        System.out.println(SystemUtil.getEndian(byteBuffer));

        SystemUtil.toLittleEndian(byteBuffer);
        System.out.println(SystemUtil.getEndian(byteBuffer));

        val = byteBuffer.getShort(0);

        System.out.printf("val:%d%n", val);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Standart cihaz bağımsız bitmap (Device Independent Bitmap) dosyasında resmin genişliği ve uzunluğu
    dosyanın başından itibaren 18'inci ve 22'inci offsetlerde int bir bilgi olarak tutulmaktadır. Formata göre bu bilgi
    "little endian" olarak yazılmıştır. Bu bilgiyi bir resim dosyasından alıp ekrana yazdıran programı yazınız. Program
    resmin geçerliliği gibi detaylı kontrolleri yapmayacaktır.
    Program açıklayıcı olması açısından sadece main içerisinde yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CommanLineUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws IOException
    {
        Scanner kb = new Scanner(System.in);
        args = CommanLineUtil.getArguments(args, "Yol ifadesini giriniz", kb);

        if (args.length != 1) {
            System.out.println("Wrong usage");
            System.exit(-1);
        }

        byte [] data = new byte[4];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "r")) {
            randomAccessFile.seek(18);
            randomAccessFile.read(data);
            int width = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
            randomAccessFile.read(data);
            int height = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();

            System.out.printf("%d x %d%n", width, height);
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıdaki açıklanan programı yazınız:
    - Program içerisinde bir menü olacaktır
    - Menüler sırasıyla "Ekle", "Listele" ve çıkış şeklindedir
    - Cihazlara ilişkin bilgiler (id, name, host) devices.dat isimli bir dosyada saklanacaktır
    - Dosya programın sonuna kadar açık kalacaktır
    - Örnek basit olması açısından dosya formatı kontrolü yapılmamıştır
    - Fonksiyonel programlama kullanılarak daha iyi şekilde yazılabilir (Uygulama kursunda ele alınacaktır)
    - TODO: Dosyanın sürekli açık kalmayan versiyonunu yazınız
    - Dosya kapatım
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.devicesapp.DevicesPersistenceApp;

class App {
    public static void main(String[] args)
    {
        DevicesPersistenceApp.run();
    }
}

package org.csystem.app.samples.devicesapp;

public final class DevicesPersistenceApp {
    private DevicesPersistenceApp()
    {
    }

    public static void run()
    {
        try (DevicesPersistence devicesPersistence = new DevicesPersistence("devices.dat")) {
            devicesPersistence.run();
        }
        catch (Throwable ex) {
            System.out.println("Beklenmedik bir durum oluştu. Uygulama sonlanıyor...");
        }
    }
}
package org.csystem.app.samples.devicesapp;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class DevicesPersistence implements Closeable {
    private final Scanner m_kb = new Scanner(System.in);
    private final  RandomAccessFile m_randomAccessFile;

    private void displayMenu()
    {
        System.out.println("1.Ekle");
        System.out.println("2.Listele");
        System.out.println("3.Çıkış");
        System.out.print("Seçenek:");
    }

    private void insertProc() throws IOException
    {
        System.out.print("id değerini giriniz:");
        int id = Integer.parseInt(m_kb.nextLine());

        System.out.print("Adını giriniz:");
        String name = m_kb.nextLine();

        System.out.print("Ip adresini giriniz:");
        String host = m_kb.nextLine();

        m_randomAccessFile.seek(m_randomAccessFile.length());
        m_randomAccessFile.writeInt(id);
        m_randomAccessFile.writeUTF(name);
        m_randomAccessFile.writeUTF(host);
    }

    private void listProc() throws IOException
    {
        try {
            m_randomAccessFile.seek(0);
            for (;;) {
                int id = m_randomAccessFile.readInt();
                String name = m_randomAccessFile.readUTF();
                String host = m_randomAccessFile.readUTF();

                System.out.printf("[%d]%s-%s%n", id, name, host);
            }
        }
        catch (EOFException ex) {
            System.out.println("Okuma tamamlandı");
        }
    }

    private void exitProc()
    {
        System.out.println("C ve Sistem Programsıları Derneği");
        System.out.println("Tekrar yapıyor musunuz?");
        System.exit(0);
    }

    private void doWorkForOption(int option) throws IOException
    {
        switch (option) {
            case 1:
                this.insertProc();
                break;
            case 2:
                listProc();
                break;
            case 3:
                exitProc();
                break;
            default:
                System.out.println("Geçersiz seçenek");
        }
    }

    public DevicesPersistence(String path) throws IOException
    {
        m_randomAccessFile = new RandomAccessFile(path, "rw");
    }

    public void run()
    {
        for (;;) {
            try {
                this.displayMenu();
                this.doWorkForOption(Integer.parseInt(m_kb.nextLine()));
            }
            catch (NumberFormatException ex) {
                System.out.println("Geçersiz giriş");
            }
            catch (Throwable ex) {
                System.out.println("Beklenmedik bir durum oluştu");
            }
        }
    }

    public void close() throws IOException
    {
        m_randomAccessFile.close();
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Dosyalar ve genel olarak giriş/çıkış işlemleri için Java'da daha başka sınıflar da vardır. Burada dosya işlemlerine
    yönelik temel olan sınıflar anlatılmıştır
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	CommandLineUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Scanner;

public final class CommanLineUtil {
    private CommanLineUtil()
    {}

    public static String [] getArguments(String [] args, String prompt, Scanner scanner)
    {
        if (args.length > 0)
            return args;

        System.out.print(prompt + ":");

        return scanner.nextLine().split("[ \t]+");
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	SystemUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class SystemUtil {
    private SystemUtil()
    {
    }

    public static String getEndianText()
    {
        return isLittleEndian() ? "LITTLE ENDIAN" : "BIG ENDIAN";
    }

    public static ByteOrder getEndian(ByteBuffer byteBuffer)
    {
        return byteBuffer.order();
    }

    public static void toLittleEndian(ByteBuffer byteBuffer)
    {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static void toBigEndian(ByteBuffer byteBuffer)
    {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public static boolean isLittleEndian()
    {
        return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    }
}
```
```java
/*----------------------------------------------------------------------
	FILE        : BitConverter.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 05.10.2020

	BitConverter class for byte operations with built-in types

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.converter;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class BitConverter {
	private static ByteBuffer allocate(int capacity)
	{
		return ByteBuffer.allocate(capacity);
	}

	private static ByteBuffer wrap(byte [] data, int offset, int length)
	{
		return ByteBuffer.wrap(data, offset, length);
	}

	private BitConverter()
	{
	}

	public static byte [] getBytes(String str)
	{
		return getBytes(str, StandardCharsets.UTF_8);
	}

	public static byte [] getBytes(String str, Charset charset)
	{
		return str.getBytes(charset);
	}

	public static byte [] getBytes(byte value)
	{
		return new byte [] {value};
	}

	public static byte[] getBytes(short value)
	{
		return allocate(2).putShort(value).array();
	}

	public static byte[] getBytes(int value)
	{
		return allocate(4).putInt(value).array();
	}

	public static byte[] getBytes(long value)
	{
		return allocate(8).putLong(value).array();
	}

	public static byte[] getBytes(char value)
	{
		return allocate(2).putChar(value).array();
	}

	public static byte[] getBytes(double value)
	{
		return allocate(8).putDouble(value).array();
	}

	public static byte[] getBytes(float value)
	{
		return allocate(4).putFloat(value).array();
	}

	public static byte[] getBytes(boolean value)
	{
		return new byte[] {(byte)(value ? 1 : 0)};
	}

	public static String toString(byte [] data)
	{
		return toString(data, StandardCharsets.UTF_8);
	}

	public static String toString(byte [] data, Charset charset)
	{
		return new String(data, charset);
	}

	public static short toShort(byte [] data)
	{
		return toShort(data, 0);
	}

	public static short toShort(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 2).getShort();
	}

	public static int toInt(byte [] data)
	{
		return toInt(data, 0);
	}

	public static int toInt(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 4).getInt();
	}

	public static long toLong(byte [] data)
	{
		return toLong(data, 0);
	}

	public static long toLong(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 8).getLong();
	}

	public static char toChar(byte [] data)
	{
		return toChar(data, 0);
	}

	public static char toChar(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 2).getChar();
	}

	public static double toDouble(byte [] data)
	{
		return toDouble(data, 0);
	}

	public static double toDouble(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 8).getDouble();
	}

	public static float toFloat(byte [] data)
	{
		return toFloat(data, 0);
	}

	public static float toFloat(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 4).getFloat();
	}

	public static boolean toBoolean(byte [] data)
	{
		return toBoolean(data, 0);
	}

	public static boolean toBoolean(byte [] data, int startIndex)
	{
		return data[startIndex] != 0;
	}
}



/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
```
