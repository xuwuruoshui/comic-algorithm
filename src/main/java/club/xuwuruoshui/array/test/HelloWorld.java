package club.xuwuruoshui.array.test;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HelloWorld {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = ss.accept();
                // 设置代理服务器与客户端的连接未活动超时时间
                socket.setSoTimeout(1000 * 60);
                String line = "";
                InputStream inputStream = socket.getInputStream();
                String tempHost = "";
                String host = "";
                int port = 80;
                String type = null;
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                int temp = 1;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    System.out.println(line + "------------------------");
                    if (temp == 1) {
                        type = line.split(" ")[0];
                        if (type == null) continue;
                    }
                    temp++;
                    String[] s1 = line.split(": ");
                    if (line.isEmpty()) {
                        break;
                    }
                    for (int i = 0; i < s1.length; i++) {
                        if (s1[i].equalsIgnoreCase("host")) {
                            tempHost = s1[i + 1];
                        }
                    }
                    sb.append(line + "\r\n");
                    line = null;
                }
                sb.append("\r\n");
                if (tempHost.split(":").length > 1) {
                    port = Integer.valueOf(tempHost.split(":")[1]);
                }
                host = tempHost.split(":")[0];
                Socket proxySocket = null;
                if (host != null && !host.equals("")) {
                    proxySocket = new Socket(host, port);
                    proxySocket.setSoTimeout(1000 * 60);
                    OutputStream proxyOs = proxySocket.getOutputStream();
                    InputStream proxyIs = proxySocket.getInputStream();
                    if (type.equalsIgnoreCase("connect")) {
                        outputStream.write("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes());
                        outputStream.flush();
                    } else {
                        proxyOs.write(sb.toString().getBytes(StandardCharsets.UTF_8));
                        proxyOs.flush();
                    }
                    new ProxyHandleThread(inputStream, proxyOs, host).start();
                    new ProxyHandleThread(inputStream, proxyOs, host).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}


class ProxyHandleThread extends Thread {
    private InputStream input;
    private OutputStream output;
    private String host;

    public ProxyHandleThread(InputStream input, OutputStream output, String host) {
        this.input = input;
        this.output = output;
        this.host = host;
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedInputStream bis = new BufferedInputStream(input);
                byte[] bufffer = new byte[1024];
                int length = -1;
                while ((length = bis.read(bufffer)) != -1) {
                    output.write(bufffer, 0, length);
                    length = -1;
                }
                output.flush();

                Thread.sleep(10);
            }
        } catch (IOException e) {
            try {
                input.close();
                output.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}