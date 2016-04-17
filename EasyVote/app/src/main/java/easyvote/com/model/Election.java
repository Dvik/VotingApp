package easyvote.com.model;

/**
 * Created by Divya on 4/17/2016.
 */
public class Election {

    public String id;
    public String name;
    public String place;
    public String date;
    public String timings;
    public String positionId;
    public String organiserId;


    public Election(String id,String name, String place, String date,String timings,String positionId,String organiserId)
    {
        this.id = id;
        this.name=name;
        this.place=place;
        this.date=date;
        this.timings=timings;
        this.positionId=positionId;
        this.organiserId=organiserId;
    }
}
