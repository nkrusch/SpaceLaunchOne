package apimodels;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftConfigurationDetail {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("type")
  private SpacecraftConfigType type = null;
  @SerializedName("agency")
  private Agency agency = null;
  @SerializedName("in_use")
  private Boolean inUse = null;
  @SerializedName("capability")
  private String capability = null;
  @SerializedName("history")
  private String history = null;
  @SerializedName("details")
  private String details = null;
  @SerializedName("maiden_flight")
  private Date maidenFlight = null;
  @SerializedName("height")
  private BigDecimal height = null;
  @SerializedName("diameter")
  private BigDecimal diameter = null;
  @SerializedName("human_rated")
  private Boolean humanRated = null;
  @SerializedName("crew_capacity")
  private Integer crewCapacity = null;
  @SerializedName("payload_capacity")
  private Integer payloadCapacity = null;
  @SerializedName("flight_life")
  private String flightLife = null;
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
  public SpacecraftConfigType getType() {
    return type;
  }
  public void setType(SpacecraftConfigType type) {
    this.type = type;
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
  public String getHistory() {
    return history;
  }
  public void setHistory(String history) {
    this.history = history;
  }

  /**
   **/
  @ApiModelProperty()
  public String getDetails() {
    return details;
  }
  public void setDetails(String details) {
    this.details = details;
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
  public BigDecimal getHeight() {
    return height;
  }
  public void setHeight(BigDecimal height) {
    this.height = height;
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
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getPayloadCapacity() {
    return payloadCapacity;
  }
  public void setPayloadCapacity(Integer payloadCapacity) {
    this.payloadCapacity = payloadCapacity;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFlightLife() {
    return flightLife;
  }
  public void setFlightLife(String flightLife) {
    this.flightLife = flightLife;
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
    SpacecraftConfigurationDetail spacecraftConfigurationDetail = (SpacecraftConfigurationDetail) o;
    return (Objects.equals(this.id, spacecraftConfigurationDetail.id)) &&
        (Objects.equals(this.url, spacecraftConfigurationDetail.url)) &&
        (Objects.equals(this.name, spacecraftConfigurationDetail.name)) &&
        (Objects.equals(this.type, spacecraftConfigurationDetail.type)) &&
        (Objects.equals(this.agency, spacecraftConfigurationDetail.agency)) &&
        (Objects.equals(this.inUse, spacecraftConfigurationDetail.inUse)) &&
        (Objects.equals(this.capability, spacecraftConfigurationDetail.capability)) &&
        (Objects.equals(this.history, spacecraftConfigurationDetail.history)) &&
        (Objects.equals(this.details, spacecraftConfigurationDetail.details)) &&
        (Objects.equals(this.maidenFlight, spacecraftConfigurationDetail.maidenFlight)) &&
        (Objects.equals(this.height, spacecraftConfigurationDetail.height)) &&
        (Objects.equals(this.diameter, spacecraftConfigurationDetail.diameter)) &&
        (Objects.equals(this.humanRated, spacecraftConfigurationDetail.humanRated)) &&
        (Objects.equals(this.crewCapacity, spacecraftConfigurationDetail.crewCapacity)) &&
        (Objects.equals(this.payloadCapacity, spacecraftConfigurationDetail.payloadCapacity)) &&
        (Objects.equals(this.flightLife, spacecraftConfigurationDetail.flightLife)) &&
        (Objects.equals(this.imageUrl, spacecraftConfigurationDetail.imageUrl)) &&
        (Objects.equals(this.nationUrl, spacecraftConfigurationDetail.nationUrl)) &&
        (Objects.equals(this.wikiLink, spacecraftConfigurationDetail.wikiLink)) &&
        (Objects.equals(this.infoLink, spacecraftConfigurationDetail.infoLink));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.agency == null ? 0: this.agency.hashCode());
    result = 31 * result + (this.inUse == null ? 0: this.inUse.hashCode());
    result = 31 * result + (this.capability == null ? 0: this.capability.hashCode());
    result = 31 * result + (this.history == null ? 0: this.history.hashCode());
    result = 31 * result + (this.details == null ? 0: this.details.hashCode());
    result = 31 * result + (this.maidenFlight == null ? 0: this.maidenFlight.hashCode());
    result = 31 * result + (this.height == null ? 0: this.height.hashCode());
    result = 31 * result + (this.diameter == null ? 0: this.diameter.hashCode());
    result = 31 * result + (this.humanRated == null ? 0: this.humanRated.hashCode());
    result = 31 * result + (this.crewCapacity == null ? 0: this.crewCapacity.hashCode());
    result = 31 * result + (this.payloadCapacity == null ? 0: this.payloadCapacity.hashCode());
    result = 31 * result + (this.flightLife == null ? 0: this.flightLife.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.nationUrl == null ? 0: this.nationUrl.hashCode());
    result = 31 * result + (this.wikiLink == null ? 0: this.wikiLink.hashCode());
    result = 31 * result + (this.infoLink == null ? 0: this.infoLink.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftConfigurationDetail {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  type: " + type + "\n" +
            "  agency: " + agency + "\n" +
            "  inUse: " + inUse + "\n" +
            "  capability: " + capability + "\n" +
            "  history: " + history + "\n" +
            "  details: " + details + "\n" +
            "  maidenFlight: " + maidenFlight + "\n" +
            "  height: " + height + "\n" +
            "  diameter: " + diameter + "\n" +
            "  humanRated: " + humanRated + "\n" +
            "  crewCapacity: " + crewCapacity + "\n" +
            "  payloadCapacity: " + payloadCapacity + "\n" +
            "  flightLife: " + flightLife + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "  nationUrl: " + nationUrl + "\n" +
            "  wikiLink: " + wikiLink + "\n" +
            "  infoLink: " + infoLink + "\n" +
            "}\n";
  }
}
