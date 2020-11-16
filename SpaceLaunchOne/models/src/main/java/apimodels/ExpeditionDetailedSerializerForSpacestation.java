package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class ExpeditionDetailedSerializerForSpacestation {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("start")
  private Date start = null;
  @SerializedName("end")
  private Date end = null;
  @SerializedName("crew")
  private List<AstronautFlightForExpedition> crew = null;

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
  @ApiModelProperty(required = true)
  public Date getStart() {
    return start;
  }
  public void setStart(Date start) {
    this.start = start;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getEnd() {
    return end;
  }
  public void setEnd(Date end) {
    this.end = end;
  }

  /**
   **/
  @ApiModelProperty()
  public List<AstronautFlightForExpedition> getCrew() {
    return crew;
  }
  public void setCrew(List<AstronautFlightForExpedition> crew) {
    this.crew = crew;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExpeditionDetailedSerializerForSpacestation expeditionDetailedSerializerForSpacestation = (ExpeditionDetailedSerializerForSpacestation) o;
    return (Objects.equals(this.id, expeditionDetailedSerializerForSpacestation.id)) &&
        (Objects.equals(this.url, expeditionDetailedSerializerForSpacestation.url)) &&
        (Objects.equals(this.name, expeditionDetailedSerializerForSpacestation.name)) &&
        (Objects.equals(this.start, expeditionDetailedSerializerForSpacestation.start)) &&
        (Objects.equals(this.end, expeditionDetailedSerializerForSpacestation.end)) &&
        (Objects.equals(this.crew, expeditionDetailedSerializerForSpacestation.crew));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.start == null ? 0: this.start.hashCode());
    result = 31 * result + (this.end == null ? 0: this.end.hashCode());
    result = 31 * result + (this.crew == null ? 0: this.crew.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class ExpeditionDetailedSerializerForSpacestation {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  name: " + name + "\n" +
            "  start: " + start + "\n" +
            "  end: " + end + "\n" +
            "  crew: " + crew + "\n" +
            "}\n";
  }
}
