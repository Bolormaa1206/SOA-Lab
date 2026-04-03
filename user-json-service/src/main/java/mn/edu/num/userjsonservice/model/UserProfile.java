package mn.edu.num.userjsonservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserProfile {
    @Id
    private String id;
    private String name;
    private String email;
    private String bio;
    private String phone;
    private String profileImageUrl;

    public UserProfile() {}

    public UserProfile(String id, String name, String email, String bio, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.phone = phone;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getProfileImageUrl() { return profileImageUrl; }
    public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }
}
