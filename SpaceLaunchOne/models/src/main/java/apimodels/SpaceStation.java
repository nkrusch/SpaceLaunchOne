package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpaceStation {
  
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
  @SerializedName("description")
  private String description = null;
  @SerializedName("orbit")
  private String orbit = null;
  @SerializedName("owners")
  private List<AgencyList> owners = null;
  @SerializedName("active_expedition")
  private List<ExpeditionSerializerForSpacestation> activeExpedition = null;
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
  public List<AgencyList> getOwners() {
    return owners;
  }
  public void setOwners(List<AgencyList> owners) {
    this.owners = owners;
  }

  /**
   **/
  @ApiModelProperty()
  public List<ExpeditionSerializerForSpacestation> getActiveExpedition() {
    return activeExpedition;
  }
  public void setActiveExpedition(List<ExpeditionSerializerForSpacestation> activeExpedition) {
    this.activeExpedition = activeExpedition;
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
    SpaceStation spaceStation = (SpaceStation) o;
    return (Objects.equals(this.id, spaceStation.id)) &&
        (Objects.equals(this.url, spaceStation.url)) &&
        (Objects.equals(this.name, spaceStation.name)) &&
        (Objects.equals(this.status, spaceStation.status)) &&
        (Objects.equals(this.type, spaceStation.type)) &&
        (Objects.equals(this.founded, spaceStation.founded)) &&
        (Objects.equals(this.deorbited, spaceStation.deorbited)) &&
        (Objects.equals(this.description, spaceStation.description)) &&
        (Objects.equals(this.orbit, spaceStation.orbit)) &&
        (Objects.equals(this.owners, spaceStation.owners)) &&
        (Objects.equals(this.activeExpedition, spaceStation.activeExpedition)) &&
        (Objects.equals(this.imageUrl, spaceStation.imageUrl));
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
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.orbit == null ? 0: this.orbit.hashCode());
    result = 31 * result + (this.owners == null ? 0: this.owners.hashCode());
    result = 31 * result + (this.activeExpedition == null ? 0: this.activeExpedition.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpaceStation {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  status: " + status + "\n" +
            "  type: " + type + "\n" +
            "  founded: " + founded + "\n" +
            "  deorbited: " + deorbited + "\n" +
            "  description: " + description + "\n" +
            "  orbit: " + orbit + "\n" +
            "  owners: " + owners + "\n" +
            "  activeExpedition: " + activeExpedition + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "}\n";
  }
}
