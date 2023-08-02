package ex02;
import java.util.Scanner;
import java.io.File;

public class FileManager{
    private String workdir;
    private int sizeFolder;
    public FileManager(){
        this.workdir = new String("");
        this.sizeFolder = 0;
    }

    private void setWorkdir(String path){
        this.workdir = path;
        System.out.println(path);
    }

    private String getWorkdir(){
        return this.workdir;
    }
    
    private void sizeFolder(String pathFolder){
        File folder = new File(pathFolder);
        if (folder.exists() && folder.isDirectory()){
            File[] files = folder.listFiles();
            for(File file: files){
                if (!file.isDirectory() && file.isFile()){
                    long fileSizeBytes = file.length();
                    int fileSizeKB = (int) fileSizeBytes / 1024;
                    this.sizeFolder += fileSizeKB;
                }
                else if (file.isDirectory()){
                    String newPath = pathFolder + "/" +file.getName();
                    this.sizeFolder(newPath);
                }
                else
                    return ;
            }
        }
    }

    private void ls(){
        File folder = new File(this.getWorkdir());
        File[] files = folder.listFiles();
        for(File file: files){
            this.sizeFolder = 0;
            if (file.isFile() && !file.isDirectory()){
                long fileSizeBytes = file.length();
                int fileSizeKB = (int) fileSizeBytes / 1024;
                System.out.println(file.getName() + " " + fileSizeKB + " KB"); 
            }else{
                this.sizeFolder(file.getParent() + "/" + file.getName());
                int fileSizeKB = this.sizeFolder;
                System.out.println(file.getName() + " " + fileSizeKB + " KB");
            }
        }
    }

    private void cd(String nameFolder){
        String newPath = this.getWorkdir() + "/" + nameFolder;
        File folder = new File(newPath);
        if (!folder.exists() || !folder.isDirectory()){
            System.out.println("cd: no such file or directory: " + newPath);
            return ;
        }
        this.setWorkdir(newPath);
    }

    private void mv(String what, String where){
        String newWherePath = new String("");
        File dir = new File(this.getWorkdir());
        if (where.contains("..")){
            newWherePath = where.replace("..", dir.getParent());
            System.out.println(newWherePath);
        }
        else
            newWherePath = where;
        File Whatfile = new File(this.getWorkdir(),what);
        // handle moving file or folder;
        File Wherefile = new File(newWherePath);
        if (Wherefile.exists() && Wherefile.isDirectory()){
            File newDest = new File(newWherePath, what);
            Whatfile.renameTo(newDest);
        }
        else{ // handle renaming folder or file;
            File Wherefile1 = new File(this.getWorkdir(), newWherePath);
            Whatfile.renameTo(Wherefile1);
        }
    }

    public void startProgram(String path){
        this.setWorkdir(path);
        Scanner in = new Scanner(System.in);
        String line = new String("");
        while(true){
            line = "";
            line = in.nextLine();
            String[] params = line.split(" ");
            if (params.length == 1 && params[0].equals("ls")){
                this.ls();
            }
            else if (params.length == 2 && params[0].equals("cd")){
                this.cd(params[1]);
            }
            else if (params.length == 3 && params[0].equals("mv")){
                this.mv(params[1], params[2]);
            }
            else if (params.length == 1 && params[0].equals("exit")){
                System.exit(0);
            }
            else
                System.out.println("Invalid command!");
        }
    }
} 
