package event_;

public class event {
    /**
     * java事件处理是采用“委派事件模型”
     * 当事件发生时，产生事件的对象，会把此信息传递给事件的监听者处理
     * 这里的监听者实际上是java.awt.event事件类库里某个类所创建的对象，称为“事件的对象”
     *
     * 事件监听器接口：
     * 当事件源产生一个事件，可以传递给事件监听者处理
     * 事件监听者实际上就是一个类，该类实现了某个事件监听器接口，如前面的MyPanel就是一个类，实现了KeyLisenter接口
     *
     */
}
