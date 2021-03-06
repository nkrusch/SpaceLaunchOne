package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Pad {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("agency_id")
  private Integer agencyId = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("info_url")
  private String infoUrl = null;
  @SerializedName("wiki_url")
  private String wikiUrl = null;
  @SerializedName("map_url")
  private String mapUrl = null;
  @SerializedName("latitude")
  private String latitude = null;
  @SerializedName("longitude")
  private String longitude = null;
  @SerializedName("location")
  private Location location = null;
  @SerializedName("map_image")
  private String mapImage = null;
  @SerializedName("total_launch_count")
  private String totalLaunchCount = null;

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
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getAgencyId() {
    return agencyId;
  }
  public void setAgencyId(Integer agencyId) {
    this.agencyId = agencyId;
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
  public String getMapUrl() {
    return mapUrl;
  }
  public void setMapUrl(String mapUrl) {
    this.mapUrl = mapUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLatitude() {
    return latitude;
  }
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   **/
  @ApiModelProperty()
  public String getLongitude() {
    return longitude;
  }
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public Location getLocation() {
    return location;
  }
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   **/
  @ApiModelProperty()
  public String getMapImage() {
    return mapImage;
  }
  public void setMapImage(String mapImage) {
    this.mapImage = mapImage;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pad pad = (Pad) o;
    return (Objects.equals(this.id, pad.id)) &&
        (Objects.equals(this.url, pad.url)) &&
        (Objects.equals(this.agencyId, pad.agencyId)) &&
        (Objects.equals(this.name, pad.name)) &&
        (Objects.equals(this.infoUrl, pad.infoUrl)) &&
        (Objects.equals(this.wikiUrl, pad.wikiUrl)) &&
        (Objects.equals(this.mapUrl, pad.mapUrl)) &&
        (Objects.equals(this.latitude, pad.latitude)) &&
        (Objects.equals(this.longitude, pad.longitude)) &&
        (Objects.equals(this.location, pad.location)) &&
        (Objects.equals(this.mapImage, pad.mapImage)) &&
        (Objects.equals(this.totalLaunchCount, pad.totalLaunchCount));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.agencyId == null ? 0: this.agencyId.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.infoUrl == null ? 0: this.infoUrl.hashCode());
    result = 31 * result + (this.wikiUrl == null ? 0: this.wikiUrl.hashCode());
    result = 31 * result + (this.mapUrl == null ? 0: this.mapUrl.hashCode());
    result = 31 * result + (this.latitude == null ? 0: this.latitude.hashCode());
    result = 31 * result + (this.longitude == null ? 0: this.longitude.hashCode());
    result = 31 * result + (this.location == null ? 0: this.location.hashCode());
    result = 31 * result + (this.mapImage == null ? 0: this.mapImage.hashCode());
    result = 31 * result + (this.totalLaunchCount == null ? 0: this.totalLaunchCount.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class Pad {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  agencyId: " + agencyId + "\n" +
            "  name: " + name + "\n" +
            "  infoUrl: " + infoUrl + "\n" +
            "  wikiUrl: " + wikiUrl + "\n" +
            "  mapUrl: " + mapUrl + "\n" +
            "  latitude: " + latitude + "\n" +
            "  longitude: " + longitude + "\n" +
            "  location: " + location + "\n" +
            "  mapImage: " + mapImage + "\n" +
            "  totalLaunchCount: " + totalLaunchCount + "\n" +
            "}\n";
  }
}
