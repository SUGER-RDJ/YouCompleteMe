package ArrayList;

public class News {
    private String titles;
    private String content;

    public News(String titles, String content) {
        this.titles = titles;
        this.content = content;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "titles='" + titles + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
