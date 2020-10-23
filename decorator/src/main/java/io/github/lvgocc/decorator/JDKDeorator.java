package io.github.lvgocc.decorator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 演示 JDK 中用到的 装饰者（套娃）模式
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/23 16:25
 */
public class JDKDeorator {

    public void io() throws FileNotFoundException {
        InputStream in = new DataInputStream(new FileInputStream(new File("filePath")));
    }

    public void collection() {
        List<Object> list = new ArrayList<>();
        list = Collections.synchronizedList(list);
    }
}
