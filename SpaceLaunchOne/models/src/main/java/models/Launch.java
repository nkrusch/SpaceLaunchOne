package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import models.base.InfoObj;

@SuppressWarnings("SpellCheckingInspection")
public class Launch extends InfoObj {

    private static final String dateFormatPattern = "MMM dd, yyyy HH:mm:ss 'UTC'";
    private static final String chagedFormatPattern = "yyyy-MM-dd HH:mm:ss";

    private String hashtag;
    private String net;
    private int probability;
    private int status;
    private int tbddate;
    private int tbdtime;
    private String windowend;
    private String windowstart;
    private String isostart;
    private String isoend;
    private String isonet;
    private int wsstamp;
    private int westamp;
    private int netstamp;
    private String holdreason;
    private String failreason;
    private String image;
    private String[] vidURLs;
    private Agency lsp = new Agency();
    private Rocket rocket = new Rocket();
    private Mission[] missions = new Mission[]{};
    private Location location = new Location();

    public Launch() {
    }

    public Launch(Launch l) {
        this.setId(l.getId());
        this.setName(l.getName());
        this.rocket = l.getRocket();
    }

    public String[] getVidURLs() {
        return vidURLs;
    }

    public void setVidURLs(String[] vidURLs) {
        this.vidURLs = vidURLs;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getStatusText() {
        switch (status) {
            case 1:
                return "Go";
            case 2:
                return "No-Go";
            case 3:
                return "Success";
            case 4:
                return "Failed";
            case 5:
                return "Hold";
            case 6:
                return "In Flight";
            case 7:
                return "Partial Failure";
            default:
                return "Unknown";
        }
    }

    public String getIsonet() {
        return isonet;
    }

    public void setIsonet(String isonet) {
        this.isonet = isonet;
    }

    public int getWsstamp() {
        return wsstamp;
    }

    public void setWsstamp(int wsstamp) {
        this.wsstamp = wsstamp;
    }

    public int getWestamp() {
        return westamp;
    }

    public void setWestamp(int westamp) {
        this.westamp = westamp;
    }

    public int getNetstamp() {
        return netstamp;
    }

    public void setNetstamp(int netstamp) {
        this.netstamp = netstamp;
    }

    public boolean isOnHold() {
        return getHoldreason() != null && getHoldreason().trim().length() > 0;
    }

    private String getHoldreason() {
        return holdreason;
    }

    public void setHoldreason(String holdreason) {
        this.holdreason = holdreason;
    }

    public String getFailreason() {
        return failreason;
    }

    public void setFailreason(String failreason) {
        this.failreason = failreason;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Mission[] getMissions() {
        return missions;
    }

    public void setMissions(Mission[] missions) {
        this.missions = missions;
    }

    public boolean isProjectedLaunchDate() {
        return tbddate == 1;
    }

    public boolean isProjectedLaunchTime() {
        return tbdtime == 1;
    }

    public boolean isUnknownProbability() {
        return probability == -1;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Agency getLsp() {
        return lsp;
    }

    public void setLsp(Agency lsp) {
        this.lsp = lsp;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTbddate() {
        return tbddate;
    }

    public void setTbddate(int tbddate) {
        this.tbddate = tbddate;
    }

    public int getTbdtime() {
        return tbdtime;
    }

    public void setTbdtime(int tbdtime) {
        this.tbdtime = tbdtime;
    }

    public String getWindowend() {
        return windowend;
    }

    public void setWindowend(String windowend) {
        this.windowend = windowend;
    }

    public String getWindowstart() {
        return windowstart;
    }

    public void setWindowstart(String windowstart) {
        this.windowstart = windowstart;
    }

    public String getIsostart() {
        return isostart;
    }

    public void setIsostart(String isostart) {
        this.isostart = isostart;
    }

    public String getIsoend() {
        return isoend;
    }

    public void setIsoend(String isoend) {
        this.isoend = isoend;
    }

    public Long getLaunchDateUTC() {
        DateFormat format = new SimpleDateFormat(dateFormatPattern, Locale.getDefault());
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return format.parse(this.net).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 2696400000L; // 1-1-1970
    }

    public static Long changeDate(String changed) {
        DateFormat format = new SimpleDateFormat(chagedFormatPattern, Locale.getDefault());
        try {
            return format.parse(changed).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 2696400000L; // 1-1-1970
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static boolean isPlaceholderImage(String img) {
        return img == null || img.indexOf("placeholder_") > 0;
    }

}
