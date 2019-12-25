package cn.z.Json;

public class Bookmanage {
    private Integer herepage=1;
    private Integer allpages;
    private Integer pagesize = 4;
    private Integer start=0;//limit的第一个字段

    public Integer getHerepage() {
        return herepage;
    }

    public void setHerepage(Integer herepage) {
        this.herepage = herepage;
    }

    public Integer getAllpages() {
        return allpages;
    }

    public void setAllpages(Integer allpages) {
        this.allpages = allpages;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "bookmanage{" +
                "herepage=" + herepage +
                ", allpages=" + allpages +
                ", pagesize=" + pagesize +
                ", start=" + start +
                '}';
    }
}
