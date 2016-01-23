package yqj.kafka;

/**
 * Created by yaoqijun.
 * Date:2015-05-15
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class Keyword {
    private String id;

    private String user;

    private String password;

    private String date;

    public String getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
