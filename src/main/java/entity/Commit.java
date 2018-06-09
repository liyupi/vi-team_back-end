package entity;

import java.io.Serializable;
import java.util.Date;

public class Commit implements Serializable {
    private Integer commitId;

    private String title;

    private Date commitTime;

    private String committerId;

    private Integer libId;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getCommitId() {
        return commitId;
    }

    public void setCommitId(Integer commitId) {
        this.commitId = commitId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getCommitterId() {
        return committerId;
    }

    public void setCommitterId(String committerId) {
        this.committerId = committerId == null ? null : committerId.trim();
    }

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
        this.libId = libId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Commit other = (Commit) that;
        return (this.getCommitId() == null ? other.getCommitId() == null : this.getCommitId().equals(other.getCommitId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCommitTime() == null ? other.getCommitTime() == null : this.getCommitTime().equals(other.getCommitTime()))
            && (this.getCommitterId() == null ? other.getCommitterId() == null : this.getCommitterId().equals(other.getCommitterId()))
            && (this.getLibId() == null ? other.getLibId() == null : this.getLibId().equals(other.getLibId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommitId() == null) ? 0 : getCommitId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCommitTime() == null) ? 0 : getCommitTime().hashCode());
        result = prime * result + ((getCommitterId() == null) ? 0 : getCommitterId().hashCode());
        result = prime * result + ((getLibId() == null) ? 0 : getLibId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}