package com.jv_lp_01;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.nio.file.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){
//            public boolean accept(Path path) throws IOException{
//                return (Files.isRegularFile(path));
//            }
//        };

        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);


        //Path directy = FileSystems.getDefault().getPath("FileTree\\Dir2");
        /* USE STRONG BUILDER */
        Path directy = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directy, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);


        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println(store.name());
            System.out.println(store);
        }

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();

        for (Path path : rootPaths) {
            System.out.println(path);
        }

        System.out.println("------Walking tree for Dir2------");
        Path dir2path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /* copy tree  */
//             System.out.println("=== Copy Dir2 to Dir4/Dir2copy");
//        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
//        try{
//            Files.walkFileTree(dir2path,new CopyFiles(dir2path,copyPath));
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

        File file = new File(".\\FileTree\\file.txt");
        Path covertedPath = file.toPath();
        System.out.println("convertedPath = " + covertedPath);

        File parent = new File(".\\FileTree");
        File resolveFile = new File(parent, ".\\Dir1\\file1.txt");
        System.out.println(resolveFile.toPath());
        resolveFile = new File(".\\FileTree","Dir1\\file1.txt");
        System.out.println(resolveFile.toPath());

        Path parentPath = Paths.get(".\\FileTree");
        Path chilRelativePath = Paths.get("Dir1\\file.txt");
        System.out.println(parentPath.resolve(chilRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("----- print dir1 contents using list() -----");
        File dir2File = new File(workingDirectory,"\\FileTree\\Dir2");
        String[] dir2Contencts = dir2File.list();
        for(int i = 0; i < dir2Contencts.length; i++){
            System.out.println("i = " + i + ": " + dir2Contencts[i]);
        }

        System.out.println("----- print dir1 contents using listFiles() -----");
        File[] dir2Files = dir2File.listFiles();
        for(int i = 0; i < dir2Files.length; i++){
            System.out.println("i = " + i + ": " + dir2Files[i].getName());
        }



    }
}
