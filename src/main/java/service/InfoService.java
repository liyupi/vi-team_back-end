package service;

import entity.Info;

import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:21 2018/5/14
 * @Description:
 * @Modified By:
 */

public interface InfoService {

    boolean addInfo(Info info, String token);

    List<Info> getInfosByTeamIdByStatusByPage(Integer teamId,Integer status, String token, int page, int limit);

    boolean updateInfo(Info info, String token);

    boolean deleteInfoById(Integer infoId, String token);

}
