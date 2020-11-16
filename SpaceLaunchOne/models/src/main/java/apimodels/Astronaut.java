package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Astronaut {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("status")
  private AstronautStatus status = null;
  @SerializedName("agency")
  private AgencySerializerMini agency = null;
  @SerializedName("profile_image")
  private String profileImage = null;
  @SerializedName("profile_image_thumbnail")
  private String profileImageThumbnail = null;

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
  public AstronautStatus getStatus() {
    return status;
  }
  public void setStatus(AstronautStatus status) {
    this.status = status;
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
  public String getProfileImage() {
    return profileImage;
  }
  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }

  /**
   **/
  @ApiModelProperty()
  public String getProfileImageThumbnail() {
    return profileImageThumbnail;
  }
  public void setProfileImageThumbnail(String profileImageThumbnail) {
    this.profileImageThumbnail = profileImageThumbnail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Astronaut astronaut = (Astronaut) o;
    return (Objects.equals(this.id, astronaut.id)) &&
        (Objects.equals(this.url, astronaut.url)) &&
        (Objects.equals(this.name, astronaut.name)) &&
        (Objects.equals(this.status, astronaut.status)) &&
        (Objects.equals(this.agency, astronaut.agency)) &&
        (Objects.equals(this.profileImage, astronaut.profileImage)) &&
        (Objects.equals(this.profileImageThumbnail, astronaut.profileImageThumbnail));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.agency == null ? 0: this.agency.hashCode());
    result = 31 * result + (this.profileImage == null ? 0: this.profileImage.hashCode());
    result = 31 * result + (this.profileImageThumbnail == null ? 0: this.profileImageThumbnail.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class Astronaut {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  status: " + status + "\n" +
            "  agency: " + agency + "\n" +
            "  profileImage: " + profileImage + "\n" +
            "  profileImageThumbnail: " + profileImageThumbnail + "\n" +
            "}\n";
  }
}
