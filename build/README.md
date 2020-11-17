![build](https://i.loli.net/2020/10/17/8NsSJTuzyraGeOV.png)

# 建造者模式 🔨

> 指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示

根据建造者模式的定义，我们可以先简单的了解一下建造者模式要解决的问题，它是指将一个复杂对象的构建与它的表示分离，这句话的意思是指一个对象的构建过程与表示不再绝对。即一个构建过程对应多个结果，这取决于客户端如果指挥构建者进行对象的构建。这里的构建者就是我们接下来要讲的建造者模式内容。


## 理解程序中的建造 🗯

对于建造这个词语没什么好说的，在软件程序中建造是什么呢？我相信看到下面这个例子你应该就已经掌握了什么是建造者模式，当然这还不够，让我们慢慢来。

### JDK 中的 StringBuilder

```java
public class StringBuilderTest {
    @Test
    void test(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1).append("个张三，和").append(4).append("个李四");
        System.out.println(stringBuilder.toString());
    }
}
```

```text
1个张三，和4个李四
Process finished with exit code 0
```

上面的例子是妇孺皆知的 JDK 中提供的一个为了解决复杂 String 对象的 String 对象生成器。它还有个孪生姐夫``StringBuffer``用在并发环境下。



### Netty 中的 ServerBootstrap

再比如这个，netty 的启动器

```java
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(parentGroup, childGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childHandler(new NettyProtobufChannelInitializer());

        try {
            ChannelFuture sync = bootstrap.bind(2333).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
```

通过建造者 ``ServerBootstrap`` 来完成一个启动器的构建，同一个构造过程，却有着千差万别的结果。



### lvgo 的 Slient 并发任务处理器

如果建造者被我们自己应用的话，我个人将它使用到了程序插拔配置上了，就像 netty 的启动器一样。

```java
        new TaskHandler<String>(testData) {
            @Override
            public void run(String s) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("第" + s + "个任务" + Thread.currentThread());
            }
        }.sync(false).overRun(() -> {
            log.debug("我所有的任务执行结束了");
        }).execute(10);
```

上面我写的这个组件已发布到 maven 仓库，源码仓库：[https://github.com/lvgocc/silent](https://github.com/lvgocc/silent)

```xml
<dependency>
  <groupId>org.lvgo</groupId>
  <artifactId>silent</artifactId>
  <version>1.0</version>
</dependency>
```

通过上面的几个例子我们大概知道什么是建造者模式了，它可以通过同一个构造过程来创建出不同的表示对象，比如

- StringBuilder 通过不同的参数传入 append 方法，得到结果是不一样的；
- ServerBootstrap 的不同参数设置，启动出来的 netty 服务端有着不同作用；
- TaskHandler 通过指定不同的参数，可以使任务的执行效果产生不同的变化；

## 建造者模式类图 📌

> 注：在 GOF 的原著中对建造模式的理解与本篇差别较大。所以类图看起来会和很多资料中有所差异，望读者知悉。

![build-UML](https://i.loli.net/2020/10/17/Aqzo6p4f1FPlasD.png)

GOF 中定义的建造者类图

![gof-build-UML](https://i.loli.net/2020/10/17/jVEaygYQd7rOscR.png)

这里说明一下，GOF 的建造者模式中体现的是将要构建的对象、构建者、具体构建者、指挥者4部分独立开来，可以做很好的水平扩展。而 lvgo 将建造者的抽象类与具体的构建者合成一个，通过参数的方式将具体的构建者体现出来。将指挥者的角色延迟到了客户端，直接由客户端 client 来代替 Director 的工作。

## 代码 📄

> 避免篇幅过长，完整代码及单元测试结果点击查看 [https://github.com/lvgocc/java-design-patterns/tree/main/build](https://github.com/lvgocc/java-design-patterns/tree/main/build)


为了能够更好的去理解 lvgo 与 GOF 中类图的差异，这里准备了两种写法，以诠释上面的说明。

**GOF 类图的实现**

```java
public abstract class Builder {

    protected PlayerRole playerRole = new PlayerRole();

    abstract void setHairColor();
    abstract void setShape();
    abstract void setSkinColour();

    PlayerRole build() {
        return playerRole;
    }
}
```

```java
public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public PlayerRole construct() {
        builder.setHairColor();
        builder.setShape();
        builder.setSkinColour();
        return builder.build();
    }
    public PlayerRole construct2() {
        builder.setHairColor();
        return builder.build();
    }
    public PlayerRole construct3() {
        builder.setSkinColour();
        return builder.build();
    }
}
```

```java
public class PlayerRoleBuilder extends Builder {
    @Override
    void setHairColor() {
        playerRole.setHairColor("褐色");
    }

    @Override
    void setShape() {
        playerRole.setShape("健硕");
    }

    @Override
    void setSkinColour() {
        playerRole.setSkinColour("古铜色");
    }
}
```

```java
public class PlayerRole {

    private String hairColor;
    private String shape;
    private String skinColour;
}
```

测试类

```java
    void build() {
        Builder playerRoleBuilder = new PlayerRoleBuilder();
        Director playerRoleBuildDirector = new Director(playerRoleBuilder);
        PlayerRole construct = playerRoleBuildDirector.construct();
    }
```

结果

```java
construct = PlayerRole{hairColor='褐色', shape='健硕', skinColour='古铜色'}
```

个人觉得这种写法稍为复杂，不过他的水平扩展性和隔离性都比较好。



**lvgo 整理的写法如下**

```java
public class PlayerRole {

    private String hairColor;
    private String shape;
    private String skinColour;
}
```

```java
public class PlayerRoleBuilder {

    private final PlayerRole playerRole = new PlayerRole();

    PlayerRoleBuilder hairColor(String color) {
        playerRole.setHairColor(color);
        return this;
    }

    PlayerRoleBuilder shape(String shape) {
        playerRole.setShape(shape);
        return this;
    }

    PlayerRoleBuilder skinColour(String skinColour) {
        playerRole.setSkinColour(skinColour);
        return this;
    }

    PlayerRole build() {
        return playerRole;
    }
}
```

测试

```java
    @Test
    void test(){
        PlayerRoleBuilder playerRoleBuilder = new PlayerRoleBuilder();
        playerRoleBuilder.hairColor("红色").shape("健硕").skinColour("古铜色");
        PlayerRole build = playerRoleBuilder.build();
        System.out.println("build = " + build);
    }
```

结果

```java
build = PlayerRole{hairColor='红色', shape='健硕', skinColour='古铜色'}
```



## 总结 🐱‍💻


**相同的资源，不同的结果**是我对建造者模式创建对象的理解。就像建造我们的人生，提供了相同的世界，相同的空气，每个个体的表现均不同。


通过使用建造者模式，我们可以更加灵活的去处理一个构建过程复杂的对象。将它的构建过程与表示分离开。例如如果你正在为**一长串的 set 方法**苦恼的时候可以考虑一下建造者模式。它使代码更整洁，可读性更好。

```java
xxx.setA();
xxx.setB();
xxx.setC();
xxx.setD();
xxx.setE();
```

```java
xxx.A().B().C().D().E().build();
```
当你想要给一个对象组装一个特有的结果的时候，不妨试试 GOF 的思路，很不错的。

**缺点：**

建造者模式因为需要维护一个单独的建造者类，同时要为每个属性单独维护一个方法，当类中有属性调整的时候，要一起调整对应建造者中的方法，这也是随它的优势而带来的一些副作用。**但如果有需要它的地方尽管去用。没有什么比混沌的代码更糟糕的事情了。**

## 案例应用

这里为了应读者要求，想有对应的案例可以参考，不然不清楚设计模式到底在什么地方用。

1. 餐饮系统有23道素材、18道荤菜，老板今天推出 8 种 2素 1 荤套餐，你如何实现？
2. 试想一下在我的世界（mc）中，提供了各种不同的道具，相同的道具组合，你做出来的房子和我做出来的房子看起来不那么一样。
3. 在塔防类游戏中，同一个射手，每次攒钱给他升级，最终有的变成了单体攻击高的神射手，有的变成散射群里攻击低的散箭手。



## 返璞归真

我认为学习设计模式的过程就像拿到一台游戏机，玩到最后，我都会拆开看看里面是什么，而早已不关心游戏好不好玩了。

知识也是一样，知其然而知其所以然。

**我们为了学会使用某种东西看他的操作手册就可以了；**

**我们如果想要学会修某种东西就需要看他的设计手册；**

**当我们想要创造某种东西，你就需要掌握很多很多设计手册，将他们的经验进行吸收、消化、提炼。才能有更好的结果。**

*当然，如果你只想会用，有一份差不多的操作指南也就够了。*

抱歉这一篇说了一些题外话。

----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>获取源码、加群一起交流学习🤓。</p>
    <img alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>
