package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AstronautFlight {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("role")
  private String role = null;
  @SerializedName("astronaut")
  private AstronautDetailedSerializerNoFlights astronaut = null;

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
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }

  /**
   **/
  @ApiModelProperty()
  public AstronautDetailedSerializerNoFlights getAstronaut() {
    return astronaut;
  }
  public void setAstronaut(AstronautDetailedSerializerNoFlights astronaut) {
    this.astronaut = astronaut;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AstronautFlight astronautFlight = (AstronautFlight) o;
    return (Objects.equals(this.id, astronautFlight.id)) &&
        (Objects.equals(this.role, astronautFlight.role)) &&
        (Objects.equals(this.astronaut, astronautFlight.astronaut));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.role == null ? 0: this.role.hashCode());
    result = 31 * result + (this.astronaut == null ? 0: this.astronaut.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class AstronautFlight {\n" +
            "  id: " + id + "\n" +
            "  role: " + role + "\n" +
            "  astronaut: " + astronaut + "\n" +
            "}\n";
  }
}
