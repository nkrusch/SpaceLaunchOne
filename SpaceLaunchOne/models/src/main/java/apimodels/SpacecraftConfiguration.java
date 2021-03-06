package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftConfiguration {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("agency")
  private Agency agency = null;
  @SerializedName("in_use")
  private Boolean inUse = null;
  @SerializedName("capability")
  private String capability = null;
  @SerializedName("maiden_flight")
  private Date maidenFlight = null;
  @SerializedName("human_rated")
  private Boolean humanRated = null;
  @SerializedName("crew_capacity")
  private Integer crewCapacity = null;
  @SerializedName("image_url")
  private String imageUrl = null;
  @SerializedName("nation_url")
  private String nationUrl = null;
  @SerializedName("wiki_link")
  private String wikiLink = null;
  @SerializedName("info_link")
  private String infoLink = null;

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
  public Agency getAgency() {
    return agency;
  }
  public void setAgency(Agency agency) {
    this.agency = agency;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getInUse() {
    return inUse;
  }
  public void setInUse(Boolean inUse) {
    this.inUse = inUse;
  }

  /**
   **/
  @ApiModelProperty()
  public String getCapability() {
    return capability;
  }
  public void setCapability(String capability) {
    this.capability = capability;
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
   **/
  @ApiModelProperty()
  public Boolean getHumanRated() {
    return humanRated;
  }
  public void setHumanRated(Boolean humanRated) {
    this.humanRated = humanRated;
  }

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getCrewCapacity() {
    return crewCapacity;
  }
  public void setCrewCapacity(Integer crewCapacity) {
    this.crewCapacity = crewCapacity;
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

  /**
   **/
  @ApiModelProperty()
  public String getWikiLink() {
    return wikiLink;
  }
  public void setWikiLink(String wikiLink) {
    this.wikiLink = wikiLink;
  }

  /**
   **/
  @ApiModelProperty()
  public String getInfoLink() {
    return infoLink;
  }
  public void setInfoLink(String infoLink) {
    this.infoLink = infoLink;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftConfiguration spacecraftConfiguration = (SpacecraftConfiguration) o;
    return (Objects.equals(this.id, spacecraftConfiguration.id)) &&
        (Objects.equals(this.url, spacecraftConfiguration.url)) &&
        (Objects.equals(this.name, spacecraftConfiguration.name)) &&
        (Objects.equals(this.agency, spacecraftConfiguration.agency)) &&
        (Objects.equals(this.inUse, spacecraftConfiguration.inUse)) &&
        (Objects.equals(this.capability, spacecraftConfiguration.capability)) &&
        (Objects.equals(this.maidenFlight, spacecraftConfiguration.maidenFlight)) &&
        (Objects.equals(this.humanRated, spacecraftConfiguration.humanRated)) &&
        (Objects.equals(this.crewCapacity, spacecraftConfiguration.crewCapacity)) &&
        (Objects.equals(this.imageUrl, spacecraftConfiguration.imageUrl)) &&
        (Objects.equals(this.nationUrl, spacecraftConfiguration.nationUrl)) &&
        (Objects.equals(this.wikiLink, spacecraftConfiguration.wikiLink)) &&
        (Objects.equals(this.infoLink, spacecraftConfiguration.infoLink));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.agency == null ? 0: this.agency.hashCode());
    result = 31 * result + (this.inUse == null ? 0: this.inUse.hashCode());
    result = 31 * result + (this.capability == null ? 0: this.capability.hashCode());
    result = 31 * result + (this.maidenFlight == null ? 0: this.maidenFlight.hashCode());
    result = 31 * result + (this.humanRated == null ? 0: this.humanRated.hashCode());
    result = 31 * result + (this.crewCapacity == null ? 0: this.crewCapacity.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.nationUrl == null ? 0: this.nationUrl.hashCode());
    result = 31 * result + (this.wikiLink == null ? 0: this.wikiLink.hashCode());
    result = 31 * result + (this.infoLink == null ? 0: this.infoLink.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftConfiguration {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  agency: " + agency + "\n" +
            "  inUse: " + inUse + "\n" +
            "  capability: " + capability + "\n" +
            "  maidenFlight: " + maidenFlight + "\n" +
            "  humanRated: " + humanRated + "\n" +
            "  crewCapacity: " + crewCapacity + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "  nationUrl: " + nationUrl + "\n" +
            "  wikiLink: " + wikiLink + "\n" +
            "  infoLink: " + infoLink + "\n" +
            "}\n";
  }
}
