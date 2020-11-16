package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpaceStationSerializerForExpedition {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("status")
  private SpaceStationStatus status = null;
  @SerializedName("orbit")
  private String orbit = null;
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
  public String getOrbit() {
    return orbit;
  }
  public void setOrbit(String orbit) {
    this.orbit = orbit;
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
    SpaceStationSerializerForExpedition spaceStationSerializerForExpedition = (SpaceStationSerializerForExpedition) o;
    return (Objects.equals(this.id, spaceStationSerializerForExpedition.id)) &&
        (Objects.equals(this.url, spaceStationSerializerForExpedition.url)) &&
        (Objects.equals(this.name, spaceStationSerializerForExpedition.name)) &&
        (Objects.equals(this.status, spaceStationSerializerForExpedition.status)) &&
        (Objects.equals(this.orbit, spaceStationSerializerForExpedition.orbit)) &&
        (Objects.equals(this.imageUrl, spaceStationSerializerForExpedition.imageUrl));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.orbit == null ? 0: this.orbit.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpaceStationSerializerForExpedition {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  status: " + status + "\n" +
            "  orbit: " + orbit + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "}\n";
  }
}
