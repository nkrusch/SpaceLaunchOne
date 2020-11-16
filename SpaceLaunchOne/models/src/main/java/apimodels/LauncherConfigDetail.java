package apimodels;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LauncherConfigDetail {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("launch_library_id")
  private Integer launchLibraryId = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("family")
  private String family = null;
  @SerializedName("full_name")
  private String fullName = null;
  @SerializedName("manufacturer")
  private AgencySerializerDetailedCommon manufacturer = null;
  @SerializedName("program")
  private List<Program> program = null;
  @SerializedName("variant")
  private String variant = null;
  @SerializedName("alias")
  private String alias = null;
  @SerializedName("min_stage")
  private Integer minStage = null;
  @SerializedName("max_stage")
  private Integer maxStage = null;
  @SerializedName("length")
  private BigDecimal length = null;
  @SerializedName("diameter")
  private BigDecimal diameter = null;
  @SerializedName("maiden_flight")
  private Date maidenFlight = null;
  @SerializedName("launch_mass")
  private Integer launchMass = null;
  @SerializedName("leo_capacity")
  private Integer leoCapacity = null;
  @SerializedName("gto_capacity")
  private Integer gtoCapacity = null;
  @SerializedName("to_thrust")
  private Integer toThrust = null;
  @SerializedName("apogee")
  private Integer apogee = null;
  @SerializedName("vehicle_range")
  private Integer vehicleRange = null;
  @SerializedName("image_url")
  private String imageUrl = null;
  @SerializedName("info_url")
  private String infoUrl = null;
  @SerializedName("wiki_url")
  private String wikiUrl = null;
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
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFamily() {
    return family;
  }
  public void setFamily(String family) {
    this.family = family;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   **/
  @ApiModelProperty()
  public AgencySerializerDetailedCommon getManufacturer() {
    return manufacturer;
  }
  public void setManufacturer(AgencySerializerDetailedCommon manufacturer) {
    this.manufacturer = manufacturer;
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
  public String getVariant() {
    return variant;
  }
  public void setVariant(String variant) {
    this.variant = variant;
  }

  /**
   **/
  @ApiModelProperty()
  public String getAlias() {
    return alias;
  }
  public void setAlias(String alias) {
    this.alias = alias;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getMinStage() {
    return minStage;
  }
  public void setMinStage(Integer minStage) {
    this.minStage = minStage;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getMaxStage() {
    return maxStage;
  }
  public void setMaxStage(Integer maxStage) {
    this.maxStage = maxStage;
  }

  /**
   **/
  @ApiModelProperty()
  public BigDecimal getLength() {
    return length;
  }
  public void setLength(BigDecimal length) {
    this.length = length;
  }

  /**
   **/
  @ApiModelProperty()
  public BigDecimal getDiameter() {
    return diameter;
  }
  public void setDiameter(BigDecimal diameter) {
    this.diameter = diameter;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getMaidenFlight() {
    return maidenFlight;
  }
  public void setMaidenFlight(Date maidenFlight) {
    this.maidenFlight = maidenFlight;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getLaunchMass() {
    return launchMass;
  }
  public void setLaunchMass(Integer launchMass) {
    this.launchMass = launchMass;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getLeoCapacity() {
    return leoCapacity;
  }
  public void setLeoCapacity(Integer leoCapacity) {
    this.leoCapacity = leoCapacity;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getGtoCapacity() {
    return gtoCapacity;
  }
  public void setGtoCapacity(Integer gtoCapacity) {
    this.gtoCapacity = gtoCapacity;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getToThrust() {
    return toThrust;
  }
  public void setToThrust(Integer toThrust) {
    this.toThrust = toThrust;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getApogee() {
    return apogee;
  }
  public void setApogee(Integer apogee) {
    this.apogee = apogee;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getVehicleRange() {
    return vehicleRange;
  }
  public void setVehicleRange(Integer vehicleRange) {
    this.vehicleRange = vehicleRange;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LauncherConfigDetail launcherConfigDetail = (LauncherConfigDetail) o;
    return (Objects.equals(this.id, launcherConfigDetail.id)) &&
        (Objects.equals(this.launchLibraryId, launcherConfigDetail.launchLibraryId)) &&
        (Objects.equals(this.url, launcherConfigDetail.url)) &&
        (Objects.equals(this.name, launcherConfigDetail.name)) &&
        (Objects.equals(this.description, launcherConfigDetail.description)) &&
        (Objects.equals(this.family, launcherConfigDetail.family)) &&
        (Objects.equals(this.fullName, launcherConfigDetail.fullName)) &&
        (Objects.equals(this.manufacturer, launcherConfigDetail.manufacturer)) &&
        (Objects.equals(this.program, launcherConfigDetail.program)) &&
        (Objects.equals(this.variant, launcherConfigDetail.variant)) &&
        (Objects.equals(this.alias, launcherConfigDetail.alias)) &&
        (Objects.equals(this.minStage, launcherConfigDetail.minStage)) &&
        (Objects.equals(this.maxStage, launcherConfigDetail.maxStage)) &&
        (Objects.equals(this.length, launcherConfigDetail.length)) &&
        (Objects.equals(this.diameter, launcherConfigDetail.diameter)) &&
        (Objects.equals(this.maidenFlight, launcherConfigDetail.maidenFlight)) &&
        (Objects.equals(this.launchMass, launcherConfigDetail.launchMass)) &&
        (Objects.equals(this.leoCapacity, launcherConfigDetail.leoCapacity)) &&
        (Objects.equals(this.gtoCapacity, launcherConfigDetail.gtoCapacity)) &&
        (Objects.equals(this.toThrust, launcherConfigDetail.toThrust)) &&
        (Objects.equals(this.apogee, launcherConfigDetail.apogee)) &&
        (Objects.equals(this.vehicleRange, launcherConfigDetail.vehicleRange)) &&
        (Objects.equals(this.imageUrl, launcherConfigDetail.imageUrl)) &&
        (Objects.equals(this.infoUrl, launcherConfigDetail.infoUrl)) &&
        (Objects.equals(this.wikiUrl, launcherConfigDetail.wikiUrl)) &&
        (Objects.equals(this.totalLaunchCount, launcherConfigDetail.totalLaunchCount)) &&
        (Objects.equals(this.consecutiveSuccessfulLaunches, launcherConfigDetail.consecutiveSuccessfulLaunches)) &&
        (Objects.equals(this.successfulLaunches, launcherConfigDetail.successfulLaunches)) &&
        (Objects.equals(this.failedLaunches, launcherConfigDetail.failedLaunches)) &&
        (Objects.equals(this.pendingLaunches, launcherConfigDetail.pendingLaunches));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.launchLibraryId == null ? 0: this.launchLibraryId.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.family == null ? 0: this.family.hashCode());
    result = 31 * result + (this.fullName == null ? 0: this.fullName.hashCode());
    result = 31 * result + (this.manufacturer == null ? 0: this.manufacturer.hashCode());
    result = 31 * result + (this.program == null ? 0: this.program.hashCode());
    result = 31 * result + (this.variant == null ? 0: this.variant.hashCode());
    result = 31 * result + (this.alias == null ? 0: this.alias.hashCode());
    result = 31 * result + (this.minStage == null ? 0: this.minStage.hashCode());
    result = 31 * result + (this.maxStage == null ? 0: this.maxStage.hashCode());
    result = 31 * result + (this.length == null ? 0: this.length.hashCode());
    result = 31 * result + (this.diameter == null ? 0: this.diameter.hashCode());
    result = 31 * result + (this.maidenFlight == null ? 0: this.maidenFlight.hashCode());
    result = 31 * result + (this.launchMass == null ? 0: this.launchMass.hashCode());
    result = 31 * result + (this.leoCapacity == null ? 0: this.leoCapacity.hashCode());
    result = 31 * result + (this.gtoCapacity == null ? 0: this.gtoCapacity.hashCode());
    result = 31 * result + (this.toThrust == null ? 0: this.toThrust.hashCode());
    result = 31 * result + (this.apogee == null ? 0: this.apogee.hashCode());
    result = 31 * result + (this.vehicleRange == null ? 0: this.vehicleRange.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.infoUrl == null ? 0: this.infoUrl.hashCode());
    result = 31 * result + (this.wikiUrl == null ? 0: this.wikiUrl.hashCode());
    result = 31 * result + (this.totalLaunchCount == null ? 0: this.totalLaunchCount.hashCode());
    result = 31 * result + (this.consecutiveSuccessfulLaunches == null ? 0: this.consecutiveSuccessfulLaunches.hashCode());
    result = 31 * result + (this.successfulLaunches == null ? 0: this.successfulLaunches.hashCode());
    result = 31 * result + (this.failedLaunches == null ? 0: this.failedLaunches.hashCode());
    result = 31 * result + (this.pendingLaunches == null ? 0: this.pendingLaunches.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LauncherConfigDetail {\n" +
            "  id: " + id + "\n" +
            "  launchLibraryId: " + launchLibraryId + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  description: " + description + "\n" +
            "  family: " + family + "\n" +
            "  fullName: " + fullName + "\n" +
            "  manufacturer: " + manufacturer + "\n" +
            "  program: " + program + "\n" +
            "  variant: " + variant + "\n" +
            "  alias: " + alias + "\n" +
            "  minStage: " + minStage + "\n" +
            "  maxStage: " + maxStage + "\n" +
            "  length: " + length + "\n" +
            "  diameter: " + diameter + "\n" +
            "  maidenFlight: " + maidenFlight + "\n" +
            "  launchMass: " + launchMass + "\n" +
            "  leoCapacity: " + leoCapacity + "\n" +
            "  gtoCapacity: " + gtoCapacity + "\n" +
            "  toThrust: " + toThrust + "\n" +
            "  apogee: " + apogee + "\n" +
            "  vehicleRange: " + vehicleRange + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "  infoUrl: " + infoUrl + "\n" +
            "  wikiUrl: " + wikiUrl + "\n" +
            "  totalLaunchCount: " + totalLaunchCount + "\n" +
            "  consecutiveSuccessfulLaunches: " + consecutiveSuccessfulLaunches + "\n" +
            "  successfulLaunches: " + successfulLaunches + "\n" +
            "  failedLaunches: " + failedLaunches + "\n" +
            "  pendingLaunches: " + pendingLaunches + "\n" +
            "}\n";
  }
}
