![clone-wordpress](https://i.loli.net/2020/10/17/q62IGUFY1xmdbw4.png)

# 原型模式 🎭

> 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。



![来源：https://refactoringguru.cn/design-patterns/prototype](https://i.loli.net/2020/10/16/waBiVhAvyOptTE3.png)

> 图片来源：https://refactoringguru.cn/design-patterns/prototype



## 月饼？盗文章？ 🤔

每年中秋节的时候，大家都会吃到自己心仪口味的样式各异的月饼，但是他是怎么生产出来的呢，我猜它应该是有一个模板，比如花边图案的月饼

![月饼模板原型](https://i.loli.net/2020/10/16/Lm9cNiTsrtSRMdl.jpg)

他会创造出来一个月饼原型，当你想吃五仁的时候，就把里面的馅改成五仁的，当你想吃蛋黄的（自己准备鸡蛋），就把馅改成蛋黄的，这样做不仅提高了生产效率，而且还节省了一部分再创建一个月饼的时间。

==再比如说可恶的盗图、盗文章、盗视频的人，他们把原创内容拿回去改个名字，去掉水印，随便改改内容，就成了自己的了！？==

![clone-wordpress1](https://i.loli.net/2020/10/17/koZI5pEbB8hmJHl.png)

上面说的两个案例的行为都是在节省了创建时间，同时达到了自己的一些目的。而这在设计模式中，就叫做**原型模式**，为了解决一个对象的创建而出现的一种设计模式，归类在了创建型模式中。

> 注意：在行为型模式中有着与之类似的一种模式——模版方法模式，是为了制定解决一件事情中的一系列操作约束而存在的一种模式，二者的区别在于，原型模式用于对象创建，模板方法模式用于事件行为约束。





## 原型模式类图 📌



![prototype-UML](https://i.loli.net/2020/10/16/Ct5bJAgkDiTcWsy.png)



## 来看代码 📃

> 完整代码及单元测试结果点击查看 [https://github.com/lvgocc/java-design-patterns/tree/main/prototype](https://github.com/lvgocc/java-design-patterns/tree/main/prototype)

java 的 JDK 中，提供一个标识接口 Cloneable ，我们将需要定义成原型的类实现这个接口就可以完成复制了。

**通过 cloneable 接口实现原型模式**

```java
public class Graphics implements Cloneable {

    private final String color;
    private final String shape;


    public Graphics(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    @Override
    protected Graphics clone() throws CloneNotSupportedException {
        return (Graphics) super.clone();
    }
    
    ..... set/get/toString
}
```

在上面的例子中，类中的对象类型都是基本类型，如果出现引用类型的时候，就会引发一个问题“浅克隆”，这会导致我们克隆出来的类会受原型中引用的类型影响，那我们如何才能规避这个问题做到“深克隆”呢​？



## 浅克隆？🎭 深克隆？🎎 

浅、深指的是对对象的占有权利。比如我借给你一个手机，那你只能使用这个手机里现有的东西，我如果删除了一个软件，那你自然也就没有这个软件了。假如我送给你一个手机，那你就可以随便的使用，不用担心我会做什么了，因为这个手机就是你的了。



那在 java 代码中，我们怎么理解浅克隆🎭 、深克隆🎎 呢？


实现了 cloneable 接口，可以克隆一个区别于当前对象的另外一个新的对象，但对于对象中的引用，却不能进行克隆，你虽得到了他的人，但你却得不到他的心，如果想要得到他的心怎么办？拿钱砸他！非也，你只要把他的心也克隆一份就可以了。但是前提是他的心允许克隆（实现了 cloneable 接口）。



### 浅克隆代码

```java
public class Graphics implements Cloneable {

    private final String color;
    private final String shape;
    // 引用类型没有实现 cloneable 接口
    private final Size size;


    public Graphics(String color, String shape, Size size) {
        this.color = color;
        this.shape = shape;
        this.size = size;
    }

    @Override
    protected Graphics clone() throws CloneNotSupportedException {
        return (Graphics) super.clone();
    }
}
```

引用类型没有实现 cloneable 接口

```java
// 引用类型没有实现 cloneable 接口
public class Size {
    public int width;
    public int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Size(" + width + ", " + height + ")";
    }
}
```

测试结果

```java
class GraphicsTest {
    @Test
    void graphicsTest() throws CloneNotSupportedException {
        Size size = new Size(1, 2);
        Graphics graphics = new Graphics("red", "circular", size);
        Graphics clone = graphics.clone();
        size.height = 3;
        size.width = 5;
        System.out.println("graphics = " + graphics);
        // 判断两个对象是否不同
        Assertions.assertNotSame(graphics, clone);
        clone.setColor("blue");
        clone.setShape("square");
        System.out.println("clone = " + clone);
    }
}
```

**注意此时的引用对象 size 的值**
修改引用类型内容导致 clone 类的内容也跟着发生了变化
```text
graphics = Graphics[color='red', shape='circular', size=Size(5, 3)]
clone = Graphics[color='blue', shape='square', size=Size(5, 3)]
```



### 深克隆：引用类型也实现 Cloneable 接口

```java
// 引用类型实现了 cloneable 接口
public class Size implements Cloneable {
    public int width;
    public int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected Size clone() throws CloneNotSupportedException {
        return (Size) super.clone();
    }

    @Override
    public String toString() {
        return "Size(" + width + ", " + height + ")";
    }
}
```

在原型类中调整 clone 方法

```java
    @Override
    protected Graphics clone() throws CloneNotSupportedException {
        Graphics clone = (Graphics) super.clone();
        clone.size = size.clone();
        return clone;
    }
```

测试结果

```java
class GraphicsTest {
    @Test
    void graphicsTest() throws CloneNotSupportedException {
        Size size = new Size(1, 2);
        Graphics graphics = new Graphics("red", "circular", size);
        Graphics clone = graphics.clone();
        // 修改引用类型内容
        size.height = 3;
        size.width = 5;
        System.out.println("graphics = " + graphics);
        // 判断两个对象是否不同
        Assertions.assertNotSame(graphics, clone);
        clone.setColor("blue");
        clone.setShape("square");
        System.out.println("clone = " + clone);
    }
}
```

**注意此时的引用对象 size 的值**

```text
graphics = Graphics[color='red', shape='circular', size=Size(5, 3)]
clone = Graphics[color='blue', shape='square', size=Size(1, 2)]
```

完整代码  [https://github.com/lvgocc/java-design-patterns/tree/main/prototype](https://github.com/lvgocc/java-design-patterns/tree/main/prototype)

## 原型模式自身有什么优势和问题呢？ 🤔

**优势：**

1. JDK 的 cloneable 接口是基于内存数据的直接复制，速度相较于 new 关键字创建对象更加快速；同时简化了创建过程（不会执行构造方法）。
2. 通过**深克隆**来保存一个对象某一时刻的状态，便于还原，实现撤销操作；

问题：

1. 需要为每个类重写 #clone 方法；
2. 深克隆需要将每个对象都维护一个 cloneable 接口；
3. 构造方法中的代码不会执行；



## 总结

当我们需要频繁使用一些类似的对象的时候，可以考虑使用原型模式来降低资源的开销，使资源得到合理的分配和使用。而对于原型模式的深克隆带来的弊端，就显得那么的不重要了。

1. 类似的对象使用频繁，考虑原型模式
2. 深克隆时注意类中的引用类型是否实现了 cloneable 接口
3. 注意构造函数中是否有必要代码要执行，可以考虑放到 #clone 方法中执行


----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>获取源码、加群一起交流学习🤓。</p>
    <img alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>
