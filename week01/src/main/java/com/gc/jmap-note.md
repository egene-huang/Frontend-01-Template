# #GC命令笔记:
### # jmap
输出堆内存信息, 有以下选项
 - -heap [pid] 打印堆内存配置和使用信息
 - -histo [pid] 查看类占用内存情况
 - -dump:format=b,file=xxx.hprof 将来堆内存信息导出到xxx.hprof文件

`macOS`上这个命令无法使用，不知道是怎么回事, 还会杀死进程