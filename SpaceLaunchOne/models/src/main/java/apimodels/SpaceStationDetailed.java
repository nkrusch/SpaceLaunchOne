package apimodels;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpaceStationDetailed {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("status")
  private SpaceStationStatus status = null;
  @SerializedName("type")
  private SpaceStationType type = null;
  @SerializedName("founded")
  private Date founded = null;
  @SerializedName("deorbited")
  private Date deorbited = null;
  @SerializedName("height")
  private BigDecimal height = null;
  @SerializedName("width")
  private BigDecimal width = null;
  @SerializedName("mass")
  private BigDecimal mass = null;
  @SerializedName("volume")
  private Integer volume = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("orbit")
  private String orbit = null;
  @SerializedName("onboard_crew")
  private String onboardCrew = null;
  @SerializedName("owners")
  private List<Agency> owners = null;
  @SerializedName("active_expeditions")
  private List<ExpeditionDetailedSerializerForSpacestation> activeExpeditions = null;
  @SerializedName("docking_location")
  private List<DockingLocationSerializerForSpacestation> dockingLocation = null;
  @SerializedName("image_url")
  private String imageUrl = null;

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
  public SpaceStationStatus getStatus() {
    return status;
  }
  public void setStatus(SpaceStationStatus status) {
    this.status = status;
  }

  /**
   **/
  @ApiModelProperty()
  public SpaceStationType getType() {
    return type;
  }
  public void setType(SpaceStationType type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public Date getFounded() {
    return founded;
  }
  public void setFounded(Date founded) {
    this.founded = founded;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getDeorbited() {
    return deorbited;
  }
  public void setDeorbited(Date deorbited) {
    this.deorbited = deorbited;
  }

  /**
   **/
  @ApiModelProperty()
  public BigDecimal getHeight() {
    return height;
  }
  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  /**
   **/
  @ApiModelProperty()
  public BigDecimal getWidth() {
    return width;
  }
  public void setWidth(BigDecimal width) {
    this.width = width;
  }

  /**
   **/
  @ApiModelProperty()
  public BigDecimal getMass() {
    return mass;
  }
  public void setMass(BigDecimal mass) {
    this.mass = mass;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getVolume() {
    return volume;
  }
  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty()
  public String getOrbit() {
    return orbit;
  }
  public void setOrbit(String orbit) {
    this.orbit = orbit;
  }

  /**
   **/
  @ApiModelProperty()
  public String getOnboardCrew() {
    return onboardCrew;
  }
  public void setOnboardCrew(String onboardCrew) {
    this.onboardCrew = onboardCrew;
  }

  /**
   **/
  @ApiModelProperty()
  public List<Agency> getOwners() {
    return owners;
  }
  public void setOwners(List<Agency> owners) {
    this.owners = owners;
  }

  /**
   **/
  @ApiModelProperty()
  public List<ExpeditionDetailedSerializerForSpacestation> getActiveExpeditions() {
    return activeExpeditions;
  }
  public void setActiveExpeditions(List<ExpeditionDetailedSerializerForSpacestation> activeExpeditions) {
    this.activeExpeditions = activeExpeditions;
  }

  /**
   **/
  @ApiModelProperty()
  public List<DockingLocationSerializerForSpacestation> getDockingLocation() {
    return dockingLocation;
  }
  public void setDockingLocation(List<DockingLocationSerializerForSpacestation> dockingLocation) {
    this.dockingLocation = dockingLocation;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpaceStationDetailed spaceStationDetailed = (SpaceStationDetailed) o;
    return (Objects.equals(this.id, spaceStationDetailed.id)) &&
        (Objects.equals(this.url, spaceStationDetailed.url)) &&
        (Objects.equals(this.name, spaceStationDetailed.name)) &&
        (Objects.equals(this.status, spaceStationDetailed.status)) &&
        (Objects.equals(this.type, spaceStationDetailed.type)) &&
        (Objects.equals(this.founded, spaceStationDetailed.founded)) &&
        (Objects.equals(this.deorbited, spaceStationDetailed.deorbited)) &&
        (Objects.equals(this.height, spaceStationDetailed.height)) &&
        (Objects.equals(this.width, spaceStationDetailed.width)) &&
        (Objects.equals(this.mass, spaceStationDetailed.mass)) &&
        (Objects.equals(this.volume, spaceStationDetailed.volume)) &&
        (Objects.equals(this.description, spaceStationDetailed.description)) &&
        (Objects.equals(this.orbit, spaceStationDetailed.orbit)) &&
        (Objects.equals(this.onboardCrew, spaceStationDetailed.onboardCrew)) &&
        (Objects.equals(this.owners, spaceStationDetailed.owners)) &&
        (Objects.equals(this.activeExpeditions, spaceStationDetailed.activeExpeditions)) &&
        (Objects.equals(this.dockingLocation, spaceStationDetailed.dockingLocation)) &&
        (Objects.equals(this.imageUrl, spaceStationDetailed.imageUrl));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.founded == null ? 0: this.founded.hashCode());
    result = 31 * result + (this.deorbited == null ? 0: this.deorbited.hashCode());
    result = 31 * result + (this.height == null ? 0: this.height.hashCode());
    result = 31 * result + (this.width == null ? 0: this.width.hashCode());
    result = 31 * result + (this.mass == null ? 0: this.mass.hashCode());
    result = 31 * result + (this.volume == null ? 0: this.volume.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.orbit == null ? 0: this.orbit.hashCode());
    result = 31 * result + (this.onboardCrew == null ? 0: this.onboardCrew.hashCode());
    result = 31 * result + (this.owners == null ? 0: this.owners.hashCode());
    result = 31 * result + (this.activeExpeditions == null ? 0: this.activeExpeditions.hashCode());
    result = 31 * result + (this.dockingLocation == null ? 0: this.dockingLocation.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpaceStationDetailed {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  status: " + status + "\n" +
            "  type: " + type + "\n" +
            "  founded: " + founded + "\n" +
            "  deorbited: " + deorbited + "\n" +
            "  height: " + height + "\n" +
            "  width: " + width + "\n" +
            "  mass: " + mass + "\n" +
            "  volume: " + volume + "\n" +
            "  description: " + description + "\n" +
            "  orbit: " + orbit + "\n" +
            "  onboardCrew: " + onboardCrew + "\n" +
            "  owners: " + owners + "\n" +
            "  activeExpeditions: " + activeExpeditions + "\n" +
            "  dockingLocation: " + dockingLocation + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "}\n";
  }
}
