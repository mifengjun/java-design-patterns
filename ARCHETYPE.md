lvgocc java design pattern maven archetype description

1. run ``run.bat``

2. 找到新增模块菜单
![](https://i.loli.net/2020/10/18/GW1Qg5UOXoY3Mu6.png)

3. 打开 maven 仓库目录，找到 archetype-catalog.xml
![](https://i.loli.net/2020/10/18/XQTL6IkZNaRtcu8.png)

4. 复制文档内容
![](https://i.loli.net/2020/10/18/vU8CIyZ6dBANaxJ.png)

5. 填写
![](https://i.loli.net/2020/10/18/Skm5hszyRwIK9qr.png)



----

code template

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
 /**
 *
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友 
 * 也可以加我微信（lvgocc）拉你进群
 *
 * @author lvgorice@gmail.com
 * @blog http://lvgo.org
 * @CSDN https://blog.csdn.net/sinat_34344123
 * @version 1.0
 * @date ${DATE}
 */
public class ${NAME} {
}
```