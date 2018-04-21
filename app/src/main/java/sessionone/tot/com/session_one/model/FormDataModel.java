package sessionone.tot.com.session_one.model;

/**
 * Created by theReza on 1/11/2018.
 */

public class FormDataModel {
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String institute;


    public FormDataModel(String name, String gender, String phone, String email, String institute) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.institute = institute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }
}
