# 设计模式（Java实现）

　　设计模式专题，共 23 种设计模式。每种设计模式均从根本出发，深入理解设计思想，再配合一些小故事加以理解，让设计模式变得通俗易懂。让自己和现在正在阅读的你，能够知其然而知其所以然。

- 提到单例想到 “饿汉？，懒汉？”
- 提到工厂想到 “汽车？”
- 提到抽象工厂想到 “一个大的工厂？“
- 提到适配器想到 “插头？USB？”

　　如果是，我相信这里很适合你阅读学习。设计模式学了不会用？可以看两篇试一试，同样的知识，不一样的“味道”。

"每一篇...(突然被打断)"

“don't talk, show me see see” 

"好的大哥，这就安排！"

- [x] [1. 单例模式: 资源！要合理的分配使用！](https://github.com/lvgocc/java-design-patterns/tree/main/singleton)
- [x] [2. 原型模式：啥？盗图、盗文章的人居然用的是一种设计模式！原型模式？](https://github.com/lvgocc/java-design-patterns/tree/main/prototype)
- [x] [3. 工厂模式：像工厂一样创建对象，让业务代码更专注！](https://github.com/lvgocc/java-design-patterns/tree/main/factory)
- [x] [4. 抽象工厂模式：抽象工厂模式和工厂模式有区别吗？](https://github.com/lvgocc/java-design-patterns/tree/main/abstract-factory)
- [x] [5. 建造者模式：学个设计模式还和人生扯上关系了？](https://github.com/lvgocc/java-design-patterns/tree/main/build)
- [x] [6. 代理模式：有什么问题跟我律师说吧！](https://github.com/lvgocc/java-design-patterns/tree/main/proxy)
- [x] [7. 装饰者模式：玩了把坦克大战居然彻底搞懂了装饰者模式！](https://github.com/lvgocc/java-design-patterns/tree/main/decorator)
- [x] [8. 桥接模式：这个不常用的设计模式居然被我学的最透，草率了！](https://github.com/lvgocc/java-design-patterns/tree/main/bridge)
- [x] [9. 适配器模式：要是不认识榫字，可以点进来看看了，今天轻松点，就说说什么是“榫”，什么是“卯”，什么是“榫卯”！](https://github.com/lvgocc/java-design-patterns/tree/main/adapter)



每一篇都有对应的文章配合源码学习，文章以通俗为主，易懂为辅。学渣的心情学习学霸的知识，我不善搞深奥的东西，但喜欢将深奥的东西变成简单的东西，我深信复杂度守恒定律，我也相信讲出来的东西是为了让大家能听懂而不是自己秀知识储备而已。听懂掌声。

# 软件设计模式背景

>当我们要学习一门技术或者一类知识的时候，先去了解学习它的背景，会对我们接下来的学习和理解产生一些潜移默化的影响和帮助

这个背景千篇一律，事实就是如此。我用自己的话在总结一下。

## “设计模式”最初的提出，是在建筑领域。🌉

　　1977 年被美国的建筑大师🕍 克里斯托夫·亚历山大 （Christopher Alexander）在他的著作📕《建筑模式语言：城镇、建筑、构造（A Pattern Language: Towns Building Construction）中描述了一些常见的建筑设计问题，并提出了一系列的解决方案， 至此称为模式。


　　2年后，1979年，克里斯托夫·亚历山大 在他的另一本著作📙《建筑的永恒之道》（The Timeless Way of Building）进一步强化了设计模式的思想。


　　直到 1990 年，也就是 13 年后。设计模式一词才到了软件工程界，同时为此开辟了专题研讨会。

## GOF👨‍🦲👦👨🧑

　　在“设计模式”进入软件行业后的第5年，也就是 1995 年，艾瑞克·伽马（ErichGamma）👨‍🦲、理査德·海尔姆（Richard Helm）👦、拉尔夫·约翰森（Ralph Johnson）👨、约翰·威利斯迪斯（John Vlissides）🧑等 4 位作者合作出版了📘《设计模式：可复用面向对象软件的基础》（Design Patterns: Elements of Reusable Object-Oriented Software）一书。


　　从此掀起了软件工程界的“设计模式”浪潮，使越来越多的开发者受益，同时涌现出了越来越多的设计模式。而这 4 位作者在软件领域小组名称 Gang of Four 四人组（四人帮），后来设计模式也以此匿名著称 GOF。

![gof](https://i.loli.net/2020/10/08/CHaE8bzvX4fScYA.jpg)

## 设计模式要做的事情

　　现如今的设计模式可远不止笔者这里收录整理学习的 23 种，而要比这多太多太多，但这么多的设计模式希望做的事情确实相同的。都是为了能够被反复利用，解决不断重复出现的问题而存在的，就像当初 GOF 写的那本书一样，‘可复用面向对象的基础’。

　　一种方法，解决n种问题。这就是模式，它要解决的，就是拥有共性的问题。



# 设计模式基本原则
> 基本原则摘自 http://c.biancheng.net/design_pattern/

　　当问题的解决方案有很多时，该怎么权衡哪一个方案可以成为是模式呢？这就有了原则性的约束。为了提高软件系统的可维护性和可复用性，增加软件的可扩展性和灵活性，我们应当要尽量根据 **⑦** 条原则来开发程序，从而提高软件开发效率、节约软件开发成本和维护成本。

- 1️⃣ 开闭原则 OCP ， 1988 年 勃兰特·梅耶（Bertrand Meyer）在其著作《面向对象软件构造》📕中提出 ：<u>软件实体应当对扩展开放，对修改关闭</u>。

- 2️⃣ 里式替换原则 LSP ，1987 年 里斯科夫（Liskov）女士👩‍🦰 的“面向对象技术的高峰会议”（OOPSLA）上发表的一篇文章《数据抽象和层次》📜提出：<u>继承必须确保超类所拥有的性质在子类中仍然成立</u>。

- 3️⃣ 依赖倒置原则 DIP ，1996 年 Object Mentor 公司总裁罗伯特·马丁（Robert C.Martin）🧑在C++ Report 上发表的文章 ：高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象 （<u>要面向接口编程，不要面向实现编程。</u>）

- 4️⃣ 单一职责原则 SRP，罗伯特·C.马丁🧑（与DIP原则同一人）（Robert C. Martin）于《敏捷软件开发：原则、模式和实践》一书中提出的。这里的职责是指类变化的原因，单一职责原则规定一<u>个类应该有且仅有一个引起它变化的原因，否则类应该被拆分</u>

- 5️⃣ 接口隔离原则 ISP，2002 年罗伯特·C.马丁🧑 给“接口隔离原则”的定义是：客户端不应该被迫依赖于它不使用的方法。该原则还有另外一个定义：一个类对另一个类的依赖应该建立在最小的接口上。以上两个定义的含义是：<u>要为各个类建立它们需要的专用接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用</u>。

- 6️⃣ 迪米特法则又叫作最少知识原则 LOD/LKP ，1987 年美国东北大学👨‍🎓（Northeastern University）的一个名为迪米特（Demeter）的研究项目，由伊恩·荷兰（Ian Holland）提出，被 UML 创始人之一布奇（Booch）🧙‍♂️普及，后来又在经典著作《程序员修炼之道》📕中提及，从而传播开来。原则定义：只与你的直接朋友交谈，不跟“陌生人”说话（Talk only to your immediate friends and not to strangers）。其含义是：<u>如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用</u>。其目的是降低类之间的耦合度，提高模块的相对独立性。

- 7️⃣ 合成复用原则 CRP 又叫组合/聚合复用原则，提倡<u>软件复用过程中，优先使用组合复用，其次考虑继承</u>，(如果使用继承，必须遵循里式替换原则)，它与里式替换原则相辅相成。

> 对于原则的定义和约束，在多个设计模式中会有具体体现及说明。



# 🎨 设计模式分类

> 摘自 GOF 设计模式一书中文版译文，可能有内容有出入，还请参考原著辅助阅读。

　　根据模式是用来完成什么工作来划分，这种方式可分为创建型模式、结构型模式和行为型模式 3 种。

>每种类型在对应部分中会再进行着重说明

1. 🏗创建型模式：用于描述“<u>怎样创建对象</u>”，它的主要特点是“<u>将对象的创建与使用分离</u>”。GoF 中提供了单例、原型、工厂方法、抽象工厂、建造者等 5 种创建型模式。
2. 🖇结构型模式：用于描述<u>如何将类或对象按某种布局组成更大的结构</u>，GoF 中提供了代理、适配器、桥接、装饰、外观、享元、组合等 7 种结构型模式。
3. 🎭行为型模式：用于描述<u>类或对象之间怎样相互协作共同完成单个对象无法单独完成的任务，以及怎样分配职责</u>。GoF 中提供了模板方法、策略、命令、职责链、状态、观察者、中介者、迭代器、访问者、备忘录、解释器等 11 种行为型模式。

**在通过表格的形式帮助理解学习和记忆**

<table>
<caption>按照类型划分</caption>
	<tr>
	    <th>类型</th>
	    <th>模式</th>
        <th>类型</th>
        <th>模式</th>
        <th>类型</th>
        <th>模式</th>
	</tr >
	<tr >
	    <td rowspan="5">创建型(5)</td>
	    <td>单例</td>
        <td rowspan="7">结构型(7)</td>
        <td>代理</td>
        <td rowspan="11">行为型(11)</td>
        <td>模板方法</td>
	</tr>
    <tr>
        <td>原型</td>
        <td>适配器</td>
        <td>策略</td>
    </tr>
    <tr>
        <td>建造者</td>
        <td>桥接</td>
        <td>命令</td>
    </tr>
    <tr>
        <td>工厂</td>
        <td>装饰</td>
        <td>职责链</td>
    </tr>
    <tr>
        <td>抽象工厂</td>
        <td>外观/门面</td>
        <td>状态</td>
    </tr>    
    <tr>
        <td></td>        
        <td></td>
        <td>享元</td>
        <td>观察者</td>
    </tr>  
    <tr>
        <td></td>        
        <td></td>
        <td>组合</td>
        <td>中介者</td>
    </tr>    
    <tr>
        <td></td>        
        <td></td>
        <td></td>
        <td></td>
        <td>迭代器</td>
    </tr>    
    <tr>
        <td></td>        
        <td></td>
        <td></td>
        <td></td>
        <td>访问者</td>
    </tr>    
    <tr>
        <td></td>        
        <td></td>
        <td></td>
        <td></td>
        <td>备忘录</td>
    </tr>    
    <tr>
        <td></td>        
        <td></td>
        <td></td>
        <td></td>
        <td>解释器</td>
    </tr>    
</table>


**按照作用来划分**

| 范围\目的 | 创建型模式                             | 结构型模式                                                   | 行为型模式                                                   |
| --------- | -------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 类模式    | 工厂方法                               | (类)适配器                                                   | 模板方法<br />解释器                                         |
| 对象模式  | 单例<br />原型<br />建造<br />抽象工厂 | (对象)适配器<br />外观<br />装饰<br />桥接<br />代理<br />享元<br />组合 | 状态<br />命令<br />责任链<br />策略<br />观察者<br />中介者<br />访问者<br />备忘录<br />迭代器 |

以上我们已经对设计模式有一个比较全面的简单了解了. 那么现在，开始吧！

------


**以下分类中可点击的模式为已完成部分，其他未完成部分正在努力“生产”**

## 🏗 创建型(5)

- [x] [1. 单例（Singleton）模式: 某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。](https://github.com/lvgocc/java-design-patterns/tree/main/singleton)
- [x] [2. 原型（Prototype）模式：将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。](https://github.com/lvgocc/java-design-patterns/tree/main/prototype)
- [x] [3. 工厂（Factory）模式：定义一个用于创建产品的接口，由子类决定生产什么产品。](https://github.com/lvgocc/java-design-patterns/tree/main/factory)
- [x] [4. 抽象工厂（AbstractFactory）模式：提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。](https://github.com/lvgocc/java-design-patterns/tree/main/abstract-factory)
- [x] [5. 建造者（Builder）模式：将一个复杂对象分解成多个相对简单的部分，然后根据不同需要分别创建它们，最后构建成该复杂对象。](https://github.com/lvgocc/java-design-patterns/tree/main/build)


## 🖇 结构型(7)

- [x] [1. 代理（Proxy）模式：为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。](https://github.com/lvgocc/java-design-patterns/tree/main/proxy)
- [x] [2. 适配器（Adapter）模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。](https://github.com/lvgocc/java-design-patterns/tree/main/adapter)
- [x] [3. 桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现的，从而降低了抽象和实现这两个可变维度的耦合度。](https://github.com/lvgocc/java-design-patterns/tree/main/bridge)
- [x] [4. 装饰（Decorator）模式：动态地给对象增加一些职责，即增加其额外的功能。](https://github.com/lvgocc/java-design-patterns/tree/main/decorator)
- [ ] [5. 外观（Facade）模式：为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。](https://github.com/lvgocc/java-design-patterns/tree/main/facade)
- [ ] 6.享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。
- [ ] 7.组合（Composite）模式：将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。

## 🎭 行为型(11)

- [ ] 1.模板方法（Template Method）模式：定义一个操作中的算法骨架，将算法的一些步骤延迟到子类中，使得子类在可以不改变该算法结构的情况下重定义该算法的某些特定步骤。
- [ ] 2.策略（Strategy）模式：定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。
- [ ] 3.命令（Command）模式：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
- [ ] 4.职责链（Chain of Responsibility）模式：把请求从链中的一个对象传到下一个对象，直到请求被响应为止。通过这种方式去除对象之间的耦合。
- [ ] 5.状态（State）模式：允许一个对象在其内部状态发生改变时改变其行为能力。
- [ ] 6.观察者（Observer）模式：多个对象间存在一对多关系，当一个对象发生改变时，把这种改变通知给其他多个对象，从而影响其他对象的行为。
- [ ] 7.中介者（Mediator）模式：定义一个中介对象来简化原有对象之间的交互关系，降低系统中对象间的耦合度，使原有对象之间不必相互了解。
- [ ] 8.迭代器（Iterator）模式：提供一种方法来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。
- [ ] 9.访问者（Visitor）模式：在不改变集合元素的前提下，为一个集合中的每个元素提供多种访问方式，即每个元素有多个访问者对象访问。
- [ ] 10.备忘录（Memento）模式：在不破坏封装性的前提下，获取并保存一个对象的内部状态，以便以后恢复它。
- [ ] 11.解释器（Interpreter）模式：提供如何定义语言的文法，以及对语言句子的解释方法，即解释器。



# 系列专题

　　该设计模式专题将用以记录笔者技术生涯的一次沉淀过程，一共会分为 23 篇文章以及对应的源码内容，文中内容和源码均为自我理解学习沉淀分享，目的与各位一起学习，一起完成心中的梦想。

　　笔者技术水平、理解能力均有限，如有读者发现有歧义甚至错误的地方，希望可以通过评论或私信或邮箱等等让我知道的途径提醒笔者改正。记得点个 star ⭐ 哦 ヾ(≧▽≦*)o [https://github.com/lvgocc/java-design-patterns](https://github.com/lvgocc/java-design-patterns)

----
<div align="center">
    <b>亦或繁星、亦或尘埃。星尘✨，为了梦想，学习技术，不要抱怨、坚持下去💪。</b>
    <p>关注<b style='color:blue'>星尘的一个朋友</b>获取源码、加群一起交流学习🤓。</p>
    <img alt='星尘的一个朋友' src='https://i.loli.net/2020/10/22/7swJfMCPrThebVI.png'/>
</div>


# 参（jù）考（rén）文（jiān）献（bǎng）

　　非常感谢以下平台或书籍或个人的无私贡献知识资源，才能够让我有更多机会去学习了解各类知识。同时在此列出系列文章中的全部出处来源，同时后续在各篇独立文章中如有涉及也会尽可能的列出。排名不分先后。

- [https://bugstack.cn/itstack/itstack-demo-design.html](https://bugstack.cn/itstack/itstack-demo-design.html)

- [http://c.biancheng.net/design_pattern/](http://c.biancheng.net/design_pattern/)

- [https://refactoringguru.cn/design-patterns](https://refactoringguru.cn/design-patterns)

- [https://www.journaldev.com/31902/gangs-of-four-gof-design-patterns](https://www.journaldev.com/31902/gangs-of-four-gof-design-patterns)

- [https://www.runoob.com/design-pattern/design-pattern-tutorial.html](https://www.runoob.com/design-pattern/design-pattern-tutorial.html)

- [可复用面向对象软件的基础](https://book.douban.com/subject/34262305/)

- [大话设计模式](https://book.douban.com/subject/2334288/)

- [设计模式之禅（第2版）](https://book.douban.com/subject/25843319/)

- [人人都懂设计模式：从生活中领悟设计模式：Python实现](https://book.douban.com/subject/33399755/)

- [设计模式（Java版）](https://weread.qq.com/web/reader/8cc327d05a60108cc68d859)
