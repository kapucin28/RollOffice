package table1;

import java.util.GregorianCalendar;

/**
 * Created by TIMBULI REMUS K@puc!n on 07-Jun-16.
 *
 *     This class represents performance details that
 * will be inserted in table 1
 */
public class Table1 {

    // Team1 variables--------------------------------------------------------------------------------------------------
    private GregorianCalendar calendar = new GregorianCalendar();
    private String post;
    private long scrap, pending, output, target, month, year;
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public Table1(String post, long scrap, long pending, long output, long target, long month, long year) {
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
}
