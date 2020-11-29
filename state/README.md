# 状态模式

> 允许一个对象在其内部状态发生改变时改变其行为能力。

我刚开始看到这个模式的时候，没啥感觉，不知道这东西要说的是个啥，后来看了个案例，渐渐清楚了，这个模式本身还是比较简单的。

## 小菜的工作状态

> 这个案例出自程杰的《大话设计模式》，抽取案例模型，完整案例还请大家自行阅读

案例说的是主人公“小菜”上班写代码时的各种状态，上午的时候精神饱满，中午时有点萎靡，下午状态一般，晚上状态疲惫。然后这一天各个时段的写代码状态用程序表达出来是这个样子的；

```java
public class Work {

    static int clock;

    public static void main(String[] args) {
        // 上午 9 点
        clock = 9;
        writeCode();
        // 中午 12 点
        clock = 12;
        writeCode();
        // 下午 15 点
        clock = 15;
        writeCode();
        // 晚上 21 点
        clock = 21;
        writeCode();
    }

    public static void writeCode() {
        if (clock < 12) {
            System.out.println("精神抖擞写代码");
        } else if (clock < 13) {
            System.out.println("饿了困了写代码");
        } else if (clock < 17) {
            System.out.println("状态一般写代码");
        } else if (clock < 23) {
            System.out.println("加班疲惫写代码");
        }
    }
}
```

一段典型的面向过程编程代码，之后根据面向对象的思想来改了一版变成了这样。

```java
public class OOPWork {

    public static void main(String[] args) {
        Working working = new Working();
        // 上午 9 点
        working.clock = 9;
        working.writeCode();
        // 中午 12 点
        working.clock = 12;
        working.writeCode();
        // 下午 15 点
        working.clock = 15;
        working.writeCode();
        // 晚上 21 点
        working.clock = 21;
        working.writeCode();
    }
}

class Working {
    int clock;

    public void writeCode() {
        if (clock < 12) {
            new MorningState();
        } else if (clock < 13) {
            new NoonState();
        } else if (clock < 17) {
            new AfterNoonState();
        } else if (clock < 23) {
            new EveningState();
        }
    }
}

class MorningState {

    {
        System.out.println("精神抖擞写代码");
    }
}

class NoonState {

    {
        System.out.println("饿了困了写代码");
    }
}

class AfterNoonState {

    {
        System.out.println("状态一般写代码");
    }
}


class EveningState {

    {
        System.out.println("加班疲惫写代码");
    }
}
```

其实写到这里我相信大家就算没看过这本书也能多少发现一点端倪，就是这个 Working 类是不是有点奇怪。每新增一个状态就要去改这个类，而且这里负责了全部的工作状态，还有最关键的就是这个 ``if else`` 是不是有点太长了？？？没错，其实这些都可以用 `状态模式` 来规避掉，并且这些在软件设计中也都违反了一些原则或建议。

1. 每新增一个状态就要去改这个类（违反了 `开闭原则`）
2. 而且这里负责了全部的工作状态（违反了 `单一职责原则`）
3. 还有最关键的就是这个 ``if else`` 是不是有点太长了？？？（这是 `重构` 书中提到的 `long method` 的坏味道）



## 利用状态模式解决这 3 个问题

首先来看下状态模式的结构类图

### 状态模式类图 📌

![state-UML](https://i.loli.net/2020/11/29/YWsdEVzrgFheG3A.png)

这里有几个关键的角色

1. 运行的上下文环境 `Context` 对应到程序中就是 `Working` 类
2. 状态接口 `State` 这是为了解决单一职责和开闭原则；
3. 具体的状态，也就是 `State` 接口的实现

### 状态模式代码 📃

将上面的写法改成用状态模式的话就长这个样子

```java
@Test
void writeCode() {
    Working working = new Working(new MorningState());
    // 手动模拟不同时刻
    working.setClock(9);
    working.writeCode();

    working.setClock(12);
    working.writeCode();

    working.setClock(15);
    working.writeCode();

    working.setClock(21);
    working.writeCode();


    working.setClock(24);
    working.writeCode();
}
```

```java
public class Working {
    /**
     * 当前工作状态
     */
    private final WorkState concurrentState;

    /**
     * 当前时刻
     */
    private int clock;

    public Working(WorkState concurrentState) {
        this.concurrentState = concurrentState;
    }

    public void writeCode() {
        concurrentState.handle(this);
    }
    ....
    ....
    // 篇幅原因，完整代码关注回复“源码”获取。
}
```

测试结果
```java
精神抖擞写代码
饿了困了写代码
状态一般写代码
加班疲惫写代码
别再写了，程序员回家了，明早再试吧😢，现在都已经24点了。放过他吧
```

> 篇幅原因，完整代码关注回复“源码”获取。

这样不仅消除了 `if else` 的臃肿 `long method` 坏味道代码，同时 Working 类更专注 “写代码”，同时有 `State` 接口的出现，实现了开闭原则，让程序的扩展的到了保障，并且一个关键的内容就是“在不同时刻，调用 writeCode 方法的结果是不同的。这也是状态模式的定义中提到的 `一个对象在其内部状态发生改变时改变其行为能力。` 改变对象的一个状态，使他的行为也发生了变化，这看起来就像我们对这个类的代码进行了修改一样。



## 状态模式延伸

如果大家有做过交易系统的订单的话，有一个东西应该不会陌生，叫做 `有限状态机` 也叫做 `状态机`。

![state-order](https://i.loli.net/2020/11/29/ODt68sjlZchYk3M.png)

这是正常情况，也就是如果一个订单按照正常步骤来流转是会按照上图所示来进行。但是，真实的订单场景远比这个要复杂的多。

这里我们只看一些简单的几个场景：

1. 提交订单之后突然心思转变，不买了，那这个时候给客户就是`取消订单`和`付款`两种选择，这一步发生的时候，订单状态为 `待付款`；
2. 付款之后又看了看发现有更好的店铺选择，此时钱已经付了，所以此时的操作提供给客户的就是 `申请退款`，此时订单状态为 `待发货`；
3. 等等订单场景较为复杂，不过万变不离其宗，即 `不同的状态，用户的操作行为和这笔订单之后的行为是有限的`；

用一个图来看下上述几个问题场景

![state-exception-order](https://i.loli.net/2020/11/29/gbnuih81x7ZYMBr.png)

我们可以通过图可以看到，即使只有这简单的两种情况，整个订单的处理逻辑就已经开始变得复杂了起来，如果利用传统的面向过程编程或简单的面向对象编程思路来设计这个订单流程逻辑，我想，第一版，也就是正常的订单流程开发实现起来问题应该“不大”，无非代码啰嗦一点、判断逻辑多一点。

不过一旦产品经理提出在付款时可以进行撤单操作、在发货时可以进行退款、发货前可以修改接收地址又或者收货时可以拒收等等这些需求时，我觉得这个业务应该不会有人愿意去开发了。

不是开发人员不愿意做这个业务，而是不愿意在糟糕的代码上进行再次迭代（当然在现实情况，一个糟糕的团队确有可能继续在糟糕的代码上继续迭代，原因很简单，因为他们从一开始便能设计出来，领导能通过就说明这是一个没有技术沉淀的团队，他们很愿意将一坨坨代码“至死不渝”的一直维护下去）。

如果订单状态利用 `状态模式` 来设计，无论状态如何变化，高层模块也永远不需要关心，这也是开闭与单一职责这两个原则的很好体现。在哪个状态能做哪些事情，完全有对应的状态说了算，即使在复杂的业务，也会因为状态的区分而是业务颗粒变得很小（如果传统的 `if else` 到底，整个业务流程必须全部重新测试一遍，这不是谁说的，这是由高耦合紧密设计决定的，逃不开），这一点在开发和测试上，都会大幅提高开发和测试效率和节省成本。

好了，关于这一块内容确实大家可以看看 `有限状态机` ，订单业务在实际情况是交由 `状态机` 来管理的。



## 总结 📚

当你的应用程序可能会存在多种状态，而且每种状态的行为会随着状态的改变而改变，这时你可以考虑使用状态模式。通过状态模式不光可以使应用程序可以和应用状态可以很好的解耦，同时在状态的管理和扩展上都是非常的有帮助。

状态模式关键的几个点：

1. 应用环境的上下文，这个是用来作为状态模式的入口，他负责来调用当前状态的执行方法。
2. 状态接口，这个接口负责管理全部的状态，这里在使用的时候需要好好设计，可以将整个业务所有的状态方法全部维护好，在具体接口类中间放一个抽象状态类，如果当前状态不能操作这个方法可以放在一个抽象类中来实现一个空方法，而不是子类去实现全部的接口方法。

设计模式是一把双刃剑，在合理的时机使用可以达到很好的应用效果，反之亦然。大家要谨慎对待。不要变成手里只有一把锤子的人。

----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>欢迎加群一起交流学习🤓。</p>
    <img alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>
