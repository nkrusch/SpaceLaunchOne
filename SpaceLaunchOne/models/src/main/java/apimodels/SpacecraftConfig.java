package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftConfig {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("type")
  private SpacecraftConfigType type = null;
  @SerializedName("agency")
  private AgencySerializerMini agency = null;
  @SerializedName("in_use")
  private Boolean inUse = null;
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
  public SpacecraftConfigType getType() {
    return type;
  }
  public void setType(SpacecraftConfigType type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty()
  public AgencySerializerMini getAgency() {
    return agency;
  }
  public void setAgency(AgencySerializerMini agency) {
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
    SpacecraftConfig spacecraftConfig = (SpacecraftConfig) o;
    return (Objects.equals(this.id, spacecraftConfig.id)) &&
        (Objects.equals(this.url, spacecraftConfig.url)) &&
        (Objects.equals(this.name, spacecraftConfig.name)) &&
        (Objects.equals(this.type, spacecraftConfig.type)) &&
        (Objects.equals(this.agency, spacecraftConfig.agency)) &&
        (Objects.equals(this.inUse, spacecraftConfig.inUse)) &&
        (Objects.equals(this.imageUrl, spacecraftConfig.imageUrl));
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
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftConfig {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  type: " + type + "\n" +
            "  agency: " + agency + "\n" +
            "  inUse: " + inUse + "\n" +
            "  imageUrl: " + imageUrl + "\n" +
            "}\n";
  }
}
