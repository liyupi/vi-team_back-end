package service;

import entity.Team;
import entity.TeamExample;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 13:57 2018/5/13
 * @Description:
 * @Modified By:
 */
public interface TeamService {

    boolean createTeam(Team team, String token);

    List<Team> getCreateTeamByPage(String userId, String token, int page, int limit);

    int updateTeam(Team team, String token);

    String uploadTeamPic(HttpServletRequest request, CommonsMultipartFile file, String token) throws IOException;

    List<Team> getCreateTeamAll(String userId, String token);
}
