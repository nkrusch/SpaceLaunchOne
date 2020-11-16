package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AstronautDetailedSerializerNoFlights {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("type")
  private AstronautType type = null;
  @SerializedName("status")
  private AstronautStatus status = null;
  @SerializedName("agency")
  private AgencySerializerMini agency = null;
  @SerializedName("date_of_birth")
  private Date dateOfBirth = null;
  @SerializedName("date_of_death")
  private Date dateOfDeath = null;
  @SerializedName("nationality")
  private String nationality = null;
  @SerializedName("twitter")
  private String twitter = null;
  @SerializedName("instagram")
  private String instagram = null;
  @SerializedName("bio")
  private String bio = null;
  @SerializedName("profile_image")
  private String profileImage = null;
  @SerializedName("wiki")
  private String wiki = null;
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
  public AstronautType getType() {
    return type;
  }
  public void setType(AstronautType type) {
    this.type = type;
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
  public String getProfileImage() {
    return profileImage;
  }
  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
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
    AstronautDetailedSerializerNoFlights astronautDetailedSerializerNoFlights = (AstronautDetailedSerializerNoFlights) o;
    return (Objects.equals(this.id, astronautDetailedSerializerNoFlights.id)) &&
        (Objects.equals(this.url, astronautDetailedSerializerNoFlights.url)) &&
        (Objects.equals(this.name, astronautDetailedSerializerNoFlights.name)) &&
        (Objects.equals(this.type, astronautDetailedSerializerNoFlights.type)) &&
        (Objects.equals(this.status, astronautDetailedSerializerNoFlights.status)) &&
        (Objects.equals(this.agency, astronautDetailedSerializerNoFlights.agency)) &&
        (Objects.equals(this.dateOfBirth, astronautDetailedSerializerNoFlights.dateOfBirth)) &&
        (Objects.equals(this.dateOfDeath, astronautDetailedSerializerNoFlights.dateOfDeath)) &&
        (Objects.equals(this.nationality, astronautDetailedSerializerNoFlights.nationality)) &&
        (Objects.equals(this.twitter, astronautDetailedSerializerNoFlights.twitter)) &&
        (Objects.equals(this.instagram, astronautDetailedSerializerNoFlights.instagram)) &&
        (Objects.equals(this.bio, astronautDetailedSerializerNoFlights.bio)) &&
        (Objects.equals(this.profileImage, astronautDetailedSerializerNoFlights.profileImage)) &&
        (Objects.equals(this.wiki, astronautDetailedSerializerNoFlights.wiki)) &&
        (Objects.equals(this.lastFlight, astronautDetailedSerializerNoFlights.lastFlight)) &&
        (Objects.equals(this.firstFlight, astronautDetailedSerializerNoFlights.firstFlight));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.agency == null ? 0: this.agency.hashCode());
    result = 31 * result + (this.dateOfBirth == null ? 0: this.dateOfBirth.hashCode());
    result = 31 * result + (this.dateOfDeath == null ? 0: this.dateOfDeath.hashCode());
    result = 31 * result + (this.nationality == null ? 0: this.nationality.hashCode());
    result = 31 * result + (this.twitter == null ? 0: this.twitter.hashCode());
    result = 31 * result + (this.instagram == null ? 0: this.instagram.hashCode());
    result = 31 * result + (this.bio == null ? 0: this.bio.hashCode());
    result = 31 * result + (this.profileImage == null ? 0: this.profileImage.hashCode());
    result = 31 * result + (this.wiki == null ? 0: this.wiki.hashCode());
    result = 31 * result + (this.lastFlight == null ? 0: this.lastFlight.hashCode());
    result = 31 * result + (this.firstFlight == null ? 0: this.firstFlight.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class AstronautDetailedSerializerNoFlights {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  type: " + type + "\n" +
            "  status: " + status + "\n" +
            "  agency: " + agency + "\n" +
            "  dateOfBirth: " + dateOfBirth + "\n" +
            "  dateOfDeath: " + dateOfDeath + "\n" +
            "  nationality: " + nationality + "\n" +
            "  twitter: " + twitter + "\n" +
            "  instagram: " + instagram + "\n" +
            "  bio: " + bio + "\n" +
            "  profileImage: " + profileImage + "\n" +
            "  wiki: " + wiki + "\n" +
            "  lastFlight: " + lastFlight + "\n" +
            "  firstFlight: " + firstFlight + "\n" +
            "}\n";
  }
}
