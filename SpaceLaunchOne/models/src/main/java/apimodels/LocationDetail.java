package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LocationDetail {
  
  @SerializedName("id")
  private Integer id = null;
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
  @SerializedName("pads")
  private List<PadSerializerNoLocation> pads = null;

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

  /**
   **/
  @ApiModelProperty(required = true)
  public List<PadSerializerNoLocation> getPads() {
    return pads;
  }
  public void setPads(List<PadSerializerNoLocation> pads) {
    this.pads = pads;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationDetail locationDetail = (LocationDetail) o;
    return (Objects.equals(this.id, locationDetail.id)) &&
        (Objects.equals(this.name, locationDetail.name)) &&
        (Objects.equals(this.countryCode, locationDetail.countryCode)) &&
        (Objects.equals(this.mapImage, locationDetail.mapImage)) &&
        (Objects.equals(this.totalLaunchCount, locationDetail.totalLaunchCount)) &&
        (Objects.equals(this.totalLandingCount, locationDetail.totalLandingCount)) &&
        (Objects.equals(this.pads, locationDetail.pads));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.countryCode == null ? 0: this.countryCode.hashCode());
    result = 31 * result + (this.mapImage == null ? 0: this.mapImage.hashCode());
    result = 31 * result + (this.totalLaunchCount == null ? 0: this.totalLaunchCount.hashCode());
    result = 31 * result + (this.totalLandingCount == null ? 0: this.totalLandingCount.hashCode());
    result = 31 * result + (this.pads == null ? 0: this.pads.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class LocationDetail {\n" +
            "  id: " + id + "\n" +
            "  name: " + name + "\n" +
            "  countryCode: " + countryCode + "\n" +
            "  mapImage: " + mapImage + "\n" +
            "  totalLaunchCount: " + totalLaunchCount + "\n" +
            "  totalLandingCount: " + totalLandingCount + "\n" +
            "  pads: " + pads + "\n" +
            "}\n";
  }
}
