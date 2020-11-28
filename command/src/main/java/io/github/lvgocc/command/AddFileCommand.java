package io.github.lvgocc.command;

/**
 * AddFileCommand 新增文件命令
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/28
 */
public class AddFileCommand implements Command {

    private final Receiver receiver;

    public AddFileCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
