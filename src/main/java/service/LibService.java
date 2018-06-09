package service;

import entity.Lib;

import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:21 2018/5/14
 * @Description:
 * @Modified By:
 */

public interface LibService {

    boolean addLib(Lib lib, String token);

    List<Lib> getLibsByTeamIdByPage(Integer teamId, String token, Integer status, int page, int limit);

    Lib getLibById(Integer libId,String token);

    boolean updateLib(Lib lib, String token);

    boolean deleteLibById(Integer libId, String token);
}
