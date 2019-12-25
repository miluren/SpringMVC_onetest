package cn.z.Json;

public class Select {
    private Integer Herepages = 1;
    private Integer start = 0;
    private Integer pagesize = 5;
    private Integer Allpages;

    public Integer getHerepages() {
        return Herepages;
    }

    public void setHerepages(Integer herepages) {
        Herepages = herepages;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getAllpages() {
        return Allpages;
    }

    public void setAllpages(Integer allpages) {
        Allpages = allpages;
    }

    @Override
    public String toString() {
        return "Select{" +
                "Herepages=" + Herepages +
                ", start=" + start +
                ", pagesize=" + pagesize +
                ", Allpages=" + Allpages +
                '}';
    }
}
