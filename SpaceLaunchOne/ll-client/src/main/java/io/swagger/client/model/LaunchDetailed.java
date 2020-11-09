/**
 * Launch Library
 * The Launch Library API is a product by The Space Devs with an up-to-date database of Spaceflight events.
 *
 * OpenAPI spec version: v2.0.0
 * Contact: support@thespacedevs.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import io.swagger.client.model.AgencySerializerDetailedCommon;
import io.swagger.client.model.InfoURL;
import io.swagger.client.model.LaunchStatus;
import io.swagger.client.model.Mission;
import io.swagger.client.model.Pad;
import io.swagger.client.model.Program;
import io.swagger.client.model.RocketDetailed;
import io.swagger.client.model.VidURL;
import java.util.*;
import java.util.Date;
import java.util.UUID;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
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
  @ApiModelProperty(value = "")
  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
  public Integer getLaunchLibraryId() {
    return launchLibraryId;
  }
  public void setLaunchLibraryId(Integer launchLibraryId) {
    this.launchLibraryId = launchLibraryId;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public LaunchStatus getStatus() {
    return status;
  }
  public void setStatus(LaunchStatus status) {
    this.status = status;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getNet() {
    return net;
  }
  public void setNet(Date net) {
    this.net = net;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getWindowEnd() {
    return windowEnd;
  }
  public void setWindowEnd(Date windowEnd) {
    this.windowEnd = windowEnd;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getWindowStart() {
    return windowStart;
  }
  public void setWindowStart(Date windowStart) {
    this.windowStart = windowStart;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getInhold() {
    return inhold;
  }
  public void setInhold(Boolean inhold) {
    this.inhold = inhold;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getTbdtime() {
    return tbdtime;
  }
  public void setTbdtime(Boolean tbdtime) {
    this.tbdtime = tbdtime;
  }

  /**
   **/
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
  public Integer getProbability() {
    return probability;
  }
  public void setProbability(Integer probability) {
    this.probability = probability;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getHoldreason() {
    return holdreason;
  }
  public void setHoldreason(String holdreason) {
    this.holdreason = holdreason;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getFailreason() {
    return failreason;
  }
  public void setFailreason(String failreason) {
    this.failreason = failreason;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getHashtag() {
    return hashtag;
  }
  public void setHashtag(String hashtag) {
    this.hashtag = hashtag;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public AgencySerializerDetailedCommon getLaunchServiceProvider() {
    return launchServiceProvider;
  }
  public void setLaunchServiceProvider(AgencySerializerDetailedCommon launchServiceProvider) {
    this.launchServiceProvider = launchServiceProvider;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public RocketDetailed getRocket() {
    return rocket;
  }
  public void setRocket(RocketDetailed rocket) {
    this.rocket = rocket;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Mission getMission() {
    return mission;
  }
  public void setMission(Mission mission) {
    this.mission = mission;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Pad getPad() {
    return pad;
  }
  public void setPad(Pad pad) {
    this.pad = pad;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<InfoURL> getInfoURLs() {
    return infoURLs;
  }
  public void setInfoURLs(List<InfoURL> infoURLs) {
    this.infoURLs = infoURLs;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<VidURL> getVidURLs() {
    return vidURLs;
  }
  public void setVidURLs(List<VidURL> vidURLs) {
    this.vidURLs = vidURLs;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getWebcastLive() {
    return webcastLive;
  }
  public void setWebcastLive(Boolean webcastLive) {
    this.webcastLive = webcastLive;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getInfographic() {
    return infographic;
  }
  public void setInfographic(String infographic) {
    this.infographic = infographic;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<Program> getProgram() {
    return program;
  }
  public void setProgram(List<Program> program) {
    this.program = program;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getOrbitalLaunchAttemptCount() {
    return orbitalLaunchAttemptCount;
  }
  public void setOrbitalLaunchAttemptCount(String orbitalLaunchAttemptCount) {
    this.orbitalLaunchAttemptCount = orbitalLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getLocationLaunchAttemptCount() {
    return locationLaunchAttemptCount;
  }
  public void setLocationLaunchAttemptCount(String locationLaunchAttemptCount) {
    this.locationLaunchAttemptCount = locationLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getPadLaunchAttemptCount() {
    return padLaunchAttemptCount;
  }
  public void setPadLaunchAttemptCount(String padLaunchAttemptCount) {
    this.padLaunchAttemptCount = padLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getAgencyLaunchAttemptCount() {
    return agencyLaunchAttemptCount;
  }
  public void setAgencyLaunchAttemptCount(String agencyLaunchAttemptCount) {
    this.agencyLaunchAttemptCount = agencyLaunchAttemptCount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getOrbitalLaunchAttemptCountYear() {
    return orbitalLaunchAttemptCountYear;
  }
  public void setOrbitalLaunchAttemptCountYear(String orbitalLaunchAttemptCountYear) {
    this.orbitalLaunchAttemptCountYear = orbitalLaunchAttemptCountYear;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getLocationLaunchAttemptCountYear() {
    return locationLaunchAttemptCountYear;
  }
  public void setLocationLaunchAttemptCountYear(String locationLaunchAttemptCountYear) {
    this.locationLaunchAttemptCountYear = locationLaunchAttemptCountYear;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getPadLaunchAttemptCountYear() {
    return padLaunchAttemptCountYear;
  }
  public void setPadLaunchAttemptCountYear(String padLaunchAttemptCountYear) {
    this.padLaunchAttemptCountYear = padLaunchAttemptCountYear;
  }

  /**
   **/
  @ApiModelProperty(value = "")
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
    return (this.id == null ? launchDetailed.id == null : this.id.equals(launchDetailed.id)) &&
        (this.url == null ? launchDetailed.url == null : this.url.equals(launchDetailed.url)) &&
        (this.launchLibraryId == null ? launchDetailed.launchLibraryId == null : this.launchLibraryId.equals(launchDetailed.launchLibraryId)) &&
        (this.slug == null ? launchDetailed.slug == null : this.slug.equals(launchDetailed.slug)) &&
        (this.name == null ? launchDetailed.name == null : this.name.equals(launchDetailed.name)) &&
        (this.status == null ? launchDetailed.status == null : this.status.equals(launchDetailed.status)) &&
        (this.net == null ? launchDetailed.net == null : this.net.equals(launchDetailed.net)) &&
        (this.windowEnd == null ? launchDetailed.windowEnd == null : this.windowEnd.equals(launchDetailed.windowEnd)) &&
        (this.windowStart == null ? launchDetailed.windowStart == null : this.windowStart.equals(launchDetailed.windowStart)) &&
        (this.inhold == null ? launchDetailed.inhold == null : this.inhold.equals(launchDetailed.inhold)) &&
        (this.tbdtime == null ? launchDetailed.tbdtime == null : this.tbdtime.equals(launchDetailed.tbdtime)) &&
        (this.tbddate == null ? launchDetailed.tbddate == null : this.tbddate.equals(launchDetailed.tbddate)) &&
        (this.probability == null ? launchDetailed.probability == null : this.probability.equals(launchDetailed.probability)) &&
        (this.holdreason == null ? launchDetailed.holdreason == null : this.holdreason.equals(launchDetailed.holdreason)) &&
        (this.failreason == null ? launchDetailed.failreason == null : this.failreason.equals(launchDetailed.failreason)) &&
        (this.hashtag == null ? launchDetailed.hashtag == null : this.hashtag.equals(launchDetailed.hashtag)) &&
        (this.launchServiceProvider == null ? launchDetailed.launchServiceProvider == null : this.launchServiceProvider.equals(launchDetailed.launchServiceProvider)) &&
        (this.rocket == null ? launchDetailed.rocket == null : this.rocket.equals(launchDetailed.rocket)) &&
        (this.mission == null ? launchDetailed.mission == null : this.mission.equals(launchDetailed.mission)) &&
        (this.pad == null ? launchDetailed.pad == null : this.pad.equals(launchDetailed.pad)) &&
        (this.infoURLs == null ? launchDetailed.infoURLs == null : this.infoURLs.equals(launchDetailed.infoURLs)) &&
        (this.vidURLs == null ? launchDetailed.vidURLs == null : this.vidURLs.equals(launchDetailed.vidURLs)) &&
        (this.webcastLive == null ? launchDetailed.webcastLive == null : this.webcastLive.equals(launchDetailed.webcastLive)) &&
        (this.image == null ? launchDetailed.image == null : this.image.equals(launchDetailed.image)) &&
        (this.infographic == null ? launchDetailed.infographic == null : this.infographic.equals(launchDetailed.infographic)) &&
        (this.program == null ? launchDetailed.program == null : this.program.equals(launchDetailed.program)) &&
        (this.orbitalLaunchAttemptCount == null ? launchDetailed.orbitalLaunchAttemptCount == null : this.orbitalLaunchAttemptCount.equals(launchDetailed.orbitalLaunchAttemptCount)) &&
        (this.locationLaunchAttemptCount == null ? launchDetailed.locationLaunchAttemptCount == null : this.locationLaunchAttemptCount.equals(launchDetailed.locationLaunchAttemptCount)) &&
        (this.padLaunchAttemptCount == null ? launchDetailed.padLaunchAttemptCount == null : this.padLaunchAttemptCount.equals(launchDetailed.padLaunchAttemptCount)) &&
        (this.agencyLaunchAttemptCount == null ? launchDetailed.agencyLaunchAttemptCount == null : this.agencyLaunchAttemptCount.equals(launchDetailed.agencyLaunchAttemptCount)) &&
        (this.orbitalLaunchAttemptCountYear == null ? launchDetailed.orbitalLaunchAttemptCountYear == null : this.orbitalLaunchAttemptCountYear.equals(launchDetailed.orbitalLaunchAttemptCountYear)) &&
        (this.locationLaunchAttemptCountYear == null ? launchDetailed.locationLaunchAttemptCountYear == null : this.locationLaunchAttemptCountYear.equals(launchDetailed.locationLaunchAttemptCountYear)) &&
        (this.padLaunchAttemptCountYear == null ? launchDetailed.padLaunchAttemptCountYear == null : this.padLaunchAttemptCountYear.equals(launchDetailed.padLaunchAttemptCountYear)) &&
        (this.agencyLaunchAttemptCountYear == null ? launchDetailed.agencyLaunchAttemptCountYear == null : this.agencyLaunchAttemptCountYear.equals(launchDetailed.agencyLaunchAttemptCountYear));
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
    StringBuilder sb = new StringBuilder();
    sb.append("class LaunchDetailed {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  launchLibraryId: ").append(launchLibraryId).append("\n");
    sb.append("  slug: ").append(slug).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  net: ").append(net).append("\n");
    sb.append("  windowEnd: ").append(windowEnd).append("\n");
    sb.append("  windowStart: ").append(windowStart).append("\n");
    sb.append("  inhold: ").append(inhold).append("\n");
    sb.append("  tbdtime: ").append(tbdtime).append("\n");
    sb.append("  tbddate: ").append(tbddate).append("\n");
    sb.append("  probability: ").append(probability).append("\n");
    sb.append("  holdreason: ").append(holdreason).append("\n");
    sb.append("  failreason: ").append(failreason).append("\n");
    sb.append("  hashtag: ").append(hashtag).append("\n");
    sb.append("  launchServiceProvider: ").append(launchServiceProvider).append("\n");
    sb.append("  rocket: ").append(rocket).append("\n");
    sb.append("  mission: ").append(mission).append("\n");
    sb.append("  pad: ").append(pad).append("\n");
    sb.append("  infoURLs: ").append(infoURLs).append("\n");
    sb.append("  vidURLs: ").append(vidURLs).append("\n");
    sb.append("  webcastLive: ").append(webcastLive).append("\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("  infographic: ").append(infographic).append("\n");
    sb.append("  program: ").append(program).append("\n");
    sb.append("  orbitalLaunchAttemptCount: ").append(orbitalLaunchAttemptCount).append("\n");
    sb.append("  locationLaunchAttemptCount: ").append(locationLaunchAttemptCount).append("\n");
    sb.append("  padLaunchAttemptCount: ").append(padLaunchAttemptCount).append("\n");
    sb.append("  agencyLaunchAttemptCount: ").append(agencyLaunchAttemptCount).append("\n");
    sb.append("  orbitalLaunchAttemptCountYear: ").append(orbitalLaunchAttemptCountYear).append("\n");
    sb.append("  locationLaunchAttemptCountYear: ").append(locationLaunchAttemptCountYear).append("\n");
    sb.append("  padLaunchAttemptCountYear: ").append(padLaunchAttemptCountYear).append("\n");
    sb.append("  agencyLaunchAttemptCountYear: ").append(agencyLaunchAttemptCountYear).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
