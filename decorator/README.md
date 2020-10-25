![decorator-title](https://i.loli.net/2020/10/25/pRsncV7AJKI4CFG.png)

## 题外话

一直都有看到“包装者模式“ 出现在一些文章，甚至书中。它们被应用在装饰者模式和适配器模式中，这个原因笔者猜测源自 GOF 最早在书中给模式命名的时候提到了这两个模式的别名 wrapper同时还有适配器也被成为 wrapper, 所以有人将这几个名称混来混去。后来 GOF 在结尾讲书的简史的时候有提到一些模式的名称变化，其中 glue 改成了 facade， wrapper 改为 decorator ，walker 变成了 visitor 。


## 前言

前阵子出于自己学习使用的原因开发了一个 chrome extension ，这样我的 chrome 变得比以前更强了，我赋予了它一个可以保存某个页面的某个片段的位置，后续通过点击这个记录可以快速的回到并高亮当时浏览的记录。

![memo1](https://i.loli.net/2020/10/24/hb75jWUIlHGdmu1.png)

![memo](https://i.loli.net/2020/10/24/HamO9V56Y3bMKJP.png)

**我给 chrome 简单的装饰了一下（加了一个插件），它就变强了**

``插件开源，可以作为基础进行二次开发，想要开发 chrome 插件但是不知道如何开始的可以参考。关注``**星尘的一个朋友**``公众号，回复源码获取``



## 不知不觉你已经知道了装饰者的概念。

> 动态地给一个对象添加一些额外的职责

![chrome](https://i.loli.net/2020/10/24/j7fU3RozypgGWAN.png)

![chrome](https://i.loli.net/2020/10/24/EqQbkpzTeP6n5t3.png)



上面两个举出的例子在实际过程中只要你想，你可以无限的装饰它，所以装饰者的类，可以一直嵌套下去。就像

```java
        InputStream in = new DataInputStream(new FileInputStream(new File("filePath")));
```

如果IO不熟，看得不理解，那再看看这个

```java
        List<Object> list = new ArrayList<>();
        list = Collections.synchronizedList(list);
```

其实，当我写到这里的时候已经很清楚装饰者的概念了，它就是通过“套娃”变强了😂！

让我继续深入看看它的结构图👀。

## 装饰者模式类图 📌


![装饰者模式类图](https://i.loli.net/2020/10/25/L2a951Jf7cIspGK.png)

一个浏览器的接口，一个 Chrome 实现类，一个 ChromeExtension 插件的实现类（用以装饰 Chrome），扩展中的构造函数为 浏览器类型，在插件类中会对浏览器 Brower 的 browse 方法进行一层装饰（增强，或减弱），在不改变对象的情况下，对对象行为进行动态的改变。



上面的类图在抽象一层的话就变成了了这个样子

![装饰者模式类图](https://i.loli.net/2020/10/24/iJMe7mblkcOGTV2.png)

> 为了示意，名称使用了中文，当然如果能够让人清楚你在干什么，无所谓你怎么表达。

通过对象的组合来实现类的增强要比继承更加的灵活。这也是软件设计原则中的组合复用原则的一种体现，优先使用组合，然后考虑继承。



## 代码 📄

> 关注公众号：星尘的一个朋友 回复：``源码``，获取全部代码和类图

![decorator-code](https://i.loli.net/2020/10/25/qsjOMU9HLpcnlzP.png)



代码演示通过一个游戏获取道具的方式来理解装饰者模式的具体实现；

想来想去，我没有选择超级玛丽，图难找，代码不好表达🤣

所以我选择了它 **Tank Battle** ![tank](https://i.loli.net/2020/10/24/KED9OZhFk7WGtbl.jpg)😂

``很多回忆都在这里``而且好表达😁

在这游戏中，我们吃到一个星星⭐的时候，就会变强，可以发射两发子弹，同时样子也会发生改变。



![image-20201025111349260](https://i.loli.net/2020/10/25/hfzJVmHCj6sNIEq.png) 吃了这个星（装饰），我变得更强 ![p1tankU](https://i.loli.net/2020/10/24/uQvdNDEV7JmLBCZ.gif)  ==>>  ![star](https://i.loli.net/2020/10/24/QvIyB28tdxSjnrK.gif) ==>> ![enemy3U](https://i.loli.net/2020/10/25/ANrTSZUghK5lcot.gif)



### 结构组成

1. 被装饰者接口
2. 具体的装饰者类
3. 抽象装饰者
4. 具体的装饰者

因为星星强化一共有 3 个级别

- 移动、子弹加速

- 连发

- 打掉白色方块


所以我们应该有 3 个装饰者。类角色。

1. 被装饰者接口 -> 坦克 Tank
2. 具体的被装饰者 -> 玩家坦克 PlayerTank
3. 抽象装饰者 -> 用来抽象定义装饰者基本信息，如构造函数等 TankDecorator
4. 具体的装饰者 -> OneStarTankDecorator -> TwoStarTankDecorator -> ThreeStarTankDecorator



![decorator](https://i.loli.net/2020/10/25/LySXmYe7CJov9wx.png)



**部分代码**

> 关注公众号：``星尘的一个朋友`` 回复：``源码``，**获取全部代码和类图**

```java
/**
 * 玩家坦克
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 11:40
 * @since 1.0.0
 */
public class PlayerTank extends Tank {

    /**
     * 玩家默认坦克数据，移动，设计速度 1
     */
    public PlayerTank() {
        super(1, 1);
    }
}
```



```java
/**
 * 定义坦克抽象装饰者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 11:40
 * @since 1.0.0
 */
public abstract class TankDecorator extends Tank{

    protected Tank tank;

    public TankDecorator(Tank tank) {
        this.tank = tank;
    }

    @Override
    protected void move() {
        tank.move();
    }

    @Override
    protected void fire() {
        tank.fire();
    }
}
```



测试结果

![image-20201025141131981](https://i.loli.net/2020/10/25/FaRXJTVbftoL3sY.png)





## 总结 🐱‍💻

坦克增强的过程是一颗星一颗星获取的一个过程，一直在动态的增强。这个案例中只是一个维度，坦克吃星星。如果在增加一些额外的功能时，比如坦克变身，进化等等，不断的增加装饰时，就可以体会到装饰者模式组合的可扩展性。当然使用继承来实现的话，如果是单一不变的多种状况是很好的，比如说我的玩家坦克的选择不同的外观，可通过不同的子类来确定下来，但如果动态的想要增加一个类的时候，继承就显得非常的困难。

装饰者模式在不改变原对象的情况下，动态的增强具有较好的可扩展性。这也体现了``开闭原则``。但我们发现，如果你不合理的使用装饰者模式，类的数量会变的更多，且多重装饰使一个对象的维护变的更加复杂。所以，就像前面说的，具体的特性就完全可以用继承来实现而非装饰者模式，装饰者模式一定是使用在想要动态的给对象增加一些功能的时候使用。

- 比如 JDK 中对 IO 的操作有一个 read() 操作，对它进行装饰之后就变成了 readLine().
 ![image-20201025143102142](https://i.loli.net/2020/10/25/hBN54spCA7yaqto.png)
 ![image-20201025143124892](https://i.loli.net/2020/10/25/thRfTdxnbvZpNEV.png)
 ![image-20201025143158945](https://i.loli.net/2020/10/25/abst7No5EjLGFQY.png)

- 再比如 JDK 中的 Collections 工具类，通过对集合类的装饰，使其变得线程安全，而对象本身却没有发生改变

![image-20201025143320753](https://i.loli.net/2020/10/25/qfHuhsSwnGMLY4F.png)

![image-20201025143355998](https://i.loli.net/2020/10/25/VXEMplcQaYkmHBy.png)

仅仅是对原来的方法前面都加了 `` synchronized`` 关键字来对原对象做了增强

![image-20201025143507646](https://i.loli.net/2020/10/25/MFXhDSzmRg3lAoT.png)

而 List 本身仍有更多的子类。Collections 工具类提供的就是对 List 对象做增强。



## 结尾

当我们明白了一件事物的本质之后，再去看表象会变的轻而易举。而这最关键的是要去亲自的操作它，看着再简单不过的东西，你第一次动手都会有很大的收获。这也让我想起了初中物理课本最常见的一句话 “**动手动脑学物理**”

![img](https://i.loli.net/2020/10/25/TI5ECVzNZQgqi6A.jpg)

任何情况下，看会和听懂都不是掌握。再不济语文课也学过“书读百遍其义自见”也是要动动嘴的🗣。加油！



----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>获取源码、加群一起交流学习🤓。</p>
    <img alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>
