package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpaceStationSerializerForDockingEvent {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
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
    SpaceStationSerializerForDockingEvent spaceStationSerializerForDockingEvent = (SpaceStationSerializerForDockingEvent) o;
    return (Objects.equals(this.id, spaceStationSerializerForDockingEvent.id)) &&
        (Objects.equals(this.url, spaceStationSerializerForDockingEvent.url)) &&
        (Objects.equals(this.name, spaceStationSerializerForDockingEvent.name)) &&
        (Objects.equals(this.imageUrl, spaceStationSerializerForDockingEvent.imageUrl));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpaceStationSerializerForDockingEvent {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "}\n";
  }
}
