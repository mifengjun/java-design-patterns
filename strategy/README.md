![strategy-title.png](https://i.loli.net/2020/11/22/EbcfqsQpOhvYCad.png)

# 策略模式

策略模式最早的时候是在马老师的坦克大战看的，讲的很干，也挺清楚。现在回想起来更是记忆犹新。

说到策略模式，最应该关注的应该就是策略这个词语了吧。这个词我直接贴一段百度的翻译，大家看一下

![image-20201121172440172](https://i.loli.net/2020/11/21/nYyQ4dELalKpr25.png)

提取和设计模式相关的两个含义

1. 可以实现目标的方案集合
2. 根据不同情况选择不同的策略

然后我们再看看标准的策略模式定义

> 定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。

有了这个基本的清晰概念再学起来就很轻松了。

## 策略模式类图 📌

![strategy-uml.png](https://i.loli.net/2020/11/21/xRjFyEgXSmHnidp.png)

定义了一个策略接口，然后将每种不同的策略实现同一个接口。这样各个策略之间就可以进行切换。在使用的过程中，可以将策略当成参数传到具体的方法中执行（这里要用函数接口），或者在客户端调用之前就将指定好具体的策略。

## 站点的主题切换 🎨

相信大家都使用过可以切换主题的站点，这次我也是尝试使用策略模式来实现这个功能。

**需求：**

1. 用户可以根据自己的喜欢自行选择预设的 3 个主题配色

**3 个主题配色：**

1. **七彩斑斓的黑**
	- 背景色：backgroundColor 黑色
	- 字体颜色：fontColor 灰色
2. **五颜六色的黑**
	- 背景色：backgroundColor 黑灰色
	- 字体颜色：fontColor 白色
3. **绚烂多彩的黑**
	- 背景色：backgroundColor 灰黑色
	- 字体颜色：fontColor 黑色

**代码实现：**

```java
/**
 * Theme 主题接口
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/21
 */
public interface Theme {

    void show();
}
```

```java
/**
 * Context
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/21
 */
public class Context {
    private Theme theme;

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void show() {
        theme.show();
    }
}
```

测试代码

```java
/**
 * ThemeTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/21
 */
class ThemeTest {

    @Test
    void show() {
        Context context = new Context();
        System.out.println("七彩斑斓的黑");
        context.setTheme(new ColorfulBlack());
        context.show();

        System.out.println("五颜六色的黑");
        context.setTheme(new MotleyBlack());
        context.show();

        System.out.println("绚烂多彩的黑");
        context.setTheme(new SplendidBlack());
        context.show();
    }
}
```

测试结果

```java

七彩斑斓的黑
- 背景色：backgroundColor 黑色
- 字体颜色：fontColor 灰色

五颜六色的黑
- 背景色：backgroundColor 黑灰色
- 字体颜色：fontColor 白色

绚烂多彩的黑
- 背景色：backgroundColor 灰黑色
- 字体颜色：fontColor 黑色

```

其实要说这个策略模式的实现，它本身就是这么一个非常简单的写法。只是可以通过更多的思想融入可以使其变得更加灵活好用，同时也会变得复杂起来。这里一起看看一个经典的策略模式的实现，就是 JDK 中的比较器。在 JDK 中就是不同的类型有不同的比较算法，这也是符合了策略模式的思想。我再把策略模式的定义拿过来看一看

> 定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。

JDK 为每种不同的数据类型定义了一系列的算法，并将每个算法封装起来，使他们可以通过 Comparator 接口进行相互替换，对于客户端来讲，尽管调用比较方法就可以了，即使算法发生了改变（替换其他算法）也不会影响到客户端的使用。

## JDK 比较器

JDK 中的比较实现有两种，一种是直接通过实现 Compareable 接口，定义其他对象与自己的顺序（比较）。而另一种就是通过使用策略模式来实现的比较器 Comparator 接口。接下来就一起看看 JDK 是怎么运用策略模式设计的比较器。

首先是策略模式中的第一个关键的定义，定义一系列算法。根据开闭原则，这里定义了一个接口，然后将具体的一系列算法实现延迟到子类当中去。

比较器 - 策略接口

```java
public interface Comparator<T>
```

一系列算法 - 具体策略

String 的比较算法

```java
    public static final Comparator<String> CASE_INSENSITIVE_ORDER
                                         = new CaseInsensitiveComparator();
    private static class CaseInsensitiveComparator
            implements Comparator<String>, java.io.Serializable {
        // use serialVersionUID from JDK 1.2.2 for interoperability
        private static final long serialVersionUID = 8575799808933029326L;

        public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1);
                    c2 = Character.toUpperCase(c2);
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1);
                        c2 = Character.toLowerCase(c2);
                        if (c1 != c2) {
                            // No overflow because of numeric promotion
                            return c1 - c2;
                        }
                    }
                }
            }
            return n1 - n2;
        }

        /** Replaces the de-serialized object. */
        private Object readResolve() { return CASE_INSENSITIVE_ORDER; }
    }
```

如果对象本身支持比较，即实现了 Comparable 接口的对象，可以使用 Comparator 提供的下面这个方法

```java
    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return (Comparator<T>) Comparators.NaturalOrderComparator.INSTANCE;
    }
```

其中 Comparators 这个类是专门为 Comparator 接口创建比较算法使用的默认类，是一个同包访问权限的类

```java
/**
 * Package private supporting class for {@link Comparator}.
 */
class Comparators {
    private Comparators() {
        throw new AssertionError("no instances");
    }

    /**
     * Compares {@link Comparable} objects in natural order.
     *
     * @see Comparable
     */
    enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        INSTANCE;

        @Override
        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c1.compareTo(c2);
        }

        @Override
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.reverseOrder();
        }
    }
    ....
    省略部分代码
    ....
}
```

其实对于比较这种算法，更多的是由使用者自己来决定谁大谁小，JDK 仅提供了一些基本的比较策略。比如如下几种比较策略

```java
   // 常规比较
   static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return NaturalOrderComparator.INSTANCE;
    }
	// 空值小于非空
    static <T> Comparator<T> nullsFirst(Comparator<? super T> var0) {
        return new NullComparator(true, var0);
    }
	// 空值大于非空
    static <T> Comparator<T> nullsLast(Comparator<? super T> var0) {
        return new NullComparator(false, var0);
    }
	// 等等，如果还想了解可以自行查看 java/util/Comparator.java
```

**注意：两个空值比较只是提供了当两个元素为空时的比较策略，当两个比较元素都不为空时需使用调用者提供的比较算法**

下面我们一起看下如何使用 JDK 的比较器来达到策略模式定义的第二点``它们可以相互替换，且算法的改变不会影响使用算法的客户。``

### ‘你’ 大还是 ‘好’ 大

我们就拿 ‘**你**‘ 和 ’**好**’ 这两个汉字来尝试一下。

```java
public class TestJDKComparator {

    public static void main(String[] args) {
        String you = "你";
        String fine = "好";
        // String 的比较器
        int ctic = you.compareToIgnoreCase(fine);
        System.out.println("compareToIgnoreCase:" + ctic);

        // JDK 提供的默认比较器
        Comparator<String> comparator = Comparator.naturalOrder();
        int compare = comparator.compare(you, fine);
        System.out.println("naturalOrder = " + compare);

        // 自定义比较器1
        Comparator<String> stringComparator1 = Comparator.nullsFirst((o1, o2) -> {
            byte[] bytes1 = o1.getBytes();
            byte[] bytes2 = o2.getBytes();
            return bytes1.length - bytes2.length;

        });
        int compare1 = stringComparator1.compare(you, fine);
        System.out.println("nullsFirst&customComparator1 = " + compare1);

        // 自定义比较器2
        Comparator<String> stringComparator2 = Comparator.nullsFirst((o1, o2) -> {
            int length1 = o1.length();
            int length2 = o2.length();
            int min = Math.min(length1, length2);
            for (int i = 0; i < min; i++) {
                char o1Char = o1.charAt(i);
                char o2Char = o2.charAt(i);
                if (o1Char != o2Char) {
                    return o2Char - o1Char;
                }
            }
            return length2 - length1;
        });
        int compare2 = stringComparator2.compare(you, fine);
        System.out.println("nullsFirst&customComparator2 = " + compare2);
    }
}
```

测试结果

```java
compareToIgnoreCase:-2589
naturalOrder = -2589
nullsFirst&customComparator1 = 0
nullsFirst&customComparator2 = 2589
```

---

在 JDK 的比较器中有一个方法，可以让我们学习。就是 naturalOrder() 返回来的这个比较器。

```java
   // 常规比较
   static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return NaturalOrderComparator.INSTANCE;
    }
```

```java
    enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        INSTANCE;

        // 实现比较器定义的抽象方法
        @Override
        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            // 使用参数自己的“策略”
            return c1.compareTo(c2);
        }

        @Override
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.reverseOrder();
        }
    }
```

这个比较器里有一个参数限制，而这个参数限制的就是必须是 Comarable 的实现类，同时是这个实现类的子类。其实，这个参数就是一个策略模式的“策略接口”，传入的参数就是具体的策略。因为这个传入的参数必须要实现 compareTo 这个方法，也就是实现 Comarable 接口的抽象方法。

```java
public interface Comparable<T> {
    int compareTo(T var1);
}
```

![strategy-comparator.png](https://i.loli.net/2020/11/22/6BejY1tkK3MaUZJ.png)

在 JDK 中更灵活的使用比较器就是使用匿名类的写法

![image-20201122223734626](https://i.loli.net/2020/11/22/AOCGdnXKmxrYFVJ.png)



## 总结 📚

其实抛开这个模式本身，我们在一些逻辑实现的时候也会使用这种写法，最简单的就是对一个接口方法的实现。使得他们可以在不同的情况下进行不同的切换。所以，在我们系统中，如果可能出现一些相同的操作，但是却会有很多不同的实现的时候，就是在使用这种“策略模式”来实现。每个具体的实现算法不同，但是他们的操作是相同。使用开闭原则来控制算法的入口，具体的实现延迟到子类。但当我们的具体算法变多的时候，使用起来可能会有一些副作用，所以这个时候可以考虑使用工厂模式来辅助策略模式变得更好用。



----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>获取源码、加群一起交流学习🤓。</p>
    <img alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>
