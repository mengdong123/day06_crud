package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 数据库备份功能
 */

@WebServlet("/mng/program")
public class DataBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String state = req.getParameter("state");
        String username = "root";
        String password = "root";
        String database_name = "wd";
        String back_path = "D:/";
//        String back_name = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".sql";
        String back_name = "数据库备份.sql";
//        if () {
//            back_name =
//        }

        if (state.equals("backup")) {
            try {
                DataBaseServlet.dbBackUp("root", "root", "wd", "D:/", back_name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("msg3", "数据库已备份。");
            req.getRequestDispatcher("/mng/data/sql.jsp").forward(req,resp);


        }


        if (state.equals("restore")) {
            DataBaseServlet.dbRestore("root", "root", "wd", "D://数据库备份.sql");
            req.setAttribute("msg2", "数据库已还原。");
            req.getRequestDispatcher("/mng/data/sql.jsp").forward(req,resp);
        }
    }

    /**
     * 备份数据库db
     *
     */
    public static void dbBackUp(String root, String pwd, String dbName, String backPath, String backName) throws Exception {
        String pathSql = backPath + backName;
        File fileSql = new File(pathSql);
        //创建备份sql文件
        if (!fileSql.exists()) {
            fileSql.createNewFile();
        }
        //mysqldump -hlocalhost -uroot -p123456 db > /home/back.sql
        StringBuffer sb = new StringBuffer();
        sb.append("mysqldump");
        sb.append(" -hlocalhost");
        sb.append(" -u" + root);
        sb.append(" -p" + pwd);
        sb.append(" " + dbName + " >");
        sb.append(pathSql);
        System.out.println("cmd命令为：" + sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始备份：" + dbName);
        Process process = runtime.exec("cmd /c" + sb.toString());
        System.out.println("数据库备份成功!");
    }

    /**
     * 恢复数据库
     *
     * @param root
     * @param pwd
     * @param dbName
     * @param filePath mysql -hlocalhost -uroot -p123456 db < /home/back.sql
     */
    public static void dbRestore(String root, String pwd, String dbName, String filePath) {
        StringBuilder sb = new StringBuilder();
        sb.append("mysql");
        sb.append(" -hlocalhost");
        sb.append(" -u" + root);
        sb.append(" -p" + pwd);
        sb.append(" " + dbName + " <");
        sb.append(filePath);
        System.out.println("cmd命令为：" + sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始还原数据");
        try {
            Process process = runtime.exec("cmd /c" + sb.toString());
            InputStream is = process.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is, "utf8"));
            String line = null;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("已成功还原！");
    }
}