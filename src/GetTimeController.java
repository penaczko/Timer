import java.util.Calendar;
import java.util.GregorianCalendar;

public class GetTimeController {
    public GetTimeController(){}

    public String getTime() {
        GregorianCalendar gregCalendar = new GregorianCalendar();

        String hour = "" + gregCalendar.get(Calendar.HOUR_OF_DAY);
        String minute = "" + gregCalendar.get(Calendar.MINUTE);
        String second = "" + gregCalendar.get(Calendar.SECOND);

        if(Integer.parseInt(hour) < 10) {
            hour = "0" + hour;
        }

        if(Integer.parseInt(minute) < 10) {
            minute = "0" + minute;
        }

        if(Integer.parseInt(second) < 10) {
            second = "0" + second;
        }

        return hour + " : " + minute + " : " + second;
    }
}
