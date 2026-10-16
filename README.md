# Project 2 小组合并版

本目录以小组仓库的 `project2` 分支为基础，合入 `../Project2` 中完成的任务二及其表达式语法依赖。原 `../Project2` 目录保持不变。

## 按任务说明改动

| 对应任务 | 文件 | 合并内容 |
| --- | --- | --- |
| 任务一：表达式语法 | `Splc.g4` 的 `expression` | 从个人 Project2 合入完整表达式语法、优先级和结合性 |
| 任务二：constexpr | `src/main/java/ConstExprVisitor.java` | 从个人 Project2 合入完整初始化右值识别、递归求值及结果记录 |
| 任务三：错误报告与恢复 | `Splc.g4` 的 `parameterList`、`Project2ErrorStrategy.java` | 保留小组仓库已有实现，未用个人版覆盖 |
| 验证工具 | `build.ps1`、`tests/test_task2.py` | 合入 Windows 构建脚本和任务二测试；本目录脚本默认运行全部公开样例 |

Visitor 仅记录局部变量的完整 constexpr 初始化表达式。支持整数、括号、一元正负、加减乘除和取模；其余表达式返回非 constexpr，不单独记录子表达式，也不记录普通赋值、return 或条件表达式。文本从 Parse Tree 获取，输出使用框架原有逻辑。

课程框架、Makefile、Lexer、公开测试、小组 VS Code 配置和已有 ANTLR JAR 均保留。

## Windows 验证

需要 PowerShell 7 和 JDK 17，`java`、`javac`、`jar` 应在 PATH 中。仓库已提供 ANTLR 4.13.2。

```powershell
./build.ps1 build
./build.ps1 test
python tests/test_task2.py
'int main() { int a = 1+2*3; return a; }' | ./build.ps1 run
```

合并验证：生成 Parser/Visitor、编译和打包成功；全部公开样例 7/7 通过，额外任务二测试 5/5 组通过。未验证 OJ 隐藏测试。

## 任务三的后续检查

现有缺逗号错误产生式只匹配 `parameter parameter`，且在第二个参数消费完后才获取行号。建议任务三负责人继续核对多参数与跨行场景；本次合并没有改动该逻辑。公开样例通过不代表这些边界情况已经验证。

## 最终提交

原 Makefile 保持不变。在具备 GNU make 和 POSIX shell 的环境中，可按课程要求执行 `make test`、`make handin`。最终 ZIP 根目录应包含 `Splc.g4`、`ConstExprVisitor.java`、`Project2ErrorStrategy.java`。本次仅合并和本地验证，未提交 Git commit、推送 GitHub 或上传 OJ。
