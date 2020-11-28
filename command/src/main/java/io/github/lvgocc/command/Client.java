package io.github.lvgocc.command;

/**
 * Client 命令模式通用客户端
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/28
 */
public class Client {
    public static void main(String[] args) {
        FileReceiver fileReceiver = new FileReceiver();
        AddFileCommand addFileCommand = new AddFileCommand(fileReceiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(addFileCommand);
        invoker.executeCommand();
    }
}
