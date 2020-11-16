package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpaceStationSerializerForCommon {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("status")
  private SpaceStationStatus status = null;
  @SerializedName("founded")
  private Date founded = null;
  @SerializedName("description")
  private String description = null;
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
  @ApiModelProperty(required = true)
  public Date getFounded() {
    return founded;
  }
  public void setFounded(Date founded) {
    this.founded = founded;
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
    SpaceStationSerializerForCommon spaceStationSerializerForCommon = (SpaceStationSerializerForCommon) o;
    return (Objects.equals(this.id, spaceStationSerializerForCommon.id)) &&
        (Objects.equals(this.url, spaceStationSerializerForCommon.url)) &&
        (Objects.equals(this.name, spaceStationSerializerForCommon.name)) &&
        (Objects.equals(this.status, spaceStationSerializerForCommon.status)) &&
        (Objects.equals(this.founded, spaceStationSerializerForCommon.founded)) &&
        (Objects.equals(this.description, spaceStationSerializerForCommon.description)) &&
        (Objects.equals(this.orbit, spaceStationSerializerForCommon.orbit)) &&
        (Objects.equals(this.imageUrl, spaceStationSerializerForCommon.imageUrl));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.founded == null ? 0: this.founded.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.orbit == null ? 0: this.orbit.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpaceStationSerializerForCommon {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  status: " + status + "\n" +
            "  founded: " + founded + "\n" +
            "  description: " + description + "\n" +
            "  orbit: " + orbit + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "}\n";
  }
}
