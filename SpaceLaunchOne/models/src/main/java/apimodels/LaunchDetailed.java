package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LaunchDetailed {
  
  @SerializedName("id")
  private UUID id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("launch_library_id")
  private Integer launchLibraryId = null;
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
  private AgencySerializerDetailedCommon launchServiceProvider = null;
  @SerializedName("rocket")
  private RocketDetailed rocket = null;
  @SerializedName("mission")
  private Mission mission = null;
  @SerializedName("pad")
  private Pad pad = null;
  @SerializedName("infoURLs")
  private List<InfoURL> infoURLs = null;
  @SerializedName("vidURLs")
  private List<VidURL> vidURLs = null;
  @SerializedName("webcast_live")
  private Boolean webcastLive = null;
  @SerializedName("image")
  private String image = null;
  @SerializedName("infographic")
  private String infographic = null;
  @SerializedName("program")
  private List<Program> program = null;
  @SerializedName("orbital_launch_attempt_count")
  private String orbitalLaunchAttemptCount = null;
  @SerializedName("location_launch_attempt_count")
  private String locationLaunchAttemptCount = null;
  @SerializedName("pad_launch_attempt_count")
  private String padLaunchAttemptCount = null;
  @SerializedName("agency_launch_attempt_count")
  private String agencyLaunchAttemptCount = null;
  @SerializedName("orbital_launch_attempt_count_year")
  private String orbitalLaunchAttemptCountYear = null;
  @SerializedName("location_launch_attempt_count_year")
  private String locationLaunchAttemptCountYear = null;
  @SerializedName("pad_launch_attempt_count_year")
  private String padLaunchAttemptCountYear = null;
  @SerializedName("agency_launch_attempt_count_year")
  private String agencyLaunchAttemptCountYear = null;

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
  public Integer getLaunchLibraryId() {
    return launchLibraryId;
  }
  public void setLaunchLibraryId(Integer launchLibraryId) {
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
  public AgencySerializerDetailedCommon getLaunchServiceProvider() {
    return launchServiceProvider;
  }
  public void setLaunchServiceProvider(AgencySerializerDetailedCommon launchServiceProvider) {
    this.launchServiceProvider = launchServiceProvider;
  }

  /**
   **/
  @ApiModelProperty()
  public RocketDetailed getRocket() {
    return rocket;
  }
  public void setRocket(RocketDetailed rocket) {
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
  public List<InfoURL> getInfoURLs() {
    return infoURLs;
  }
  public void setInfoURLs(List<InfoURL> infoURLs) {
    this.infoURLs = infoURLs;
  }

  /**
   **/
  @ApiModelProperty()
  public List<VidURL> getVidURLs() {
    return vidURLs;
  }
  public void setVidURLs(List<VidURL> vidURLs) {
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

  /**
   **/
  @ApiModelProperty()
  public String getOrbitalLaunchAttemptCount() {
    return orbitalLaunchAttemptCount;
  }
  public void setOrbitalLaunchAttemptCount(String orbitalLaunchAttemptCount) {
    this.orbitalLaunchAttemptCount = orbitalLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLocationLaunchAttemptCount() {
    return locationLaunchAttemptCount;
  }
  public void setLocationLaunchAttemptCount(String locationLaunchAttemptCount) {
    this.locationLaunchAttemptCount = locationLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty()
  public String getPadLaunchAttemptCount() {
    return padLaunchAttemptCount;
  }
  public void setPadLaunchAttemptCount(String padLaunchAttemptCount) {
    this.padLaunchAttemptCount = padLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty()
  public String getAgencyLaunchAttemptCount() {
    return agencyLaunchAttemptCount;
  }
  public void setAgencyLaunchAttemptCount(String agencyLaunchAttemptCount) {
    this.agencyLaunchAttemptCount = agencyLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty()
  public String getOrbitalLaunchAttemptCountYear() {
    return orbitalLaunchAttemptCountYear;
  }
  public void setOrbitalLaunchAttemptCountYear(String orbitalLaunchAttemptCountYear) {
    this.orbitalLaunchAttemptCountYear = orbitalLaunchAttemptCountYear;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLocationLaunchAttemptCountYear() {
    return locationLaunchAttemptCountYear;
  }
  public void setLocationLaunchAttemptCountYear(String locationLaunchAttemptCountYear) {
    this.locationLaunchAttemptCountYear = locationLaunchAttemptCountYear;
  }

  /**
   **/
  @ApiModelProperty()
  public String getPadLaunchAttemptCountYear() {
    return padLaunchAttemptCountYear;
  }
  public void setPadLaunchAttemptCountYear(String padLaunchAttemptCountYear) {
    this.padLaunchAttemptCountYear = padLaunchAttemptCountYear;
  }

  /**
   **/
  @ApiModelProperty()
  public String getAgencyLaunchAttemptCountYear() {
    return agencyLaunchAttemptCountYear;
  }
  public void setAgencyLaunchAttemptCountYear(String agencyLaunchAttemptCountYear) {
    this.agencyLaunchAttemptCountYear = agencyLaunchAttemptCountYear;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LaunchDetailed launchDetailed = (LaunchDetailed) o;
    return (Objects.equals(this.id, launchDetailed.id)) &&
        (Objects.equals(this.url, launchDetailed.url)) &&
        (Objects.equals(this.launchLibraryId, launchDetailed.launchLibraryId)) &&
        (Objects.equals(this.slug, launchDetailed.slug)) &&
        (Objects.equals(this.name, launchDetailed.name)) &&
        (Objects.equals(this.status, launchDetailed.status)) &&
        (Objects.equals(this.net, launchDetailed.net)) &&
        (Objects.equals(this.windowEnd, launchDetailed.windowEnd)) &&
        (Objects.equals(this.windowStart, launchDetailed.windowStart)) &&
        (Objects.equals(this.inhold, launchDetailed.inhold)) &&
        (Objects.equals(this.tbdtime, launchDetailed.tbdtime)) &&
        (Objects.equals(this.tbddate, launchDetailed.tbddate)) &&
        (Objects.equals(this.probability, launchDetailed.probability)) &&
        (Objects.equals(this.holdreason, launchDetailed.holdreason)) &&
        (Objects.equals(this.failreason, launchDetailed.failreason)) &&
        (Objects.equals(this.hashtag, launchDetailed.hashtag)) &&
        (Objects.equals(this.launchServiceProvider, launchDetailed.launchServiceProvider)) &&
        (Objects.equals(this.rocket, launchDetailed.rocket)) &&
        (Objects.equals(this.mission, launchDetailed.mission)) &&
        (Objects.equals(this.pad, launchDetailed.pad)) &&
        (Objects.equals(this.infoURLs, launchDetailed.infoURLs)) &&
        (Objects.equals(this.vidURLs, launchDetailed.vidURLs)) &&
        (Objects.equals(this.webcastLive, launchDetailed.webcastLive)) &&
        (Objects.equals(this.image, launchDetailed.image)) &&
        (Objects.equals(this.infographic, launchDetailed.infographic)) &&
        (Objects.equals(this.program, launchDetailed.program)) &&
        (Objects.equals(this.orbitalLaunchAttemptCount, launchDetailed.orbitalLaunchAttemptCount)) &&
        (Objects.equals(this.locationLaunchAttemptCount, launchDetailed.locationLaunchAttemptCount)) &&
        (Objects.equals(this.padLaunchAttemptCount, launchDetailed.padLaunchAttemptCount)) &&
        (Objects.equals(this.agencyLaunchAttemptCount, launchDetailed.agencyLaunchAttemptCount)) &&
        (Objects.equals(this.orbitalLaunchAttemptCountYear, launchDetailed.orbitalLaunchAttemptCountYear)) &&
        (Objects.equals(this.locationLaunchAttemptCountYear, launchDetailed.locationLaunchAttemptCountYear)) &&
        (Objects.equals(this.padLaunchAttemptCountYear, launchDetailed.padLaunchAttemptCountYear)) &&
        (Objects.equals(this.agencyLaunchAttemptCountYear, launchDetailed.agencyLaunchAttemptCountYear));
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
    result = 31 * result + (this.orbitalLaunchAttemptCount == null ? 0: this.orbitalLaunchAttemptCount.hashCode());
    result = 31 * result + (this.locationLaunchAttemptCount == null ? 0: this.locationLaunchAttemptCount.hashCode());
    result = 31 * result + (this.padLaunchAttemptCount == null ? 0: this.padLaunchAttemptCount.hashCode());
    result = 31 * result + (this.agencyLaunchAttemptCount == null ? 0: this.agencyLaunchAttemptCount.hashCode());
    result = 31 * result + (this.orbitalLaunchAttemptCountYear == null ? 0: this.orbitalLaunchAttemptCountYear.hashCode());
    result = 31 * result + (this.locationLaunchAttemptCountYear == null ? 0: this.locationLaunchAttemptCountYear.hashCode());
    result = 31 * result + (this.padLaunchAttemptCountYear == null ? 0: this.padLaunchAttemptCountYear.hashCode());
    result = 31 * result + (this.agencyLaunchAttemptCountYear == null ? 0: this.agencyLaunchAttemptCountYear.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LaunchDetailed {\n" +
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
            "  orbitalLaunchAttemptCount: " + orbitalLaunchAttemptCount + "\n" +
            "  locationLaunchAttemptCount: " + locationLaunchAttemptCount + "\n" +
            "  padLaunchAttemptCount: " + padLaunchAttemptCount + "\n" +
            "  agencyLaunchAttemptCount: " + agencyLaunchAttemptCount + "\n" +
            "  orbitalLaunchAttemptCountYear: " + orbitalLaunchAttemptCountYear + "\n" +
            "  locationLaunchAttemptCountYear: " + locationLaunchAttemptCountYear + "\n" +
            "  padLaunchAttemptCountYear: " + padLaunchAttemptCountYear + "\n" +
            "  agencyLaunchAttemptCountYear: " + agencyLaunchAttemptCountYear + "\n" +
            "}\n";
  }
}
