package service;

import entity.Commit;

import java.util.List;

/**
 * @Author: Yupi Li
 * @Date: Created in 23:21 2018/5/14
 * @Description:
 * @Modified By:
 */

public interface CommitService {

    boolean addCommit(Commit commit, String token);

    List<Commit> getCommitsByPage(Commit commit, String token, int page, int limit);

    boolean updateCommit(Commit commit, String token);

    boolean deleteCommitById(Integer commitId, String token);

    Commit getCommitById(Integer commitId, String token);
}
