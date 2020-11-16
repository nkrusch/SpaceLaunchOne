package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SpacecraftDetailed {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("serial_number")
  private String serialNumber = null;
  @SerializedName("status")
  private SpacecraftStatus status = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("spacecraft_config")
  private SpacecraftConfigurationDetail spacecraftConfig = null;
  @SerializedName("flights")
  private List<SpacecraftFlight> flights = null;

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
  public String getSerialNumber() {
    return serialNumber;
  }
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   **/
  @ApiModelProperty()
  public SpacecraftStatus getStatus() {
    return status;
  }
  public void setStatus(SpacecraftStatus status) {
    this.status = status;
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
  public SpacecraftConfigurationDetail getSpacecraftConfig() {
    return spacecraftConfig;
  }
  public void setSpacecraftConfig(SpacecraftConfigurationDetail spacecraftConfig) {
    this.spacecraftConfig = spacecraftConfig;
  }

  /**
   **/
  @ApiModelProperty()
  public List<SpacecraftFlight> getFlights() {
    return flights;
  }
  public void setFlights(List<SpacecraftFlight> flights) {
    this.flights = flights;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpacecraftDetailed spacecraftDetailed = (SpacecraftDetailed) o;
    return (Objects.equals(this.id, spacecraftDetailed.id)) &&
        (Objects.equals(this.url, spacecraftDetailed.url)) &&
        (Objects.equals(this.name, spacecraftDetailed.name)) &&
        (Objects.equals(this.serialNumber, spacecraftDetailed.serialNumber)) &&
        (Objects.equals(this.status, spacecraftDetailed.status)) &&
        (Objects.equals(this.description, spacecraftDetailed.description)) &&
        (Objects.equals(this.spacecraftConfig, spacecraftDetailed.spacecraftConfig)) &&
        (Objects.equals(this.flights, spacecraftDetailed.flights));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.serialNumber == null ? 0: this.serialNumber.hashCode());
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.spacecraftConfig == null ? 0: this.spacecraftConfig.hashCode());
    result = 31 * result + (this.flights == null ? 0: this.flights.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class SpacecraftDetailed {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  serialNumber: " + serialNumber + "\n" +
            "  status: " + status + "\n" +
            "  description: " + description + "\n" +
            "  spacecraftConfig: " + spacecraftConfig + "\n" +
            "  flights: " + flights + "\n" +
            "}\n";
  }
}
