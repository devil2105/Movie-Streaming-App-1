public class Movie {
    private String id;
    private String title;
    private String posterUrl; // Changed from resource ID to URL string
    private int position; // Top 10 position (1-10)

    public Movie(String id, String title, String posterUrl, int position) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.position = position;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getPosterUrl() { return posterUrl; }
    public int getPosition() { return position; }
}