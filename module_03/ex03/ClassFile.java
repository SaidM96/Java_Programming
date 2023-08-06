package ex03;

public class ClassFile{
    private String url;
    private Status status;

    public ClassFile(String url, Status status){
        this.status = status;
        this.url = url;
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
}