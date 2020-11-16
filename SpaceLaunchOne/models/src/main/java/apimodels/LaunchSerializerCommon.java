package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LaunchSerializerCommon {
  
  @SerializedName("id")
  private UUID id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("launch_library_id")
  private String launchLibraryId = null;
  @SerializedName("slug")
  private String slug = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("status")
  private LaunchStatus status = null;
  @SerializedName("net")
  private Date net = null;
  @SerializedName("window_end")
  private Date windowEnd = null;
  @SerializedName("window_start")
  private Date windowStart = null;
  @SerializedName("inhold")
  private Boolean inhold = null;
  @SerializedName("tbdtime")
  private Boolean tbdtime = null;
  @SerializedName("tbddate")
  private Boolean tbddate = null;
  @SerializedName("probability")
  private Integer probability = null;
  @SerializedName("holdreason")
  private String holdreason = null;
  @SerializedName("failreason")
  private String failreason = null;
  @SerializedName("hashtag")
  private String hashtag = null;
  @SerializedName("launch_service_provider")
  private AgencySerializerMini launchServiceProvider = null;
  @SerializedName("rocket")
  private RocketSerializerCommon rocket = null;
  @SerializedName("mission")
  private Mission mission = null;
  @SerializedName("pad")
  private Pad pad = null;
  @SerializedName("infoURLs")
  private String infoURLs = null;
  @SerializedName("vidURLs")
  private String vidURLs = null;
  @SerializedName("webcast_live")
  private Boolean webcastLive = null;
  @SerializedName("image")
  private String image = null;
  @SerializedName("infographic")
  private String infographic = null;
  @SerializedName("program")
  private List<Program> program = null;

  /**
   **/
  @ApiModelProperty()
  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty()
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public String getLaunchLibraryId() {
    return launchLibraryId;
  }
  public void setLaunchLibraryId(String launchLibraryId) {
    this.launchLibraryId = launchLibraryId;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   **/
  @ApiModelProperty()
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty()
  public LaunchStatus getStatus() {
    return status;
  }
  public void setStatus(LaunchStatus status) {
    this.status = status;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getNet() {
    return net;
  }
  public void setNet(Date net) {
    this.net = net;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getWindowEnd() {
    return windowEnd;
  }
  public void setWindowEnd(Date windowEnd) {
    this.windowEnd = windowEnd;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getWindowStart() {
    return windowStart;
  }
  public void setWindowStart(Date windowStart) {
    this.windowStart = windowStart;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getInhold() {
    return inhold;
  }
  public void setInhold(Boolean inhold) {
    this.inhold = inhold;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getTbdtime() {
    return tbdtime;
  }
  public void setTbdtime(Boolean tbdtime) {
    this.tbdtime = tbdtime;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getTbddate() {
    return tbddate;
  }
  public void setTbddate(Boolean tbddate) {
    this.tbddate = tbddate;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getProbability() {
    return probability;
  }
  public void setProbability(Integer probability) {
    this.probability = probability;
  }

  /**
   **/
  @ApiModelProperty()
  public String getHoldreason() {
    return holdreason;
  }
  public void setHoldreason(String holdreason) {
    this.holdreason = holdreason;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFailreason() {
    return failreason;
  }
  public void setFailreason(String failreason) {
    this.failreason = failreason;
  }

  /**
   **/
  @ApiModelProperty()
  public String getHashtag() {
    return hashtag;
  }
  public void setHashtag(String hashtag) {
    this.hashtag = hashtag;
  }

  /**
   **/
  @ApiModelProperty()
  public AgencySerializerMini getLaunchServiceProvider() {
    return launchServiceProvider;
  }
  public void setLaunchServiceProvider(AgencySerializerMini launchServiceProvider) {
    this.launchServiceProvider = launchServiceProvider;
  }

  /**
   **/
  @ApiModelProperty()
  public RocketSerializerCommon getRocket() {
    return rocket;
  }
  public void setRocket(RocketSerializerCommon rocket) {
    this.rocket = rocket;
  }

  /**
   **/
  @ApiModelProperty()
  public Mission getMission() {
    return mission;
  }
  public void setMission(Mission mission) {
    this.mission = mission;
  }

  /**
   **/
  @ApiModelProperty()
  public Pad getPad() {
    return pad;
  }
  public void setPad(Pad pad) {
    this.pad = pad;
  }

  /**
   **/
  @ApiModelProperty()
  public String getInfoURLs() {
    return infoURLs;
  }
  public void setInfoURLs(String infoURLs) {
    this.infoURLs = infoURLs;
  }

  /**
   **/
  @ApiModelProperty()
  public String getVidURLs() {
    return vidURLs;
  }
  public void setVidURLs(String vidURLs) {
    this.vidURLs = vidURLs;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getWebcastLive() {
    return webcastLive;
  }
  public void setWebcastLive(Boolean webcastLive) {
    this.webcastLive = webcastLive;
  }

  /**
   **/
  @ApiModelProperty()
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  /**
   **/
  @ApiModelProperty()
  public String getInfographic() {
    return infographic;
  }
  public void setInfographic(String infographic) {
    this.infographic = infographic;
  }

  /**
   **/
  @ApiModelProperty()
  public List<Program> getProgram() {
    return program;
  }
  public void setProgram(List<Program> program) {
    this.program = program;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LaunchSerializerCommon launchSerializerCommon = (LaunchSerializerCommon) o;
    return (Objects.equals(this.id, launchSerializerCommon.id)) &&
        (Objects.equals(this.url, launchSerializerCommon.url)) &&
        (Objects.equals(this.launchLibraryId, launchSerializerCommon.launchLibraryId)) &&
        (Objects.equals(this.slug, launchSerializerCommon.slug)) &&
        (Objects.equals(this.name, launchSerializerCommon.name)) &&
        (Objects.equals(this.status, launchSerializerCommon.status)) &&
        (Objects.equals(this.net, launchSerializerCommon.net)) &&
        (Objects.equals(this.windowEnd, launchSerializerCommon.windowEnd)) &&
        (Objects.equals(this.windowStart, launchSerializerCommon.windowStart)) &&
        (Objects.equals(this.inhold, launchSerializerCommon.inhold)) &&
        (Objects.equals(this.tbdtime, launchSerializerCommon.tbdtime)) &&
        (Objects.equals(this.tbddate, launchSerializerCommon.tbddate)) &&
        (Objects.equals(this.probability, launchSerializerCommon.probability)) &&
        (Objects.equals(this.holdreason, launchSerializerCommon.holdreason)) &&
        (Objects.equals(this.failreason, launchSerializerCommon.failreason)) &&
        (Objects.equals(this.hashtag, launchSerializerCommon.hashtag)) &&
        (Objects.equals(this.launchServiceProvider, launchSerializerCommon.launchServiceProvider)) &&
        (Objects.equals(this.rocket, launchSerializerCommon.rocket)) &&
        (Objects.equals(this.mission, launchSerializerCommon.mission)) &&
        (Objects.equals(this.pad, launchSerializerCommon.pad)) &&
        (Objects.equals(this.infoURLs, launchSerializerCommon.infoURLs)) &&
        (Objects.equals(this.vidURLs, launchSerializerCommon.vidURLs)) &&
        (Objects.equals(this.webcastLive, launchSerializerCommon.webcastLive)) &&
        (Objects.equals(this.image, launchSerializerCommon.image)) &&
        (Objects.equals(this.infographic, launchSerializerCommon.infographic)) &&
        (Objects.equals(this.program, launchSerializerCommon.program));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.launchLibraryId == null ? 0: this.launchLibraryId.hashCode());
    result = 31 * result + (this.slug == null ? 0: this.slug.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.net == null ? 0: this.net.hashCode());
    result = 31 * result + (this.windowEnd == null ? 0: this.windowEnd.hashCode());
    result = 31 * result + (this.windowStart == null ? 0: this.windowStart.hashCode());
    result = 31 * result + (this.inhold == null ? 0: this.inhold.hashCode());
    result = 31 * result + (this.tbdtime == null ? 0: this.tbdtime.hashCode());
    result = 31 * result + (this.tbddate == null ? 0: this.tbddate.hashCode());
    result = 31 * result + (this.probability == null ? 0: this.probability.hashCode());
    result = 31 * result + (this.holdreason == null ? 0: this.holdreason.hashCode());
    result = 31 * result + (this.failreason == null ? 0: this.failreason.hashCode());
    result = 31 * result + (this.hashtag == null ? 0: this.hashtag.hashCode());
    result = 31 * result + (this.launchServiceProvider == null ? 0: this.launchServiceProvider.hashCode());
    result = 31 * result + (this.rocket == null ? 0: this.rocket.hashCode());
    result = 31 * result + (this.mission == null ? 0: this.mission.hashCode());
    result = 31 * result + (this.pad == null ? 0: this.pad.hashCode());
    result = 31 * result + (this.infoURLs == null ? 0: this.infoURLs.hashCode());
    result = 31 * result + (this.vidURLs == null ? 0: this.vidURLs.hashCode());
    result = 31 * result + (this.webcastLive == null ? 0: this.webcastLive.hashCode());
    result = 31 * result + (this.image == null ? 0: this.image.hashCode());
    result = 31 * result + (this.infographic == null ? 0: this.infographic.hashCode());
    result = 31 * result + (this.program == null ? 0: this.program.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LaunchSerializerCommon {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  launchLibraryId: " + launchLibraryId + "\n" +
            "  slug: " + slug + "\n" +
            "  name: " + name + "\n" +
            "  status: " + status + "\n" +
            "  net: " + net + "\n" +
            "  windowEnd: " + windowEnd + "\n" +
            "  windowStart: " + windowStart + "\n" +
            "  inhold: " + inhold + "\n" +
            "  tbdtime: " + tbdtime + "\n" +
            "  tbddate: " + tbddate + "\n" +
            "  probability: " + probability + "\n" +
            "  holdreason: " + holdreason + "\n" +
            "  failreason: " + failreason + "\n" +
            "  hashtag: " + hashtag + "\n" +
            "  launchServiceProvider: " + launchServiceProvider + "\n" +
            "  rocket: " + rocket + "\n" +
            "  mission: " + mission + "\n" +
            "  pad: " + pad + "\n" +
            "  infoURLs: " + infoURLs + "\n" +
            "  vidURLs: " + vidURLs + "\n" +
            "  webcastLive: " + webcastLive + "\n" +
            "  image: " + image + "\n" +
            "  infographic: " + infographic + "\n" +
            "  program: " + program + "\n" +
            "}\n";
  }
}
