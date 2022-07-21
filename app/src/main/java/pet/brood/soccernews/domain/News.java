package pet.brood.soccernews.domain;

public class News {
    private String title;
    private String Description;


    public News(String title, String description) {
        this.title = title;
        Description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
