package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AgencySerializerDetailedCommon {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("featured")
  private Boolean featured = null;
  @SerializedName("type")
  private String type = null;
  @SerializedName("country_code")
  private String countryCode = null;
  @SerializedName("abbrev")
  private String abbrev = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("administrator")
  private String administrator = null;
  @SerializedName("founding_year")
  private String foundingYear = null;
  @SerializedName("launchers")
  private String launchers = null;
  @SerializedName("spacecraft")
  private String spacecraft = null;
  @SerializedName("launch_library_url")
  private String launchLibraryUrl = null;
  @SerializedName("total_launch_count")
  private String totalLaunchCount = null;
  @SerializedName("consecutive_successful_launches")
  private String consecutiveSuccessfulLaunches = null;
  @SerializedName("successful_launches")
  private String successfulLaunches = null;
  @SerializedName("failed_launches")
  private String failedLaunches = null;
  @SerializedName("pending_launches")
  private String pendingLaunches = null;
  @SerializedName("consecutive_successful_landings")
  private String consecutiveSuccessfulLandings = null;
  @SerializedName("successful_landings")
  private String successfulLandings = null;
  @SerializedName("failed_landings")
  private String failedLandings = null;
  @SerializedName("attempted_landings")
  private String attemptedLandings = null;
  @SerializedName("info_url")
  private String infoUrl = null;
  @SerializedName("wiki_url")
  private String wikiUrl = null;
  @SerializedName("logo_url")
  private String logoUrl = null;
  @SerializedName("image_url")
  private String imageUrl = null;
  @SerializedName("nation_url")
  private String nationUrl = null;

  /**
   **/
  @ApiModelProperty()
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
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
   **/
  @ApiModelProperty(required = true)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getFeatured() {
    return featured;
  }
  public void setFeatured(Boolean featured) {
    this.featured = featured;
  }

  /**
   **/
  @ApiModelProperty()
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty()
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   **/
  @ApiModelProperty()
  public String getAbbrev() {
    return abbrev;
  }
  public void setAbbrev(String abbrev) {
    this.abbrev = abbrev;
  }

  /**
   **/
  @ApiModelProperty()
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty()
  public String getAdministrator() {
    return administrator;
  }
  public void setAdministrator(String administrator) {
    this.administrator = administrator;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFoundingYear() {
    return foundingYear;
  }
  public void setFoundingYear(String foundingYear) {
    this.foundingYear = foundingYear;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLaunchers() {
    return launchers;
  }
  public void setLaunchers(String launchers) {
    this.launchers = launchers;
  }

  /**
   **/
  @ApiModelProperty()
  public String getSpacecraft() {
    return spacecraft;
  }
  public void setSpacecraft(String spacecraft) {
    this.spacecraft = spacecraft;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLaunchLibraryUrl() {
    return launchLibraryUrl;
  }
  public void setLaunchLibraryUrl(String launchLibraryUrl) {
    this.launchLibraryUrl = launchLibraryUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getTotalLaunchCount() {
    return totalLaunchCount;
  }
  public void setTotalLaunchCount(String totalLaunchCount) {
    this.totalLaunchCount = totalLaunchCount;
  }

  /**
   **/
  @ApiModelProperty()
  public String getConsecutiveSuccessfulLaunches() {
    return consecutiveSuccessfulLaunches;
  }
  public void setConsecutiveSuccessfulLaunches(String consecutiveSuccessfulLaunches) {
    this.consecutiveSuccessfulLaunches = consecutiveSuccessfulLaunches;
  }

  /**
   **/
  @ApiModelProperty()
  public String getSuccessfulLaunches() {
    return successfulLaunches;
  }
  public void setSuccessfulLaunches(String successfulLaunches) {
    this.successfulLaunches = successfulLaunches;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFailedLaunches() {
    return failedLaunches;
  }
  public void setFailedLaunches(String failedLaunches) {
    this.failedLaunches = failedLaunches;
  }

  /**
   **/
  @ApiModelProperty()
  public String getPendingLaunches() {
    return pendingLaunches;
  }
  public void setPendingLaunches(String pendingLaunches) {
    this.pendingLaunches = pendingLaunches;
  }

  /**
   **/
  @ApiModelProperty()
  public String getConsecutiveSuccessfulLandings() {
    return consecutiveSuccessfulLandings;
  }
  public void setConsecutiveSuccessfulLandings(String consecutiveSuccessfulLandings) {
    this.consecutiveSuccessfulLandings = consecutiveSuccessfulLandings;
  }

  /**
   **/
  @ApiModelProperty()
  public String getSuccessfulLandings() {
    return successfulLandings;
  }
  public void setSuccessfulLandings(String successfulLandings) {
    this.successfulLandings = successfulLandings;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFailedLandings() {
    return failedLandings;
  }
  public void setFailedLandings(String failedLandings) {
    this.failedLandings = failedLandings;
  }

  /**
   **/
  @ApiModelProperty()
  public String getAttemptedLandings() {
    return attemptedLandings;
  }
  public void setAttemptedLandings(String attemptedLandings) {
    this.attemptedLandings = attemptedLandings;
  }

  /**
   **/
  @ApiModelProperty()
  public String getInfoUrl() {
    return infoUrl;
  }
  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getWikiUrl() {
    return wikiUrl;
  }
  public void setWikiUrl(String wikiUrl) {
    this.wikiUrl = wikiUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLogoUrl() {
    return logoUrl;
  }
  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getNationUrl() {
    return nationUrl;
  }
  public void setNationUrl(String nationUrl) {
    this.nationUrl = nationUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgencySerializerDetailedCommon agencySerializerDetailedCommon = (AgencySerializerDetailedCommon) o;
    return (Objects.equals(this.id, agencySerializerDetailedCommon.id)) &&
        (Objects.equals(this.url, agencySerializerDetailedCommon.url)) &&
        (Objects.equals(this.name, agencySerializerDetailedCommon.name)) &&
        (Objects.equals(this.featured, agencySerializerDetailedCommon.featured)) &&
        (Objects.equals(this.type, agencySerializerDetailedCommon.type)) &&
        (Objects.equals(this.countryCode, agencySerializerDetailedCommon.countryCode)) &&
        (Objects.equals(this.abbrev, agencySerializerDetailedCommon.abbrev)) &&
        (Objects.equals(this.description, agencySerializerDetailedCommon.description)) &&
        (Objects.equals(this.administrator, agencySerializerDetailedCommon.administrator)) &&
        (Objects.equals(this.foundingYear, agencySerializerDetailedCommon.foundingYear)) &&
        (Objects.equals(this.launchers, agencySerializerDetailedCommon.launchers)) &&
        (Objects.equals(this.spacecraft, agencySerializerDetailedCommon.spacecraft)) &&
        (Objects.equals(this.launchLibraryUrl, agencySerializerDetailedCommon.launchLibraryUrl)) &&
        (Objects.equals(this.totalLaunchCount, agencySerializerDetailedCommon.totalLaunchCount)) &&
        (Objects.equals(this.consecutiveSuccessfulLaunches, agencySerializerDetailedCommon.consecutiveSuccessfulLaunches)) &&
        (Objects.equals(this.successfulLaunches, agencySerializerDetailedCommon.successfulLaunches)) &&
        (Objects.equals(this.failedLaunches, agencySerializerDetailedCommon.failedLaunches)) &&
        (Objects.equals(this.pendingLaunches, agencySerializerDetailedCommon.pendingLaunches)) &&
        (Objects.equals(this.consecutiveSuccessfulLandings, agencySerializerDetailedCommon.consecutiveSuccessfulLandings)) &&
        (Objects.equals(this.successfulLandings, agencySerializerDetailedCommon.successfulLandings)) &&
        (Objects.equals(this.failedLandings, agencySerializerDetailedCommon.failedLandings)) &&
        (Objects.equals(this.attemptedLandings, agencySerializerDetailedCommon.attemptedLandings)) &&
        (Objects.equals(this.infoUrl, agencySerializerDetailedCommon.infoUrl)) &&
        (Objects.equals(this.wikiUrl, agencySerializerDetailedCommon.wikiUrl)) &&
        (Objects.equals(this.logoUrl, agencySerializerDetailedCommon.logoUrl)) &&
        (Objects.equals(this.imageUrl, agencySerializerDetailedCommon.imageUrl)) &&
        (Objects.equals(this.nationUrl, agencySerializerDetailedCommon.nationUrl));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.featured == null ? 0: this.featured.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.countryCode == null ? 0: this.countryCode.hashCode());
    result = 31 * result + (this.abbrev == null ? 0: this.abbrev.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.administrator == null ? 0: this.administrator.hashCode());
    result = 31 * result + (this.foundingYear == null ? 0: this.foundingYear.hashCode());
    result = 31 * result + (this.launchers == null ? 0: this.launchers.hashCode());
    result = 31 * result + (this.spacecraft == null ? 0: this.spacecraft.hashCode());
    result = 31 * result + (this.launchLibraryUrl == null ? 0: this.launchLibraryUrl.hashCode());
    result = 31 * result + (this.totalLaunchCount == null ? 0: this.totalLaunchCount.hashCode());
    result = 31 * result + (this.consecutiveSuccessfulLaunches == null ? 0: this.consecutiveSuccessfulLaunches.hashCode());
    result = 31 * result + (this.successfulLaunches == null ? 0: this.successfulLaunches.hashCode());
    result = 31 * result + (this.failedLaunches == null ? 0: this.failedLaunches.hashCode());
    result = 31 * result + (this.pendingLaunches == null ? 0: this.pendingLaunches.hashCode());
    result = 31 * result + (this.consecutiveSuccessfulLandings == null ? 0: this.consecutiveSuccessfulLandings.hashCode());
    result = 31 * result + (this.successfulLandings == null ? 0: this.successfulLandings.hashCode());
    result = 31 * result + (this.failedLandings == null ? 0: this.failedLandings.hashCode());
    result = 31 * result + (this.attemptedLandings == null ? 0: this.attemptedLandings.hashCode());
    result = 31 * result + (this.infoUrl == null ? 0: this.infoUrl.hashCode());
    result = 31 * result + (this.wikiUrl == null ? 0: this.wikiUrl.hashCode());
    result = 31 * result + (this.logoUrl == null ? 0: this.logoUrl.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.nationUrl == null ? 0: this.nationUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class AgencySerializerDetailedCommon {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  featured: " + featured + "\n" +
            "  type: " + type + "\n" +
            "  countryCode: " + countryCode + "\n" +
            "  abbrev: " + abbrev + "\n" +
            "  description: " + description + "\n" +
            "  administrator: " + administrator + "\n" +
            "  foundingYear: " + foundingYear + "\n" +
            "  launchers: " + launchers + "\n" +
            "  spacecraft: " + spacecraft + "\n" +
            "  launchLibraryUrl: " + launchLibraryUrl + "\n" +
            "  totalLaunchCount: " + totalLaunchCount + "\n" +
            "  consecutiveSuccessfulLaunches: " + consecutiveSuccessfulLaunches + "\n" +
            "  successfulLaunches: " + successfulLaunches + "\n" +
            "  failedLaunches: " + failedLaunches + "\n" +
            "  pendingLaunches: " + pendingLaunches + "\n" +
            "  consecutiveSuccessfulLandings: " + consecutiveSuccessfulLandings + "\n" +
            "  successfulLandings: " + successfulLandings + "\n" +
            "  failedLandings: " + failedLandings + "\n" +
            "  attemptedLandings: " + attemptedLandings + "\n" +
            "  infoUrl: " + infoUrl + "\n" +
            "  wikiUrl: " + wikiUrl + "\n" +
            "  logoUrl: " + logoUrl + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "  nationUrl: " + nationUrl + "\n" +
            "}\n";
  }
}
