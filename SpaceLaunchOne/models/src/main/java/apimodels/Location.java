package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Location {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("country_code")
  private String countryCode = null;
  @SerializedName("map_image")
  private String mapImage = null;
  @SerializedName("total_launch_count")
  private String totalLaunchCount = null;
  @SerializedName("total_landing_count")
  private String totalLandingCount = null;

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
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
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

  /**
   **/
  @ApiModelProperty()
  public String getTotalLandingCount() {
    return totalLandingCount;
  }
  public void setTotalLandingCount(String totalLandingCount) {
    this.totalLandingCount = totalLandingCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return (Objects.equals(this.id, location.id)) &&
        (Objects.equals(this.url, location.url)) &&
        (Objects.equals(this.name, location.name)) &&
        (Objects.equals(this.countryCode, location.countryCode)) &&
        (Objects.equals(this.mapImage, location.mapImage)) &&
        (Objects.equals(this.totalLaunchCount, location.totalLaunchCount)) &&
        (Objects.equals(this.totalLandingCount, location.totalLandingCount));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.countryCode == null ? 0: this.countryCode.hashCode());
    result = 31 * result + (this.mapImage == null ? 0: this.mapImage.hashCode());
    result = 31 * result + (this.totalLaunchCount == null ? 0: this.totalLaunchCount.hashCode());
    result = 31 * result + (this.totalLandingCount == null ? 0: this.totalLandingCount.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class Location {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  countryCode: " + countryCode + "\n" +
            "  mapImage: " + mapImage + "\n" +
            "  totalLaunchCount: " + totalLaunchCount + "\n" +
            "  totalLandingCount: " + totalLandingCount + "\n" +
            "}\n";
  }
}
