package umn.ac.id.uas_projek;

public class Member
{
    private String UserID, Nama, ImageURL;

    public Member()
    {

    }

    public Member(String UserID, String Nama, String ImageURL)
    {
        this.UserID = UserID;
        this.Nama = Nama;
        this.ImageURL = ImageURL;
    }

    public void setUserID(String userID)
    {
        UserID = userID;
    }

    public void setNama(String nama)
    {
        Nama = nama;
    }

    public void setImageURL(String imageURL)
    {
        ImageURL = imageURL;
    }

    public String getUserID()
    {
        return UserID;
    }

    public String getNama()
    {
        return Nama;
    }

    public String getImageURL()
    {
        return ImageURL;
    }
}
