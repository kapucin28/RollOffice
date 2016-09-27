package table2;

import java.util.GregorianCalendar;

/**
 * Created by TIMBULI REMUS K@puc!n on 07-Jun-16.
 * <p>
 * This class represents performance details that
 * will be inserted in table 2
 */
public class Table2 {

    // Team2 variables--------------------------------------------------------------------------------------------------
    private GregorianCalendar calendar = new GregorianCalendar();
    private String post;
    private long scrap, pending, output, target, month, year;
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public Table2(String post, long scrap, long pending, long output, long target, long month, long year) {
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        this.post = post;
        this.scrap = scrap;
        this.pending = pending;
        this.output = output;
        this.target = target;
        this.month = month;
        this.year = year;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Getters & Setters------------------------------------------------------------------------------------------------
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public long getScrap() {
        return scrap;
    }

    public void setScrap(long scrap) {
        this.scrap = scrap;
    }

    public long getPending() {
        return pending;
    }

    public void setPending(long pending) {
        this.pending = pending;
    }

    public long getOutput() {
        return output;
    }

    public void setOutput(long output) {
        this.output = output;
    }

    public long getTarget() {
        return target;
    }

    public void setTarget(long target) {
        this.target = target;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
    //------------------------------------------------------------------------------------------------------------------
}
