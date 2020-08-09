package com.cqupt.bcirs.domain;

/**
 * 记录传入的图像
 * @author ggtms
 * @ 2020-04-14 10:22
 */
public class Picture {

    private int id;


    private String path;

    private Picture(){}


    //private static Picture picture = null;

    /*public static Picture getPicture(){
        if(picture == null){
            synchronized (Picture.class){
                if(picture == null){
                    picture = new Picture();
                }
            }
        }
        return picture;
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }

}
