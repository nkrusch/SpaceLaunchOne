package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AgencyList {

    @SerializedName("id")
    private Integer id = null;
    @SerializedName("url")
    private String url = null;
    @SerializedName("name")
    private String name = null;
    @SerializedName("abbrev")
    private String abbrev = null;

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
    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AgencyList agencyList = (AgencyList) o;
        return (Objects.equals(this.id, agencyList.id)) &&
                (Objects.equals(this.url, agencyList.url)) &&
                (Objects.equals(this.name, agencyList.name)) &&
                (Objects.equals(this.abbrev, agencyList.abbrev));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        result = 31 * result + (this.url == null ? 0 : this.url.hashCode());
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        result = 31 * result + (this.abbrev == null ? 0 : this.abbrev.hashCode());
        return result;
    }

    @Override
    public String toString() {

        return "class AgencyList {\n" +
                "  id: " + id + "\n" +
                "  url: " + url + "\n" +
                "  name: " + name + "\n" +
                "  abbrev: " + abbrev + "\n" +
                "}\n";
    }
}
