# 每周总结可以写在这里
学习使我快乐。
# 作业完成说明:
1.（选做）自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。
    对应目录: week01/src/main/java/com/geek/
2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。
    对应目录: week01/src/main/java/com/hello/
    `Hello.xlass`是源加密后的`Hello.xlass`是源加密后的文件
3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。
    文件位置: week01/src/JVM内存设置.png


# 学习笔记
操作码: 
iload 将本地变量表指定的int型变量加载到操作栈(栈顶) 入栈一定是在栈顶
iload_x 将本地变量表第一x个int变量加载到操作栈
lload/dload/fload同理  aload是本地引用变量压栈
istore lstore dstore fstore astore 等则是将变量从操作栈弹出并保存在本地变量表中

iconst_x 将int x常量压入操作栈顶

getstatic 访问静态区域

#类加载流程
- 首先去检查是否已经加载过了，已经加载了，则解析或者返回这个class引用
- 没有加载，则去交给附加载器加载(`parent` 组合模式变量), 如果`parent`不存在则交给 `Bootstrap`是一个本地方法
- 如果仍然无法加载则交给`findClass()`进行加载
- 加载失败，则抛出异常 `ClassNotFoundException`