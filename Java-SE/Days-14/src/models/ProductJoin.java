package models;

public class ProductJoin {

    private Integer pid;
    private String title;
    private Integer price;
    private String cTitle;

    public ProductJoin() {
    }

    public ProductJoin(Integer pid, String title, Integer price, String cTitle) {
        this.pid = pid;
        this.title = title;
        this.price = price;
        this.cTitle = cTitle;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    @Override
    public String toString() {
        return "ProductJoin{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", cTitle='" + cTitle + '\'' +
                '}';
    }

}
