1、windows端的netstat的用法

要使用 `netstat`，首先打开命令提示符（CMD）。可以通过按 `Win + R` 键，然后输入 `cmd` 并回车来打开命令提示符窗口。

### 常用选项

以下是一些常用的 `netstat` 选项及其说明：

- **无参数**：

  ```
  netstat
  ```

  显示活动的 TCP 连接列表。

- **-a**：

  ```
  netstat -a
  ```

  显示所有活动的 TCP 连接以及监听 TCP 和 UDP 端口。

- **-b**：

  ```
  netstat -b
  ```

  显示每个连接或监听端口所对应的可执行程序。由于需要额外的权限，可能需要以管理员身份运行 CMD。

- **-n**：

  ```
  netstat -n
  ```

  以数字形式显示地址和端口号，而不是尝试解析主机名和服务名。

- **-o**：

  ```
  netstat -o
  ```

  显示与每个连接相关的进程 ID (PID)。

- **-p 协议**：

  ```
  netstat -p tcp
  ```

  显示特定协议（如 TCP 或 UDP）的连接。可以指定 `tcp`, `udp`, `icmp`, `ip` 或 `all` 来表示所有协议。

- **-r**：

  ```
  netstat -r
  ```

  显示 IP 路由表。

- **-s**：

  ```
  netstat -s
  ```

  按照协议显示统计信息。默认情况下显示 IP、ICMP、TCP 和 UDP 的统计信息。

### 实际应用示例

1. **查看所有活动的 TCP 连接及监听端口**：

   ```
   netstat -an
   ```

2. **查找哪个程序正在使用某个端口**：

   ```
   netstat -ano | findstr :<port_number>
   ```

   例如，查找占用 8080 端口的程序：

   ```
   netstat -ano | findstr :8080
   ```

3. **查看本地路由表**：

   ```
   netstat -r
   ```

4. **每隔一段时间更新一次网络统计信息**：

   ```
   netstat -a 5
   ```

   上面的例子会每 5 秒更新一次显示的信息。

### 注意事项

- 使用 `-b` 参数时，因为涉及到系统级别的操作，可能需要提升权限运行 CMD。
- 在进行网络故障排查时，结合其他工具如 `ping`, `tracert`, `nslookup` 等，能更全面地了解网络状况。

2、windows端如何查找进程ID、进程名的相关信息？如何杀死进程？

### 使用命令行工具

#### 查找进程ID和进程名

1. **使用 `tasklist` 命令**：

   - 打开命令提示符（CMD），可以通过按 `Win + R` 键，然后输入 `cmd` 并回车来打开。

   - 输入以下命令以列出所有正在运行的进程及其PID：

     ```
     tasklist
     ```

   - 如果您想要查找特定进程的信息，可以使用 `findstr` 来过滤结果。例如，要查找名为 `notepad.exe` 的进程：

     ```
     tasklist | findstr notepad
     ```

#### 杀死进程

1. **使用 `taskkill` 命令**：

   - 要根据进程ID（PID）终止一个进程，可以使用如下命令（假设要终止PID为1234的进程）：

     ```
     taskkill /PID 1234 /F
     ```

   - `/F` 参数表示强制终止进程。

   - 若要通过进程名终止进程，可以这样操作（这里以 `notepad.exe` 为例）：

     ```
     taskkill /IM notepad.exe /F
     ```

   - `/IM` 后面跟的是进程名称，`/F` 表示强制终止。

2. **使用 PowerShell 的 `Stop-Process` cmdlet**：

   - 在 PowerShell 中，您可以使用 `Stop-Process` 来终止进程。例如，终止所有名为 `notepad` 的进程：

     ```
     Stop-Process -Name notepad -Force
     ```

   - `-Force` 参数用于强制终止进程。

### 使用任务管理器

除了命令行工具外，Windows 自带的任务管理器也是一个直观的方式来查看和管理进程。