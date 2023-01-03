package pintar.gasper.backend.webApp.service.time;

public class TimeChanger {

    public static String calculateTime(int years, int months, int weeks, int days, int hours, int minutes) {
        String date;
        if (years == 0) {
            if (months == 0) {
                if (weeks == 0) {
                    if (days == 0) {
                        if (hours == 0) {
                            if (minutes == 0) date = "less than a minute";
                            else date = minutes + "min";
                        } else date = hours + "h";
                    } else date = days + "d";
                } else date = weeks + "w";
            } else date = months + "m";
        } else date = years + "y";
        return date + " ago";
    }
}