package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Events {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("url")
  private String url = null;
  @SerializedName("slug")
  private String slug = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("type")
  private EventType type = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("location")
  private String location = null;
  @SerializedName("news_url")
  private String newsUrl = null;
  @SerializedName("video_url")
  private String videoUrl = null;
  @SerializedName("feature_image")
  private String featureImage = null;
  @SerializedName("date")
  private Date date = null;
  @SerializedName("launches")
  private List<LaunchSerializerCommon> launches = null;
  @SerializedName("expeditions")
  private List<Expedition> expeditions = null;
  @SerializedName("spacestations")
  private List<SpaceStationSerializerForCommon> spacestations = null;
  @SerializedName("program")
  private List<Program> program = null;

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
  public String getSlug() {
    return slug;
  }
  public void setSlug(String slug) {
    this.slug = slug;
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
  public EventType getType() {
    return type;
  }
  public void setType(EventType type) {
    this.type = type;
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
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   **/
  @ApiModelProperty()
  public String getNewsUrl() {
    return newsUrl;
  }
  public void setNewsUrl(String newsUrl) {
    this.newsUrl = newsUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getVideoUrl() {
    return videoUrl;
  }
  public void setVideoUrl(String videoUrl) {
    this.videoUrl = videoUrl;
  }

  /**
   **/
  @ApiModelProperty()
  public String getFeatureImage() {
    return featureImage;
  }
  public void setFeatureImage(String featureImage) {
    this.featureImage = featureImage;
  }

  /**
   **/
  @ApiModelProperty()
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public List<LaunchSerializerCommon> getLaunches() {
    return launches;
  }
  public void setLaunches(List<LaunchSerializerCommon> launches) {
    this.launches = launches;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public List<Expedition> getExpeditions() {
    return expeditions;
  }
  public void setExpeditions(List<Expedition> expeditions) {
    this.expeditions = expeditions;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public List<SpaceStationSerializerForCommon> getSpacestations() {
    return spacestations;
  }
  public void setSpacestations(List<SpaceStationSerializerForCommon> spacestations) {
    this.spacestations = spacestations;
  }

  /**
   **/
  @ApiModelProperty()
  public List<Program> getProgram() {
    return program;
  }
  public void setProgram(List<Program> program) {
    this.program = program;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Events events = (Events) o;
    return (Objects.equals(this.id, events.id)) &&
        (Objects.equals(this.url, events.url)) &&
        (Objects.equals(this.slug, events.slug)) &&
        (Objects.equals(this.name, events.name)) &&
        (Objects.equals(this.type, events.type)) &&
        (Objects.equals(this.description, events.description)) &&
        (Objects.equals(this.location, events.location)) &&
        (Objects.equals(this.newsUrl, events.newsUrl)) &&
        (Objects.equals(this.videoUrl, events.videoUrl)) &&
        (Objects.equals(this.featureImage, events.featureImage)) &&
        (Objects.equals(this.date, events.date)) &&
        (Objects.equals(this.launches, events.launches)) &&
        (Objects.equals(this.expeditions, events.expeditions)) &&
        (Objects.equals(this.spacestations, events.spacestations)) &&
        (Objects.equals(this.program, events.program));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    result = 31 * result + (this.slug == null ? 0: this.slug.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.location == null ? 0: this.location.hashCode());
    result = 31 * result + (this.newsUrl == null ? 0: this.newsUrl.hashCode());
    result = 31 * result + (this.videoUrl == null ? 0: this.videoUrl.hashCode());
    result = 31 * result + (this.featureImage == null ? 0: this.featureImage.hashCode());
    result = 31 * result + (this.date == null ? 0: this.date.hashCode());
    result = 31 * result + (this.launches == null ? 0: this.launches.hashCode());
    result = 31 * result + (this.expeditions == null ? 0: this.expeditions.hashCode());
    result = 31 * result + (this.spacestations == null ? 0: this.spacestations.hashCode());
    result = 31 * result + (this.program == null ? 0: this.program.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class Events {\n" +
            "  id: " + id + "\n" +
            "  url: " + url + "\n" +
            "  slug: " + slug + "\n" +
            "  name: " + name + "\n" +
            "  type: " + type + "\n" +
            "  description: " + description + "\n" +
            "  location: " + location + "\n" +
            "  newsUrl: " + newsUrl + "\n" +
            "  videoUrl: " + videoUrl + "\n" +
            "  featureImage: " + featureImage + "\n" +
            "  date: " + date + "\n" +
            "  launches: " + launches + "\n" +
            "  expeditions: " + expeditions + "\n" +
            "  spacestations: " + spacestations + "\n" +
            "  program: " + program + "\n" +
            "}\n";
  }
}
