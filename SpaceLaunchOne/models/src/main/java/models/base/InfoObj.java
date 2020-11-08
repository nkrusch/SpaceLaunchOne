package models.base;

public abstract class InfoObj extends BaseObj {

    @Deprecated
    private String[] infoURLs;
    @Deprecated
    private String wikiURL;
    @Deprecated
    public String[] getInfoURLs() {
        return infoURLs;
    }
    @Deprecated
    public void setInfoURLs(String[] infoURLs) {
        this.infoURLs = infoURLs;
    }
    @Deprecated
    public String getWikiURL() {
        return wikiURL;
    }
    @Deprecated
    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }
}
