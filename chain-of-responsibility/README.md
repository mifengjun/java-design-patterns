![chain-of-responsibility.png](https://i.loli.net/2020/11/28/25fjXDYo4VriF9l.png)

> 图片来源：https://refactoringguru.cn/design-patterns/chain-of-responsibility

# 责任链模式

> 把请求从链中的一个对象传到下一个对象，直到请求被响应为止。通过这种方式去除对象之间的耦合。

通过上面的图其实也能看个差不多了，在这幅图中水桶就是整个链路中被传递的对象。它可以在链路上的任意一个节点被消费，如果你觉得剩的水可以继续给下一个节点用，你甚至可以将它继续传递下去。这样设计的好处就行定义中说的那样，去除对象间的耦合。

假设这个业务场景需要请求的对象是存在联系的，比如具有一定顺序去消费同一个对象，又比如他们消费对象的方法相同，具体逻辑略有差异。此时如果这个水桶对象的传递不通过责任链这种模式，看看会有什么问题。

![chain-of-responsibility-none](https://i.loli.net/2020/11/28/UuO5PtAK6Xwvx1q.png)

王二需要分为4个时刻与4个不同的对象进行交互，这无疑增加了系统的复杂性。并且这里其中任意一个请求目标发生变化，王二都必须要跟着调整。再比如下面这个生活中的例子。

王二因为一些原因不能上班，需要和领导请假，卑微的王二在单位的职位级别比较低，需要多级领导审批，甚至同事都是一个坎，让我们看看没有责任链模式介入时王二的请假过程。

![chain-of-responsibility-wanger](https://i.loli.net/2020/11/28/f2Vca1v5tFpGPhn.png)

**王二卒。**



王二这件事被同事张三知道后，张三决定为了纪念王二的悲催经历。他决定向领导提出一个流程调整方案，具体的意见如下；

1. 请假时每个人的动作相同，均为审批。至于审批是同意或拒绝由审批者自己决定。
2. 对请假流程中涉及的人员使用链式传递。不得跨越（即每个人必须都需要经过处理后才能继续传递）。



## 责任链模式类图 📌

![chain-of-responsibility-UML.png](https://i.loli.net/2020/11/28/VwsODFXe7ISup6c.png)



## 张三请假 📃

张三使用责任链模式请假流程示意图

![chain-of-responsibility-zhangsan](https://i.loli.net/2020/11/28/QKCPk5Ixmpir7to.png)

抽象处理类，各个环节处理时统一标准。

```java
public abstract class AbstractHandler {

    protected AbstractHandler next;

    public AbstractHandler getNext() {
        return next;
    }

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    protected void handle(String request) {
        conCreteHandle(request);
        if (getNext() == null) {
            System.out.println("流程结束");
        } else {
            getNext().handle(request);
        }
    }

    protected abstract void conCreteHandle(String request);
}
```



```java
public class QingJia extends AbstractHandler{
    @Override
    protected void conCreteHandle(String request) {
        System.out.println(request);
    }
}
```



```java
class AbstractHandlerTest {

    @Test
    void handle() {
        AbstractHandler qingJia = new QingJia();
        AbstractHandler renShi = new RenShi();
        AbstractHandler shangjiLingdao = new ShangjiLingdao();
        AbstractHandler tongShi = new TongShi();
        AbstractHandler zuZhang = new ZuZhang();

        qingJia.setNext(tongShi);
        tongShi.setNext(zuZhang);
        zuZhang.setNext(shangjiLingdao);
        shangjiLingdao.setNext(renShi);

        qingJia.handle("张三请假");

    }
}
```

测试张三请假

```text
张三请假
同事审批：同意
组长审批：同意
上级领导审批：同意
人事审批：同意
流程结束
```

> 完整代码文末关注，回复 “源码” 获取。

## 总结 📚

使用责任链模式可以使原本的对象间耦合度降低。各个模块间功能更加具体专注。同时链上的处理也可以更加灵活，可以通过处理请求的时候进行判断来过滤自己关注的内容来处理，或者在生成链的时候将无关节点去掉。

同时可以配合创建型模式中的工厂模式，来封装链的维护，这样在链上节点发生变化时（算法实现发生改变、新增或删除）对于高层模块是没有感知的。扩展起来非常的方便。或使用建造者模式来更加灵活地创建这条“责任链”，以达到客户端的自定义目的。总之，责任链模式在处理链式问题是个利器。



----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>获取源码、加群一起交流学习🤓。</p>
    <img width="200px" alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>
