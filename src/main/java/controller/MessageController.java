package controller;

import com.github.pagehelper.Page;
import entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MessageService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yupi Li
 * @Date: Created in 13:56 2018/5/13
 * @Description:
 * @Modified By:
 */
@Controller
@CrossOrigin
public class MessageController {

    @Resource
    private MessageService messageService;

    @RequestMapping("/message/add")
    @ResponseBody
    public Map<String, Object> addMessage(Message message, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (messageService.addMessage(message, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/message/get")
    @ResponseBody
    public Map<String, Object> getMessageByPage(Message message, String token, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Message> messageList = messageService.getMessagesByPage(message, token, page, limit);
            if (messageList != null) {
                long total = ((Page) messageList).getTotal();
                map.put("total", total);
                if (messageList.size() > 0) {
                    map.put("messageList", messageList);
                    map.put("code", 0);
                } else {
                    map.put("code", 4);
                }
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/message/update")
    @ResponseBody
    public Map<String, Object> updateMessage(Message message, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (messageService.updateMessage(message, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }

    @RequestMapping("/message/delete")
    @ResponseBody
    public Map<String, Object> deleteMessage(Integer messageId, String token) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (messageService.deleteMessageById(messageId, token)) {
                map.put("code", 0);
            } else {
                map.put("code", 2);
            }
        } catch (Exception e) {
            map.put("code", 3);
        }
        return map;
    }
}
