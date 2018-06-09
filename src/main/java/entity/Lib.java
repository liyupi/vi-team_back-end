package entity;

import java.io.Serializable;
import java.util.Date;

public class Lib implements Serializable {
    private Integer libId;

    private String libName;

    private String libProfile;

    private Integer teamId;

    private Date createDate;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
        this.libId = libId;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName == null ? null : libName.trim();
    }

    public String getLibProfile() {
        return libProfile;
    }

    public void setLibProfile(String libProfile) {
        this.libProfile = libProfile == null ? null : libProfile.trim();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        Lib other = (Lib) that;
        return (this.getLibId() == null ? other.getLibId() == null : this.getLibId().equals(other.getLibId()))
            && (this.getLibName() == null ? other.getLibName() == null : this.getLibName().equals(other.getLibName()))
            && (this.getLibProfile() == null ? other.getLibProfile() == null : this.getLibProfile().equals(other.getLibProfile()))
            && (this.getTeamId() == null ? other.getTeamId() == null : this.getTeamId().equals(other.getTeamId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLibId() == null) ? 0 : getLibId().hashCode());
        result = prime * result + ((getLibName() == null) ? 0 : getLibName().hashCode());
        result = prime * result + ((getLibProfile() == null) ? 0 : getLibProfile().hashCode());
        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}