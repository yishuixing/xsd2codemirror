#### 根据xml schmea 文件生成 codemirror 需要的tags json对象，解决在线xml编辑根据xsd文件的自动提示功能

有问题或建议提到 [issue](https://github.com/yishuixing/xsd2codemirror/issues)
打包:
```
gradle shadowJar

```
运行:
```
java -Dport=8080 -Dworkdir=" xsd文件所在目录，比如:  d:/xsd"    build\libs\xsd2codemirror-1.0.jar
```