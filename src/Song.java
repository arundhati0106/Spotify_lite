public class Song {
    //song has a name, duration... private as no one else should access it
    private String title;
    private double duration;

    //constructor... alt+insert
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    //getters and setters... alt+insert
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    //print objects of song class, with this statement
    //SOP internally calls toString method, which converts objects to string, and prints it
    //by default, address of objects are printed, thus override
    @Override
    public String toString() {
        return "Song currently playing is "+title+ " of duration "+duration;
    }
}
