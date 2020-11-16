package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class Agency {

    @SerializedName("id")
    private Integer id = null;
    @SerializedName("url")
    private String url = null;
    @SerializedName("name")
    private String name = null;
    @SerializedName("featured")
    private Boolean featured = null;
    @SerializedName("type")
    private String type = null;
    @SerializedName("country_code")
    private String countryCode = null;
    @SerializedName("abbrev")
    private String abbrev = null;
    @SerializedName("description")
    private String description = null;
    @SerializedName("administrator")
    private String administrator = null;
    @SerializedName("founding_year")
    private String foundingYear = null;
    @SerializedName("launchers")
    private String launchers = null;
    @SerializedName("spacecraft")
    private String spacecraft = null;
    @SerializedName("parent")
    private String parent = null;
    @SerializedName("image_url")
    private String imageUrl = null;

    /**
     *
     **/
    @ApiModelProperty()
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     **/
    @ApiModelProperty(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(String foundingYear) {
        this.foundingYear = foundingYear;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getLaunchers() {
        return launchers;
    }

    public void setLaunchers(String launchers) {
        this.launchers = launchers;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(String spacecraft) {
        this.spacecraft = spacecraft;
    }

    /**
     *
     **/
    @ApiModelProperty()
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     *
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
        Agency agency = (Agency) o;
        return (Objects.equals(this.id, agency.id)) &&
                (Objects.equals(this.url, agency.url)) &&
                (Objects.equals(this.name, agency.name)) &&
                (Objects.equals(this.featured, agency.featured)) &&
                (Objects.equals(this.type, agency.type)) &&
                (Objects.equals(this.countryCode, agency.countryCode)) &&
                (Objects.equals(this.abbrev, agency.abbrev)) &&
                (Objects.equals(this.description, agency.description)) &&
                (Objects.equals(this.administrator, agency.administrator)) &&
                (Objects.equals(this.foundingYear, agency.foundingYear)) &&
                (Objects.equals(this.launchers, agency.launchers)) &&
                (Objects.equals(this.spacecraft, agency.spacecraft)) &&
                (Objects.equals(this.parent, agency.parent)) &&
                (Objects.equals(this.imageUrl, agency.imageUrl));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        result = 31 * result + (this.url == null ? 0 : this.url.hashCode());
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        result = 31 * result + (this.featured == null ? 0 : this.featured.hashCode());
        result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
        result = 31 * result + (this.countryCode == null ? 0 : this.countryCode.hashCode());
        result = 31 * result + (this.abbrev == null ? 0 : this.abbrev.hashCode());
        result = 31 * result + (this.description == null ? 0 : this.description.hashCode());
        result = 31 * result + (this.administrator == null ? 0 : this.administrator.hashCode());
        result = 31 * result + (this.foundingYear == null ? 0 : this.foundingYear.hashCode());
        result = 31 * result + (this.launchers == null ? 0 : this.launchers.hashCode());
        result = 31 * result + (this.spacecraft == null ? 0 : this.spacecraft.hashCode());
        result = 31 * result + (this.parent == null ? 0 : this.parent.hashCode());
        result = 31 * result + (this.imageUrl == null ? 0 : this.imageUrl.hashCode());
        return result;
    }

    @Override
    public String toString() {

        return "class Agency {\n" +
                "  id: " + id + "\n" +
                "  url: " + url + "\n" +
                "  name: " + name + "\n" +
                "  featured: " + featured + "\n" +
                "  type: " + type + "\n" +
                "  countryCode: " + countryCode + "\n" +
                "  abbrev: " + abbrev + "\n" +
                "  description: " + description + "\n" +
                "  administrator: " + administrator + "\n" +
                "  foundingYear: " + foundingYear + "\n" +
                "  launchers: " + launchers + "\n" +
                "  spacecraft: " + spacecraft + "\n" +
                "  parent: " + parent + "\n" +
                "  imageUrl: " + imageUrl + "\n" +
                "}\n";
    }
}
