package io.github.lvgocc.composite;

import org.junit.jupiter.api.Test;

class ComponentTest {

    @Test
    void composite() {
        Component root = new Composite("计算机");
        Composite c2 = new Composite("编程语言");
        root.add(c2);
        c2.add(new Leaf("Java"));
        c2.add(new Leaf("C++"));
        c2.add(new Leaf("C"));
        root.display(1);
    }

}