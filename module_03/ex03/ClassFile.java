package ex03;

public class ClassFile{
    private String url;
    private Status status;
    private int id;

    public ClassFile(int id, String url, Status status){
        this.status = status;
        this.url = url;
        this.id = id;
    } 

    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
}