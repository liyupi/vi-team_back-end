package service;

import entity.Message;

import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:21 2018/5/14
 * @Description:
 * @Modified By:
 */

public interface MessageService {

    boolean addMessage(Message message, String token);

    List<Message> getMessagesByPage(Message message, String token, int page, int limit);

    boolean updateMessage(Message message, String token);

    boolean deleteMessageById(Integer messageId, String token);
}
