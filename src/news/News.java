package news;

import util.FluxibleList;

// 주가에 영향을 주는 뉴스(추상)
public abstract class News {

    public static FluxibleList newsList = new FluxibleList(100);

    public static void register(News news) {
        newsList.add(news);
    }

    protected String writer;
    protected String title;
    protected String context;
    protected boolean isFavorable; // 뉴스가 호재인 지의 여부

    public News(String writer, String title, String context, boolean isFavorable) {
        this.writer = writer;
        this.title = title;
        this.context = context;
        this.isFavorable = isFavorable;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public boolean isFavorable() {
        return isFavorable;
    }

    public abstract void apply();

}
