package com.ck.io.other;

import java.io.FilePermission;
import java.security.PermissionCollection;

/**
 * FilePermission类包含与目录或文件相关的权限。所有权限都与路径相关。路径可以有两种类型：
 *
 * D:\\IO\\-：表示该权限与所有子目录和文件都递归关联。
 * D:\\IO\\*：表示该权限与该目录中的所有目录和文件（子目录除外）相关联。
 */
public class FilePermissionDemo {

    public static void main(String[] args) {
        String str = "C:\\Users\\pc\\Desktop\\test\\test.txt";
        FilePermission filePermission = new FilePermission("C:\\Users\\pc\\Desktop\\test\\-","readOnly");
        PermissionCollection permissionCollection = filePermission.newPermissionCollection();
        permissionCollection.add(filePermission);
        FilePermission filePermission1 = new FilePermission(str,"write");
        permissionCollection.add(filePermission1);
        if (permissionCollection.implies(new FilePermission(str,"read,write"))) {
            System.out.println("Read,Write permission is granted for the path" + str);
        } else {
            System.out.println("No Read,Write permission is granted for the path" + str);
        }
    }
}
