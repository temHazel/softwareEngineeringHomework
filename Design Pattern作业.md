# Design Pattern作业

## 实验要求

Funny JSON Explorer（**FJE**），是一个JSON文件可视化的命令行界面小工具，可以快速切换**风格**（style），包括：树形（tree）、矩形（rectangle），也可以指定**图标族**（icon family），为中间节点或叶节点指定一套icon。

## 设计模式

使用**工厂方法**（Factory）、**抽象工厂**（Abstract Factory）、**建造者**（Builder）模式、**组合模式**（Composition），完成功能的同时，使得程序易于扩展和维护。

UML类图如下

![image-20240612212331405](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612212331405.png)

工厂方法

定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类。

![image-20240612213215961](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612213215961.png)

抽象工厂

定义了一个接口用于创建相关或有依赖关系的对象族，而无需明确指定具体类。

![image-20240612213345518](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612213345518.png)

组合模式

将对象组合成树状的层次结构，用来表示“部分-整体”的关系，使用户对单个对象和组合对象具有一致的访问性。

![image-20240612213734072](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612213734072.png)

建造者模式

指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。在FJE中，ContainerFactory作为Builder，ContainerDirector作为Director。

![image-20240612214333449](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612214333449.png)

## 具体实现

添加新的抽象工厂的方法如下

```java
public class AbstractFactory implements ContainerFactory {
    @Override
    public Container createContainer() {
        Component style = createStyle();
        Component icon = createIcon();
        return new Container(style, icon);
    }

    @Override
    public Component createStyle() {
        return new AbstractStyle();
    }

    @Override
    public Component createIcon() {
        return new Icon.DefaultIcon();
    }
}

```

## 实验结果

![image-20240612221247583](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612221247583.png)

![image-20240612222523647](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612222523647.png)

![image-20240612222213647](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612222213647.png)

![image-20240612222334745](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\image-20240612222334745.png)