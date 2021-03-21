# #GC命令笔记:
### # jstack
用来查看JVM内现在全部线程的状态, 有以下选项
- -F 强制执行`jstack`命令
- -m 混合模式(mixed mode), 将java frame和native frame一起输出
- -l 长列表模式，线程相关的信息，比如锁  持有锁，等待锁等等
#### #命令使用
`jstack -l pid`

```shell
2021-03-21 21:45:39
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.181-b13 mixed mode):

"Attach Listener" #11 daemon prio=9 os_prio=31 tid=0x00007fbfff84e000 nid=0x5703 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Service Thread" #10 daemon prio=9 os_prio=31 tid=0x00007fbffd84b000 nid=0x4503 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C1 CompilerThread3" #9 daemon prio=9 os_prio=31 tid=0x00007fbffe014000 nid=0x4303 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C2 CompilerThread2" #8 daemon prio=9 os_prio=31 tid=0x00007fbffe013000 nid=0x4103 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C2 CompilerThread1" #7 daemon prio=9 os_prio=31 tid=0x00007fbfff80d000 nid=0x4703 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C2 CompilerThread0" #6 daemon prio=9 os_prio=31 tid=0x00007fbffe001000 nid=0x3e03 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Monitor Ctrl-Break" #5 daemon prio=5 os_prio=31 tid=0x00007fbffd0d5000 nid=0x3d03 runnable [0x000070000b248000]
   java.lang.Thread.State: RUNNABLE
	at java.net.SocketInputStream.socketRead0(Native Method)
	at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
	at java.net.SocketInputStream.read(SocketInputStream.java:171)
	at java.net.SocketInputStream.read(SocketInputStream.java:141)
	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
	- locked <0x00000006c0004948> (a java.io.InputStreamReader)
	at java.io.InputStreamReader.read(InputStreamReader.java:184)
	at java.io.BufferedReader.fill(BufferedReader.java:161)
	at java.io.BufferedReader.readLine(BufferedReader.java:324)
	- locked <0x00000006c0004948> (a java.io.InputStreamReader)
	at java.io.BufferedReader.readLine(BufferedReader.java:389)
	at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:47)

   Locked ownable synchronizers:
	- None

"Signal Dispatcher" #4 daemon prio=9 os_prio=31 tid=0x00007fbfff801000 nid=0x490b runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Finalizer" #3 daemon prio=8 os_prio=31 tid=0x00007fbffe007800 nid=0x4e03 in Object.wait() [0x000070000b042000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000006c0008470> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:144)
	- locked <0x00000006c0008470> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:165)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:216)

   Locked ownable synchronizers:
	- None

"Reference Handler" #2 daemon prio=10 os_prio=31 tid=0x00007fbffc81b000 nid=0x3203 in Object.wait() [0x000070000af3f000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000006c000e188> (a java.lang.ref.Reference$Lock)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
	- locked <0x00000006c000e188> (a java.lang.ref.Reference$Lock)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

   Locked ownable synchronizers:
	- None

"main" #1 prio=5 os_prio=31 tid=0x00007fbffc803000 nid=0x2903 runnable [0x000070000a521000]
   java.lang.Thread.State: RUNNABLE
	at java.lang.Object.hashCode(Native Method)
	at java.lang.Object.toString(Object.java:236)
	at com.gc.GcTester.main(GcTester.java:14)

   Locked ownable synchronizers:
	- None

"VM Thread" os_prio=31 tid=0x00007fbffc814800 nid=0x4f03 runnable

"GC task thread#0 (ParallelGC)" os_prio=31 tid=0x00007fbffd004800 nid=0x2207 runnable

"GC task thread#1 (ParallelGC)" os_prio=31 tid=0x00007fbffd005000 nid=0x2103 runnable

"GC task thread#2 (ParallelGC)" os_prio=31 tid=0x00007fbffd005800 nid=0x2a03 runnable

"GC task thread#3 (ParallelGC)" os_prio=31 tid=0x00007fbffd006800 nid=0x5403 runnable

"GC task thread#4 (ParallelGC)" os_prio=31 tid=0x00007fbffd007000 nid=0x5303 runnable

"GC task thread#5 (ParallelGC)" os_prio=31 tid=0x00007fbffd007800 nid=0x5203 runnable

"GC task thread#6 (ParallelGC)" os_prio=31 tid=0x00007fbffd008000 nid=0x2f03 runnable

"GC task thread#7 (ParallelGC)" os_prio=31 tid=0x00007fbffd009000 nid=0x5103 runnable

"VM Periodic Task Thread" os_prio=31 tid=0x00007fbffd84c000 nid=0x5503 waiting on condition

JNI global references: 15
```

linux下可以通过` kill -3 pid`达到以上目的，输出的线程栈信息在该进程所在机器上