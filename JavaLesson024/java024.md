```java
/*----------------------------------------------------------------------------------------------------------------------
    24.10.2020
    Arayüzlerle İlgili Tür Dönüştürmeleri

    Arayüzlerle ilgili tür dönüştürmeleri dört durum olarak ele alınabilir:

    1. Bir sınıf referansının onun desteklediği bir arayüz referansına dönüştürülmesi

    2. Bir arayüz referansının herhangi bir sınıf türüne dönüştürülmesi

    3. Bir arayüz referansının başka bir arayüz referansına dönüştürülmesi

    4. Bir sınıf referansının onun desteklemediği bir arayüz referansına dönüştürülmesi
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	1. Bir sınıf referansının onun desteklediği bir arayüz referansına dönüştürülmesi doğrudan yapılabilir
	Bu durum çok aşikar bir durumdur. Arayüz referansının taban sınıf referansı gibi kullanılmasıdır. Zaten interface'in
	hedeflerinden biri de budur.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();

        IX ix = a;
    }
}

class A implements IX {

}

interface IX {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	2. Bir arayüz referansının herhangi bir sınıf türüne dönüştürülmesi:
	Bu dönüşüm tür dönüştürme operatörü ile yapılmalıdır. Ancak çalışma zamanı sırasında arayüz referansının dinamik
	türünün dönüştürülecek sınıfı kapsayıp kapsamadığına bakılır. Kapsıyorsa haklı dönüşümdür. Kapsamıyorsa haksız
	dönüşümdür. ClassCastException nesnesi fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        B b = (B) ix; //Haklı dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class A extends B implements IX {

}

class B {
    //...
}

interface IX {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	2. Bir arayüz referansının herhangi bir sınıf türüne dönüştürülmesi:
	Bu dönüşüm tür dönüştürme operatörü ile yapılmalıdır. Ancak çalışma zamanı sırasında arayüz referansının dinamik
	türünün dönüştürülecek sınıfı kapsayıp kapsamadığına bakılır. Kapsıyorsa haklı dönüşümdür. Kapsamıyorsa haksız
	dönüşümdür. ClassCastException nesnesi fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IX ix = a;

        B b = (B) ix; //Haksız dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class A implements IX {

}

class B {
    //...
}

interface IX {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	3. Bir arayüz referansının başka bir arayüz referansına dönüştürülmesi:
	Bu durum iki şekilde incelenebilir:
	- Kaynak arayüz referansına ilişkin tür hedef arayüz referansına ilişkin türden türetilmişse doğrudan yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IY iy = a;
        IX ix;

        ix = iy; //upcasting
        //...
    }
}


class A implements IY {

}

interface IY extends IX {

}

interface IX {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	3. Bir arayüz referansının başka bir arayüz referansına dönüştürülmesi:
	Bu durum iki şekilde incelenebilir:
	- Kaynak arayüz referansına ilişkin tür hedef arayüz referansına ilişkin türden türetilMEmişse tür dönüştürme
	operatörü ile yapılabilir. Bu durumda çalışma zamanı sırasında kaynak arayüz referansının dinamik türünün hedef
	arayüzü destekleyip desteklemediğine bakılır. Destekliyorsa haklı dönüşüdür. Desteklemiyorsa haksız dönüşümdür.
	ClassCastException fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IY iy = a;
        IX ix = (IX) iy; //Haklı dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}


class A  implements IY, IX {

}

interface IY {
    //...
}

interface IX {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	3. Bir arayüz referansının başka bir arayüz referansına dönüştürülmesi:
	Bu durum iki şekilde incelenebilir:
	- Kaynak arayüz referansına ilişkin tür hedef arayüz referansına ilişkin türden türetilMEmişse tür dönüştürme
	operatörü ile yapılabilir. Bu durumda çalışma zamanı sırasında kaynak arayüz referansının dinamik türünün hedef
	arayüzü destekleyip desteklemediğine bakılır. Destekliyorsa haklı dönüşüdür. Desteklemiyorsa haksız dönüşümdür.
	ClassCastException fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A();
        IY iy = a;
        IX ix = (IX) iy; //Haksız dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}


class A implements IY {

}

interface IY {
    //...
}

interface IX {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	3. Bir arayüz referansının başka bir arayüz referansına dönüştürülmesi:
	Bu durum iki şekilde incelenebilir:
	- Kaynak arayüz referansına ilişkin tür hedef arayüz referansına ilişkin türden türetilMEmişse
	tür dönüştürme operatörü ile yapılabilir. Bu durumda çalışma zamanı sırasında kaynak arayüz referansının
	dinamik türünün hedef arayüzü destekleyip desteklemediğine bakılır. Destekliyorsa haklı dönüşüdür.
	Desteklemiyorsa haksız dönüşümdür. ClassCastException fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new B();
        IY iy = a;
        IX ix = (IX)iy; //Haklı dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class B extends A implements IX {

}

class A implements IY {

}

interface IY {

}

interface IX {

}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	3. Bir arayüz referansının başka bir arayüz referansına dönüştürülmesi:
	Bu durum iki şekilde incelenebilir:
	- Kaynak arayüz referansına ilişkin tür hedef arayüz referansına ilişkin türden türetilMEmişse
	tür dönüştürme operatörü ile yapılabilir. Bu durumda çalışma zamanı sırasında kaynak arayüz referansının
	dinamik türünün hedef arayüzü destekleyip desteklemediğine bakılır. Destekliyorsa haklı dönüşüdür.
	Desteklemiyorsa haksız dönüşümdür. ClassCastException fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new B();
        IY iy = a;
        IX ix = (IX)iy; //Haksız dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class B extends A {

}

class A implements IY {

}

interface IY {

}

interface IX {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	4. Bir sınıf referansının onun desteklemediği bir arayüz referansına dönüştürülmesi:
	Bu işlem tür dönüştürme operatörü ile yapılabilir. Çalışma zamanı sırasında kaynak referansın
	dinamik türünün hedef arayüzü destekleyip desteklemediğine bakılır. Destekliyorsa haklı dönüşümdür.
	Desteklemiyorsa haksız dönüşümdür. ClassCastException fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new B();
        IX ix = (IX) a; //Haklı dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class B extends A implements IX {

}

class A {

}

interface IX {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	4. Bir sınıf referansının onun desteklemediği bir arayüz referansına dönüştürülmesi:
	Bu işlem tür dönüştürme operatörü ile yapılabilir. Çalışma zamanı sırasında kaynak referansın
	dinamik türünün hedef arayüzü destekleyip desteklemediğine bakılır. Destekliyorsa haklı dönüşümdür.
	Desteklemiyorsa haksız dönüşümdür. ClassCastException fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new B();
        IX ix = (IX)a; //Haksız dönüşüm

        System.out.println("Tekrar yapıyor musunuz?");
    }
}

class B extends A {

}

class A {

}

interface IX {

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Nesne Klonlanması: Bir nesnenin o anki durumunun (state) kopyasının çıkartılmasına klonlama denir. Klonlama işleminden
    sonra her iki nesne de ayrı nesneler olarak yaşamaya devam ederler.

    Bir nesnenin kopyası kendisi tarafından çıkartılabilir. Çünkü sınıfın private veri elemanları olabilir. Bu
    elemanların da kopyasının çıkartılması gerekir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Cloneable arayüzü: Bu arayüz bir nesnenin klonlanabileceğini belirtir. Bu arayüzü destekleyen sınıflar clone
	isimli bir metodu yazarlar. Aslında Cloneable arayüzü işaretleme arayüzüdür. Maaalesef bu yanlış bir tasarımdır.
	Bu arayüzü destekleyen sınıflar Object sınıfının içerisinde protected olarak bildirilmiş clone metodunu override
	ederler. clone metodu zorunlu olmasa da Cloneable arayüzünü destekleyen sınıflar için public override edilmelidir.
	Bunun prtaikte istisnası yoktur ve olmamalıdır
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Basit bir klonlama işlemi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample(10);

        System.out.println("s:");
        s.foo();
        System.out.printf("s.x=%d%n", s.getX());

        Sample clone = (Sample) s.clone();

        System.out.println("clone:");
        clone.foo();
        System.out.printf("clone.x=%d%n", clone.getX());

        System.out.println("s:");
        s.foo();
        System.out.printf("s.x=%d%n", s.getX());
    }
}

class Sample implements Cloneable {
    private final int m_x;
    private boolean m_flag;

    public Sample(int x)
    {
        m_x = x;
    }

    public int getX() {return m_x;}

    public void foo()
    {
        System.out.printf("Before:m_flag=%b%n", m_flag);
        m_flag = !m_flag;
        System.out.printf("After:m_flag=%b%n", m_flag);
    }

    public Object clone()
    {
        Sample s = new Sample(m_x);

        s.m_flag = m_flag;

        return s;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıf içerisinde bir referans bildirilmişse kopyalama işlemi iki şekilde yapılabilir: sığ (shallow) kopyalama,
	derin (deep) kopyalama

	Kopyalanacak nesneye ilişin sınıfın içinde bulunan referansa ilişkin nesnenin kopyası çıkartılmıyor ise sığ kopyalama,
	çıkartılıyor ise derin kopyalamadır.

	Derin kopyalama yapabilmek için içerde tutulan referansa ilişkin sınıfın da Cloneable olması gerekir.

	Sınıf tasarımında clone metoduna bakılarak kopyalamanın derin veya sığ olup olmadığı anlaşılamaz. Bu durum
	sınıfın clone metodunun dökümantasyonuna bakılarak anlaşılabilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Basit bir sığ kopyalama (shallow copy) örneği
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A(10);
        B b = new B(23, a);

        B clone = (B) b.clone();

        System.out.printf("b.a.x=%d%n", b.getA().getX());
        System.out.printf("clone.a.x=%d%n", clone.getA().getX());
        System.out.printf("b.y=%d%n", b.getY());
        System.out.printf("clone.y=%d%n", clone.getY());

        b.getA().setX(45);
        b.setY(89);

        System.out.println("**************");
        System.out.printf("b.a.x=%d%n", b.getA().getX());
        System.out.printf("clone.a.x=%d%n", clone.getA().getX());
        System.out.printf("b.y=%d%n", b.getY());
        System.out.printf("clone.y=%d%n", clone.getY());
    }
}

class B implements Cloneable {
    private int m_y;
    private A m_a;

    public B(int y, A a)
    {
        m_y = y;
        m_a = a;
    }

    public int getY()
    {
        return m_y;
    }

    public void setY(int y)
    {
        m_y = y;
    }

    public A getA()
    {
        return m_a;
    }

    public void setA(A a)
    {
        m_a = a;
    }

    public Object clone()
    {
        B b = new B(m_y, m_a);

        return b;
    }
}

class A {
    private int m_x;

    public A(int x)
    {
        m_x = x;
    }

    public int getX()
    {
        return m_x;
    }

    public void setX(int x)
    {
        m_x = x;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Basit bir derin kopyalama (deep copy) örneği
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A a = new A(10);
        B b = new B(23, a);

        B clone = (B)b.clone();

        System.out.printf("b.a.x=%d%n", b.getA().getX());
        System.out.printf("clone.a.x=%d%n", clone.getA().getX());
        System.out.printf("b.y=%d%n", b.getY());
        System.out.printf("clone.y=%d%n", clone.getY());

        b.getA().setX(45);
        b.setY(89);

        System.out.println("**************");
        System.out.printf("b.a.x=%d%n", b.getA().getX());
        System.out.printf("clone.a.x=%d%n", clone.getA().getX());
        System.out.printf("b.y=%d%n", b.getY());
        System.out.printf("clone.y=%d%n", clone.getY());
    }
}

class B implements Cloneable {
    private int m_y;
    private A m_a;

    public B(int y, A a)
    {
        m_y = y;
        m_a = a;
    }

    public int getY()
    {
        return m_y;
    }

    public void setY(int y)
    {
        m_y = y;
    }

    public A getA()
    {
        return m_a;
    }

    public void setA(A a)
    {
        m_a = a;
    }

    public Object clone()
    {
        B b = new B(m_y, (A)m_a.clone());

        return b;
    }
}

class A implements Cloneable {
    private int m_x;

    public A(int x)
    {
        m_x = x;
    }

    public int getX()
    {
        return m_x;
    }

    public void setX(int x)
    {
        m_x = x;
    }
    public Object clone()
    {
        return new A(m_x);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	clone metodu aşağıdaki gibi override edilirse (covariant return type) downcasting yapılmadan da çağrılabilir.
	Ancak bu yaklaşım Java' da çok tercih edilmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample(10);

        System.out.println("s:");
        s.foo();

        Sample clone = s.clone();

        System.out.println("clone:");
        clone.foo();

        System.out.println("s:");
        s.foo();
    }
}

class Sample implements Cloneable {
    private final int m_x;
    private boolean m_flag;

    public Sample(int x)
    {
        m_x = x;
    }

    public int getX() {return m_x;}

    public void foo()
    {
        System.out.printf("Before:m_flag=%b%n", m_flag);
        m_flag = !m_flag;
        System.out.printf("After:m_flag=%b%n", m_flag);
    }

    public Sample clone()
    {
        Sample s = new Sample(m_x);

        s.m_flag = m_flag;

        return s;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayList sınıfı sığ kopyalama yapar. Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList devices = new ArrayList();

        devices.add(new DeviceInfo(1, "test", 5050));
        devices.add(new DeviceInfo(2, "sensor", 5051));
        devices.add(new DeviceInfo(3, "mest", 5698));

        System.out.printf("devices:%s%n", devices);

        ArrayList clone = (ArrayList)devices.clone();

        System.out.printf("clone:%s%n", clone);

        System.out.println("********************");

        ((DeviceInfo)clone.get(1)).setName("SENSOR");

        System.out.printf("devices:%s%n", devices);
        System.out.printf("clone:%s%n", clone);
    }
}

class DeviceInfo {
    private int m_id;
    private String m_name;
    private int m_port;

    public DeviceInfo() {}

    public DeviceInfo(int id, String name, int port)
    {
        //...
        m_id = id;
        m_name = name;
        m_port = port;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        //...
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        //...
        m_name = name;
    }

    public int getPort()
    {
        return m_port;
    }

    public void setPort(int port)
    {
        //...
        m_port = port;
    }

    public String toString()
    {
        return String.format("[%d]%s:%d", m_id, m_name, m_port);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte clone referansına ilişkin nesnenin (ArrayList) içerisindeki bir bilgi değiştirilmiştir.
	Yani artık clone yeni adresteki nesneyi görmektedir. Orjinal nesne bundan etkilenmez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList devices = new ArrayList();

        devices.add(new DeviceInfo(1, "test", 5050));
        devices.add(new DeviceInfo(2, "sensor", 5051));
        devices.add(new DeviceInfo(3, "mest", 5698));

        System.out.printf("devices:%s%n", devices);

        ArrayList clone = (ArrayList)devices.clone();

        System.out.printf("clone:%s%n", clone);

        System.out.println("********************");

        clone.set(1, new DeviceInfo(2, "SENSOR", 6767));

        System.out.printf("devices:%s%n", devices);
        System.out.printf("clone:%s%n", clone);
    }
}

class DeviceInfo {
    private int m_id;
    private String m_name;
    private int m_port;

    public DeviceInfo() {}

    public DeviceInfo(int id, String name, int port)
    {
        //...
        m_id = id;
        m_name = name;
        m_port = port;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        //...
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        //...
        m_name = name;
    }

    public int getPort()
    {
        return m_port;
    }

    public void setPort(int port)
    {
        //...
        m_port = port;
    }
    public String toString()
    {
        return String.format("[%d]%s:%d", m_id, m_name, m_port);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte devices referansına ilişkin ArrayList nesnesine yeni bir eleman eklenmiştir. clone
	referansına ilişkin ArrayList nesnesinin bundan haberi olmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList devices = new ArrayList();

        devices.add(new DeviceInfo(1, "test", 5050));
        devices.add(new DeviceInfo(2, "sensor", 5051));
        devices.add(new DeviceInfo(3, "mest", 5698));

        System.out.printf("devices:%s%n", devices);

        ArrayList clone = (ArrayList)devices.clone();

        System.out.printf("clone:%s%n", clone);

        System.out.println("********************");

        devices.add(new DeviceInfo(5, "weathersensor", 9898));

        System.out.printf("devices:%s%n", devices);
        System.out.printf("clone:%s%n", clone);
    }
}

class DeviceInfo {
    private int m_id;
    private String m_name;
    private int m_port;

    public DeviceInfo() {}

    public DeviceInfo(int id, String name, int port)
    {
        //...
        m_id = id;
        m_name = name;
        m_port = port;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        //...
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        //...
        m_name = name;
    }

    public int getPort()
    {
        return m_port;
    }

    public void setPort(int port)
    {
        //...
        m_port = port;
    }
    public String toString()
    {
        return String.format("[%d]%s:%d", m_id, m_name, m_port);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bazı durumlarda nesne içerisinde bir takım kaynaklar (resources) kullanılıyor olabilir. Bu kaynakların kullanılmaya
	başlanmasına mantıksal olarak "kaynağın açılması" dersek kaynak kullanımı bittikten sonra bu kaynağın
	artk mantıksal olarak "kapatılması" yani artık serbest bırakılması gerekebilir. Java' da nesneler garbage collector
	tarafından yok edildiğinden kullanılan kaynağı geri bırakmak için nesnenin ölmesi beklenmez. Çünkü örneğin
	bu kaynak iş bittikten sonra başka bir nesne tarafından tekrar kullanılmaya başlayabilir. Bu durumda eskiden kullanan
	nesne ölmezse yeni nesne bu kaynağın kullanımına başlayamayabilir. Burada kaynak olarak belirttiğimiz bir dosya,
	bir cihaz vb. olabilir. Böylesi bir durumda Closeable arayüzü kullanılır. Closeable arayüzü close metoduna sahiptir.
	Anlatılana benzer kaynağı kullanan sınıf Closeable arayüzünü destekler ve bu sınıfı kullanan programcı (client) kaynakla
	işi bittikten sonra close metodunu çağırır. Java'da Closeable arayüzünü destekleyen bir sınıfı gören programcı
	yukarıdaki anlatılanları bilir ve close metodunu çağırması gerektiğini anlar.
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte finally bloğunda çağrılan close metodu try-catch içerisine alınarak checked exception fırlatmasından
	dolayı oluşan error engellenmiştir.	Ancak çoğu zaman (her zaman değil) close metodunun exception fırlatması
	durumu programın ilgileneceği birşey değildir. Yani açık olan bir kaynağın close yapılamaması durumunda çoğu zaman
	programcının yapabileceği birşey yoktur. Dolayısıyla aşağıdaki örnekte finally içerisinde try-catch kullanılması
	checked exception probleminden dolayı yapılmıştır. Yani aslında gereksiz bir kod yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        Connection con  = null;

        try {
            con = new Connection("postgresql:jdbc://localhost:8080/devicesdb");
            con.doWork();
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (con != null)
                    con.close();
            }
            catch (Exception ex) {
               //...
            }
        }
    }
}

class Connection implements Closeable {
    private final String m_url;

    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }

    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }

}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problem aşağıdaki gibi daha az karmaşık ve biraz daha okunabilir olarak çözülebilir.
	Ayrıca bu yaklaşımda close metodu için exception işlenmesi de yapılabilir. Ancak üstteki örnekte close
	için yapılacak exception işlenmesi ayrıca yapılmak zorundadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        Connection con  = null;

        try {
            try {
                con = new Connection("postgresql:jdbc://localhost:8080/devicesdb");
                con.doWork();
            }
            finally {
                if (con != null)
                    con.close();
            }
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Connection implements Closeable {
    private final String m_url;
    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }
}
```
```java


/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örnek aşağıdaki gibi daha okunabilir hale getirilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        Connection con  = null;

        try {
            ConnectionUtil.doWorkForConnection("postgresql:jdbc://localhost:8080/devicesdb");
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class ConnectionUtil {
    public static void doWorkForConnection(String url) throws IOException
    {
        Connection con = null;

        try {
            con = new Connection(url);
            con.doWork();
        }
        finally {
            if (con != null)
                con.close();
        }
    }
}

class Connection implements Closeable {
    private final String m_url;
    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 7 ile birlikte eklenen try-with resources (twr) deyimi ile yukarıdaki problem çok daha etkin olarak çözülebilir.
	twr deyimi ile AutoCloseable arayüzünü destekleyen sınıflar kullanılabilir. twr yukarıdaki işlemin
	otomatik olarak yapılanı biçiminde düşünülebilir. Closeable arayüzü AutoCloseable arayüzünden türetilmiştir.
	Bu deyim ile close metodunun çağrılacağı da garanti altında olduğundan programcının çağırmayı unutması gibi
	bir durum da yaşanmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        try (Connection con = new Connection("postgresql:jdbc://localhost:8080/devicesdb")) {
            con.doWork();
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Connection implements Closeable {
    private final String m_url;

    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	twr birden fazla sınıf ile de kullanılabilir. Bu durumda close yaratılma sırasının tersinde çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        try (Connection con = new Connection("postgresql:jdbc://localhost:8080/devicesdb");
             Image image = new Image("tatil.png")) {
            con.doWork();
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Connection implements Closeable {
    private final String m_url;
    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }
}


class Image implements Closeable {
    private final String m_filename;

    public Image(String filename)
    {
        //...
        m_filename  = filename;
        System.out.printf("%s image opened%n", m_filename);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on image '%s'%n", m_filename);
    }
    public void close() throws IOException
    {
        System.out.println("Image closed");
    }

}

/*----------------------------------------------------------------------------------------------------------------------
	twr paranetezi içerisinde yaratılan nesnelere ilişkin referanslar final kabul edilir (effectively final)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        try (Connection con = new Connection("postgresql:jdbc://localhost:8080/devicesdb");
             Image image = new Image("tatil.png")) {
            con = new Connection("test"); //error
            con.doWork();
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Connection implements Closeable {
    private final String m_url;
    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }

}

class Image implements Closeable {
    private String m_filename;
    public Image(String filename)
    {
        //...
        m_filename  = filename;
        System.out.printf("%s image opened%n", m_filename);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on image '%s'%n", m_filename);
    }
    public void close() throws IOException
    {
        System.out.println("Image closed");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 9 ile birlikte twr'den önce yaratılmış olan nesnelere ilişkin referanslar da twr parantezi içerisinde
	kullanılabilmektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        Connection con = new Connection("postgresql:jdbc://localhost:8080/devicesdb");
        Image image = new Image("tatil.png");

        try (con; image) { //Since Java 9
            con.doWork();
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Connection implements Closeable {
    private final String m_url;

    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }
}

class Image implements Closeable {
    private final String m_filename;
    public Image(String filename)
    {
        //...
        m_filename  = filename;
        System.out.printf("%s image opened%n", m_filename);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on image '%s'%n", m_filename);
    }
    public void close() throws IOException
    {
        System.out.println("Image closed");
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	twr parantezi içerisinde kullanılan referanslar yine final etkisi gösterir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        Connection con = new Connection("postgresql:jdbc://localhost:8080/devicesdb");
        Image image = new Image("tatil.png");

        try (con; image) { //error
            con.doWork();
            con = new Connection("test");
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Connection implements Closeable {
    private final String m_url;
    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }
}

class Image implements Closeable {
    private final String m_filename;
    public Image(String filename)
    {
        //...
        m_filename  = filename;
        System.out.printf("%s image opened%n", m_filename);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on image '%s'%n", m_filename);
    }
    public void close() throws IOException
    {
        System.out.println("Image closed");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	twr parantezi içerisinde kullanılan referanslar yine final etkisi gösterir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.io.Closeable;
import java.io.IOException;

class App {
    public static void main(String [] args)
    {
        Connection con = new Connection("postgresql:jdbc://localhost:8080/devicesdb");
        Image image = new Image("tatil.png");


        try (con; image) { //error
            con.doWork();

        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        con = new Connection("test");
    }
}

class Connection implements Closeable {
    private final String m_url;
    public Connection(String url)
    {
        //...
        m_url = url;
        System.out.printf("Connected to:%s%n", m_url);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on connection at '%s'%n", m_url);
    }
    public void close() throws IOException
    {
        System.out.println("Connection closed");
    }
}

class Image implements Closeable {
    private final String m_filename;
    public Image(String filename)
    {
        //...
        m_filename  = filename;
        System.out.printf("%s image opened%n", m_filename);
    }

    public void doWork()
    {
        //...
        System.out.printf("Working on image '%s'%n", m_filename);
    }
    public void close() throws IOException
    {
        System.out.println("Image closed");
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	twr bloğu yalnız başına olabilir. Scanner sınıfı Closeable arayüzünü destekler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        try (Scanner kb = new Scanner(System.in)) {
            System.out.print("Bir sayı giriniz:");
            int val = Integer.parseInt(kb.nextLine());

            System.out.println(val * val);
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic kavramı derleme zamanında türden bağımsız kod yazabilmek için tasarlanmıştır. Programcı generic bir tür
	ya da metodu türden bağımsız olarak yazar. Generic sınıf ya da metotları kullanan programcı	da hangi türde
	kullanacağına karar vererek aşağıda anlatılan özelliklere göre daha güvenli ve okunabilir kodlar yazabilir.
	Generic'ler kullanılarak derleme zamanında çok biçimli (compile time polymorphism) kodlar yazılabilmektedir.
	Generic Türler: Generic olabilecek türler şunlardır: Sınıflar, arayüzler
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıf bildiriminde generic parametreler denen isimler kullanılır. Bu isimler açısal parantezler arasında
	virgülle ayrılacak şekilde sınıf isminden sonra yazılır. Generic parametreler değişken isimlendirme kurallarına
	uygun isimlerdir. Bu isimler bildirildikleri sınıf boyunca geçerlidir (class scope, sınıf faaliyet alanı). Generic
	parametre ismi bir tür ismi anlamına gelir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class A<T> { // T generic parametre
    //...
    private T m_t;
}


abstract  class B<T, K, L> { //T, K ve L generic parametreler
    //...
    public abstract T foo(K k, L l);
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıflar açılım (expansion) ile kullanılabilir. Açılım generic parametrenin türünü belirtir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<String> a; // A nın String açılımı
        A<Integer> b; // A nın Integer açılımı
        A<Boolean> c; // A nın Boolean açılımı
    }
}

class A<T> { // T generic parametre
    //...
    private T m_t;
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıf açılımsız kullanılırsa generic parametreler Object kabul edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A a; // T Object kabul edilir

	}
}

class A<T> { // T generic parametre
	//...
	private T m_t;
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic açılımlar temel türlerle yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
	public static void main(String [] args)
	{
		A<int> a; // error

	}
}

class A<T> { // T generic parametre
	//...
	private T m_t;
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problem sarmalayan sınıflar ile açılım yapılarak çözülebilir. Yani generic parametre olarak temel türlerin
	kullanılacağı generic bir sınıf (ve metot) için sarmalayan sınıflar açılımda kullanılmalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<Integer> x;
        A<Boolean> y;
        A<Float> z;
        //...


    }
}

class A<T> { // T generic parametre
    //...
    private T m_t;
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıflar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<Boolean, String> a;
        A<Integer, Boolean> b;
        //...
    }
}

class A<T, K> {
    //...

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıflar türünden nesne yaratılması aşağıdaki gibi yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<Boolean, String> x = new A<Boolean, String>();
        A<Integer, Float> y = new A<Integer, Float>();

        //...
    }
}

class A<T, K> {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java 7 ile birlikte new operatörü ile açılım yapılırken türler yazılmayabilir. Ancak açısal parantezler olmalıdır
	(diamond syntax). Şüphesiz olmaması bir sentaks ya da semantic bir hata oluşturmaz. Ancak kesinlikle kullanımı
	tavsiye edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<Boolean, String> x = new A<>(); //Since Java 7 : Diamond syntax
        A<Integer, Float> y = new A<>();

        //...
    }
}

class A<T, K> {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıflar Object için kullanılacaksa Object açılımı yapılması iyi bir tekniktir. Yani generic sınıflar
	açılımsız kullanılmamalıdır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<Object> x = new A<>();

        //...
    }
}

class A<T> {
    //...

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıfların generic parametrelerinin kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

abstract class A<T, R> {
    public abstract R get(T t);
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıf generic olmayan bir sınıftan türetilebilir. Bu durumda generic sınıfın her açılımı
	o taban sınıftan türetilmiş olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B<Boolean> bb = new B<>();
        B<String> bs = new B<>();

        A x;

        x = bs;
        x = bb;

        //...
    }
}


class B<T> extends A {
    //
}


class A {
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic olmayan bir sınıf generic bir sınıfın herhangi bir açılımından türetilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B b = new B();
        A<String> a;

        a = b;

        b.foo("ankara");
        a.foo("istanbul");
        a.foo(10); //error
        A<Integer> ai = b; //error

        //...
    }
}

class B extends A<String> {
    //
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic olmayan bir sınıf generic bir sınıfın herhangi bir açılımından türetilebilir. Aşağıdaki örnekte
	foo metodu override edilmiş ve taban sınıfın foo metodu da çağrılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B b = new B();
        A<String> a = b;

        a.foo("istanbul");

        //...
    }
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}
class B extends A<String> {
    public void foo(String str) //override
    {
        super.foo(str);
        System.out.println(str.toUpperCase());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte derleme zamanında tür kontrolü dolayısıyla error oluşur (type safety)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B b = new B();
        A<String> a = b;

        a.foo("ankara");
        a.foo(3.4); //error

        //...
    }
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}

class B extends A<String> {
    public void foo(String str)
    {
        super.foo(str);
        System.out.println(str.toUpperCase());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte generic A sınıfı açılımsız kullanıldığından derleme zamanı tür kontrolü yapılamaz.
	Örneğimiz için foo metoduna double türü geçirildiğinde exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B b = new B();
        A a = b;

        a.foo(3.4);

        //...
    }
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}
class B extends A<String> {
    public void foo(String str)
    {
        super.foo(str);
        System.out.println(str.toUpperCase());
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıf başka bir generic sınıfın bir açılımından türetilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B<String> b = new B<>();
        A<Integer> a;

        a = b;

        a.foo(10);
        b.bar("ankara");

        B<Boolean> bb = new B<>();

        a = bb;

        bb.foo(23);
        bb.bar(true);
    }
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}

class B<T> extends A<Integer> {
    public void bar(T t)
    {
        System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıf başka bir generic sınıftan türetilebilir. Bu durumda türemiş sınıfın her açılımı
	taban sınıfın o açılımından türetilmiş olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B<Integer> b = new B<>();
        A<Integer> a;

        a = b;

        b.foo(10);
        b.bar(1);

        B<String> b1 = new B<>();
        A<String> a1;

        a1 = b1;
        a1.foo("ankara");
        b1.bar("istanbul");
    }
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}

class B<T> extends A<T> {
    public void bar(T t)
    {
        System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte K generic parametresi taban sınıf için kullanılmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B<Integer, String> x = new B<>();
        A<String> y;

        y = x;
        x.bar(10, "zonguldak");
        x.foo("ankara");
        y.foo("izmir");

        //...
    }
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}

class B<T, K> extends A<K> {
    public void bar(T t, K k)
    {
        System.out.println(t);
        System.out.println(k);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte x' in türünden dolayı A<Boolean> açılımına atanamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        B<Integer, String> x = new B<>();
        A<Boolean> y = x; //error

        //...
    }
}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}

class B<T, K> extends A<K> {
    public void bar(T t)
    {
        System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayList sınıfının kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<String> names = new ArrayList<>();

        names.add("ali");
        names.add("veli");
        names.add("selami");

        for (String name : names)
            System.out.println(name.toUpperCase());

        System.out.println("***************");

        for (int i = 0; i < names.size(); ++i) {
            String str = names.get(i);

            System.out.println(str.toUpperCase());
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayList sınıfının kullanımı. Aşağıdaki örnekte foreach döngü deyiminde döngü değişkenine atama yapılmadan önce
	int türüne otomatik kutu açılır. Benzer şekilde add metodu çağrılarında da kutulma yapılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++i)
            list.add(i * 10); //auto-boxing

        for (int val : list) //auto-unboxing
            System.out.printf("%d ", val);

        System.out.println();
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte döngü değişkenine atama yapılmadan önce int türüne kutu açıldığı için error ya da exception
	durumu oluşmaz. Yani aslında for-each deyimindeki atama int türünden double türüne doğrudan yapılan atamadır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++i)
            list.add(i * 10); //auto-boxing

        for (double val : list) //auto-unboxing
            System.out.printf("%f%n", val);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki anlatılana göre aşağıdaki for-each döngü deyiminde int türünde short türüne doğrudan atama geçersiz
	olduğundan error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++i)
            list.add(i * 10); //auto-boxing

        for (short val : list) //auto-unboxing
            System.out.printf("%f ", val);

        System.out.println();
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Çalışma zamanı sırasında generic bir sınıfın her açılımı aynı türdendir. Yani sınıf generic bile olsa o sınıfa
	ilişkin tek bir tür bulunmaktadır. Arakod içerisinde sadece A sınıfı bulunur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<String> as = new A<>();
        A<Integer> ai = new A<>();
        A<Boolean> ab = new A<>();

        System.out.println(as.getClass().getName());
        System.out.println(ab.getClass().getName());
        System.out.println(ai.getClass().getName());
    }
}

class A<T> {
    //...
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	ArrayList sınıfının kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<ArrayList<String>> names = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();

        nameList.add("Ali");
        nameList.add("Veli");

        names.add(nameList);

        nameList = new ArrayList<>();

        nameList.add("Ayşe");
        nameList.add("Fatma");
        nameList.add("Zeynep");

        names.add(nameList);
        for (ArrayList<String> nl : names) {
            for (String name : nl)
                System.out.printf("%s ", name);
            System.out.println();
        }
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.ArrayList;
import java.util.Random;

public final class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] > a[k])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }
            }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {
    }

    public static int [][] addMatrices(int [][] a, int [][] b)
    {
        if (isNotMatrix(a) || isNotMatrix(b) || a.length != b.length || a[0].length != b[0].length)
            throw new IllegalArgumentException("Invalid matrices for add operation");

        int [][] total = new int[a.length][a[0].length];

        for (int i = 0; i < total.length; ++i)
            for (int j = 0; j < total[i].length; ++j)
                total[i][j] = a[i][j] + b[i][j];

        return total;
    }


    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void display(int [] a)
    {
        display(1, a);
    }

    public static void display(int k, int [] a)
    {
        display(k, a.length, a);
    }

    public static void display(int k, int count, int [] a)
    {
        String fmt = String.format("%%0%dd ", k); //"%02d " -> k = 2

        for (int i = 0; i < count; ++i)
            System.out.printf(fmt, a[i]);

        System.out.println();
    }

    public static void display(String [] strings)
    {
        for (String string : strings)
            System.out.println(string);
    }

    public static void display(int [][] a)
    {
        display(1, a);
    }

    public static void display(int k, int [][] a)
    {
        for (int [] array : a)
            display(k, array);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        int maxVal = max(data);

        for (int val : data) {
            int count  = (int)Math.floor(val * n / (double)maxVal);

            while (count-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int [] enlarge(int [] a, int newLength)
    {
        if (newLength <= a.length)
            return a;

        int [] newArray = new int[newLength];

        for (int i = 0; i < a.length; ++i)
            newArray[i] = a[i];

        return newArray;
    }

    public static void fillRandomArray(int [] a, int min, int max)
    {
        fillRandomArray(new Random(), a, min, max);
    }

    public static void fillRandomArray(Random r, int [] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;
    }

    public static int[] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] histData = new int[n + 1];

        for (int val : a)
            ++histData[val];

        return histData;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int [] getRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int [] a = new int[n];

        fillRandomArray(r, a, min, max);

        return a;
    }

    public static int[][] getRandomMatrix(int m, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int[][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static boolean isMatrix(int [][] a)
    {
        int count = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (a[i].length != count)
                return false;

        return true;
    }

    public static boolean isNotMatrix(int [][]a)
    {
        return !isMatrix(a);
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a[0].length == a.length;
    }

    public static boolean isNotSquareMatrix(int [][] a)
    {
        return !isSquareMatrix(a);
    }


    public static String join(ArrayList<String> list, char delimiter)
    {
        return join(list, delimiter + "");
    }

    public static String join(ArrayList<String> list, String delimiter)
    {
        String str = "";

        for (String s : list)
            str += s + delimiter;

        return str.substring(0, str.length() - delimiter.length());
    }

    public static String join(String [] strings, char delimiter)
    {
        return join(strings, delimiter + "");
    }

    public static String join(String [] strings, String delimiter)
    {
        String str = "";

        for (String s : strings)
            str += s + delimiter;

        return str.substring(0, str.length() - delimiter.length());
    }

    public static int max(int [] a)
    {
        int maxVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (a[i] > maxVal)
                maxVal = a[i];

        return maxVal;
    }

    public static int min(int [] a)
    {
        int minVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (a[i] < minVal)
                minVal = a[i];

        return minVal;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void reverse(int [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static int sum(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            for (int k = 0; k < a[i].length; ++k)
                total += a[i][k];

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static int [][] transpose(int [][] a)
    {
        int [][] t = new int[a[0].length][a.length];

        for (int i = 0; i < t.length; ++i)
            for (int j = 0; j < t[i].length; ++j)
                t[i][j] = a[j][i];

        return t;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic açılımlarda dizi türü de kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<int[]> list = new ArrayList<>();

        list.add(new int[] {1, 2, 3, 4});
        list.add(ArrayUtil.getRandomArray(10, 10, 20));


        for (int [] a : list) {
            for (int val : a)
                System.out.printf("%d ", val);

            System.out.println();
        }

    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	CommandPrompt sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.commandpromptapp;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandPrompt {
    private static final String [] COMMAND_STRINGS = {"length", "reverse", "upper", "lower", "change", "clear", "gettext", "join"};
    private final ArrayList<String> m_textList;
    private final Scanner m_kb;

    private String m_prompt;

    private static String getCommandByText(String text)
    {
        if (text.length() < 3)
            return "";

        for (String s : COMMAND_STRINGS)
            if (s.startsWith(text))
                return s;

        return "";
    }

    private void lengthProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("length bir tane argüman almalıdır");
            return;
        }

        System.out.println(commandsStr[1].length());
    }

    private void reverseProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("revere bir tane argüman almalıdır");
            return;
        }

        System.out.println(StringUtil.reverse(commandsStr[1]));
    }

    private void upperProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("upper bir tane argüman almalıdır");
            return;
        }
        System.out.println(commandsStr[1].toUpperCase());
    }

    private void lowerProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("lower bir tane argüman almalıdır");
            return;
        }
        System.out.println(commandsStr[1].toLowerCase());
    }

    private void changeProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            System.out.println("change bir tane argüman almalıdır");
            return;
        }
        m_prompt = commandsStr[1];
    }

    private void clearProc(String [] commandsStr)
    {
        for (int i = 0; i < 30; ++i)
            System.out.println();
    }

    private void getTextProc(String [] commandsStr)
    {
        if (commandsStr.length != 1) {
            System.out.println("gettext hiç argüman almamalıdır");
            return;
        }

        System.out.println("Bu menüden çıkmak için quit yazınız");
        for (;;) {
            System.out.print("Yazıyı giriniz:");
            String text = m_kb.nextLine();

            if (text.equals("quit"))
                break;

            m_textList.add(text);
        }
    }

    private void joinProc(String [] commandsStr)
    {
        if (commandsStr.length > 2) {
            System.out.println("join en fazla 2(iki) argüman alabilir");
            return;
        }

        if (m_textList.isEmpty()) {
            System.out.println("Listede hiç yazı yok");
            return;
        }

        String str = ArrayUtil.join(m_textList, commandsStr.length == 1 ? " " : commandsStr[1]);

        System.out.println(str);
    }

    private void doWorkForCommand(String [] commandInfoStr)
    {
        switch (commandInfoStr[0]) {
            case "length":
                lengthProc(commandInfoStr);
                break;
            case "reverse":
                reverseProc(commandInfoStr);
                break;
            case "upper":
                upperProc(commandInfoStr);
                break;
            case "lower":
                lowerProc(commandInfoStr);
                break;
            case "change":
                changeProc(commandInfoStr);
                break;
            case "clear":
                clearProc(commandInfoStr);
                break;
            case "gettext":
                getTextProc(commandInfoStr);
                break;
            case "join":
                joinProc(commandInfoStr);
                break;
        }
    }

    private void parseCommand(String [] commandInfoStr)
    {
        String cmd = getCommandByText(commandInfoStr[0]);

        if (!cmd.isEmpty()) {
            commandInfoStr[0] = cmd;
            doWorkForCommand(commandInfoStr);
        }
        else
            System.out.println("Geçersiz komut");
    }

    public CommandPrompt(String p)
    {
        m_prompt = p;
        m_textList = new ArrayList();
        m_kb = new Scanner(System.in);
    }

    public void run()
    {
        System.out.println("C ve Sistem Programcıları Derneği");

        for (;;) {
            System.out.print(m_prompt + ">");
            String cmd = m_kb.nextLine().trim();

            if (cmd.equals("quit"))
                break;

            parseCommand(cmd.split("[ \t]+"));
        }

        System.out.println("C ve Sistem Programcıları Derneği");
        System.out.println("Tekrar yapıyor musunuz?");
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir arayüzün herhangi bir açılımını implemente eden bir sınıf içerisinde arayüzün metotları açılıma
    uygun şekilde override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample();

        s.foo("ankara");
    }
}

class Sample implements IX<String> {
    public void foo(String str)
    {
        System.out.println(str.toUpperCase());
    }
}

interface IX<T> {
    void foo(T t);
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir arayüzün herhangi bir açılımını implemente eden bir sınıf içerisinde arayüzün metotları açılıma
    uygun şekilde override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        StringToLengthConverter stringToLengthConverter = new StringToLengthConverter();
        ArrayList<String> cities = new ArrayList<>();

        cities.add("ankara");
        cities.add("istanbul");
        cities.add("izmir");
        cities.add("zonguldak");

        for (String city : cities)
            System.out.printf("%d ", stringToLengthConverter.convert(city));

        System.out.println();
    }
}



class StringToLengthConverter implements IConverter<String, Integer> {
    //...
    public Integer convert(String str)
    {
        return str.length();
    }
}

interface IConverter<T, R> {
    R convert(T t);
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic arayüzlerin bir kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.NumberUtil;

import java.util.Random;
import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Ön yazıyı giriniz:");
        String prefix = kb.nextLine();

        Random r = new Random();
        NumToTextConverter numToTextConverter = new NumToTextConverter(prefix);

        while (true) {
            int val = r.nextInt(1000 + 999) - 999;

            System.out.printf("%d %s%n", val, numToTextConverter.convert(val));
            if (val == 0)
                break;

        }
        System.out.println("Tekrar yapıyor musunuz?");
    }
}


class NumToTextConverter implements IConverter<Integer, String> {
    private final String m_prefix;

    public NumToTextConverter(String prefix)
    {
        m_prefix = prefix;
    }

    public String convert(Integer str)
    {
        return String.format("%s:%s", m_prefix, NumberUtil.numberToTextTR(str));
    }
}

interface IConverter<T, R> {
    R convert(T t);
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	25.10.2020
	Generic bir arayüzü implemente eden bir sınıf içerisinde arayüzün metotları açılıma uygun şekilde override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample();

        s.foo("ankara");
        s.bar(20);
    }
}

class Sample implements IX<String>, IY<Integer> {
    public void foo(String str)
    {
        System.out.println(str.toUpperCase());
    }

    public void bar(Integer i)
    {
        System.out.println(i * i);
    }
}

interface IX<T> {
    void foo(T t);
}

interface IY<T> {
    void bar(T t);
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir arayüzü implemente eden bir sınıf içerisinde arayüzün metotları açılıma uygun şekilde override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<Boolean> sb = new Sample<>();
        Sample<Double> sd = new Sample<>();

        sb.foo(true);
        sb.bar(false);

        sd.foo(3.4);
        sd.bar(4.5);
    }
}

class Sample<T> implements IX<T>, IY<T> {
    public void foo(T t)
    {
        System.out.println("foo:");
        System.out.println(t);
    }

    public void bar(T t)
    {
        System.out.println("bar:");
        System.out.println(t);
    }
}

interface IX<T> {
    void foo(T t);
}

interface IY<T> {
    void bar(T t);
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir arayüzü implemente eden bir sınıf içerisinde arayüzün metotları açılıma uygun şekilde override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<String, Boolean> ssb = new Sample<>();
        Sample<Integer, String> sis = new Sample<>();

        ssb.foo(true);
        ssb.bar("ankara");

        sis.foo("zonguldak");
        sis.bar(10);
    }
}

class Sample<T, K> implements IX<K>, IY<T> {
    public void foo(K k)
    {
        System.out.println("foo:");
        System.out.println(k);
    }

    public void bar(T t)
    {
        System.out.println("bar:");
        System.out.println(t);
    }
}

interface IX<T> {
    void foo(T t);
}

interface IY<T> {
    void bar(T t);
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir abstract sınıftan türetilen bir sınıf içerisinde taban sınıfın sanal metotları açılıma uygun şekilde
	override edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class MyTask extends AsyncTask<String, String, Integer> {
    public Integer doInBackground(String [] params)
    {
        return null;
    }

    public void onProgressExecute(String [] progresses)
    {
        //...
    }

    public void onPostExecute(Integer result)
    {
        //...
    }
}

abstract class AsyncTask<Params, Progress, Result> {
    protected abstract Result doInBackground(Params [] params);
    public void onProgressExecute(Progress [] progresses)
    {
        //...
    }

    public void onPostExecute(Result result)
    {
        //...
    }

    //...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Bir sınıf generic bir arayüzün birden fazla açılımını destekleyemez. Çünkü arakodda tüm açılan generic parametrelerin
	türler Object olarak ele alınır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Sample implements IX<Integer>, IX<String> { //error
    public void foo(String t)
    {

    }

    public void foo(Integer t)
    {

    }
}

interface IX<T> {
    void foo(T t);
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnek geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Sample<T> implements IX<Integer>, IY<String> { //error
    public void foo(String t)
    {

    }

    public void foo(Integer t)
    {

    }
}

interface IX<T> {
    void foo(T t);
}

interface IY<T> {
    void foo(T t);
}

```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Generic parametrelere kısıt (constraint) verilebilir. Bu işlem için extends anahtar sözcüğü kullanılır. Aşağıdaki
	örnekte Mample sınıfı IX arayüzünü destekleyen bir tür ile açılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Mample<Sample> m;
        Mample<Integer> m1; //error
        //...
    }
}

class Mample<T extends IX> {
    public void bar(T t)
    {
        t.foo();
    }
}

class Sample implements IX {
    public void foo()
    {
        System.out.println("Sample.foo");
    }
}

interface IX {
    void foo();
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	int türden bir dizi referansı Integer türden bir dizi referansına atanamaz. Aslında sarmalayan sınıf türünden
	dizi ile sarmaladığı sınıf türünden dizi referansları arasında dönüşüm geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<Integer> s = new Sample<>();
        int [] a = {1, 2, 4};

        s.display(a); //error
    }
}

class Sample<T> {
    //...
    public void display(T [] a)
    {
        for (T t : a)
            System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte String türden dizi ile dispaly çağrılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<String> s = new Sample<>();
        String [] cities = {"ankara", "istanbul", "izmir"};

        s.display(cities);
    }
}

class Sample<T> {
    //...
    public void display(T [] a)
    {
        for (T t : a)
            System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic parametreler temel türler olarak belirlenemeyeceğinden aşağıdaki örnekte int, double ve long türden
	diziler için ayrı sınıflar yazılmıştır. Bu aynı zamanda kutulama işleminin de yapılmamasını sağlar. Çünkü sadece
	generic olan yazılsaydı display metodunu çağıran programcı int türden diziyi Integer türden bir dizi olarak
	oluşturup çağırması gerekirdi. Bu da otomatik kutulama anlamına gelecektir. Üstelik bu kopyalamanın O(n)
	karmaşıklıkta olacağına dikkat ediniz. Bu yaklaşım çok yerde kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<String> sample = new Sample<>();
        IntSample intSample = new IntSample();
        LongSample longSample = new LongSample();
        DoubleSample doubleSample = new DoubleSample();

        String [] names = {"ali", "veli", "selami"};
        int [] a = {1, 2, 3, 4};
        long [] b = {1L, 3L, 6L};
        double [] c = {1.4, 2.89, -3.78};

        sample.display(names);
        intSample.display(a);
        longSample.display(b);
        doubleSample.display(c);
    }
}

class IntSample {
    //...
    public void display(int [] a)
    {
        for (int val : a)
            System.out.printf("%d ", val);

        System.out.println();
    }
}

class LongSample {
    //...
    public void display(long [] a)
    {
        for (long val : a)
            System.out.printf("%d ", val);

        System.out.println();
    }
}

class DoubleSample {
    //....
    public void display(double [] a)
    {
        for (double val : a)
            System.out.printf("%f ", val);

        System.out.println();
    }
}

class Sample<T> {
    public void display(T [] a)
    {
        for (T t : a)
            System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic parametreler temel türler olarak belirlenemeyeceğinden aşağıdaki örnekte int, double ve long türden
	diziler için ayrı metotlar yazılmıştır. Bu yaklaşım örnek bazında yukarıdaki yaklaşımdan okunabililik açısından
	daha kötüdür. Bunu genellememek gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<String> sample = new Sample<>();
        String [] names = {"ali", "veli", "selami"};
        int [] a = {1, 2, 3, 4};
        long [] b = {1L, 3L, 6L};
        double [] c = {1.4, 2.89, -3.78};

        sample.display(names);
        sample.display(a);
        sample.display(b);
        sample.display(c);
    }
}

class Sample<T> {
    public void display(long [] a)
    {
        for (long val : a)
            System.out.printf("%d ", val);

        System.out.println();
    }

    public void display(int [] a)
    {
        for (int val : a)
            System.out.printf("%d ", val);

        System.out.println();
    }

    public void display(double [] a)
    {
        for (double val : a)
            System.out.printf("%f ", val);

        System.out.println();
    }

    public void display(T [] a)
    {
        for (T t : a)
            System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıfın türemiş sınıf açılımı aynı generic sınıfın taban sınıf açılımına doğrudan atanamaz (invariant)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++i)
            list.add(i * 10);

        Sample.display(list); //error
    }
}

class Sample {
    public static void display(ArrayList<Number> list)
    {
        for (Number n : list)
            System.out.println(n);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıfın türemiş sınıf açılımı aynı generic sınıfın taban sınıf açılımına tür dönüştürme operatörü ile de
	dönüştürülemez (invariant)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++i)
            list.add(i * 10);

        Sample.display((ArrayList<Number>)list); //error
    }
}

class Sample {
    public static void display(ArrayList<Number> list)
    {
        for (Number n : list)
            System.out.println(n);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki durum ? extends ile aşağıdaki gibi çözülebilir (covariant)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; ++i)
            integers.add(i * 10);

        Sample.display(integers);

        System.out.println("/////////////////");
        ArrayList<Double> doubles = new ArrayList<>();

        for (double i = 0; i < 1.23; i += 0.1)
            doubles.add(i);

        Sample.display(doubles);
    }
}

class Sample {
    public static void display(ArrayList<? extends Number> list)
    {
        for (Number n : list)
            System.out.println(n);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki foo çağrısı geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Number> list = new ArrayList<>();

        Sample.foo(list);

        ArrayList<Object> listObjects = new ArrayList<>();

        Sample.foo(listObjects); //error
    }
}

class Sample {
    public static void foo(ArrayList<Integer> list)
    {
        //...
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki foo çağrısı geçersizdir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Number> list = new ArrayList<>();

        Sample.foo(list);

        ArrayList<Object> listObjects = new ArrayList<>();

        Sample.foo((ArrayList<Integer>)listObjects); //error
    }
}

class Sample {
    public static void foo(ArrayList<Integer> list)
    {
        //...
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
	Aşağıda generic açılım contravariant duruma getirilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Number> list = new ArrayList<>();

        Sample.foo(list);

        ArrayList<Object> listObjects = new ArrayList<>();

        Sample.foo(listObjects);
    }
}

class Sample {
    public static void foo(ArrayList<? super Integer> list)
    {
        //...
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte ? işereti açılımı kullanılmıştır. Bu herhangi bir tür demektir. Ancak Object gibi düşünülmemelidir.
	Bu durumun kullanımı uygulama kursunda ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        A<?> a;

        a = new A<>();

        a.foo("ankara"); //error
        a.bar();
    }
}

class A<T> {
    public void bar()
    {

    }

    public void foo(T t)
    {
        System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	enum türleri ve exception sınıfları generic olarak bildirilemez
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

enum A<T> { //error
    //...
}

class MyException<T> extends RuntimeException { //error
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic metotlar:
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Generic metotlar ve çağrılması. Generic metotların çağrısında generic poarametrenin türü geçilen argümana göre
	tespit edilebiliyorsa (type deduction) çağrı açılım yapmadan da yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample s = new Sample();

        s.<String>foo("ankara");
        s.foo("ankara");
        s.foo(10);
        s.foo(true);
    }
}

class Sample {
    public <T> void foo(T t)
    {
        System.out.println(t);
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
   Aşağıdaki iki çağırmada da String parametreli foo çağrılır.
   Dikkat: Tür belirtilse bile String paramatreli metot çağrılır.
   Bu işlem generic bir işin türe özgü olarak farklılaşması gibi durumlarda kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample.foo("ankara");
        Sample.<String>foo("ankara");
        Sample.foo(10);
        Sample.foo(3.4);
    }
}

class Sample {
    public static void foo(String s)
    {
        System.out.println("foo(String)");
    }

    public static void foo(int val)
    {
        System.out.println("foo(int)");
    }

    public static <T> void foo(T t)
    {
        System.out.println("foo(T)");
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıfların static metotlarında sınıfların generic parametreleri kullanılamaz.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample.foo("ankara");
        Sample.foo(2.3);

    }
}

class Sample<T> {
    public void bar(T t)
    {
        System.out.println(t);
    }

    public static void foo(T t) //error
    {
        System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıfların static metotlarında sınıfların generic parametreleri kullanılamaz. Bu durumda static
	metotların da generic yapılması gerekir.

	Anahtar Notlar: Generic sınıfların static metotları çağrılırken sadece sınıf ismi
	kullanılabilir. Açılım yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample.foo("ankara");
        Sample.foo(2.3);

        Sample<String> ss = new Sample<>();
        Sample<Float> sf = new Sample<>();

        ss.bar("ankara");
        sf.bar(3.4F);
    }
}

class Sample<T> {
    public void bar(T t)
    {
        System.out.println(t);
    }

    public static <K> void foo(K k)
    {
        System.out.println(k);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıfların static metotlarında sınıfların generic parametreleri kullanılamaz. Bu durumda static
	metotların da generic yapılması gerekir. Aşağıdaki örnekte static metodun generic pametresi ile sınıfın generic
	parametresi aynı isimdedir. Bu bir sorun oluşturmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample.foo("ankara");
        Sample.foo(2.3);

        Sample<String> s = new Sample<>();

        s.bar("ankara");
    }
}

class Sample<T> {
    public void bar(T t)
    {
        System.out.println(t);
    }

    public static <T> void foo(T t)
    {
        System.out.println(t);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıfların static metotlarında sınıfların generic parametreleri kullanılamaz. Bu durumda static ,
	metotların da generic yapılması gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample.foo("ankara", true);
        Sample.foo(2.3, 's');
    }
}

class Sample<T, K> {
    //...
    public void bar(T t, K k)
    {
        //...
    }

    public static <T, K> void foo(T t, K k)
    {
        System.out.println(t);
        System.out.println(k);
    }
}


```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte generic bir sınıfın içerisinde non-static bir metot generic yapılmıştır (member generic)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<Integer, Float> s;

        s = new Sample<>();

        System.out.printf("Result:%s%n", s.foo(10, 3.4F, "ankara", true));
        System.out.printf("Result:%c%n", s.foo(10, 3.4F, 'z', 9L));
    }
}

class Sample<T, K> {
    //...
    public <L, M> L foo(T t, K k, L l, M m)
    {
        System.out.println(t);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);

        return l;
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte generic bar metodunun T ve K parametreli isim olarak sınıfın T ve K parametre isimleriniz gizler
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        Sample<Integer, Float> s;

        s = new Sample<>();
        s.foo(10, 3.4F);
        s.bar("ankara", true);
    }
}

class Sample<T, K> {
    //...
    public void foo(T t, K k)
    {
        System.out.println("foo");
        System.out.println(t);
        System.out.println(k);
    }

    public <T, K> void bar(T t, K k)
    {
        System.out.println("bar");
        System.out.println(t);
        System.out.println(k);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte doInBakground metodunun geri dönüş değerinin olmaması durumu için yazılan MyVoid isimli bir sınıf
	açılımda kullanılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

final class MyVoid {
    private MyVoid()
    {}
}

class MyTask extends AsyncTask<String, String, MyVoid> {
    public MyVoid doInBackground(String [] params)
    {
        return null;
    }

    public void onProgressExecute(String [] progresses)
    {
        //...
    }

    public void onPostExecute(MyVoid myVoid)
    {
        //...
    }
}

abstract class AsyncTask<Params, Progress, Result> {
    protected abstract Result doInBackground(Params [] params);
    public void onProgressExecute(Progress [] progresses)
    {
        //...
    }

    public void onPostExecute(Result result)
    {
        //...
    }

    //...
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki örnekteki gibi durumlar için java.lang paketi içerisinde Void isimli bir sınıf vardır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class YourTask extends AsyncTask<Void, String, Void> {
    public Void doInBackground(Void [] params)
    {
        return null;
    }

    public void onProgressExecute(String [] progresses)
    {
        //...
    }

    public void onPostExecute(Void result)
    {
        //...
    }
}

class MyTask extends AsyncTask<String, String, Void> {
    public Void doInBackground(String [] params)
    {
        return null;
    }

    public void onProgressExecute(String [] progresses)
    {
        //...
    }

    public void onPostExecute(Void result)
    {
        //...
    }
}

abstract class AsyncTask<Params, Progress, Result> {
    protected abstract Result doInBackground(Params [] params);
    public void onProgressExecute(Progress [] progresses)
    {
        //...
    }

    public void onPostExecute(Result result)
    {
        //...
    }

    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte IRunnable parametreli submit metodundan elde edilen IFuture referansı ile get metodu çağrılır
	geri dönüş değeri (yani IFuture'ın açılımına ilişkin tür) kullanılamaz ya da anlamsızdır. Bu durumda IFuture
	? (wildcard) ile açılır. Örnek tamamen konuyu anlatmak içindir. Detaylar önemsizdir. Çalışıtırıldığında tamamı
	yazılmadığı için exception oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        ExecutorService executorService = Executors.createExecutorService();

        IFuture<?> runnableFuture = executorService.submit(new MyRunnabble());

        runnableFuture.get();

        IFuture<String> callableFuture = executorService.submit(new MyCallable());

        System.out.printf("Result:%s%n", callableFuture.get());
    }
}

class MyCallable implements ICallable<String> {
    public String call()
    {
        String s = "ankara";

        //...
        return s;
    }
}

class MyRunnabble implements IRunnable {
    //...
    public void run()
    {
        //...
    }
}

class Executors {
    public static ExecutorService createExecutorService()
    {
        //....
        return new ExecutorService();
    }
}

class ExecutorService {
    public IFuture<?> submit(IRunnable runnable)
    {
        //...
        return null; // Öylesine yazıldı. Şüphesiz bir IFuture arayüzünü implemente eden nesnenin referansına geri döner
    }

    public <T> IFuture<T> submit(ICallable<T> callable)
    {
        //...
        return null; // Öylesine yazıldı. Şüphesiz bir IFuture arayüzünü implemente eden nesnenin referansına geri döner
    }
}

interface ICallable<T> {
    T call();
}

interface IRunnable {
    void run();
}


interface IFuture<T> {
    T get();
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Java'da generic kavrama genel olarak arakoda yansıtılmadığı için aynı paket içerisinde aynı isimde fakat
	farklı sayıda generic parametreye sahip türler bildirilemez
----------------------------------------------------------------------------------------------------------------------*/
package test;

public class Tuple<T> { //error
    //
}

class Tuple<T1, T2> { //error

}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Unit sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Unit;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Unit<String>> units = new ArrayList<>();

        units.add(new Unit<>("ankara"));
        units.add(new Unit<>("istanbul"));

        for (Unit<String> unit : units)
            System.out.println(unit);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Unit sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Unit;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Unit<String>> units = new ArrayList<>();

        units.add(Unit.of("ankara"));
        units.add(Unit.of("istanbul"));

        for (Unit<String> unit : units)
            System.out.println(unit);
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Unit sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class Unit<T> {
    private final T m_value;

    public static <T> Unit<T> of(T value)
    {
        return new Unit<>(value);
    }

    public Unit(T value)
    {
        m_value = value;
    }

    public T getValue()
    {
        return m_value;
    }

    //...

    public String toString()
    {
        return String.format("{value : %s}", m_value);
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Pair sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Pair;

import static org.csystem.util.Pair.*;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Pair<Integer, DeviceInfo>> devices = new ArrayList<>();

        devices.add(of(1, new DeviceInfo(1, "test", 34000)));
        devices.add(of(2, new DeviceInfo(2, "weather", 55000)));

        for (Pair<Integer, DeviceInfo> devicePair : devices)
            System.out.println(devicePair);
    }
}

class DeviceInfo {
    private int m_id;
    private String m_name;
    private int m_port;

    public DeviceInfo() {}

    public DeviceInfo(int id, String name, int port)
    {
        //...
        m_id = id;
        m_name = name;
        m_port = port;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        //...
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        //...
        m_name = name;
    }

    public int getPort()
    {
        return m_port;
    }

    public void setPort(int port)
    {
        //...
        m_port = port;
    }

    public String toString()
    {
        return String.format("[%d]%s:%d", m_id, m_name, m_port);
    }
}
```
```java

/*----------------------------------------------------------------------------------------------------------------------
    Pair sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Pair;

import static org.csystem.util.Pair.*;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        ArrayList<Pair<Integer, Integer>> points = new ArrayList<>();

        points.add(of(100, 100));
        points.add(of(50, 50));

        for (Pair<Integer, Integer> point : points)
            System.out.println(point);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Pair sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class Pair<F, S> {
    private final F m_first;
    private final S m_second;

    public Pair(F first, S second)
    {
        m_first = first;
        m_second = second;
    }

    public static <F, S> Pair<F, S> of(F first, S second)
    {
        return new Pair<>(first, second);
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    //...

    public String toString()
    {
        return String.format("{first : %s, second : %s}", m_first, m_second);
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
    Triple sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Triple;

import java.util.ArrayList;

import static org.csystem.util.Triple.of;

class App {
    public static void main(String [] args)
    {
        ArrayList<Triple<Integer, Integer, Integer>> points = new ArrayList<>();

        points.add(of(100, 100, 200));
        points.add(of(50, 50, -30));

        for (Triple<Integer, Integer, Integer> point : points)
            System.out.println(point);
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Triple sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class Triple<F, S, T> {
    private final F m_first;
    private final S m_second;
    private final T m_third;

    public Triple(F first, S second, T third)
    {
        m_first = first;
        m_second = second;
        m_third = third;
    }

    public static <F, S, T> Triple<F, S, T> of(F first, S second, T third)
    {
        return new Triple<>(first, second, third);
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    public T getThird()
    {
        return m_third;
    }

    //...

    public String toString()
    {
        return String.format("{first : %s, second : %s, third : %s}", m_first, m_second, m_third);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Generic parametre türü new operatörü ile kullanılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Sample<T> {
    private T m_t;

    public Sample(int n)
    {
        m_t = new T(); //error
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki kuraldan dolayı generic türden dizi de new operatörü ile doğrudan yaratılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Sample<T> {
    private T [] m_t;

    public Sample(int n)
    {
        m_t = new T[n]; //error
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki problem aşağıdaki gibi yapılarak çözülebilir. Aşağıdaki kodda uyarının problem oluturduğu bir durum
	gerçekleşemez. Çünkü Object dizisinin referansı dışarıya Object [] türünden verilmemiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Sample<T> {
    private T [] m_t;
    private int m_index;

    public Sample(int n)
    {
        m_t = (T []) new Object[n]; //Uyarı önemsiz. Şimdilik görmeyin
    }

    public boolean add(T value)
    {
        if (m_index == m_t.length)
            return false;
        m_t[m_index++] = value;

        return true;
    }
}

```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte de Object yaratılmış ve T türüne dönüştürülmüştür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Sample<T> {
    private T m_t;

    public Sample(int n)
    {
        m_t = (T) new Object(); //Uyarı önemsiz
    }
    //...
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.collection.CSDArrayList;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        CSDArrayList<Integer> list = new CSDArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 10; ++i)
            list.add(r.nextInt(100));

        int size = list.size();

        int sum = 0;

        for (int i = 0; i < size; ++i) {
            int value = list.get(i);

            System.out.printf("%d ", value);
            sum += value;
        }

        System.out.printf("%nToplam:%d%n", sum);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.collection;

public class CSDArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E [] m_elems;
    private int m_index;

    private static void doWorkForIllegalArgumentException(String message)
    {
        throw new IllegalArgumentException(message);
    }

    private static void doWorkForIndexOutOfBoundsException(String message)
    {
        throw new IndexOutOfBoundsException(message);
    }

    private void checkForIndex(int index)
    {
        if (index < 0 || index >= m_index)
            doWorkForIndexOutOfBoundsException("Index out of bounds");
    }

    private void checkCapacityValue(int capacity)
    {
        if (capacity < 0)
            doWorkForIllegalArgumentException("Capacity can not be negative");
    }

    private void changeCapacity(int capacity)
    {
        E [] temp = (E[]) new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elems[i];

        m_elems = temp;
    }

    public CSDArrayList()
    {
        m_elems = (E []) new Object[DEFAULT_CAPACITY];
    }

    public CSDArrayList(int capacity)
    {
        checkCapacityValue(capacity);

        m_elems = (E[]) new Object[capacity];
    }

    public boolean add(E elem)
    {
        if (m_index == m_elems.length)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, E elem)
    {
        if (m_index == m_elems.length)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        //TODO:
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity <= m_elems.length)
            return;

        changeCapacity(Math.max(minCapacity, m_elems.length * 2));
    }

    public E get(int index)
    {
        checkForIndex(index);

        return m_elems[index];
    }

    public E remove(int index)
    {
        //TODO: bellek sızıntına dikkat!!!
        E oldElem = m_elems[index];

        //...

        return oldElem;
    }

    public E set(int index, E elem)
    {
        checkForIndex(index);
        E oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }

    public int size()
    {
        return m_index;
    }

    public void trimToSize()
    {
        changeCapacity(m_index);
    }

    //...

    public String toString()
    {
        String str = "";

        for (int i = 0; i < m_index; ++i)
            str += m_elems[i] + ", ";

        if (!str.isEmpty())
            str = str.substring(0, str.length() - ", ".length());

        return "[" + str + "]";
    }
}

```
```java


/*----------------------------------------------------------------------------------------------------------------------
	Bir programın komut satırı argümanı program çalıştırılırken ona geçilen yazılara denir. Komut satırı argümanları
	genellike boşlukla birbirinden ayrılır. Çoğu sistemde bir komut satırı argümanları boşluk olsa da birleştirilmek
	için iki tırnak veya tek tırnak kullılır. Bir Java uygulamasına geçilen komutr satırı argümanları çeşitli yollarla
	elde edilebilse de en kolay yöntem main metodunun parametre değişkeni String dizi referansını kullanmaktır. Programa
	geçilen komut satırı argümanları JVM tarafından bir dizi oluşturularak main metoduna argüman olarak geçilir. Hiçbir
	komut satırı argümanı verilmezse bu dizi sıfır elemanlı olur. Dizi yaratılır ancak length değeri sıfırdır. Java'da
	komut satırı argümanı dizisine sadece komut satırı argümanları geçirilir
----------------------------------------------------------------------------------------------------------------------*/
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki program çalıştırılırken komut satırı argümanı verilmezse length değeri sıfır olur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        System.out.printf("Length:%d%n", args.length);

        for (String arg : args)
            System.out.println(arg);
    }
}
```
```java
/*----------------------------------------------------------------------------------------------------------------------
	Komut satırı argümanlarının kullanımı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;

class App {
    public static void main(String[] args)
    {
        System.out.printf("Length:%d%n", args.length);

        if (args.length > 0)
            System.out.println(ArrayUtil.join(args, '-'));
    }
}

/*----------------------------------------------------------------------------------------------------------------------
	
----------------------------------------------------------------------------------------------------------------------*/
```
