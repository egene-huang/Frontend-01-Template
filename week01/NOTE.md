# 每周总结可以写在这里
学习使我快乐。
# 提交测试

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