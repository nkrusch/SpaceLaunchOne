package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Landing {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("attempt")
  private Boolean attempt = null;
  @SerializedName("success")
  private Boolean success = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("location")
  private LandingLocation location = null;
  @SerializedName("type")
  private LandingType type = null;

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
  public Boolean getAttempt() {
    return attempt;
  }
  public void setAttempt(Boolean attempt) {
    this.attempt = attempt;
  }

  /**
   **/
  @ApiModelProperty()
  public Boolean getSuccess() {
    return success;
  }
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  /**
   **/
  @ApiModelProperty()
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty()
  public LandingLocation getLocation() {
    return location;
  }
  public void setLocation(LandingLocation location) {
    this.location = location;
  }

  /**
   **/
  @ApiModelProperty()
  public LandingType getType() {
    return type;
  }
  public void setType(LandingType type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Landing landing = (Landing) o;
    return (Objects.equals(this.id, landing.id)) &&
        (Objects.equals(this.attempt, landing.attempt)) &&
        (Objects.equals(this.success, landing.success)) &&
        (Objects.equals(this.description, landing.description)) &&
        (Objects.equals(this.location, landing.location)) &&
        (Objects.equals(this.type, landing.type));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.attempt == null ? 0: this.attempt.hashCode());
    result = 31 * result + (this.success == null ? 0: this.success.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.location == null ? 0: this.location.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class Landing {\n" +
            "  id: " + id + "\n" +
            "  attempt: " + attempt + "\n" +
            "  success: " + success + "\n" +
            "  description: " + description + "\n" +
            "  location: " + location + "\n" +
            "  type: " + type + "\n" +
            "}\n";
  }
}
