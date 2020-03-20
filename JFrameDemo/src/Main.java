import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // swing推荐写法，将窗口创建添加到事件队列中。这里是使用lambda表达式
        // 对于事件队列，Java会创建一个事件分发线程来处理事件队列中的事件
        // 当GUI程序越来越大以后，事件分发线程能避免错误。
        EventQueue.invokeLater(() -> {
//            AlgoFrame algoFrame = new AlgoFrame("Welcome", 500, 500);
            AlgoFrame algoFrame = new AlgoFrame("Welcome");
        });
    }
}
