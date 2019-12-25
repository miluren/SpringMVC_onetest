package cn.z.domain;

public class XgAccount {
    private Integer id;
    private  String oldpwd;
    private  String newpwd;
    private  String surepwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getSurepwd() {
        return surepwd;
    }

    public void setSurepwd(String surepwd) {
        this.surepwd = surepwd;
    }

    @Override
    public String toString() {
        return "XgAccount{" +
                "id=" + id +
                ", oldpwd='" + oldpwd + '\'' +
                ", newpwd='" + newpwd + '\'' +
                ", surepwd='" + surepwd + '\'' +
                '}';
    }
}
