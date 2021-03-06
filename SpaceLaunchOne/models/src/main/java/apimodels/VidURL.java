package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class VidURL {
  
  @SerializedName("priority")
  private Integer priority = null;
  @SerializedName("title")
  private String title = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("feature_image")
  private String featureImage = null;
  @SerializedName("url")
  private String url = null;

  /**
   * minimum: -2147483648
   * maximum: 2147483647
   **/
  @ApiModelProperty()
  public Integer getPriority() {
    return priority;
  }
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  /**
   **/
  @ApiModelProperty()
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
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
  public String getFeatureImage() {
    return featureImage;
  }
  public void setFeatureImage(String featureImage) {
    this.featureImage = featureImage;
  }

  /**
   **/
  @ApiModelProperty(required = true)
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VidURL vidURL = (VidURL) o;
    return (Objects.equals(this.priority, vidURL.priority)) &&
        (Objects.equals(this.title, vidURL.title)) &&
        (Objects.equals(this.description, vidURL.description)) &&
        (Objects.equals(this.featureImage, vidURL.featureImage)) &&
        (Objects.equals(this.url, vidURL.url));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.priority == null ? 0: this.priority.hashCode());
    result = 31 * result + (this.title == null ? 0: this.title.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.featureImage == null ? 0: this.featureImage.hashCode());
    result = 31 * result + (this.url == null ? 0: this.url.hashCode());
    return result;
  }

  @Override
  public String toString()  {

    return "class VidURL {\n" +
            "  priority: " + priority + "\n" +
            "  title: " + title + "\n" +
            "  description: " + description + "\n" +
            "  featureImage: " + featureImage + "\n" +
            "  url: " + url + "\n" +
            "}\n";
  }
}
