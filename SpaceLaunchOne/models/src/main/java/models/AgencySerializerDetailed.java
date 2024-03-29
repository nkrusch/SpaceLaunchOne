/*
 * Launch Library
 * The Launch Library API is a product by The Space Devs with an up-to-date database of Spaceflight events.   While this API is free to use it is subject to rate limiting for non-authenticated requests.  Please use https://lldev.thespacedevs.com for development testing - this endpoint has stale data but is not subject to any rate limits.  If you are interested in a higher rate limit please consider supporting the project on Patreon for access to an API Key.
 *
 * OpenAPI spec version: 2.2.0
 * Contact: support@thespacedevs.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * AgencySerializerDetailed
 */

public class AgencySerializerDetailed {
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

  @SerializedName("parent")
  private String parent = null;

  @SerializedName("launch_library_url")
  private String launchLibraryUrl = null;

  @SerializedName("total_launch_count")
  private Integer totalLaunchCount = null;

  @SerializedName("successful_launches")
  private Integer successfulLaunches = null;

  @SerializedName("consecutive_successful_launches")
  private Integer consecutiveSuccessfulLaunches = null;

  @SerializedName("failed_launches")
  private Integer failedLaunches = null;

  @SerializedName("pending_launches")
  private Integer pendingLaunches = null;

  @SerializedName("successful_landings")
  private Integer successfulLandings = null;

  @SerializedName("failed_landings")
  private Integer failedLandings = null;

  @SerializedName("attempted_landings")
  private Integer attemptedLandings = null;

  @SerializedName("consecutive_successful_landings")
  private Integer consecutiveSuccessfulLandings = null;

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

  @SerializedName("launcher_list")
  private List<LauncherConfigDetailSerializerForAgency> launcherList = null;

  @SerializedName("spacecraft_list")
  private List<SpacecraftConfigurationDetail> spacecraftList = null;

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public AgencySerializerDetailed name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AgencySerializerDetailed featured(Boolean featured) {
    this.featured = featured;
    return this;
  }

   /**
   * Get featured
   * @return featured
  **/
  @ApiModelProperty(value = "")
  public Boolean isFeatured() {
    return featured;
  }

  public void setFeatured(Boolean featured) {
    this.featured = featured;
  }

  public AgencySerializerDetailed type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AgencySerializerDetailed countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

   /**
   * Get countryCode
   * @return countryCode
  **/
  @ApiModelProperty(value = "")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public AgencySerializerDetailed abbrev(String abbrev) {
    this.abbrev = abbrev;
    return this;
  }

   /**
   * Get abbrev
   * @return abbrev
  **/
  @ApiModelProperty(value = "")
  public String getAbbrev() {
    return abbrev;
  }

  public void setAbbrev(String abbrev) {
    this.abbrev = abbrev;
  }

  public AgencySerializerDetailed description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AgencySerializerDetailed administrator(String administrator) {
    this.administrator = administrator;
    return this;
  }

   /**
   * Get administrator
   * @return administrator
  **/
  @ApiModelProperty(value = "")
  public String getAdministrator() {
    return administrator;
  }

  public void setAdministrator(String administrator) {
    this.administrator = administrator;
  }

  public AgencySerializerDetailed foundingYear(String foundingYear) {
    this.foundingYear = foundingYear;
    return this;
  }

   /**
   * Get foundingYear
   * @return foundingYear
  **/
  @ApiModelProperty(value = "")
  public String getFoundingYear() {
    return foundingYear;
  }

  public void setFoundingYear(String foundingYear) {
    this.foundingYear = foundingYear;
  }

  public AgencySerializerDetailed launchers(String launchers) {
    this.launchers = launchers;
    return this;
  }

   /**
   * Get launchers
   * @return launchers
  **/
  @ApiModelProperty(value = "")
  public String getLaunchers() {
    return launchers;
  }

  public void setLaunchers(String launchers) {
    this.launchers = launchers;
  }

  public AgencySerializerDetailed spacecraft(String spacecraft) {
    this.spacecraft = spacecraft;
    return this;
  }

   /**
   * Get spacecraft
   * @return spacecraft
  **/
  @ApiModelProperty(value = "")
  public String getSpacecraft() {
    return spacecraft;
  }

  public void setSpacecraft(String spacecraft) {
    this.spacecraft = spacecraft;
  }

   /**
   * Get parent
   * @return parent
  **/
  @ApiModelProperty(value = "")
  public String getParent() {
    return parent;
  }

   /**
   * Get launchLibraryUrl
   * @return launchLibraryUrl
  **/
  @ApiModelProperty(value = "")
  public String getLaunchLibraryUrl() {
    return launchLibraryUrl;
  }

   /**
   * Get totalLaunchCount
   * @return totalLaunchCount
  **/
  @ApiModelProperty(value = "")
  public Integer getTotalLaunchCount() {
    return totalLaunchCount;
  }

   /**
   * Get successfulLaunches
   * @return successfulLaunches
  **/
  @ApiModelProperty(value = "")
  public Integer getSuccessfulLaunches() {
    return successfulLaunches;
  }

   /**
   * Get consecutiveSuccessfulLaunches
   * @return consecutiveSuccessfulLaunches
  **/
  @ApiModelProperty(value = "")
  public Integer getConsecutiveSuccessfulLaunches() {
    return consecutiveSuccessfulLaunches;
  }

   /**
   * Get failedLaunches
   * @return failedLaunches
  **/
  @ApiModelProperty(value = "")
  public Integer getFailedLaunches() {
    return failedLaunches;
  }

   /**
   * Get pendingLaunches
   * @return pendingLaunches
  **/
  @ApiModelProperty(value = "")
  public Integer getPendingLaunches() {
    return pendingLaunches;
  }

   /**
   * Get successfulLandings
   * @return successfulLandings
  **/
  @ApiModelProperty(value = "")
  public Integer getSuccessfulLandings() {
    return successfulLandings;
  }

   /**
   * Get failedLandings
   * @return failedLandings
  **/
  @ApiModelProperty(value = "")
  public Integer getFailedLandings() {
    return failedLandings;
  }

   /**
   * Get attemptedLandings
   * @return attemptedLandings
  **/
  @ApiModelProperty(value = "")
  public Integer getAttemptedLandings() {
    return attemptedLandings;
  }

   /**
   * Get consecutiveSuccessfulLandings
   * @return consecutiveSuccessfulLandings
  **/
  @ApiModelProperty(value = "")
  public Integer getConsecutiveSuccessfulLandings() {
    return consecutiveSuccessfulLandings;
  }

  public AgencySerializerDetailed infoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
    return this;
  }

   /**
   * Get infoUrl
   * @return infoUrl
  **/
  @ApiModelProperty(value = "")
  public String getInfoUrl() {
    return infoUrl;
  }

  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }

  public AgencySerializerDetailed wikiUrl(String wikiUrl) {
    this.wikiUrl = wikiUrl;
    return this;
  }

   /**
   * Get wikiUrl
   * @return wikiUrl
  **/
  @ApiModelProperty(value = "")
  public String getWikiUrl() {
    return wikiUrl;
  }

  public void setWikiUrl(String wikiUrl) {
    this.wikiUrl = wikiUrl;
  }

   /**
   * Get logoUrl
   * @return logoUrl
  **/
  @ApiModelProperty(value = "")
  public String getLogoUrl() {
    return logoUrl;
  }

   /**
   * Get imageUrl
   * @return imageUrl
  **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }

   /**
   * Get nationUrl
   * @return nationUrl
  **/
  @ApiModelProperty(value = "")
  public String getNationUrl() {
    return nationUrl;
  }

   /**
   * Get launcherList
   * @return launcherList
  **/
  @ApiModelProperty(value = "")
  public List<LauncherConfigDetailSerializerForAgency> getLauncherList() {
    return launcherList;
  }

   /**
   * Get spacecraftList
   * @return spacecraftList
  **/
  @ApiModelProperty(value = "")
  public List<SpacecraftConfigurationDetail> getSpacecraftList() {
    return spacecraftList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgencySerializerDetailed agencySerializerDetailed = (AgencySerializerDetailed) o;
    return Objects.equals(this.id, agencySerializerDetailed.id) &&
        Objects.equals(this.url, agencySerializerDetailed.url) &&
        Objects.equals(this.name, agencySerializerDetailed.name) &&
        Objects.equals(this.featured, agencySerializerDetailed.featured) &&
        Objects.equals(this.type, agencySerializerDetailed.type) &&
        Objects.equals(this.countryCode, agencySerializerDetailed.countryCode) &&
        Objects.equals(this.abbrev, agencySerializerDetailed.abbrev) &&
        Objects.equals(this.description, agencySerializerDetailed.description) &&
        Objects.equals(this.administrator, agencySerializerDetailed.administrator) &&
        Objects.equals(this.foundingYear, agencySerializerDetailed.foundingYear) &&
        Objects.equals(this.launchers, agencySerializerDetailed.launchers) &&
        Objects.equals(this.spacecraft, agencySerializerDetailed.spacecraft) &&
        Objects.equals(this.parent, agencySerializerDetailed.parent) &&
        Objects.equals(this.launchLibraryUrl, agencySerializerDetailed.launchLibraryUrl) &&
        Objects.equals(this.totalLaunchCount, agencySerializerDetailed.totalLaunchCount) &&
        Objects.equals(this.successfulLaunches, agencySerializerDetailed.successfulLaunches) &&
        Objects.equals(this.consecutiveSuccessfulLaunches, agencySerializerDetailed.consecutiveSuccessfulLaunches) &&
        Objects.equals(this.failedLaunches, agencySerializerDetailed.failedLaunches) &&
        Objects.equals(this.pendingLaunches, agencySerializerDetailed.pendingLaunches) &&
        Objects.equals(this.successfulLandings, agencySerializerDetailed.successfulLandings) &&
        Objects.equals(this.failedLandings, agencySerializerDetailed.failedLandings) &&
        Objects.equals(this.attemptedLandings, agencySerializerDetailed.attemptedLandings) &&
        Objects.equals(this.consecutiveSuccessfulLandings, agencySerializerDetailed.consecutiveSuccessfulLandings) &&
        Objects.equals(this.infoUrl, agencySerializerDetailed.infoUrl) &&
        Objects.equals(this.wikiUrl, agencySerializerDetailed.wikiUrl) &&
        Objects.equals(this.logoUrl, agencySerializerDetailed.logoUrl) &&
        Objects.equals(this.imageUrl, agencySerializerDetailed.imageUrl) &&
        Objects.equals(this.nationUrl, agencySerializerDetailed.nationUrl) &&
        Objects.equals(this.launcherList, agencySerializerDetailed.launcherList) &&
        Objects.equals(this.spacecraftList, agencySerializerDetailed.spacecraftList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, name, featured, type, countryCode, abbrev, description, administrator, foundingYear, launchers, spacecraft, parent, launchLibraryUrl, totalLaunchCount, successfulLaunches, consecutiveSuccessfulLaunches, failedLaunches, pendingLaunches, successfulLandings, failedLandings, attemptedLandings, consecutiveSuccessfulLandings, infoUrl, wikiUrl, logoUrl, imageUrl, nationUrl, launcherList, spacecraftList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgencySerializerDetailed {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    featured: ").append(toIndentedString(featured)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    abbrev: ").append(toIndentedString(abbrev)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    administrator: ").append(toIndentedString(administrator)).append("\n");
    sb.append("    foundingYear: ").append(toIndentedString(foundingYear)).append("\n");
    sb.append("    launchers: ").append(toIndentedString(launchers)).append("\n");
    sb.append("    spacecraft: ").append(toIndentedString(spacecraft)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    launchLibraryUrl: ").append(toIndentedString(launchLibraryUrl)).append("\n");
    sb.append("    totalLaunchCount: ").append(toIndentedString(totalLaunchCount)).append("\n");
    sb.append("    successfulLaunches: ").append(toIndentedString(successfulLaunches)).append("\n");
    sb.append("    consecutiveSuccessfulLaunches: ").append(toIndentedString(consecutiveSuccessfulLaunches)).append("\n");
    sb.append("    failedLaunches: ").append(toIndentedString(failedLaunches)).append("\n");
    sb.append("    pendingLaunches: ").append(toIndentedString(pendingLaunches)).append("\n");
    sb.append("    successfulLandings: ").append(toIndentedString(successfulLandings)).append("\n");
    sb.append("    failedLandings: ").append(toIndentedString(failedLandings)).append("\n");
    sb.append("    attemptedLandings: ").append(toIndentedString(attemptedLandings)).append("\n");
    sb.append("    consecutiveSuccessfulLandings: ").append(toIndentedString(consecutiveSuccessfulLandings)).append("\n");
    sb.append("    infoUrl: ").append(toIndentedString(infoUrl)).append("\n");
    sb.append("    wikiUrl: ").append(toIndentedString(wikiUrl)).append("\n");
    sb.append("    logoUrl: ").append(toIndentedString(logoUrl)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    nationUrl: ").append(toIndentedString(nationUrl)).append("\n");
    sb.append("    launcherList: ").append(toIndentedString(launcherList)).append("\n");
    sb.append("    spacecraftList: ").append(toIndentedString(spacecraftList)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

