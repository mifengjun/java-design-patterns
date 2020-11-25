![template-method-title.png](https://i.loli.net/2020/11/24/65JlOrxysH82ivQ.png)

# 冲啊！

最近经常看《四驱兄弟》，脑子已经被“冲啊”洗掉了。

“冲啊，就让我们一路领先到底吧！”，“冲啊，看我的胜利冲锋！”，“冲啊！先驱音速！”，“去吧！三角箭！”，“冲啊！疾速斧头！”，“冲啊！二郎丸特别号！”，“冲啊！”

终于来到了设计模式的“人性”部分，行为型模式，为什么说行为型模式是“人性”部分呢，因为行为型模式当中的 11 种设计模式对理解都非常的友好啊。所以接下来的内容可能让我学起来说不定更有趣些。

# 模板方法模式

> 定义一个操作中的算法骨架，将算法的一些步骤延迟到子类中，使得子类在可以不改变该算法结构的情况下重定义该算法的某些特定步骤。

## 如何理解

定义一个操作中的算法骨架，说白了这不就是一个步骤约束吗？在看第二段，将算法的一些步骤延迟到子类中，意思就是步骤里的一部分留给你了，具体怎么做看你（子类）自己了。使得子类在可以不改变该算法结构的情况下重定义该算法的某些特定步骤，这句就更好理解了，有了步骤的约束，你负责执行具体的步骤，说白了，步骤只要执行就可以，不管你怎么做，所以也就有了不改变结构的情况下可以重新定义特定的步骤，这里的特定指的就是约束步骤里留给你的那部分步骤。

- 比如我们经常写 PPT 的小伙伴知道，在 PPT 中，点击新增一页 PPT ，创建出来的页面，大部分的布局格式都是已经设置好的，我们只需要去填充里面的内容就可以了。

- 再比如经常写需求说明书的时候，会和同事要一份“模板”，这也是一种模板方法模式的体现。

- 还有如果你使用过 maven 创建过项目，那这个你一定不陌生

![template-method-maven.png](https://i.loli.net/2020/11/24/1mWL2Nnue5A3yrF.png)

## 重新定义

模板方法模式就是：提供一个具体的步骤，1,2,3,4，现在1,2,4都写好了，步骤3的实现由具体的执行者说了算，只要步骤符合要求，随你发挥。

## 模板方法模式类图 📌

![template-method](https://i.loli.net/2020/11/24/RsQzpH46XNZTWcd.png)

看类图就是抽象和子类的样子，而实际模板方法模式就是利用了"抽象"。是一个完全遵守开闭原则的设计模式。可以这么说，搞懂了模板方法模式，开闭原则基本就通了。

**注意：模板方法模式中与我们平时继承抽象类有一个关键性的区别，就是入口方法，正常抽象类继承是不需要有这个所谓的入口方法，可以通过入口方法来确定算法的执行顺序，即算法骨架。**

## 我怎么用模板方法模式📃

模板方法模式可以说是非常简单的一种设计模式了，虽然简单，但它的作用却很大。比如我们经常使用的lock 锁，它的实现就利用了 AQS ，而 AQS 就是使用 **模板方法模式** 维护的一个锁框架，通过它可以快速的开发出一个锁。这步可以结合 AQS 的代码来看一看。

第一步：通过 Lock 接口来约束一个锁所需要的几个关键方法（其实这也可以说是一种模板，只是约束力很小）

```java
public class MutexLock implements Lock {

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(0);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
```

**核心代码**

第二步：具体的锁实现，这个类的约束力比较强，因为我们想偷懒，借助 AQS 来实现一个锁，所以就要按照它所提供的模板要求来完成对应步骤的代码逻辑，也就是上面提到的（使得子类在可以不改变该算法结构的情况下重定义该算法的某些特定步骤。）这些需要我们去写的步骤就是 AQS 留给我们的 “特殊步骤”

```java
final static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, arg)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            } else {
                return false;
            }
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (compareAndSetState(1, arg)) {
                setExclusiveOwnerThread(null);
                return true;
            } else {
                return false;
            }
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }
```

关于 AQS 留给我们的 “特殊步骤”可以在源码中看到

我们自己定一个锁，然后调用 acquire 方法

```java
public class MutexLock implements Lock {

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }
```

之后 AQS 按照它的模板继续执行，在需要的时候（特殊步骤）会调用我们自己提供的方法，锁具体的实现要自行实现，模板类 AQS 不提供具体实现。

![template-method-AQS1.png](https://i.loli.net/2020/11/24/ruJo4M3l1SF9ILO.png)

```java
        // 重写 AQS 的特殊步骤，如果不写会抛出上述异常
		@Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, arg)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            } else {
                return false;
            }
        }
```

通过一个图来理解这个过程

![template-method-AQS2.png](https://i.loli.net/2020/11/24/Vl3LZn1STyj8MbU.png)

其中“**特殊步骤**”就是 AQS 模板留给我们要实现的地方。

最后，测试一下我们自己写的锁

```java
class MutexLockTest {
    private static int f = 0;

    @Test
    void lock() throws InterruptedException {
        Lock lock = new MutexLock();
        int threadCount = Runtime.getRuntime().availableProcessors();
        CountDownLatch signal = new CountDownLatch(threadCount);
        int loop = 100000;
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                int l = 0;
                while (l < loop) {
                    lock.lock();
                    try {
                        f++;
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                    l++;
                }
                signal.countDown();
            });
            thread.start();
        }
        signal.await();
        Assertions.assertEquals(threadCount * loop, f);
    }
```

**运行结果**

![template-method-test.png](https://i.loli.net/2020/11/24/bXn3FYOSryAseka.png)

这里建议大家配合源码学习，同时也能学习一些与锁实现上的一些相关知识，如果有不清楚或觉得有疑问的地方，欢迎加我微信一起讨论（lvgocc）

## 总结 📚

通过模版模式可以将一些我们想要约束的执行步骤固定下来，同时对于步骤中重复的内容可以进行抽象，这样就可以简化很多子类的操作，也避免了一些不必要的冗余代码产生。

使用模板方法模式可以非常简单的来约束一段逻辑的执行要求。在做程序扩展限制时，非常有用。定义好具体的逻辑流程抽象类，将公共部分代码写在抽象类中，然后将其中需要使用者自行实现的方法定义为抽象方法，这样当他继承这个类的时候，只需要将对应的抽象方法实现就好了，不需要关系其具体的执行顺序。

但同样的，这样会使**执行顺序对使用者完全透明**，如果抽象的方法较为复杂时，对于一个初次使用该逻辑的人来说，出现 bug 可能会使他很“难受”，因为他需要搞清楚整个抽象类中每个方法的执行顺序才能更好的去解决问题。这一点，**增加了系统的复杂性**。不过，设计模式的复杂性，是不可避免的。**在功能复用、提高生产力上来说，这点复杂性的代价，还是能够接受的。**

----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>获取源码、加群一起交流学习🤓。</p>
    <img alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>
