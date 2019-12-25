package cn.z.Json;

public class PageSet {

    private Integer page = 1;
    private Integer start = 0;
    private Integer persize = 5;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.start = (page-1) * this.persize;
        this.page = page;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPersize() {
        return persize;
    }

    public void setPersize(Integer persize) {
        this.persize = persize;
    }

    @Override
    public String toString() {
        return "PageSet{" +
                "page=" + page +
                ", start=" + start +
                ", persize=" + persize +
                '}';
    }
}
