package polaris.core.handlers;

import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.BotUnmuteEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polaris.core.Set;
import polaris.core.utils.MessageBuilder;

import java.util.Objects;

public class MemberUnmuteEventHandler extends SimpleListenerHost {
    Logger logger = LoggerFactory.getLogger("EventHandler");
    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception){
        exception.printStackTrace();
        // 处理事件处理时抛出的异常
    }


    @NotNull
    @EventHandler
    public ListeningStatus onMessage(@NotNull BotUnmuteEvent event) throws Exception { // 可以抛出任何异常, 将在 handleException 处理
        logger.info("[event]    "+event);
        event.getGroup().sendMessage(Objects.requireNonNull(MessageBuilder.buildMessageChain(Set.CONFIG.BotSet.UnmuteSay, event.getGroup())));
        return ListeningStatus.LISTENING; // 表示继续监听事件

        // return ListeningStatus.STOPPED; // 表示停止监听事件

    }

}
