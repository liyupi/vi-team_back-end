package service;

import com.github.pagehelper.PageHelper;
import entity.Message;
import entity.MessageExample;
import mapper.MessageMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:27 2018/5/14
 * @Description:
 * @Modified By:
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private Jedis jedis;

    @Override
    public boolean addMessage(Message message, String token) {
        if (jedis.exists(token)) {
            message.setSendTime(new Date());
            message.setHasRead(0);
            messageMapper.insert(message);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Message> getMessagesByPage(Message message, String token, int page, int limit) {
        if (jedis.exists(token)) {
            MessageExample messageExample = new MessageExample();
            MessageExample.Criteria criteria = messageExample.createCriteria();
            if (message.getTeamId() != null) {
                criteria.andTeamIdEqualTo(message.getTeamId());
            }
            if (message.getFromUser() != null) {
                criteria.andFromUserEqualTo(message.getFromUser());
            }
            if (message.getToUser() != null) {
                criteria.andToUserEqualTo(message.getToUser());
            }
            if (message.getHasRead() != null) {
                criteria.andHasReadEqualTo(message.getHasRead());
            }
            PageHelper.startPage(page,limit);
            return messageMapper.selectByExample(messageExample);
        } else {
            return null;
        }
    }

    @Override
    public boolean updateMessage(Message message, String token) {
        if (jedis.exists(token)) {
            messageMapper.updateByPrimaryKeySelective(message);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteMessageById(Integer messageId, String token) {
        if (jedis.exists(token)) {
            messageMapper.deleteByPrimaryKey(messageId);
            return true;
        } else {
            return false;
        }
    }
}
