package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AstronautNormal {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("status")
  private AstronautStatus status = null;
  @SerializedName("type")
  private AstronautType type = null;
  @SerializedName("date_of_birth")
  private Date dateOfBirth = null;
  @SerializedName("date_of_death")
  private Date dateOfDeath = null;
  @SerializedName("nationality")
  private String nationality = null;
  @SerializedName("bio")
  private String bio = null;
  @SerializedName("twitter")
  private String twitter = null;
  @SerializedName("instagram")
  private String instagram = null;
  @SerializedName("wiki")
  private String wiki = null;
  @SerializedName("agency")
  private Agency agency = null;
  @SerializedName("profile_image")
  private String profileImage = null;
  @SerializedName("profile_image_thumbnail")
  private String profileImageThumbnail = null;
  @SerializedName("last_flight")
  private String lastFlight = null;
  @SerializedName("first_flight")
  private String firstFlight = null;

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
  public AstronautType getType() {
    return type;
  }
  public void setType(AstronautType type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public Date getDateOfBirth() {
    return dateOfBirth;
  }
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getDateOfDeath() {
    return dateOfDeath;
  }
  public void setDateOfDeath(Date dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getNationality() {
    return nationality;
  }
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getBio() {
    return bio;
  }
  public void setBio(String bio) {
    this.bio = bio;
  }

  /**
   **/
  @ApiModelProperty()
  public String getTwitter() {
    return twitter;
  }
  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  /**
   **/
  @ApiModelProperty()
  public String getInstagram() {
    return instagram;
  }
  public void setInstagram(String instagram) {
    this.instagram = instagram;
  }

  /**
   **/
  @ApiModelProperty()
  public String getWiki() {
    return wiki;
  }
  public void setWiki(String wiki) {
    this.wiki = wiki;
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

  /**
   **/
  @ApiModelProperty()
  public String getLastFlight() {
    return lastFlight;
  }
  public void setLastFlight(String lastFlight) {
    this.lastFlight = lastFlight;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFirstFlight() {
    return firstFlight;
  }
  public void setFirstFlight(String firstFlight) {
    this.firstFlight = firstFlight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AstronautNormal astronautNormal = (AstronautNormal) o;
    return (Objects.equals(this.id, astronautNormal.id)) &&
        (Objects.equals(this.url, astronautNormal.url)) &&
        (Objects.equals(this.name, astronautNormal.name)) &&
        (Objects.equals(this.status, astronautNormal.status)) &&
        (Objects.equals(this.type, astronautNormal.type)) &&
        (Objects.equals(this.dateOfBirth, astronautNormal.dateOfBirth)) &&
        (Objects.equals(this.dateOfDeath, astronautNormal.dateOfDeath)) &&
        (Objects.equals(this.nationality, astronautNormal.nationality)) &&
        (Objects.equals(this.bio, astronautNormal.bio)) &&
        (Objects.equals(this.twitter, astronautNormal.twitter)) &&
        (Objects.equals(this.instagram, astronautNormal.instagram)) &&
        (Objects.equals(this.wiki, astronautNormal.wiki)) &&
        (Objects.equals(this.agency, astronautNormal.agency)) &&
        (Objects.equals(this.profileImage, astronautNormal.profileImage)) &&
        (Objects.equals(this.profileImageThumbnail, astronautNormal.profileImageThumbnail)) &&
        (Objects.equals(this.lastFlight, astronautNormal.lastFlight)) &&
        (Objects.equals(this.firstFlight, astronautNormal.firstFlight));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.dateOfBirth == null ? 0: this.dateOfBirth.hashCode());
    result = 31 * result + (this.dateOfDeath == null ? 0: this.dateOfDeath.hashCode());
    result = 31 * result + (this.nationality == null ? 0: this.nationality.hashCode());
    result = 31 * result + (this.bio == null ? 0: this.bio.hashCode());
    result = 31 * result + (this.twitter == null ? 0: this.twitter.hashCode());
    result = 31 * result + (this.instagram == null ? 0: this.instagram.hashCode());
    result = 31 * result + (this.wiki == null ? 0: this.wiki.hashCode());
    result = 31 * result + (this.agency == null ? 0: this.agency.hashCode());
    result = 31 * result + (this.profileImage == null ? 0: this.profileImage.hashCode());
    result = 31 * result + (this.profileImageThumbnail == null ? 0: this.profileImageThumbnail.hashCode());
    result = 31 * result + (this.lastFlight == null ? 0: this.lastFlight.hashCode());
    result = 31 * result + (this.firstFlight == null ? 0: this.firstFlight.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class AstronautNormal {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  status: " + status + "\n" +
            "  type: " + type + "\n" +
            "  dateOfBirth: " + dateOfBirth + "\n" +
            "  dateOfDeath: " + dateOfDeath + "\n" +
            "  nationality: " + nationality + "\n" +
            "  bio: " + bio + "\n" +
            "  twitter: " + twitter + "\n" +
            "  instagram: " + instagram + "\n" +
            "  wiki: " + wiki + "\n" +
            "  agency: " + agency + "\n" +
            "  profileImage: " + profileImage + "\n" +
            "  profileImageThumbnail: " + profileImageThumbnail + "\n" +
            "  lastFlight: " + lastFlight + "\n" +
            "  firstFlight: " + firstFlight + "\n" +
            "}\n";
  }
}
