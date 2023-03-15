
package ch03;

import java.util.LinkedHashMap;
import java.util.Map;


public class User {

    public Integer id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
